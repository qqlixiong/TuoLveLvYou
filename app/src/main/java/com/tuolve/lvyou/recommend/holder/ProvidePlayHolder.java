package com.tuolve.lvyou.recommend.holder;

import android.content.Context;
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
@RecyclerItemViewId(R.layout.provide_play_a_item)
public class ProvidePlayHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.iv_provide_play)
    ImageView ivProvidePlay;
    @Bind(R.id.tv_provide_play)
    TextView tvProvidePlay;

    public ProvidePlayHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        tvProvidePlay.setText((String) item);
        glideImage.displayImage(context, ivProvidePlay);
    }
}
