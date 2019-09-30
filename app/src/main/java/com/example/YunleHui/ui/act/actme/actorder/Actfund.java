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
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.Bean_Term;
import com.example.YunleHui.Bean.Bean_naturOne;
import com.example.YunleHui.Bean.Bean_pur;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.refund.ActRefund;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.NoScrollListView;

import java.util.ArrayList;
import java.util.List;

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


    @BindView(R.id.edit_context)
    EditText editContext;


    @BindView(R.id.text_jddj)
    TextView text_jddj;

    private String order_number;

    private int orderNature = 0;


    @BindView(R.id.npoksd)
    NoScrollListView npoksd;


    List<Bean_pur.DataBean.OrderDetailListBean> orderDetailList;


    @BindView(R.id.lin_tuikuan)
    LinearLayout lin_tuikuan;


    @BindView(R.id.lin_shequgou)
    LinearLayout lin_shequgou;


    public static Actfund actfund ;


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


    private MyListView myListView;


    @Override
    public void initData() {

        actfund = this;

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

        order_number = intent.getStringExtra("order_id");

        orderNature = intent.getIntExtra("orderNature", 0);

        if (orderNature == 1) {
            lin_tuikuan.setVisibility(View.GONE);
            orderDetailList = (List<Bean_pur.DataBean.OrderDetailListBean>) intent.getSerializableExtra("DetailList");
            myListView = new MyListView(orderDetailList, this);
            npoksd.setAdapter(myListView);
        } else {


            lin_shequgou.setVisibility(View.GONE);


        }


    }


    @OnClick({R.id.text_Submission})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_Submission:

                HttpUtil.addMapparams();
                HttpUtil.params.put("orderNum", order_number);
                HttpUtil.params.put("remark", editContext.getText().toString());
                HttpUtil.params.put("orderNature", orderNature);
                HttpUtil.Post_request("order/refund", HttpUtil.params);

                Log.i("asdasdsa",order_number+"----"+orderNature);

                getdata("order/refund");

                break;
        }
    }

    @Override
    public void StringResulit(final String key, final String Value) {

        try {
            if (key.equals("order/refund")) {
//            private Bean_Term bean_term;
//            private boolean success;
//            private int code;
//            private String msg;
//            private Object data;


                if (orderNature == 0){
                    bean_term = MyApp.gson.fromJson(Value, Bean_Term.class);
                    success = bean_term.isSuccess();
                    if (success) {
                        Intent intent = new Intent(this, ActRefund.class);
                        intent.putExtra("orderNature", orderNature);
                        intent.putExtra("order_number",order_number);
                        startActivity(intent);
                    }
                }else if (orderNature == 1){


                    bean_naturOne = MyApp.gson.fromJson(Value,Bean_naturOne.class);

                    code_naturOne = bean_naturOne.getCode();

                    if (code_naturOne == 200){
                        Intent intent = new Intent(this, ActRefund.class);
                        intent.putExtra("orderNature", orderNature);
                        intent.putExtra("order_number",order_number);
                        startActivity(intent);
                    }

                }

            }
        } catch (Exception e) {

        }
    }



    private Bean_naturOne bean_naturOne;
    private boolean success_naturOne;
    private int code_naturOne;
    private String msg_naturOne;
    private Bean_naturOne.DataBean data_naturOne;




//    社区购的列表


    public class MyListView extends BaseAdapter {


        private ArrayList<Bean_pur.DataBean.OrderDetailListBean> datas = new ArrayList<>();
        private LayoutInflater inflater;


        public MyListView(List<Bean_pur.DataBean.OrderDetailListBean> datas, Context context) {
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


            MyViewHolder myViewHolder = null;

            if (convertView == null) {
                myViewHolder = new MyViewHolder();
                convertView = inflater.inflate(R.layout.item_order_shequ, parent, false);


                myViewHolder.text_name = (TextView) convertView.findViewById(R.id.text_name);
                myViewHolder.text_size = (TextView) convertView.findViewById(R.id.text_size);
                myViewHolder.text_price = (TextView) convertView.findViewById(R.id.text_price);

                convertView.setTag(myViewHolder);

            } else {
                myViewHolder = (MyViewHolder) convertView.getTag();
            }

            if (datas != null && !datas.isEmpty()) {

                myViewHolder.text_name.setText(datas.get(position).getGoodsName());
                myViewHolder.text_size.setText(datas.get(position).getNum() + "");
                myViewHolder.text_price.setText(Tools.chenfa(datas.get(position).getPrice()));

            }


            return convertView;
        }


        public class MyViewHolder {

            private TextView text_name;
            private TextView text_size;
            private TextView text_price;

        }


    }


}
