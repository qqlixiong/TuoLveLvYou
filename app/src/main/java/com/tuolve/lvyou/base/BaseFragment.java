package com.tuolve.lvyou.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tuolve.lvyou.common.RecyclerViewUtil;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    /**
     * 上下文
     */
    protected Context mContext;
    protected RecyclerViewUtil recyclerViewUtil;

    public BaseFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(mContext).inflate(getFragmentLayoutId(), null);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    protected void initView() {
    }

    /**
     * 强制子类重写，实现子类特有的ui
     * @return
     */
    protected abstract int getFragmentLayoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
        initRecyclerView();
    }

    /**
     * 当孩子需要初始化数据，或者联网请求绑定数据，展示数据的 等等可以重写该方法
     */
    protected void initData() {
        recyclerViewUtil = RecyclerViewUtil.getInstance();
    }

    protected void initRecyclerView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
