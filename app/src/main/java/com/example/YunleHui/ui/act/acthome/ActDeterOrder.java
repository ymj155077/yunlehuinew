package com.example.YunleHui.ui.act.acthome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.Bean_cread;
import com.example.YunleHui.Bean.Bean_sucess;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import butterknife.BindView;
import butterknife.OnClick;

//确认订单
public class ActDeterOrder extends BaseAct {


    public static ActDeterOrder actDeterOrder;
    private Bean_sucess bean_sucess;
    private boolean success_sucess;
    private int code_sucess;
    private String msg_sucess;
    private Bean_sucess.DataBean data_sucess;

    private Bean_cread bean_cread;

    private String order_number;

    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @BindView(R.id.lin_place)
    LinearLayout lin_place;


    //套餐ID
    private String goodsSetId = "";
    //商品ID
    private String goodsId = "";

//名字

    private String name = "";

//    图片

    private String url = "";

//    内容

    private String content = "";

//    金额

    private double price_tao = 0.00;

    private int order_id = 0;


    @BindView(R.id.img_jian)
    ImageView img_jian;


    @BindView(R.id.img_add)
    ImageView img_add;


    @BindView(R.id.text_size)
    TextView text_size;

    @BindView(R.id.shop_name)
    TextView shop_name;

    @BindView(R.id.shop_img)
    ImageView shop_img;

    @BindView(R.id.text_content)
    TextView text_content;


    @BindView(R.id.text_price)
    TextView text_price;


    @BindView(R.id.edit_phone)
    TextView edit_phone;

    @BindView(R.id.edit_Remarks)
    EditText edit_Remarks;


    @BindView(R.id.text_price_boom)
    TextView text_price_boom;


    @BindView(R.id.lin_size)
    LinearLayout lin_size;


//    等于1的时候  order 详情点击 进来的;

    private int type = 0;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_deter_order;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            TextView textView = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            textView.setText("确认订单");
        }
    }

    @Override
    public void initData() {
        actDeterOrder = this;
        Intent intent = getIntent();
        type = intent.getIntExtra("type", 0);
        if (type == 0) {
            goodsSetId = intent.getStringExtra("goodsSetId");
            goodsId = intent.getStringExtra("goodsId");
            name = intent.getStringExtra("name");
            url = intent.getStringExtra("url");
            content = intent.getStringExtra("content");
            price_tao = intent.getDoubleExtra("price_tao", price_tao);
            shop_name.setText(name);
            Glide.with(this).load(url).into(shop_img);
            text_content.setText(content);
            text_price.setText(Tools.chenfa(price_tao) + "");
            text_price_boom.setText(Tools.chenfa(price_tao) + "");
        } else if (type == 1) {
            String text_title = intent.getStringExtra("text_title");
            shop_name.setText(text_title);
            String log_url = intent.getStringExtra("log_url");
            Glide.with(this).load(log_url).into(shop_img);
            String text_context = intent.getStringExtra("text_context");
            text_content.setText(text_context);
            String text_pri = intent.getStringExtra("text_price");
            String text_size = intent.getStringExtra("text_size");
            BigDecimal a = BigDecimal.valueOf(Double.valueOf(text_pri));
            BigDecimal b = BigDecimal.valueOf(Double.valueOf(text_size));
            BigDecimal c = a.multiply(b);
            text_price.setText(c + "");
            order_id = intent.getIntExtra("order_id",0);
            String text_phone = intent.getStringExtra("text_phone");
            edit_phone.setText(text_phone);
            edit_Remarks.setVisibility(View.GONE);
            lin_size.setVisibility(View.GONE);
            text_price_boom.setText(c + "");
            order_number = intent.getStringExtra("order_number");
            edit_phone.setEnabled(false);
        }
    }


    @OnClick({R.id.lin_place, R.id.img_jian,R.id.img_add})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.lin_place:
                if (type == 0){
                    if (edit_phone.getText().toString().length() == 11) {
                        Map<Object, Object> params_order = new HashMap<>();
                        params_order.clear();
                        HttpUtil.addMapparams();
                        params_order.put("channel", 2);
//                    渠道
                        params_order.put("count", Integer.valueOf(text_size.getText().toString()));
                        params_order.put("goodsId", Integer.valueOf(goodsId));
                        params_order.put("goodsSetId", Integer.valueOf(goodsSetId));
                        ArrayList<Long> a = new ArrayList<>();
                        a.clear();
                        a.add(0l);
                        params_order.put("discountResultIdList", a);
                        params_order.put("remark", edit_Remarks.getText().toString().trim());
                        params_order.put("tel", edit_phone.getText().toString().trim());
                        params_order.put("userId", Integer.valueOf(MyApp.user));
//                      HttpUtil.params.put("createOrderDto", params_order);
                        HttpUtil.postRaw("order/create",
                                params_order
                        );
                        getdata("order/create");
                    } else {
                        Toast.makeText(this, "请检查手机号码！", Toast.LENGTH_SHORT).show();
                    }
                }else if (type == 1){
                    Intent intent = new Intent(this, ActPayOrder.class);
                    intent.putExtra("order", order_number);
                    intent.putExtra("order_id",order_id);
                    intent.putExtra("price", text_price_boom.getText().toString());
                    intent.putExtra("shop_name",shop_name.getText().toString());
                    startActivity(intent);
                }

                break;

            case R.id.img_jian:

                if (Integer.valueOf(text_size.getText().toString()) == 1) {
                    Toast.makeText(this, "没有了哟！", Toast.LENGTH_SHORT).show();
                } else {
                    text_size.setText(Integer.valueOf(text_size.getText().toString()) - 1 + "");
//                    BigDecimal a = BigDecimal.valueOf(price_tao);
//                    BigDecimal b = BigDecimal.valueOf(Integer.valueOf(text_size.getText().toString()));
//                    BigDecimal c = a.multiply(b);
                    text_price_boom.setText(Tools.chenfa(price_tao*Integer.valueOf(text_size.getText().toString())));
                }

                break;

            case R.id.img_add:
                text_size.setText(Integer.valueOf(text_size.getText().toString()) + 1 + "");
//                BigDecimal a = BigDecimal.valueOf(price_tao);
//                BigDecimal b = BigDecimal.valueOf(Integer.valueOf(text_size.getText().toString()));
//                BigDecimal c = a.multiply(b);
                text_price_boom.setText(Tools.chenfa(price_tao*Integer.valueOf(text_size.getText().toString())));
                break;
        }
    }


    @Override
    public void stringResulit(String key, String value) {

        try {
            if (key.equals("order/create")) {

                bean_sucess = MyApp.gson.fromJson(value, Bean_sucess.class);
                code_sucess = bean_sucess.getCode();

                if (code_sucess == 200) {
                    Intent intent = new Intent(this, ActPayOrder.class);

                    String order = bean_sucess.getData().getOrderNumber();

                    String OrderNumber = bean_sucess.getData().getOrderNumber();


                    intent.putExtra("OrderNumber", OrderNumber);

                    intent.putExtra("order", order);

                    intent.putExtra("shop_name",shop_name.getText().toString());

                    intent.putExtra("Content",text_content.getText().toString());

                    intent.putExtra("price", text_price_boom.getText().toString());

                    startActivity(intent);
                } else {
                    Toast.makeText(this, bean_sucess.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }
        }catch (Exception E){

        }


    }
}
