package com.tuolve.lvyou.common;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Toast;
import com.tuolve.lvyou.App;

/**
 * 专门提供为处理一些UI相关的问题而创建的工具类，
 * 提供资源获取的通用方法，避免每次都写重复的代码获取结果。
 */
public class UIUtils {

    public static Context getContext(){
        return App.context;
    }

    /**
     * 获取资源对象
     */
    public static Resources getResources() {
        return getContext().getResources();
    }
    /**
     * 获取资源文件字符串
     *
     * @param id
     * @return
     */
    public static String getString(int id) {
        return getResources().getString(id);
    }

    public static Handler getHandler(){
        return App.handler;
    }

    /**
     * 获取资源文件图片
     *
     * @param id
     * @return
     */
    public static Drawable getDrawable(int id) {
        return ContextCompat.getDrawable(getContext(), id);
    }
    /**
     * 根据id获取颜色的状态选择器
     *
     * @param id
     * @return
     */
    public static ColorStateList getColorStateList(int id) {
        return ContextCompat.getColorStateList(getContext(), id);
    }
    /**
     * 获取尺寸
     *
     * @param id
     * @return
     */
    public static int getDimen(int id) {
        return getResources().getDimensionPixelSize(id); // 返回具体像素值
    }
    /**
     * 获取资源文件颜色
     *
     * @param id
     * @return
     */
    public static int getColor(int id) {
        return ContextCompat.getColor(getContext(), id);
    }

    //加载指定viewId的视图对象，并返回
    public static View inflate(int viewId){
        return View.inflate(getContext(), viewId, null);
    }

    public static String[] getStringArr(int strArrId){
        String[] stringArray = getContext().getResources().getStringArray(strArrId);
        return stringArray;
    }

    //将dp转化为px
    public static int dp2px(int dp){
        //获取手机密度
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5);//实现四舍五入
    }

    public static int px2dp(int px){
        //获取手机密度
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (px / density + 0.5);//实现四舍五入
    }

    /**
     * 把自身从父View中移除
     * @param view
     */
    public static void removeSelfFromParent(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent != null && parent instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) parent;
                group.removeView(view);
            }
        }
    }
    /**
     * 请求View树重新布局，用于解决中层View有布局状态而导致上层View状态断裂
     * @param view
     * @param isAll
     */
    public static void requestLayoutParent(View view, boolean isAll) {
        ViewParent parent = view.getParent();
        while (parent != null && parent instanceof View) {
            if (!parent.isLayoutRequested()) {
                parent.requestLayout();
                if (!isAll) {
                    break;
                }
            }
            parent = parent.getParent();
        }
    }
    /**
     * 判断触点是否落在该View上
     * @param ev
     * @param v
     * @return
     */
    public static boolean isTouchInView(MotionEvent ev, View v) {
        int[] vLoc = new int[2];
        v.getLocationOnScreen(vLoc);
        float motionX = ev.getRawX();
        float motionY = ev.getRawY();
        return motionX >= vLoc[0] && motionX <= (vLoc[0] + v.getWidth())
                && motionY >= vLoc[1] && motionY <= (vLoc[1] + v.getHeight());
    }

    //保证runnable中的操作在主线程中执行
    public static void runOnUiThread(Runnable runnable) {
        if(isInMainThread()){
            runnable.run();
        }else{
            UIUtils.getHandler().post(runnable);
        }
    }
    //判断当前线程是否是主线程
    private static boolean isInMainThread() {
        int currentThreadId = android.os.Process.myTid();
        return App.mainThreadId == currentThreadId;

    }

    public static void toast(String message, boolean isLengthLong){
        Toast.makeText(UIUtils.getContext(), message,isLengthLong? Toast.LENGTH_LONG : Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取屏幕的比例
     * @param context
     * @return
     */
    public static float getScaledDensity(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        float value = dm.scaledDensity;
        return value;
    }
    /**
     * 获取控件的高度，如果获取的高度为0，则重新计算尺寸后再返回高度
     * @param view
     * @return
     */
    public static int getViewMeasuredHeight(View view) {
        calcViewMeasure(view);
        return view.getMeasuredHeight();
    }
    /**
     * 获取控件的宽度，如果获取的宽度为0，则重新计算尺寸后再返回宽度
     * @param view
     * @return
     */
    public static int getViewMeasuredWidth(View view) {
        calcViewMeasure(view);
        return view.getMeasuredWidth();
    }
    /**
     * 测量控件的尺寸
     * @param view
     */
    public static void calcViewMeasure(View view) {
        int width = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int expandSpec = View.MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        view.measure(width, expandSpec);
    }
    /**
     * 设置textview指定文字为某一颜色
     *
     * @param content 显示的文字
     * @param color   需要转换成的颜色值
     * @param start   需要变色文字开始位置
     * @param end     需要变色文字结束位置
     */
    public static SpannableStringBuilder changeTextColor(String content, int color, int start, int end) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(content);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableStringBuilder;
    }
}
