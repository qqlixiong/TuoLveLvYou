package com.tuolve.lvyou.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tuolve.lvyou.common.GlideImage;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * RecyclerView 通用适配器第一版
 * Created by cd5160866 on 16/5/10.
 */
public class ModelRecyclerAdapter<T> extends RecyclerView.Adapter<ModelRecyclerAdapter.ModelViewHolder> {
    protected Context mContext;
    /**
     * 通过注释的方式加入的布局item的layoutId
     */
    protected int mLayoutId;
    /**
     * viewholder的实现类类名
     */
    private Class<? extends ModelViewHolder> viewHolderClass;
    /**
     * 数据 即我们的任何类型的bean
     */
    protected List<T> mDatas = new ArrayList<>();

    public ModelRecyclerAdapter(Class<ModelViewHolder> viewHolderClass) {
        this.viewHolderClass = viewHolderClass;
        this.mLayoutId = viewHolderClass.getAnnotation(RecyclerItemViewId.class)
                .value();
    }

    public ModelRecyclerAdapter(Class<? extends ModelViewHolder> viewHolderClass, List<T> Datas) {
        this.viewHolderClass = viewHolderClass;
        this.mLayoutId = viewHolderClass.getAnnotation(RecyclerItemViewId.class)//获取我们的layoutid，我们的类注释后面的部分
                .value();
        mDatas = Datas;
    }

    @Override
    public ModelViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ModelViewHolder viewHolder = null;
        if (mContext == null)
            mContext = parent.getContext();

        try {
            View converView = LayoutInflater.from(parent.getContext()).inflate(mLayoutId, parent, false);
            viewHolder = viewHolderClass.getConstructor(View.class).newInstance(converView);
            ButterKnife.bind(viewHolder, converView);//将viewhodler于我们的view绑定起来
        } catch (Exception e) {
            e.printStackTrace();
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ModelViewHolder holder, int position) {
        holder.convert(mDatas.get(position), this, mContext, position);//这里更新数据
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void add(int positon, T data) {
        mDatas.add(positon, data);
        notifyItemInserted(positon);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        }, 500);

    }

    public void add(T data) {
        mDatas.add(data);
        notifyDataSetChanged();

    }

    public void add(List<T> data) {
        mDatas.clear();
        mDatas.addAll(data);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        }, 500);
    }

    public void replace(int position, T data) {
        mDatas.remove(position);
        mDatas.add(position == 0 ? position : position - 1, data);
        notifyDataSetChanged();
    }

    public void addAll(List<T> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public void clear() {
        mDatas.clear();
        notifyDataSetChanged();
    }

    public List<T> getItems() {
        return mDatas;
    }

    /**
     * hodler抽象类，支持任何数据类型
     *
     * @param <T>
     */
    public static abstract class ModelViewHolder<T> extends RecyclerView.ViewHolder {
        protected GlideImage glideImage;

        public ModelViewHolder(View itemView) {
            super(itemView);
            glideImage = GlideImage.getInstance();
        }

        /**
         * 这个是我们真正在实际使用的类中的绑定数据的方法
         *
         * @param item    bean类型
         * @param adapter adpter对象
         * @param context context对象
         * @param position 位置
         */
        public abstract void convert(T item, ModelRecyclerAdapter adapter, Context context, int position);
    }
}
