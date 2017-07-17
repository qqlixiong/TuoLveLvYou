package com.tuolve.lvyou.my.activity;

import android.widget.RadioGroup;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseFragment;
import com.tuolve.lvyou.base.BaseFragmentMainActivity;
import com.tuolve.lvyou.shopping.fragment.MallFragment;
import com.tuolve.lvyou.shopping.fragment.StrategyFragment;
import com.tuolve.lvyou.shopping.fragment.TourMyCollectionFragment;
import com.tuolve.lvyou.interfaces.ICheckedChanged;
import com.tuolve.lvyou.common.Constant;

import butterknife.Bind;
import butterknife.OnClick;

public class TourCityActivity extends BaseFragmentMainActivity {

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;
    @Bind(R.id.rg_tour_city)
    RadioGroup rgTourCity;

    @Override
    protected int initFrameLayoutId() {
        return R.id.fl_tour_city;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_tour_city;
    }

    @Override
    protected void initView() {
        textViewTitleBar.setText(getIntent().getExtras().getString(Constant.MY_TOUR_CITY));
    }

    @Override
    protected BaseFragment[] initClass() {
        return new BaseFragment[]{StrategyFragment.newInstance(textViewTitleBar.getText().toString()),
                new MallFragment(),new TourMyCollectionFragment()};
    }

    @Override
    protected void setListener() {
        rgTourCity.setOnCheckedChangeListener(new MyOnCheckedChangeListener(new ICheckedChanged() {
            @Override
            public void checkedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_strategy:
                        position = 0;
                        break;
                    case R.id.rb_mall:
                        position = 1;
                        break;
                    case R.id.rb_my_collection:
                        position = 2;
                        break;
                    default:
                        position = 0;
                        break;
                }
            }
        }));
        rgTourCity.check(R.id.rb_strategy);
    }

    @OnClick(R.id.ib_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
