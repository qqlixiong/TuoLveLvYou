package com.tuolve.lvyou.my.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.common.RecyclerViewUtil;
import com.tuolve.lvyou.interfaces.IActivity;
import com.tuolve.lvyou.interfaces.IRecyclerViewActivity;
import com.tuolve.lvyou.recommend.holder.MyCollectDestinationHolder;
import com.tuolve.lvyou.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的锦囊
 */
public class MyCultureActivity extends AppCompatActivity implements IActivity,IRecyclerViewActivity{

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;
    @Bind(R.id.rv_my_collect_destination)
    RecyclerView rvMyCollectDestination;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_culture;
    }

    @Override
    public void initData() {
        textViewTitleBar.setText("我的锦囊");
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
        list.add("中国");
        list.add("美国");
        recyclerViewUtil.initRecyclerView(rvMyCollectDestination,list,
                new LinearLayoutManager(MyCultureActivity.this),
                new DividerListItemDecoration(MyCultureActivity.this,DividerListItemDecoration.VERTICAL_LIST,true),
                MyCollectDestinationHolder.class);
    }
}
