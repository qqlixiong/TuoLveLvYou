package com.tuolve.lvyou.shopping.guesslike;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseGlideHolder;
import com.tuolve.lvyou.common.GlideImage;
import com.tuolve.lvyou.common.IntentUtil;
import com.tuolve.lvyou.common.UIUtils;
import com.tuolve.lvyou.destination.activity.MapActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by john on 2017/5/15.
 */

public class LookMapHolder extends BaseGlideHolder {
    @Bind(R.id.iv_guess_a)
    ImageView ivGuessA;

    @Override
    protected void initGlideImage(Context context, GlideImage glideImage) {
        glideImage.displayImage(context, ivGuessA);
    }

    @Override
    protected View initView() {
        return UIUtils.inflate(R.layout.look_map_layout);
    }

    @Override
    protected void refreshView(Object data) {

    }

    @OnClick(R.id.tv_guess_b)
    public void onViewClicked() {
        IntentUtil.startActivity(context, MapActivity.class);
    }
}
