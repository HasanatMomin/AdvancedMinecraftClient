package com.advanced.client.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logger {

    private static org.apache.logging.log4j.Logger logger;

    public static void init(String name) {
        logger = LogManager.getLogger(name);
    }

    public static void info(String message) {
        if (logger != null) logger.info(message);
    }

    public static void warn(String message) {
        if (logger != null) logger.warn(message);
    }

    public static void error(String message) {
        if (logger != null) logger.error(message);
    }

    public static void debug(String message) {
        if (logger != null) logger.debug(message);
    }
}
