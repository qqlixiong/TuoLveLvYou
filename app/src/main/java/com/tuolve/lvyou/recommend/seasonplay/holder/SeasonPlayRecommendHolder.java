package com.tuolve.lvyou.recommend.seasonplay.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;
import com.tuolve.lvyou.common.IntentUtil;
import com.tuolve.lvyou.recommend.seasonplay.activity.SeasonPlayActivity;

import butterknife.Bind;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.season_play_item)
public class SeasonPlayRecommendHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.iv_play_a)
    ImageView ivPlayA;
    @Bind(R.id.tv_play_a)
    TextView tvPlayA;
    @Bind(R.id.tv_play_b)
    TextView tvPlayB;
    @Bind(R.id.tv_play_c)
    TextView tvPlayC;
    @Bind(R.id.rb_play_a)
    RatingBar rbPlayA;
    @Bind(R.id.iv_play_b)
    CircleImageView ivPlayB;
    @Bind(R.id.tv_play_d)
    TextView tvPlayD;
    @Bind(R.id.tv_play_e)
    TextView tvPlayE;
    @Bind(R.id.iv_play_c)
    ImageView ivPlayC;
    private Context context;

    public SeasonPlayRecommendHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        this.context = context;
        tvPlayA.setText((String) item);
        glideImage.displayImage(context, ivPlayA);
        glideImage.displayImage(context, ivPlayB);
    }

    @OnClick(R.id.rl_season_play)
    public void onViewClicked() {
        IntentUtil.startActivity(context, SeasonPlayActivity.class);
    }
}
