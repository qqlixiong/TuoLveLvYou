package com.tuolve.lvyou.my.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by john on 2017/4/30.
 */

public class CustomMyView extends FrameLayout {
    @Bind(R.id.iv_person_message)
    ImageView imageView;
    @Bind(R.id.tv_guess_a)
    TextView textView;

    public CustomMyView(Context context) {
        this(context, null);
    }

    public CustomMyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomMyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.my_item, this);
        ButterKnife.bind(this, view);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomMyView);
        for (int i = 0; i < array.getIndexCount(); i++) {
            int id = array.getIndex(i);
            switch (id) {
                case R.styleable.CustomMyView_my_src:
                    imageView.setImageDrawable(array.getDrawable(id));
                    break;

                case R.styleable.CustomMyView_my_name:
                    textView.setText(array.getString(id));
                    break;
            }
        }
        array.recycle();
    }
}
