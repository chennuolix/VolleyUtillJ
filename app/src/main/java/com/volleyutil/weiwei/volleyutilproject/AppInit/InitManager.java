package com.volleyutil.weiwei.volleyutilproject.AppInit;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.luuu.commodule.CommonUtils;
import com.luuu.datamodule.SPDataUtilJ.SPManager;
import com.luuu.logmodule.LoggerManager;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.logging.LogManager;

/**
 * Created by luuu on 2018/1/19.
 */

public class InitManager {

    private static AppInitListener appInitListener = null;

    /**
     * 初始化
     *
     * @param context
     */
    public static void init(Context context) {
        initAppConfig(context);
        initSP();
        initLoggerManager();
        if (appInitListener != null) {
            appInitListener.initSuccess();
        }
    }

    public static void setAppInitListener(AppInitListener appInitListener) {
        InitManager.appInitListener = appInitListener;
    }

    public interface AppInitListener {

        void initSuccess();

        void initFail(String failStr);
    }

    /**
     * 初始化App配置文件
     *
     * @param context
     */
    private static void initAppConfig(Context context) {
        try {
            InputStream inputStream = context.getAssets().open("appConfig.json");
            String json = CommonUtils.convertStreamToString(inputStream);
            if (!TextUtils.isEmpty(json)) {
                Gson gson = new Gson();
                LinkedTreeMap<String, Object> appConfig = (LinkedTreeMap<String, Object>) gson.fromJson(json, Object.class);
                if (appConfig.containsKey("appInit")) {
                    Class appConfigClass = AppConfig.class;
                    LinkedTreeMap<String, String> appInit = (LinkedTreeMap<String, String>) appConfig.get("appInit");
                    parseConfigMap(appInit, appConfigClass);
                }
                if (appConfig.containsKey("logInit")) {
                    Class loggerManagerClass = LoggerManager.class;
                    LinkedTreeMap<String, String> logInit = (LinkedTreeMap<String, String>) appConfig.get("logInit");
                    parseConfigMap(logInit, loggerManagerClass);
                }
            }
            String sp_name = AppConfig.getSpName();
            Log.d("TAG", sp_name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 利用反射直接设置AppConfig的属性
     *
     * @param map
     * @param clazz
     */
    private static void parseConfigMap(Map<?, ?> map, final Class clazz) {
        CommonUtils.forEachMap(map, new CommonUtils.MapForEachCallBack() {
            @Override
            public void each(Object key, Object value) {
                try {
                    Field field;
                    if (value instanceof String) {
                        field = clazz.getDeclaredField(String.valueOf(key));
                        field.setAccessible(true);
                        field.set(clazz, value);
                    } else if (value instanceof Integer) {
                        field = clazz.getDeclaredField(String.valueOf(key));
                        field.setAccessible(true);
                        field.setInt(clazz, Integer.valueOf(String.valueOf(value)));
                    } else if (value instanceof Boolean) {
                        field = clazz.getDeclaredField(String.valueOf(key));
                        field.setAccessible(true);
                        field.setBoolean(clazz, Boolean.valueOf(String.valueOf(value)));
                    } else if (value instanceof Double) {
                        field = clazz.getDeclaredField(String.valueOf(key));
                        field.setAccessible(true);
                        field.setDouble(clazz, Double.valueOf(String.valueOf(value)));
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 初始化SP相关
     */
    private static void initSP() {
        SPManager.getInstance().setSpName(AppConfig.getSpName());
    }

    /**
     * 初始化Log相关
     */
    private static void initLoggerManager() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(LoggerManager.isShowThread())
                .methodCount(LoggerManager.getMethodCount())
                .methodOffset(LoggerManager.getMethodOffset())
                .tag(LoggerManager.getTagName())
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }
}
