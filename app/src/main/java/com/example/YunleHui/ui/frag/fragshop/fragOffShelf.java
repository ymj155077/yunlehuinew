package com.example.YunleHui.ui.frag.fragshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseFrag;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.MyXrecycleview;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by admin on 2019/8/30 0030.
 *
 *
 * 已下架
 *
 *
 */

public class fragOffShelf extends BaseFrag {




    @BindView(R.id.xre_shelf)
    MyXrecycleview xre_shelf;



    @BindView(R.id.frag_chu)
    FrameLayout frag_chu;

    @BindView(R.id.text_sure)
    TextView text_sure;

    private MyRecycleViewAdapter myRecycleViewAdapter;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(),clz));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_off_shelf;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }



    @OnClick({R.id.text_sure})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.text_sure:
                frag_chu.setVisibility(View.GONE);
                break;
        }
    }




    @Override
    protected void initData() {
        Tools.setManger(xre_shelf, getActivity());

        ArrayList<String> datas = new ArrayList<>();
        datas.clear();
        for (int i = 0; i < 10; i++) {
            datas.add("");
        }

        myRecycleViewAdapter = new MyRecycleViewAdapter(datas, getActivity());

        xre_shelf.setAdapter(myRecycleViewAdapter);

        xre_shelf.setLoadingListener(new XRecyclerView.LoadingListener() {
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
//                getdata("frontShop/recommendGoods");
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        xre_shelf.refreshComplete();
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
//                HttpUtil.Post_request("frontShop/recommendGoods", params);
//                HttpUtil.getAsynHttp("frontShop/recommendGoods?" +
//                        "longitude=" + "" +
//                        "&latitude=" + "" +
//                        "&shopClassId=" + "" +
//                        "&shopCityId=" + "" +
//                        "&offset=" + ""
//                );
//                getdata("frontShop/recommendGoods");

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        xre_shelf.loadMoreComplete();
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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ietm_xiajia, parent, false);
            return new MyRecycleViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyRecycleViewAdapter.ViewHolder holder, final int position) {
holder.lin_details.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        frag_chu.setVisibility(View.VISIBLE);
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
