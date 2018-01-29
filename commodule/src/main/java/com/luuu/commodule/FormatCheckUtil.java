package com.luuu.commodule;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by luuu on 2018/1/29.
 */

public class FormatCheckUtil {

    private static final String DEFAULT_FILE_PATH = "formatCheck.json";      //默认的格式检查配置文件路径
    private static FormatCheckUtil instance;
    private JSONObject jsonObject = null;
    private Context mContext;

    private FormatCheckUtil(Context context, String filePath) {
        mContext = context;
        AssetManager assetManager = context.getAssets();
        InputStream inputStream;
        String jsonString;
        try {
            inputStream = assetManager.open(filePath);
            if (inputStream != null) {
                jsonString = CommonUtils.convertStreamToString(inputStream);
                jsonObject = new JSONObject(jsonString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 自定义检查格式文件路径
     *
     * @param context
     * @param filePath
     * @return
     */
    public static FormatCheckUtil getInstance(Context context, String filePath) {
        if (instance == null) {
            synchronized (FormatCheckUtil.class) {
                if (instance == null) {
                    instance = new FormatCheckUtil(context, filePath);
                }
            }
        }
        return instance;
    }

    /**
     * 默认的检查格式配置文件的路径
     *
     * @param context
     * @return
     */
    public static FormatCheckUtil getInstance(Context context) {
        if (instance == null) {
            synchronized (FormatCheckUtil.class) {
                if (instance == null) {
                    instance = new FormatCheckUtil(context, DEFAULT_FILE_PATH);
                }
            }
        }
        return instance;
    }

    /**
     * 检查格式正确定
     *
     * @param type     检查的类型
     * @param checkStr 检查的字符串
     * @return
     */
    public boolean check(String type, String checkStr) {
        if (!TextUtils.isEmpty(type) && !TextUtils.isEmpty(checkStr)) {
            if (jsonObject != null) {
                JSONObject typeItem = jsonObject.optJSONObject(type);
                if (typeItem != null) {
                    JSONArray patternArray = typeItem.optJSONArray("patternString");
                    String tip = typeItem.optString("tip", "");
                    int minLength = typeItem.optInt("minLength", 0);
                    if (!checkMinLength(minLength, checkStr)) {
                        showTip(tip);
                        return false;
                    }
                    int maxLength = typeItem.optInt("maxLength", 0);
                    if (!checkMaxLength(maxLength, checkStr)) {
                        showTip(tip);
                        return false;
                    }
                    if (patternArray != null && patternArray.length() > 0) {
                        for (int i = 0; i < patternArray.length(); i++) {
                            Pattern pattern = Pattern.compile(patternArray.optString(i));
                            Matcher matcher = pattern.matcher(checkStr);
                            if (!matcher.matches()) {
                                showTip(tip);
                                return false;
                            }
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /**
     * 检查最短长度，如果最短程度小于等于0，不检查
     *
     * @param minLength
     * @param checkStr
     * @return
     */
    private boolean checkMinLength(int minLength, String checkStr) {
        if (minLength > 0) {
            if (minLength > checkStr.length()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查最长长度，如果最长长度小于等于0 ，不检查
     *
     * @param maxLength
     * @param checkStr
     * @return
     */
    private boolean checkMaxLength(int maxLength, String checkStr) {
        if (maxLength > 0) {
            if (maxLength < checkStr.length()) {
                return false;
            }
        }
        return true;
    }

    private void showTip(String tip) {
        ToastManager.showShortTip(mContext, tip);
    }

}
