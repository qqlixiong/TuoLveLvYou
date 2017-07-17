package com.tuolve.lvyou.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

import com.tuolve.lvyou.base.BaseRecommendView;
import com.tuolve.lvyou.recommend.holder.HotRecommendHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2017/4/27.
 */

public class HotRecommendView extends BaseRecommendView{
    public HotRecommendView(Context context) {
        super(context);
    }

    public HotRecommendView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public HotRecommendView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initRecyclerView() {
        List<String> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add("深圳一日游");
        }
        recyclerViewUtil.initRecyclerView(rvRecommend,list,new LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL, false),HotRecommendHolder.class);
    }
}
