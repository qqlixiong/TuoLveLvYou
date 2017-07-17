package com.tuolve.lvyou.login;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import com.tuolve.lvyou.interfaces.IActivity;
import com.tuolve.lvyou.MainActivity;
import com.tuolve.lvyou.R;
import com.tuolve.lvyou.common.Constant;
import com.tuolve.lvyou.common.IntentUtil;
import com.tuolve.lvyou.common.RecyclerViewUtil;
import com.tuolve.lvyou.common.SharedPreferenceUtil;

import butterknife.Bind;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements IActivity{

    @Bind(R.id.rg_login)
    RadioGroup rgLogin;
    private SharedPreferenceUtil sharedPreferenceUtil;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void setListener() {
        rgLogin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_login_a:
                        sharedPreferenceUtil.set(Constant.FLAG, Constant.REGULAR_MEMBERS);
                        break;

                    case R.id.rb_login_b:
                        sharedPreferenceUtil.set(Constant.FLAG, Constant.PAYING_MEMBERS);
                        break;
                }
            }
        });
        rgLogin.check(R.id.rb_login_a);
    }

    @OnClick({R.id.bt_ok, R.id.rig_user,R.id.iv_other_a,R.id.iv_other_b,R.id.iv_other_c})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_ok:
                IntentUtil.startActivity(LoginActivity.this, MainActivity.class);
                finish();
                break;

            case R.id.rig_user:
                IntentUtil.startActivity(LoginActivity.this, EnrollActivity.class);
                break;

            case R.id.iv_other_a:
                break;

            case R.id.iv_other_b:
                break;

            case R.id.iv_other_c:
                break;
        }
    }

    @Override
    public void initData() {
        sharedPreferenceUtil = new SharedPreferenceUtil(this, Constant.SP);
    }
}
