package com.tuolve.lvyou.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

import com.tuolve.lvyou.base.BaseRecommendView;
import com.tuolve.lvyou.recommend.holder.DoyenRecommendHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 推荐达人
 * Created by john on 2017/4/27.
 */

public class DoyenRecommendView extends BaseRecommendView{
    public DoyenRecommendView(Context context) {
        super(context);
    }

    public DoyenRecommendView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DoyenRecommendView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void initData() {
        super.initData();
        textViewName.setText("推荐达人");
    }

    @Override
    public void initRecyclerView() {
        List<String> list = new ArrayList<>();
        list.add("李思");
        list.add("dca");
        list.add("李思");
        list.add("dca");
        recyclerViewUtil.initRecyclerView(rvRecommend,list,new LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL, false),DoyenRecommendHolder.class);
    }
}
