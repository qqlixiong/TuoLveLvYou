package com.tuolve.lvyou.shopping.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseFragment;
import com.tuolve.lvyou.recommend.holder.TitleShoppingHolder;
import com.tuolve.lvyou.tribe.holder.TribeMessageHolder;
import com.tuolve.lvyou.tribe.holder.TribePersonMessageHolder;
import com.tuolve.lvyou.view.CustomGridLayoutManager;
import com.tuolve.lvyou.view.CustomLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 部落里的推荐
 */
public class TribeRecommendFragment extends BaseFragment {

    @Bind(R.id.rv_tribe_recommend_top)
    RecyclerView rvTribeRecommendTop;
    @Bind(R.id.rv_tribe_recommend)
    RecyclerView rvTribeRecommend;
    @Bind(R.id.rv_tribe_recommend_bottom)
    RecyclerView rvTribeRecommendBottom;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_tribe_recommend;
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> listTop = new ArrayList<>();
        listTop.add("旅游摄影");
        listTop.add("结伴出游");
        listTop.add("签证须知");
        listTop.add("旅游视频");
        listTop.add("进入面板");
        recyclerViewUtil.initRecyclerView(rvTribeRecommendTop,listTop,new CustomGridLayoutManager(mContext,5),
                TitleShoppingHolder.class);

        List<String> list = new ArrayList<>();
        list.add("最新精华游记");
        list.add("小长假");
        list.add("最新精华游记");
        list.add("小长假");
        recyclerViewUtil.initRecyclerView(rvTribeRecommend,list,new LinearLayoutManager(
                mContext,LinearLayoutManager.HORIZONTAL,false),TribeMessageHolder.class);

        List<String> listBottom = new ArrayList<>();
        listBottom.add("里斯");
        listBottom.add("里斯");
        listBottom.add("里斯");
        listBottom.add("里斯");
        recyclerViewUtil.initRecyclerView(rvTribeRecommendBottom,listBottom,new CustomLinearLayoutManager(mContext),
                TribePersonMessageHolder.class);
    }
}
