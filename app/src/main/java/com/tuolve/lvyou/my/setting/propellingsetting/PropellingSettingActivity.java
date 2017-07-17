package com.tuolve.lvyou.my.setting.propellingsetting;

import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseActivity;
import com.tuolve.lvyou.my.customview.PropellingSettingView;

import butterknife.Bind;
import butterknife.OnClick;

public class PropellingSettingActivity extends BaseActivity {

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;
    @Bind(R.id.occasionally_remind)
    PropellingSettingView occasionallyRemind;
    @Bind(R.id.posts_remind)
    PropellingSettingView postsRemind;
    @Bind(R.id.question_and_answer_remind)
    PropellingSettingView questionAndAnswerRemind;
    @Bind(R.id.companion_remind)
    PropellingSettingView companionRemind;

    @Override
    public int getLayoutId() {
        return R.layout.activity_propelling_setting;
    }

    @Override
    public void initData() {
        super.initData();
        textViewTitleBar.setText("推送设置");
    }

    @OnClick(R.id.ib_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
