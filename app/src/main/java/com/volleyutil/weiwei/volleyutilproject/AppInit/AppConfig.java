package com.volleyutil.weiwei.volleyutilproject.AppInit;

/**
 * Created by luuu on 2018/1/19.
 */

public class AppConfig {

    private static String SP_NAME = "";       //SharedPreferences的名字
    private static String NET_DOMAIN = "";    //网络请求url前缀
    private static double THREAD_NUM = 0;     //线程个数
    private static boolean IS_PASS = false;

    public static String getSpName() {
        return SP_NAME;
    }

    public static void setSpName(String spName) {
        SP_NAME = spName;
    }

    public static String getNetDomain() {
        return NET_DOMAIN;
    }

    public static void setNetDomain(String netDomain) {
        NET_DOMAIN = netDomain;
    }

    public static int getThreadNum() {
        return (int) THREAD_NUM;
    }

    public static void setThreadNum(int threadNum) {
        THREAD_NUM = threadNum;
    }

    public static boolean isIsPass() {
        return IS_PASS;
    }

    public static void setIsPass(boolean isPass) {
        IS_PASS = isPass;
    }

}
