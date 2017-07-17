package com.tuolve.lvyou.recommend.activity;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseGlideActivity;
import com.tuolve.lvyou.recommend.holder.CiceroneHolder;
import com.tuolve.lvyou.view.CustomLinearLayoutManager;
import com.tuolve.lvyou.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 咨询达人
 */
public class SeekDoyenActivity extends BaseGlideActivity {

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;
    @Bind(R.id.iv_seek_doyen_head)
    ImageView ivSeekDoyenHead;
    @Bind(R.id.iv_seek_doyen_play)
    ImageView ivSeekDoyenPlay;
    @Bind(R.id.rv_seek_doyen_cicerone)
    RecyclerView rvSeekDoyenCicerone;

    @Override
    public int getLayoutId() {
        return R.layout.activity_seek_doyen;
    }

    @Override
    public void initData() {
        super.initData();
        textViewTitleBar.setText("咨询");
        glideImage.displayImage(this, ivSeekDoyenHead);
        glideImage.displayImage(this, ivSeekDoyenPlay);
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> list = new ArrayList<>();
        list.add("徒步导游,包括当天徒步接送机服务");
        list.add("带车导游");
        recyclerViewUtil.initNSVRecyclerView(rvSeekDoyenCicerone,list,
                new CustomLinearLayoutManager(this),
                new DividerListItemDecoration(this,DividerListItemDecoration.VERTICAL_LIST,false),
                CiceroneHolder.class);
    }

    @OnClick({R.id.ib_back, R.id.iv_seek_doyen_go})
    public void onViewClicked() {
        onBackPressed();
    }
}
