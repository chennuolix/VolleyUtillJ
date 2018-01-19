package com.volleyutil.weiwei.volleyutilproject.AppInit;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.luuu.commodule.CommonUtils;
import com.luuu.datamodule.SPDataUtilJ.SPManager;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by luuu on 2018/1/19.
 */

public class InitManager {

    public static void init(Context context) {
        initApp(context);
        initSP();
    }

    private static void initApp(Context context) {
        try {
            InputStream inputStream = context.getAssets().open("appConfig.json");
            String json = CommonUtils.convertStreamToString(inputStream);
            if (!TextUtils.isEmpty(json)) {
                Gson gson = new Gson();
                LinkedTreeMap<String, Object> appConfig = (LinkedTreeMap<String, Object>) gson.fromJson(json, Object.class);
                if (appConfig.containsKey("appInit")) {
                    LinkedTreeMap<String, String> appInit = (LinkedTreeMap<String, String>) appConfig.get("appInit");
                    if (appInit.containsKey("sp_name")) {
                        AppConfig.setSpName(appInit.get("sp_name"));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initSP() {
        SPManager.getInstance().setSpName(AppConfig.getSpName());
    }

}