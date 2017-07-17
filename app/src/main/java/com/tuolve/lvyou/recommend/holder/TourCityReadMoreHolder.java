package com.tuolve.lvyou.recommend.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;

import butterknife.Bind;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.tour_city_read_more_item)
public class TourCityReadMoreHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.tv_tour_city_read_more_name)
    TextView tvTourCityReadMoreName;
    @Bind(R.id.iv_tour_city_read_more)
    ImageView ivTourCityReadMore;

    public TourCityReadMoreHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        tvTourCityReadMoreName.setText((String) item);
        glideImage.displayImage(context,ivTourCityReadMore);
    }
}
