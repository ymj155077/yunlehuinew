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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.BeanShequ;
import com.example.YunleHui.Bean.BeanTwo_list;
import com.example.YunleHui.Bean.Bean_dai;
import com.example.YunleHui.Bean.Bean_detailas;
import com.example.YunleHui.Bean.Bean_order;
import com.example.YunleHui.Bean.Bean_shop;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseFrag;
import com.example.YunleHui.ui.act.acthome.ActDeterOrder;
import com.example.YunleHui.ui.act.actme.ActTodetails;
import com.example.YunleHui.ui.act.actme.actbusiness.ActBusDistribution;
import com.example.YunleHui.ui.act.actme.actbusiness.ActComSelfOrder;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.MyXrecycleview;
import com.example.YunleHui.view.NoScrollListView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by admin on 2019/8/14 0014.
 * <p>
 * 待付款
 */

public class fragToused extends BaseFrag {

    @BindView(R.id.xre_toused)
    MyXrecycleview xre_toused;
    private int offset = 1;
    private int max = 10;
    private int type = 0;
    private Bean_order bean_dai;
    private boolean success_dai;
    private int code_dai;
    private String msg_dai;
    private Bean_order.DataBean data_dai;
    private List<Bean_order.DataBean.VoListBean> voList_dai;
    private ArrayList<Bean_order.DataBean.VoListBean> voList_All = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.frag_toused;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

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
                    HttpUtil.params.put("userId", MyApp.user);
                    HttpUtil.params.put("state", 0);
                    HttpUtil.params.put("sort", 0);
                    HttpUtil.params.put("offset", offset);
                    HttpUtil.params.put("shopClassId", 0);
                    HttpUtil.params.put("max", max);

                    HttpUtil.postRaw("orderFull/list", HttpUtil.params);
                    getdata("0_list");

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
                    HttpUtil.params.put("userId", MyApp.user);
                    HttpUtil.params.put("state", 0);
                    HttpUtil.params.put("sort", 0);
                    HttpUtil.params.put("offset", offset);
                    HttpUtil.params.put("max", max);
                    HttpUtil.postRaw("orderFull/list", HttpUtil.params);
                    getdata("0_list");

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
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(), clz));
    }


    MyRecycleViewAdapter myRecycleViewAdapter;


//    private List<Bean_order.DataBean.VoListBean.Object> orderDetailList;


    private BeanTwo_list beanTwo_list;
    private int orderNature;

    private String orderDetail;


    @Override
    public void StringResulit(String key, String value) {

        try {

            if (key.equals("0_list")) {

                JSONObject json = new JSONObject(value);
                JSONObject result = json.getJSONObject("data");
                JSONArray voList = result.getJSONArray("voList");

                ArrayList<BeanTwo_list> datas = new ArrayList<>();
                datas.clear();
                for (int i = 0; i < voList.length(); i++) {
                    String values = voList.getString(i);
                    JSONObject jsonObject = new JSONObject(values);
                    int orderNature = jsonObject.getInt("orderNature");
                    String shopName = jsonObject.getString("shopName");
                    int receiveWay = jsonObject.getInt("receiveWay");
//                  总数量

                    int totalNum = jsonObject.getInt("totalNum");

//                  订单号
                    String orderNum = jsonObject.getString("orderNum");
//                    总金额
                    int totalMoney = jsonObject.getInt("totalMoney");

                    JSONArray orderDetailList = jsonObject.getJSONArray("orderDetailList");
                    Tools.i("fragTouesd", totalNum+"++++++"+orderNature + "---" + values + "---" + shopName + "---" + receiveWay);
//                    订单Id
                    datas.add(new BeanTwo_list(orderNature, values, shopName, receiveWay, orderNum, totalMoney,totalNum));
                }

                if (type == 0) {
                    myRecycleViewAdapter = new MyRecycleViewAdapter(datas, getActivity());
                    xre_toused.setAdapter(myRecycleViewAdapter);
                } else if (type == 1) {
                    myRecycleViewAdapter.clear_data(datas);
//                    myRecycleViewAdapter.notifyDataSetChanged();
                    myRecycleViewAdapter.notifyDataSetChanged();

                } else if (type == 2) {
                    myRecycleViewAdapter.add_data(datas);
                    myRecycleViewAdapter.notifyDataSetChanged();
                }
            }
        } catch (Exception e) {

        }
        try {
            if (key.equals("Payment_on_behalf")) {

                Toast.makeText(getActivity(), "取消订单！！！", Toast.LENGTH_SHORT).show();
                xre_toused.refresh();
            }
        } catch (Exception e) {

        }

    }


    public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {

//        private ArrayList<Bean_order.DataBean.VoListBean> datas = new ArrayList<>();
//        private LayoutInflater inflater;
//        private Context context;

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
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_animation, parent, false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder,int position) {
//            orderNature  0  云享购 爆款
//                         1  社区购
            holder.text_price_all.setText(datas.get(position).getTotalMoney() * 0.01 + "");


            holder.text_boom_size.setText(datas.get(position).getTotalNum() + "");


            if (datas.get(position).getOrderNature() == 0) {
                Tools.i("bean_nature_0", datas.get(position).getOrderDetail() + "----");
                bean_shop = MyApp.gson.fromJson(datas.get(position).getOrderDetail(), Bean_shop.class);
                holder.text_title.setText(bean_shop.getShopName());
                Bean_detailas bean_detailas;
                bean_detailas = MyApp.gson.fromJson(bean_shop.getOrderDetailList().get(0).getShopDetail(), Bean_detailas.class);
                Glide.with(context).load(bean_detailas.getLogoUrl()).into(holder.img_shop);

                holder.text_details.setText(bean_detailas.getIntro());
                float num = (float) (bean_shop.getTotalMoney() / bean_shop.getOrderDetailList().get(0).getCount() * 0.01);
                DecimalFormat df = new DecimalFormat("0.00");//格式化小数
                String s = df.format(num);//返回的是String类型
                try {
                    holder.text_price.setText(s);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                holder.lin_item.setVisibility(View.VISIBLE);
                holder.no_list.setVisibility(View.GONE);
            } else {
                Log.i("bean_nature_1", datas.get(position).getOrderDetail() + "----");
                List<BeanShequ.OrderDetailListBean> orderDetailList;
                beanShequ = MyApp.gson.fromJson(datas.get(position).getOrderDetail(), BeanShequ.class);
                orderDetailList = beanShequ.getOrderDetailList();
                holder.text_details.setText(beanShequ.getOrderDetailList().get(0).getGoodsName());
                holder.text_title.setText(datas.get(position).getShopName());
                float num = (float) (beanShequ.getOrderDetailList().get(0).getPrice() / beanShequ.getOrderDetailList().get(0).getNum() * 0.01);
                DecimalFormat df = new DecimalFormat("0.00");//格式化小数
                String s = df.format(num);//返回的是String类型
                try {
                    holder.text_price.setText(s);
                } catch (Exception e) {
                    e.printStackTrace();
                }

//              String order_iD = bean_nature_1.getOrderNum();
                myNoAdapter = new MyNoAdapter(orderDetailList, context);
                holder.no_list.setAdapter(myNoAdapter);
                holder.lin_item.setVisibility(View.GONE);
                holder.no_list.setVisibility(View.VISIBLE);
//                myNoAdapter.notifyDataSetChanged();
            }
//           订单 id
//           订单详情的界面
//           社区购详情
            holder.no_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if (datas.get(position).getOrderNature() == 0) {
                        //                        爆款的 的 云享优汇的
                        Intent intent = new Intent(context, ActTodetails.class);
                        intent.putExtra("Nature", datas.get(position).getOrderNature());
                        bean_shop = MyApp.gson.fromJson(datas.get(position).getOrderDetail(), Bean_shop.class);
                        intent.putExtra("orderId", datas.get(position).getOrderNum());
                        intent.putExtra("order_number", datas.get(position).getOrderNum());
                        context.startActivity(intent);
                    } else {
                        List<BeanShequ.OrderDetailListBean> orderDetailList = new ArrayList<>();
                        orderDetailList.clear();
                        beanShequ = MyApp.gson.fromJson(datas.get(position).getOrderDetail(), BeanShequ.class);
                        orderDetailList = beanShequ.getOrderDetailList();
                        Intent intent_noused = new Intent(context, ActBusDistribution.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("orderDetailList", (Serializable) orderDetailList);
                        intent_noused.putExtras(bundle);
                        intent_noused.putExtra("Nature", 1);
                        if (datas.get(position).getReceiveWay() == 1) {
                            intent_noused.putExtra("ReceiveWay", "到商家取");
                        } else if (datas.get(position).getReceiveWay() == 2) {
                            intent_noused.putExtra("ReceiveWay", "到社区取");
                        } else if (datas.get(position).getReceiveWay() == 3) {
                            intent_noused.putExtra("ReceiveWay", "商家送货");
                        } else if (datas.get(position).getReceiveWay() == 4) {
                            intent_noused.putExtra("ReceiveWay", "社区送货");
                        }
//                      intent_noused.putExtra("orderId",datas.get(position).getOrderId());
                        bean_shop = MyApp.gson.fromJson(datas.get(position).getOrderDetail(), Bean_shop.class);
                        intent_noused.putExtra("order_number", datas.get(position).getOrderNum());
                        intent_noused.putExtra("text_price_all", holder.text_price_all.getText().toString());
                        context.startActivity(intent_noused);
                    }
                }
            });
            holder.lin_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MyApp.order_ty = 1;
                    if (datas.get(position).getOrderNature() == 0) {
                        //                        爆款的 的 云享优汇的
                        Intent intent = new Intent(context, ActTodetails.class);
                        intent.putExtra("Nature", datas.get(position).getOrderNature());
                        bean_shop = MyApp.gson.fromJson(datas.get(position).getOrderDetail(), Bean_shop.class);
                        intent.putExtra("orderId", datas.get(position).getOrderNum());
                        intent.putExtra("order_number", datas.get(position).getOrderNum());
                        context.startActivity(intent);
                    } else {
                        List<BeanShequ.OrderDetailListBean> orderDetailList = new ArrayList<>();
                        orderDetailList.clear();
                        beanShequ = MyApp.gson.fromJson(datas.get(position).getOrderDetail(), BeanShequ.class);
                        orderDetailList = beanShequ.getOrderDetailList();
                        Intent intent_noused = new Intent(context, ActBusDistribution.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("orderDetailList", (Serializable) orderDetailList);
                        intent_noused.putExtras(bundle);
                        intent_noused.putExtra("Nature", 1);
                        if (datas.get(position).getReceiveWay() == 1) {
                            intent_noused.putExtra("ReceiveWay", "到商家取");
                        } else if (datas.get(position).getReceiveWay() == 2) {
                            intent_noused.putExtra("ReceiveWay", "到社区取");
                        } else if (datas.get(position).getReceiveWay() == 3) {
                            intent_noused.putExtra("ReceiveWay", "商家送货");
                        } else if (datas.get(position).getReceiveWay() == 4) {
                            intent_noused.putExtra("ReceiveWay", "社区送货");
                        }
//                      intent_noused.putExtra("orderId",datas.get(position).getOrderId());
                        bean_shop = MyApp.gson.fromJson(datas.get(position).getOrderDetail(), Bean_shop.class);
                        intent_noused.putExtra("order_number", datas.get(position).getOrderNum());
                        intent_noused.putExtra("text_price_all", holder.text_price_all.getText().toString());
                        context.startActivity(intent_noused);
                    }
                }
            });
//          代付款到付款界面
//            holder.lin_payment.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    try {
//                        MyApp.order_ty = 2;
////                        Bean_usedetail bean_usedetail;
//
////                        List<Bean_usedetail.ChannelUserVoListBean> channelUserVoList;
////
//                        Intent intent = new Intent(context, ActDeterOrder.class);
////
////                        intent.putExtra("type",1);
////
////                        intent.putExtra("text_title",holder.text_title.getText().toString());
////
////                        intent.putExtra("log_url",bean_de.getLogoUrl()+"");
////
////                        intent.putExtra("text_context",holder.text_details.getText().toString());
////
////                        intent.putExtra("text_price",holder.text_price.getText().toString());
////
////                        intent.putExtra("text_size",holder.text_boom_size.getText().toString());
////
////                        intent.putExtra("text_boom_price",holder.text_price_all.getText().toString());
////
////                        String userdetail = datas.get(position).getUserDetail();
////
////                        bean_usedetail = MyApp.gson.fromJson(userdetail, Bean_usedetail.class);
////
////                        channelUserVoList = bean_usedetail.getChannelUserVoList();
////                        intent.putExtra("text_phone",channelUserVoList.get(0).getPhone());
////
////                        intent.putExtra("order_number",datas.get(position).getOrderNumber());
////                        intent.putExtra("order_id", datas.get(position).getId());
////                        context.startActivity(intent);
//
//                    } catch (Exception e) {
//
//                    }
//
//                }
//            });
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private LinearLayout lin_details;

            private LinearLayout lin_payment;

            private TextView text_title;

            private ImageView img_shop;

            private TextView text_details;

            private TextView text_price;

            private TextView text_size;

            private TextView text_boom_size;

            private TextView text_price_all;

            private NoScrollListView no_list;

            private LinearLayout lin_item;




            public ViewHolder(View itemView) {
                super(itemView);
                lin_details = (LinearLayout) itemView.findViewById(R.id.lin_details);
                lin_payment = (LinearLayout) itemView.findViewById(R.id.lin_payment);
                text_title = (TextView) itemView.findViewById(R.id.text_title);
                img_shop = (ImageView) itemView.findViewById(R.id.img_shop);
                text_details = (TextView) itemView.findViewById(R.id.text_details);
                text_price = (TextView) itemView.findViewById(R.id.text_price);
                text_size = (TextView) itemView.findViewById(R.id.text_size);
                text_boom_size = (TextView) itemView.findViewById(R.id.text_boom_size);
                text_price_all = (TextView) itemView.findViewById(R.id.text_price_all);
                no_list = (NoScrollListView) itemView.findViewById(R.id.no_list);


                lin_item = (LinearLayout) itemView.findViewById(R.id.lin_item);


            }
        }
    }


    private Bean_shop bean_shop;

    private BeanShequ beanShequ;

    private String logoUrl;

    //多个 列表
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

//            if (convertView == null) {
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
//            } else {
//                myViewHoder = (MyViewHoder) convertView.getTag();
//            }

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
