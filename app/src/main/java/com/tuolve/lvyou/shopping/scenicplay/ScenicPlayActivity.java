package com.tuolve.lvyou.shopping.scenicplay;

import android.widget.RadioGroup;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseFragment;
import com.tuolve.lvyou.base.BaseFragmentMainActivity;
import com.tuolve.lvyou.interfaces.ICheckedChanged;
import com.tuolve.lvyou.shopping.scenicplay.fragment.EntertainmentFragment;
import com.tuolve.lvyou.shopping.scenicplay.fragment.FineFoodFragment;
import com.tuolve.lvyou.shopping.scenicplay.fragment.MoreCategoriesFragment;
import com.tuolve.lvyou.shopping.scenicplay.fragment.ScenicPlayFragment;
import com.tuolve.lvyou.shopping.scenicplay.fragment.TradeFragment;

import butterknife.Bind;
import butterknife.OnClick;

public class ScenicPlayActivity extends BaseFragmentMainActivity {

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;
    @Bind(R.id.rg_scenic_play)
    RadioGroup rgScenicPlay;

    @Override
    protected int initFrameLayoutId() {
        return R.id.fl_scenic_play;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_scenic_play;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BaseFragment[] initClass() {
        return new BaseFragment[]{new ScenicPlayFragment(), new FineFoodFragment(),
                new TradeFragment(), new EntertainmentFragment(), new MoreCategoriesFragment()};
    }

    @Override
    protected void setListener() {
        rgScenicPlay.setOnCheckedChangeListener(new MyOnCheckedChangeListener(new ICheckedChanged() {
            @Override
            public void checkedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_scenic_play:
                        position = 0;
                        textViewTitleBar.setText("景点玩乐");
                        break;
                    case R.id.rb_fine_food:
                        position = 1;
                        textViewTitleBar.setText("美食");
                        break;
                    case R.id.rb_trade:
                        position = 2;
                        textViewTitleBar.setText("购物");
                        break;
                    case R.id.rb_entertainment:
                        position = 3;
                        textViewTitleBar.setText("休闲娱乐");
                        break;
                    case R.id.rb_more_categories:
                        position = 4;
                        textViewTitleBar.setText("更多分类");
                        break;
                    default:
                        position = 0;
                        textViewTitleBar.setText("景点玩乐");
                        break;
                }
            }
        }));
        rgScenicPlay.check(R.id.rb_scenic_play);
    }

    @OnClick(R.id.ib_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
