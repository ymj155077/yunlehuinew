package com.example.YunleHui.adpter;

import android.content.Context;
import android.graphics.Paint;

import com.example.YunleHui.Bean.BeanHomeList;
import com.example.YunleHui.R;

import java.util.List;

/**
 * Created by admin on 2019/8/12 0012.
 */

public class MyAdapter extends CommonRecycleAdapter<BeanHomeList.DataBean.VoListBean> {

    private CommonViewHolder.onItemCommonClickListener commonClickListener;

    public MyAdapter(Context context, List<BeanHomeList.DataBean.VoListBean> dataList) {
        super(context, dataList, R.layout.item_hone);
    }

    public MyAdapter(Context context, List<BeanHomeList.DataBean.VoListBean> dataList, CommonViewHolder.onItemCommonClickListener commonClickListener) {
        super(context, dataList, R.layout.item_hone);
        this.commonClickListener = commonClickListener;
    }

    @Override
    void bindData(CommonViewHolder holder, BeanHomeList.DataBean.VoListBean data) {

//        holder.setText(R.id.tv_title, data.getDistance()).getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG );
//        holder.setText(R.id.tv_content, data.getContent());

        holder.setCommonClickListener(commonClickListener);
    }
}
