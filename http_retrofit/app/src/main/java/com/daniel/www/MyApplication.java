package com.daniel.www;

import android.app.Application;

/**
 * Created by Daniel on 2017/1/3.
 */

public class MyApplication extends Application {

    private static MyApplication _instance;

    public static MyApplication getInstance() {
        return _instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;
    }
}
