package com.tuolve.lvyou;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tuolve.lvyou.base.BaseFragment;
import com.tuolve.lvyou.base.BaseFragmentMainActivity;
import com.tuolve.lvyou.common.Constant;
import com.tuolve.lvyou.common.IntentUtil;
import com.tuolve.lvyou.common.SharedPreferenceUtil;
import com.tuolve.lvyou.common.ViewUtils;
import com.tuolve.lvyou.destination.fragment.DestinationFragment;
import com.tuolve.lvyou.interfaces.ICheckedChanged;
import com.tuolve.lvyou.member.MemberFragment;
import com.tuolve.lvyou.my.MyActivity;
import com.tuolve.lvyou.my.activity.OutdoorTravelActivity;
import com.tuolve.lvyou.recommend.fragment.RecommendFragment;
import com.tuolve.lvyou.shopping.ShoppingFragment;
import com.tuolve.lvyou.shopping.fragment.TribeFragment;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseFragmentMainActivity {
    @Bind(R.id.fab)
    public ImageView fab;
    /*@Bind(R.id.textView_title_bar)
    TextView textViewTitle;*/
    @Bind(R.id.rg_main)
    RadioGroup rgMain;
    @Bind(R.id.rb_member)
    RadioButton rbMember;
    /*@Bind(R.id.title_layout)
    RelativeLayout rlTitleBar;*/
    private int flag;
    private SharedPreferenceUtil sharedPreferenceUtil;

    @Override
    protected int initFrameLayoutId() {
        return R.id.fl_content;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        sharedPreferenceUtil = new SharedPreferenceUtil(this, Constant.SP);
        flag = sharedPreferenceUtil.get(Constant.FLAG, Constant.REGULAR_MEMBERS);
        switch (flag) {
            case Constant.REGULAR_MEMBERS:
                ViewUtils.goneView(rbMember);
                break;

            case Constant.PAYING_MEMBERS:
                ViewUtils.showView(rbMember);
                break;
        }
    }

    @Override
    protected BaseFragment[] initClass() {
        return new BaseFragment[]{new MemberFragment(), new RecommendFragment(),
                new DestinationFragment(), new ShoppingFragment(), new TribeFragment()};
    }

    @Override
    protected void setListener() {
        rgMain.setOnCheckedChangeListener(new MyOnCheckedChangeListener(new ICheckedChanged() {
            @Override
            public void checkedChanged(RadioGroup group, int checkedId) {
                ViewUtils.setFab(MainActivity.this, fab, R.string.travel_release, R.string.my_message,
                        R.drawable.ic_tab_video_press);
                switch (checkedId) {
                    case R.id.rb_member:
                        position = 0;
//                        StatusBarUtils.from(MainActivity.this).setTransparentStatusbar(true).process();
                        /*ViewUtils.showGoneView(rlTitleBar);
                        textViewTitle.setText("会员商城");*/
                        break;
                    case R.id.rb_recommend:
                        position = 1;
//                        StatusBarUtils.from(MainActivity.this).setTransparentStatusbar(true).process();
                        /*ViewUtils.goneView(rlTitleBar);
                        textViewTitle.setText("推荐首页");*/
                        break;
                    case R.id.rb_destination:
                        position = 2;
                        /*ViewUtils.goneView(rlTitleBar);*/
                        break;
                    case R.id.rb_shopping:
                        position = 3;
//                        StatusBarUtils.from(MainActivity.this).setTransparentStatusbar(true).process();
                        /*ViewUtils.showGoneView(rlTitleBar);
                        textViewTitle.setText("商城");*/
                        break;
                    case R.id.rb_tribe:
                        position = 4;
                        /*ViewUtils.showGoneView(rlTitleBar);
                        textViewTitle.setText("部落");*/
                        break;
                    default:
                        position = 1;
                        /*ViewUtils.showGoneView(rlTitleBar);
                        textViewTitle.setText("推荐首页");*/
                        break;
                }
            }
        }));
        rgMain.check(R.id.rb_recommend);
    }

    @OnClick(R.id.fab)
    public void fab(View view) {
        if (ViewUtils.isChange(MainActivity.this, view, R.string.travel_release)) {
            IntentUtil.startActivity(MainActivity.this, OutdoorTravelActivity.class);
        } else if (ViewUtils.isChange(MainActivity.this, view, R.string.my_message)) {
            IntentUtil.startActivity(MainActivity.this, MyActivity.class);
        }
    }
}
