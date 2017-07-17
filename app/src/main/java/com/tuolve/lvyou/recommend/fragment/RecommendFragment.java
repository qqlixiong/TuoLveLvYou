package com.tuolve.lvyou.recommend.fragment;

import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseBannerFragment;
import com.tuolve.lvyou.recommend.holder.AnnouncementRecommendHolder;
import com.tuolve.lvyou.recommend.viewholder.HotRecommendHolder;
import com.tuolve.lvyou.tribe.holder.TravelNotesRecommendHolder;
import com.tuolve.lvyou.view.CustomLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 推荐首页
 */
public class RecommendFragment extends BaseBannerFragment {
    @Bind(R.id.rv_announcement)
    RecyclerView recyclerViewAnnouncement;
    @Bind(R.id.rv_travel_notes)
    RecyclerView recyclerViewTravelNotes;
    @Bind(R.id.rv_answer)
    RecyclerView recyclerViewAnswer;
    @Bind(R.id.fl_hot_recommend)
    FrameLayout flHotRecommend;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView() {
        super.initView();
        HotRecommendHolder hotRecommendHolder = new HotRecommendHolder();
        hotRecommendHolder.setGlideImage(mContext,glideImage);
        flHotRecommend.addView(hotRecommendHolder.getView());
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> list = new ArrayList<>();
        list.add("公告");
        recyclerViewUtil.initRecyclerView(recyclerViewAnnouncement,list,new CustomLinearLayoutManager(mContext),
                AnnouncementRecommendHolder.class);

        List<String> listTravelNotes = new ArrayList<>();
        listTravelNotes.add("游记");
        recyclerViewUtil.initRecyclerView(recyclerViewTravelNotes,listTravelNotes,
                new CustomLinearLayoutManager(mContext),TravelNotesRecommendHolder.class);

        List<String> listAnswer = new ArrayList<>();
        listAnswer.add("问答");
        recyclerViewUtil.initRecyclerView(recyclerViewAnswer,listAnswer,
                new CustomLinearLayoutManager(mContext),AnnouncementRecommendHolder.class);
    }
}
