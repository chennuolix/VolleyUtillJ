package com.volleyutil.weiwei.volleyutilproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.volleyutil.weiwei.VolleyUtilJ.RequestCallBack.StringRequestCallBack;
import com.volleyutil.weiwei.VolleyUtilJ.VolleyStringUtilJ;

/**
 * Created by weiwei on 17-10-25.
 */

public class QueryPythonActivity extends Activity implements View.OnClickListener {

    private final String TAG = "QueryPythonActivity";

    private Button btnQuery;
    private TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quey_python);
        initView();
    }

    private void initView() {
        btnQuery = findViewById(R.id.btn_queryTest);
        tvResult = findViewById(R.id.tv_queryResult);
        btnQuery.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_queryTest:
                VolleyStringUtilJ.getInstance(this).startGETStringRequest("http://192.168.41.104:5000/", new StringRequestCallBack() {
                    @Override
                    public void successCallBack(String s) {
                        String result = s;
                        tvResult.setText(result);
                        Log.d(TAG, result);
                    }

                    @Override
                    public void failCallBack(VolleyError volleyError) {
                        Log.e(TAG, "request error");
                    }
                });
                break;
            default:
                Log.d(TAG, "other click");
                break;
        }
    }
}
