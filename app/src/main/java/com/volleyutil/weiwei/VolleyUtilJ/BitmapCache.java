package com.volleyutil.weiwei.VolleyUtilJ;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by Administrator on 2017/9/27.
 */

public class BitmapCache implements ImageLoader.ImageCache {


    private LruCache<String, Bitmap> mCache;

    /**
     * the default max size of cache is 10M.
     */
    public BitmapCache() {
        int maxSize = 10 * 1024 * 1024;
        mCache = new LruCache<String, Bitmap>(maxSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
    }

    /**
     * mSize is the max size of cache, unit is M.
     *
     * @param mSize
     */
    public BitmapCache(int mSize) {
        int maxSize = mSize * 1024 * 1024;
        mCache = new LruCache<String, Bitmap>(maxSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
    }

    @Override
    public Bitmap getBitmap(String url) {
        return mCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        mCache.put(url, bitmap);
    }

}
