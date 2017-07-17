package com.tuolve.lvyou.my.activity;

import android.widget.RadioGroup;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseFragment;
import com.tuolve.lvyou.base.BaseFragmentMainActivity;
import com.tuolve.lvyou.shopping.fragment.MyCollectCardFragment;
import com.tuolve.lvyou.shopping.fragment.MyCollectDestinationFragment;
import com.tuolve.lvyou.shopping.fragment.MyCollectOtherFragment;
import com.tuolve.lvyou.shopping.fragment.MyCollectRebateFragment;
import com.tuolve.lvyou.interfaces.ICheckedChanged;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的收藏
 */
public class MyCollectActivity extends BaseFragmentMainActivity {

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;
    @Bind(R.id.rg_my_collect)
    RadioGroup rgMyCollect;

    @Override
    protected int initFrameLayoutId() {
        return R.id.fl_my_collect;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_collect;
    }

    @Override
    protected void initView() {
        textViewTitleBar.setText("我的收藏");
    }

    @Override
    protected BaseFragment[] initClass() {
        return new BaseFragment[]{new MyCollectDestinationFragment(), new MyCollectCardFragment(),
                new MyCollectRebateFragment(), new MyCollectOtherFragment()};
    }

    @Override
    protected void setListener() {
        rgMyCollect.setOnCheckedChangeListener(new MyOnCheckedChangeListener(new ICheckedChanged() {
            @Override
            public void checkedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.my_collect_destination:
                        position = 0;
                        break;
                    case R.id.my_collect_card:
                        position = 1;
                        break;
                    case R.id.my_collect_rebate:
                        position = 2;
                        break;
                    case R.id.my_collect_other:
                        position = 3;
                        break;
                    default:
                        position = 0;
                        break;
                }
            }
        }));
        rgMyCollect.check(R.id.my_collect_destination);
    }

    @OnClick(R.id.ib_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
