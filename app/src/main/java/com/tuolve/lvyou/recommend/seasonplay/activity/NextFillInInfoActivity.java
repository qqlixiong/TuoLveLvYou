package com.tuolve.lvyou.recommend.seasonplay.activity;

import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseActivity;
import com.tuolve.lvyou.common.Constant;

import butterknife.Bind;
import butterknife.OnClick;

public class NextFillInInfoActivity extends BaseActivity {

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_next_fill_in_info;
    }

    @Override
    public void initData() {
        super.initData();
        textViewTitleBar.setText(getIntent().getExtras().getString(Constant.TITLE));
    }

    @OnClick(R.id.ib_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
