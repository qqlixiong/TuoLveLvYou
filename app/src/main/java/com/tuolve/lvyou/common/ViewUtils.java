package com.tuolve.lvyou.common;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by john on 2017/4/26.
 */

public class ViewUtils {
    /**
     * 隐藏view
     *
     * @param view
     */
    public static void hideView(View view) {
        if (view.getVisibility() == View.VISIBLE) {
            view.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * 消失view
     *
     * @param view
     */
    public static void goneView(View view) {
        if (view.getVisibility() == View.VISIBLE) {
            view.setVisibility(View.GONE);
        }
    }

    /**
     * 显示view
     *
     * @param view
     */
    public static void showView(View view) {
        if (view.getVisibility() == View.INVISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 显示消失的view
     *
     * @param view
     */
    public static void showGoneView(View view) {
        if (view.getVisibility() == View.GONE) {
            view.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 判断view是否为显示状态
     *
     * @param view
     * @return true为显示状态   false为隐藏状态
     */
    public static boolean isShowView(View view) {
        return view.getVisibility() == View.VISIBLE ? true : false;
    }

    /**
     * 设置FloatingActionButton 显示的图片背景
     * @param context                 上下文
     * @param fab                     FloatingActionButton
     * @param resId                   原资源tag
     * @param targetResId             目标资源tag
     * @param imageId                目标资源图片
     */
    public static void setFab(Context context, ImageView fab, int resId, int targetResId,
                              int imageId){
        if(fab.getTag().equals(ResourcesUtils.getString(context, resId))){
            fab.setImageResource(imageId);
            fab.setTag(ResourcesUtils.getString(context,targetResId));
        }
    }

    /**
     * 是否改变了view的状态
     * @param context    上下文
     * @param view       控件
     * @param resId      原资源tag
     * @return
     */
    public static boolean isChange(Context context,View view,int resId){
        return view.getTag().equals(ResourcesUtils.getString(context,resId));
    }
}
