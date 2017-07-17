package com.tuolve.lvyou.shopping.guesslike;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;

import butterknife.Bind;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.comments_pic_item)
public class AllCommentsPicHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.iv_comments_pic)
    ImageView ivCommentsPic;

    public AllCommentsPicHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        glideImage.displayImage(context, ivCommentsPic);
    }
}
