package com.tuolve.lvyou.destination.fragment;


import com.tuolve.lvyou.common.ViewUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 日韩朝
 */
public class KoreaJapanFragment extends HotCityFragment {

    @Override
    protected void initCityData() {
        super.initCityData();
        ViewUtils.showView(rlCity);
        cityName = "日韩朝";
        List<String> list = new ArrayList<>();
        list.add("日本");
        list.add("韩国");
        list.add("朝鲜");
        cityList = list;
    }
}
