package com.tuolve.lvyou.shopping.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;
import com.tuolve.lvyou.shopping.selectdiscount.SelectDiscountActivity;
import com.tuolve.lvyou.common.IntentUtil;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.choice_shopping_item)
public class ChoiceShoppingHolder extends ModelRecyclerAdapter.ModelViewHolder {
    @Bind(R.id.textView_title_bar)
    TextView textViewTitle;
    @Bind(R.id.iv_person_message)
    ImageView imageView;
    @Bind(R.id.textView_describe)
    TextView textViewDescribe;
    private Context context;

    public ChoiceShoppingHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        this.context = context;
        textViewTitle.setText((String) item);
        glideImage.displayImage(context, imageView);
    }

    @OnClick(R.id.rl_choice_shopping)
    public void onViewClicked() {
        IntentUtil.startActivity(context,SelectDiscountActivity.class);
    }
}
