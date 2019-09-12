package com.example.YunleHui.ui.act.actme.actorder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.Bean_Term;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.HttpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 申请退款
 */


public class Actfund extends BaseAct {





    private Bean_Term bean_term;
    private boolean success;
    private int code;
    private String msg;
    private Object data;







    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @BindView(R.id.text_Submission)
    TextView text_Submission;
    @BindView(R.id.shop_name)
    TextView shopName;
    @BindView(R.id.img_goods)
    ImageView imgGoods;
    @BindView(R.id.text_context)
    TextView textContext;



    @BindView(R.id.text_size)
    TextView textSize;




    @BindView(R.id.text_price_all)
    TextView textPriceAll;
    @BindView(R.id.text_price)
    TextView textPrice;




    @BindView(R.id.lin_tuikuan)
    LinearLayout linTuikuan;
    @BindView(R.id.edit_context)
    EditText editContext;


    @BindView(R.id.text_jddj)
TextView text_jddj;

    private int order_id;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_actfund;
    }

    @Override
    protected void findViews() {

        if (toolbar_all != null) {
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("申请退款");
        }

    }

    @Override
    public void initData() {


        Intent intent = getIntent();


       String text_name = intent.getStringExtra("text_name");

        shopName.setText(text_name);

       String log_img = intent.getStringExtra("log_img");

        Glide.with(this).load(log_img).into(imgGoods);

       String text_context = intent.getStringExtra("text_context");

        textContext.setText(text_context);


       String text_price = intent.getStringExtra("text_price");


        textPrice.setText(text_price);

       String size = intent.getStringExtra("size");


        textSize.setText(size);

       String text_price_all = intent.getStringExtra("text_price_all");

        textPriceAll.setText(text_price_all);

        text_jddj.setText(text_price_all);

        order_id = intent.getIntExtra("order_id", 0);


    }


    @OnClick({R.id.text_Submission})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_Submission:

                HttpUtil.addMapparams();
                HttpUtil.params.put("userId", MyApp.user);

                HttpUtil.params.put("orderId", order_id);
                HttpUtil.params.put("remark", editContext.getText().toString());

                HttpUtil.Post_request("order/refund ", HttpUtil.params);
                getdata("order/refund");



                break;
        }
    }

    @Override
    public void StringResulit(final String key, final String Value) {

        try {
            if (key.equals("order/refund")){
//            private Bean_Term bean_term;
//            private boolean success;
//            private int code;
//            private String msg;
//            private Object data;
                bean_term = MyApp.gson.fromJson(Value,Bean_Term.class);
                success = bean_term.isSuccess();
                if (success){
                    startActivity(ActApplyrefund.class);
                }
            }
        }catch (Exception e){

        }


    }






}
