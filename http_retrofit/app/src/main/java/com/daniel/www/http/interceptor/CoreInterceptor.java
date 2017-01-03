package com.daniel.www.http.interceptor;

import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Daniel on 2017/1/3.
 */
public class CoreInterceptor implements Interceptor {

    private static final String TAG = "CoreInterceptor";

    public CoreInterceptor(String... strHeader) {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = null;
        Response response = null;
        request = chain.request()
                .newBuilder()
                .addHeader("Timestamp", "")
                .build();
        response = chain.proceed(request);

        //request = chain.request();
        // response = chain.proceed(request);
        Log.d(TAG, "response.code =" + response.code());
        Log.d(TAG, "----        Request       ---- " + "\n" + request.toString());
        Log.d(TAG, "----        Response      ---- " + "\n" + response.toString());

        return response;
    }

}
