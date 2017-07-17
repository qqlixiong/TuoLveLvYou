package com.tuolve.lvyou.base;

import com.tuolve.lvyou.common.GlideImage;

/**
 * Created by john on 2017/5/4.
 */

public abstract class BaseGlideFragment extends BaseFragment{
    protected GlideImage glideImage;

    @Override
    protected void initView() {
        super.initView();
        glideImage = GlideImage.getInstance();
    }
}
