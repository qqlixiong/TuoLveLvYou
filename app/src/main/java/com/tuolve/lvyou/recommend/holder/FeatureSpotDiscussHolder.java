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
@RecyclerItemViewId(R.layout.feature_spot_discuss_item)
public class FeatureSpotDiscussHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.textView_feature_spot_discuss)
    TextView textViewFeatureSpotDiscuss;
    @Bind(R.id.iv_feature_spot_pic)
    ImageView ivFeatureSpotPic;

    public FeatureSpotDiscussHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        textViewFeatureSpotDiscuss.setText((String) item);
        glideImage.displayImage(context,ivFeatureSpotPic);
    }
}
