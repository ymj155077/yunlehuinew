package com.example.YunleHui.ui.act.ActComPur;

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
import com.example.YunleHui.Bean.Bean_mall;
import com.example.YunleHui.R;
import com.example.YunleHui.adpter.MyRecycleViewAdapter;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.acthome.ActComdetails;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.MyXrecycleview;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ActNearMer extends BaseAct {


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;




    private ArrayList<Bean_mall.DataBean.ShopInfoListBean> shopInfoListAll = new ArrayList<>();


    @BindView(R.id.my_Xreteam)
    MyXrecycleview my_Xreteam;


    private MyRecycleViewAdapter myRecycleViewAdapter;


    public static ActNearMer actNearMer;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_near_mer;
    }

    @Override
    protected void findViews() {

        TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
        text_center.setText("附近商铺");

    }


    private String img_she = "";


    private String name = "";


    @Override
    public void initData() {

        actNearMer = this;

        shopInfoListAll.clear();
        Intent intent = getIntent();
        shopInfoListAll = (ArrayList<Bean_mall.DataBean.ShopInfoListBean>) intent.getSerializableExtra("shopInfoListAll");

        img_she = intent.getStringExtra("img_she");

        name = intent.getStringExtra("name");

        Tools.setManger(my_Xreteam, this);

        View view = LayoutInflater.from(this).inflate(R.layout.item_mer, null);


        ImageView img_kk = view.findViewById(R.id.img_kk);

        TextView text_lak = view.findViewById(R.id.text_lak);

        Glide.with(this).load(img_she).into(img_kk);
        text_lak.setText(name);

        my_Xreteam.addHeaderView(view);

        myRecycleViewAdapter = new MyRecycleViewAdapter(shopInfoListAll, this);

        my_Xreteam.setAdapter(myRecycleViewAdapter);

        my_Xreteam.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        my_Xreteam.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        my_Xreteam.loadMoreComplete();
                    }
                }, 1000);
            }
        });







    }


//    @OnClick({R.id.lin_shop_center})
//    public void OnClick(View view) {
//        switch (view.getId()) {
//            case R.id.lin_shop_center:
//                startActivity(ActShopCenter.class);
//                break;
//        }
//    }


    public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {

        private LayoutInflater inflater;

        private ArrayList<Bean_mall.DataBean.ShopInfoListBean> datas = new ArrayList<>();

        private Context context;

        public MyRecycleViewAdapter(ArrayList<Bean_mall.DataBean.ShopInfoListBean> datas, Context context) {

            this.datas.clear();

            this.datas.addAll(datas);

            this.context = context;

            this.inflater = LayoutInflater.from(context);

        }


        public void clear_data(ArrayList<Bean_mall.DataBean.ShopInfoListBean> datas) {

            this.datas.clear();
            this.datas.addAll(datas);

            notifyDataSetChanged();

        }


        public void add_data(ArrayList<Bean_mall.DataBean.ShopInfoListBean> datas) {

            this.datas.addAll(datas);

            notifyDataSetChanged();

        }

        @Override
        public MyRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shoppa, parent, false);
            return new MyRecycleViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyRecycleViewAdapter.ViewHolder holder, final int position) {


            Glide.with(context).load(datas.get(position).getShopLogoUrl()).into(holder.img_sa);
            holder.text_name.setText(datas.get(position).getShopName());
            holder.text_size.setText(datas.get(position).getSalesVolume() + "");
            holder.text_time.setText(datas.get(position).getOpenTime());


            holder.lin_shop_center.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(context,ActShopCenterNew.class);

                    intent.putExtra("shopId",datas.get(position).getId()+"");

                    intent.putExtra("tel",datas.get(position).getShopTel());

                    intent.putExtra("name",datas.get(position).getShopName());

                    intent.putExtra("address",datas.get(position).getShopAddress());

                    intent.putExtra("img",datas.get(position).getShopLogoUrl());

                    intent.putExtra("shopIdd",datas.get(position).getId());
                    intent.putExtra("communityId",datas.get(position).getId());
                    startActivity(intent);
                }
            });


        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView img_sa;
            private TextView text_name;
            private TextView text_juli;
            private TextView text_fen;
            private TextView text_size;
            private TextView text_time;

            private LinearLayout lin_shop_center;

            public ViewHolder(View itemView) {
                super(itemView);

                lin_shop_center = (LinearLayout) itemView.findViewById(R.id.lin_shop_center);

                img_sa = (ImageView) itemView.findViewById(R.id.img_sa);
                text_name = (TextView) itemView.findViewById(R.id.text_name);
                text_juli = (TextView) itemView.findViewById(R.id.text_juli);
                text_fen = (TextView) itemView.findViewById(R.id.text_fen);
                text_size = (TextView) itemView.findViewById(R.id.text_size);
                text_time = (TextView) itemView.findViewById(R.id.text_time);
            }
        }
    }


}
