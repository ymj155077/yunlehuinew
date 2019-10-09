package com.example.YunleHui.ui.act.actme.actbusiness;

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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.frag.fragshop.fragConsumed;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.MyXrecycleview;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 *
 *
 * 核销历史
 *
 * */

public class ActWriteHistory extends BaseAct {


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    @BindView(R.id.Xre_History)
    MyXrecycleview Xre_History;


    private MyRecycleViewAdapter myRecycleViewAdapter;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this,clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_write_history;
    }

    @Override
    protected void findViews() {

        if (toolbar_all!=null){
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("核销历史");
        }

    }

    @Override
    public void initData() {

        Tools.setManger(Xre_History,this);


        ArrayList<String> datas = new ArrayList<>();
        datas.clear();
        for (int i = 0; i < 10; i++) {
            datas.add("");
        }

        myRecycleViewAdapter = new MyRecycleViewAdapter(datas,this);

        Xre_History.setAdapter(myRecycleViewAdapter);

        Xre_History.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
//                page = 1;
//                type = 0;
//                HttpUtil.addMapparams();
//                params.put("longitude", "");
//                params.put("latitude", "");
//                params.put("shopClassId", "");
//                params.put("shopCityId", "");
//                params.put("offset", "");
//                HttpUtil.Post_request("frontShop/recommendGoods", params);


//                HttpUtil.getAsynHttp("frontShop/recommendGoods?" +
//                        "longitude=" + "" +
//                        "&latitude=" + "" +
//                        "&shopClassId=" + "" +
//                        "&shopCityId=" + "" +
//                        "&offset=" + ""
//                );
//
//
//                getdata("frontShop/recommendGoods");
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Xre_History.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {
//                ++page;
//                type = 2;
//                HttpUtil.addMapparams();
//                params.put("longitude", "");
//                params.put("latitude", "");
//                params.put("shopClassId", "");
//                params.put("shopCityId", "");
//                params.put("offset", "");
//
//                HttpUtil.Post_request("frontShop/recommendGoods", params);


//                HttpUtil.getAsynHttp("frontShop/recommendGoods?" +
//
//                        "longitude=" + "" +
//                        "&latitude=" + "" +
//                        "&shopClassId=" + "" +
//                        "&shopCityId=" + "" +
//                        "&offset=" + ""
//                );
//                getdata("frontShop/recommendGoods");

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Xre_History.loadMoreComplete();
                    }
                }, 1000);
            }
        });
    }







    public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {


        private LayoutInflater inflater;

        private ArrayList<String> datas = new ArrayList<>();

        private Context context;

        public MyRecycleViewAdapter(ArrayList<String> datas, Context context) {

            this.datas.clear();

            this.datas.addAll(datas);

            this.context = context;

            this.inflater = LayoutInflater.from(context);

        }


        public void clear_data(ArrayList<String> datas) {

            this.datas.clear();
            this.datas.addAll(datas);

            notifyDataSetChanged();

        }


        public void add_data(ArrayList<String> datas) {

            this.datas.addAll(datas);

            notifyDataSetChanged();

        }

        @Override
        public MyRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_his, parent, false);
            return new MyRecycleViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyRecycleViewAdapter.ViewHolder holder, final int position) {


            holder.lin_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context,ActOrderDetails.class));
                }
            });


        }

        @Override
        public int getItemCount() {
            return
                    datas.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private LinearLayout lin_details;

            public ViewHolder(View itemView) {
                super(itemView);


                lin_details = (LinearLayout) itemView.findViewById(R.id.lin_details);

            }
        }
    }




















}
