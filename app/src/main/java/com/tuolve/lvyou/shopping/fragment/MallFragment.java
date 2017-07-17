package com.tuolve.lvyou.shopping.fragment;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseBannerFragment;
import com.tuolve.lvyou.destination.MallAllDestinationActivity;
import com.tuolve.lvyou.recommend.holder.AttractionsTourPriceHolder;
import com.tuolve.lvyou.common.Constant;
import com.tuolve.lvyou.common.IntentUtil;
import com.tuolve.lvyou.view.CustomLinearLayoutManager;
import com.tuolve.lvyou.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 商城
 */
public class MallFragment extends BaseBannerFragment {

    @Bind(R.id.rv_mall_destination_select_content)
    RecyclerView rvMallDestinationSelectContent;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_mall;
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> list = new ArrayList<>();
        for(int i=0;i<40;i++){
            list.add("￥2599");
        }
        recyclerViewUtil.initRecyclerView(rvMallDestinationSelectContent, list,
                new CustomLinearLayoutManager(mContext),
                new DividerListItemDecoration(mContext, DividerListItemDecoration.VERTICAL_LIST, true),
                AttractionsTourPriceHolder.class);
    }

    @OnClick({R.id.tv_mall_all_destination, R.id.tv_mall_intelligent_sorting, R.id.tv_mall_more_screening})
    public void onViewClicked(View view) {
        Bundle bundle = new Bundle();
        int position = 0;
        switch (view.getId()) {
            case R.id.tv_mall_all_destination:
                position = 0;
                break;
            case R.id.tv_mall_intelligent_sorting:
                position = 1;
                break;
            case R.id.tv_mall_more_screening:
                position = 2;
                break;
        }
        bundle.putInt(Constant.DESTINATION_TITLE_POSITION,position);
        IntentUtil.startActivity(mContext, MallAllDestinationActivity.class,bundle);
    }
}
