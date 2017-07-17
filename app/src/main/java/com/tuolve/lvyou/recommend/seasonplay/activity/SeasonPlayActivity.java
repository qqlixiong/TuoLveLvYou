package com.tuolve.lvyou.recommend.seasonplay.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseGlideActivity;
import com.tuolve.lvyou.recommend.holder.GuessLikeSeasonShoppingHolder;
import com.tuolve.lvyou.common.Constant;
import com.tuolve.lvyou.common.IntentUtil;
import com.tuolve.lvyou.recommend.seasonplay.viewholder.GuessLikeHolder;
import com.tuolve.lvyou.view.CustomLinearLayoutManager;
import com.tuolve.lvyou.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class SeasonPlayActivity extends BaseGlideActivity {

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;
    @Bind(R.id.iv_guess_like_head)
    ImageView ivGuessLikeHead;
    @Bind(R.id.rv_select_product_type)
    RecyclerView rvSelectProductType;
    @Bind(R.id.fl_guess_like)
    FrameLayout flGuessLike;

    @Override
    public int getLayoutId() {
        return R.layout.activity_season_play;
    }

    @Override
    protected void initView() {
        super.initView();
        GuessLikeHolder guessLikeHolder = new GuessLikeHolder();
        flGuessLike.addView(guessLikeHolder.getView());
    }

    @Override
    public void initData() {
        super.initData();
        textViewTitleBar.setText("香港迪士尼乐园");
        glideImage.displayImage(this, ivGuessLikeHead);
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> listGuessLike = new ArrayList<>();
        listGuessLike.add("香港迪斯尼乐园");
        listGuessLike.add("青马大桥");
        listGuessLike.add("黄大仙XXX");
        recyclerViewUtil.initRecyclerView(rvSelectProductType,listGuessLike,
                new CustomLinearLayoutManager(this),
                new DividerListItemDecoration(this,DividerListItemDecoration.VERTICAL_LIST,true),
                GuessLikeSeasonShoppingHolder.class);
    }

    @OnClick({R.id.ib_back,R.id.tv_immediate_reservation})
    public void onViewClicked(View v) {
        switch (v.getId()){
            case R.id.ib_back:
                onBackPressed();
                break;

            case R.id.tv_immediate_reservation:
                Bundle bundle = new Bundle();
                bundle.putString(Constant.TITLE,textViewTitleBar.getText().toString());
                IntentUtil.startActivity(this,ImmediateReservationActivity.class,bundle);
                break;
        }
    }
}
