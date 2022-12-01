package com.darksoldier1404.dppc.api.logger;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@SuppressWarnings("unused")
public class DLogger {
    private final Map<String, YamlConfiguration> logMap = new HashMap<>();
    private YamlConfiguration mainLog = new YamlConfiguration();
    private final JavaPlugin plugin;
    private final Logger log;
    private BukkitTask task;
    private boolean useConsoleLog = false;
    private byte logLevel = 4;
    // 0 = log for only this class only
    // 1 = log for logMap's logs only
    // 2 = log for mainLog only
    // 3 = log for all logs
    // 4~, ~-1 = no log

    public DLogger(JavaPlugin plugin) {
        this.plugin = plugin;
        log = this.plugin.getLogger();
        if (logLevel == 0 || logLevel == 3) {
            log.info("DLogger 활성화 - 로그 레벨: " + logLevel);
            log.info("DLogger 활성화 - 콘솔 로그 사용: " + useConsoleLog);
        }
    }

    public DLogger(JavaPlugin plugin, boolean useConsoleLog) {
        this.plugin = plugin;
        this.useConsoleLog = useConsoleLog;
        log = this.plugin.getLogger();
        if (logLevel == 0 || logLevel == 3) {
            log.info("DLogger 활성화 - 로그 레벨: " + logLevel);
            log.info("DLogger 활성화 - 콘솔 로그 사용: " + useConsoleLog);
        }
    }

    public DLogger(JavaPlugin plugin, boolean useConsoleLog, byte logLevel) {
        this.plugin = plugin;
        this.useConsoleLog = useConsoleLog;
        this.logLevel = logLevel;
        log = this.plugin.getLogger();
        if (logLevel == 0 || logLevel == 3) {
            log.info("DLogger 활성화 - 로그 레벨: " + logLevel);
            log.info("DLogger 활성화 - 콘솔 로그 사용: " + useConsoleLog);
            log.info("DLogger 활성화 - 메인 로그 사용: " + (mainLog != null));
        }
    }

    public boolean addLog(String name) {
        if (logMap.containsKey(name)) {
            if (logLevel == 0 || logLevel == 3) {
                log.warning("이미 " + name + " 로그가 존재합니다.");
            }
            return false;
        } else {
            logMap.put(name, new YamlConfiguration());
            if (logLevel == 0 || logLevel == 3) {
                log.info(name + " 로그를 추가했습니다.");
            }
            return true;
        }
    }

    @Deprecated
    public void resetMainLog() {
        mainLog = null;
        if (logLevel == 0 || logLevel == 3) {
            log.info("메인 로그를 리셋 하였습니다.");
        }
    }

    @Nullable
    public YamlConfiguration getLog(String name) {
        if (!logMap.containsKey(name)) {
            if (logLevel == 0 || logLevel == 3) {
                log.warning(name + " 로그가 존재하지 않습니다.");
            }
            return null;
        }
        if (logLevel == 0 || logLevel == 3) {
            log.info(name + " 로그를 가져왔습니다.");
        }
        return logMap.get(name);
    }

    public boolean removeLog(String name) {
        if (logMap.containsKey(name)) {
            logMap.remove(name);
            if (logLevel == 0 || logLevel == 3) {
                log.info(name + " 로그를 제거했습니다.");
            }
            return true;
        } else {
            if (logLevel == 0 || logLevel == 3) {
                log.warning(name + " 로그가 존재하지 않습니다.");
            }
            return false;
        }
    }

    public boolean log(String name, String key, Object value) {
        if (logMap.containsKey(name)) {
            YamlConfiguration data = logMap.get(name);
            if (data.contains(key)) {
                if (logLevel == 0 || logLevel == 3) {
                    log.warning(name + " 로그의 " + key + " 키에 이미 값이 존재합니다.");
                }
                return false;
            } else {
                data.set(key, value);
                if (logLevel == 1 || logLevel == 3) {
                    log.info(name + " 로그의 " + key + " 키에 " + value + " 값을 추가했습니다.");
                }
                return true;
            }
        } else {
            if (logLevel == 0 || logLevel == 3) {
                log.warning(name + " 로그가 존재하지 않습니다.");
            }
            return false;
        }
    }

    public boolean log(String key, Object value) {
        if (mainLog != null) {
            if (mainLog.contains(key)) {
                if (logLevel == 0 || logLevel == 3) {
                    log.warning("메인 로그의 " + key + " 키에 이미 값이 존재합니다.");
                }
                return false;
            } else {
                mainLog.set(key, value);
                if (logLevel == 2 || logLevel == 3) {
                    log.info("메인 로그의 " + key + " 키에 " + value + " 값을 추가했습니다.");
                }
                return true;
            }
        } else {
            if (logLevel == 0 || logLevel == 3) {
                log.warning("메인 로그가 존재하지 않습니다.");
            }
            return false;
        }
    }

    public boolean log(Object value) {
        if (mainLog != null) {
            String nanoTimeStr = String.valueOf(System.nanoTime());
            String key = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + "-" + nanoTimeStr.substring(nanoTimeStr.length() - 6);
            if (mainLog.contains(key)) {
                if (logLevel == 0 || logLevel == 3) {
                    log.warning("메인 로그의 " + key + " 키에 이미 값이 존재합니다.");
                }
                return false;
            }
            mainLog.set(key, value);
            if (logLevel == 2 || logLevel == 3) {
                log.info("메인 로그의 " + key + " 키에 " + value + " 값을 추가했습니다.");
            }
            return true;
        } else {
            if (logLevel == 0 || logLevel == 3) {
                log.warning("메인 로그가 존재하지 않습니다.");
            }
            return false;
        }
    }

    public void initAutoSave(long delay, long period, String logMapPath, String logMapName, String mainLogPath, String mainLogName, boolean withReset) {
        if (task != null) {
            if (logLevel == 0 || logLevel == 3) {
                log.warning("이미 자동 저장이 활성화 되어 있습니다.");
            }
            return;
        }
        task = new BukkitRunnable() {
            @Override
            public void run() {
                if (logLevel == 0 || logLevel == 3) {
                    log.info("DLogger 자동 저장을 시작합니다.");
                }
                if (logMapPath != null && logMapName != null) {
                    String nanoTimeStr = String.valueOf(System.nanoTime());
                    String key = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + "-" + nanoTimeStr.substring(nanoTimeStr.length() - 6);
                    saveLogMapData(logMapPath, logMapName + "-" + key, withReset);
                }
                if (mainLogPath != null && mainLogName != null) {
                    String nanoTimeStr = String.valueOf(System.nanoTime());
                    String key = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + "-" + nanoTimeStr.substring(nanoTimeStr.length() - 6);
                    saveMainLogData(mainLogPath, mainLogName + "-" + key, withReset);
                }
                if (logLevel == 0 || logLevel == 3) {
                    log.info("DLogger 자동 저장을 완료했습니다.");
                }
            }
        }.runTaskTimer(plugin, delay, period);
        if (logLevel == 0 || logLevel == 3) {
            log.info("자동 저장을 활성화 했습니다.");
        }
    }

    public void cancelAutoSaveTask() {
        if (task != null) {
            task.cancel();
            task = null;
            if (logLevel == 0 || logLevel == 3) {
                log.info("자동 저장을 비활성화 했습니다.");
            }
        } else {
            if (logLevel == 0 || logLevel == 3) {
                log.warning("자동 저장이 이미 비활성화 되어 있습니다.");
            }
        }
    }

    public void saveMainLogData(String path, String fileName, boolean withReset) {
        if (mainLog != null) {
            try {
                if(!mainLog.getKeys(false).isEmpty()) {
                    mainLog.save(new File(path, fileName+".yml"));
                }
                if (withReset) {
                    mainLog = new YamlConfiguration();
                }
                if (logLevel == 2 || logLevel == 3) {
                    log.info("메인 로그를 " + path + "/" + fileName + " 에 저장했습니다.");
                }
            } catch (IOException e) {
                if (logLevel == 0 || logLevel == 3) {
                    log.warning("메인 로그를 " + path + "/" + fileName + " 에 저장하는데 실패했습니다.");
                }
                e.printStackTrace();
            }
        } else {
            if (logLevel == 0 || logLevel == 3) {
                log.warning("메인 로그가 존재하지 않습니다.");
            }
        }
    }

    public void saveLogMapData(String path, String fileName, boolean withReset) {
        if (!logMap.isEmpty()) {
            for (String name : logMap.keySet()) {
                YamlConfiguration data = logMap.get(name);
                try {
                    if(!data.getKeys(false).isEmpty()) {
                        data.save(new File(path, fileName.replace("%name%", name) + ".yml"));
                    }
                    if (withReset) {
                        logMap.put(name, new YamlConfiguration());
                    }
                    if (logLevel == 1 || logLevel == 3) {
                        log.info(name + " 로그를 " + path + "/" + fileName.replace("%name%", name) + " 에 저장했습니다.");
                    }
                } catch (IOException e) {
                    if (logLevel == 0 || logLevel == 3) {
                        log.warning(name + " 로그를 " + path + "/" + fileName.replace("%name%", name) + " 에 저장하는데 실패했습니다.");
                    }
                    e.printStackTrace();
                }
            }
        } else {
            if (logLevel == 0 || logLevel == 3) {
                log.warning("로그가 존재하지 않습니다.");
            }
        }
    }
}
