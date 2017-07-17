package com.tuolve.lvyou.common;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.tuolve.lvyou.App;
import com.tuolve.lvyou.R;
import com.tuolve.lvyou.interfaces.IActivity;
import com.tuolve.lvyou.interfaces.IGlideImageActivity;
import com.tuolve.lvyou.interfaces.IRecyclerViewActivity;

import butterknife.ButterKnife;

/**
 * Created by john on 2017/5/18.
 */

public class ActivityLifecycleCallbacks {

    private ActivityLifecycleCallbacks() {
        if(Inner.activityLifecycleCallbacks != null){
            throw new RuntimeException();
        }
    }

    private static class Inner{
        private static ActivityLifecycleCallbacks activityLifecycleCallbacks = new ActivityLifecycleCallbacks();
    }

    public static ActivityLifecycleCallbacks getInstance(){
        return Inner.activityLifecycleCallbacks;
    }

    public void registerActivityLifecycleCallbacks(App app) {
        app.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                if(activity instanceof IActivity){
                    activity.setContentView(((IActivity) activity).getLayoutId());
                    setSystemBarTint(activity);
                    ButterKnife.bind(activity);
                    ((IActivity) activity).initData();
                    ((IActivity) activity).setListener();
                    if(activity instanceof IRecyclerViewActivity){
                        ((IRecyclerViewActivity) activity).initRecyclerView(RecyclerViewUtil.getInstance());
                    }
                    if(activity instanceof IGlideImageActivity){
                        ((IGlideImageActivity) activity).initGlideImage(GlideImage.getInstance());
                    }
                }
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                ButterKnife.unbind(activity);
            }
        });
    }

    private void setSystemBarTint(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            SystemBarTintManager tintManager = new SystemBarTintManager(activity);
            // 激活状态栏
            tintManager.setStatusBarTintEnabled(true);
            // enable navigation bar tint 激活导航栏
            tintManager.setNavigationBarTintEnabled(true);
            //设置系统栏设置颜色
            //tintManager.setTintColor(R.color.red);
            //给状态栏设置颜色
            tintManager.setStatusBarTintResource(R.color.mask_tags);
            //Apply the specified drawable or color resource to the system navigation bar.
            //给导航栏设置资源
            tintManager.setNavigationBarTintResource(R.color.mask_tags);
        }
    }
}
