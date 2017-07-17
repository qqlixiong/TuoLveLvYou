package com.tuolve.lvyou.my.setting;

import android.view.View;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseActivity;
import com.tuolve.lvyou.my.setting.personmessage.PersonMessageActivity;
import com.tuolve.lvyou.my.setting.propellingsetting.PropellingSettingActivity;
import com.tuolve.lvyou.my.setting.userpws.MyUserPwsActivity;
import com.tuolve.lvyou.common.IntentUtil;

import butterknife.Bind;
import butterknife.OnClick;

public class MySettingActivity extends BaseActivity {

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_setting;
    }

    @Override
    public void initData() {
        super.initData();
        textViewTitleBar.setText("设置");
    }

    @OnClick({R.id.ib_back, R.id.my_user_and_pws, R.id.my_message, R.id.my_propelling_setting, R.id.my_clear_cache, R.id.my_check_latest_version, R.id.my_feedback, R.id.my_contact_us})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_back:
                onBackPressed();
                break;
            case R.id.my_user_and_pws:
                IntentUtil.startActivity(MySettingActivity.this, MyUserPwsActivity.class);
                break;
            case R.id.my_message:
                IntentUtil.startActivity(this, PersonMessageActivity.class);
                break;
            case R.id.my_propelling_setting:
                IntentUtil.startActivity(this, PropellingSettingActivity.class);
                break;
            case R.id.my_clear_cache:
                break;
            case R.id.my_check_latest_version:
                break;
            case R.id.my_feedback:
                break;
            case R.id.my_contact_us:
                break;
        }
    }
}
