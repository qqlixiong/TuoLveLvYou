package com.tuolve.lvyou.destination.fragment;


import android.widget.RadioGroup;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseDestinationFragment;
import com.tuolve.lvyou.base.BaseFragment;
import com.tuolve.lvyou.interfaces.ICheckedChanged;

import butterknife.Bind;

/**
 * 目的地
 */
public class DestinationFragment extends BaseDestinationFragment {
    @Bind(R.id.include)
    RadioGroup rgMain;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_destination;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BaseFragment[] initClass() {
        return new BaseFragment[]{new HotCityFragment(),new PopularIslandFragment(),
                new HKMacaoTaiwanFragment(),new KoreaJapanFragment(),
                new SoutheastAsiaFragment()/*,new OtherAsianFragment(),
                new EuropeFragment(),new NorthAmericaFragment(),new AfricaFragment()*/};
    }

    @Override
    protected void setListener() {
        rgMain.setOnCheckedChangeListener(new MyOnCheckedChangeListener(new ICheckedChanged() {
            @Override
            public void checkedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_hot_city:
                        position = 0;
                        break;
                    case R.id.rb_popular_island:
                        position = 1;
                        break;
                    case R.id.rb_hk_macao_taiwan:
                        position = 2;
                        break;
                    case R.id.rb_korea_japan:
                        position = 3;
                        break;
                    case R.id.rb_southeast_asia:
                        position = 4;
                        break;
                    /*case R.id.rb_other_asian:
                        position = 5;
                        break;
                    case R.id.rb_europe:
                        position = 6;
                        break;
                    case R.id.rb_north_america:
                        position = 7;
                        break;
                    case R.id.rb_africa:
                        position = 8;
                        break;*/
                    default:
                        position = 0;
                        break;
                }
            }
        }));
        rgMain.check(R.id.rb_hot_city);
    }

    @Override
    public int getFrameLayoutId() {
        return R.id.fl_content_destination;
    }
}
