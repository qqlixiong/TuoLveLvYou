package com.tuolve.lvyou.shopping.selectdiscount;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;
import com.tuolve.lvyou.common.LogUtil;
import com.tuolve.lvyou.common.RecyclerViewUtil;
import com.tuolve.lvyou.view.CustomLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.select_discount_item)
public class SelectDiscountHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.iv_person_message)
    ImageView ivPersonMessage;
    @Bind(R.id.rv_select_fall_price)
    RecyclerView rvSelectFallPrice;
    @Bind(R.id.tv_guess_h)
    TextView tvGuessH;

    public SelectDiscountHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        tvGuessH.setText((String) item);
        glideImage.displayImage(context, ivPersonMessage);
        List<String> list = new ArrayList<>();
        if (position == 0) {
            list.add("588");
            list.add("588");
        } else {
            list.add("358");
            list.add("358");
        }
        RecyclerViewUtil.getInstance().initRecyclerView(rvSelectFallPrice, list,
                new CustomLinearLayoutManager(context), SelectFallPriceHolder.class);
    }
}
