package com.tuolve.lvyou.recommend.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.common.GlideImage;
import com.tuolve.lvyou.common.IntentUtil;
import com.tuolve.lvyou.base.BaseGlideActivity;
import com.tuolve.lvyou.common.RecyclerViewUtil;
import com.tuolve.lvyou.interfaces.IActivity;
import com.tuolve.lvyou.interfaces.IGlideImageActivity;
import com.tuolve.lvyou.interfaces.IRecyclerViewActivity;
import com.tuolve.lvyou.recommend.holder.ProvidePlayHolder;
import com.tuolve.lvyou.view.CustomLinearLayoutManager;
import com.tuolve.lvyou.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class DoyenRecommendActivity extends AppCompatActivity implements IActivity,IRecyclerViewActivity,IGlideImageActivity{

    @Bind(R.id.rv_provide_play)
    RecyclerView rvProvidePlay;
    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;
    @Bind(R.id.iv_doyen_a)
    ImageView ivDoyenA;

    @Override
    public int getLayoutId() {
        return R.layout.activity_doyen_recommend;
    }

    @Override
    public void initData() {
//        tvDoyen.setText(getIntent().getExtras().getString(Constant.TITLE));
//        glideImage.displayImage(this, ivDoyen);
        textViewTitleBar.setText("达人主页");

    }

    @Override
    public void setListener() {

    }

    @OnClick({R.id.ib_back, R.id.tv_seek_doyen})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_back:
                onBackPressed();
                break;
            case R.id.tv_seek_doyen:
                IntentUtil.startActivity(this, SeekDoyenActivity.class);
                break;
        }
    }

    @Override
    public void initGlideImage(GlideImage glideImage) {
        glideImage.displayImage(this,ivDoyenA);
    }

    @Override
    public void initRecyclerView(RecyclerViewUtil recyclerViewUtil) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("青马大桥");
        }
        recyclerViewUtil.initNSVRecyclerView(rvProvidePlay, list,
                new CustomLinearLayoutManager(this),
                new DividerListItemDecoration(this, DividerListItemDecoration.VERTICAL_LIST, true),
                ProvidePlayHolder.class);
    }
}
