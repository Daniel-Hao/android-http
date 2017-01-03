package com.daniel.www;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daniel.www.entity.LoginResponse;
import com.daniel.www.http.MainHttp;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * 1，需在主綫程啓動
     * 2，callback也是主綫程，可直接修好UI
     * 3，callback中耗時操作，建議開啓子綫程操作
     */
    private void postLogin() {
        //1，判断网络
        Map<String, String> params = new HashMap<>();
        params.put("password", "123456");
        MainHttp.getInstance().getLolToken(params, "", new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });


    }
}
