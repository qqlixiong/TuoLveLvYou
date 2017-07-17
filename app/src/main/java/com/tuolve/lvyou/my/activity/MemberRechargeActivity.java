package com.tuolve.lvyou.my.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.interfaces.IActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 会员充值
 */
public class MemberRechargeActivity extends AppCompatActivity implements IActivity{

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;
    @Bind(R.id.textView_title)
    TextView textViewTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_member_recharge;
    }

    @Override
    public void initData() {
        textViewTitleBar.setText("会员充值");
        textViewTitle.setText("输入充值金额");
    }

    @Override
    public void setListener() {

    }

    @OnClick(R.id.ib_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
