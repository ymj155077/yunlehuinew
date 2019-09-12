package com.example.YunleHui.ui.act.actme.actorder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.Bean_order_deatil;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.HttpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 核销码
 */

public class ActWritecode extends BaseAct {

    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.text_he)
    TextView textHe;
    @BindView(R.id.text_Term)
    TextView textTerm;

    private int order_id = 0;


    private Bean_order_deatil bean_order_deatil;
    private boolean success;
    private int code;
    private String msg;
    private Bean_order_deatil.DataBean data;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_writecode;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("订单核销码");
        }
    }

    @Override
    public void initData() {

        Intent intent = getIntent();
//      datas = (ArrayList<Bean_no_use.DataBean.VoListBean>) intent.getSerializableExtra("serinfo");
        order_id = intent.getIntExtra("order_id", 0);
        HttpUtil.addMapparams();
        HttpUtil.params.put("orderId", order_id);
        HttpUtil.Post_request("order/detail", HttpUtil.params);
        getdata("order/detail");

    }


    public void StringResulit(final String key, final String Value) {

        try {
            if (key.equals("order/detail")) {

                bean_order_deatil = MyApp.gson.fromJson(Value, Bean_order_deatil.class);

                data = bean_order_deatil.getData();


                Glide.with(this).load(MyApp.PUBLIC_URL + "order/generateQrCode?secret=" + data.getOrderVerificationCode()).into(imgBack);


                textHe.setText(data.getOrderVerificationCode()+"");

                textTerm.setText("有效期至："+data.getEffectiveDate()+"");

            }

        }catch (Exception e){

        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
