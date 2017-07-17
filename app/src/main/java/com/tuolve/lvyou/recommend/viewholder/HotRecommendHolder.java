package com.tuolve.lvyou.recommend.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseGlideHolder;
import com.tuolve.lvyou.common.GlideImage;
import com.tuolve.lvyou.common.IntentUtil;
import com.tuolve.lvyou.common.UIUtils;
import com.tuolve.lvyou.shopping.selectdiscount.SelectDiscountActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by john on 2017/5/15.
 */

public class HotRecommendHolder extends BaseGlideHolder {

    @Bind(R.id.iv_b)
    ImageView ivB;
    @Bind(R.id.tv_b)
    TextView tvB;
    @Bind(R.id.iv_c)
    ImageView ivC;
    @Bind(R.id.tv_c)
    TextView tvC;
    @Bind(R.id.iv_f)
    ImageView ivF;
    @Bind(R.id.tv_f)
    TextView tvF;
    @Bind(R.id.ratingBar_f)
    RatingBar ratingBarF;
    @Bind(R.id.tv_f_x)
    TextView tvFX;
    @Bind(R.id.tv_f_a)
    TextView tvFA;
    @Bind(R.id.tv_f_b)
    TextView tvFB;
    @Bind(R.id.tv_f_z)
    TextView tvFZ;
    @Bind(R.id.iv_g)
    ImageView ivG;
    @Bind(R.id.tv_g)
    TextView tvG;
    @Bind(R.id.ratingBar_g)
    RatingBar ratingBarG;
    @Bind(R.id.tv_g_x)
    TextView tvGX;
    @Bind(R.id.tv_g_a)
    TextView tvGA;
    @Bind(R.id.tv_g_b)
    TextView tvGB;
    @Bind(R.id.tv_g_z)
    TextView tvGZ;
    @Bind(R.id.iv_h)
    ImageView ivH;
    @Bind(R.id.tv_h)
    TextView tvH;
    @Bind(R.id.ratingBar_h)
    RatingBar ratingBarH;
    @Bind(R.id.tv_h_x)
    TextView tvHX;
    @Bind(R.id.tv_h_a)
    TextView tvHA;
    @Bind(R.id.tv_h_b)
    TextView tvHB;
    @Bind(R.id.tv_h_z)
    TextView tvHZ;

    @Override
    protected View initView() {
        return UIUtils.inflate(R.layout.hot_recommend_a);
    }

    @Override
    protected void refreshView(Object data) {

    }

    @Override
    protected void initGlideImage(Context context, GlideImage glideImage) {
        glideImage.displayImage(context, ivH,ivB,ivC,ivF,ivG);
    }

    @OnClick({R.id.rl_recommend_a, R.id.rl_recommend_b, R.id.rl_recommend_c, R.id.rl_recommend_d, R.id.rl_recommend_e, R.id.rl_recommend_f})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_recommend_a:
                break;
            case R.id.rl_recommend_b:
            case R.id.rl_recommend_c:
            case R.id.rl_recommend_d:
            case R.id.rl_recommend_e:
            case R.id.rl_recommend_f:
                IntentUtil.startActivity(context,SelectDiscountActivity.class);
                break;
        }
    }
}
