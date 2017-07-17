package com.tuolve.lvyou.common;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tuolve.lvyou.adapter.ModelRecyclerAdapter;

import java.util.List;

/**
 * Created by john on 2017/4/29.
 */

public class RecyclerViewUtil {

    private RecyclerViewUtil(){};

    public static class Inner{
        private static RecyclerViewUtil manager = new RecyclerViewUtil();
    }

    public static RecyclerViewUtil getInstance() {
        return Inner.manager;
    }

    public <T> void initRecyclerView(final RecyclerView recyclerView, List<T> list, Object... objects){
        initRecyclerView(recyclerView, list, new RecycleViewManager() {
            @Override
            public void recycleViewManager(RecyclerView.LayoutManager layoutManager) {
                recyclerView.setLayoutManager(layoutManager);
            }
        }, objects);
    }

    //NestedScrollView中包含竖直方向的RecyclerView时使用(处理滑动卡顿问题)
    public <T> void initNSVRecyclerView(final RecyclerView recyclerView, List<T> list, Object... objects){
        initRecyclerView(recyclerView, list, new RecycleViewManager() {
            @Override
            public void recycleViewManager(RecyclerView.LayoutManager layoutManager) {
                if(layoutManager instanceof LinearLayoutManager){
                    ((LinearLayoutManager)layoutManager).setSmoothScrollbarEnabled(true);
                    layoutManager.setAutoMeasureEnabled(true);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setNestedScrollingEnabled(false);
                }
                recyclerView.setLayoutManager(layoutManager);
            }
        }, objects);
    }

    private interface RecycleViewManager{
        void recycleViewManager(RecyclerView.LayoutManager layoutManager);
    }

    private  <T> void initRecyclerView(RecyclerView recyclerView,List<T> list,
                                     RecycleViewManager manager,Object... objects){
        for(Object object : objects){
            if(object instanceof RecyclerView.LayoutManager){
                manager.recycleViewManager((RecyclerView.LayoutManager) object);
            }
            if(object instanceof RecyclerView.ItemDecoration){
                recyclerView.addItemDecoration((RecyclerView.ItemDecoration) object);
            }
            if(object instanceof Class){
                if(ModelRecyclerAdapter.ModelViewHolder.class.isAssignableFrom(
                        (Class<? extends ModelRecyclerAdapter.ModelViewHolder>) object)){
                    recyclerView.setAdapter(new ModelRecyclerAdapter<T>(
                            (Class<? extends ModelRecyclerAdapter.ModelViewHolder>) object, list));
                }
            }
        }
    }
}
