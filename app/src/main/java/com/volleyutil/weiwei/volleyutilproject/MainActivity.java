package com.volleyutil.weiwei.volleyutilproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.luuu.logmodule.LoggerUtil;
import com.luuu.netmodule.VolleyUtilJ.RequestCallBack.StringRequestCallBack;
import com.luuu.netmodule.VolleyUtilJ.VolleyErrorManager;
import com.luuu.netmodule.VolleyUtilJ.VolleyImageUtilJ;
import com.luuu.netmodule.VolleyUtilJ.VolleyStringUtilJ;

import java.util.HashMap;


public class MainActivity extends Activity implements View.OnClickListener {

    private final String TAG_STRING_SUCCESS = "string response:";
    private final String TAG_STRING_FAIL = "string fail response:";

    private ImageView imageView;
    private Button btnToQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LoggerUtil.d("MainActivity onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        VolleyStringUtilJ.getInstance(this).startGETStringRequest("http://www.baidu.com", new StringRequestCallBack() {
            @Override
            public void successCallBack(String s) {
                Log.d(TAG_STRING_SUCCESS, s);
            }

            @Override
            public void failCallBack(VolleyErrorManager volleyError) {

            }
        });
        VolleyImageUtilJ.getInstance(this).startImageLoaderRequest("http://img2.imgtn.bdimg.com/it/u=3895206830,2289042136&fm=27&gp=0.jpg", imageView);
        HashMap<String, String> testMap = new HashMap<>();
        testMap.put("key1", "value1");
        testMap.put("key2", "value2");
        testMap.put("key3", "value3");
        LoggerUtil.d(testMap);
        LoggerUtil.d("my self tag", testMap);
    }

    private void initView() {
        LoggerUtil.d("my self tag:", "MainActivity initView()");
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
