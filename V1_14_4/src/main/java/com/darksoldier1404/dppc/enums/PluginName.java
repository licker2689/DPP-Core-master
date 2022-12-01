package com.darksoldier1404.dppc.enums;

@SuppressWarnings("all")
public enum PluginName {
    DPPCore("DPP-Core", 13426),
    LegendaryCash("DP-LegendaryCash", 13387),
    VirtualStorage("DP-VirtualStorage", 13386),
    SimplePrefix("DP-SimplePrefix", 13460),
    ItemEditor("DP-ItemEditor", 13462),
    SimpleMenu("DP-SimpleMenu", 13499),
    SimpleAnnouncement("DP-SimpleAnnouncement", 13561),
    EquipmentAttribution("DP-EquipmentAttribution", 13663),
    SimpleShop("DP-SimpleShop", 14331),
    RPG("DP-RPG", 14497),
    OreGen("DP-OreGen", 14637),
    MultiWorld("DP-MultiWorld", 14686),
    ItemCommand("DP-ItemCommand", 14687),
    EasyEntitySpawn("DP-EasyEntitySpawn", 14688),
    HotTime("DP-HotTime", 14732),
    EasyMessages("DP-EasyMessages", 14733),
    EasyWarning("DP-EasyWarning", 14737),
    EasyWarp("DP-EasyWarp", 14751),
    LegendaryStorage("DP-LegendaryStorage", 14782),
    Lotto("DP-Lotto", 14901),
    ChatChannel("DP-ChatChannel", 14902),
    RandomBox("DP-RandomBox", 15134),
    GiftBox("DP-GiftBox", 15135),
    BackPack("DP-BackPack", 15136),
    BubbleChat("DP-BubbleChat", 15491),
    LegendaryEnderChest("DP-LegendaryEnderChest", 15714),
    BroadcastStream("DP-BroadcastStream", 15715),
    Menu("DP-Menu", 15781),
    MultiCommand("DP-MultiCommand", 15934),
    LegendaryCollection("DP-LegendaryCollection", 15935),
    ;

    private final String name;
    private final int pluginID;

    PluginName(String name, int pluginID) {
        this.name = name;
        this.pluginID = pluginID;
    }

    public String getName() {
        return name;
    }

    public int getPluginID() {
        return pluginID;
    }

    public static PluginName getByName(String name) {
        for (PluginName pluginName : values()) {
            if (pluginName.getName().equals(name)) {
                return pluginName;
            }
        }
        return null;
    }

    public static PluginName getByID(int id) {
        for (PluginName pluginName : values()) {
            if (pluginName.getPluginID() == id) {
                return pluginName;
            }
        }
        return null;
    }
}
