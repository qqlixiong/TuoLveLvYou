package com.tuolve.lvyou.shopping.selectdiscount;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;
import com.tuolve.lvyou.common.GlideImage;

import butterknife.Bind;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.select_fall_price_f_item)
public class SelectFallPriceHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.tv_scenic_play_sub_price)
    TextView tvScenicPlaySubPrice;
    @Bind(R.id.iv_a)
    ImageView ivA;

    public SelectFallPriceHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        tvScenicPlaySubPrice.setText((String) item);
        GlideImage.getInstance().displayImage(context,ivA);
    }
}
