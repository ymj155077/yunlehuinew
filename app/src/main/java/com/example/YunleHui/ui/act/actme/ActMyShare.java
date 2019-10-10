package com.example.YunleHui.ui.act.actme;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.Bean_share;
import com.example.YunleHui.Bean.Bean_tuan;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.MyXrecycleview;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;


/**
 * 我的分享
 */
public class ActMyShare extends BaseAct {


    private Bean_share bean_tuan;
    private int code;
    private Bean_share.DataBean data;
    private String msg;
    private boolean success;

    private List<Bean_share.DataBean.VoListBean> voList;

    private ArrayList<Bean_share.DataBean.VoListBean> voList_all = new ArrayList<>();


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    @BindView(R.id.xrec_share)
    MyXrecycleview xrec_share;


    private int offset = 1;
    private int type = 0;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_my_share;
    }

    @Override
    protected void findViews() {

        if (toolbar_all != null) {
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("我的分享");
        }

    }

    @Override
    public void initData() {


        Tools.setManger(xrec_share, this);

        xrec_share.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                offset = 1;
                type = 0;

                Map<Object, Object> params_order = new HashMap<>();

                params_order.clear();

                HttpUtil.addMapparams();

                params_order.put("max", 10);

                params_order.put("offset", offset);

                Map<Object, Object> a = new HashMap<>();
                a.clear();
                a.put("beginDate", "");
                a.put("endDate", "");
                a.put("goodsName", "");
                a.put("userId", MyApp.user);
                params_order.put("searchCondition", a);

                Map<Object, Object> aa = new HashMap<>();
                aa.clear();
                aa.put("id", 0);
                aa.put("pv", 0);
                params_order.put("sortCondition", aa);

                HttpUtil.postRaw("sell/searchSellGoods",
                        params_order
                );
                getdata("sell/searchSellGoods");

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        xrec_share.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {

                ++offset;
                type = 2;
                Map<Object, Object> params_order = new HashMap<>();

                params_order.clear();

                HttpUtil.addMapparams();

                params_order.put("max", 10);

                params_order.put("offset", offset);

                Map<Object, Object> a = new HashMap<>();
                a.clear();
                a.put("beginDate", "");
                a.put("endDate", "");
                a.put("goodsName", "");
                a.put("userId", MyApp.user);
                params_order.put("searchCondition", a);

                Map<Object, Object> aa = new HashMap<>();
                aa.clear();
                aa.put("id", 0);
                aa.put("pv", 0);
                params_order.put("sortCondition", aa);

                HttpUtil.postRaw("sell/searchSellGoods",
                        params_order
                );
                getdata("sell/searchSellGoods");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xrec_share.loadMoreComplete();
                    }
                }, 1000);
            }
        });
        xrec_share.refresh();
    }


    @Override
    public void stringResulit(String key, String value) {
        try {
            if (key.equals("sell/searchSellGoods")) {


//                private Bean_share bean_tuan;
//                private int code;
//                private Bean_share.DataBean data;
//                private String msg;
//                private boolean success;
//
//                private List<Bean_share.DataBean.VoListBean> voList;
//
//                private ArrayList<Bean_share.DataBean.VoListBean> voList_all = new ArrayList<>();

                bean_tuan = MyApp.gson.fromJson(value, Bean_share.class);
                data = bean_tuan.getData();

                voList = data.getVoList();

                voList_all.clear();

                voList_all.addAll(voList);
                if (type == 0) {
                    myRecycleViewAdapter = new MyRecycleViewAdapter(voList_all, this);
                    xrec_share.setAdapter(myRecycleViewAdapter);
                } else if (type == 2) {
                    myRecycleViewAdapter.add_data(voList_all);
                    myRecycleViewAdapter.notifyDataSetChanged();
                }
            }
        } catch (Exception e) {

        }
    }


    MyRecycleViewAdapter myRecycleViewAdapter;


    public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {


        private LayoutInflater inflater;

        private ArrayList<Bean_share.DataBean.VoListBean> datas = new ArrayList<>();

        private Context context;

        public MyRecycleViewAdapter(ArrayList<Bean_share.DataBean.VoListBean> datas, Context context) {

            this.datas.clear();

            this.datas.addAll(datas);

            this.context = context;

            this.inflater = LayoutInflater.from(context);

        }


        public void clear_data(ArrayList<Bean_share.DataBean.VoListBean> datas) {

            this.datas.clear();
            this.datas.addAll(datas);

            notifyDataSetChanged();

        }


        public void add_data(ArrayList<Bean_share.DataBean.VoListBean> datas) {

            this.datas.addAll(datas);

            notifyDataSetChanged();

        }

        @Override
        public MyRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_share, parent, false);
            return new MyRecycleViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyRecycleViewAdapter.ViewHolder holder, final int position) {

            try {
                holder.text_refund_title.setText(datas.get(position).getName());
                holder.text_price.setText(datas.get(position).getPrice() * 0.01 + "");
//holder.text_time.setText(datas.get(position).);
                holder.text_yongjin.setText("佣金+"+datas.get(position).getCommission()*0.01+"");
                Glide.with(ActMyShare.this).load(datas.get(position).getLogoUrl()).into(holder.img_head);
                holder.text_context.setText(datas.get(position).getIntro());
                Glide.with(ActMyShare.this).load(datas.get(position).getPosterUrl()).into(holder.img_refund);
            }catch (Exception e){

            }


        }

        @Override
        public int getItemCount() {
            return
                    datas.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {


            RoundedImageView img_head;

            TextView text_refund_title;

            TextView text_context;

            ImageView img_refund;

            TextView text_price;

            TextView text_time;

            TextView text_yongjin;

            public ViewHolder(View itemView) {
                super(itemView);
                img_head = (RoundedImageView) itemView.findViewById(R.id.img_head);
                text_refund_title = (TextView) itemView.findViewById(R.id.text_refund_title);
                img_refund = (ImageView) itemView.findViewById(R.id.img_refund);
                text_price = (TextView) findViewById(R.id.text_price);
                text_time = (TextView) findViewById(R.id.text_time);
                text_yongjin = (TextView) findViewById(R.id.text_yongjin);
                text_context = (TextView) findViewById(R.id.text_context);
            }
        }
    }


}
