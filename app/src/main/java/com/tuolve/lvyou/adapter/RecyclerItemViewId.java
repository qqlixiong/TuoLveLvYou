package com.tuolve.lvyou.adapter;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by john on 2017/4/15.
 */

@Retention(RUNTIME)
public @interface RecyclerItemViewId {
    int value();//我们注解后面使用id值
}
