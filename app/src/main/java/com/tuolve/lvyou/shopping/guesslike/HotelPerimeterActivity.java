package com.tuolve.lvyou.shopping.guesslike;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseActivity;
import com.tuolve.lvyou.shopping.guesslike.dialog.HotelPerimeterSortDialog;
import com.tuolve.lvyou.common.Constant;
import com.tuolve.lvyou.view.CustomLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class HotelPerimeterActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.textView_title_bar)
    TextView textViewTitleBar;
    @Bind(R.id.rv_hotel_perimeter)
    RecyclerView rvHotelPerimeter;
    private HotelPerimeterSortDialog sortDialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_hotel_perimeter;
    }

    @Override
    public void initData() {
        super.initData();
        textViewTitleBar.setText(getIntent().getExtras().getString(Constant.TITLE));
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                list.add("京帝酒店");
            } else {
                list.add("京帝酒店" + i);
            }
        }
        recyclerViewUtil.initNSVRecyclerView(rvHotelPerimeter, list,
                new CustomLinearLayoutManager(this), HotelHolder.class);
    }

    @OnClick({R.id.ib_back, R.id.tv_hotel_perimeter_dressing, R.id.tv_hotel_perimeter_sort})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_back:
                onBackPressed();
                break;
            case R.id.tv_hotel_perimeter_dressing:
                break;
            case R.id.tv_hotel_perimeter_sort:
                clearHotelPerimeterDialog();
                sortDialog = new HotelPerimeterSortDialog(this, this);
                sortDialog.show();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sort_button_cancel:
                sortDialog.dismiss();
                break;

            case R.id.sort_button_confirm:
                break;
        }
    }

    private void clearHotelPerimeterDialog() {
        if (sortDialog != null) {
            sortDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        clearHotelPerimeterDialog();
    }
}
