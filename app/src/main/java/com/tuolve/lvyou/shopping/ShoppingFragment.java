package com.tuolve.lvyou.shopping;


import android.support.v7.widget.RecyclerView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseBannerFragment;
import com.tuolve.lvyou.recommend.holder.DayShoppingHolder;
import com.tuolve.lvyou.recommend.holder.GuessLikeSeasonShoppingHolder;
import com.tuolve.lvyou.recommend.holder.HotSeasonShoppingHolder;
import com.tuolve.lvyou.recommend.holder.TitleShoppingHolder;
import com.tuolve.lvyou.shopping.holder.ChoiceShoppingHolder;
import com.tuolve.lvyou.view.CustomGridLayoutManager;
import com.tuolve.lvyou.view.CustomLinearLayoutManager;
import com.tuolve.lvyou.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 商城
 */
public class ShoppingFragment extends BaseBannerFragment {
    @Bind(R.id.rv_shopping)
    RecyclerView recyclerView;
    @Bind(R.id.rv_shopping_day)
    RecyclerView recyclerViewDay;
    @Bind(R.id.rv_choice)
    RecyclerView recyclerViewChoice;
    @Bind(R.id.rv_hot_season)
    RecyclerView recyclerViewHotSeason;
    @Bind(R.id.rv_guess_like)
    RecyclerView recyclerViewGuessLike;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_shopping;
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> list = new ArrayList<>();
        list.add("机加酒");
        list.add("出境游");
        list.add("国内游");
        list.add("酒店");
        list.add("旅行周边");
        list.add("签证");
        list.add("自由行");
        list.add("旅游保险");
        list.add("接送包车");
        list.add("邮轮");
        recyclerViewUtil.initRecyclerView(recyclerView,list,new CustomGridLayoutManager(mContext,5),
                TitleShoppingHolder.class);

        List<String> listDay = new ArrayList<>();
        listDay.add("天天特惠");
        listDay.add("上新精品");
        listDay.add("尾货甩单");
        listDay.add("拼团特卖");
        recyclerViewUtil.initRecyclerView(recyclerViewDay,listDay,new CustomGridLayoutManager(
                mContext,2),DayShoppingHolder.class);

        List<String> listChoice = new ArrayList<>();
        listChoice.add("省万元,五星马尔代夫");
        listChoice.add("四月行XXXXX优惠券");
        recyclerViewUtil.initRecyclerView(recyclerViewChoice,listChoice,new CustomLinearLayoutManager(
                mContext),new DividerListItemDecoration(mContext,DividerListItemDecoration.VERTICAL_LIST,false),
                ChoiceShoppingHolder.class);

        List<Integer> listHot = new ArrayList<>();
        listHot.add(R.mipmap.ic_launcher);
        listHot.add(R.mipmap.ic_launcher);
        listHot.add(R.mipmap.ic_launcher);
        recyclerViewUtil.initRecyclerView(recyclerViewHotSeason,listHot,new CustomLinearLayoutManager(
                mContext),HotSeasonShoppingHolder.class);

        List<String> listGuessLike = new ArrayList<>();
        listGuessLike.add("香港迪斯尼乐园");
        listGuessLike.add("青马大桥");
        listGuessLike.add("黄大仙XXX");
        recyclerViewUtil.initRecyclerView(recyclerViewGuessLike,listGuessLike,
                new CustomLinearLayoutManager(mContext),
                new DividerListItemDecoration(mContext,DividerListItemDecoration.VERTICAL_LIST,true),
                GuessLikeSeasonShoppingHolder.class);
    }
}
