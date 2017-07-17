package com.tuolve.lvyou.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.tuolve.lvyou.interfaces.ICheckedChanged;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2017/4/16.
 */

public abstract class BaseStrategyFragment extends BaseBannerFragment {

    protected List<BaseFragment> mBaseFragment;
    /**
     * 上次切换的Fragment
     */
    protected Fragment mContent;
    /**
     * 选中的Fragment的对应的位置
     */
    protected int position;
    private int frameLayoutId;

    @Override
    public void initData() {
        super.initData();
        initView();
        frameLayoutId = getFrameLayoutId();
        //初始化Fragment
        initFragment();
        //设置RadioGroup的监听
        setListener();
    }

    protected abstract void initView();

    protected void initFragment(){
        mBaseFragment = new ArrayList<>();
        for(BaseFragment baseFragment : initClass()){
            mBaseFragment.add(baseFragment);
        }
    }

    protected abstract BaseFragment[] initClass();

    protected abstract void setListener();

    /**
     * @param from 刚显示的Fragment,马上就要被隐藏了
     * @param to   马上要切换到的Fragment，一会要显示
     */
    private void switchFragment(Fragment from, Fragment to) {
        if (from != to) {
            mContent = to;
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            //才切换
            //判断有没有被添加
            if (!to.isAdded()) {
                //to没有被添加
                //from隐藏
                if (from != null) {
                    ft.hide(from);
                }
                //添加to
                if (to != null) {
                    ft.add(frameLayoutId, to).commit();
                }
            } else {
                //to已经被添加
                // from隐藏
                if (from != null) {
                    ft.hide(from);
                }
                //显示to
                if (to != null) {
                    ft.show(to).commit();
                }
            }
        }

    }

    public abstract int getFrameLayoutId();

    protected class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        private ICheckedChanged iCheckedChanged;

        public MyOnCheckedChangeListener(ICheckedChanged iCheckedChanged) {
            this.iCheckedChanged = iCheckedChanged;
        }

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            iCheckedChanged.checkedChanged(group,checkedId);

            //根据位置得到对应的Fragment
            Fragment to = getFragment();
            //替换
            switchFragment(mContent, to);

        }
    }

    /**
     * 根据位置得到对应的Fragment
     *
     * @return
     */
    protected BaseFragment getFragment() {
        BaseFragment fragment = mBaseFragment.get(position);
        return fragment;
    }
}
