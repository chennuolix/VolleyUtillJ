package com.luuu.datamodule.SPDataUtilJ;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

/**
 * Created by luuu on 2018/1/19.
 */

public class SPManager {

    private static SPManager instance;
    private static String spName;

    /**
     * 单例
     *
     * @return
     */
    public static SPManager getInstance() {
        if (instance == null) {
            synchronized (SPManager.class) {
                if (instance == null) {
                    return new SPManager();
                }
            }
        }
        return null;
    }

    /**
     * 设置默认spName
     *
     * @param spName
     */
    public void setSpName(String spName) {
        SPManager.spName = spName;
    }

    /**
     * 保存int类型数据
     * 使用appConfig默认spName
     *
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static boolean saveIntSPValue(Context context, String key, int value) {
        return saveIntSPValue(context, spName, key, value);
    }

    /**
     * 保存int类型数据
     * 使用自定义spName
     * 默认spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param value
     * @return
     */
    public static boolean saveIntSPValue(Context context, String spName, String key, int value) {
        return saveIntSPValue(context, spName, key, value, Context.MODE_PRIVATE);
    }

    /**
     * 保存int类型数据
     * 使用自定义spName、spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param value
     * @return
     */
    public static boolean saveIntSPValue(Context context, String spName, String key, int value, int spMode) {
        if (context == null) {
            return false;
        }

        SharedPreferences.Editor editor = context.getSharedPreferences(spName, spMode).edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    /**
     * 获取int数据
     * 使用appConfig默认的spName
     * 自定义defaultValue
     *
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getIntSPValue(Context context, String key, int defaultValue) {
        return getIntSPValue(context, spName, key, defaultValue);
    }

    /**
     * 获取int数据
     * 使用自定义的spName
     * 自定义defaultValue
     * 默认spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getIntSPValue(Context context, String spName, String key, int defaultValue) {
        return getIntSPValue(context, spName, key, Context.MODE_PRIVATE, defaultValue);
    }

    /**
     * 获取int数据
     * 使用自定义的spName
     * 自定义defaultValue
     * 自定义spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param spMode
     * @param defaultValue
     * @return
     */
    public static int getIntSPValue(Context context, String spName, String key, int spMode, int defaultValue) {
        int value = defaultValue;
        if (context == null) {
            return value;
        }

        SharedPreferences sharedPreferences = context.getSharedPreferences(spName, spMode);
        if (sharedPreferences != null) {
            value = sharedPreferences.getInt(key, defaultValue);
        }
        return value;
    }

    /**
     * 保存long类型数据
     * 使用appConfig默认spName
     *
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static boolean saveLongSPValue(Context context, String key, long value) {
        return saveLongSPValue(context, spName, key, value);
    }

    /**
     * 保存long类型数据
     * 使用自定义spName
     * 默认spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param value
     * @return
     */
    public static boolean saveLongSPValue(Context context, String spName, String key, long value) {
        return saveLongSPValue(context, spName, key, value, Context.MODE_PRIVATE);
    }

    /**
     * 保存long类型数据
     * 使用自定义spName、spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param value
     * @return
     */
    public static boolean saveLongSPValue(Context context, String spName, String key, long value, int spMode) {
        if (context == null) {
            return false;
        }

        SharedPreferences.Editor editor = context.getSharedPreferences(spName, spMode).edit();
        editor.putLong(key, value);
        return editor.commit();
    }

    /**
     * 获取long数据
     * 使用appConfig默认的spName
     * 自定义defaultValue
     *
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static long getLongSPValue(Context context, String key, long defaultValue) {
        return getLongSPValue(context, spName, key, defaultValue);
    }

    /**
     * 获取long数据
     * 使用自定义的spName
     * 自定义defaultValue
     * 默认spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param defaultValue
     * @return
     */
    public static long getLongSPValue(Context context, String spName, String key, long defaultValue) {
        return getLongSPValue(context, spName, key, Context.MODE_PRIVATE, defaultValue);
    }

    /**
     * 获取long数据
     * 使用自定义的spName
     * 自定义defaultValue
     * 自定义spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param spMode
     * @param defaultValue
     * @return
     */
    public static long getLongSPValue(Context context, String spName, String key, int spMode, long defaultValue) {
        long value = defaultValue;
        if (context == null) {
            return value;
        }

        SharedPreferences sharedPreferences = context.getSharedPreferences(spName, spMode);
        if (sharedPreferences != null) {
            value = sharedPreferences.getLong(key, defaultValue);
        }
        return value;
    }

    /**
     * 保存float类型数据
     * 使用appConfig默认spName
     *
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static boolean saveFloatSPValue(Context context, String key, float value) {
        return saveFloatSPValue(context, spName, key, value);
    }

    /**
     * 保存float类型数据
     * 使用自定义spName
     * 默认spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param value
     * @return
     */
    public static boolean saveFloatSPValue(Context context, String spName, String key, float value) {
        return saveFloatSPValue(context, spName, key, value, Context.MODE_PRIVATE);
    }

    /**
     * 保存float类型数据
     * 使用自定义spName、spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param value
     * @return
     */
    public static boolean saveFloatSPValue(Context context, String spName, String key, float value, int spMode) {
        if (context == null) {
            return false;
        }

        SharedPreferences.Editor editor = context.getSharedPreferences(spName, spMode).edit();
        editor.putFloat(key, value);
        return editor.commit();
    }

    /**
     * 获取float数据
     * 使用appConfig默认的spName
     * 自定义defaultValue
     *
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static float getFloatSPValue(Context context, String key, float defaultValue) {
        return getFloatSPValue(context, spName, key, defaultValue);
    }

    /**
     * 获取float数据
     * 使用自定义的spName
     * 自定义defaultValue
     * 默认spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param defaultValue
     * @return
     */
    public static float getFloatSPValue(Context context, String spName, String key, float defaultValue) {
        return getFloatSPValue(context, spName, key, Context.MODE_PRIVATE, defaultValue);
    }

    /**
     * 获取float数据
     * 使用自定义的spName
     * 自定义defaultValue
     * 自定义spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param spMode
     * @param defaultValue
     * @return
     */
    public static float getFloatSPValue(Context context, String spName, String key, int spMode, float defaultValue) {
        float value = defaultValue;
        if (context == null) {
            return value;
        }

        SharedPreferences sharedPreferences = context.getSharedPreferences(spName, spMode);
        if (sharedPreferences != null) {
            value = sharedPreferences.getFloat(key, defaultValue);
        }
        return value;
    }

    /**
     * 保存boolean类型数据
     * 使用appConfig默认spName
     *
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static boolean saveBoolSPValue(Context context, String key, boolean value) {
        return saveBoolSPValue(context, spName, key, value);
    }

    /**
     * 保存boolean类型数据
     * 使用自定义spName
     * 默认spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param value
     * @return
     */
    public static boolean saveBoolSPValue(Context context, String spName, String key, boolean value) {
        return saveBoolSPValue(context, spName, key, value, Context.MODE_PRIVATE);
    }

    /**
     * 保存boolean类型数据
     * 使用自定义spName、spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param value
     * @return
     */
    public static boolean saveBoolSPValue(Context context, String spName, String key, boolean value, int spMode) {
        if (context == null) {
            return false;
        }

        SharedPreferences.Editor editor = context.getSharedPreferences(spName, spMode).edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    /**
     * 获取boolean数据
     * 使用appConfig默认的spName
     * 自定义defaultValue
     *
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static boolean getBoolSPValue(Context context, String key, boolean defaultValue) {
        return getBoolSPValue(context, spName, key, defaultValue);
    }

    /**
     * 获取boolean数据
     * 使用自定义的spName
     * 自定义defaultValue
     * 默认spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param defaultValue
     * @return
     */
    public static boolean getBoolSPValue(Context context, String spName, String key, boolean defaultValue) {
        return getBoolSPValue(context, spName, key, Context.MODE_PRIVATE, defaultValue);
    }

    /**
     * 获取boolean数据
     * 使用自定义的spName
     * 自定义defaultValue
     * 自定义spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param spMode
     * @param defaultValue
     * @return
     */
    public static boolean getBoolSPValue(Context context, String spName, String key, int spMode, boolean defaultValue) {
        boolean value = defaultValue;
        if (context == null) {
            return value;
        }

        SharedPreferences sharedPreferences = context.getSharedPreferences(spName, spMode);
        if (sharedPreferences != null) {
            value = sharedPreferences.getBoolean(key, defaultValue);
        }
        return value;
    }

    /**
     * 保存String数据
     * 使用appConfig默认的spName
     *
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static boolean saveStringSPValue(Context context, String key, String value) {
        return saveStringSPValue(context, spName, key, value);
    }

    /**
     * 保存String数据
     * 使用自定义的spName
     * 默认的spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param value
     * @return
     */
    public static boolean saveStringSPValue(Context context, String spName, String key, String value) {
        return saveStringSPValue(context, spName, key, value, Context.MODE_PRIVATE);
    }

    /**
     * 保存String数据
     * 使用自定义的spName、spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param value
     * @param spMode
     * @return
     */
    public static boolean saveStringSPValue(Context context, String spName, String key, String value, int spMode) {
        if (context == null) {
            return false;
        }

        SharedPreferences.Editor editor = context.getSharedPreferences(spName, spMode).edit();
        editor.putString(key, value);
        return editor.commit();
    }

    /**
     * 获取String数据
     * 使用appConfig默认的spName
     * 自定义defaultValue
     *
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getStringSPValue(Context context, String key, String defaultValue) {
        return getStringSPValue(context, spName, key, defaultValue);
    }

    /**
     * 获取String数据
     * 使用自定义的spName
     * 自定义defaultValue
     * 默认spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getStringSPValue(Context context, String spName, String key, String defaultValue) {
        return getStringSPValue(context, spName, key, Context.MODE_PRIVATE, defaultValue);
    }

    /**
     * 获取String数据
     * 使用自定义的spName
     * 自定义defaultValue
     * 自定义spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param spMode
     * @param defaultValue
     * @return
     */
    public static String getStringSPValue(Context context, String spName, String key, int spMode, String defaultValue) {
        String value = defaultValue;
        if (context == null) {
            return value;
        }

        SharedPreferences sharedPreferences = context.getSharedPreferences(spName, spMode);
        if (sharedPreferences != null) {
            value = sharedPreferences.getString(key, defaultValue);
        }
        return value;
    }

    /**
     * 保存Object数据
     * 使用appConfig默认的spName
     *
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static boolean saveObjSPValue(Context context, String key, Object value) {
        return saveObjSPValue(context, spName, key, value);
    }

    /**
     * 保存Object数据
     * 使用自定义的spName
     * 默认的spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param value
     * @return
     */
    public static boolean saveObjSPValue(Context context, String spName, String key, Object value) {
        return saveObjSPValue(context, spName, key, value, Context.MODE_PRIVATE);
    }

    /**
     * 保存Object数据
     * 使用自定义的spName、spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param value
     * @param spMode
     * @return
     */
    public static boolean saveObjSPValue(Context context, String spName, String key, Object value, int spMode) {
        if (context == null) {
            return false;
        }

        try {
            // 保存对象
            SharedPreferences.Editor editor = context.getSharedPreferences(spName, spMode).edit();
            //先将序列化结果写到byte缓存中，其实就分配一个内存空间
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(bos);
            //将对象序列化写入byte缓存
            os.writeObject(value);
            //将序列化的数据转为16进制保存
            String bytesToHexString = bytesToHexString(bos.toByteArray());
            //保存该16进制数组
            editor.putString(key, bytesToHexString);
            return editor.commit();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取Object数据
     * 使用appConfig默认的spName
     * 自定义defaultValue
     *
     * @param context
     * @param key
     * @return
     */
    public static Object getObjSPValue(Context context, String key) {
        return getObjSPValue(context, spName, key);
    }

    /**
     * 获取Object数据
     * 使用自定义的spName
     * 自定义defaultValue
     * 默认spMode
     *
     * @param context
     * @param spName
     * @param key
     * @return
     */
    public static Object getObjSPValue(Context context, String spName, String key) {
        return getObjSPValue(context, spName, key, Context.MODE_PRIVATE);
    }

    /**
     * 获取Object数据
     * 使用自定义的spName
     * 自定义defaultValue
     * 自定义spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param spMode
     * @return
     */
    public static Object getObjSPValue(Context context, String spName, String key, int spMode) {
        if (context == null) {
            return null;
        }

        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(spName, spMode);
            if (sharedPreferences.contains(key)) {
                String string = sharedPreferences.getString(key, "");
                if (TextUtils.isEmpty(string)) {
                    return null;
                } else {
                    //将16进制的数据转为数组，准备反序列化
                    byte[] stringToBytes = StringToBytes(string);
                    ByteArrayInputStream bis = new ByteArrayInputStream(stringToBytes);
                    ObjectInputStream is = new ObjectInputStream(bis);
                    //返回反序列化得到的对象
                    return is.readObject();
                }
            }
        } catch (StreamCorruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //所有异常返回null
        return null;
    }

    /**
     * 将数组转为16进制
     *
     * @param bArray
     * @return
     */
    private static String bytesToHexString(byte[] bArray) {
        if (bArray == null) {
            return null;
        }
        if (bArray.length == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制的数据转为数组
     *
     * @param data
     * @return
     */
    private static byte[] StringToBytes(String data) {
        String hexString = data.toUpperCase().trim();
        if (hexString.length() % 2 != 0) {
            return null;
        }
        byte[] retData = new byte[hexString.length() / 2];
        for (int i = 0; i < hexString.length(); i++) {
            int int_ch;  // 两位16进制数转化后的10进制数
            char hex_char1 = hexString.charAt(i); ////两位16进制数中的第一位(高位*16)
            int int_ch3;
            if (hex_char1 >= '0' && hex_char1 <= '9')
                int_ch3 = (hex_char1 - 48) * 16;   //// 0 的Ascll - 48
            else if (hex_char1 >= 'A' && hex_char1 <= 'F')
                int_ch3 = (hex_char1 - 55) * 16; //// A 的Ascll - 65
            else
                return null;
            i++;
            char hex_char2 = hexString.charAt(i); ///两位16进制数中的第二位(低位)
            int int_ch4;
            if (hex_char2 >= '0' && hex_char2 <= '9')
                int_ch4 = (hex_char2 - 48); //// 0 的Ascll - 48
            else if (hex_char2 >= 'A' && hex_char2 <= 'F')
                int_ch4 = hex_char2 - 55; //// A 的Ascll - 65
            else
                return null;
            int_ch = int_ch3 + int_ch4;
            retData[i / 2] = (byte) int_ch;//将转化后的数放入Byte里
        }
        return retData;
    }

    /**
     * 删除SP键值对应的spValue
     * 使用appConfig默认的spName
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean removeSPValue(Context context, String key) {
        return removeSPValue(context, spName, key);
    }

    /**
     * 删除SP键值对应的spValue
     * 使用自定义的spName
     * 默认的spMode
     *
     * @param context
     * @param spName
     * @param key
     * @return
     */
    public static boolean removeSPValue(Context context, String spName, String key) {
        return removeSPValue(context, spName, key, Context.MODE_PRIVATE);
    }

    /**
     * 删除SP键值对应的spValue
     * 使用自定义的spName、spMode
     *
     * @param context
     * @param spName
     * @param key
     * @param spMode
     * @return
     */
    public static boolean removeSPValue(Context context, String spName, String key, int spMode) {
        if (context == null) {
            return false;
        }

        SharedPreferences.Editor editor = context.getSharedPreferences(spName, spMode).edit();
        editor.remove(key);
        return editor.commit();
    }

}