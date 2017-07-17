package com.tuolve.lvyou.my.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseActivity;
import com.tuolve.lvyou.recommend.holder.MyMateHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的结伴
 */
public class MyMateActivity extends BaseActivity {

    @Bind(R.id.textView_title_bar)
    TextView textViewTitle;
    @Bind(R.id.rv_my_mate)
    RecyclerView rvMyMate;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_mate;
    }

    @Override
    public void initData() {
        super.initData();
        textViewTitle.setText("我的结伴");
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<List<String>> list = new ArrayList<>();
        List<String> listStr = new ArrayList<>();
        listStr.add("寻求五月欧洲结伴同行");
        listStr.add("西班牙");
        listStr.add("20112浏览");
        list.add(listStr);
        recyclerViewUtil.initRecyclerView(rvMyMate,list,new LinearLayoutManager(MyMateActivity.this),
                MyMateHolder.class);
    }

    @OnClick(R.id.ib_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
