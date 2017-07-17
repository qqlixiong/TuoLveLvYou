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
@RecyclerItemViewId(R.layout.my_foot_mack_item)
public class MyFootMackHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.textView_num)
    TextView tvNum;
    @Bind(R.id.iv_person_message)
    ImageView ivPersonMessage;

    public MyFootMackHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        tvNum.setText((String) item);
        glideImage.displayImage(context,ivPersonMessage);
    }
}
