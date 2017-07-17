package com.tuolve.lvyou.destination.fragment;


import com.tuolve.lvyou.common.ViewUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 港澳台
 */
public class HKMacaoTaiwanFragment extends HotCityFragment {

    @Override
    protected void initCityData() {
        super.initCityData();
        ViewUtils.showView(rlCity);
        cityName = "港澳台";
        List<String> list = new ArrayList<>();
        list.add("香港");
        list.add("澳门");
        list.add("台湾");
        cityList = list;
    }
}
