package com.volleyutil.weiwei.volleyutilproject.Utils;

import android.text.TextUtils;

import com.volleyutil.weiwei.volleyutilproject.AppInit.AppConfig;

/**
 * Created by luuu on 2018/1/22.
 */

class AppUtils {

    /**
     * 拼接url
     *
     * @param url
     * @return
     */
    public static String appendUrl(String url) {
        if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(AppConfig.getNetDomain())) {
            return AppConfig.getNetDomain() + url;
        }
        return url;
    }

}
