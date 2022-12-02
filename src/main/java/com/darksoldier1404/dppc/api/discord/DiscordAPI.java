package com.darksoldier1404.dppc.api.discord;

import com.darksoldier1404.dppc.DPPCore;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class DiscordAPI {
    private static final DPPCore plugin = DPPCore.getInstance();
    private static JDA jda;
    public static void init() {
        String token = DPPCore.getInstance().config.getString("Settings.discord-bot-token");
        if(token == null){
            plugin.log.warning("디스코드 봇 토큰이 설정되지 않았습니다.");
            plugin.log.warning("Discord API 사용 불가.");
            return;
        }
        jda = JDABuilder.createDefault(token).build();
    }

    public static JDA getJDA(){
        return jda;
    }
}
