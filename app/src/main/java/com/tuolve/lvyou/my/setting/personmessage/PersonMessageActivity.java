package com.tuolve.lvyou.my.setting.personmessage;

import android.view.View;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseActivity;
import com.tuolve.lvyou.common.IntentUtil;

import butterknife.Bind;
import butterknife.OnClick;

public class PersonMessageActivity extends BaseActivity {

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_person_message;
    }

    @Override
    public void initData() {
        super.initData();
        textViewTitleBar.setText("个人信息");
    }

    @OnClick({R.id.ib_back, R.id.person_head_sculpture, R.id.person_nick_name, R.id.person_six, R.id.person_permanent_city, R.id.person_individual_resume})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_back:
                onBackPressed();
                break;
            case R.id.person_head_sculpture:
                break;
            case R.id.person_nick_name:
                IntentUtil.startActivity(this,PersonNickNameActivity.class);
                break;
            case R.id.person_six:
                break;
            case R.id.person_permanent_city:
                break;
            case R.id.person_individual_resume:
                break;
        }
    }
}
