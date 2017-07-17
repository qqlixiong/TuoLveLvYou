package com.tuolve.lvyou.base;

import com.tuolve.lvyou.common.GlideImage;

/**
 * Created by john on 2017/5/4.
 */

public abstract class BaseGlideActivity extends BaseActivity{
    protected GlideImage glideImage;

    @Override
    public void initData() {
        super.initData();
        glideImage = GlideImage.getInstance();
    }
}
