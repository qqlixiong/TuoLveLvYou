package com.tuolve.lvyou.my.setting.userpws;

import android.view.View;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseActivity;
import com.tuolve.lvyou.common.IntentUtil;

import butterknife.Bind;
import butterknife.OnClick;

public class MyRevisePwsActivity extends BaseActivity {

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_revise_pws;
    }

    @Override
    public void initData() {
        super.initData();
        textViewTitleBar.setText("修改密码");
    }

    @OnClick({R.id.ib_back, R.id.my_tv_revise_pws})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_back:
                onBackPressed();
                break;
            case R.id.my_tv_revise_pws:
                IntentUtil.startActivity(this, RevisePwsActivity.class);
                break;
        }
    }
}
