package com.tuolve.lvyou.recommend.holder;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.my.activity.MyCollectActivity;
import com.tuolve.lvyou.my.activity.MyCultureActivity;
import com.tuolve.lvyou.my.activity.MyFootMackActivity;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;
import com.tuolve.lvyou.common.Constant;
import com.tuolve.lvyou.common.IntentUtil;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.title_shopping_item)
public class MyHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.iv_person_message)
    ImageView imageView;
    @Bind(R.id.tv_guess_a)
    TextView textView;
    private int position;
    private Context context;

    public MyHolder(View itemView) {
        super(itemView);
    }

    @OnClick(R.id.rl_title_shopping)
    void onclick() {
        switch (position) {
            case 0:
                IntentUtil.startActivity(context, MyCollectActivity.class);
                break;

            case 1:
                IntentUtil.startActivity(context, MyCultureActivity.class);
                break;

            case 2:
                Bundle bundle = new Bundle();
                bundle.putString(Constant.MY_FOOT_MACK,"我的行程");
                IntentUtil.startActivity(context,MyFootMackActivity.class,bundle);
                break;
        }
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        this.position = position;
        this.context = context;
        textView.setText((String) item);
        glideImage.displayImage(context,imageView);
    }
}
