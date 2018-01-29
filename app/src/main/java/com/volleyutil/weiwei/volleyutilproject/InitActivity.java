package com.volleyutil.weiwei.volleyutilproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.volleyutil.weiwei.volleyutilproject.AppInit.InitManager;

/**
 * Created by luuu on 2018/1/27.
 */

public class InitActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitManager.setAppInitListener(new InitManager.AppInitListener() {
            @Override
            public void initSuccess() {
                startActivity(new Intent(InitActivity.this, MainActivity.class));
            }

            @Override
            public void initFail(String failStr) {

            }
        });
        InitManager.init(this);
    }
}
