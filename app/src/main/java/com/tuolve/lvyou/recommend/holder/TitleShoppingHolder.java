package com.tuolve.lvyou.recommend.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;
import com.tuolve.lvyou.shopping.scenicplay.ScenicPlayActivity;
import com.tuolve.lvyou.common.IntentUtil;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.title_shopping_item)
public class TitleShoppingHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.iv_person_message)
    ImageView imageView;
    @Bind(R.id.tv_guess_a)
    TextView textView;
    private Context context;

    public TitleShoppingHolder(View itemView) {
        super(itemView);
    }

    @OnClick(R.id.rl_title_shopping)
    void onClick(){
        IntentUtil.startActivity(context, ScenicPlayActivity.class);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        this.context = context;
        textView.setText((String) item);
    }
}
