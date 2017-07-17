package com.tuolve.lvyou.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * 不支持滑动的线性管理器
 * 在 RecyclerView 设置LinearLayout的时候 继承上述子类，并设置setScrollEnabled 为false 即可。
 * CustomLinearLayoutManager linearLayoutManager = new CustomLinearLayoutManager(mContext);
 linearLayoutManager.setScrollEnabled(false);
 mDevicesRV.setLayoutManager(linearLayoutManager);
 * Created by john on 2017/4/28.
 */

public class CustomLinearLayoutManager extends LinearLayoutManager {
    private boolean isScrollEnabled = true;

    public CustomLinearLayoutManager(Context context) {
        super(context);
    }

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
        return isScrollEnabled && super.canScrollVertically();
    }
}
