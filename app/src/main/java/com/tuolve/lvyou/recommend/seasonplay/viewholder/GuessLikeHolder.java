package com.tuolve.lvyou.recommend.seasonplay.viewholder;

import android.view.View;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseHolder;
import com.tuolve.lvyou.common.UIUtils;

/**
 * Created by john on 2017/5/13.
 */

public class GuessLikeHolder extends BaseHolder{
    @Override
    protected View initView() {
        return UIUtils.inflate(R.layout.guess_like_a_layout);
    }

    @Override
    protected void refreshView(Object data) {

    }
}
