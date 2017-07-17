package com.tuolve.lvyou.member;


import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseBannerFragment;
import com.tuolve.lvyou.recommend.holder.MemberAdvertHolder;
import com.tuolve.lvyou.recommend.holder.MemberHolder;
import com.tuolve.lvyou.recommend.holder.MemberUserHolder;
import com.tuolve.lvyou.common.GlideImage;
import com.tuolve.lvyou.view.CustomGridLayoutManager;
import com.tuolve.lvyou.view.CustomLinearLayoutManager;
import com.tuolve.lvyou.view.DividerListItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 会员商城
 */
public class MemberFragment extends BaseBannerFragment {
    @Bind(R.id.rv_advert)
    RecyclerView recyclerViewAdvert;
    @Bind(R.id.rv_member_user)
    RecyclerView recyclerViewMemberUser;
    @Bind(R.id.rv_member)
    RecyclerView recyclerViewMember;
    @Bind(R.id.iv_person_message)
    ImageView ivPersonMessage;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_member;
    }

    @Override
    public void initData() {
        super.initData();
        GlideImage.getInstance().displayImage(mContext,ivPersonMessage);
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        List<String> list = new ArrayList<>();
        list.add("广告");
        list.add("广告");
        list.add("广告");
        list.add("广告");
        recyclerViewUtil.initRecyclerView(recyclerViewAdvert, list, new CustomGridLayoutManager(mContext, 2),
                new DividerListItemDecoration(mContext, DividerListItemDecoration.VERTICAL_LIST, true),
                new DividerListItemDecoration(mContext, DividerListItemDecoration.HORIZONTAL_LIST, true),
                MemberAdvertHolder.class);

        List<String> listMemberUser = new ArrayList<>();
        listMemberUser.add("青马大桥");
        listMemberUser.add("黄大仙XXX");
        listMemberUser.add("青马大桥");
        listMemberUser.add("黄大仙XXX");
        listMemberUser.add("青马大桥");
        listMemberUser.add("黄大仙XXX");
        recyclerViewUtil.initRecyclerView(recyclerViewMemberUser, listMemberUser,
                new CustomGridLayoutManager(mContext, 2), MemberUserHolder.class);

        List<String> listMember = new ArrayList<>();
        listMember.add("省万元,五星马尔代夫");
        listMember.add("四月行XXXXX优惠券");
        listMember.add("香港迪士尼乐园");
        recyclerViewUtil.initRecyclerView(recyclerViewMember, listMember,
                new CustomLinearLayoutManager(mContext), MemberHolder.class);
    }
}
