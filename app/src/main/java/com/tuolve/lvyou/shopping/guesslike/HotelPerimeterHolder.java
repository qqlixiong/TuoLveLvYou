package com.tuolve.lvyou.shopping.guesslike;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;
import com.tuolve.lvyou.common.Constant;
import com.tuolve.lvyou.common.IntentUtil;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.hotel_perimeter_item)
public class HotelPerimeterHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.iv_hotel_perimeter)
    ImageView ivHotelPerimeter;
    @Bind(R.id.tv_hotel_perimeter_name)
    TextView tvHotelPerimeterName;
    private Context context;

    public HotelPerimeterHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        this.context = context;
        tvHotelPerimeterName.setText((String) item);
        glideImage.displayImage(context, ivHotelPerimeter);
    }

    @OnClick(R.id.rl_hotel_perimeter)
    public void onViewClicked() {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.TITLE,tvHotelPerimeterName.getText().toString());
        IntentUtil.startActivity(context,HotelPerimeterActivity.class,bundle);
    }
}
