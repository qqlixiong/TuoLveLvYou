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

public class CustomMoneyView extends FrameLayout {

    @Bind(R.id.textView_money_name)
    TextView textViewMoneyName;

    public CustomMoneyView(Context context) {
        this(context, null);
    }

    public CustomMoneyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomMoneyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.my_money_item, this);
        ButterKnife.bind(this, view);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomMoneyView);
        for (int i = 0; i < array.getIndexCount(); i++) {
            int id = array.getIndex(i);
            switch (id) {
                case R.styleable.CustomMoneyView_money_name:
                    textViewMoneyName.setText(array.getString(id));
                    break;
            }
        }
        array.recycle();
    }
}
