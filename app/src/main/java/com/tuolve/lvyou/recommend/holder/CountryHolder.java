package com.tuolve.lvyou.recommend.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;

import java.util.List;

import butterknife.Bind;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.country_item)
public class CountryHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.imageView_country)
    ImageView imageViewCountry;
    @Bind(R.id.textView_collect_destination_num)
    TextView textViewCollectDestinationNum;
    @Bind(R.id.textView_country)
    TextView textViewCountry;

    public CountryHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        List<String> list = (List<String>) item;
        textViewCountry.setText(list.get(0));
        textViewCollectDestinationNum.setText(list.get(1));
        glideImage.displayImage(context,imageViewCountry);
    }
}
