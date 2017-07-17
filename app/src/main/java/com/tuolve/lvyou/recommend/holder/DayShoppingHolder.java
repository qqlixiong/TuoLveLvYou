package com.tuolve.lvyou.recommend.holder;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;
import com.tuolve.lvyou.shopping.indulgence.OddsActivity;
import com.tuolve.lvyou.common.Constant;
import com.tuolve.lvyou.common.IntentUtil;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.day_shopping_item)
public class DayShoppingHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.tv_guess_a)
    TextView textView;
    private Context context;

    public DayShoppingHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        this.context = context;
        textView.setText((String) item);
    }

    @OnClick(R.id.rl_odds)
    public void onViewClicked() {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.TITLE,textView.getText().toString());
        IntentUtil.startActivity(context,OddsActivity.class,bundle);
    }
}
