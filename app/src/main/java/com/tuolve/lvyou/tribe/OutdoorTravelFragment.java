package com.tuolve.lvyou.tribe;


import android.support.v7.widget.RecyclerView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseFragment;
import com.tuolve.lvyou.view.CustomLinearLayoutManager;
import com.tuolve.lvyou.tribe.holder.TribeOutdoorHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 户外出行
 */
public class OutdoorTravelFragment extends BaseFragment {
    @Bind(R.id.rv_outdoor)
    RecyclerView recyclerViewOutdoor;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_outdoor_travel;
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> listBottom = new ArrayList<>();
        listBottom.add("里斯");
        listBottom.add("里斯");
        listBottom.add("里斯");
        listBottom.add("里斯");
        recyclerViewUtil.initRecyclerView(recyclerViewOutdoor,listBottom,
                new CustomLinearLayoutManager(mContext),TribeOutdoorHolder.class);
    }
}
