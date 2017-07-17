package com.tuolve.lvyou.base;

import android.view.View;

import butterknife.ButterKnife;

/**
 *
 *  类说明 所有界面都是 holder的开发
 *
 *  所有页面都离不开： 网络请求数据和显示页面 并且他们两个宗旨是一样的 但每个页面都各有特色，所以就让子类去实现
 *  先初始化默认的控件，
 *  当网络请求数据的时候在把得到的数据写到控件里面
 *
 *  总之是 为了避免 因为 界面复杂     而    所有代码都写到一个界面中，进而难以维护，坑自己更坑队友
 */
public abstract class BaseHolder<T> {
    private View contentView;//界面

    //初始化的时候 先初始化空间，再把控件 都写到view里面（类似于listview的 view.setTag(holder)）
    public BaseHolder() {
        contentView = initView();
        contentView.setTag(this);
        ButterKnife.bind(this, contentView);
        init();
    }

    protected void init() {

    }

    //  读取数据：注意这里的数据已经是  网络加载和json解析完 得到的 数据，
    public void setData(T data) {
        refreshView(data);//显示界面
    }
    //把当前的view返回给父类
    public View getView() {
        return contentView;
    }
    /**
     * 初始化各种控件
     * @return view
     */
    protected abstract View initView();
    /**
     * 控件添加各种数据 ，耗时操作等
     * @param data
     */
    protected abstract void refreshView(T data);
}
