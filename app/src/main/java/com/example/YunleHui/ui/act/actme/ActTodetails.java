package com.example.YunleHui.ui.act.actme;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.Bean_dai;
import com.example.YunleHui.Bean.Bean_de;
import com.example.YunleHui.Bean.Bean_detailas;
import com.example.YunleHui.Bean.Bean_shop;
import com.example.YunleHui.Bean.Bean_sjs;
import com.example.YunleHui.Bean.Bean_uesrDetail;
import com.example.YunleHui.Bean.Bean_usedetail;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.acthome.ActComdetails;
import com.example.YunleHui.ui.act.acthome.ActDeterOrder;
import com.example.YunleHui.ui.act.acthome.ActPayOrder;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.NoScrollListView;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 待支付详情
 */

public class ActTodetails extends BaseAct {


    private MyAdapter myAdapter;


//用户详情

    private Bean_uesrDetail bean_uesrDetail;
    private String address;
    private String avatarUrl;
    private String city;
    private int cityId;
    private String country;
    private Bean_uesrDetail.CreateTimeBean createTime;
    private int gender;
    private int id;
    private String language;
    private int latitude;
    private int longitude;
    private String nickName;
    private String phone;
    private String province;
    private String realName;
    private String remark;
    private int state;
    private Bean_uesrDetail.UserChannelVoBean userChannelVo;


    @BindView(R.id.nolist)
    NoScrollListView nolist;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    @BindView(R.id.text_pay)
    TextView text_pay;


    //    订单id
    private int orderId = 0;

    private String orderNumber = "";

    private String title;
    private String log_url;
    private String content;
    private int price;
    private int size;


    @BindView(R.id.text_title)
    TextView text_title;

    @BindView(R.id.img_shop)
    ImageView img_shop;

    @BindView(R.id.text_context)
    TextView text_context;

    @BindView(R.id.text_price)
    TextView text_price;

    @BindView(R.id.text_size)
    TextView text_size;

    @BindView(R.id.text_boom_price)
    TextView text_boom_price;

    @BindView(R.id.text_name)
    TextView text_name;

    @BindView(R.id.text_phone)
    TextView text_phone;

    @BindView(R.id.text_order_size)
    TextView text_order_size;

    @BindView(R.id.text_order_all)
    TextView text_order_all;

    @BindView(R.id.text_order_number)
    TextView text_order_number;


    @BindView(R.id.text_order_time)
    TextView text_order_time;

    //下单的用户的详情
    private String userdetail;

    @BindView(R.id.text_pay_shi)
    TextView text_pay_shi;

    //订单详情的数据
    private Bean_sjs bean_sjs;
    private boolean success_sjs;
    private int code_sjs;
    private String msg_sjs;
    private Bean_sjs.DataBean data_sjs;


    //指定门店列表
    private List<Bean_sjs.DataBean.VerificationShopListBean> verificationShopList;



    public static ActTodetails actTodetails;




    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_todetails;
    }

    @Override
    protected void findViews() {

        if (toolbar_all != null) {
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("订单详情");
        }

    }


    private int Nature = 0;

    private String order_number = "";


    @Override
    public void initData() {


        actTodetails = this;


        Intent intent = getIntent();

        orderId = intent.getIntExtra("orderId", 0);


        Nature = intent.getIntExtra("Nature", 0);
        order_number = intent.getStringExtra("order_number");

        Log.i("Nature", Nature + "---" + orderId);

        HttpUtil.addMapparams();
        HttpUtil.params.put("orderNum", order_number);
        HttpUtil.params.put("orderNature", Nature);
        HttpUtil.Post_request("orderFull/details", HttpUtil.params);
        getdata("orderFull/details");
    }


    private Bean_shop bean_shop;


    @Override
    public void StringResulit(String key, String value) {

        try {
            if (key.equals("orderFull/details")) {

                bean_sjs = MyApp.gson.fromJson(value, Bean_sjs.class);
                data_sjs = bean_sjs.getData();
                text_title.setText(data_sjs.getShopName());
                log_url = data_sjs.getLogoUrl();
                Glide.with(ActTodetails.this).load(data_sjs.getLogoUrl()).into(img_shop);
                text_context.setText(data_sjs.getGoodsName());
                text_price.setText(data_sjs.getTotalMoney() / data_sjs.getCount() * 0.01 + "");
                text_size.setText(data_sjs.getCount() + "");
                text_boom_price.setText(Tools.chenfa(data_sjs.getTotalMoney()) + "");
                text_order_size.setText(data_sjs.getCount() + "");
                text_order_all.setText(Tools.chenfa(data_sjs.getTotalMoney()) + "");
                text_pay_shi.setText(Tools.chenfa(data_sjs.getTotalMoney()) + "");
                text_order_number.setText(data_sjs.getOrderNumber());
                text_order_time.setText(data_sjs.getPayTime());
                bean_uesrDetail = MyApp.gson.fromJson(data_sjs.getUserDetail(), Bean_uesrDetail.class);
                text_name.setText(bean_uesrDetail.getNickName());
                text_phone.setText(bean_uesrDetail.getPhone());
                verificationShopList = data_sjs.getVerificationShopList();
                myAdapter = new MyAdapter(verificationShopList, ActTodetails.this);
                nolist.setAdapter(myAdapter);
            }
        } catch (Exception e) {

        }

    }

    @OnClick({R.id.text_pay})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.text_pay:
                Intent intent = new Intent(this, ActPayOrder.class);
                intent.putExtra("OrderNumber", order_number);
                intent.putExtra("price", text_boom_price.getText().toString());
                intent.putExtra("typeNo",2);
                intent.putExtra("orderNature",0);
                intent.putExtra("shop_name",text_title.getText().toString());
                startActivity(intent);
                break;
        }
    }

    public class MyAdapter extends BaseAdapter {

        ArrayList<Bean_sjs.DataBean.VerificationShopListBean> datas = new ArrayList<>();
        private LayoutInflater inflater;
        public MyAdapter(List<Bean_sjs.DataBean.VerificationShopListBean> datas, Context context) {
            this.inflater = LayoutInflater.from(context);
            this.datas.clear();
            this.datas.addAll(datas);
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
            MyViewHolder myViewHolder = new MyViewHolder();
            convertView = inflater.inflate(R.layout.item_shopp, parent, false);
            myViewHolder.text_address = (TextView) convertView.findViewById(R.id.text_address);
            myViewHolder.img_phone = (ImageView) convertView.findViewById(R.id.img_phone);
            myViewHolder.text_address.setText(datas.get(position).getShopName());
            myViewHolder.lin_call = (LinearLayout) convertView.findViewById(R.id.lin_call);
            myViewHolder.img_phone.setVisibility(View.GONE);
            myViewHolder.lin_call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Intent intent = new Intent(Intent.ACTION_DIAL);
//                    Uri data = Uri.parse("tel:" + datas.get(position).get());
//                    intent.setData(data);
//                    startActivity(intent);
                }
            });
            return convertView;
        }

        public class MyViewHolder {
            private TextView text_address;
            private LinearLayout lin_call;
            private ImageView img_phone;
            private ImageView img_dingwei;
        }
    }
}
