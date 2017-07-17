# TuoLveLvYou
这是一个与旅游相关的APP,使用了万能RecyclerView，Banner轮播框架，下拉刷新框架，Glide图片加载，地图定位，ViewHolder编程，Android生命周期的回调等，你可以直接安装apk看效果哈！
------------------------------------------
万能RecyclerView：<br>
1.首先定义两个类  ModelRecyclerAdapter<T>     RecyclerItemViewId<br>
2.写一个Holder继承  ModelRecyclerAdapter.ModelViewHolder   在类上标记注解@RecyclerItemViewId（LayoutId）<br>
3.写一个类RecyclerViewUtil：
  public class RecyclerViewUtil {

    private RecyclerViewUtil(){};

    public static class Inner{
        private static RecyclerViewUtil manager = new RecyclerViewUtil();
    }

    public static RecyclerViewUtil getInstance() {
        return Inner.manager;<br>
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
}<br>
ViewHolder编程：<br>
1.写一个BaseHolder:<br>
 public abstract class BaseHolder<T> {
    private View contentView;//界面

    //初始化的时候 先初始化空间，再把控件 都写到view里面（类似于listview的 view.setTag(holder)）
    public BaseHolder() {
        contentView = initView();
        contentView.setTag(this);
        ButterKnife.bind(this, contentView);
        init();
    }

    protected void init() {

    }

    //  读取数据：注意这里的数据已经是  网络加载和json解析完 得到的 数据，
    public void setData(T data) {
        refreshView(data);//显示界面
    }
    //把当前的view返回给父类
    public View getView() {
        return contentView;
    }
    /**
     * 初始化各种控件
     * @return view
     */
    protected abstract View initView();
    /**
     * 控件添加各种数据 ，耗时操作等
     * @param data
     */
    protected abstract void refreshView(T data);
}<br>
1.写一个ViewHolder 继承于BaseHolder <br>
2.把ViewHolder添加到帧布局<br>
Activity生命周期的回调：<br>
在Application中有registerActivityLifecycleCallbacks方法，   有助于生命周期的统一管理，     可以替换BaseActivity<br>
对于Fragment同样可以    <br> 例子我将在之后做详细讲解。
