package com.example.YunleHui.ui.act.actme;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.BeanHomeList;
import com.example.YunleHui.Bean.Bean_tuan;
import com.example.YunleHui.R;
import com.example.YunleHui.adpter.MyRecycleViewAdapter;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.acthome.ActComdetails;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.MyXrecycleview;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 我的团队
 */

public class ActMyCustomer extends BaseAct {


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    @BindView(R.id.xrec_customer)
    MyXrecycleview xrec_customer;


    private MyRecycleViewAdapter myRecycleViewAdapter;


    private Bean_tuan bean_tuan;
    private int code;
    private Bean_tuan.DataBean data;
    private String msg;
    private boolean success;

    private List<Bean_tuan.DataBean.VoListBean> voList;

    private ArrayList<Bean_tuan.DataBean.VoListBean> voList_all = new ArrayList<>();

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_my_customer;
    }

    @Override
    protected void findViews() {

        if (toolbar_all!=null){
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("我的团队");
        }

    }


    private int offset = 1;

    private int max = 10;

    private int type = 0;


    @Override
    public void initData() {

        Tools.setManger(xrec_customer, this);

        xrec_customer.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                offset = 1;
                type = 0;

                HttpUtil.getAsynHttp("sell/searchTeamCommissions?userId=" + MyApp.user + "&offset=" + offset + "&max=" + max);
                getdata("sell/searchTeamCommissions");

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        xrec_customer.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {

                ++offset;
                type = 2;
                HttpUtil.getAsynHttp("sell/searchTeamCommissions?userId=" + MyApp.user + "&offset=" + offset + "&max=" + max);
                getdata("sell/searchTeamCommissions");

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        xrec_customer.loadMoreComplete();
                    }
                }, 1000);
            }
        });
        xrec_customer.refresh();
    }

    public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {


        private LayoutInflater inflater;

        private ArrayList<Bean_tuan.DataBean.VoListBean> datas = new ArrayList<>();

        private Context context;

        public MyRecycleViewAdapter(ArrayList<Bean_tuan.DataBean.VoListBean> datas, Context context) {

            this.datas.clear();

            this.datas.addAll(datas);

            this.context = context;

            this.inflater = LayoutInflater.from(context);

        }


        public void clear_data(ArrayList<Bean_tuan.DataBean.VoListBean> datas) {

            this.datas.clear();
            this.datas.addAll(datas);

            notifyDataSetChanged();

        }


        public void add_data(ArrayList<Bean_tuan.DataBean.VoListBean> datas) {

            this.datas.addAll(datas);

            notifyDataSetChanged();

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tuan, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {

            holder.text_name.setText(datas.get(position).getSubUserName());

            Glide.with(ActMyCustomer.this).load(datas.get(position).getSubLogo()).into(holder.round_img);

            holder.text_jin.setText(datas.get(position).getTotalCommission() * 0.01 + "");


        }

        @Override
        public int getItemCount() {
            return
                    datas.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private RoundedImageView round_img;
            private TextView text_name;
            private TextView text_jin;

            public ViewHolder(View itemView) {
                super(itemView);

                round_img = (RoundedImageView) itemView.findViewById(R.id.round_img);
                text_jin = (TextView) itemView.findViewById(R.id.text_jin);
                text_name = (TextView) itemView.findViewById(R.id.text_name);

            }
        }
    }


    @Override
    public void StringResulit(String key, String value) {
        try {
            if (key.equals("sell/searchTeamCommissions")) {
                bean_tuan = MyApp.gson.fromJson(value, Bean_tuan.class);
                data = bean_tuan.getData();
                voList = data.getVoList();
                voList_all.addAll(voList);
                if (type == 0) {
                    myRecycleViewAdapter = new MyRecycleViewAdapter(voList_all, this);
                    xrec_customer.setAdapter(myRecycleViewAdapter);
                } else if (type == 2) {
                    myRecycleViewAdapter.add_data(voList_all);
                    myRecycleViewAdapter.notifyDataSetChanged();
                }
            }
        } catch (Exception e) {

        }
    }
}
