package com.tuolve.lvyou.shopping.indulgence;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseActivity;
import com.tuolve.lvyou.shopping.indulgence.holder.OddsHolder;
import com.tuolve.lvyou.common.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 天天特惠
 */
public class OddsActivity extends BaseActivity {

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;
    @Bind(R.id.rv_odds)
    RecyclerView rvOdds;

    @Override
    public int getLayoutId() {
        return R.layout.activity_odds;
    }

    @Override
    public void initData() {
        super.initData();
        textViewTitleBar.setText(getIntent().getExtras().getString(Constant.TITLE));
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> list = new ArrayList<>();
        for(int i=0;i<30;i++){
            list.add("香港狄斯尼乐园+青马大桥");
        }
        recyclerViewUtil.initRecyclerView(rvOdds,list,
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false),
                OddsHolder.class);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
