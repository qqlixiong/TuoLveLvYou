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
@RecyclerItemViewId(R.layout.tribe_person_item)
public class TribePersonMessageHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.textView_name)
    TextView textViewName;
    @Bind(R.id.imageView_head)
    ImageView mImageViewHead;
    @Bind(R.id.imageView4)
    ImageView mImageView4;
    @Bind(R.id.imageView5)
    ImageView mImageView5;
    @Bind(R.id.imageView6)
    ImageView mImageView6;

    public TribePersonMessageHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        textViewName.setText((String) item);
        glideImage.displayImage(context,mImageViewHead,mImageView4,mImageView5,mImageView6);
    }
}
