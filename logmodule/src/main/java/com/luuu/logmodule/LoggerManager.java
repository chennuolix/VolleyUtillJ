package com.luuu.logmodule;

import java.nio.file.FileAlreadyExistsException;

/**
 * Created by luuu on 2018/1/30.
 */

public class LoggerManager {

    private static String TAG_NAME = "";        //TAG标签名
    private static boolean IS_DEBUG = true;      //是否是debug状态
    private static String LOG_FILEPATH = "";     //日志保存到本地的路径
    private static boolean SHOW_THREAD = true;   //是否展示线程信息
    private static double METHOD_COUNT = 2;      //打印的方法个数
    private static double METHOD_OFFSET = 0;

    public static String getTagName() {
        return TAG_NAME;
    }

    public static void setTagName(String tagName) {
        TAG_NAME = tagName;
    }

    public static boolean isIsDebug() {
        return IS_DEBUG;
    }

    public static void setIsDebug(boolean isDebug) {
        IS_DEBUG = isDebug;
    }

    public static String getLogFilepath() {
        return LOG_FILEPATH;
    }

    public static void setLogFilepath(String logFilepath) {
        LOG_FILEPATH = logFilepath;
    }

    public static boolean isShowThread() {
        return SHOW_THREAD;
    }

    public static void setShowThread(boolean showThread) {
        SHOW_THREAD = showThread;
    }

    public static int getMethodCount() {
        return (int) METHOD_COUNT;
    }

    public static void setMethodCount(int methodCount) {
        METHOD_COUNT = methodCount;
    }

    public static int getMethodOffset() {
        return (int) METHOD_OFFSET;
    }

    public static void setMethodOffset(int methodOffset) {
        METHOD_OFFSET = methodOffset;
    }

}
