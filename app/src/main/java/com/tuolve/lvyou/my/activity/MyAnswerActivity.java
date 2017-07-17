package com.tuolve.lvyou.my.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.common.RecyclerViewUtil;
import com.tuolve.lvyou.interfaces.IActivity;
import com.tuolve.lvyou.interfaces.IRecyclerViewActivity;
import com.tuolve.lvyou.recommend.holder.MyAnswerHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 问答
 */
public class MyAnswerActivity extends AppCompatActivity implements IActivity,IRecyclerViewActivity{

    @Bind(R.id.textView_title_bar)
    TextView textViewTitle;
    @Bind(R.id.rv_answer)
    RecyclerView rvAnswer;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_answer;
    }

    @Override
    public void initData() {
        textViewTitle.setText("问答");
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
        List<List<String>> list = new ArrayList<>();
        List<String> listStr = new ArrayList<>();
        listStr.add("国亲节去欧洲还是非洲");
        listStr.add("描述 : 如果你无法简洁的表达你的想法,那只说明你还不够了解它。");
        listStr.add("20112浏览");
        list.add(listStr);
        recyclerViewUtil.initRecyclerView(rvAnswer,list,new LinearLayoutManager(MyAnswerActivity.this),
                MyAnswerHolder.class);
    }
}
