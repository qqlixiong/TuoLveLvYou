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
 * Created by john on 2017/5/3.
 */

public class PropellingSettingView extends FrameLayout {
    @Bind(R.id.iv_propelling_setting)
    ImageView ivPropellingSetting;
    @Bind(R.id.tv_propelling_setting)
    TextView tvPropellingSetting;
    @Bind(R.id.custom_switch_view)
    SwitchView customSwitchView;

    public PropellingSettingView(Context context) {
        this(context, null);
    }

    public PropellingSettingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PropellingSettingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.propelling_setting_item, this);
        ButterKnife.bind(this, view);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.PropellingSettingView);
        for (int i = 0; i < array.getIndexCount(); i++) {
            int id = array.getIndex(i);
            switch (id) {
                case R.styleable.PropellingSettingView_propelling_setting_pic:
                    ivPropellingSetting.setImageDrawable(array.getDrawable(id));
                    break;

                case R.styleable.PropellingSettingView_propelling_setting_title:
                    tvPropellingSetting.setText(array.getString(id));
                    break;
            }
        }
        array.recycle();
    }
}
