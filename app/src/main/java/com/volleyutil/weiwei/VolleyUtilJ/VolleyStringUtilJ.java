package com.volleyutil.weiwei.VolleyUtilJ;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.volleyutil.weiwei.VolleyUtilJ.RequestCallBack.StringRequestCallBack;

import java.util.Map;

/**
 * Created by Administrator on 2017/9/29.
 */

public class VolleyStringUtilJ {

    private static VolleyStringUtilJ instance = null;
    private Context mContext;
    private RequestQueue requestQueue;


    private VolleyStringUtilJ(Context context) {
        mContext = context;
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
    }

    public static synchronized VolleyStringUtilJ getInstance(Context context) {
        if (instance == null) {
            instance = new VolleyStringUtilJ(context);
        }
        return instance;
    }

    /**
     * return requestQueue
     *
     * @return
     */
    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return requestQueue;
    }

    /**
     * new StringRequest and init it
     *
     * @param method
     * @param url
     * @param requestData
     * @param listener
     * @return
     */
    private StringRequest initStringRequest(int method, String url, final Map<String, String> requestData, final StringRequestCallBack listener) {
        return new StringRequest(method, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if (listener != null) {
                            listener.successCallBack(s);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        if (listener != null) {
                            listener.failCallBack(volleyError);
                        }
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return requestData == null ? super.getParams() : requestData;
            }
        };
    }

    /**
     * GET StringRequest
     *
     * @param url
     * @param listener
     */
    public void startGETStringRequest(String url, StringRequestCallBack listener) {
        StringRequest stringRequest = initStringRequest(Request.Method.GET, url, null, listener);
        requestQueue.add(stringRequest);
    }

    /**
     * POST StringRequest
     *
     * @param url
     * @param requestData
     * @param listener
     */
    public void startPOSTStringRequest(String url, Map<String, String> requestData, StringRequestCallBack listener) {
        StringRequest stringRequest = initStringRequest(Request.Method.POST, url, requestData, listener);
        requestQueue.add(stringRequest);
    }
}
