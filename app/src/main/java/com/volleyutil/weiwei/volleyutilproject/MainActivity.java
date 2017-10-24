package com.volleyutil.weiwei.volleyutilproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.volleyutil.weiwei.VolleyUtilJ.RequestCallBack.StringRequestCallBack;
import com.volleyutil.weiwei.VolleyUtilJ.VolleyImageUtilJ;
import com.volleyutil.weiwei.VolleyUtilJ.VolleyStringUtilJ;

public class MainActivity extends Activity implements View.OnClickListener {

    private final String TAG_STRING_SUCCESS = "string response:";
    private final String TAG_STRING_FAIL = "string fail response:";

    private ImageView imageView;
    private Button btnToQuery;

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
        btnToQuery = findViewById(R.id.btn_toQuery);
        btnToQuery.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_toQuery:
                Intent intent = new Intent(this, QueryPythonActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
