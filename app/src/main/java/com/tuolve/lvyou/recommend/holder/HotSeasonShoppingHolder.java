package com.tuolve.lvyou.recommend.holder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;
import com.tuolve.lvyou.recommend.seasonplay.holder.SeasonPlayRecommendHolder;
import com.tuolve.lvyou.common.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.hot_season_item)
public class HotSeasonShoppingHolder extends ModelRecyclerAdapter.ModelViewHolder {
    @Bind(R.id.iv_person_message)
    ImageView imageView;
    @Bind(R.id.rv_hot_season_item)
    RecyclerView rvHotSeasonItem;

    public HotSeasonShoppingHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        int id = (int) item;
        glideImage.displayImage(context,imageView);
        List<String> list = new ArrayList<>();
        list.add("寻找镜头下的风景");
        list.add("寻找镜头下的风景");
        list.add("寻找镜头下的风景");
        RecyclerViewUtil.getInstance().initRecyclerView(rvHotSeasonItem,list,new LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL, false),SeasonPlayRecommendHolder.class);
    }
}
