package com.tuolve.lvyou.shopping.fragment;


import android.support.v7.widget.RecyclerView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseFragment;
import com.tuolve.lvyou.recommend.holder.MyOrderHolder;
import com.tuolve.lvyou.view.CustomLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 我的所有订单
 */
public class MyAllOrderFragment extends BaseFragment {

    @Bind(R.id.rv_my_all_order)
    RecyclerView rvMyAllOrder;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_my_all_order;
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> listOrder = new ArrayList<>();
        listOrder.add("【梦幻通话世界】香港迪士尼乐园一日/两日游门票");
        listOrder.add("【梦幻通话世界】香港迪士尼乐园一日/两日游门票");
        listOrder.add("【梦幻通话世界】香港迪士尼乐园一日/两日游门票");
        recyclerViewUtil.initRecyclerView(rvMyAllOrder,listOrder,
                new CustomLinearLayoutManager(mContext),MyOrderHolder.class);
    }
}
