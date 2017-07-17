package com.tuolve.lvyou.shopping.indulgence.holder;

import android.content.Context;
import android.graphics.Paint;
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
@RecyclerItemViewId(R.layout.odds_item)
public class OddsHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.iv_odds)
    ImageView ivOdds;
    @Bind(R.id.tv_odds_title)
    TextView tvOddsTitle;
    @Bind(R.id.tv_old_price)
    TextView tvOldPrice;

    public OddsHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        tvOddsTitle.setText((String) item);
        glideImage.displayImage(context, ivOdds);
        tvOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }
}
