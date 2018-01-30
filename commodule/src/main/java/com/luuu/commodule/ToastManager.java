package com.luuu.commodule;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by luuu on 2018/1/29.
 */

public class ToastManager {

    private static String oldMessage = "";
    private static long firstTime = 0;     //第一次时间
    private static long secondTime = 0;    //第二次时间

    private static final int TIP_SHOW_SHORT = 3000;      //显示时长3秒
    private static final int TIP_SHOW_LONG = 5000;       //显示时长5秒
    private static Toast toast = null;

    /**
     * 展示短时间的toast
     *
     * @param context
     * @param tip
     */
    public static void showShortTip(Context context, String tip) {
        showNormalTip(context, tip, TIP_SHOW_SHORT, -1, 0, 0);
    }

    /**
     * 展示长时间的toast
     *
     * @param context
     * @param tip
     */
    public static void showLongTip(Context context, String tip) {
        showNormalTip(context, tip, TIP_SHOW_LONG, -1, 0, 0);
    }

    /**
     * 展示自定义时间的toast
     *
     * @param context
     * @param tip
     * @param duration
     */
    public static void showTimeTip(Context context, String tip, int duration) {
        showNormalTip(context, tip, duration, -1, 0, 0);
    }

    /**
     * 在一定时间内不重复展示相同内容
     * 自定义toast展示的位置
     *
     * @param context
     * @param tip
     * @param duration
     */
    public static void showNormalTip(Context context, String tip, int duration, int gravity, int offsetX, int offsetY) {
        if (toast == null) {
            toast = Toast.makeText(context, tip, duration);
            if (gravity >= 0) {
                toast.setGravity(gravity, offsetX, offsetY);
            }
            toast.show();
            firstTime = System.currentTimeMillis();
        } else {
            secondTime = System.currentTimeMillis();
            if (tip.equals(oldMessage)) {
                if (secondTime - firstTime > duration) {
                    toast.show();
                    firstTime = secondTime;
                }
            } else {
                oldMessage = tip;
                toast.setText(tip);
                toast.show();
                firstTime = secondTime;
            }
        }
    }

}
