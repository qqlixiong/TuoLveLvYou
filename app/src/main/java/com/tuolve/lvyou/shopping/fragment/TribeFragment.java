package com.tuolve.lvyou.shopping.fragment;


import android.widget.ImageView;
import android.widget.RadioGroup;

import com.tuolve.lvyou.MainActivity;
import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseDestinationFragment;
import com.tuolve.lvyou.base.BaseFragment;
import com.tuolve.lvyou.common.ViewUtils;
import com.tuolve.lvyou.interfaces.ICheckedChanged;
import com.tuolve.lvyou.tribe.OutdoorTravelFragment;

import butterknife.Bind;

/**
 * 部落
 */
public class TribeFragment extends BaseDestinationFragment {

    @Bind(R.id.rg_tribe)
    RadioGroup rgTribe;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_tribe;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BaseFragment[] initClass() {
        return new BaseFragment[]{new TribeRecommendFragment(),new OutdoorTravelFragment()};
    }

    @Override
    protected void setListener() {
        rgTribe.setOnCheckedChangeListener(new MyOnCheckedChangeListener(new ICheckedChanged() {
            @Override
            public void checkedChanged(RadioGroup group, int checkedId) {
                ImageView fab = ((MainActivity) mContext).fab;
                switch (checkedId) {
                    case R.id.button_recommend:
                        position = 0;
                        ViewUtils.setFab(mContext, fab, R.string.travel_release, R.string.my_message,
                                R.drawable.btn_me);
                        break;
                    case R.id.button_outdoor_travel:
                        position = 1;
                        ViewUtils.setFab(mContext, fab, R.string.my_message, R.string.travel_release,
                                R.drawable.ic_tab_video_press);
                        break;
                    default:
                        position = 0;
                        break;
                }
            }
        }));
        rgTribe.check(R.id.button_recommend);
    }

    @Override
    public int getFrameLayoutId() {
        return R.id.fl_tribe;
    }
}
