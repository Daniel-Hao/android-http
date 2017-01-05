package com.daniel.www.http;

import android.content.Context;

import com.daniel.www.MyApplication;
import com.daniel.www.http.cache.CachePath;
import com.daniel.www.http.interceptor.CoreInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dainel on 2017/1/3.
 */

public class RetrofitManager {

    private Context mContext = MyApplication.getInstance();

    //优化：建立final配置类，专门配置
    private static final String API_IP = "http://192.168.1.40:8000/v1";
    // 网络请求超时
    private static final int TIME_OUT = 10 * 1000;
    private static final int CACHE_SIZE = 20 * 1024 * 1024;



    private RetrofitManager() {
    }

    private static class InstanceHolder {
        private static final RetrofitManager instance = new RetrofitManager();
    }

    public static RetrofitManager getInstance() {
        return InstanceHolder.instance;
    }

    /**
     * 获取一个服务对象，使用Gson转换器，用于json数据的交互
     *
     * @return
     */
    public APIService create(String... timeOutAndOther) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_IP)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient(timeOutAndOther))
                .build();
        return retrofit.create(APIService.class);
    }


    /**
     * https 验证也在这里
     * 获取一个带拦截器的client对象
     * param：timeOutAndOther [0] timeout,[1]agent_v为调用api header中内部版本号
     *
     * @return
     */
    private OkHttpClient getClient(String... timeOutAndOther) {
        //设置缓存目录
        File dir = new File(CachePath.HTTPCACHE);
        Cache cache = new Cache(dir, CACHE_SIZE);

        //TODO Daniel
        //https 尚未完成
        //SSLSocketFactory sslSocketFactory = new SSlContextFactory().getSslSocket().getSocketFactory();
        //.socketFactory(sslSocketFactory)
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new CoreInterceptor(timeOutAndOther))
                .connectTimeout((timeOutAndOther != null && timeOutAndOther.length > 0) ?
                        Integer.valueOf(timeOutAndOther[0]) : TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout((timeOutAndOther != null && timeOutAndOther.length > 0) ?
                        Integer.valueOf(timeOutAndOther[0]) : TIME_OUT, TimeUnit.MILLISECONDS)
                .cache(cache)
                .build();
        return client;
    }

    /**
     * 执行
     *
     * @param call
     * @param callback
     */
    public void enqueue(Call call, Callback callback) {
        //可分装 网络提示：断网toast等等
        call.enqueue(callback);
    }

    public void enqueue(Call call, BaseCallback callback) {
        //可分装 网络提示：断网toast等等
        call.enqueue(callback);
    }
}
