package com.tuolve.lvyou.shopping.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseFragment;
import com.tuolve.lvyou.recommend.holder.MyCollectDestinationHolder;
import com.tuolve.lvyou.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 收藏的目的地
 */
public class MyCollectDestinationFragment extends BaseFragment {

    @Bind(R.id.rv_my_collect_destination)
    RecyclerView rvMyCollectDestination;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_my_collect_destination;
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> list = new ArrayList<>();
        list.add("中国");
        list.add("美国");
        recyclerViewUtil.initRecyclerView(rvMyCollectDestination,list,
                new LinearLayoutManager(mContext),
                new DividerListItemDecoration(mContext,DividerListItemDecoration.VERTICAL_LIST,true),
                MyCollectDestinationHolder.class);
    }
}
