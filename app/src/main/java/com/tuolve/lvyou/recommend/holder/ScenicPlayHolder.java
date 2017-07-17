package com.tuolve.lvyou.recommend.holder;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;
import com.tuolve.lvyou.shopping.guesslike.GuessLikeActivity;
import com.tuolve.lvyou.common.Constant;
import com.tuolve.lvyou.common.IntentUtil;
import com.tuolve.lvyou.common.RecyclerViewUtil;
import com.tuolve.lvyou.view.CustomLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.scenic_play_item)
public class ScenicPlayHolder extends ModelRecyclerAdapter.ModelViewHolder {
    @Bind(R.id.tv_guess_a)
    TextView textView;
    @Bind(R.id.iv_person_message)
    ImageView ivPersonMessage;
    @Bind(R.id.rv_scenic_play_sub)
    RecyclerView rvScenicPlaySub;
    private Context context;

    public ScenicPlayHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        this.context = context;
        textView.setText((String) item);
        glideImage.displayImage(context, ivPersonMessage);
        List<List<String>> list = new ArrayList<>();
        List<String> listStr = new ArrayList<>();
        if (position == 0) {
            listStr.add("【梦幻童话】香港迪士尼一日/两日门票");
            listStr.add("458");
            list.add(listStr);
        } else if (position == 2) {
            listStr.add("【精选路线】青马大桥+天坛大佛");
            listStr.add("458");
            list.add(listStr);
        }
        if (list.size() > 0) {
            RecyclerViewUtil.getInstance().initRecyclerView(rvScenicPlaySub, list,
                    new CustomLinearLayoutManager(context), ScenicPlaySubHolder.class);
        }
    }

    @OnClick(R.id.rl_guess_like)
    public void onViewClicked() {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.TITLE,textView.getText().toString());
        IntentUtil.startActivity(context, GuessLikeActivity.class,bundle);
    }
}
