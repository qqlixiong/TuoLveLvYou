package com.tuolve.lvyou.shopping.selectdiscount;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseActivity;
import com.tuolve.lvyou.common.GlideImage;
import com.tuolve.lvyou.view.CustomLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 精选折扣
 */
public class SelectDiscountActivity extends BaseActivity {

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;
    @Bind(R.id.iv_select_discount)
    ImageView ivSelectDiscount;
    @Bind(R.id.rv_select_discount)
    RecyclerView rvSelectDiscount;

    @Override
    public int getLayoutId() {
        return R.layout.activity_select_discount;
    }

    @Override
    public void initData() {
        super.initData();
        textViewTitleBar.setText("旅游路线推荐");
        GlideImage.getInstance().displayImage(this,ivSelectDiscount);
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> list = new ArrayList<>();
        list.add("香港狄斯尼乐园");
        list.add("黄大仙");
        recyclerViewUtil.initRecyclerView(rvSelectDiscount,list,
                new CustomLinearLayoutManager(this),SelectDiscountHolder.class);
    }

    @OnClick(R.id.ib_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
