package com.volleyutil.weiwei.VolleyUtilJ;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.volleyutil.weiwei.VolleyUtilJ.RequestCallBack.JSONArrayRequestCallBack;
import com.volleyutil.weiwei.VolleyUtilJ.RequestCallBack.JSONObjectRequestCallBack;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by Administrator on 2017/9/29.
 */

public class VolleyJsonUtilJ {

    private static VolleyJsonUtilJ instance = null;
    private Context mContext;
    private RequestQueue requestQueue;

    private VolleyJsonUtilJ(Context context) {
        mContext = context;
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
    }

    public static synchronized VolleyJsonUtilJ getInstance(Context context) {
        if (instance == null) {
            instance = new VolleyJsonUtilJ(context);
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
     * new JsonObjectRequest and init it
     *
     * @param method
     * @param url
     * @param requestData
     * @param listener
     * @return
     */
    private JsonObjectRequest initJsonObjectRequest(int method, String url, final Map<String, String> requestData, final JSONObjectRequestCallBack listener) {
        return new JsonObjectRequest(method, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        if (listener != null) {
                            listener.successCallBack(jsonObject);
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
     * GET JsonObjectRequest
     *
     * @param url
     * @param listener
     */
    public void startGETJsonObjectRequest(String url, JSONObjectRequestCallBack listener) {
        JsonObjectRequest jsonObjectRequest = initJsonObjectRequest(Request.Method.GET, url, null, listener);
        requestQueue.add(jsonObjectRequest);
    }

    /**
     * POST JsonObjectRequest
     *
     * @param url
     * @param requestData
     * @param listener
     */
    public void startPOSTJsonObjectRequest(String url, Map<String, String> requestData, JSONObjectRequestCallBack listener) {
        JsonObjectRequest jsonObjectRequest = initJsonObjectRequest(Request.Method.POST, url, requestData, listener);
        requestQueue.add(jsonObjectRequest);
    }

    /**
     * new JsonArrayRequest and init it
     *
     * @param method
     * @param url
     * @param requestData
     * @param listener
     * @return
     */
    private JsonArrayRequest initJsonArrayRequest(int method, String url, final Map<String, String> requestData, final JSONArrayRequestCallBack listener) {
        return new JsonArrayRequest(method, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        if (listener != null) {
                            listener.successCallBack(jsonArray);
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
     * GET JsonArrayRequest
     *
     * @param url
     * @param listener
     */
    public void startGETJsonArrayRequest(String url, JSONArrayRequestCallBack listener) {
        JsonArrayRequest jsonArrayRequest = initJsonArrayRequest(Request.Method.GET, url, null, listener);
        requestQueue.add(jsonArrayRequest);
    }

    /**
     * POST JsonArrayRequest
     *
     * @param url
     * @param requestData
     * @param listener
     */
    public void startPOSTJsonArrayRequest(String url, Map<String, String> requestData, JSONArrayRequestCallBack listener) {
        JsonArrayRequest jsonArrayRequest = initJsonArrayRequest(Request.Method.POST, url, requestData, listener);
        requestQueue.add(jsonArrayRequest);
    }


}
