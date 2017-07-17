package com.tuolve.lvyou.recommend.holder;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.my.activity.TourCityActivity;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;
import com.tuolve.lvyou.common.Constant;
import com.tuolve.lvyou.common.IntentUtil;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.destination_city_item)
public class DestinationCityHolder extends ModelRecyclerAdapter.ModelViewHolder {
    @Bind(R.id.iv_person_message)
    ImageView imageView;
    @Bind(R.id.tv_guess_a)
    TextView textViewCity;
    private Context context;
    private String cityName;

    public DestinationCityHolder(View itemView) {
        super(itemView);
    }

    @OnClick(R.id.rl_destination_city)
    void onclick() {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.MY_TOUR_CITY,cityName);
        IntentUtil.startActivity(context, TourCityActivity.class,bundle);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        this.context = context;
        cityName = (String) item;
        textViewCity.setText(cityName);
        glideImage.displayImage(context,imageView);
    }
}
