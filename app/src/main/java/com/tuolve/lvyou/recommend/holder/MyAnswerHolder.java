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
@RecyclerItemViewId(R.layout.my_answer_item)
public class MyAnswerHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.textView_name)
    TextView textViewName;
    @Bind(R.id.textView_person)
    TextView textViewPerson;
    @Bind(R.id.tv_place)
    TextView ivPlace;
    @Bind(R.id.textView_content)
    TextView textViewContent;
    @Bind(R.id.imageView_head)
    ImageView imageViewHead;

    public MyAnswerHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        List<String> list = (List<String>) item;
        textViewContent.setText(list.get(0));
        textViewPerson.setText(list.get(1));
        ivPlace.setText(list.get(2));
        glideImage.displayImage(context,imageViewHead);
    }
}
