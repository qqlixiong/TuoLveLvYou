package com.tuolve.lvyou.recommend.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;
import com.tuolve.lvyou.common.ViewUtils;

import butterknife.Bind;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.my_order_item)
public class MyOrderHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_immediate_pay)
    TextView tvImmediatePly;
    @Bind(R.id.tv_time_quantum)
    TextView tvTimeQuantum;
    @Bind(R.id.tv_after_sales)
    TextView tvAfterSales;

    public MyOrderHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        tvTitle.setText((String) item);
        if(position == 0){
            ViewUtils.hideView(tvAfterSales);
        }
        if(position == 1){
            ViewUtils.hideView(tvTimeQuantum);
            tvImmediatePly.setText("已支付");
        }
        if(position == 2){
            ViewUtils.hideView(tvTimeQuantum);
            tvImmediatePly.setText("已完成");
            tvAfterSales.setText("去评价");
        }
    }
}
