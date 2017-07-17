package com.tuolve.lvyou.destination.fragment;


import com.tuolve.lvyou.common.ViewUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 欧洲
 */
public class EuropeFragment extends HotCityFragment {

    @Override
    protected void initCityData() {
        super.initCityData();
        ViewUtils.showView(rlCity);
        cityName = "欧洲";
        List<String> list = new ArrayList<>();
        list.add("法国");
        list.add("英国");
        list.add("德国");
        list.add("意大利");
        cityList = list;
    }
}
