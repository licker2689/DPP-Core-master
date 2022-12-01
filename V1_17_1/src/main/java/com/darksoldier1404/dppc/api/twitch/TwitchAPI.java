package com.darksoldier1404.dppc.api.twitch;

import com.darksoldier1404.dppc.DPPCore;
import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import com.github.twitch4j.chat.events.channel.DonationEvent;
import com.github.twitch4j.events.ChannelGoLiveEvent;
import com.github.twitch4j.events.ChannelGoOfflineEvent;
import org.bukkit.Bukkit;

@SuppressWarnings("unused")
public class TwitchAPI {
    private static final DPPCore plugin = DPPCore.getInstance();
    private static TwitchClient tc;

    public static void init() {
        try{
            String key, secret, cbid, cbtoken;
            key = plugin.config.getString("Settings.twitch-api-key");
            secret = plugin.config.getString("Settings.twitch-api-secret");
            cbid = plugin.config.getString("Settings.twitch-chatbot-clientID");
            cbtoken = plugin.config.getString("Settings.twitch-chatbot-accessToken");
            if (key == null || secret == null) { // for the application
                plugin.log.warning("Twitch API Key 또는 Secret이 설정되지 않았습니다.");
                plugin.log.warning("Twitch API 사용 불가.");
                return;
            }
            if (cbid == null || cbtoken == null) { // for the chatbot
                plugin.log.warning("Twitch Chatbot ClientID 또는 AccessToken이 설정되지 않았습니다.");
                plugin.log.warning("Twitch API 사용 불가.");
                return;
            }
            tc = TwitchClientBuilder.builder()
                    .withEnableHelix(true)
                    .withClientId(key)
                    .withClientSecret(secret)
                    .withDefaultEventHandler(SimpleEventHandler.class)
                    .withEnableChat(true)
                    .withChatAccount(new OAuth2Credential(cbid, cbtoken))
                    .build();
            registerEvents();
        }catch (Exception e){
            plugin.log.warning("Twitch API Key, Secret, ClientID, AccessToken중에 무언가가 잘못되었습니다.");
            plugin.log.warning("Twitch API 사용 불가.");
        }
    }

    public static void enableStreamTracking(String username) {
        tc.getClientHelper().enableStreamEventListener(username);
    }

    private static void registerEvents() {
        tc.getEventManager().onEvent(ChannelGoLiveEvent.class, e -> Bukkit.getServer().getPluginManager().callEvent(new TwitchLiveEvent(e.getChannel(), e.getStream(), e)));
        tc.getEventManager().onEvent(ChannelMessageEvent.class, e -> Bukkit.getServer().getPluginManager().callEvent(new TwitchMessageEvent(e)));
        tc.getEventManager().onEvent(DonationEvent.class, e -> Bukkit.getServer().getPluginManager().callEvent(new TwitchDonationEvent(e)));
        tc.getEventManager().onEvent(ChannelGoOfflineEvent.class, e -> Bukkit.getServer().getPluginManager().callEvent(new TwitchOfflineEvent(e.getChannel())));
    }

    public static TwitchClient getTwitchClient() {
        return tc;
    }
}
