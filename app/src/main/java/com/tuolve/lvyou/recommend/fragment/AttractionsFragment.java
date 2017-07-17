package com.tuolve.lvyou.recommend.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseFragment;
import com.tuolve.lvyou.recommend.holder.AttractionsCityStaySelectHolder;
import com.tuolve.lvyou.recommend.holder.FeatureSpotDiscussHolder;
import com.tuolve.lvyou.recommend.seasonplay.holder.SeasonPlayRecommendHolder;
import com.tuolve.lvyou.recommend.holder.TourCityReadMoreHolder;
import com.tuolve.lvyou.view.CustomGridLayoutManager;
import com.tuolve.lvyou.view.CustomLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 景点
 */
public class AttractionsFragment extends BaseFragment {

    @Bind(R.id.rv_attractions_play_pic)
    RecyclerView rvAttractionsPlayPic;
    @Bind(R.id.rv_attractions_city_stay_select)
    RecyclerView rvAttractionsCityStaySelect;
    @Bind(R.id.rv_tour_city_recommend_play)
    RecyclerView rvTourCityRecommendPlay;
    @Bind(R.id.rv_read_more)
    RecyclerView rvReadMore;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_attractions;
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> list1 = new ArrayList<>();
        list1.add("香港亲子游");
        list1.add("香港亲子游");
        list1.add("香港亲子游");
        list1.add("香港亲子游");
        recyclerViewUtil.initRecyclerView(rvAttractionsPlayPic, list1,
                new CustomGridLayoutManager(mContext, 2),
                FeatureSpotDiscussHolder.class);

        List<String> list = new ArrayList<>();
        list.add("尖沙咀");
        list.add("尖沙咀");
        list.add("尖沙咀");
        recyclerViewUtil.initRecyclerView(rvAttractionsCityStaySelect, list,
                new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false),
                AttractionsCityStaySelectHolder.class);

        List<String> list2 = new ArrayList<>();
        list2.add("寻找镜头下的风景");
        list2.add("寻找镜头下的风景");
        list2.add("寻找镜头下的风景");
        recyclerViewUtil.initRecyclerView(rvTourCityRecommendPlay, list2, new LinearLayoutManager(mContext,
                LinearLayoutManager.HORIZONTAL, false), SeasonPlayRecommendHolder.class);

        List<String> list3 = new ArrayList<>();
        list3.add("香港食记一再不吃,就没有了");
        list3.add("香港食记一再不吃,就没有了");
        list3.add("香港食记一再不吃,就没有了");
        recyclerViewUtil.initRecyclerView(rvReadMore,list3,
                new CustomLinearLayoutManager(mContext),TourCityReadMoreHolder.class);
    }
}
