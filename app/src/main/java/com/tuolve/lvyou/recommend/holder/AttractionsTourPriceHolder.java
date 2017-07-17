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
@RecyclerItemViewId(R.layout.attractions_tour_price_item)
public class AttractionsTourPriceHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.tv_attractions_tour_price)
    TextView tvAttractionsTourPrice;
    @Bind(R.id.iv_attractions_tour_price)
    ImageView ivAttractionsTourPrice;

    public AttractionsTourPriceHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        tvAttractionsTourPrice.setText((String) item);
        glideImage.displayImage(context,ivAttractionsTourPrice);
    }
}
