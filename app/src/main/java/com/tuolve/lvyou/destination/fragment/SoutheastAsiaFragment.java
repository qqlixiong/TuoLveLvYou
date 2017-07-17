package com.tuolve.lvyou.destination.fragment;


import com.tuolve.lvyou.common.ViewUtils;
import com.tuolve.lvyou.destination.fragment.HotCityFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 东南亚
 */
public class SoutheastAsiaFragment extends HotCityFragment {

    @Override
    protected void initCityData() {
        super.initCityData();
        ViewUtils.showView(rlCity);
        cityName = "东南亚";
        List<String> list = new ArrayList<>();
        list.add("新加坡");
        list.add("菲律宾");
        list.add("文莱");
        list.add("东帝汶");
        list.add("印尼");
        cityList = list;
    }
}
