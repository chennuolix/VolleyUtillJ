package com.luuu.netmodule.VolleyUtilJ;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.luuuu.netmodule.R;

import java.util.Map;

import com.luuu.netmodule.VolleyUtilJ.RequestCallBack.ImageRequestCallBack;

/**
 * Created by Administrator on 2017/9/29.
 */

public class VolleyImageUtilJ {

    private static VolleyImageUtilJ instance = null;
    private Context mContext;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;

    private VolleyImageUtilJ(Context context) {
        mContext = context;
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        if (imageLoader == null) {
            imageLoader = new ImageLoader(requestQueue, new BitmapCache());
        }
    }

    public static synchronized VolleyImageUtilJ getInstance(Context context) {
        if (instance == null){
            synchronized (VolleyImageUtilJ.class){
                if (instance == null) {
                    instance = new VolleyImageUtilJ(context);
                }
            }
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
     * new ImageRequest and init it
     *
     * @param url
     * @param maxWidth
     * @param maxHeight
     * @param scaleType
     * @param config
     * @param imageView
     * @param requestData
     * @param listener
     * @return
     */
    private ImageRequest initImageRequest(final String url, int maxWidth, int maxHeight, ImageView.ScaleType scaleType, Bitmap.Config config, final ImageView imageView, final Map<String, String> requestData, final ImageRequestCallBack listener) {
        return new ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        if (imageView == null) {
                            if (listener != null) {
                                listener.successCallBack(bitmap);
                            }
                        } else {
                            imageView.setImageBitmap(bitmap);
                        }
                    }
                }, maxWidth, maxHeight, scaleType, config,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        if (listener != null) {
                            VolleyErrorManager volleyErrorManager = new VolleyErrorManager();
                            volleyErrorManager.setVolleyError(volleyError);
                            listener.failCallBack(volleyErrorManager);
                        }
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return requestData == null ? super.getParams() : requestData;
            }
        };
    }

    /**
     * GET ImageRequest with CallBack
     *
     * @param url
     * @param listener
     */
    public void startGETImageRequest(String url, ImageRequestCallBack listener) {
        ImageRequest imageRequest = initImageRequest(url, 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, null, null, listener);
        requestQueue.add(imageRequest);
    }

    /**
     * GET ImageRequest with CallBack and maxWidth,maxHeight
     *
     * @param url
     * @param maxWidth
     * @param maxHeight
     * @param listener
     */
    public void startGETImageRequest(String url, int maxWidth, int maxHeight, ImageRequestCallBack listener) {
        ImageRequest imageRequest = initImageRequest(url, maxWidth, maxHeight, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, null, null, listener);
        requestQueue.add(imageRequest);
    }

    /**
     * GET ImageRequest with CallBack and maxWidth,maxHeight and ScaleType,Config
     *
     * @param url
     * @param maxWidth
     * @param maxHeight
     * @param scaleType
     * @param config
     * @param listener
     */
    public void startGETImageRequest(String url, int maxWidth, int maxHeight, ImageView.ScaleType scaleType, Bitmap.Config config, ImageRequestCallBack listener) {
        ImageRequest imageRequest = initImageRequest(url, maxWidth, maxHeight, scaleType, config, null, null, listener);
        requestQueue.add(imageRequest);
    }

    /**
     * GET ImageRequest with ImageView and maxWidth,maxHeight
     *
     * @param url
     * @param maxWidth
     * @param maxHeight
     * @param imageView
     */
    public void startGETImageRequest(String url, int maxWidth, int maxHeight, ImageView imageView) {
        ImageRequest imageRequest = initImageRequest(url, maxWidth, maxHeight, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, imageView, null, null);
        requestQueue.add(imageRequest);
    }

    /**
     * GET ImageRequest with ImageView and maxWidth,maxHeight and ScaleType,Config
     *
     * @param url
     * @param maxWidth
     * @param maxHeight
     * @param scaleType
     * @param config
     * @param imageView
     */
    public void startGETImageRequest(String url, int maxWidth, int maxHeight, ImageView.ScaleType scaleType, Bitmap.Config config, ImageView imageView) {
        ImageRequest imageRequest = initImageRequest(url, maxWidth, maxHeight, scaleType, config, imageView, null, null);
        requestQueue.add(imageRequest);
    }

    /**
     * POST ImageRequest with ImageView
     *
     * @param url
     * @param imageView
     * @param requestData
     */
    public void startPOSTImageRequest(String url, ImageView imageView, Map<String, String> requestData) {
        ImageRequest imageRequest = initImageRequest(url, 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, imageView, requestData, null);
        requestQueue.add(imageRequest);
    }

    /**
     * POST ImageRequest with CallBack
     *
     * @param url
     * @param listener
     * @param requestData
     */
    public void startPOSTImageRequest(String url, ImageRequestCallBack listener, Map<String, String> requestData) {
        ImageRequest imageRequest = initImageRequest(url, 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, null, requestData, listener);
        requestQueue.add(imageRequest);
    }

    /**
     * POST ImageRequest with ImageView and maxWidth,maxHeight
     *
     * @param url
     * @param maxWidth
     * @param maxHeight
     * @param imageView
     * @param requestData
     */
    public void startPOSTImageRequest(String url, int maxWidth, int maxHeight, ImageView imageView, Map<String, String> requestData) {
        ImageRequest imageRequest = initImageRequest(url, maxWidth, maxHeight, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, imageView, requestData, null);
        requestQueue.add(imageRequest);
    }

    /**
     * POST ImageRequest with CallBack and maxWidth,maxHeight
     *
     * @param url
     * @param maxWidth
     * @param maxHeight
     * @param listener
     * @param requestData
     */
    public void startPOSTImageRequest(String url, int maxWidth, int maxHeight, ImageRequestCallBack listener, Map<String, String> requestData) {
        ImageRequest imageRequest = initImageRequest(url, maxWidth, maxHeight, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, null, requestData, listener);
        requestQueue.add(imageRequest);
    }

    /**
     * POST ImageRequest with ImageView and maxWidth,maxHeight and ScaleType,Config
     *
     * @param url
     * @param maxWidth
     * @param maxHeight
     * @param scaleType
     * @param config
     * @param imageView
     * @param requestData
     */
    public void startPOSTImageRequest(String url, int maxWidth, int maxHeight, ImageView.ScaleType scaleType, Bitmap.Config config, ImageView imageView, Map<String, String> requestData) {
        ImageRequest imageRequest = initImageRequest(url, maxWidth, maxHeight, scaleType, config, imageView, requestData, null);
        requestQueue.add(imageRequest);
    }

    /**
     * POST ImageRequest with CallBack and maxWidth,maxHeight and ScaleType,Config
     *
     * @param url
     * @param maxWidth
     * @param maxHeight
     * @param scaleType
     * @param config
     * @param listener
     * @param requestData
     */
    public void startPOSTImageRequest(String url, int maxWidth, int maxHeight, ImageView.ScaleType scaleType, Bitmap.Config config, ImageRequestCallBack listener, Map<String, String> requestData) {
        ImageRequest imageRequest = initImageRequest(url, maxWidth, maxHeight, scaleType, config, null, requestData, listener);
        requestQueue.add(imageRequest);
    }

    /**
     * new ImageListener and init it
     *
     * @param imageView
     * @param defaultImg
     * @param failImg
     * @return
     */
    private ImageLoader.ImageListener initImageListener(ImageView imageView, int defaultImg, int failImg) {
        return ImageLoader.getImageListener(imageView, defaultImg, failImg);
    }

    /**
     * Image load with default image
     *
     * @param url
     * @param imageView
     */
    public void startImageLoaderRequest(String url, ImageView imageView) {
        ImageLoader.ImageListener imageListener = initImageListener(imageView, R.drawable.ic_launcher, R.drawable.ic_launcher);
        imageLoader.get(url, imageListener);
    }

    /**
     * Image loader with appoint image
     *
     * @param url
     * @param imageView
     * @param defaultImg
     * @param failImg
     */
    public void startImageLoaderRequest(String url, ImageView imageView, int defaultImg, int failImg) {
        ImageLoader.ImageListener imageListener = initImageListener(imageView, defaultImg, failImg);
        imageLoader.get(url, imageListener);
    }

}
