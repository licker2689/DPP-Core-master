package com.darksoldier1404.dppc.api.benta;

import com.darksoldier1404.dppc.api.benta.etc.EvtCulturelandFail;
import com.darksoldier1404.dppc.api.benta.etc.EvtCulturelandSuccess;
import com.darksoldier1404.dppc.api.benta.etc.EvtDepositSuccess;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class BentaAPI {
    private final String appKey;
    private final JavaPlugin plugin;
    private String title;
    private String prefix;

    public BentaAPI(String appKey, JavaPlugin plugin) {
        this.appKey = appKey;
        this.plugin = plugin;
        registerScheduler();
    }

    public BentaAPI(String appKey, JavaPlugin plugin, String title) {
        this.appKey = appKey;
        this.plugin = plugin;
        this.title = title;
        registerScheduler();
    }

    public BentaAPI(String appKey, JavaPlugin plugin, String title, String prefix) {
        this.appKey = appKey;
        this.plugin = plugin;
        this.title = title;
        this.prefix = prefix;
        registerScheduler();
    }

    public String getAppKey() {
        return appKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    void registerScheduler() {
        plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin, new BentaScheduler(), 10 * 20, 20 * 5);
    }

    public void sendPaymentURL(Player p) {
        Bukkit.getServer().getScheduler().runTaskAsynchronously(plugin, () -> {
            p.sendMessage(prefix + "결제 페이지를 생성 중입니다. 잠시만 기다려 주세요.");
            JSONObject response = generateBentaPayment("{ \"token\" : \"" + appKey + "\",  \"title\" : \"" + title + "\", \"identifier\" : \"" + p.getUniqueId() + "\" }");
            if (response == null) {
                p.sendMessage(prefix + "결제 페이지 생성 중에 오류가 발생하였습니다.");
            } else {
                if (response.get("error") != null) {
                    p.sendMessage(prefix + "오류 코드 : " + response.get("error"));
                    p.sendMessage(prefix + "오류 메세지 : " + response.get("error_msg"));
                } else {
                    p.sendMessage(prefix + "아래의 링크를 클릭하여 결제를 진행하여 주세요.");
                    p.sendMessage(prefix + "https://benta.im/checkout/" + response.get("payToken"));
                }
            }
        });
    }

    @Nullable
    private JSONObject generateBentaPayment(String jsonMessage) {
        try {
            URL url = new URL("https://api.benta.im/payments");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(5000); //서버에 연결되는 Timeout 시간 설정
            con.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정
            con.setRequestMethod("POST"); //어떤 요청으로 보낼 것인지?

            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Content-type", "application/json");

            con.setDoInput(true);
            con.setDoOutput(true);
            con.setUseCaches(false);
            con.setDefaultUseCaches(false);

            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            wr.write(jsonMessage);
            wr.flush();

            StringBuilder sb = new StringBuilder();
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "utf-8"));
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                br.close();
                JSONParser jsonParser = new JSONParser();
                JSONObject responseData = (JSONObject) jsonParser.parse(sb.toString());
                return responseData;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    class BentaScheduler implements Runnable {
        @Override
        public void run() {
            JSONObject response = getPayment("?token=" + appKey);
            if (response == null) {
                plugin.getLogger().info(prefix + "Benta API 서버와의 연결에 실패하여 결제 정보를 가져오지 못 하였습니다.");
            } else if (response.get("error") == null) {
                JSONObject payment = (JSONObject) response.get("payment");
                String identifier = (String) response.get("identifier");
                long paidAmount = (long) payment.get("paidAmount");

                String PAYMENT_METHOD = (String) payment.get("method");
                if (PAYMENT_METHOD.equals("CULTURE")) {
                    if ((long) payment.get("paidAmount") == 0L)
                        plugin.getServer().getScheduler().runTask(plugin, () -> Bukkit.getServer().getPluginManager().callEvent(new EvtCulturelandFail(identifier)));
                    else
                        plugin.getServer().getScheduler().runTask(plugin, () -> Bukkit.getServer().getPluginManager().callEvent(new EvtCulturelandSuccess(identifier, paidAmount)));
                } else if (PAYMENT_METHOD.equals("DEPOSIT"))
                    plugin.getServer().getScheduler().runTask(plugin, () -> Bukkit.getServer().getPluginManager().callEvent(new EvtDepositSuccess(identifier, paidAmount)));
            } else if (!response.get("error").equals("NO_PROGRESS_PAYMENTS")) {
                plugin.getLogger().info(prefix + "오류 코드 : " + response.get("error"));
                plugin.getLogger().info(prefix + "오류 메시지 : " + response.get("error_msg"));
            }
        }
    }

    private JSONObject getPayment(String query) {
        try {

            URL url = new URL("https://api.benta.im/callback/rest" + query);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setRequestMethod("GET");

            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Content-type", "application/json");

            con.setDoInput(true);
            con.setUseCaches(false);
            con.setDefaultUseCaches(false);

            StringBuilder sb = new StringBuilder();
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "utf-8"));
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                br.close();
                JSONParser jsonParser = new JSONParser();
                JSONObject responseData = (JSONObject) jsonParser.parse(sb.toString());
                return responseData;
            }
        } catch (Exception e) {
            plugin.getLogger().info(prefix + e);
        }
        return null;
    }
}
