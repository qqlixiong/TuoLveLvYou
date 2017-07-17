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
@RecyclerItemViewId(R.layout.feature_spot_pic_item)
public class FeatureSpotPicHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.textView_feature_spot_pic_name)
    TextView textViewFeatureSpotPicName;
    @Bind(R.id.iv_feature_spot_pic)
    ImageView ivFeatureSpotPic;

    public FeatureSpotPicHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        textViewFeatureSpotPicName.setText((String) item);
        glideImage.displayImage(context,ivFeatureSpotPic);
    }
}
