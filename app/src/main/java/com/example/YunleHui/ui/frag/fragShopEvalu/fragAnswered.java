package com.example.YunleHui.ui.frag.fragShopEvalu;



import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.BeanHomeList;
import com.example.YunleHui.R;
import com.example.YunleHui.adpter.MyRecycleViewAdapter;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseFrag;
import com.example.YunleHui.ui.act.acthome.ActComdetails;
import com.example.YunleHui.ui.act.actme.actbusiness.ActShopCom;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.MyXrecycleview;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;


//商家评价管理待回复

public class fragAnswered extends BaseFrag {


    @BindView(R.id.xrecyc_answer)
    MyXrecycleview xrecyc_answer;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(),clz));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_answered;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }


    private int offset = 0;

    private int max = 10;

    private int type = 0;

    private int replyId;


    @Override
    protected void initData() {

        Tools.setManger(xrecyc_answer, getActivity());

        try {
            xrecyc_answer.setLoadingListener(new XRecyclerView.LoadingListener() {
                @Override
                public void onRefresh() {

                    offset = 1;
                    type = 0;
                    HttpUtil.addMapparams();
                    HttpUtil.params.put("shopUserId", MyApp.shopId);
                    HttpUtil.params.put("shopReplyState", 0);
                    HttpUtil.params.put("offset", offset);
                    HttpUtil.params.put("max", max);
                    HttpUtil.Post_request("frontShop/getShopReply", HttpUtil.params);
                    getdata("frontShop/getShopReply");

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            xrecyc_answer.refreshComplete();
                        }
                    }, 1000);
                }

                @Override
                public void onLoadMore() {

                    ++offset;
                    type = 2;
                    HttpUtil.addMapparams();
                    HttpUtil.params.put("shopUserId", MyApp.shopId);
                    HttpUtil.params.put("shopReplyState", 0);
                    HttpUtil.params.put("offset", offset);
                    HttpUtil.params.put("max", max);
                    HttpUtil.Post_request("frontShop/getShopReply", HttpUtil.params);
                    getdata("frontShop/getShopReply");

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            xrecyc_answer.loadMoreComplete();
                        }
                    }, 1000);
                }
            });

        } catch (Exception e) {

        }
        xrecyc_answer.refresh();
    }


    private MyRecycleViewAdapter myRecycleViewAdapter;


    @Override
    public void StringResulit(String key, String value) {


        if (key.equals("frontShop/getShopReply")){

            if (type == 0){

                ArrayList<String> datas = new ArrayList<>();

                for (int i = 0; i < 10; i++) {
                    datas.add("");
                }

                myRecycleViewAdapter = new MyRecycleViewAdapter(datas,getActivity());
                xrecyc_answer.setAdapter(myRecycleViewAdapter);

            }else if (type == 2){



            }


        }


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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_answer, parent, false);
            return new MyRecycleViewAdapter.ViewHolder(view);

        }

        @Override
        public void onBindViewHolder(MyRecycleViewAdapter.ViewHolder holder, final int position) {
            holder.lin_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(getActivity(),ActShopCom.class);

                    startActivity(intent);

                }
            });
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private TextView useName,text_top,shopName,text_details,text_time;

            private ImageView img_shop;

            private LinearLayout lin_use;

            private LinearLayout lin_details;

            public ViewHolder(View itemView) {
                super(itemView);

                useName = (TextView) itemView.findViewById(R.id.useName);
                text_top = (TextView) itemView.findViewById(R.id.text_top);
                shopName = (TextView) itemView.findViewById(R.id.shopName);
                text_details = (TextView) itemView.findViewById(R.id.text_details);
                text_time = (TextView) itemView.findViewById(R.id.text_time);
                img_shop = (ImageView) itemView.findViewById(R.id.img_shop);
                lin_use = (LinearLayout) itemView.findViewById(R.id.lin_use);
                lin_details = (LinearLayout) itemView.findViewById(R.id.lin_details);

            }

        }
    }






}
