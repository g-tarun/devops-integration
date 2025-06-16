package com.learning.parent.core;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CTLogger {
    private static final String LOG_FILE = "logs/app-log.log";
    private static final long MAX_SIZE = 12 * 1024 * 1024; // 12MB
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    static {
        try {
            Files.createDirectories(Paths.get("logs"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String level, String tnxId, String message) {
        rotateIfNeeded();
        String logEntry = String.format("mwrequest | %s | %s | %s | %s\n",
                TIME_FORMATTER.format(LocalDateTime.now()), tnxId, level.toUpperCase(), message);
        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            fw.write(logEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void rotateIfNeeded() {
        File file = new File(LOG_FILE);
        if (file.exists() && file.length() >= MAX_SIZE) {
            String newName = "logs/app-log-" + System.currentTimeMillis() + ".log";
            file.renameTo(new File(newName));
        }
    }

    public static void debug(String tnxId, String msg) { log("DEBUG", tnxId, msg); }
    public static void info(String tnxId, String msg)  { log("INFO", tnxId, msg); }
    public static void warn(String tnxId, String msg)  { log("WARN", tnxId, msg); }
    public static void error(String tnxId, String msg) { log("ERROR", tnxId, msg); }
}

