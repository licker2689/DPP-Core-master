![](https://bstats.org/signatures/bukkit/DP-UniversalCore.svg)
[![Gradle Build by.Bruce0203](https://github.com/darksoldier1404/DPP-Core/actions/workflows/gradle.yml/badge.svg?branch=master)](https://github.com/darksoldier1404/DPP-Core/actions/workflows/gradle.yml)
# DPP-Core (old name - DP-UniversalCore)

## GRADLE

## 리포지토리 - Repository
```gradle
    maven {
        url "http://dpp.dpnw.site:8081/repository/maven-public/"
        allowInsecureProtocol = true
    }
```
## 디펜던시 - Dependencies
```gradle
compileOnly 'com.darksoldier1404.dppc:DPP-Core:1.19-SNAPSHOT'
compileOnly 'com.darksoldier1404.dppc:DPP-Core:1.18.2-SNAPSHOT'
compileOnly 'com.darksoldier1404.dppc:DPP-Core:1.18.1-SNAPSHOT'
compileOnly 'com.darksoldier1404.dppc:DPP-Core:1.17.1-SNAPSHOT'
compileOnly 'com.darksoldier1404.dppc:DPP-Core:1.16.5-SNAPSHOT'
compileOnly 'com.darksoldier1404.dppc:DPP-Core:1.15.2-SNAPSHOT'
compileOnly 'com.darksoldier1404.dppc:DPP-Core:1.14.4-SNAPSHOT'
compileOnly 'com.darksoldier1404.dppc:DPP-Core:1.13.2-SNAPSHOT'
compileOnly 'com.darksoldier1404.dppc:DPP-Core:1.12.2-SNAPSHOT'
```
## Spigot & CraftBukkit
```gradle
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.19'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.18.2'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.18.1'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.18'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.17.1'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.17'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.16.5'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.16.4'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.16.3'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.16.2'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.16.1'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.15.2'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.15.1'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.15'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.14.4'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.14.3'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.14.2'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.14.1'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.14'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.13.2'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.13.1'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.13'
compileOnly 'org.bukkit.craftbukkit:craftbukkit:R0.1:1.12.2'

compileOnly 'org.spigotmc:spigot-api:R0.1:1.19'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.18.2'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.18.1'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.18'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.17.1'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.17'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.16.5'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.16.4'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.16.3'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.16.2'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.16.1'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.15.2'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.15.1'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.15'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.14.4'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.14.3'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.14.2'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.14.1'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.14'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.13.2'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.13.1'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.13'
compileOnly 'org.spigotmc:spigot-api:R0.1:1.12.2'
```

## GRADLE kotlin DSL

## 리포지토리 - Repository
```gradle
    maven {
        url = uri('http://dpp.dpnw.site:8081/repository/maven-public/')
    }
```
## 디펜던시 - Dependencies
```gradle
compileOnly("com.darksoldier1404.dppc:DPP-Core:1.19-SNAPSHOT")
compileOnly("com.darksoldier1404.dppc:DPP-Core:1.18.2-SNAPSHOT")
compileOnly("com.darksoldier1404.dppc:DPP-Core:1.18.1-SNAPSHOT")
compileOnly("com.darksoldier1404.dppc:DPP-Core:1.17.1-SNAPSHOT")
compileOnly("com.darksoldier1404.dppc:DPP-Core:1.16.5-SNAPSHOT")
compileOnly("com.darksoldier1404.dppc:DPP-Core:1.15.2-SNAPSHOT")
compileOnly("com.darksoldier1404.dppc:DPP-Core:1.14.4-SNAPSHOT")
compileOnly("com.darksoldier1404.dppc:DPP-Core:1.13.2-SNAPSHOT")
compileOnly("com.darksoldier1404.dppc:DPP-Core:1.12.2-SNAPSHOT")
```
## Spigot & CraftBukkit
```gradle
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.19")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.18.2")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.18.1")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.18")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.17.1")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.17")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.16.5")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.16.4")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.16.3")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.16.2")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.16.1")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.15.2")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.15.1")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.15")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.14.4")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.14.3")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.14.2")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.14.1")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.14")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.13.2")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.13.1")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.13")
compileOnly("org.bukkit.craftbukkit:craftbukkit:R0.1:1.12.2")

compileOnly("org.spigotmc:spigot-api:R0.1:1.19")
compileOnly("org.spigotmc:spigot-api:R0.1:1.18.2")
compileOnly("org.spigotmc:spigot-api:R0.1:1.18.1")
compileOnly("org.spigotmc:spigot-api:R0.1:1.18")
compileOnly("org.spigotmc:spigot-api:R0.1:1.17.1")
compileOnly("org.spigotmc:spigot-api:R0.1:1.17")
compileOnly("org.spigotmc:spigot-api:R0.1:1.16.5")
compileOnly("org.spigotmc:spigot-api:R0.1:1.16.4")
compileOnly("org.spigotmc:spigot-api:R0.1:1.16.3")
compileOnly("org.spigotmc:spigot-api:R0.1:1.16.2")
compileOnly("org.spigotmc:spigot-api:R0.1:1.16.1")
compileOnly("org.spigotmc:spigot-api:R0.1:1.15.2")
compileOnly("org.spigotmc:spigot-api:R0.1:1.15.1")
compileOnly("org.spigotmc:spigot-api:R0.1:1.15")
compileOnly("org.spigotmc:spigot-api:R0.1:1.14.4")
compileOnly("org.spigotmc:spigot-api:R0.1:1.14.3")
compileOnly("org.spigotmc:spigot-api:R0.1:1.14.2")
compileOnly("org.spigotmc:spigot-api:R0.1:1.14.1")
compileOnly("org.spigotmc:spigot-api:R0.1:1.14")
compileOnly("org.spigotmc:spigot-api:R0.1:1.13.2")
compileOnly("org.spigotmc:spigot-api:R0.1:1.13.1")
compileOnly("org.spigotmc:spigot-api:R0.1:1.13")
compileOnly("org.spigotmc:spigot-api:R0.1:1.12.2")
```

## API
### ConfigUtils - Custom Config Utils
```java
public static YamlConfiguration config;
public static TestPlugin plugin;
public void onEnable() {
    plugin = this;
    config = ConfigUtils.loadDefaultPluginConfig(plugin);
}
```
### DInventory - Custom Inventory Class
```java
DInventory inv = new DInventory(null, "DInventory Test", 54, true, plugin);
ItemStack pane = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
ItemStack prev = NBT.setStringTag(new ItemStack(Material.PINK_DYE), "prev", "true");
ItemMeta im = prev.getItemMeta();
im.setDisplayName("이전 페이지");
prev.setItemMeta(im);
ItemStack next = NBT.setStringTag(new ItemStack(Material.LIME_DYE), "next", "true");
im = next.getItemMeta();
im.setDisplayName("다음 페이지");
next.setItemMeta(im);
inv.setPageTools(new ItemStack[]{pane, pane, prev, pane, pane, pane, next, pane, pane});
inv.addPageContent(/*ItemStack[]*/);
inv.update();
Player#openInventory(inv);
```
```java
@EventHandler
public void onInventoryClick(InventoryClickEvent e) {
    if (e.getClickedInventory() instanceof DInventory) {
        DInventory inv = (DInventory) e.getClickedInventory();
        if (NBT.hasTagKey(e.getCurrentItem(), "prev")) {
            e.setCancelled(true);
            inv.prevPage();
            return;
        }
        if (NBT.hasTagKey(e.getCurrentItem(), "next")) {
            e.setCancelled(true);
            inv.nextPage();
            return;
        }
    }
}
```
#### but at 1.12.2 mc version need to use custom inventory holder like
```java
public static Map<UUID, DInventory> currentInv = new HashMap<>(); // <---

public static void openInv(Player p){
    DInventory inv = new DInventory(null, "DInventory Test", 54, true, plugin);
    p.openInventory(inv);
    currentInv.put(p.getUniqueId(), inv); // <---
}

@EventHandler
public void onInventoryClick(InventoryClickEvent e) {
    if (currentInv.containsKey(e.getWhoClicked().getUniqueId())) { // <---
        DInventory inv = (DInventory) e.getClickedInventory(); // <---
        if (NBT.hasTagKey(e.getCurrentItem(), "prev")) {
            e.setCancelled(true);
            inv.prevPage();
            return;
        }
        if (NBT.hasTagKey(e.getCurrentItem(), "next")) {
            e.setCancelled(true);
            inv.nextPage();
            return;
        }
    }
}
```
### InventoryUtils - Simple Inventory Utility
```java
Player p = Bukkit.getPlayer("DEAD_POOLIO_");
ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 10);
if(InventoryUtils.hasEnoughSpace(p.getInventory().getStorageContents(), item)) {
    p.getInventory().addItem(item);
}else{
    p.sendMessage("Inventory has not enough space.");
}
```
### ColorUtils - Simplest Color Applier
```java
String s = "&aTest String"
s = ColorUtils.applyColor(s);
String s2 = "<#FFFFFF>TestString"
s2 = ColorUtils.applyColor(s2);
```
### DLang - Multi Language Support
```java
private static TestPlugin plugin;
public static DLang lang;
public static YamlConfiguration config;

public void onEnable() {
    plugin = this;
    config = ConfigUtils.loadDefaultPluginConfig(plugin);
    lang = new DLang(config.getString("Settings.Lang") == null ? "English" : config.getString("Settings.Lang"), plugin);
}

public void test() {
    String arg = "Test"
    lang.get("test_text");
    // Test Text
    lang.getWithArgs("test_text2", arg);
    // Test Text: Test
}
```
### BentaAPI - 문화상품권, 계좌이체(프리미엄) 결제 활용
```java
BentaAPI bapi = new BentaAPI("벤타 어플리케이션 토큰", plugin, "벤타 결제시 표시될 타이틀", prefix); // Init
bapi.sendPaymentURL(player, plugin); // 플레이어에게 결제 페이지 링크 전송

// 이벤트 활용
    @EventHandler
    public void onCultuerlandFail(EvtCulturelandFail e) {
        OfflinePlayer op = Bukkit.getPlayer(UUID.fromString(e.getIdentifier()));
        if(op != null) {
            if(op.isOnline()) {
                Player p = Bukkit.getPlayer(op.getUniqueId());
                p.sendMessage(plugin.prefix + "§c컬처랜드 결제에 실패했습니다.");
            }
        }
    }

    @EventHandler
    public void onCultuerlandSuccess(EvtCulturelandSuccess e) {
        OfflinePlayer op = Bukkit.getPlayer(UUID.fromString(e.getIdentifier()));
        if(op != null) {
            if(op.isOnline()) {
                Player p = Bukkit.getPlayer(op.getUniqueId());
                p.sendMessage(plugin.prefix + "§a컬처랜드 결제에 성공했습니다.");
                p.sendMessage(plugin.prefix + "§a금액 : " + e.getPaidAmount() + " 원");
            }
        }
    }

    @EventHandler
    public void onDepositSuccess(EvtDepositSuccess e) {
        OfflinePlayer op = Bukkit.getPlayer(UUID.fromString(e.getIdentifier()));
        if(op != null) {
            if(op.isOnline()) {
                Player p = Bukkit.getPlayer(op.getUniqueId());
                p.sendMessage(plugin.prefix + "§a입금에 성공했습니다.");
                p.sendMessage(plugin.prefix + "§a금액 : " + e.getPaidAmount() + " 원");
            }
        }
    }
```
#### English.yml in /lang/English.yml
```yaml
Lang: English

test_text: "Test Text"
test_text2: "Test Text: {0}"
```
