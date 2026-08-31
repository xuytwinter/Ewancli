package com.ewancli.wechat;

import java.nio.file.Path;

public final class WechatPaths {
    private WechatPaths() {
    }

    public static Path root() {
        String configured = System.getProperty("ewancli.wechat.dir");
        if (configured == null || configured.isBlank()) {
            configured = System.getenv("EWANCLI_WECHAT_DIR");
        }
        if (configured == null || configured.isBlank()) {
            configured = Path.of(System.getProperty("user.home"), ".ewancli", "wechat").toString();
        }
        return Path.of(configured);
    }

    public static Path accountsDir() {
        return root().resolve("accounts");
    }

    public static Path sessionsDir() {
        return root().resolve("sessions");
    }

    public static Path mediaDir() {
        return root().resolve("media");
    }

    public static Path logsDir() {
        return root().resolve("logs");
    }

    public static Path pidFile() {
        return root().resolve("ewancli-wechat.pid");
    }
}
