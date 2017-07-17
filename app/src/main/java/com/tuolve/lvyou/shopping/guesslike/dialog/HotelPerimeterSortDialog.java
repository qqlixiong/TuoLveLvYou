package com.tuolve.lvyou.shopping.guesslike.dialog;

import android.app.Activity;
import android.view.View;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseCustomDialog;

import java.util.List;

/**
 * Created by john on 2017/5/5.
 */

public class HotelPerimeterSortDialog extends BaseCustomDialog{
    public HotelPerimeterSortDialog(Activity activity, View.OnClickListener onClickListener) {
        super(activity, onClickListener);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.hotel_perimeter_sort_dialog;
    }

    @Override
    protected List<Integer> getConcernedIds() {
        return null;
    }

    @Override
    protected void initView(View view) {

    }
}
