package com.example.YunleHui.ui.frag.fragorder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.BeanShequ;
import com.example.YunleHui.Bean.BeanTwo_list;
import com.example.YunleHui.Bean.Bean_detailas;
import com.example.YunleHui.Bean.Bean_no_use;
import com.example.YunleHui.Bean.Bean_orderList;
import com.example.YunleHui.Bean.Bean_shop;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseFrag;
import com.example.YunleHui.ui.act.actme.actorder.ActComPurUsed;
import com.example.YunleHui.ui.act.actme.actorder.ActDetailstoused;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.MyXrecycleview;
import com.example.YunleHui.view.NoScrollListView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;

/**
 * Created by admin on 2019/8/14 0014.
 * <p>
 * 未使用
 */

public class fragnoTused extends BaseFrag {


    @BindView(R.id.xre_toused)
    MyXrecycleview xre_toused;
    private int offset = 1;
    private int max = 10;
    private int type = 0;
    private Bean_no_use bean_no_use;
    private boolean success;
    private int code;
    private String msg;
    private Bean_no_use.DataBean data;
    private List<Bean_no_use.DataBean.VoListBean> voList;
    private ArrayList<Bean_no_use.DataBean.VoListBean> voList_ = new ArrayList<>();


    @Override
    protected int getLayoutId() {
        return R.layout.frag_notused;
    }

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(), clz));
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }
    private Bean_orderList bean_orderList;

    @Override
    protected void initData() {
        Tools.setManger(xre_toused, getActivity());
        try {
            xre_toused.setLoadingListener(new XRecyclerView.LoadingListener() {
                @Override
                public void onRefresh() {
                    offset = 1;
                    type = 0;
                    HttpUtil.addMapparams();
                    HttpUtil.params.put("state", 2);
                    HttpUtil.params.put("sort", 0);
                    HttpUtil.params.put("offset", offset);
                    HttpUtil.params.put("max", max);
                    HttpUtil.Post_request("orderFull/list", HttpUtil.params);
                    getdata("2_list");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            xre_toused.refreshComplete();
                        }
                    }, 1000);
                }
                @Override
                public void onLoadMore() {
                    ++offset;
                    type = 2;
                    HttpUtil.addMapparams();
                    HttpUtil.params.put("state", 2);
                    HttpUtil.params.put("sort", 0);
                    HttpUtil.params.put("offset", offset);
                    HttpUtil.params.put("max", max);
                    HttpUtil.Post_request("orderFull/list", HttpUtil.params);
                    getdata("2_list");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            xre_toused.loadMoreComplete();
                        }
                    }, 1000);
                }
            });
        } catch (Exception e) {

        }
        xre_toused.refresh();
    }

    @Override
    public void stringResulit(String key, String value){
        try {
            if (key.equals("2_list")) {
                JSONObject json = new JSONObject(value);
                JSONObject result = json.getJSONObject("data");
                JSONArray voList = result.getJSONArray("voList");
                ArrayList<BeanTwo_list> datas = new ArrayList<>();
                datas.clear();
                for (int i = 0; i < voList.length(); i++) {
                    String values = voList.getString(i);
                    JSONObject jsonObject = new JSONObject(values);
                    int orderNature = jsonObject.getInt("orderNature");
                    String   shopName = jsonObject.getString("shopName");
                    int receiveWay = jsonObject.getInt("receiveWay");
                    JSONArray orderDetailList = jsonObject.getJSONArray("orderDetailList");
//                  订单号
                    String orderNum = jsonObject.getString("orderNum");
//                    总金额
                    int totalMoney =  jsonObject.getInt("totalMoney");
//                  总数量
                    int totalNum = jsonObject.getInt("totalNum");

                    //                    是否评价过的

                    int isComment = jsonObject.getInt("isComment");

                    Tools.i("orderNature_notused", orderNature + "---" + orderDetailList.toString() + "---");
//                    订单Id
                    datas.add(new BeanTwo_list(orderNature, values, shopName, receiveWay,orderNum,totalMoney,totalNum,value,isComment));
                }
                if (type == 0) {
                    myRecycleViewAdapter = new MyRecycleViewAdapter(datas, getActivity());
                    xre_toused.setAdapter(myRecycleViewAdapter);
                } else if (type == 1) {
                    myRecycleViewAdapter.clear_data(datas);
                    myRecycleViewAdapter.notifyDataSetChanged();
                } else if (type == 2) {
                    myRecycleViewAdapter.add_data(datas);
                    myRecycleViewAdapter.notifyDataSetChanged();
                }
            }
        } catch (Exception e) {

        }
    }


    MyRecycleViewAdapter myRecycleViewAdapter;
    private Bean_shop bean_shop;
    private BeanShequ beanShequ;
    public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {

        private ArrayList<BeanTwo_list> datas = new ArrayList<>();

        private LayoutInflater inflater;
        private Context context;

        public MyRecycleViewAdapter(ArrayList<BeanTwo_list> datas, Context context) {
            this.datas.clear();
            this.datas.addAll(datas);
            this.context = context;
            this.inflater = LayoutInflater.from(context);
        }


        public void clear_data(ArrayList<BeanTwo_list> datas) {

            this.datas.clear();
            this.datas.addAll(datas);
            notifyDataSetChanged();

        }


        public void add_data(ArrayList<BeanTwo_list> datas) {
            this.datas.addAll(datas);
            notifyDataSetChanged();
        }

        @Override
        public MyRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_order_no, parent, false);
            return new MyRecycleViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final MyRecycleViewAdapter.ViewHolder holder, final int position) {
            Tools.i("sssssssss", datas.get(position).getOrderDetail() + "----");
            holder.text_price_all.setText(Tools.chenfa(datas.get(position).getTotalMoney()));
            holder.text_size.setText(datas.get(position).getTotalNum()+"");

            holder.text_state_title.setText("未使用");

            if (datas.get(position).getOrderNature() == 0) {

////                爆款
//                Bean_detailas bean_detailas = MyApp.gson.fromJson(datas.get(position).getValue(), Bean_detailas.class);
//                List<BeanShequ.OrderDetailListBean> orderDetailList = new ArrayList<>();
//                orderDetailList.clear();
////爆款的详情界面
//                List<Bean_detailas.DataBean.VoListBean.OrderDetailListBean> order = bean_detailas.getData().getVoList().get(position).getOrderDetailList();
//
//
//                holder.text_title.setText(order.get(0).getShopName());
//
//
//                orderDetailList.add(new BeanShequ.OrderDetailListBean(
//                        order.get(0).getId(),
////                        datas.get(position).getOrderNum(),
//                        0,
//                        order.get(0).getGoodsId(),
//                        order.get(0).getGoodsSetName(),
//                        datas.get(position).getTotalMoney()/order.get(0).getCount(),
//                        datas.get(position).getTotalNum(),
//                        "",
//                        datas.get(position).getTotalMoney(),
//                        "",
//                        order.get(0).getLogoUrl()
//                ));









                Bean_detailas bean_detailas = MyApp.gson.fromJson(datas.get(position).getValue(), Bean_detailas.class);
                List<BeanShequ.OrderDetailListBean> orderDetailList = new ArrayList<>();
                orderDetailList.clear();
//爆款的详情界面
                List<Bean_detailas.DataBean.VoListBean.OrderDetailListBean> order = bean_detailas.getData().getVoList().get(position).getOrderDetailList();


                holder.text_title.setText(order.get(0).getShopName());


                orderDetailList.add(new BeanShequ.OrderDetailListBean(
                        order.get(0).getId(),
//                        datas.get(position).getOrderNum(),
                        0,
                        order.get(0).getGoodsId(),
                        order.get(0).getGoodsSetName(),
                        datas.get(position).getTotalMoney()/order.get(0).getCount(),
                        datas.get(position).getTotalNum(),
                        "",
                        datas.get(position).getTotalMoney(),
                        "",
                        order.get(0).getLogoUrl()
                ));
                myNoAdapter = new MyNoAdapter(orderDetailList, context);
                holder.list_bao.setAdapter(myNoAdapter);

            } else {
//                社区购
                List<BeanShequ.OrderDetailListBean> orderDetailList;

                beanShequ = MyApp.gson.fromJson(datas.get(position).getOrderDetail(), BeanShequ.class);
                orderDetailList = beanShequ.getOrderDetailList();
                myNoAdapter = new MyNoAdapter(orderDetailList, context);
                holder.list_bao.setAdapter(myNoAdapter);


                holder.text_title.setText(beanShequ.getShopName());


            }


            holder.list_bao.setFocusable(false);


//            再来一单
//            holder.lin_use.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (datas.get(position).getOrderNature()==0){
//                        bean_shop = MyApp.gson.fromJson(datas.get(position).getOrderDetail(), Bean_shop.class);
//                        Intent intent = new Intent(context, ActDeterOrder.class);
//                        intent.putExtra("goodsSetId", bean_shop.getOrderDetailList().get(0).getGoodsSetId());
//                        intent.putExtra("goodsId", bean_shop.getOrderDetailList().get(0).getGoodsId());
//                        intent.putExtra("name", bean_shop.getOrderDetailList().get(0).getGoodsName());
//                        Bean_detailas bean_detailas;
//                        bean_detailas = MyApp.gson.fromJson(bean_shop.getOrderDetailList().get(0).getShopDetail(), Bean_detailas.class);
//                        List<BeanShequ.OrderDetailListBean> orderDetailList = new ArrayList<>();
//                        intent.putExtra("url", orderDetailList.get(0).getLogoUrl());
//                        intent.putExtra("content", content);
//                        intent.putExtra("price_tao", price_tao);
//                        startActivity(intent);
//                    }
//                }
//            });

            holder.list_bao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//爆款
                    if (datas.get(position).getOrderNature() == 0) {
                        Intent intent = new Intent(context, ActDetailstoused.class);
                        if (datas.get(position).getReceiveWay() == 1) {
                            intent.putExtra("fang_shi","到商家取");
                        }else if (datas.get(position).getReceiveWay()==2){
                            intent.putExtra("fang_shi","到社区取");
                        }else if (datas.get(position).getReceiveWay()==3){
                            intent.putExtra("fang_shi","商家送货");
                        }else if (datas.get(position).getReceiveWay()==4){
                            intent.putExtra("fang_shi","社区送货");
                        }
                        intent.putExtra("ReceiveWay",datas.get(position).getReceiveWay());
                        intent.putExtra("Nature", datas.get(position).getOrderNature());

                            bean_shop = MyApp.gson.fromJson(datas.get(position).getOrderDetail(), Bean_shop.class);
                            intent.putExtra("order_number", datas.get(position).getOrderNum());

                        context.startActivity(intent);
                    }else {
//                        社区购
                        Intent intent = new Intent(context, ActComPurUsed.class);
                        if (datas.get(position).getReceiveWay() == 1) {
                            intent.putExtra("fang_shi","到商家取");
                        }else if (datas.get(position).getReceiveWay()==2){
                            intent.putExtra("fang_shi","到社区取");
                        }else if (datas.get(position).getReceiveWay()==3){
                            intent.putExtra("fang_shi","商家送货");
                        }else if (datas.get(position).getReceiveWay()==4){
                            intent.putExtra("fang_shi","社区送货");
                        }
                        intent.putExtra("ReceiveWay",datas.get(position).getReceiveWay());
                        intent.putExtra("Nature", datas.get(position).getOrderNature());
                            beanShequ = MyApp.gson.fromJson(datas.get(position).getOrderDetail(), BeanShequ.class);
                            intent.putExtra("order_number", datas.get(position).getOrderNum());
                        context.startActivity(intent);
                    }
                }
            });

            holder.lin_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //爆款
                    if (datas.get(position).getOrderNature() == 0) {
                        Intent intent = new Intent(context, ActDetailstoused.class);
                        if (datas.get(position).getReceiveWay() == 1) {
                            intent.putExtra("fang_shi","到商家取");
                        }else if (datas.get(position).getReceiveWay()==2){
                            intent.putExtra("fang_shi","到社区取");
                        }else if (datas.get(position).getReceiveWay()==3){
                            intent.putExtra("fang_shi","商家送货");
                        }else if (datas.get(position).getReceiveWay()==4){
                            intent.putExtra("fang_shi","社区送货");
                        }
                        intent.putExtra("ReceiveWay",datas.get(position).getReceiveWay());
                        intent.putExtra("Nature", datas.get(position).getOrderNature());
                        if (datas.get(position).getOrderNature() == 0) {
                            bean_shop = MyApp.gson.fromJson(datas.get(position).getOrderDetail(), Bean_shop.class);
                            intent.putExtra("order_number", datas.get(position).getOrderNum());
                        } else {
                            beanShequ = MyApp.gson.fromJson(datas.get(position).getOrderDetail(), BeanShequ.class);
                        }
                        context.startActivity(intent);
                    }else {
//                        社区购
                        Intent intent = new Intent(context, ActComPurUsed.class);
                        if (datas.get(position).getReceiveWay() == 1) {
                            intent.putExtra("fang_shi","到商家取");
                        }else if (datas.get(position).getReceiveWay()==2){
                            intent.putExtra("fang_shi","到社区取");
                        }else if (datas.get(position).getReceiveWay()==3){
                            intent.putExtra("fang_shi","商家送货");
                        }else if (datas.get(position).getReceiveWay()==4){
                            intent.putExtra("fang_shi","社区送货");
                        }
                        intent.putExtra("ReceiveWay",datas.get(position).getReceiveWay());
                        intent.putExtra("Nature", datas.get(position).getOrderNature());
                        beanShequ = MyApp.gson.fromJson(datas.get(position).getOrderDetail(), BeanShequ.class);
                        intent.putExtra("order_number", datas.get(position).getOrderNum());
                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {


            private NoScrollListView list_bao;

            private LinearLayout lin_details;

            private TextView text_price_all;

            private TextView text_size;

            private LinearLayout lin_use;

            private TextView text_title;

            private TextView text_state_title;

            public ViewHolder(View itemView) {
                super(itemView);

                list_bao = (NoScrollListView) itemView.findViewById(R.id.list_bao);

                lin_details = (LinearLayout) itemView.findViewById(R.id.lin_details);

                text_price_all = (TextView) itemView.findViewById(R.id.text_price_all);

                text_size = (TextView) itemView.findViewById(R.id.text_size);

                lin_use = (LinearLayout) itemView.findViewById(R.id.lin_use);

                text_title = (TextView) itemView.findViewById(R.id.text_title);

                text_state_title = (TextView) itemView.findViewById(R.id.text_state_title);

            }
        }
    }


    //未使用的爆款
    private MyNoAdapter myNoAdapter;

    public class MyNoAdapter extends BaseAdapter {


        private ArrayList<BeanShequ.OrderDetailListBean> datas = new ArrayList<>();

        private LayoutInflater inflater;

        private Context context;


        public MyNoAdapter(List<BeanShequ.OrderDetailListBean> datas, Context context) {
            this.datas.clear();
            this.datas.addAll(datas);
            this.inflater = LayoutInflater.from(context);
            this.context = context;
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

            MyViewHoder myViewHoder = null;

            if (convertView == null) {
                myViewHoder = new MyViewHoder();
                convertView = inflater.inflate(R.layout.item_no, parent, false);
//                private ImageView img_shop;
//                private TextView text_details;
//                private TextView text_price;
//                private TextView text_size;
                myViewHoder.img_shop = convertView.findViewById(R.id.img_shop);
                myViewHoder.text_details = convertView.findViewById(R.id.text_details);
                myViewHoder.text_price = convertView.findViewById(R.id.text_price);
                myViewHoder.text_size = convertView.findViewById(R.id.text_size);
                convertView.setTag(myViewHoder);
            } else {
                myViewHoder = (MyViewHoder) convertView.getTag();
            }

            try {
                Glide.with(context).load(datas.get(position).getLogoUrl()).into(myViewHoder.img_shop);

                myViewHoder.text_details.setText(datas.get(position).getGoodsName());

                myViewHoder.text_price.setText(Tools.chenfa(datas.get(position).getPrice()) + "元");

                myViewHoder.text_size.setText(datas.get(position).getNum() + "");
            } catch (Exception e) {

            }
            return convertView;
        }

        public class MyViewHoder {
            private ImageView img_shop;
            private TextView text_details;
            private TextView text_price;
            private TextView text_size;
        }
    }

    //未使用的社区购的列表
    private MyNoAdapterShe myNoAdapterShe;

    public class MyNoAdapterShe extends BaseAdapter {


        private ArrayList<BeanShequ.OrderDetailListBean> datas = new ArrayList<>();

        private LayoutInflater inflater;

        private Context context;


        public MyNoAdapterShe(List<BeanShequ.OrderDetailListBean> datas, Context context) {
            this.datas.clear();
            this.datas.addAll(datas);
            this.inflater = LayoutInflater.from(context);
            this.context = context;
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

            MyViewHoder myViewHoder = null;

            if (convertView == null) {
                myViewHoder = new MyViewHoder();
                convertView = inflater.inflate(R.layout.item_no, parent, false);
//                private ImageView img_shop;
//                private TextView text_details;
//                private TextView text_price;
//                private TextView text_size;
                myViewHoder.img_shop = convertView.findViewById(R.id.img_shop);
                myViewHoder.text_details = convertView.findViewById(R.id.text_details);
                myViewHoder.text_price = convertView.findViewById(R.id.text_price);
                myViewHoder.text_size = convertView.findViewById(R.id.text_size);
                convertView.setTag(myViewHoder);
            } else {
                myViewHoder = (MyViewHoder) convertView.getTag();
            }

            try {
                Glide.with(context).load(datas.get(position).getLogoUrl()).into(myViewHoder.img_shop);

                myViewHoder.text_details.setText(datas.get(position).getGoodsName());

                myViewHoder.text_price.setText(datas.get(position).getPrice() * 0.01 + "元");

                myViewHoder.text_size.setText(datas.get(position).getNum() + "");
            } catch (Exception e) {

            }
            return convertView;
        }

        public class MyViewHoder {
            private ImageView img_shop;
            private TextView text_details;
            private TextView text_price;
            private TextView text_size;
        }
    }


}
