package com.tuolve.lvyou.shopping.guesslike;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;
import com.tuolve.lvyou.common.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.all_comments_item)
public class AllCommentsHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.tv_comments_nick)
    TextView tvCommentsNick;
    @Bind(R.id.rv_comments_pic)
    RecyclerView rvCommentsPic;
    @Bind(R.id.iv_comments_user_pic)
    CircleImageView ivCommentsUserPic;

    public AllCommentsHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        /*if(position == 0){
            tvCommentsNick.setText((String) item);
        }*/
        glideImage.displayImage(context, ivCommentsUserPic);
        /*if(position > 1){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<10;i++){
                list.add(i);
            }

        }*/
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add("" + i);
        }
        RecyclerViewUtil.getInstance().initRecyclerView(rvCommentsPic, list,
                new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false),
                AllCommentsPicHolder.class);
    }
}
