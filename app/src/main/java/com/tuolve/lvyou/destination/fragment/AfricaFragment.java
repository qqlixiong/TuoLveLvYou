package com.tuolve.lvyou.destination.fragment;


import com.tuolve.lvyou.common.ViewUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 非洲
 */
public class AfricaFragment extends HotCityFragment {

    @Override
    protected void initCityData() {
        super.initCityData();
        ViewUtils.showView(rlCity);
        cityName = "非洲";
        List<String> list = new ArrayList<>();
        list.add("多哥");
        list.add("马拉博");
        list.add("洛美");
        list.add("佛得角");
        list.add("马拉博");
        list.add("冈比亚");
        list.add("普拉亚");
        list.add("刚果");
        list.add("班珠尔");
        list.add("阿斯马拉");
        list.add("普拉亚");
        list.add("吉布提");
        cityList = list;
    }
}
