package com.tuolve.lvyou.login;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.tuolve.lvyou.interfaces.IActivity;
import com.tuolve.lvyou.R;
import com.tuolve.lvyou.common.RecyclerViewUtil;

import butterknife.Bind;
import butterknife.OnClick;

public class EnrollActivity extends AppCompatActivity implements IActivity {

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_enroll;
    }

    @Override
    public void initData() {
        textViewTitleBar.setText("会员注册");
    }

    @Override
    public void setListener() {

    }

    @OnClick(R.id.ib_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
