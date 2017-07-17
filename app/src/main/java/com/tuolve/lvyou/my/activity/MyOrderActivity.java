package com.tuolve.lvyou.my.activity;

import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseFragment;
import com.tuolve.lvyou.base.BaseFragmentMainActivity;
import com.tuolve.lvyou.shopping.fragment.MyAllOrderFragment;
import com.tuolve.lvyou.shopping.fragment.MyOrderObligationFragment;
import com.tuolve.lvyou.shopping.fragment.MyOrderPendingEvaluationFragment;
import com.tuolve.lvyou.shopping.fragment.MyOrderSupplementedFragment;
import com.tuolve.lvyou.shopping.fragment.RefundOrAfterSaleFragment;
import com.tuolve.lvyou.interfaces.ICheckedChanged;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的订单
 */
public class MyOrderActivity extends BaseFragmentMainActivity {

    @Bind(R.id.textView_title_bar)
    TextView textViewTitle;
    @Bind(R.id.rg_my_order)
    RadioGroup rgMyOrder;

    @Override
    protected int initFrameLayoutId() {
        return R.id.fl_my_order;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_order;
    }

    @Override
    protected void initView() {
        textViewTitle.setText("我的订单");
    }

    @Override
    protected BaseFragment[] initClass() {
        return new BaseFragment[]{new MyAllOrderFragment(), new MyOrderObligationFragment(),
                new MyOrderSupplementedFragment(), new MyOrderPendingEvaluationFragment(),
                new RefundOrAfterSaleFragment()};
    }

    @Override
    protected void setListener() {
        rgMyOrder.setOnCheckedChangeListener(new MyOnCheckedChangeListener(new ICheckedChanged() {
            @Override
            public void checkedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_all_order:
                        position = 0;
                        break;
                    case R.id.rb_order_obligation:
                        position = 1;
                        break;
                    case R.id.rb_supplemented:
                        position = 2;
                        break;
                    case R.id.rb_pending_evaluation:
                        position = 3;
                        break;
                    case R.id.rb_refund_or_after_sale:
                        position = 4;
                        break;
                    default:
                        position = 0;
                        break;
                }
            }
        }));
        rgMyOrder.check(R.id.rb_all_order);
    }

    @OnClick(R.id.ib_back)
    public void back(View view) {
        onBackPressed();
    }
}
