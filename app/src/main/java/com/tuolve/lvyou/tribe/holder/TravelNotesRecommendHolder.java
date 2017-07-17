package com.tuolve.lvyou.tribe.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;

import butterknife.Bind;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.travel_recommend_item)
public class TravelNotesRecommendHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.iv_person_message)
    ImageView ivPersonMessage;
    @Bind(R.id.textView_travel)
    TextView textViewTravel;
    @Bind(R.id.imageView_pic)
    CircleImageView imageViewPic;

    public TravelNotesRecommendHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        textViewTravel.setText((String) item);
        glideImage.displayImage(context, ivPersonMessage);
        glideImage.displayImage(context, imageViewPic);
    }
}
