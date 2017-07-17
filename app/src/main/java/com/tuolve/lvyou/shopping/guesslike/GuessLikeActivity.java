package com.tuolve.lvyou.shopping.guesslike;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseActivity;
import com.tuolve.lvyou.base.BaseGlideActivity;
import com.tuolve.lvyou.recommend.seasonplay.activity.SeasonPlayActivity;
import com.tuolve.lvyou.common.Constant;
import com.tuolve.lvyou.common.GlideImage;
import com.tuolve.lvyou.common.IntentUtil;
import com.tuolve.lvyou.view.CustomLinearLayoutManager;
import com.tuolve.lvyou.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 香港狄斯尼乐园
 */
public class GuessLikeActivity extends BaseGlideActivity {

    /*@Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;*/
    @Bind(R.id.iv_guess_like_head)
    ImageView ivGuessLikeHead;
    @Bind(R.id.iv_guess_like_rebate)
    ImageView ivGuessLikeRebate;
    @Bind(R.id.rv_all_comments)
    RecyclerView rvAllComments;
    @Bind(R.id.rv_guess_like_hotel_perimeter)
    RecyclerView rvGuessLikeHotelPerimeter;
    @Bind(R.id.fl_look_map)
    FrameLayout flLookMap;

    @Override
    public int getLayoutId() {
        return R.layout.activity_guess_like;
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            list.add("昵称");
        }
        recyclerViewUtil.initRecyclerView(rvAllComments, list,
                new CustomLinearLayoutManager(this),
                new DividerListItemDecoration(this, DividerListItemDecoration.VERTICAL_LIST, true),
                AllCommentsHolder.class);
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add("迪士尼乐园酒店");
        }
        recyclerViewUtil.initRecyclerView(rvGuessLikeHotelPerimeter, list1,
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false),
                HotelPerimeterHolder.class);
    }

    @Override
    public void initData() {
        super.initData();
//        textViewTitleBar.setText(getIntent().getExtras().getString(Constant.TITLE));
        LookMapHolder lookMapHolder = new LookMapHolder();
        lookMapHolder.setGlideImage(this,glideImage);
        flLookMap.addView(lookMapHolder.getView());
        GlideImage.getInstance().displayImage(this, ivGuessLikeHead,ivGuessLikeRebate);
    }

    @OnClick({R.id.iv_back_a, R.id.ll_guess_like_rebate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back_a:
                onBackPressed();
                break;
            case R.id.ll_guess_like_rebate:
                IntentUtil.startActivity(this,SeasonPlayActivity.class);
                break;
        }
    }
}
