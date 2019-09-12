package com.example.YunleHui.ui.act.actme.actorder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
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
import com.example.YunleHui.Bean.Bean_pur;
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
 * 社区购未支付订单详情
 */

public class ActComPurUsed extends BaseAct {


    @BindView(R.id.text_fangshi)
    TextView text_fangshi;


    @BindView(R.id.lin_ziTi)
    LinearLayout lin_ziTi;

    @BindView(R.id.lin_peisong)
    LinearLayout lin_peisong;


    @BindView(R.id.textprice)
    TextView textprice;


    @BindView(R.id.text_order_id)
    TextView text_order_id;


//    商品列表

    @BindView(R.id.list_detail)
    NoScrollListView list_detail;
    @BindView(R.id.img_erweima)
    ImageView imgErweima;

    @BindView(R.id.text_name_)
    TextView textName;
    @BindView(R.id.lin_use)
    LinearLayout linUse;
    @BindView(R.id.lin_tuikuan)
    LinearLayout linTuikuan;
    @BindView(R.id.text_address)
    TextView textAddress;
    @BindView(R.id.text_phone)
    TextView textPhone;
    @BindView(R.id.text_time)
    TextView textTime;
    @BindView(R.id.text_beizhu)
    TextView textBeizhu;
    @BindView(R.id.text_Nickname)
    TextView textNickname;
    @BindView(R.id.text_usePhone)
    TextView textUsePhone;
    @BindView(R.id.text_userAddress)
    TextView textUserAddress;
    @BindView(R.id.text_order_nu)
    TextView textOrderNu;
    @BindView(R.id.text_creat_time)
    TextView textCreatTime;
    @BindView(R.id.text_pay_time)
    TextView textPayTime;
    @BindView(R.id.text_payWay)
    TextView textPayWay;


    //    配送方式文在
    private String fang_shi = "";

//    配送的状态判断

    private int ReceiveWay = 0;


//    订单

    private String order_number = "";

    private int Nature = 0;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @BindView(R.id.name_Pei)
    TextView name_Pei;

    @BindView(R.id.Tel_Pei)
    TextView Tel_Pei;

    @BindView(R.id.fang_shi_Pei)
    TextView fang_shi_Pei;

    @BindView(R.id.shouTime_Pei)
    TextView shouTime_Pei;

    @BindView(R.id.Bei_pei)
    TextView Bei_pei;

    @BindView(R.id.number_pei)
    TextView number_pei;

    @BindView(R.id.creat_pei)
    TextView creat_pei;

    @BindView(R.id.pay_time)
    TextView pay_time;

    @BindView(R.id.pay_way)
    TextView pay_way;

    @BindView(R.id.address_pei)
    TextView address_pei;

    @BindView(R.id.BussTel_Pei)
    TextView BussTel_Pei;


    private int state_order = 0;


    @BindView(R.id.text_kk)
    TextView text_kk;


    @BindView(R.id.text_aa)
    TextView text_aa;




    @BindView(R.id.lin_comple)
    LinearLayout lin_comple;

    @BindView(R.id.lin_kfkjg)
    LinearLayout lin_kfkjg;



    @BindView(R.id.lin_Another_order)
LinearLayout lin_Another_order;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_com_pur_used;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            TextView text_center = toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("订单详情");
        }


    }


    @Override
    public void initData() {

        Intent intent = getIntent();
        ReceiveWay = intent.getIntExtra("ReceiveWay", 0);
        order_number = intent.getStringExtra("order_number");
        Nature = intent.getIntExtra("Nature", 0);
        state_order = intent.getIntExtra("state_order", 0);

        if (state_order == 1) {
            lin_comple.setVisibility(View.VISIBLE);
            lin_kfkjg.setVisibility(View.GONE);
            linUse.setVisibility(View.GONE);
            }

        if (ReceiveWay == 1) {
//            intent.putExtra("fang_shi","到商家取");

            lin_ziTi.setVisibility(View.VISIBLE);
            lin_peisong.setVisibility(View.GONE);

            text_fangshi.setText("到商家取");

            fang_shi_Pei.setText("到商家取");


        } else if (ReceiveWay == 2) {
//            intent.putExtra("fang_shi","到社区取");

            lin_ziTi.setVisibility(View.VISIBLE);
            lin_peisong.setVisibility(View.GONE);

            text_fangshi.setText("到社区取");
            fang_shi_Pei.setText("到社区取");

        } else if (ReceiveWay == 3) {
//            intent.putExtra("fang_shi","商家送货");

            lin_ziTi.setVisibility(View.GONE);
            lin_peisong.setVisibility(View.VISIBLE);
            text_fangshi.setText("商家送货");
            fang_shi_Pei.setText("商家送货");

        } else if (ReceiveWay == 4) {
//            intent.putExtra("fang_shi","社区送货");


            lin_ziTi.setVisibility(View.GONE);
            lin_peisong.setVisibility(View.VISIBLE);
            text_fangshi.setText("社区送货");
            fang_shi_Pei.setText("社区送货");

        }

        Log.i("order_number",order_number+"--"+intent.getStringExtra("order_number"));
        HttpUtil.addMapparams();
        HttpUtil.params.put("orderNum", intent.getStringExtra("order_number")+"");
        HttpUtil.params.put("orderNature", Nature);
        HttpUtil.Post_request("orderFull/details", HttpUtil.params);
        getdata("orderFull/details");


        list_detail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ActComPurUsed.this, Actfund.class);
//              intent.putExtra("text_name", text_Name.getText().toString());
//                intent.putExtra("log_img", bean_de.getLogoUrl());
//                intent.putExtra("text_context", textContext.getText().toString());
//                intent.putExtra("text_price", textPrice.getText().toString());
//                intent.putExtra("size", textSize.getText().toString());
//                intent.putExtra("text_price_all", textPriceAll.getText().toString());
//                intent.putExtra("order_id", order_number);
                startActivity(intent);
            }
        });


        linTuikuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActComPurUsed.this, Actfund.class);
//              intent.putExtra("text_name", text_Name.getText().toString());
//                intent.putExtra("log_img", bean_de.getLogoUrl());
//                intent.putExtra("text_context", textContext.getText().toString());
//                intent.putExtra("text_price", textPrice.getText().toString());
//                intent.putExtra("size", textSize.getText().toString());
//                intent.putExtra("text_price_all", textPriceAll.getText().toString());
//                intent.putExtra("order_id", order_number);
                startActivity(intent);
            }
        });




        lin_Another_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActComPurUsed.this,"ksdjfj",Toast.LENGTH_SHORT).show();
            }
        });



    }


    private Bean_pur bean_pur;
    private boolean success;
    private int code;
    private String msg;
    private Bean_pur.DataBean data;


    private List<Bean_pur.DataBean.OrderDetailListBean> orderDetailList;


    @Override
    public void StringResulit(String key, String value) {
        if (key.equals("orderFull/details")) {

            bean_pur = MyApp.gson.fromJson(value, Bean_pur.class);

            data = bean_pur.getData();

            Glide.with(this).load(MyApp.PUBLIC_URL + "order/generateQrCode?secret=" + data.getReceiveCode()).into(imgErweima);

            textprice.setText(data.getTotalMoney() * 0.01 + "");

            text_order_id.setText(data.getOrderNum() + "");

            orderDetailList = data.getOrderDetailList();

            myBaseApter = new MyBaseApter(orderDetailList, ActComPurUsed.this);

            list_detail.setAdapter(myBaseApter);

            textAddress.setText(data.getShopInfo().getShopAddress());

            textPhone.setText(data.getShopInfo().getShopTel());

            textTime.setText(data.getDeliveryTime());

            textBeizhu.setText(data.getRemark());

            textNickname.setText(data.getCustomerName());
            textUsePhone.setText(data.getCustomerTel());

            textUserAddress.setText(data.getReceiveAddress());

            textOrderNu.setText(data.getOrderNum() + "");

            textCreatTime.setText(Tools.stampToDate("" + data.getCreateTime()));

            textPayTime.setText(data.getPayTime() + "");

            if (data.getPayWay() == 0) {
                textPayWay.setText("支付宝");
            } else if (data.getPayWay() == 1) {
                textPayWay.setText("余额");
            } else if (data.getPayWay() == 2) {
                textPayWay.setText("微信");
            }

//            商家配送

            name_Pei.setText(data.getCustomerName());

            Tel_Pei.setText(data.getCustomerTel());

            shouTime_Pei.setText(data.getDeliveryTime());

            Bei_pei.setText(data.getRemark());

            number_pei.setText(data.getOrderNum());

            creat_pei.setText(Tools.stampToDate(data.getCreateTime() + ""));

            pay_time.setText(data.getPayTime() + "");


            if (data.getPayWay() == 0) {
                pay_way.setText("支付宝");
            } else if (data.getPayWay() == 1) {
                pay_way.setText("余额");
            } else if (data.getPayWay() == 2) {
                pay_way.setText("微信");
            }

            address_pei.setText(data.getShopInfo().getShopAddress());

            BussTel_Pei.setText(data.getShopInfo().getShopTel());
        }
    }


    MyBaseApter myBaseApter;


    public class MyBaseApter extends BaseAdapter {


        private ArrayList<Bean_pur.DataBean.OrderDetailListBean> datas = new ArrayList<>();

        private LayoutInflater inflater;

        public MyBaseApter(List<Bean_pur.DataBean.OrderDetailListBean> datas, Context context) {
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

            MyViewHoldr myViewHoldr = null;

            if (convertView == null) {
                myViewHoldr = new MyViewHoldr();
                convertView = inflater.inflate(R.layout.item_order_shequ, parent, false);

                myViewHoldr.text_name = (TextView) convertView.findViewById(R.id.text_name);
                myViewHoldr.text_price = (TextView) convertView.findViewById(R.id.text_price);
                myViewHoldr.text_size = (TextView) convertView.findViewById(R.id.text_size);


                convertView.setTag(myViewHoldr);
            } else {
                myViewHoldr = (MyViewHoldr) convertView.getTag();
            }


            myViewHoldr.text_name.setText(datas.get(position).getGoodsName());
            myViewHoldr.text_size.setText(datas.get(position).getNum() + "");
            myViewHoldr.text_price.setText(datas.get(position).getPrice() * 0.01 + "");


            return convertView;
        }


        public class MyViewHoldr {

            private TextView text_name;
            private TextView text_price;
            private TextView text_size;
        }


    }


}
