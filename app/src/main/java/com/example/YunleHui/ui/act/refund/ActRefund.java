package com.example.YunleHui.ui.act.refund;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.BeanShequ;
import com.example.YunleHui.Bean.Bean_detailas;
import com.example.YunleHui.Bean.Bean_she;
import com.example.YunleHui.Bean.Bean_sws;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.actme.actorder.ActComPurUsed;
import com.example.YunleHui.ui.act.actme.actorder.ActDetailstoused;
import com.example.YunleHui.ui.act.actme.actorder.Actfund;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.NoScrollListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * 未使用   退款详情
 */


public class ActRefund extends BaseAct {


    private Bean_she bean_she;
    private boolean success_she;
    private int code_she;
    private String msg_she;
    private Bean_she.DataBean data_she;

    private List<Bean_she.DataBean.OrderDetailListBean> orderDetailList;


    @BindView(R.id.no_list)
    NoScrollListView no_list;

    private int orderNature = 0;

    private String order_number = "";


    Bean_detailas bean_detailas;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @BindView(R.id.text_shop_name)
    TextView text_shop_name;

    @BindView(R.id.img_back)
    ImageView img_back;

    @BindView(R.id.text_context)
    TextView text_context;

    @BindView(R.id.text_price)
    TextView text_price;

    @BindView(R.id.text_size)
    TextView text_size;

    @BindView(R.id.text_price_all)
    TextView text_price_all;

    @BindView(R.id.text_one)
    TextView text_one;

    @BindView(R.id.text_two)
    TextView text_two;

    @BindView(R.id.text_three)
    TextView text_three;

    @BindView(R.id.lin_refund)
    LinearLayout lin_refund;

    //    社区购需要展示的数据
    @BindView(R.id.lin_cs)
    LinearLayout lin_cs;


    private MyLisAdapter myLisAdapter;


//    订单查询的数据


    private int orderWay = 0;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_refund;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            TextView text_center = toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("退款详情");
            LinearLayout lin_lin_lin = (LinearLayout) toolbar_all.findViewById(R.id.lin_lin_lin);
            lin_lin_lin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (orderWay == 0) {
                        Actfund.actfund.finish();
                        ActDetailstoused.actDetailstoused.finish();
                        finish();
                    } else {
                        finish();
                    }
                }
            });
        }
    }

    @Override
    public void initData() {

        Intent intent = getIntent();
        orderNature = intent.getIntExtra("orderNature", 0);
        order_number = intent.getStringExtra("order_number");


//        订单里面点击进来的

        orderWay = intent.getIntExtra("orderWay", 0);


        if (orderNature == 0) {


            lin_cs.setVisibility(View.GONE);


        } else {

            lin_refund.setVisibility(View.GONE);
        }
//爆款
        HttpUtil.addMapparams();
        HttpUtil.params.put("orderNature", orderNature);
        HttpUtil.params.put("orderNum", order_number);
        HttpUtil.Post_request("orderFull/details", HttpUtil.params);
        getdata("orderFull/details");
//        } else {
////社区购
//            HttpUtil.addMapparams();
//            HttpUtil.params.put("orderNum", order_number);
//            HttpUtil.Post_request("order/getOrderFull", HttpUtil.params);
//            getdata("order/getOrderFull");
//        }
    }


    private Bean_sws bean_sws;
    private boolean success;
    private int code;
    private String msg;
    private Bean_sws.DataBean data;

    private List<Bean_sws.DataBean.RefundApplyVoListBean> refundApplyVoList;


    @Override
    public void StringResulit(final String key, final String Value) {
        try {
//            爆款
            if (key.equals("orderFull/details")) {
                if (orderNature == 0) {
                    bean_sws = MyApp.gson.fromJson(Value, Bean_sws.class);
                    data = bean_sws.getData();
                    refundApplyVoList = data.getRefundApplyVoList();
                    text_shop_name.setText(data.getShopName());
                    Glide.with(this).load(data.getLogoUrl()).into(img_back);
                    text_context.setText(data.getGoodsName());
                    text_price.setText(Tools.chenfa(data.getTotalMoney() / data.getCount()) + "元");
                    text_size.setText(data.getCount() + "");
                    text_price_all.setText(Tools.chenfa(data.getTotalMoney()));
                    text_one.setText(Tools.chenfa(refundApplyVoList.get(0).getAccount()));
                    text_two.setText(refundApplyVoList.get(0).getUserRemark());
                    text_three.setText(refundApplyVoList.get(0).getCreateDate());
                } else if (orderNature == 1) {
                    bean_she = MyApp.gson.fromJson(Value, Bean_she.class);
                    data_she = bean_she.getData();
                    orderDetailList = data_she.getOrderDetailList();
                    int size = 0;
                    for (int i = 0; i < orderDetailList.size(); i++) {
                        size += orderDetailList.get(i).getNum();
                    }


                    text_shop_name.setText(data_she.getShopName());


                    text_sizee.setText(size+"");
                    text_prices.setText(Tools.chenfa(data_she.getTotalMoney()));
                    myLisAdapter = new MyLisAdapter(orderDetailList, this);
                    no_list.setAdapter(myLisAdapter);
                    text_one.setText(Tools.chenfa(data_she.getTotalMoney()));
                    text_two.setText(data_she.getRemark());
                    text_three.setText(Tools.stampToDate(data_she.getCreateTime()+""));
                }
            }
        } catch (Exception e) {

        }

        try {
//          社区购
            if (key.equals("order/getOrderFull")){

            }
        } catch (Exception e) {

        }
    }

    @BindView(R.id.text_sizee)
    TextView text_sizee;

    @BindView(R.id.text_prices)
    TextView text_prices;

    public class MyLisAdapter extends BaseAdapter {

        private ArrayList<Bean_she.DataBean.OrderDetailListBean> datas = new ArrayList<>();
        private LayoutInflater inflater;

        public MyLisAdapter(List<Bean_she.DataBean.OrderDetailListBean> datas, Context context) {
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
            myViewHolder.text_name.setText(datas.get(position).getGoodsName());
            myViewHolder.text_size.setText(datas.get(position).getNum() + "");
            myViewHolder.text_price.setText(Tools.chenfa(datas.get(position).getPrice()) + "");
            return convertView;
        }

        public class MyViewHolder {
            private TextView text_name;
            private TextView text_size;
            private TextView text_price;
        }
    }

    //注意，在实测中发现event类有可能为null,当然，此例中我们并不需要event类
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (orderWay == 0) {
                //爆款的
                if (orderNature == 0) {
                    ActDetailstoused.actDetailstoused.finish();
                } else {
                    //社区购
                    ActComPurUsed.actComPurUsed.finish();
                }
                Actfund.actfund.finish();
                finish();
            } else {
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
