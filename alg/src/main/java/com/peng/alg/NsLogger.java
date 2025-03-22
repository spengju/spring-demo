package com.peng.alg;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

/**
 * @author Hoary (hoary.huang@infosec.com.cn)
 * @org �����Ű����ͿƼ��ɷ����޹�˾
 * @date 2024/7/8 17:18
 * @since NetSignServer5.7.2.2_build20240426
 */
public class NsLogger {

    private static boolean on;

    private Object logger;

    private Method logMethod;
    private Method debugMethod;
    private Method infoMethod;

    private static final String INFO = "info";
    private static final String DEBUG = "debug";

    private boolean isInfo;

    private Class clazz;

    private NsLogger() {
        String level = System.getProperty("log.level");
        if (level != null) {
            if (level.trim().equalsIgnoreCase("info")) {
                isInfo = true;
            }
            on = true;
        }
    }

    public static NsLogger getLogger(Class clazz) {
        NsLogger log = new NsLogger();
        log.clazz = clazz;
        log.initLogger();
        return log;
    }

    private void initLogger() {
        if (initSlf4j() || initCommonLog() || initLogBack() || initLog4j2() || initLog4j() || initJavaLog()) {
            logMethod = debugMethod;
            if (isInfo) {
                logMethod = infoMethod;
            }
        }
    }

    private boolean initSlf4j() {
        try {
            Class clazzFactory = Class.forName("org.slf4j.LoggerFactory");
            Method mGetLogger = clazzFactory.getMethod("getLogger", Class.class);
            logger = mGetLogger.invoke(null, clazz);
            Class clazzLogger = Class.forName("org.slf4j.Logger");
            debugMethod = clazzLogger.getMethod(DEBUG, String.class);
            infoMethod = clazzLogger.getMethod(INFO, String.class);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    private boolean initCommonLog() {
        try {
            Class clazzFactory = Class.forName("org.apache.commons.logging.LogFactory");
            Method mGetLogger = clazzFactory.getMethod("getLog", Class.class);
            logger = mGetLogger.invoke(null, clazz);
            Class clazzLogger = Class.forName("org.apache.commons.logging.Log");
            debugMethod = clazzLogger.getMethod(DEBUG, Object.class);
            infoMethod = clazzLogger.getMethod(INFO, Object.class);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    private boolean initJavaLog() {
        // ���û�� slf4j Ҳû�� commons.logging, ����JDK�Դ���
        logger = Logger.getLogger(clazz.getName());
        Logger logger1 = (Logger) logger;
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new DefaultFormatter());
        logger1.addHandler(consoleHandler);
        logger1.setUseParentHandlers(false);
        try {
            debugMethod = Logger.class.getMethod("config", String.class);
            infoMethod = Logger.class.getMethod(INFO, String.class);
            return true;
        } catch (Exception ex) {
        }
        return false;
    }

    private boolean initLog4j() {
        try {
            Class clazzLogger = Class.forName("org.apache.log4j.Logger");
            Method mGetLogger = clazzLogger.getMethod("getLogger", Class.class);
            logger = mGetLogger.invoke(null, clazz);

            debugMethod = clazzLogger.getMethod(DEBUG, String.class);
            infoMethod = clazzLogger.getMethod(INFO, String.class);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    private boolean initLog4j2() {
        try {
            Class clazzFactory = Class.forName("org.apache.logging.log4j.LogManager");
            Method mGetLogger = clazzFactory.getMethod("getLogger", Class.class);
            logger = mGetLogger.invoke(null, clazz);
            Class clazzLogger = Class.forName("org.apache.logging.log4j.Logger");
            debugMethod = clazzLogger.getMethod(DEBUG, String.class);
            infoMethod = clazzLogger.getMethod(INFO, String.class);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    private boolean initLogBack() {
        try {
            Class clazzFactory = Class.forName("ch.qos.logback.classic.LoggerContext");
            Class clazzLogger = Class.forName("ch.qos.logback.classic.Logger");
            Method mGetLogger = clazzFactory.getMethod("getLogger", Class.class);
            logger = mGetLogger.invoke(clazzFactory.getConstructor().newInstance(), clazz);
            debugMethod = clazzLogger.getMethod(DEBUG, String.class);
            infoMethod = clazzLogger.getMethod(INFO, String.class);
            return true;
        } catch (Exception e) {
        }
        return false;

    }

    class DefaultFormatter extends Formatter {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        @Override
        public String format(LogRecord record) {
            String msg = record.getMessage();
            StringBuilder builder = new StringBuilder(100 + msg.length());
            builder.append("[");
            builder.append(dateFormat.format(new Date(record.getMillis())));
            builder.append("][");
            builder.append(Thread.currentThread().getName()).append("][");
            builder.append(record.getLevel().getName());
            builder.append("] ").append(msg).append("\n");
            return builder.toString();
        }
    }

    public void log(String msg) {
        if (!on) {
            return;
        }
        try {
            logMethod.invoke(logger, msg);
        } catch (Exception e) {
        }
    }

    public void info(String msg) {
        if (!on) {
            return;
        }
        try {
            infoMethod.invoke(logger, msg);
        } catch (Exception e) {
        }
    }

    public void debug(String msg) {
        if (!on) {
            return;
        }
        try {
            debugMethod.invoke(logger, msg);
        } catch (Exception e) {
        }
    }

    public static void openLog(boolean on) {
        NsLogger.on = on;
    }
}
