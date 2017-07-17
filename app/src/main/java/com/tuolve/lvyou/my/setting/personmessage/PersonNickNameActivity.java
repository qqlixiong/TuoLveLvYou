package com.tuolve.lvyou.my.setting.personmessage;

import android.view.View;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseActivity;
import com.tuolve.lvyou.common.IntentUtil;

import butterknife.Bind;
import butterknife.OnClick;

public class PersonNickNameActivity extends BaseActivity {

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_person_nick_name;
    }

    @Override
    public void initData() {
        super.initData();
        textViewTitleBar.setText("修改昵称");
    }

    @OnClick({R.id.ib_back, R.id.my_tv_confirm_completion})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_back:
                onBackPressed();
                break;
            case R.id.my_tv_confirm_completion:
                IntentUtil.startActivity(this,PersonMessageActivity.class);
                break;
        }
    }
}
