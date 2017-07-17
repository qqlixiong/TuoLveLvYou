package com.tuolve.lvyou.recommend.holder;

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
@RecyclerItemViewId(R.layout.cicerone_item)
public class CiceroneHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.tv_guide_way)
    TextView tvGuideWay;
    @Bind(R.id.tv_guide_day_money)
    TextView tvGuideDayMoney;

    public CiceroneHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        tvGuideWay.setText((String) item);
        if(position == 0){
            tvGuideDayMoney.setText("￥910/天");
        }else {
            tvGuideDayMoney.setText("￥1700/天/车");
        }
    }
}
