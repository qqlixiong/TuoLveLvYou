package com.tuolve.lvyou.tribe.holder;

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
@RecyclerItemViewId(R.layout.tribe_news_item)
public class TribeMessageHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.iv_person_message)
    ImageView imageView;
    @Bind(R.id.tv_guess_a)
    TextView textView;

    public TribeMessageHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        textView.setText((String) item);
        glideImage.displayImage(context,imageView);
    }
}

