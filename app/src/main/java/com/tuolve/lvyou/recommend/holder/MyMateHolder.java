package com.tuolve.lvyou.recommend.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;

import java.util.List;

import butterknife.Bind;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.my_mate_item)
public class MyMateHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.textView_content)
    TextView textViewContent;
    @Bind(R.id.textView_area)
    TextView textViewArea;
    @Bind(R.id.tv_place)
    TextView ivPlace;
    @Bind(R.id.imageView_head)
    ImageView mImageViewHead;

    public MyMateHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        List<String> list = (List<String>) item;
        textViewContent.setText(list.get(0));
        textViewArea.setText(list.get(1));
        ivPlace.setText(list.get(2));
        glideImage.displayImage(context,mImageViewHead);
    }
}
