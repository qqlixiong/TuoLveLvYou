package com.tuolve.lvyou.shopping.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.RadioGroup;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseFragment;
import com.tuolve.lvyou.base.BaseStrategyFragment;
import com.tuolve.lvyou.destination.activity.MapActivity;
import com.tuolve.lvyou.recommend.holder.FeatureSpotDiscussHolder;
import com.tuolve.lvyou.recommend.holder.FeatureSpotPicHolder;
import com.tuolve.lvyou.recommend.holder.TitleShoppingHolder;
import com.tuolve.lvyou.interfaces.ICheckedChanged;
import com.tuolve.lvyou.common.IntentUtil;
import com.tuolve.lvyou.recommend.fragment.AttractionsFragment;
import com.tuolve.lvyou.view.CustomGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 攻略
 */
public class StrategyFragment extends BaseStrategyFragment {

    @Bind(R.id.rv_feature_spot)
    RecyclerView rvFeatureSpot;
    @Bind(R.id.rv_feature_spot_discuss)
    RecyclerView rvFeatureSpotDiscuss;
    @Bind(R.id.rv_feature_spot_pic)
    RecyclerView rvFeatureSpotPic;
    @Bind(R.id.rg_special_attractions)
    RadioGroup rgSpecialAttractions;
    @Bind(R.id.button_map)
    Button buttonMap;
    private String cityName;

    @Override
    public void initData() {
        super.initData();
        cityName = getArguments().getString("cityName");
        buttonMap.setText(cityName+"地图");
    }

    public static final StrategyFragment newInstance(String cityName)
    {
        StrategyFragment fragment = new StrategyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("cityName", cityName);
        fragment.setArguments(bundle);

        return fragment ;
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_strategy;
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> list = new ArrayList<>();
        list.add("城市概况");
        list.add("热门景点");
        list.add("当地美食");
        list.add("交通指南");
        list.add("特惠酒店");
        list.add("游记攻略");
        list.add("推荐路线");
        list.add("结伴出行");
        recyclerViewUtil.initRecyclerView(rvFeatureSpot, list, new CustomGridLayoutManager(mContext, 4),
                TitleShoppingHolder.class);

        List<String> list1 = new ArrayList<>();
        list1.add("香港景点好评top10");
        list1.add("香港景点好评top10");
        recyclerViewUtil.initRecyclerView(rvFeatureSpotDiscuss, list1,
                new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false),
                FeatureSpotDiscussHolder.class);

        List<String> list2 = new ArrayList<>();
        list2.add("太行山");
        list2.add("太行山");
        list2.add("太行山");
        list2.add("太行山");
        list2.add("太行山");
        list2.add("太行山");
        recyclerViewUtil.initRecyclerView(rvFeatureSpotPic, list2,
                new CustomGridLayoutManager(mContext, 3), FeatureSpotPicHolder.class);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BaseFragment[] initClass() {
        return new BaseFragment[]{new AttractionsFragment(), new CateFragment(),
                new TradeFragment()};
    }

    @Override
    protected void setListener() {
        rgSpecialAttractions.setOnCheckedChangeListener(new MyOnCheckedChangeListener(new ICheckedChanged() {
            @Override
            public void checkedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_attractions:
                        position = 0;
                        break;
                    case R.id.rb_cate:
                        position = 1;
                        break;
                    case R.id.rb_trade:
                        position = 2;
                        break;
                    default:
                        position = 0;
                        break;
                }
            }
        }));
        rgSpecialAttractions.check(R.id.rb_attractions);
    }

    @Override
    public int getFrameLayoutId() {
        return R.id.fl_special_attractions;
    }

    @OnClick(R.id.button_map)
    public void onViewClicked() {
        Bundle bundle = new Bundle();
        bundle.putString("cityName",cityName);
        IntentUtil.startActivity(mContext, MapActivity.class,bundle);
    }
}
