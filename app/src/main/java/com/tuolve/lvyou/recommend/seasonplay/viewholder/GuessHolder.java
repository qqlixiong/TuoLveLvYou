package com.tuolve.lvyou.recommend.seasonplay.viewholder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseHolder;
import com.tuolve.lvyou.common.RecyclerViewUtil;
import com.tuolve.lvyou.common.UIUtils;
import com.tuolve.lvyou.recommend.seasonplay.holder.SelectPriceHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by john on 2017/5/13.
 */

public class GuessHolder extends BaseHolder {
    @Bind(R.id.rv_guess)
    RecyclerView rvGuess;
    private Context context;

    public GuessHolder(Context context) {
        this.context = context;
    }

    @Override
    protected View initView() {
        return UIUtils.inflate(R.layout.guess_a_layout);
    }

    @Override
    protected void init() {
        super.init();
        List<String> list = new ArrayList<>();
        list.add("456");
        RecyclerViewUtil.getInstance().initRecyclerView(rvGuess,list,
                new LinearLayoutManager(context), SelectPriceHolder.class);
    }

    @Override
    protected void refreshView(Object data) {

    }
}
