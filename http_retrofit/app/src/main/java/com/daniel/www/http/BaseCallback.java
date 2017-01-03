package com.daniel.www.http;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Daniel on 2017/1/3.
 */

public abstract class BaseCallback<T> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if(response.code() == 401){
            //TODO Daniel
            //可处理token失效等业务
            return;
        }else {
            onResponseResult(call,response);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }


    //重写回调方法，可处理token失效等业务
    public abstract void onResponseResult(Call<T> call, Response<T> response);

    public abstract void onFailureResult(Call<T> call, Throwable t);
}
