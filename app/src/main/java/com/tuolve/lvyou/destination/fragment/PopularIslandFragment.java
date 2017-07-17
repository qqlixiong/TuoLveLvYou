package com.tuolve.lvyou.destination.fragment;


import com.tuolve.lvyou.common.ViewUtils;
import com.tuolve.lvyou.destination.fragment.HotCityFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 人气海岛
 */
public class PopularIslandFragment extends HotCityFragment {

    @Override
    protected void initCityData() {
        super.initCityData();
        ViewUtils.showView(rlCity);
        cityName = "人气海岛";
        List<String> list = new ArrayList<>();
        list.add("泰国");
        list.add("马来西亚");
        list.add("泰国");
        list.add("马来西亚");
        list.add("泰国");
        list.add("马来西亚");
        list.add("泰国");
        list.add("马来西亚");
        cityList = list;
    }
}
