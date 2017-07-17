package com.tuolve.lvyou.destination.fragment;


import com.tuolve.lvyou.base.BaseCityFragment;
import com.tuolve.lvyou.common.ViewUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 热门城市
 */
public class HotCityFragment extends BaseCityFragment {

    @Override
    public void initFragmentData() {
        ViewUtils.hideView(rlCity);
        List<String> list = new ArrayList<>();
        list.add("普吉岛");
        list.add("巴厘岛");
        list.add("好望角");
        list.add("马尔代夫");
        destinationCityList = list;
        initCityData();
    }

    protected void initCityData() {

    }
}
