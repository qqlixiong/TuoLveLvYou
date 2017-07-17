package com.tuolve.lvyou.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.tuolve.lvyou.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by john on 2017/4/30.
 */

public class CustomContactUsView extends FrameLayout {
    @Bind(R.id.tv_contact_us_name)
    TextView textView;

    public CustomContactUsView(Context context) {
        this(context, null);
    }

    public CustomContactUsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomContactUsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.contact_us_item, this);
        ButterKnife.bind(this, view);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomContactUsView);
        for (int i = 0; i < array.getIndexCount(); i++) {
            int id = array.getIndex(i);
            switch (id) {
                case R.styleable.CustomContactUsView_contact_us_name:
                    textView.setText(array.getString(id));
                    break;
            }
        }
        array.recycle();
    }
}
