package com.tuolve.lvyou.recommend.seasonplay.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseActivity;
import com.tuolve.lvyou.common.Constant;
import com.tuolve.lvyou.common.IntentUtil;

import butterknife.Bind;
import butterknife.OnClick;

public class ImmediateReservationActivity extends BaseActivity {

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_immediate_reservation;
    }

    @Override
    public void initData() {
        super.initData();
        textViewTitleBar.setText(getIntent().getExtras().getString(Constant.TITLE));
    }

    @OnClick({R.id.ib_back,R.id.tv_next_fill_in_info})
    public void onViewClicked(View v) {
        switch (v.getId()){
            case R.id.ib_back:
                onBackPressed();
                break;

            case R.id.tv_next_fill_in_info:
                Bundle bundle = new Bundle();
                bundle.putString(Constant.TITLE,textViewTitleBar.getText().toString());
                IntentUtil.startActivity(this,NextFillInInfoActivity.class,bundle);
                break;
        }
    }
}
