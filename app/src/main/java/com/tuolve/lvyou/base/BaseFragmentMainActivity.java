package com.tuolve.lvyou.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.WindowManager;
import android.widget.RadioGroup;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.tuolve.lvyou.R;
import com.tuolve.lvyou.interfaces.ICheckedChanged;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by john on 2017/4/16.
 */

public abstract class BaseFragmentMainActivity extends FragmentActivity {

    protected List<BaseFragment> mBaseFragment;
    /**
     * 选中的Fragment的对应的位置
     */
    protected int position;
    /**
     * 上次切换的Fragment
     */
    protected Fragment mContent;
    protected int frameLayoutId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setSystemBarTint();
        ButterKnife.bind(this);
        initView();
        //初始化Fragment
        initFragment();
        frameLayoutId = initFrameLayoutId();
        //设置RadioGroup的监听
        setListener();
    }

    private void setSystemBarTint() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            // 激活状态栏
            tintManager.setStatusBarTintEnabled(true);
            // enable navigation bar tint 激活导航栏
            tintManager.setNavigationBarTintEnabled(true);
            //设置系统栏设置颜色
            //tintManager.setTintColor(R.color.red);
            //给状态栏设置颜色
            tintManager.setStatusBarTintResource(R.color.mask_tags);
            //Apply the specified drawable or color resource to the system navigation bar.
            //给导航栏设置资源
            tintManager.setNavigationBarTintResource(R.color.mask_tags);
        }
    }

    protected abstract int initFrameLayoutId();

    protected abstract int getLayoutId();

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
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
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
        return mBaseFragment.get(position);
    }

}
