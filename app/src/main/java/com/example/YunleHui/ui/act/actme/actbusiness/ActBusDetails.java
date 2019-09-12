package com.example.YunleHui.ui.act.actme.actbusiness;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.ActComPur.ActComMall;
import com.example.YunleHui.ui.frag.fragExplosive;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class ActBusDetails extends BaseAct {


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    @BindView(R.id.text_yuan)
    TextView text_yuan;


    @BindView(R.id.lin_boom_gou)
    LinearLayout lin_boom_gou;

    @BindView(R.id.lin_ok)
LinearLayout lin_ok;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this,clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_bus_details;
    }
    private MZBannerView mMZBanner;
    @Override
    protected void findViews() {

        if (toolbar_all!=null){
            TextView text_center = toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("商品详情");
        }


        mMZBanner = (MZBannerView)findViewById(R.id.banner);

    }


    @BindView(R.id.banner)
    MZBannerView banner;

    @Override
    public void initData() {
        text_yuan.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); // 设置中划线并加清晰








        ArrayList<String> imgs
                = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567229180286&di=fe953e1fe96ffa6556cfd9c717e3c7a4&imgtype=0&src=http%3A%2F%2Fmmbiz.qpic.cn%2Fmmbiz%2FMTQFkr8uzAktEt5nrK2YITeSFQyUqVTUVbfibNzqjwaaDCvtlll9DiaHJRoD4uZ2foXSfGn7ajvyXCNwP7iadBj3g%2F0");
        }

        // 设置数据
        mMZBanner.setPages(imgs, new MZHolderCreator<fragExplosive.BannerViewHolder>() {
            @Override
            public fragExplosive.BannerViewHolder createViewHolder() {
                return new fragExplosive.BannerViewHolder();
            }
        });

        mMZBanner.start();//开始轮播










        //        购物车 弹窗
        ArrayList<String> datass = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            datass.add("");
        }
        MyGouAdapter myGouAdapter = new MyGouAdapter(datass, this);

        list_gou.setAdapter(myGouAdapter);



    }



    @BindView(R.id.lin_mall)
    LinearLayout lin_mall;




//    弹窗的list

    @BindView(R.id.list_gou)
    ListView list_gou;


    @OnClick({R.id.lin_boom_gou,R.id.lin_ok})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.lin_boom_gou:
                if (lin_mall.getVisibility()==View.GONE){
                    lin_mall.setVisibility(View.VISIBLE);
                }else {
                    lin_mall.setVisibility(View.GONE);
                }
                break;
            case R.id.lin_ok:

                startActivity(ActOrderPayCom.class);

                break;
        }
    }












    //    购物车的adpter
    public class MyGouAdapter extends BaseAdapter {


        private ArrayList<String> datas = new ArrayList<>();

        private LayoutInflater inflater;


        public MyGouAdapter(ArrayList<String> datas, Context context) {

            this.datas.clear();
            this.datas.addAll(datas);
            this.inflater = LayoutInflater.from(context);

        }


        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int i) {
            return datas.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            MyViewHolder myViewHolder = new MyViewHolder();


            convertView = inflater.inflate(R.layout.item_gou_list, parent, false);


            return convertView;
        }


        public class MyViewHolder {


        }


    }












}
