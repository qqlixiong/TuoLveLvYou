package com.tuolve.lvyou.my.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.common.GlideImage;
import com.tuolve.lvyou.interfaces.IActivity;
import com.tuolve.lvyou.interfaces.IGlideImageActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 联系我们
 */
public class AboutUsActivity extends AppCompatActivity implements IActivity ,IGlideImageActivity{

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;
    @Bind(R.id.imageView_user_pic)
    ImageView mImageViewUserPic;

    @Override
    public int getLayoutId() {
        return R.layout.activity_about_us;
    }

    @Override
    public void initData() {
        textViewTitleBar.setText("联系我们");
    }

    @Override
    public void setListener() {

    }

    @OnClick(R.id.ib_back)
    public void onViewClicked() {
        onBackPressed();
    }

    @Override
    public void initGlideImage(GlideImage glideImage) {
        glideImage.displayImage(this,mImageViewUserPic);
    }
}
