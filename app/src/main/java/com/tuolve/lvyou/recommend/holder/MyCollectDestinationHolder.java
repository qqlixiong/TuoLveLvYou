package com.tuolve.lvyou.recommend.holder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;
import com.tuolve.lvyou.adapter.RecyclerItemViewId;
import com.tuolve.lvyou.common.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by john on 2017/4/27.
 */
@RecyclerItemViewId(R.layout.my_collect_destination_item)
public class MyCollectDestinationHolder extends ModelRecyclerAdapter.ModelViewHolder {

    @Bind(R.id.tv_my_collect_country)
    TextView tvMyCollectCountry;
    @Bind(R.id.rv_my_collect_destination_country)
    RecyclerView rvMyCollectDestinationCountry;

    public MyCollectDestinationHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void convert(Object item, ModelRecyclerAdapter adapter, Context context, int position) {
        tvMyCollectCountry.setText((String) item);
        List<List<String>> list = new ArrayList<>();
        if(position == 0){
            List<String> listStr1 = new ArrayList<>();
            listStr1.add("香港");
            listStr1.add("3个收藏目的地");
            List<String> listStr2 = new ArrayList<>();
            listStr2.add("台湾");
            listStr2.add("还没有添加目的地");
            list.add(listStr1);
            list.add(listStr2);
        }else if (position == 1){
            List<String> listStr1 = new ArrayList<>();
            listStr1.add("纽约");
            listStr1.add("3个收藏目的地");
            list.add(listStr1);
        }
        RecyclerViewUtil.getInstance().initRecyclerView(rvMyCollectDestinationCountry,
                list,new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false),
                CountryHolder.class);
    }
}
