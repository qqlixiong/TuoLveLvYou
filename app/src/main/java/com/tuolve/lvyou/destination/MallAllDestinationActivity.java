package com.tuolve.lvyou.destination;

import android.widget.RadioGroup;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseFragment;
import com.tuolve.lvyou.base.BaseFragmentMainActivity;
import com.tuolve.lvyou.destination.fragment.AllDestinationFragment;
import com.tuolve.lvyou.destination.fragment.IntelligentSortingFragment;
import com.tuolve.lvyou.destination.fragment.MoreScreeningFragment;
import com.tuolve.lvyou.interfaces.ICheckedChanged;
import com.tuolve.lvyou.common.Constant;

import butterknife.Bind;
import butterknife.OnClick;

public class MallAllDestinationActivity extends BaseFragmentMainActivity {

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;
    @Bind(R.id.rg_destination)
    RadioGroup rgDestination;
    int desPosition;

    @Override
    protected int initFrameLayoutId() {
        return R.id.fl_mall_all_destination;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mall_all_destination;
    }

    @Override
    protected void initView() {
        desPosition = getIntent().getExtras().getInt(Constant.DESTINATION_TITLE_POSITION,0);
    }

    @Override
    protected BaseFragment[] initClass() {
        return new BaseFragment[]{new AllDestinationFragment(), new IntelligentSortingFragment(),
                new MoreScreeningFragment()};
    }

    @Override
    protected void setListener() {
        rgDestination.setOnCheckedChangeListener(new MyOnCheckedChangeListener(new ICheckedChanged() {
            @Override
            public void checkedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_all_destination:
                        position = 0;
                        textViewTitleBar.setText("全部目的地");
                        break;
                    case R.id.rb_intelligent_sorting:
                        position = 1;
                        textViewTitleBar.setText("智能排序");
                        break;
                    case R.id.rb_more_screening:
                        position = 2;
                        textViewTitleBar.setText("更多筛选");
                        break;
                    default:
                        position = 0;
                        textViewTitleBar.setText("全部目的地");
                        break;
                }
            }
        }));
        switch (desPosition){
            case 0:
                rgDestination.check(R.id.rb_all_destination);
                break;

            case 1:
                rgDestination.check(R.id.rb_intelligent_sorting);
                break;

            case 2:
                rgDestination.check(R.id.rb_more_screening);
                break;
        }
    }

    @OnClick(R.id.ib_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
