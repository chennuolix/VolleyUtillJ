package com.luuu.commodule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by luuu on 2018/1/19.
 */

public class CommonUtils {

    /**
     * InputStream转成String
     *
     * @param inputStream
     * @return
     */
    public static String convertStreamToString(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    /**
     * InputStream转成String
     * 附带换行符
     *
     * @param inputStream
     * @return
     */
    public static String convertStreamToStringWithLine(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 遍历Map的接口
     */
    public interface MapForEachCallBack {
        void each(Object key, Object value);
    }

    /**
     * 遍历Map类型
     *
     * @param map
     * @param callBack
     */
    public static void forEachMap(Map<?, ?> map, MapForEachCallBack callBack) {
        if (map != null && map.size() > 0 && callBack != null) {
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                callBack.each(entry.getKey(), entry.getValue());
            }
        }
    }

}
