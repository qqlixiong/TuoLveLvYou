package com.tuolve.lvyou.destination.fragment;


import com.tuolve.lvyou.common.ViewUtils;
import com.tuolve.lvyou.destination.fragment.HotCityFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 亚洲其它
 */
public class OtherAsianFragment extends HotCityFragment {

    @Override
    protected void initCityData() {
        super.initCityData();
        ViewUtils.showView(rlCity);
        cityName = "亚洲其它";
        List<String> list = new ArrayList<>();
        list.add("印度");
        list.add("越南");
        list.add("老挝");
        list.add("缅甸");
        list.add("柬埔寨");
        cityList = list;
    }
}
