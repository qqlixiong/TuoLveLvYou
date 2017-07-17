package com.tuolve.lvyou.my.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseActivity;
import com.tuolve.lvyou.base.BaseGlideActivity;
import com.tuolve.lvyou.common.GlideImage;
import com.tuolve.lvyou.interfaces.IGlideImageActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的团队
 */
public class MyTeamActivity extends BaseGlideActivity{

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;
    @Bind(R.id.textView_user_name)
    TextView textViewUserName;
    @Bind(R.id.imageView_user_pic)
    ImageView mImageViewUserPic;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_team;
    }

    @Override
    public void initData() {
        super.initData();
        textViewTitleBar.setText("我的团队");
        textViewUserName.setText("里斯");
        glideImage.displayImage(this,mImageViewUserPic);
    }

    @OnClick(R.id.ib_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
