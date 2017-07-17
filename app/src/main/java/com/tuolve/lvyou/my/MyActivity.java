package com.tuolve.lvyou.my;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseActivity;
import com.tuolve.lvyou.base.BaseGlideActivity;
import com.tuolve.lvyou.common.Constant;
import com.tuolve.lvyou.common.IntentUtil;
import com.tuolve.lvyou.my.activity.AboutUsActivity;
import com.tuolve.lvyou.my.activity.MemberRechargeActivity;
import com.tuolve.lvyou.my.activity.MemberShoppingActivity;
import com.tuolve.lvyou.my.activity.MyAnswerActivity;
import com.tuolve.lvyou.my.activity.MyCouponActivity;
import com.tuolve.lvyou.my.activity.MyFootMackActivity;
import com.tuolve.lvyou.my.activity.MyMateActivity;
import com.tuolve.lvyou.my.activity.MyOrderActivity;
import com.tuolve.lvyou.my.activity.MyTeamActivity;
import com.tuolve.lvyou.my.setting.MySettingActivity;
import com.tuolve.lvyou.recommend.holder.MyHolder;
import com.tuolve.lvyou.view.CustomGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyActivity extends BaseGlideActivity {

    @Bind(R.id.rv_my)
    RecyclerView rvMy;
    @Bind(R.id.iv_person_message)
    ImageView mIvPersonMessage;
    @Bind(R.id.imageView7)
    ImageView mImageView7;
    @Bind(R.id.imageView8)
    ImageView mImageView8;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my;
    }

    @Override
    public void initData() {
        super.initData();
        glideImage.displayImage(this,mImageView7,mImageView8,mIvPersonMessage);
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> list = new ArrayList<>();
        list.add("我的收藏");
        list.add("我的锦囊");
        list.add("我的行程");
        recyclerViewUtil.initRecyclerView(rvMy, list, new CustomGridLayoutManager(MyActivity.this, 3),
                MyHolder.class);
    }

    @OnClick({R.id.ib_back, R.id.iv_my_setting, R.id.my_order, R.id.my_coupon, R.id.my_foot_mark, R.id.my_post, R.id.my_answer, R.id.my_mate, R.id.member_recharge, R.id.member_shopping, R.id.my_team, R.id.about_us})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_back:
                onBackPressed();
                break;
            case R.id.iv_my_setting:
                IntentUtil.startActivity(MyActivity.this, MySettingActivity.class);
                break;
            case R.id.my_order:
                IntentUtil.startActivity(MyActivity.this, MyOrderActivity.class);
                break;
            case R.id.my_coupon:
                IntentUtil.startActivity(MyActivity.this, MyCouponActivity.class);
                break;
            case R.id.my_foot_mark:
                Bundle bundle = new Bundle();
                bundle.putString(Constant.MY_FOOT_MACK, "我的足迹");
                IntentUtil.startActivity(MyActivity.this, MyFootMackActivity.class, bundle);
                break;
            case R.id.my_post:
                break;
            case R.id.my_answer:
                IntentUtil.startActivity(MyActivity.this, MyAnswerActivity.class);
                break;
            case R.id.my_mate:
                IntentUtil.startActivity(MyActivity.this, MyMateActivity.class);
                break;
            case R.id.member_recharge:
                IntentUtil.startActivity(MyActivity.this, MemberRechargeActivity.class);
                break;
            case R.id.member_shopping:
                IntentUtil.startActivity(MyActivity.this, MemberShoppingActivity.class);
                break;
            case R.id.my_team:
                IntentUtil.startActivity(MyActivity.this, MyTeamActivity.class);
                break;
            case R.id.about_us:
                IntentUtil.startActivity(MyActivity.this, AboutUsActivity.class);
                break;
        }
    }
}
