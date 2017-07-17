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
@RecyclerItemViewId(R.layout.my_coupon_item)
public class MyCouponHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.textView_sale)
    TextView tvSale;
    @Bind(R.id.imageView10)
    ImageView mImageView10;

    public MyCouponHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        tvSale.setText((String) item);
        glideImage.displayImage(context,mImageView10);
    }
}
