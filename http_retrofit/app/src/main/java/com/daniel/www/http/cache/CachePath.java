package com.daniel.www.http.cache;

import android.content.Context;
import android.os.Environment;

import com.daniel.www.MyApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dainel on 2017/1/3.
 */

public class CachePath {

    //SD卡目录
    public final static String SD = Environment.getExternalStorageDirectory().getPath();

    //缓存地址目录
    public final static String TEMP = SD + "/" + getPackageName(MyApplication.getInstance());

    //日志文件地址
    public final static String LOG_PATH = TEMP + "/log/";

    //日志文件命名
    public final static String LOG = LOG_PATH + "log_" + getCurrentTime() + ".txt";

    //网络请求缓存目录
    public final static String HTTPCACHE = TEMP + "/httpCache";









    //获取应用的包名
    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    //获取当前时间
    public static String getCurrentTime() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh");
        return sDateFormat.format(new Date());
    }
}
