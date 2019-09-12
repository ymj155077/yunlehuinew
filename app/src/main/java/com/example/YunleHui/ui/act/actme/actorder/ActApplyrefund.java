package com.example.YunleHui.ui.act.actme.actorder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.view.NoScrollListView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 申请退款
 */

public class ActApplyrefund extends BaseAct {

    @BindView(R.id.list_fund)
    NoScrollListView list_fund;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    private String mark;

    private String time;


    private TextView textShopName;
    private ImageView imgBack;
    private TextView textContext;
    private TextView textSize;
    private TextView textPriceAll;
    private TextView textPrice;

    private TextView textOne;
    private TextView textTwo;
    private TextView textThree;


    @BindView(R.id.text_state)
    TextView text_state;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_applyrefund;
    }

    @Override
    protected void findViews() {

        if (toolbar_all != null) {
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("退款详情");
        }

        textShopName = (TextView) findViewById(R.id.text_shop_name);
        imgBack = (ImageView) findViewById(R.id.img_back);
        textContext = (TextView) findViewById(R.id.text_context);
        textSize = (TextView) findViewById(R.id.text_size);
        textPriceAll = (TextView) findViewById(R.id.text_price_all);
        textPrice = (TextView) findViewById(R.id.text_price);
        textOne = (TextView) findViewById(R.id.text_one);
        textTwo = (TextView) findViewById(R.id.text_two);
        textThree = (TextView) findViewById(R.id.text_three);

    }


    private int state = 0;

    private String text_refund_title;

    private String img_refund;

    private String text_context;

    private String text_price;

    private String text_boom_size;

    private String text_price_all;


    @Override
    public void initData() {
        Intent intent = getIntent();
        state = intent.getIntExtra("state", 0);
        text_refund_title = intent.getStringExtra("text_refund_title");
        img_refund = intent.getStringExtra("img_refund");
        text_context = intent.getStringExtra("text_context");
        text_price = intent.getStringExtra("text_price");
        text_boom_size = intent.getStringExtra("size");
        text_price_all = intent.getStringExtra("text_price_all");
        mark = intent.getStringExtra("mark");
//退款时间
        time = intent.getStringExtra("time");
        textShopName.setText(text_refund_title);
        Glide.with(this).load(img_refund).into(imgBack);
        textContext.setText(text_context);
        textSize.setText(text_boom_size);
        textPriceAll.setText(text_price_all);
        textPrice.setText(text_price);
        textOne.setText(text_price_all);
        textTwo.setText(mark);
        textThree.setText(time);
//        ArrayList<String> datas = new ArrayList<>();
//        datas.clear();
//        for (int i = 0; i < 3; i++) {
//            datas.add("");
//        }
//        list_fund.setAdapter(new MyAdapter(datas, this));
        if (state == 0) {
            text_state.setText("退款申请已提交");
        } else if (state == 1) {
            text_state.setText("退款申请失败");
        } else if (state == 2) {
            text_state.setText("退款申请成功待打款");
        } else if (state == 3) {
            text_state.setText("退款申请已拒绝待修改订单");
        }
    }


    private MyAdapter myAdapter;


    public class MyAdapter extends BaseAdapter {

        private ArrayList<String> datas = new ArrayList<>();

        private LayoutInflater inflater;

        public MyAdapter(ArrayList<String> datas, Context context) {

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
        public View getView(int position, View convertView, ViewGroup parent) {

            MyViewHolder myViewHolder = new MyViewHolder();

            View view1 = inflater.inflate(R.layout.item_fun, null);


            return view1;
        }


        public class MyViewHolder {


        }

    }


}
