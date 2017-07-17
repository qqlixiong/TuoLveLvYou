package com.tuolve.lvyou.base;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.recommend.holder.CityHolder;
import com.tuolve.lvyou.recommend.holder.DestinationCityHolder;

import java.util.List;

import butterknife.Bind;

/**
 * Created by john on 2017/4/29.
 */

public abstract class BaseCityFragment extends BaseFragment{
    @Bind(R.id.rv_destination_city)
    public RecyclerView rvDestinationCity;
    @Bind(R.id.tv_title)
    public TextView tvTitle;
    @Bind(R.id.rv_city)
    public RecyclerView rvCity;
    @Bind(R.id.textView_city_number)
    public TextView textViewCityNumber;
    @Bind(R.id.rl_city)
    public RelativeLayout rlCity;
    public String cityName;
    public List<String> destinationCityList;
    public List<String> cityList;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.destination_fragment_item;
    }

    public void initData() {
        super.initData();
        initFragmentData();
        if(com.tuolve.lvyou.common.ViewUtils.isShowView(rlCity)){
            tvTitle.setText(cityName);
            textViewCityNumber.setText(mContext.getResources().getString(
                    R.string.action_city_number,String.valueOf(cityList.size())));
        }
    }

    public abstract void initFragmentData();

    public void initRecyclerView() {
        recyclerViewUtil.initRecyclerView(rvDestinationCity,destinationCityList,
                new GridLayoutManager(mContext,2),DestinationCityHolder.class);

        if(cityList != null && cityList.size() != 0){
            recyclerViewUtil.initRecyclerView(rvCity,cityList,
                    new GridLayoutManager(mContext,2),CityHolder.class);
        }
    }
}
