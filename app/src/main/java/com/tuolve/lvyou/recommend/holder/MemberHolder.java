package com.tuolve.lvyou.recommend.holder;

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
@RecyclerItemViewId(R.layout.member_item)
public class MemberHolder extends ModelRecyclerAdapter.ModelViewHolder {
    @Bind(R.id.tv_guess_a)
    TextView textView;
    @Bind(R.id.iv_person_message)
    ImageView ivPersonMessage;
    private Context context;

    public MemberHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        this.context = context;
        textView.setText((String) item);
        glideImage.displayImage(context, ivPersonMessage);
    }

    @OnClick(R.id.rl_member)
    public void onViewClicked() {
        IntentUtil.startActivity(context,SelectDiscountActivity.class);
    }
}
