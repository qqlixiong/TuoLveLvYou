package com.tuolve.lvyou.base;

import com.tuolve.lvyou.App;
import com.tuolve.lvyou.R;
import com.tuolve.lvyou.common.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.transformer.DefaultTransformer;

import butterknife.Bind;

/**
 * Created by john on 2017/4/28.
 */

public abstract class BaseBannerFragment extends BaseGlideFragment{
    @Bind(R.id.banner)
    Banner banner;

    @Override
    public void initData() {
        super.initData();
        banner.setBannerAnimation(DefaultTransformer.class);
        banner.setImages(App.images)
                .setImageLoader(new GlideImageLoader())
                .start();
    }
}
