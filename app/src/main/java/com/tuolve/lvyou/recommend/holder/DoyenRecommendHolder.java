package com.tuolve.lvyou.recommend.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;
import com.tuolve.lvyou.common.IntentUtil;
import com.tuolve.lvyou.recommend.activity.DoyenRecommendActivity;

import butterknife.Bind;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.doyen_recommend_item)
public class DoyenRecommendHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.iv_doyen_b)
    ImageView ivDoyenB;
    @Bind(R.id.iv_doyen_c)
    CircleImageView ivDoyenC;
    @Bind(R.id.tv_doyen_a)
    TextView tvDoyenA;
    @Bind(R.id.tv_doyen_b)
    TextView tvDoyenB;
    private Context context;

    public DoyenRecommendHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        this.context = context;
//        textViewDoyenName.setText((String) item);
        glideImage.displayImage(context, ivDoyenB);
        glideImage.displayImage(context, ivDoyenC);
    }

    @OnClick(R.id.rl_doyen_recommend)
    public void onViewClicked() {
//        Bundle bundle = new Bundle();
//        bundle.putString(Constant.TITLE,textViewDoyenName.getText().toString());
        IntentUtil.startActivity(context, DoyenRecommendActivity.class);
    }
}
