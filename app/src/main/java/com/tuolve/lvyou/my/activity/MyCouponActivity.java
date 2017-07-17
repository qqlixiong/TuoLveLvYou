package com.tuolve.lvyou.my.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.common.RecyclerViewUtil;
import com.tuolve.lvyou.interfaces.IActivity;
import com.tuolve.lvyou.interfaces.IRecyclerViewActivity;
import com.tuolve.lvyou.recommend.holder.MyCouponHolder;
import com.tuolve.lvyou.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的优惠券
 */
public class MyCouponActivity extends AppCompatActivity implements IActivity,IRecyclerViewActivity{

    @Bind(R.id.textView_title_bar)
    TextView textViewTitle;
    @Bind(R.id.rv_my_coupon)
    RecyclerView rvMyCoupon;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_coupon;
    }

    @Override
    public void initData() {
        textViewTitle.setText("我的优惠券");
    }

    @Override
    public void setListener() {

    }

    @OnClick(R.id.ib_back)
    public void onViewClicked() {
        onBackPressed();
    }

    @Override
    public void initRecyclerView(RecyclerViewUtil recyclerViewUtil) {
        List<String> list = new ArrayList<>();
        list.add("满一百减二十");
        list.add("满一百减二十");
        list.add("满一百减二十");
        list.add("满一百减二十");
        list.add("满一百减二十");
        list.add("满一百减二十");
        list.add("满一百减二十");
        list.add("满一百减二十");
        list.add("满一百减二十");
        list.add("满一百减二十");
        recyclerViewUtil.initRecyclerView(rvMyCoupon,list,new LinearLayoutManager(MyCouponActivity.this),
                new DividerListItemDecoration(MyCouponActivity.this,DividerListItemDecoration.VERTICAL_LIST,
                        true),MyCouponHolder.class);
    }
}
