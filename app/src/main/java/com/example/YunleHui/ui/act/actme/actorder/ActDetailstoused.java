package com.example.YunleHui.ui.act.actme.actorder;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.Bean_no_use;
import com.example.YunleHui.Bean.Bean_order_deatil;
import com.example.YunleHui.Bean.Bean_usedetail;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.NoScrollListView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;


/**
 * 爆款订单详情
 */

public class ActDetailstoused extends BaseAct {

    @BindView(R.id.lin_comple)
    LinearLayout lin_comple;

    @BindView(R.id.lin_Another_order)
    LinearLayout lin_Another_order;


    @BindView(R.id.lin_kfkjg)
    LinearLayout lin_kfkjg;


    @BindView(R.id.text_order_state)
    TextView text_order_state;

    @BindView(R.id.text_mm)
    TextView text_mm;

    @BindView(R.id.no_list)
    NoScrollListView no_list;


    private Bean_order_deatil bean_order_deatil;
    private boolean success;
    private int code;
    private String msg;
    private Bean_order_deatil.DataBean data;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @BindView(R.id.lin_tuikuan)
    LinearLayout lin_tuikuan;

    @BindView(R.id.text_price)
    TextView text_Price;


    @BindView(R.id.img_erweima)
    ImageView imgErweima;


    //    核销码，不是订单号
    @BindView(R.id.text_order_id)
    TextView textOrderId;
    @BindView(R.id.text_name_)
    TextView text_name_;


    @BindView(R.id.imgShopImg)
    ImageView imgShopImg;
    @BindView(R.id.text_context)
    TextView textContext;

    @BindView(R.id.textprice)
    TextView textPrice;
    @BindView(R.id.lin_use)
    LinearLayout linUse;

    @BindView(R.id.text_phone)
    TextView textPhone;
    @BindView(R.id.text_size_)
    TextView text_size_;
    @BindView(R.id.text_price_all_)
    TextView textPriceAll;
    @BindView(R.id.text_price_all_shi)
    TextView textPriceAllShi;
    @BindView(R.id.text_order_nu)
    TextView textOrderNu;
    @BindView(R.id.text_creat_time)
    TextView textCreatTime;
    @BindView(R.id.text_pay)
    TextView textPay;
    @BindView(R.id.text_payWay)
    TextView textPayWay;


    @BindView(R.id.text_beizhu)
    TextView text_beizhu;


    private String order_id = "";

    private ArrayList<Bean_no_use.DataBean.VoListBean> datas = new ArrayList<>();


//    已使用 的 时候

    private int yishiyong = 0;

    private TextView text_center;


    private int ReceiveWay = 0;


    private String fang_shi = "";

    //    订单状态
    private int state_order = 0;


    public static ActDetailstoused actDetailstoused;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_detailstoused;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("订单详情");
        }
    }


    private int Nature = 0;
    private String order_number;


    @Override
    public void initData() {




        actDetailstoused = this;




        Intent intent = getIntent();
//        datas = (ArrayList<Bean_no_use.DataBean.VoListBean>) intent.getSerializableExtra("serinfo");
        order_id = intent.getStringExtra("order_id");
//配送方式
        ReceiveWay = intent.getIntExtra("ReceiveWay", 0);
        fang_shi = intent.getStringExtra("fang_shi");
        yishiyong = intent.getIntExtra("yishiyong", 0);
        Nature = intent.getIntExtra("Nature", 0);
        order_number = intent.getStringExtra("order_number");


//      订单已使用 的 状态

        state_order = intent.getIntExtra("state_order", 0);

        if (state_order == 1) {
//            text_order_state.setText("订单已完成");
//            text_mm.setText("再来一单");
            lin_comple.setVisibility(View.VISIBLE);
            lin_kfkjg.setVisibility(View.GONE);
            linUse.setVisibility(View.GONE);

        }

        HttpUtil.addMapparams();
        HttpUtil.params.put("orderNum", order_number);
        HttpUtil.params.put("orderNature", Nature);
        HttpUtil.Post_request("orderFull/details", HttpUtil.params);
        getdata("orderFull/details");

        if (yishiyong == 1) {
            yishiyong = 0;
            text_center.setText("交易完成");
            lin_tuikuan.setClickable(false);
            linUse.setVisibility(View.GONE);
        }


        lin_Another_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActDetailstoused.this, "再来一单吧", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @OnClick({R.id.lin_tuikuan})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lin_tuikuan:
                if (state_order == 0) {
                    Intent intent = new Intent(this, Actfund.class);
//              intent.putExtra("text_name", text_Name.getText().toString());
                    intent.putExtra("log_img", bean_order_deatil.getData().getLogoUrl());
                    intent.putExtra("text_context", textContext.getText().toString());
                    intent.putExtra("text_price", textPrice.getText().toString());
                    intent.putExtra("size", textSize.getText().toString());
                    intent.putExtra("text_price_all", textPriceAll.getText().toString());
                    intent.putExtra("text_name",text_name_.getText().toString());
                    intent.putExtra("orderNature",0);
                    intent.putExtra("order_id",order_number);
                    startActivity(intent);
                } else {
//                    Intent intent = new Intent(this, ActComdetails.class);
//                    MyApp.order_ty = 0;
//                    intent.putExtra("shop_id", datas.get(position).getId());
//                    startActivity(intent);
                    Toast.makeText(this, "暂未使用！！！", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    @BindView(R.id.textSize)
    TextView textSize;

    @Override
    public void stringResulit(final String key, final String Value) {


        try {
            if (key.equals("orderFull/details")) {

                bean_order_deatil = MyApp.gson.fromJson(Value, Bean_order_deatil.class);
                data = bean_order_deatil.getData();
                textPrice.setText(Tools.chenfa(data.getPayMoney()) + "元");
                textOrderId.setText(data.getOrderVerificationCode());

//                bean_de = MyApp.gson.fromJson(data.getShopDetail(), Bean_de.class);

                Glide.with(this).load(bean_order_deatil.getData().getLogoUrl()).into(imgShopImg);

                Glide.with(this).load(MyApp.PUBLIC_URL + "order/generateQrCode?secret=" + data.getOrderVerificationCode()).into(imgErweima);

                text_name_.setText(data.getShopName());

                text_beizhu.setText(data.getRemark());

                textContext.setText(data.getGoodsName());
                text_Price.setText(data.getPayMoney() / data.getCount() * 0.01 + "");
                textSize.setText(data.getCount() + "");
                textPriceAll.setText(data.getPayMoney() * 0.01 + "");
                text_size_.setText(data.getCount() + "");

                textPriceAllShi.setText(data.getPayMoney() * 0.01 + "");
                textOrderNu.setText(data.getPayMoney() * 0.01 + "");
                textCreatTime.setText(data.getCreateTime() + "");

//                生效时间
                textPay.setText(data.getEffectiveDate() + "");

                textPayWay.setText(Tools.payWay(data.getPayWay()));
                Bean_usedetail bean_usedetail;

                bean_usedetail = MyApp.gson.fromJson(data.getUserDetail(), Bean_usedetail.class);

                textPhone.setText(bean_usedetail.getPhone() + "");


                verificationShopList = data.getVerificationShopList();

                myAdapter = new MyAdapter(verificationShopList, ActDetailstoused.this);

                no_list.setAdapter(myAdapter);


            }
        } catch (Exception e) {

        }

        try {
            if (key.equals("order/generateQrCode")) {

            }
        } catch (Exception e) {

        }


    }


    private void getAsynHttp(String url) {
        Request.Builder requestBuilder = new Request.Builder().url(MyApp.PUBLIC_URL + url).addHeader("Authorization", "Bearer " + MyApp.access_token);
        //可以省略，默认是GET请求
        requestBuilder.method("GET", null);
        Request request = requestBuilder.build();
        Call mcall = MyApp.mOkHttpClient.newCall(request);
        mcall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
//                if (null != response.cacheResponse()) {
//                    String str = response.cacheResponse().toString();
//                    Log.i("wangshu", "cache---" + str);
//                } else {
//                    response.body().string();
//                    String str = response.networkResponse().toString();
//                    Log.i("wangshu", "network---" + str);
//                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String asdas = null;
                        try {
                            asdas = response.body().string();
                            //                        String str = response.cacheResponse().toString();
                            Log.i("response", "cache---" + asdas);
                            Toast.makeText(getApplicationContext(), "请求成功", Toast.LENGTH_SHORT).show();
                            byte[] decodedString = Base64.decode(asdas, Base64.DEFAULT);
                            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                            imgErweima.setImageBitmap(decodedByte);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }


    //指定门店列表
    private List<Bean_order_deatil.DataBean.VerificationShopListBean> verificationShopList;


    private MyAdapter myAdapter;

    public class MyAdapter extends BaseAdapter {

        ArrayList<Bean_order_deatil.DataBean.VerificationShopListBean> datas = new ArrayList<>();
        private LayoutInflater inflater;

        public MyAdapter(List<Bean_order_deatil.DataBean.VerificationShopListBean> datas, Context context) {

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

            MyViewHolder myViewHolder = new MyAdapter.MyViewHolder();

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
