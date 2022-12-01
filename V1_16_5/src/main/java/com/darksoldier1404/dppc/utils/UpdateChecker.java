package com.darksoldier1404.dppc.utils;

import com.darksoldier1404.dppc.DPPCore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class UpdateChecker {
    private static final DPPCore core = DPPCore.getInstance();
    private static final String prefix = core.prefix;
    private static final Logger log = core.getLogger();

    public static void check(JavaPlugin plugin) {
        Bukkit.getScheduler().runTaskAsynchronously(core, () -> {
        String currentVersion = plugin.getDescription().getVersion();
        String pluginName = plugin.getDescription().getName();
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL("https://raw.githubusercontent.com/darksoldier1404/" + pluginName + "/master/src/main/resources/plugin.yml").openConnection();
                connection.connect();
                String rr = new BufferedReader(new InputStreamReader(connection.getInputStream())).lines().collect(Collectors.toList()).get(1).split(" ")[1];
                if (!currentVersion.equals(rr)) {
                    log.info(prefix + pluginName + " : A new version of " + pluginName + " is available! " + rr);
                    log.info(prefix + pluginName + " : This plugin's version is " + currentVersion);
                    log.info(prefix + pluginName + " : 최신 버전이 존재합니다! " + rr);
                    log.info(prefix + pluginName + " : 이 플러그인의 버전은 " + currentVersion + " 입니다. 업데이트를 해주시기 바랍니다.");
                    log.info(prefix + pluginName + " : 업데이트 다운로드 : http://dpp.dpnw.site:8080/job/" + pluginName);
                    log.info(prefix + pluginName + " : Update Download : http://dpp.dpnw.site:8080/job/" + pluginName);
                } else {
                    log.info(prefix + pluginName + " : 이 플러그인은 최신버전 입니다." + currentVersion);
                }
            } catch (IOException e) {
                log.info(prefix + pluginName + " : 업데이트 정보를 가져오는데 실패했습니다.");
            }
        });
    }

    public static void check(JavaPlugin plugin, Player p) {
        Bukkit.getScheduler().runTaskAsynchronously(core, () -> {
        String currentVersion = plugin.getDescription().getVersion();
        String pluginName = plugin.getDescription().getName();
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL("https://raw.githubusercontent.com/darksoldier1404/" + pluginName + "/master/src/main/resources/plugin.yml").openConnection();
                connection.connect();
                String rr = new BufferedReader(new InputStreamReader(connection.getInputStream())).lines().collect(Collectors.toList()).get(1).split(" ")[1];
                if (!currentVersion.equals(rr)) {
                    p.sendMessage(prefix + pluginName + " : 최신 버전이 존재합니다! " + rr);
                    p.sendMessage(prefix + pluginName + " : 이 플러그인의 버전은 " + currentVersion + " 입니다. 업데이트를 해주시기 바랍니다.");
                    p.sendMessage(prefix + pluginName + " : 업데이트 다운로드 : http://dpp.dpnw.site:8080/job/" + pluginName);
                    p.sendMessage(prefix + pluginName + " : Update Download : http://dpp.dpnw.site:8080/job/" + pluginName);
                } else {
                    p.sendMessage(prefix + pluginName + " : 이 플러그인은 최신버전 입니다." + currentVersion);
                }
            } catch (IOException e) {
                p.sendMessage(prefix + pluginName + " : 업데이트 정보를 가져오는데 실패했습니다.");
            }
        });
    }
}