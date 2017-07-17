package com.tuolve.lvyou.recommend.holder;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;
import com.tuolve.lvyou.recommend.seasonplay.viewholder.GuessHolder;
import com.tuolve.lvyou.shopping.guesslike.GuessLikeActivity;
import com.tuolve.lvyou.common.Constant;
import com.tuolve.lvyou.common.IntentUtil;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.guess_like_a_item)
public class GuessLikeSeasonShoppingHolder extends ModelRecyclerAdapter.ModelViewHolder {
    @Bind(R.id.tv_guess_a)
    TextView textView;
    @Bind(R.id.iv_person_message)
    ImageView ivPersonMessage;
    @Bind(R.id.fl_guess_layout)
    FrameLayout flGuess;
    private Context context;

    public GuessLikeSeasonShoppingHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        this.context = context;
        textView.setText((String) item);
        glideImage.displayImage(context, ivPersonMessage);
        if(position == 0){
            GuessHolder guessHolder = new GuessHolder(context);
            flGuess.addView(guessHolder.getView());
        }
    }

    @OnClick(R.id.rl_guess_like)
    public void onViewClicked() {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.TITLE,textView.getText().toString());
        IntentUtil.startActivity(context,GuessLikeActivity.class,bundle);
    }
}
