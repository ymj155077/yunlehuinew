package com.example.YunleHui.ui.frag.fragshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseFrag;
import com.example.YunleHui.ui.act.actme.actbusiness.ActOrderDetails;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.MyXrecycleview;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by admin on 2019/8/29 0029.
 * <p>
 * 商户已添加
 */

public class fragAdded extends BaseFrag {


    private String goodsName = "";


    private int state = 1;


    @BindView(R.id.xre_added)
    MyXrecycleview xre_added;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(), clz));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_added;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }


    private MyRecycleViewAdapter myRecycleViewAdapter;


    @Override
    protected void initData() {


//        HttpUtil.getAsynHttp("backShop/goods/list?" +
//                "goodsName=" + goodsName +
//                "&state=" + state
//        );
//
//        getdata("backShop/one");

        Tools.setManger(xre_added, getActivity());

        xre_added.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
//                page = 1;
//                type = 0;

//                HttpUtil.addMapparams();
//                HttpUtil.params.put("goodsName=",goodsName);
//
//                HttpUtil.params.put("state" , state);
//                HttpUtil.Post_request("backShop/goods/list",HttpUtil.params);
//
//                getdata("backShop/one");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xre_added.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {
//                ++page;
//                type = 2;


//                HttpUtil.getAsynHttp("backShop/goods/list" +
//                        "goodsName=" + goodsName +
//                        "&state=" + state
//                );
//                getdata("backShop/one");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xre_added.loadMoreComplete();
                    }
                }, 1000);
            }
        });


        xre_added.refresh();


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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_isadd, parent, false);
            return new MyRecycleViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyRecycleViewAdapter.ViewHolder holder, final int position) {

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


    public void stringResulit(String key, String value) {


        if (key.equals("backShop/goods/list")){
            ArrayList<String> datas = new ArrayList<>();
            datas.clear();
            for (int i = 0; i < 10; i++) {
                datas.add("");
            }
            myRecycleViewAdapter = new MyRecycleViewAdapter(datas, getActivity());

            xre_added.setAdapter(myRecycleViewAdapter);
        }





    }


}
