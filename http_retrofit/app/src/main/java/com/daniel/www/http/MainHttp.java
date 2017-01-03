package com.daniel.www.http;

import com.daniel.www.entity.LoginResponse;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Daniel on 2017/1/3.
 */

public class MainHttp {


    private static final String FIVE_THOUSAND_MS = "5000";

    private MainHttp() {
    }

    private static class InstanceHolder {
        private static final MainHttp instance = new MainHttp();
    }

    public static MainHttp getInstance() {
        return InstanceHolder.instance;
    }


    /**
     * 登录获取token等信息
     */
    public void getLolToken(Map<String, String> params, String password, Callback<LoginResponse> callback) {
        //params.put("password", "password");
        if (!(params != null && params.size() > 0)) {
            params = new HashMap<>();
        }
        RetrofitManager manager = RetrofitManager.getInstance();
        APIService apiService = manager.create();
        Call<LoginResponse> call = apiService.postLogin("token", params);
        manager.enqueue(call, callback);
    }
}
