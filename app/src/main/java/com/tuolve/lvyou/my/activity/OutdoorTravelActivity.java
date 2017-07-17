package com.tuolve.lvyou.my.activity;

import android.view.View;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseActivity;

import butterknife.OnClick;

/**
 * 发布户外出行
 */
public class OutdoorTravelActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_outdoor_travel;
    }

    @OnClick(R.id.ib_back)
    public void back(View view){
        onBackPressed();
    }
}
