package com.tuolve.lvyou.base;

import android.content.Context;

import com.tuolve.lvyou.common.GlideImage;

/**
 * Created by john on 2017/5/15.
 */

public abstract class BaseGlideHolder<T> extends BaseHolder<T>{
    protected Context context;

    public void setGlideImage(Context context,GlideImage glideImage){
        this.context = context;
        initGlideImage(context,glideImage);
    }

    protected abstract void initGlideImage(Context context,GlideImage glideImage);
}
