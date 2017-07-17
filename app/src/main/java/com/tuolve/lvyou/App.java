package com.tuolve.lvyou;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.DisplayMetrics;

import com.baidu.mapapi.SDKInitializer;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.zxy.recovery.core.Recovery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by john on 2017/4/27.
 */

public class App extends Application {
    //在整个应用执行过程中，需要提供的变量
    public static Context context;//需要使用的上下文对象：application实例
    public static Handler handler;//需要使用的handler
    public static Thread mainThread;//提供主线程对象
    public static int mainThreadId;//提供主线程对象的id
    public static List<?> images=new ArrayList<>();
    public static int H;
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(this);
        context = this.getApplicationContext();
        handler = new Handler();
        mainThread = Thread.currentThread();//实例化当前Application的线程即为主线程
        mainThreadId = android.os.Process.myTid();//获取当前线程的id
        H=getScreenH(this);
        Fresco.initialize(this);
        Recovery.getInstance()
                .debug(true)
                .recoverInBackground(false)
                .recoverStack(true)
                .mainPage(MainActivity.class)
                .init(this);
        String[] urls = getResources().getStringArray(R.array.url4);
        List list = Arrays.asList(urls);
        images = new ArrayList(list);
        com.tuolve.lvyou.common.ActivityLifecycleCallbacks.getInstance().registerActivityLifecycleCallbacks(this);
    }

    public int getScreenH(Context aty) {
        DisplayMetrics dm = aty.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }
}
