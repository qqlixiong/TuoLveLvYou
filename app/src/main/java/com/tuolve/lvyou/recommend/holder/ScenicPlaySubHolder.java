package com.tuolve.lvyou.recommend.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;

import java.util.List;

import butterknife.Bind;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.scenic_play_sub_item)
public class ScenicPlaySubHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.tv_scenic_play_sub_price)
    TextView tvScenicPlaySubPrice;
    @Bind(R.id.tv_scenic_play_sub_title)
    TextView tvScenicPlaySubTitle;

    public ScenicPlaySubHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        List<String> list = (List<String>) item;
        tvScenicPlaySubTitle.setText(list.get(0));
        tvScenicPlaySubPrice.setText(list.get(1));
    }
}
