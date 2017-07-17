package com.tuolve.lvyou.my.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseActivity;
import com.tuolve.lvyou.common.RecyclerViewUtil;
import com.tuolve.lvyou.interfaces.IActivity;
import com.tuolve.lvyou.interfaces.IRecyclerViewActivity;
import com.tuolve.lvyou.recommend.holder.MyFootMackHolder;
import com.tuolve.lvyou.common.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的足迹
 */
public class MyFootMackActivity extends AppCompatActivity implements IActivity,IRecyclerViewActivity{

    @Bind(R.id.textView_title_bar)
    TextView textViewTitle;
    @Bind(R.id.rv_my_foot_mack)
    RecyclerView rvMyFootMack;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_foot_mack;
    }

    @Override
    public void initData() {
        textViewTitle.setText(getIntent().getExtras().getString(Constant.MY_FOOT_MACK));
    }

    @Override
    public void setListener() {

    }

    @OnClick(R.id.ib_back)
    public void onViewClicked() {
        onBackPressed();
    }

    @Override
    public void initRecyclerView(RecyclerViewUtil recyclerViewUtil) {
        List<String> list = new ArrayList<>();
        list.add("7");
        list.add("7");
        list.add("7");
        recyclerViewUtil.initRecyclerView(rvMyFootMack,list,new LinearLayoutManager(
                MyFootMackActivity.this),MyFootMackHolder.class);
    }
}
