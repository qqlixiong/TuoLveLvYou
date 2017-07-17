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
 * Created by john on 2017/5/1.
 */

public class MyTextView extends FrameLayout {
    @Bind(R.id.tv_guess_a)
    TextView textView;

    public MyTextView(Context context) {
        this(context, null);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.my_text_view, this);
        ButterKnife.bind(this, view);
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.MyTextView);
        for(int i=0;i<ta.getIndexCount();i++){
            int id = ta.getIndex(i);
            switch (id){
                case R.styleable.MyTextView_my_text:
                    textView.setText(ta.getString(id));
                    break;
            }
        }
        ta.recycle();
    }
}
