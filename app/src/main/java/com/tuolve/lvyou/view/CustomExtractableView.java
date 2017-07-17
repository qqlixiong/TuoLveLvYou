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

public class CustomExtractableView extends FrameLayout {

    @Bind(R.id.tv_extractable_money)
    TextView tvExtractableMoney;
    @Bind(R.id.tv_extractable)
    TextView tvExtractable;

    public CustomExtractableView(Context context) {
        this(context, null);
    }

    public CustomExtractableView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomExtractableView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.extractable_with_draw_deposit_item, this);
        ButterKnife.bind(this, view);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomExtractableView);
        for (int i = 0; i < array.getIndexCount(); i++) {
            int id = array.getIndex(i);
            switch (id) {
                case R.styleable.CustomExtractableView_extractable_money:
                    tvExtractableMoney.setText(array.getString(id));
                    break;

                case R.styleable.CustomExtractableView_extractable_name:
                    tvExtractable.setText(array.getString(id));
                    break;
            }
        }
        array.recycle();
    }
}
