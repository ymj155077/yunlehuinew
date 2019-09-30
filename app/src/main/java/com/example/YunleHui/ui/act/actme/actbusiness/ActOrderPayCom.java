package com.example.YunleHui.ui.act.actme.actbusiness;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.YunleHui.Bean.Bean_am;
import com.example.YunleHui.Bean.Bean_com;
import com.example.YunleHui.Bean.Bean_mall;
import com.example.YunleHui.Bean.Bean_nmn;
import com.example.YunleHui.MainActivity;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.ActComPur.ActComMall;
import com.example.YunleHui.ui.act.ActComPur.ActShopCenterNew;
import com.example.YunleHui.ui.act.acthome.ActPayOrder;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.ClearEditText;
import com.example.YunleHui.view.NoScrollListView;
import com.example.YunleHui.view.datePicker.DoubleTimeSelectDialog;
import com.example.YunleHui.view.starttime.TimeSelectPicker;

import org.jaaksi.pickerview.topbar.DefaultTopBar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.YunleHui.ui.act.ActComPur.ActNearMer.actNearMer;

/**
 * 下单支付 社区购
 */

public class ActOrderPayCom extends BaseAct implements CompoundButton.OnCheckedChangeListener {


    private int shopnew = 0;


    private String startTime = "";
    private String endTime = "";


    @BindView(R.id.edit_name)
    ClearEditText edit_name;

    @BindView(R.id.edit_Tel)
    ClearEditText edit_Tel;

    @BindView(R.id.edit_address)
    ClearEditText edit_address;

    @BindView(R.id.edit_Remarks)
    ClearEditText edit_Remarks;

    //    社区id
    private int communityId = 0;
    ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> entityListAll = new ArrayList<>();
    //总数量
    private int text_Num = 0;


    @BindView(R.id.no_list)
    NoScrollListView no_list;


    //  配送方式 选择
    @BindView(R.id.lin_pay_type)
    LinearLayout lin_pay_type;


    @BindView(R.id.lin_pay)
    LinearLayout lin_pay;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    @BindView(R.id.text_hsh)
    TextView text_hsh;

    @BindView(R.id.text_pay)
    TextView text_pay;


    private int shopId = 0;
    private String priceAll = "";

    //购物车列表的数据
    private Bean_nmn bean_nmn;
    private boolean success_nmn;
    private int code_nmn;
    private String msg_nmn;
    private Bean_nmn.DataBean data_nmn;
    private Bean_nmn.DataBean.CartInfoCollectionBean cartInfoCollection;
    private List<Bean_nmn.DataBean.CartInfoCollectionBean.EntityListBean> entityLists;
    //选中的商品的数据
    private ArrayList<Bean_nmn.DataBean.CartInfoCollectionBean.EntityListBean> entstAll = new ArrayList<>();


    private Bean_am bean_am;
    private boolean success_am;
    private int code_am;
    private String msg_am;
    private Bean_am.DataBean data_am;


    private int receiveWay = 1;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_order_pay_deli;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            TextView textView = toolbar_all.findViewById(R.id.toolbar_center);
            textView.setText("下单支付");
        }
        checkBoxes[0] = (RadioButton) findViewById(R.id.radio00);
        checkBoxes[1] = (RadioButton) findViewById(R.id.radio01);
        checkBoxes[2] = (RadioButton) findViewById(R.id.radio02);
        checkBoxes[3] = (RadioButton) findViewById(R.id.radio03);
        checkBoxes[0].setOnCheckedChangeListener(this);
        checkBoxes[1].setOnCheckedChangeListener(this);
        checkBoxes[2].setOnCheckedChangeListener(this);
        checkBoxes[3].setOnCheckedChangeListener(this);
//      radio_order = (RadioGroup) findViewById(R.id.radio_order);
    }

//    private RadioGroup radio_order;

    @BindView(R.id.text_start)
    TextView text_start;

    @BindView(R.id.text_end)
    TextView text_end;

    private String[] stringCkeck = {"门店自提", "社区店自提", "商家配送", "社区点配送"};

    private RadioButton[] checkBoxes = new RadioButton[4];


    public static ActOrderPayCom actOrderPayCom;


    @Override
    public void initData() {

        actOrderPayCom = this;

        Intent intent = getIntent();

//其他社区购进行购买的
        shopnew = intent.getIntExtra("shopnew",0);


        communityId = intent.getIntExtra("communityId", 0);

        shopId = intent.getIntExtra("shopId", 0);
//总金额
        priceAll = intent.getStringExtra("priceAll");
//所有数据
        entityListAll = (ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX>) intent.getSerializableExtra("entityListAll");
        Log.i("datasfan", MyApp.gson.toJson(entityListAll));
//总数量
        String size = intent.getStringExtra("text_Num");
        text_Num = Integer.valueOf(size);
        text_hsh.setText(priceAll);
        HttpUtil.addMapparams();
        HttpUtil.params.put("shopId", shopId);
        HttpUtil.Post_request("shopping/getCartsAndBaseInfo", HttpUtil.params);
        getdata("shopping/getCartsAndBaseInfo");
    }

    @OnClick({R.id.lin_pay, R.id.text_pay})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.lin_pay:
                ChooseTime();
                break;
            case R.id.text_pay:
                if (text_Num == 0) {

                } else {


                    if (edit_name.getText().toString().trim().length() == 0) {
                        Toast.makeText(this, "请输入名字", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    if (edit_Tel.getText().toString().trim().length() == 0) {
                        Toast.makeText(this, "请输入电话", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (edit_address.getText().toString().trim().length() == 0) {
                        Toast.makeText(this, "请输入收货地址", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (edit_Remarks.getText().toString().trim().length() == 0) {
                        Toast.makeText(this, "请输入备注", Toast.LENGTH_SHORT).show();
                        return;
                    }






                    HttpUtil.addMapparams();
//社区id
                    HttpUtil.params.put("communityId", communityId);

                    HttpUtil.params.put("customerId", "");

                    HttpUtil.params.put("customerName", edit_name.getText().toString().trim());

                    HttpUtil.params.put("customerTel", edit_Tel.getText().toString().trim());

                    HttpUtil.params.put("deliveryTime", startTime + "-" + endTime);
                    HttpUtil.params.put("receiveAddress", edit_address.getText().toString());
                    //1234
                    HttpUtil.params.put("receiveWay", receiveWay);
                    HttpUtil.params.put("remark", edit_Remarks.getText().toString().trim());


                    HttpUtil.params.put("shopId", shopId);


                    HttpUtil.postRaw("order/saveOrder", HttpUtil.params);
                    getdata("order/saveOrder");

                }
                break;
        }
    }

    /**
     * 默认的周开始时间，格式如：yyyy-MM-dd
     **/
    public String defaultWeekBegin;
    /**
     * 默认的周结束时间，格式如：yyyy-MM-dd
     */
    public String defaultWeekEnd;


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
            for (int i = 0; i < checkBoxes.length; i++) {
                //不等于当前选中的就变成false
                if (checkBoxes[i].getText().toString().equals(compoundButton.getText().toString())) {
                    checkBoxes[i].setChecked(true);
                    if (checkBoxes[i].getText().toString().equals("门店自提")) {

                        receiveWay = 1;

                        lin_pay_type.setVisibility(View.GONE);
                    }
                    if (checkBoxes[i].getText().toString().equals("社区点自提")) {

                        receiveWay = 2;

                        lin_pay_type.setVisibility(View.GONE);
                    }
                    if (checkBoxes[i].getText().toString().equals("商家配送")) {

                        receiveWay = 3;

                        lin_pay_type.setVisibility(View.VISIBLE);
                    }
                    if (checkBoxes[i].getText().toString().equals("社区点配送")) {

                        receiveWay = 4;

                        lin_pay_type.setVisibility(View.VISIBLE);
                    }
                } else {
                    checkBoxes[i].setChecked(false);
                }
            }
        }
    }

    //  购物车ID,
    private int SelegouId = 0;
    //    数量
    private int Gousize = 0;
    //    购物车的价钱
    private int pricePo = 0;

    //    购物车的adpter
    public class MyGouAdapter extends BaseAdapter {
        private ArrayList<Bean_nmn.DataBean.CartInfoCollectionBean.EntityListBean> datas = new ArrayList<>();
        private LayoutInflater inflater;
        private Context context;

        public MyGouAdapter(ArrayList<Bean_nmn.DataBean.CartInfoCollectionBean.EntityListBean> datas, Context context) {
            this.datas.clear();
            this.datas.addAll(datas);
            this.inflater = LayoutInflater.from(context);
            this.context = context;
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
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            MyViewHolder myViewHolder = new MyViewHolder();
            convertView = inflater.inflate(R.layout.item_com, parent, false);
            myViewHolder.text_name = (TextView) convertView.findViewById(R.id.text_name);
            myViewHolder.text_price = (TextView) convertView.findViewById(R.id.text_price);
            myViewHolder.img_jian = (ImageView) convertView.findViewById(R.id.img_jian);
            myViewHolder.text_size = (TextView) convertView.findViewById(R.id.text_size);
            myViewHolder.img_jia = (ImageView) convertView.findViewById(R.id.img_jia);
            myViewHolder.text_name.setText(datas.get(position).getGoodsName());
            myViewHolder.text_price.setText(Tools.chenfa(datas.get(position).getPrice()) + "");
            myViewHolder.text_size.setText(datas.get(position).getBuyNum() + "");
            convertView.setTag(myViewHolder);
            myViewHolder.img_jia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myViewHolder.text_size.setText(datas.get(position).getBuyNum() + 1 + "");
                    datas.get(position).setBuyNum(Integer.valueOf(myViewHolder.text_size.getText().toString()));
//                    notifyDataSetChanged();
//                    text_Num.setText(Integer.valueOf(text_Num.getText().toString()) + 1 + "");
                    SelegouId = datas.get(position).getGoodsId();
                    Gousize = Integer.valueOf(myViewHolder.text_size.getText().toString());
                    pricePo = datas.get(position).getPrice();
                    Log.i("Gousize", Gousize + "---" + datas.get(position).getShopId() + "----" + datas.get(position).getGoodsId());
                    HttpUtil.addMapparams();
                    HttpUtil.params.put("shopId", datas.get(position).getShopId());
                    HttpUtil.params.put("goodsId", datas.get(position).getGoodsId());
                    HttpUtil.params.put("buyNum", Integer.valueOf(myViewHolder.text_size.getText().toString()) + "");
                    HttpUtil.params.put("goodsName", datas.get(position).getGoodsName());
                    HttpUtil.params.put("price", datas.get(position).getPrice());
                    HttpUtil.postRaw("shopping/addOrUpdateCartInfo", HttpUtil.params);
                    getdata("shopping/addGouPop");
                }
            });

            myViewHolder.img_jian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Integer.valueOf(myViewHolder.text_size.getText().toString()) == 0) {
                        Toast.makeText(context, "没有了！！！", Toast.LENGTH_SHORT).show();
                    } else {
                        myViewHolder.text_size.setText(Integer.valueOf(myViewHolder.text_size.getText().toString()) - 1 + "");
//                        datas.set(position,Integer.valueOf(holder.text_number.getText().toString()));
                        datas.get(position).setBuyNum(Integer.valueOf(myViewHolder.text_size.getText().toString()));
//                        notifyDataSetChanged();
//                        text_Num.setText(Integer.valueOf(text_Num.getText().toString()) - 1 + "");
                        SelegouId = datas.get(position).getGoodsId();
                        Gousize = Integer.valueOf(myViewHolder.text_size.getText().toString());
                        pricePo = datas.get(position).getPrice();
                        Log.i("Gousize", Gousize + "---" + datas.get(position).getShopId() + "----" + datas.get(position).getGoodsId() + "--" + Integer.valueOf(myViewHolder.text_size.getText().toString()) + "");
                        HttpUtil.addMapparams();
                        HttpUtil.params.put("shopId", datas.get(position).getShopId());
                        HttpUtil.params.put("goodsId", datas.get(position).getGoodsId());
                        HttpUtil.params.put("buyNum", Integer.valueOf(myViewHolder.text_size.getText().toString()) + "");
                        HttpUtil.params.put("goodsName", datas.get(position).getGoodsName());
                        HttpUtil.params.put("price", datas.get(position).getPrice());
                        HttpUtil.postRaw("shopping/addOrUpdateCartInfo", HttpUtil.params);
                        getdata("shopping/JianGouPop");
                    }
                }
            });
            return convertView;
        }

        public class MyViewHolder {
            private TextView text_name;
            private TextView text_price;
            private ImageView img_jian;
            private TextView text_size;
            private ImageView img_jia;
        }
    }


    @Override
    public void StringResulit(String key, String value) {


//        选中的商品的列表

        if (key.equals("shopping/getCartsAndBaseInfo")) {
            bean_nmn = MyApp.gson.fromJson(value, Bean_nmn.class);
            data_nmn = bean_nmn.getData();
            cartInfoCollection = data_nmn.getCartInfoCollection();
            entityLists = cartInfoCollection.getEntityList();
            entstAll.clear();
            entstAll.addAll(entityLists);
//        购物车 弹窗
            MyGouAdapter myGouAdapter = new MyGouAdapter(entstAll, this);
            no_list.setAdapter(myGouAdapter);
        }


        //        购物车添加的列表
        if (key.equals("shopping/addGouPop")) {
            Log.i("SelegouId", SelegouId + "---" + Gousize);
            text_Num = text_Num + 1;
//            text_number_detail.setText(Integer.valueOf(text_number_detail.getText().toString()) - 1 + "");
            text_hsh.setText(Tools.Gouadd(text_hsh.getText().toString() + "", pricePo * 0.01 + ""));
            for (int i = 0; i < entityListAll.size(); i++) {
                if (entityListAll.get(i).getId() == SelegouId) {
                    entityListAll.get(i).setSortNum(Gousize);
                }
            }
        }


//        购物车减少的列表
        if (key.equals("shopping/JianGouPop")) {
//            text_number_detail.setText(Integer.valueOf(text_number_detail.getText().toString()) - 1 + "");
//            text_Num.setText(Integer.valueOf(text_Num.getText().toString()) - 1 + "");
            text_Num = text_Num - 1;
            Log.i("SelegouId", SelegouId + "---" + Gousize);
            text_hsh.setText(Tools.GouJian(text_hsh.getText().toString() + "", pricePo * 0.01 + ""));
            for (int i = 0; i < entityListAll.size(); i++) {
                if (entityListAll.get(i).getId() == SelegouId) {
                    entityListAll.get(i).setSortNum(Gousize);
//                    myRecycleViewAdapter.clear_data(datasss);
//                    myRecycleViewAdapter.notifyDataSetChanged();
                }
            }
            bean_am = MyApp.gson.fromJson(value, Bean_am.class);
            if (bean_am.getData().getBuyNum() == 0) {
                if (text_Num == 0) {
                    no_list.setVisibility(View.GONE);
                    Drawable drawableRed = ContextCompat.getDrawable(this, R.drawable.bamgyouno);
                    text_pay.setBackgroundDrawable(drawableRed);
                    text_pay.setText("暂无商品");
                    text_pay.setClickable(false);
                } else {
                    //                  购物车列表
                    HttpUtil.addMapparams();
                    HttpUtil.params.put("shopId", shopId);
                    HttpUtil.Post_request("shopping/getCartsAndBaseInfo", HttpUtil.params);
                    getdata("shopping/getCartsAndBaseInfo");
                }
            }
        }


//        提交订单

        if (key.equals("order/saveOrder")) {
//            private Bean_com bean_com;
//            private boolean success;
//            private int code;
//            private String msg;
//            private Bean_com.DataBean data;
            bean_com = MyApp.gson.fromJson(value, Bean_com.class);
            data = bean_com.getData();
            ActComMall.actComMall.finish();
            Intent intent = new Intent(this, ActPayOrder.class);
            intent.putExtra("orderNature", 1);
//          OrderNumber = intent.getStringExtra("OrderNumber");
//          price = intent.getStringExtra("price");
//          shop_name = intent.getStringExtra("shop_name");
            Log.i("getOrderNum", data.getOrderInfo().getOrderNum() + "--");
            intent.putExtra("OrderNumber", data.getOrderInfo().getOrderNum());
            intent.putExtra("price", Tools.chenfa(data.getOrderInfo().getPayMoney()) + "");
            intent.putExtra("shop_name", data.getOrderInfo().getShopName());
            startActivity(intent);
            if (shopnew == 1){
                actNearMer.finish();
                ActShopCenterNew.actShopCenterNew.finish();
            }
        }
    }

//    时间选择器

    private void ChooseTime() {

        startTime = "";
        endTime = "";

        long nowTime = System.currentTimeMillis();

        long todayStartTime = nowTime - (nowTime + TimeZone.getDefault().getRawOffset()) % (1000 * 3600 * 24);

        Log.i("sadsd", System.currentTimeMillis() + "-----");

        TimeSelectPicker mTimePicker = new TimeSelectPicker.Builder(ActOrderPayCom.this, TimeSelectPicker.TYPE_TIME, new TimeSelectPicker.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(TimeSelectPicker picker, Date date, Date datestart) {
//                        Toast.makeText(MainActivity.this, picker.last + "", Toast.LENGTH_SHORT).show();
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                String t1 = format.format(date);
                String t2 = format.format(datestart);

                startTime = t1;
                endTime = t2;


                text_start.setText(t1);
                text_end.setText(t2);
//              Toast.makeText(ActOrderPayCom.this, t1 + "`"+t2, Toast.LENGTH_LONG).show();
            }
        })
                // 设置不包含超出的结束时间<=
                .setContainsEndDate(false)
                // 设置时间间隔为30分钟
                .setTimeMinuteOffset(30)
//                        .setRangDate(System.currentTimeMillis(), 1577976666000L)
                .setRangDate(todayStartTime, 1577976666000L)

                .create();


        // 2018/2/5 03:14:11 - 2020/1/2 22:51:6
        Dialog pickerDialog = mTimePicker.getPickerDialog();
        pickerDialog.setCanceledOnTouchOutside(true);
        DefaultTopBar topBar = (DefaultTopBar) mTimePicker.getTopBar();
        topBar.getTitleView().setText("请选择时间");
        pickerDialog.show();
    }

    private Bean_com bean_com;
    private boolean success;
    private int code;
    private String msg;
    private Bean_com.DataBean data;


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

//            intent.putExtra("text_Num",text_Num.getText().toString());
//            Bundle bundle = new Bundle();
//            bundle.putSerializable("datas",datas);
////                    总的商品的数量
//            intent.putExtras(bundle);
//            intent.putExtra("shopId",shopId);
//            intent.putExtra("priceAll",text_sum.getText().toString());
            Intent i = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("entityListAll", entityListAll);
            i.putExtras(bundle);
            i.putExtra("shopId", shopId);
            i.putExtra("priceAll", text_hsh.getText().toString());
            i.putExtra("text_Num", text_Num + "");
            setResult(3, i);
            finish();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }


}
