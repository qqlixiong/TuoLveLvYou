package com.tuolve.lvyou.shopping.guesslike;

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
@RecyclerItemViewId(R.layout.hotel_item)
public class HotelHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.iv_hotel)
    ImageView ivHotel;
    @Bind(R.id.tv_hotel_name)
    TextView tvHotelName;

    public HotelHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        tvHotelName.setText((String) item);
        glideImage.displayImage(context, ivHotel);
    }
}
