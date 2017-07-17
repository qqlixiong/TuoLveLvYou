package com.tuolve.lvyou.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.tuolve.lvyou.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义Dialog基类。
 *
 * @author hehui
 *         ~
 * @date 2016-10-08
 */
public abstract class BaseCustomDialog {

    private final WeakReference<Activity> mActivityRef;
    private OnClickListener mOnClickListener;
    private Dialog mDialog;
    private Context mContext;

    /**
     * 是否弹出键盘
     *
     * @return
     */
    protected boolean isShowKeyboardWhenStart() {
        return false;
    }

    /**
     * 传入的布局resourceID
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 需要加监听的IDlist
     *
     * @return
     */
    protected abstract List<Integer> getConcernedIds();

    /**
     * 做一些初始化界面的操作
     */
    protected abstract void initView(View view);

    /**
     * 显示布局时是否充满整个屏幕
     *
     * @return
     */
    protected boolean isFillWindow() {
        return false;
    }

    /**
     * 是否点击弹出框其他区域销毁对话框。
     *
     * @return
     */
    protected boolean isCanceledOnTouchOutside() {
        return true;
    }

    protected boolean isCanceledOnBackKey() {
        return true;
    }

    public BaseCustomDialog(Activity activity, OnClickListener onClickListener) {
        mContext = activity.getApplicationContext();
        mActivityRef = new WeakReference<Activity>(activity);
        mOnClickListener = onClickListener;
    }

    /**
     * dialog显示的方法
     */
    public void show() {
        Activity activity = mActivityRef.get();
        if (activity == null || activity.isFinishing()) {
            return;
        }

        if (mDialog != null) {
            mDialog.dismiss();
            mDialog = null;
        }

        mDialog = new Dialog(activity, R.style.DialogTheme_CenterCustom);

        View rootView = LayoutInflater.from(activity).inflate(getLayoutId(), null);
        initView(rootView);
        if (isFillWindow()) {
            mDialog.getWindow().setContentView(rootView);
        } else {
            mDialog.setContentView(rootView);
        }
        mDialog.setCanceledOnTouchOutside(isCanceledOnTouchOutside());
        mDialog.setCancelable(isCanceledOnBackKey());
        addListeners(rootView);

        mDialog.show();
    }

    /**
     * 对布局中的子控件添加监听，若 getConcernedIds() 为空则遍历所有子控件并添加监听
     *
     * @param view 根布局
     */
    private void addListeners(View view) {
        List<Integer> concernedIds = getConcernedIds();
        if (concernedIds == null || concernedIds.isEmpty()) {
            List<View> viewList = pickViewGroup(view);
            for (View item : viewList) {
                item.setOnClickListener(mOnClickListener);
            }
        } else {
            int concernedCount = concernedIds.size();
            for (int i = 0; i < concernedCount; i++) {
                view.findViewById(concernedIds.get(i)).setOnClickListener(mOnClickListener);
            }
        }
    }

    /**
     * 遍历View子控件若为ViewGroup则放入ViewGroupList，若为View则放入ViewList
     */
    private List<View> pickViewGroup(View view) {
        List<View> viewList = new ArrayList<View>();
        List<View> groupList = new ArrayList<View>();
        groupList.add(view);
        int viewGroupListCount = groupList.size();
        View item = null;
        int tempCount = 0;
        View tempView;
        while (viewGroupListCount > 0) {
            for (int i = 0; i < viewGroupListCount; i++) {
                item = groupList.get(0);// 因为有remove操作，所以每次拿列表的首个，或者最后一个都可
                if (item instanceof ViewGroup) {
                    groupList.remove(item);

                    tempCount = ((ViewGroup) item).getChildCount();
                    for (int j = 0; j < tempCount; j++) {
                        tempView = ((ViewGroup) item).getChildAt(j);
                        if (tempView instanceof ViewGroup) {
                            groupList.add(tempView);
                        } else {
                            viewList.add(tempView);
                        }
                    }
                } else {
                    viewList.add(item);
                }
            }
            viewGroupListCount = groupList.size();
        }
        return viewList;
    }

    /**
     * 关闭dialog
     */
    public void dismiss() {

        if (mDialog != null) {
            mDialog.dismiss();
            mDialog = null;
        }
    }
}
