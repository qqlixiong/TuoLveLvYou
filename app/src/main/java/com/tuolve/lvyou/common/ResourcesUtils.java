package com.tuolve.lvyou.common;

import android.content.Context;

/**
 * Created by john on 2017/4/30.
 */

public class ResourcesUtils {

    public static String getString(Context context,int resId){
        return context.getResources().getString(resId);
    }
}
