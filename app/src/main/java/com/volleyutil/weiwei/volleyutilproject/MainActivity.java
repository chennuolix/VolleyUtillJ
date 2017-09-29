package com.volleyutil.weiwei.volleyutilproject;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.volleyutil.weiwei.VolleyUtilJ.RequestCallBack.StringRequestCallBack;
import com.volleyutil.weiwei.VolleyUtilJ.VolleyImageUtilJ;
import com.volleyutil.weiwei.VolleyUtilJ.VolleyStringUtilJ;

public class MainActivity extends Activity {

    private final String TAG_STRING_SUCCESS = "string response:";
    private final String TAG_STRING_FAIL = "string fail response:";

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        VolleyStringUtilJ.getInstance(this).startGETStringRequest("http://www.baidu.com", new StringRequestCallBack() {
            @Override
            public void successCallBack(String s) {
                Log.d(TAG_STRING_SUCCESS, s);
            }

            @Override
            public void failCallBack(VolleyError volleyError) {
                Log.d(TAG_STRING_FAIL, volleyError.getMessage());
            }
        });
        VolleyImageUtilJ.getInstance(this).startImageLoaderRequest("http://img2.imgtn.bdimg.com/it/u=3895206830,2289042136&fm=27&gp=0.jpg", imageView);
    }

    private void initView() {
        imageView = findViewById(R.id.img_request);
    }
}
