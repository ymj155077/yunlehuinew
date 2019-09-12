package com.example.YunleHui.view.cityList;

import android.content.Context;

import com.example.YunleHui.Bean.Bean_cityList;
import com.example.YunleHui.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zhangxutong .
 * Date: 16/08/28
 */

public class MeituanAdapter extends CommonAdapter<Bean_cityList.DataBean> {
    public MeituanAdapter(Context context, int layoutId, ArrayList<Bean_cityList.DataBean> datas) {
        super(context, layoutId, datas);
    }

//    @Override
//    public void convert(ViewHolder holder, final MeiTuanBean cityBean) {
//        holder.setText(R.id.tvCity, cityBean.getCity());
//    }

    @Override
    public void convert(ViewHolder holder, String name, int Id) {
        holder.setText(R.id.tvCity, name);
    }
}