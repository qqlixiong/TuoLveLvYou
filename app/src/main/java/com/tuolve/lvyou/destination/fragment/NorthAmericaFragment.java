package com.tuolve.lvyou.destination.fragment;


import com.tuolve.lvyou.common.ViewUtils;
import com.tuolve.lvyou.destination.fragment.HotCityFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 北美洲
 */
public class NorthAmericaFragment extends HotCityFragment {

    @Override
    protected void initCityData() {
        super.initCityData();
        ViewUtils.showView(rlCity);
        cityName = "北美洲";
        List<String> list = new ArrayList<>();
        list.add("巴哈马");
        list.add("美国");
        list.add("海地");
        list.add("墨西哥");
        cityList = list;
    }
}
