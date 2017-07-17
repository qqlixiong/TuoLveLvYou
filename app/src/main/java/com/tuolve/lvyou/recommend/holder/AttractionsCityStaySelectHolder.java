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
@RecyclerItemViewId(R.layout.attractions_city_stay_select_item)
public class AttractionsCityStaySelectHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.textView_attraction_city_stay_select_name)
    TextView textViewAttractionCityStaySelectName;
    @Bind(R.id.iv_attraction_city_stay_select)
    ImageView ivAttractionCityStaySelect;

    public AttractionsCityStaySelectHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        textViewAttractionCityStaySelectName.setText((String) item);
        glideImage.displayImage(context,ivAttractionCityStaySelect);
    }
}
