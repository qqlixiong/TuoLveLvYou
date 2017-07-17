package com.tuolve.lvyou.recommend.seasonplay.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;

import butterknife.Bind;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.select_fall_c_price_item)
public class SelectPriceHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.tv_scenic_play_sub_price)
    TextView tvScenicPlaySubPrice;

    public SelectPriceHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        tvScenicPlaySubPrice.setText((String) item);
    }
}
