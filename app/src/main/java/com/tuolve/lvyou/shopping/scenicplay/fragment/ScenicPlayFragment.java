package com.tuolve.lvyou.shopping.scenicplay.fragment;


import android.support.v7.widget.RecyclerView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseFragment;
import com.tuolve.lvyou.recommend.holder.ScenicPlayHolder;
import com.tuolve.lvyou.view.CustomLinearLayoutManager;
import com.tuolve.lvyou.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 景点玩乐
 */
public class ScenicPlayFragment extends BaseFragment {

    @Bind(R.id.rv_scenic_play)
    RecyclerView rvScenicPlay;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_scenic_play;
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> listGuessLike = new ArrayList<>();
        listGuessLike.add("香港迪斯尼乐园");
        listGuessLike.add("青马大桥");
        listGuessLike.add("黄大仙XXX");
        recyclerViewUtil.initRecyclerView(rvScenicPlay,listGuessLike,
                new CustomLinearLayoutManager(mContext),
                new DividerListItemDecoration(mContext,DividerListItemDecoration.VERTICAL_LIST,true),
                ScenicPlayHolder.class);
    }
}
