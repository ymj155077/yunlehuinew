package com.example.YunleHui.ui.frag.fragshop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.BeanHomeList;
import com.example.YunleHui.Bean.Bean_con;
import com.example.YunleHui.Bean.Bean_med;
import com.example.YunleHui.Bean.Bean_xiang;
import com.example.YunleHui.R;
import com.example.YunleHui.adpter.MyRecycleViewAdapter;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.base.BaseFrag;
import com.example.YunleHui.ui.act.acthome.ActComdetails;
import com.example.YunleHui.ui.act.actme.actbusiness.ActOrderDetails;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.MyXrecycleview;
import com.example.YunleHui.view.NoScrollListView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by admin on 2019/8/29 0029.
 * <p>
 * <p>
 * 已支付
 */

public class fragConsumed extends BaseFrag {


    ArrayList<Bean_xiang> datasOrder = new ArrayList<>();



    @BindView(R.id.Xre_con)
    MyXrecycleview Xre_con;


    private MyRecycleViewAdapter myRecycleViewAdapter;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(), clz));
    }


    @Override
    protected int getLayoutId() {
        return R.layout.frag_consumed;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }


    private int state = 2;
    private int deliveryRecord = -2;

    private int type = 0;

    private int page = 1;
    private int size = 10;


    @Override
    public void initData() {


        Tools.setManger(Xre_con, getActivity());

        Xre_con.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                type = 0;
                HttpUtil.addMapparams();
                HttpUtil.params.put("shopId", MyApp.shopId);
                HttpUtil.params.put("state", state);
                HttpUtil.params.put("deliveryRecord", deliveryRecord);
                HttpUtil.params.put("page", page);
                HttpUtil.params.put("size", size);
                HttpUtil.Post_request("backShop/order/allShopOrderList", HttpUtil.params);
//                HttpUtil.getAsynHttp("backShop/order/OperateShopOrder?" +
//                        "shopId=" + MyApp.shopId +
//                        "&state=" + state+
//                        "&deliveryRecord=" + deliveryRecord
//                );
                getdata("backShop/order0");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Xre_con.refreshComplete();
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



                ++page;
                type = 2;
                HttpUtil.addMapparams();
                HttpUtil.params.put("shopId", MyApp.shopId);
                HttpUtil.params.put("state", state);
                HttpUtil.params.put("deliveryRecord", deliveryRecord);
                HttpUtil.params.put("page", page);
                HttpUtil.params.put("size", size);
                HttpUtil.Post_request("backShop/order/allShopOrderList", HttpUtil.params);

                getdata("backShop/order0");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Xre_con.loadMoreComplete();
                    }
                }, 1000);
            }
        });

        Xre_con.refresh();

    }


    public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {


        private LayoutInflater inflater;

        private ArrayList<Bean_con.DataBean> datas = new ArrayList<>();

        private Context context;

        public MyRecycleViewAdapter(List<Bean_con.DataBean> datas, Context context) {

            this.datas.clear();

            this.datas.addAll(datas);

            this.context = context;

            this.inflater = LayoutInflater.from(context);

        }


        public void clear_data(List<Bean_con.DataBean> datas) {

            this.datas.clear();
            this.datas.addAll(datas);

            notifyDataSetChanged();

        }


        public void add_data(List<Bean_con.DataBean> datas) {

            this.datas.addAll(datas);

            notifyDataSetChanged();

        }

        @Override
        public MyRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_yishiyong, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyRecycleViewAdapter.ViewHolder holder, final int position) {


            holder.lin_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, ActOrderDetails.class));
                }
            });


            datasOrder.clear();

            if (datas.get(position).getOrderNature() == 0){








                bean_med = MyApp.gson.fromJson(datas.get(position).getOrderDetailList().get(0).getShopDetail(),Bean_med.class);



                datasOrder.add(new Bean_xiang(datas.get(position).getOrderDetailList().get(0).getLogoUrl(),
                        datas.get(position).getOrderDetailList().get(0).getGoodsName(),
                        bean_med.getIntro(),
                        Tools.chenfa(bean_med.getPrice())+""
                        ));





                myListApter = new MyListApter(datasOrder,getActivity());
                holder.list_yishi.setAdapter(myListApter);
                holder.list_yishi.setFocusable(false);


            }







        }

        @Override
        public int getItemCount() {
            return
                    datas.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private LinearLayout lin_details;

            private NoScrollListView list_yishi;

            private TextView text_time;


            public ViewHolder(View itemView) {
                super(itemView);

                lin_details = (LinearLayout) itemView.findViewById(R.id.lin_details);

                text_time = (TextView) itemView.findViewById(R.id.text_time);

                list_yishi = (NoScrollListView) itemView.findViewById(R.id.list_yishi);


            }
        }
    }


    public MyListApter myListApter;


    public class MyListApter extends BaseAdapter {

        private ArrayList<Bean_xiang> datas = new ArrayList<>();

        private LayoutInflater inflater;

        public MyListApter(ArrayList<Bean_xiang> datas, Context context) {

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

            MyViewHolder myViewHolder = null;


            myViewHolder = new MyViewHolder();

            convertView = inflater.inflate(R.layout.item_listshop, parent, false);


            convertView.setTag(myViewHolder);


            return convertView;
        }


        public class MyViewHolder {
            private ImageView img_shop;
            private TextView text_details;
            private TextView text_context;
            private TextView text_price;
        }
    }



    private Bean_con bean_con;
    private boolean success;
    private int code;
    private String msg;
    private List<Bean_con.DataBean> data;



    @Override
    public void stringResulit(String key, String value) {


        if (key.equals("backShop/order0")) {




//            private Bean_con bean_con;
//            private boolean success;
//            private int code;
//            private String msg;
//            private List<Bean_con.DataBean> data;



            bean_con = MyApp.gson.fromJson(value,Bean_con.class);


            data = bean_con.getData();

            myRecycleViewAdapter = new MyRecycleViewAdapter(data, getActivity());

            Xre_con.setAdapter(myRecycleViewAdapter);
        }


    }






//爆款详情的数据
    private Bean_med bean_med;
    private int buyLimited;
    private int commission;
    private String description;
    private String distance;
    private Bean_med.GoodsEffectiveTimeBean goodsEffectiveTime;
    private int id;
    private String intro;
    private int inventory;
    private String logoUrl;
    private String name;
    private Bean_med.OrderEffectiveTimeBean orderEffectiveTime;
    private int originalPrice;
    private String posterUrl;
    private int preTime;
    private int price;
    private int salesVolume;
    private Bean_med.ShopBean shop;
    private String specification;
    private int verificationPrice;
    private List<String> bannerUrlList;
    private List<Bean_med.GoodsSetMealListBean> goodsSetMealList;
    private List<Bean_med.ShopListBean> shopList;






}
