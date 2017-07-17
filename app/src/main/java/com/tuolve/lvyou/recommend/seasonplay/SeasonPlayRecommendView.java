package com.tuolve.lvyou.recommend.seasonplay;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

import com.tuolve.lvyou.base.BaseRecommendView;
import com.tuolve.lvyou.recommend.seasonplay.holder.SeasonPlayRecommendHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 当季玩法
 * Created by john on 2017/4/27.
 */

public class SeasonPlayRecommendView extends BaseRecommendView{
    public SeasonPlayRecommendView(Context context) {
        super(context);
    }

    public SeasonPlayRecommendView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SeasonPlayRecommendView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void initData() {
        super.initData();
        textViewName.setText("当季玩法");
    }

    @Override
    public void initRecyclerView() {
        List<String> list = new ArrayList<>();
        list.add("寻找镜头下的风景");
        list.add("寻找镜头下的风景");
        list.add("寻找镜头下的风景");
        recyclerViewUtil.initRecyclerView(rvRecommend,list,new LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL, false),SeasonPlayRecommendHolder.class);
    }
}
