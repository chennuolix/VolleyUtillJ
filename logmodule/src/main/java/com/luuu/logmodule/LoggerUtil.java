package com.luuu.logmodule;

import com.orhanobut.logger.Logger;

import java.util.Arrays;

/**
 * Created by luuu on 2018/1/30.
 */

public class LoggerUtil {

    private static boolean isLog() {
        return false;
    }

    private static void customLog(int priority, Throwable throwable, String tag, String msg, Object... args) {
        Logger.log(priority, tag, msg, throwable);
    }

    private static void customJsonLog(String msg) {
        Logger.json(msg);
    }

    private static void customXmlLog(String msg) {
        Logger.xml(msg);
    }

    /**
     * -------------level_debug------------
     **/
    public static void d(Object object) {
        d(LoggerManager.getTagName(), object);
    }

    public static void d(String tag, Object object) {
        d(tag, toString(object), (Object[]) null);
    }

    public static void d(String msg) {
        d(LoggerManager.getTagName(), msg);
    }

    public static void d(String tag, String msg) {
        d(tag, msg, (Object[]) null);
    }

    public static void d(String msg, Object... args) {
        d(LoggerManager.getTagName(), msg, args);
    }

    public static void d(String tag, String msg, Object... args) {
        String message = createMessage(msg, args);
        customLog(Logger.DEBUG, null, tag, message, args);
    }


    /**
     * -------------level_verbose------------
     **/
    public static void v(String msg) {
        v(LoggerManager.getTagName(), msg);
    }

    public static void v(String tag, String msg) {
        v(tag, msg, (Object[]) null);
    }

    public static void v(String msg, Object... args) {
        v(LoggerManager.getTagName(), msg, args);
    }

    public static void v(String tag, String msg, Object... args) {
        String message = createMessage(msg, args);
        customLog(Logger.VERBOSE, null, tag, message, args);
    }

    /**
     * -------------level_info------------
     **/
    public static void i(String msg) {
        i(LoggerManager.getTagName(), msg);
    }

    public static void i(String tag, String msg) {
        i(tag, msg, (Object[]) null);
    }

    public static void i(String msg, Object... args) {
        i(LoggerManager.getTagName(), msg, args);
    }

    public static void i(String tag, String msg, Object... args) {
        String message = createMessage(msg, args);
        customLog(Logger.INFO, null, tag, message, args);
    }

    /**
     * -------------level_warn------------
     **/
    public static void w(String msg) {
        w(LoggerManager.getTagName(), msg);
    }

    public static void w(String tag, String msg) {
        w(tag, msg, (Object[]) null);
    }

    public static void w(String msg, Object... args) {
        w(LoggerManager.getTagName(), msg, args);
    }

    public static void w(String tag, String msg, Object... args) {
        String message = createMessage(msg, args);
        customLog(Logger.WARN, null, tag, message, args);
    }

    /**
     * -------------level_error------------
     **/
    public static void e(String msg) {
        e(LoggerManager.getTagName(), msg);
    }

    public static void e(String tag, String msg) {
        e(null, tag, msg, (Object[]) null);
    }

    public static void e(String msg, Object... args) {
        e(null, LoggerManager.getTagName(), msg, args);
    }

    public static void e(Throwable throwable, String tag, String msg, Object... args) {
        String message = createMessage(msg, args);
        customLog(Logger.ERROR, throwable, tag, message, args);
    }

    /**
     * -------------level_assert(wtf)------------
     **/
    public static void wtf(String msg) {
        wtf(LoggerManager.getTagName(), msg);
    }

    public static void wtf(String tag, String msg) {
        wtf(tag, msg, (Object[]) null);
    }

    public static void wtf(String msg, Object... args) {
        wtf(LoggerManager.getTagName(), msg, args);
    }

    public static void wtf(String tag, String msg, Object... args) {
        String message = createMessage(msg, args);
        customLog(Logger.ASSERT, null, tag, message, args);
    }


    /**
     * -------------level_json------------
     **/
    public static void json(String msg) {
        customJsonLog(msg);
    }

    /**
     * -------------level_xml------------
     **/
    public static void xml(String msg) {
        customXmlLog(msg);
    }


    /**
     * 格式log日志
     *
     * @param message
     * @param args
     * @return
     */
    private static String createMessage(String message, Object... args) {
        return args == null || args.length == 0 ? message : String.format(message, args);
    }

    /**
     * 打印map、list等时需要进行转换
     *
     * @param object
     * @return
     */
    private static String toString(Object object) {
        if (object == null) {
            return "null";
        }
        if (!object.getClass().isArray()) {
            return object.toString();
        }
        if (object instanceof boolean[]) {
            return Arrays.toString((boolean[]) object);
        }
        if (object instanceof byte[]) {
            return Arrays.toString((byte[]) object);
        }
        if (object instanceof char[]) {
            return Arrays.toString((char[]) object);
        }
        if (object instanceof short[]) {
            return Arrays.toString((short[]) object);
        }
        if (object instanceof int[]) {
            return Arrays.toString((int[]) object);
        }
        if (object instanceof long[]) {
            return Arrays.toString((long[]) object);
        }
        if (object instanceof float[]) {
            return Arrays.toString((float[]) object);
        }
        if (object instanceof double[]) {
            return Arrays.toString((double[]) object);
        }
        if (object instanceof Object[]) {
            return Arrays.deepToString((Object[]) object);
        }
        return "Couldn't find a correct type for the object";
    }
}
