package com.example.YunleHui.ui.frag;

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
import com.example.YunleHui.ui.act.ActComPur.ActComMall;
import com.example.YunleHui.ui.act.acthome.ActComdetails;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.MyXrecycleview;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by admin on 2019/8/29 0029.
 * <p>
 * <p>
 * 社区购
 */

public class fragComPur extends BaseFrag {


    @BindView(R.id.xre_pur)
    MyXrecycleview xre_pur;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(), clz));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_com_pur;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    private MZBannerView mMZBanner;

    @Override
    protected void initData() {

        Tools.setManger(xre_pur, getActivity());

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.shequ_head, null);

        mMZBanner = (MZBannerView) view.findViewById(R.id.banner);

        xre_pur.addHeaderView(view);

        ArrayList<String> imgs
                = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            imgs.add("http://5b0988e595225.cdn.sohucs.com/images/20180413/88b2c986a2cc4ea088095ce5ae02ef51.jpeg");
        }

        // 设置数据
        mMZBanner.setPages(imgs, new MZHolderCreator<fragExplosive.BannerViewHolder>() {
            @Override
            public fragExplosive.BannerViewHolder createViewHolder() {
                return new fragExplosive.BannerViewHolder();
            }
        });

        mMZBanner.start();//开始轮播


        ArrayList<String> datas = new ArrayList<>();
        datas.clear();

        for (int i = 0; i < 4; i++) {
            datas.add("");
        }

        MyRecycleViewAdapter myRecycleViewAdapter = new MyRecycleViewAdapter(datas, getActivity());

        xre_pur.setAdapter(myRecycleViewAdapter);


        xre_pur.setLoadingListener(new XRecyclerView.LoadingListener() {
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
                        xre_pur.refreshComplete();
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
                        xre_pur.loadMoreComplete();
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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wanda, parent, false);
            return new MyRecycleViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyRecycleViewAdapter.ViewHolder holder, final int position) {
            holder.lin_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, ActComMall.class));
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
