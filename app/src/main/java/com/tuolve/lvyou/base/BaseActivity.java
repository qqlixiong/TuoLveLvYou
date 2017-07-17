package com.tuolve.lvyou.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.tuolve.lvyou.R;
import com.tuolve.lvyou.common.RecyclerViewUtil;

import butterknife.ButterKnife;

/**
 * Created by john on 2017/4/15.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected RecyclerViewUtil recyclerViewUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setSystemBarTint();
        ButterKnife.bind(this);
        initView();
        initData();
        initRecyclerView();
        setListener();
    }

    protected void initView() {
    }

    private void setSystemBarTint() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
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

    protected void initRecyclerView() {

    }

    public abstract int getLayoutId();

    public void initData(){
        recyclerViewUtil = RecyclerViewUtil.getInstance();
    };

    public void setListener(){};

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
