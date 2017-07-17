package com.tuolve.lvyou.common;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tuolve.lvyou.R;

import java.util.Random;

public class GlideImage {
    private GlideImage() {
    }

    private static class Inner{
        private static GlideImage glideImage = new GlideImage();
    }

    public static GlideImage getInstance(){
        return Inner.glideImage;
    }

    public void displayImage(Context context, ImageView... imageViews) {
        for(ImageView imageView : imageViews){
            String[] urls = context.getResources().getStringArray(R.array.url4);
            Random rand = new Random();
            String path = urls[rand.nextInt(4)];
            this.displayImage(context,path,imageView);
        }
    }

    public void displayImage(Context context, Object path, ImageView... imageViews) {
        for(ImageView imageView : imageViews){
            Glide.with(context).load(path).into(imageView);
        }
    }

}
