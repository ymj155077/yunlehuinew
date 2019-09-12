package com.example.YunleHui.ui.act.actme.actbusiness;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.YunleHui.Bean.BeanShequ;
import com.example.YunleHui.Bean.Bean_day;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.NoScrollListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 社区购商家配送未支付订单
 */

public class ActBusDistribution extends BaseAct {

    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.text_phone)
    TextView textPhone;
    @BindView(R.id.text_address)
    TextView textAddress;
    @BindView(R.id.text_soutime)
    TextView textSoutime;
    @BindView(R.id.text_tiTime)
    TextView textTiTime;
    @BindView(R.id.text_beizhu)
    TextView textBeizhu;
    @BindView(R.id.text_num)
    TextView textNum;
    @BindView(R.id.text_xia_time)
    TextView textXiaTime;
    @BindView(R.id.text_payWay)
    TextView textPayWay;
    @BindView(R.id.lin_place)
    LinearLayout linPlace;
    //    送货方式
    private String ReceiveWay;


    @BindView(R.id.no_list)
    NoScrollListView no_list;


    @BindView(R.id.text_priceAll)
TextView text_priceAll;

    private List<BeanShequ.OrderDetailListBean> orderDetailList = new ArrayList<>();

    //    订单hao
    private String order_number = "";


    private int Nature;


    //订单
    private Bean_day bean_day;
    private boolean success;
    private int code;
    private String msg;
    private Bean_day.DataBean data;

    private List<Bean_day.DataBean.OrderDetailListBean> orderDetailLists;


    private String text_price_all;

    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_bus_distribution;
    }

    @Override
    protected void findViews() {

        if (toolbar_all!=null){
            TextView text_center = toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("未支付订单");
        }

    }

    @Override
    public void initData() {
        orderDetailList.clear();
        Intent intent = getIntent();


        text_price_all = intent.getStringExtra("text_price_all");


        ReceiveWay = intent.getStringExtra("ReceiveWay");
//获得Serializable方式传过来的值
        orderDetailList = (List<BeanShequ.OrderDetailListBean>) intent.getSerializableExtra("orderDetailList");
        order_number = intent.getStringExtra("order_number");
        Nature = intent.getIntExtra("Nature", 0);
        myListAdapter = new MyListAdapter(orderDetailList, this);
        no_list.setAdapter(myListAdapter);

        HttpUtil.addMapparams();
        HttpUtil.params.put("orderNum", order_number);
        HttpUtil.params.put("orderNature", Nature);
        HttpUtil.Post_request("orderFull/details", HttpUtil.params);
        getdata("orderFull/details");
    }


    private MyListAdapter myListAdapter;

    public class MyListAdapter extends BaseAdapter {

        public List<BeanShequ.OrderDetailListBean> datas = new ArrayList<>();

        private LayoutInflater inflater;

        public MyListAdapter(List<BeanShequ.OrderDetailListBean> datas, Context context) {
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
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            MyVeiwHolder myVeiwHolder = null;
            if (convertView == null) {
                myVeiwHolder = new MyVeiwHolder();
                convertView = inflater.inflate(R.layout.item_order_shequ, parent, false);
                myVeiwHolder.text_price = (TextView) convertView.findViewById(R.id.text_price);
                myVeiwHolder.text_size = (TextView) convertView.findViewById(R.id.text_size);
                myVeiwHolder.text_name = (TextView) convertView.findViewById(R.id.text_name);
                convertView.setTag(myVeiwHolder);
            } else {
                myVeiwHolder = (MyVeiwHolder) convertView.getTag();
            }
            myVeiwHolder.text_price.setText(datas.get(position).getPrice() / datas.get(position).getNum() * 0.01 + "");
            myVeiwHolder.text_name.setText(datas.get(position).getGoodsName());
            myVeiwHolder.text_size.setText(datas.get(position).getNum() + "");
            return convertView;
        }

        public class MyVeiwHolder {
            private TextView text_price;
            private TextView text_size;
            private TextView text_name;
        }
    }

    @Override
    public void StringResulit(String key, String value) {


        if (key.equals("orderFull/details")) {

//            private Bean_day bean_day;
//            private boolean success;
//            private int code;
//            private String msg;
//            private Bean_day.DataBean data;
//            private List<Bean_day.DataBean.OrderDetailListBean> orderDetailLists;
            bean_day = MyApp.gson.fromJson(value, Bean_day.class);
            data = bean_day.getData();
            textName.setText(data.getCustomerName());
            textPhone.setText(data.getCustomerTel());
            textAddress.setText(data.getReceiveAddress());
            textSoutime.setText(data.getDeliveryTime());
            textTiTime.setText(ReceiveWay);
            try {
                textBeizhu.setText(data.getRemark());
            } catch (Exception e) {

            }
            textNum.setText(data.getOrderNum());
            String dataa = Tools.stampToDate(data.getPayTime() + "");
            textXiaTime.setText(dataa);
            if (data.getPayWay() == 0) {
                textPayWay.setText("支付宝");
            } else if (data.getPayWay() == 1) {
                textPayWay.setText("余额");
            } else if (data.getPayWay() == 2) {
                textPayWay.setText("微信");
            }

            text_priceAll.setText(text_price_all);

        }
    }
}
