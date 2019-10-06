package com.example.YunleHui.ui.act.ActComPur;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.Bean_Gou;
import com.example.YunleHui.Bean.Bean_am;
import com.example.YunleHui.Bean.Bean_mall;
import com.example.YunleHui.Bean.Bean_nmn;
import com.example.YunleHui.Bean.Bean_sasd;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.acthome.ActComdetails;
import com.example.YunleHui.ui.act.actme.actbusiness.ActOrderPayCom;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.ObservableScrollView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;


/**
 *
 *
 * 商铺中心的列表
 *
 *
 * */

public class ActShopCenterNew extends BaseAct implements ObservableScrollView.OnObservableScrollViewScrollChanged {





    @BindView(R.id.text_Num)
    TextView text_Num;


    @BindView(R.id.text_sum)
    TextView text_sum;

    @BindView(R.id.shopImg)
    ImageView shopImg;

    @BindView(R.id.text_name)
    TextView text_name;

    @BindView(R.id.text_tel)
    TextView text_tel;

    @BindView(R.id.text_address)
    TextView text_address;

    @BindView(R.id.lin_commodity)
    LinearLayout lin_commodity;


    @BindView(R.id.lin_shop)
    LinearLayout lin_shop;


    @BindView(R.id.lin_boom_gou)
    LinearLayout lin_boom_gou;


//    @BindView(R.id.lin_mall)
//    LinearLayout lin_mall;

//    @BindView(R.id.list_gou)
//    ListView list_gou;


    //社区Id
    private int communityId = 0;


    private ObservableScrollView sv_contentView;
    private LinearLayout ll_topView;
    private LinearLayout ll_fixedView;

    //用来记录内层固定布局到屏幕顶部的距离
    private int mHeight;


    @BindView(R.id.view_commodity)
    View view_commodity;

    @BindView(R.id.view_shop)
    View view_shop;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    TextView text_center;

    MyRecycleViewAdapter myRecycleViewAdapter;


    @BindView(R.id.lin_pop_type)
    LinearLayout lin_pop_type;

    private String phoneNum = "";


    @BindView(R.id.lin_ok)
    LinearLayout lin_ok;


    public static ActShopCenterNew actShopCenterNew;



    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_shop_center_new;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("商铺中心");
        }
        sv_contentView = (ObservableScrollView) findViewById(R.id.sv_contentView);
        ll_topView = (LinearLayout) findViewById(R.id.ll_topView);
        ll_fixedView = (LinearLayout) findViewById(R.id.ll_fixedView);
        sv_contentView.setOnObservableScrollViewScrollChanged(this);
    }


    private String tel = "";
    private String name = "";
    private String address = "";
    private String img = "";
    private String shopIds = "";

    @Override
    public void initData() {


        actShopCenterNew = this;


        Intent intent = getIntent();
        shopIds = intent.getStringExtra("shopId");
        tel = intent.getStringExtra("tel");
        name = intent.getStringExtra("name");
        address = intent.getStringExtra("address");
        img = intent.getStringExtra("img");

//社区ID
        communityId = intent.getIntExtra("communityId", 0);


        shopId = intent.getIntExtra("shopIdd", 0);

        Glide.with(this).load(img).into(shopImg);
        text_name.setText(name);
        text_tel.setText(tel);
        text_address.setText(address);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xre_mall.setLayoutManager(layoutManager);

        HttpUtil.getAsynHttp("shopping/toShop?shopId=" + shopIds);
        getdata("shopping/toShop");

    }

    @BindView(R.id.tab_radiogroup)
    LinearLayout tab_radiogroup;


    @BindView(R.id.text_ShopAddress)
    TextView text_ShopAddress;

    @BindView(R.id.text_openTime)
    TextView text_openTime;

    @BindView(R.id.lin_cell)
    LinearLayout lin_cell;

    @Override
    public void onObservableScrollViewScrollChanged(int l, int t, int oldl, int oldt) {
        if (t >= mHeight) {
            if (tab_radiogroup.getParent() != ll_fixedView) {


                ll_topView.removeView(tab_radiogroup);
                ll_fixedView.addView(tab_radiogroup);

                tab_radiogroup.setBackgroundColor(Color.parseColor("#FFFFFF"));

            }
        } else {
            if (tab_radiogroup.getParent() != ll_topView) {
                ll_fixedView.removeView(tab_radiogroup);
                ll_topView.addView(tab_radiogroup);

                tab_radiogroup.setBackgroundColor(Color.parseColor("#FFFFFF"));

            }
        }
    }

//    public static class BannerViewHolder implements MZViewHolder<Object> {
//        private ImageView mImageView;
//
//        @Override
//        public View createView(Context context) {
//            // 返回页面布局
//            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
//            mImageView = (ImageView) view.findViewById(R.id.banner_image);
//            return view;
//        }
//
//        @Override
//        public void onBind(Context context, int position, Object data) {
//            // 数据绑定
////            mImageView.setImageResource( data);
//            Glide.with(MyApp.context).load(data).into(mImageView);
//        }
//    }

    public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {

        private int psojfas = 0;
        MyRecycleViewAdapter.ViewHolder holder;
        private LayoutInflater inflater;
        private ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> datas = new ArrayList<>();
        private Context context;

        public MyRecycleViewAdapter(ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> datas, Context context) {
            this.datas.clear();
            this.datas.addAll(datas);
            this.context = context;
            this.inflater = LayoutInflater.from(context);
        }

        public void clear_data(ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> datas) {
            this.datas.clear();
            this.datas.addAll(datas);
            notifyDataSetChanged();
        }

        public void add_data(ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> datas) {
            this.datas.addAll(datas);
            notifyDataSetChanged();
        }


        //        获取所有的 数据

        private ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> getDatas() {
            return datas;
        }


        @Override
        public MyRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wandax, parent, false);
            return new MyRecycleViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyRecycleViewAdapter.ViewHolder holder, final int position) {

            this.holder = holder;


            Glide.with(context).load(datas.get(position).getLogoUrl()).into(holder.img_shop);
            holder.text_details.setText(datas.get(position).getGoodsName());
            holder.text_pay.setText(Tools.chenfa(datas.get(position).getDiscountPrice()) + "");
            holder.text_yuanjia.setText(Tools.chenfa(datas.get(position).getPrice()) + "");
            holder.text_size.setText(datas.get(position).getTotalSale() + "");
            holder.text_gui.setText(datas.get(position).getSpecifications());
            holder.text_yuanjia.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            holder.text_number.setText(datas.get(position).getSortNum() + "");


            holder.lin_asd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                  context.startActivity(new Intent(context, ActBusDetails.class));
                    sc_detail.setVisibility(View.VISIBLE);
                    lin_new.setVisibility(View.GONE);
                    text_center.setText("商品详情");
                    psojfas = position;
                    Shopdetails(datas, position);
                }
            });
            holder.img_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.text_number.setText(datas.get(position).getSortNum() + 1 + "");
                    datas.get(position).setSortNum(Integer.valueOf(holder.text_number.getText().toString()));
//                    notifyDataSetChanged();
//                    text_Num.setText(Integer.valueOf(text_Num.getText().toString()) + 1 + "");
                    HttpUtil.addMapparams();
                    HttpUtil.params.put("shopId", datas.get(position).getShopId());
                    HttpUtil.params.put("goodsId", datas.get(position).getId());
                    HttpUtil.params.put("buyNum", Integer.valueOf(holder.text_number.getText().toString()) + "");
                    HttpUtil.params.put("goodsName", datas.get(position).getGoodsName());
                    HttpUtil.params.put("price", datas.get(position).getPrice());
                    HttpUtil.postRaw("shopping/addOrUpdateCartInfo", HttpUtil.params);
                    getdata("shopping/addGou");
                    psojfas = position;
                }
            });
            holder.img_jian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Integer.valueOf(holder.text_number.getText().toString()) == 0) {
                        Toast.makeText(context, "没有了！！！", Toast.LENGTH_SHORT).show();
                    } else {
                        holder.text_number.setText(Integer.valueOf(holder.text_number.getText().toString()) - 1 + "");
//                        datas.set(position,Integer.valueOf(holder.text_number.getText().toString()));
                        datas.get(position).setSortNum(Integer.valueOf(holder.text_number.getText().toString()));
//                        notifyDataSetChanged();
//                        text_Num.setText(Integer.valueOf(text_Num.getText().toString()) - 1 + "");
                        HttpUtil.addMapparams();
                        HttpUtil.params.put("shopId", datas.get(position).getShopId());
                        HttpUtil.params.put("goodsId", datas.get(position).getId());
                        HttpUtil.params.put("buyNum", Integer.valueOf(holder.text_number.getText().toString()) + "");
                        HttpUtil.params.put("goodsName", datas.get(position).getGoodsName());
                        HttpUtil.params.put("price", datas.get(position).getPrice());
                        HttpUtil.postRaw("shopping/addOrUpdateCartInfo", HttpUtil.params);
                        getdata("shopping/JianGou");
                        psojfas = position;
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView img_jian, img_shop;
            private ImageView img_add;
            private TextView text_number, text_details, text_pay, text_yuanjia, text_size, text_gui;

            private LinearLayout lin_asd;

            public ViewHolder(View itemView) {
                super(itemView);
                img_jian = (ImageView) itemView.findViewById(R.id.img_jian);
                img_add = (ImageView) itemView.findViewById(R.id.img_add);
                text_number = (TextView) itemView.findViewById(R.id.text_number);
                lin_asd = itemView.findViewById(R.id.lin_asd);
                text_details = (TextView) itemView.findViewById(R.id.text_details);
                text_pay = (TextView) itemView.findViewById(R.id.text_pay);
                text_yuanjia = (TextView) itemView.findViewById(R.id.text_yuanjia);
                text_size = (TextView) itemView.findViewById(R.id.text_size);
                text_gui = (TextView) itemView.findViewById(R.id.text_gui);
                img_shop = (ImageView) itemView.findViewById(R.id.img_shop);
            }
        }
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            //获取HeaderView的高度，当滑动大于等于这个高度的时候，需要把topView移除当前布局，放入到外层布局
            mHeight = ll_topView.getTop();
        }
    }


    @OnClick({R.id.lin_boom_gou, R.id.lin_commodity, R.id.lin_shop, R.id.img_jian_detail,
            R.id.img_add_detail, R.id.lin_pop_type, R.id.lin_cell,
    R.id.lin_ok})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.lin_boom_gou:
                if (Integer.valueOf(text_Num.getText().toString()) == 0) {
                } else {
                    if (lin_mall.getVisibility() == View.GONE) {
                        lin_mall.setVisibility(View.VISIBLE);
                        Log.i("adsda", shopId + "--");
//                  购物车列表
                        HttpUtil.addMapparams();
                        HttpUtil.params.put("shopId", shopId);
                        HttpUtil.Post_request("shopping/getCartsAndBaseInfo", HttpUtil.params);
                        getdata("shopping/getCartsAndBaseInfo");
                    } else {
                        lin_mall.setVisibility(View.GONE);
                    }
                }
                break;
            case R.id.lin_commodity:
                view_shop.setVisibility(View.INVISIBLE);
                view_commodity.setVisibility(View.VISIBLE);
                xre_mall.setVisibility(View.VISIBLE);
                lin_shops.setVisibility(View.GONE);
                break;
            case R.id.lin_shop:
                view_shop.setVisibility(View.VISIBLE);
                view_commodity.setVisibility(View.INVISIBLE);
                xre_mall.setVisibility(View.GONE);
                lin_shops.setVisibility(View.VISIBLE);
                break;

            //减少
            case R.id.img_jian_detail:
                if (Integer.valueOf(text_number_detail.getText().toString()) > 0) {
                    Log.i("img_add_detail", Integer.valueOf(text_number_detail.getText().toString()) - 1 + "");
                    HttpUtil.addMapparams();
                    HttpUtil.params.put("shopId", shopId);
                    HttpUtil.params.put("goodsId", goodsId);
                    HttpUtil.params.put("buyNum", Integer.valueOf(text_number_detail.getText().toString()) - 1 + "");
                    HttpUtil.params.put("goodsName", goodsName);
                    HttpUtil.params.put("price", price);
                    HttpUtil.postRaw("shopping/addOrUpdateCartInfo", HttpUtil.params);
                    getdata("shopping/detailJian");
                } else {
                    Toast.makeText(this, "没有了！", Toast.LENGTH_SHORT).show();
                }
                break;
//                添加
            case R.id.img_add_detail:

//                红色
                Drawable drawableRed = ContextCompat.getDrawable(ActShopCenterNew.this, R.drawable.bamgyou);
                lin_ok.setBackgroundDrawable(drawableRed);


                Log.i("img_add_detail", Integer.valueOf(text_number_detail.getText().toString()) + 1 + "");
                HttpUtil.addMapparams();
                HttpUtil.params.put("shopId", shopId);
                HttpUtil.params.put("goodsId", goodsId);
                HttpUtil.params.put("buyNum", Integer.valueOf(text_number_detail.getText().toString()) + 1 + "");
                HttpUtil.params.put("goodsName", goodsName);
                HttpUtil.params.put("price", price);
                HttpUtil.postRaw("shopping/addOrUpdateCartInfo", HttpUtil.params);
                getdata("shopping/detailJia");
                break;


            case R.id.lin_pop_type:


                lin_mall.setVisibility(View.GONE);


                break;
//                打电话
            case R.id.lin_cell:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + phoneNum);
                intent.setData(data);
                startActivity(intent);
                break;
            case R.id.lin_ok:
                if (text_Num.getText().toString().equals("0")) {
                    Toast.makeText(this, "请添加商品", Toast.LENGTH_SHORT).show();
                } else {
                    if (lin_mall.getVisibility()==View.VISIBLE){
                        lin_mall.setVisibility(View.GONE);
                    }
                    Intent intentCom = new Intent(this, ActOrderPayCom.class);
                    //                        所有的数据
                    intentCom.putExtra("text_Num", text_Num.getText().toString());

//                    其他商家购买的
                    intentCom.putExtra("shopnew",1);

//                    社区Id
                    intentCom.putExtra("communityId", communityId);
                    Bundle bundle = new Bundle();
                    entitychuan = myRecycleViewAdapter.getDatas();
                    bundle.putSerializable("entityListAll", entitychuan);
//                    总的商品的数量
                    intentCom.putExtras(bundle);
                    intentCom.putExtra("shopId", shopId);
                    intentCom.putExtra("priceAll", text_sum.getText().toString());
                    startActivityForResult(intentCom, 1);
                }
                break;
        }
    }

    //传递过去的数据
    private ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> entitychuan = new ArrayList<>();

    @BindView(R.id.xre_mall)
    RecyclerView xre_mall;


    @BindView(R.id.lin_shops)
    LinearLayout lin_shops;


    @BindView(R.id.lin_mall)
    LinearLayout lin_mall;


    //    列表页
    @BindView(R.id.lin_new)
    LinearLayout lin_new;

    //    详情页
    @BindView(R.id.scr_mall)
    ScrollView sc_detail;


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (sc_detail.getVisibility() == View.VISIBLE) {
                sc_detail.setVisibility(View.GONE);
                lin_new.setVisibility(View.VISIBLE);

                text_center.setText("商铺中心");

            } else {
                finish();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }


    //真正的数据
    Bean_sasd bean_sasd;
    private boolean success;
    private int code;
    private String msg;
    private Bean_sasd.DataBean data;


    private Bean_mall bean_mall;
    private boolean success_mall;
    private int code_mall;
    private String msg_mall;
    private Bean_mall.DataBean data_mall;
    private Bean_mall.DataBean.GoodsInfoCollectionBean goodsInfoCollection;

    private List<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> entityList;

    private ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> entityListAll = new ArrayList<>();

    private Bean_mall.DataBean.SelfShopBean selfShop;

    @Override
    public void StringResulit(String key, String value) {
        if (key.equals("shopping/toShop")) {
            bean_mall = MyApp.gson.fromJson(value, Bean_mall.class);
            data_mall = bean_mall.getData();
            goodsInfoCollection = data_mall.getGoodsInfoCollection();
            entityList = goodsInfoCollection.getEntityList();
            entityListAll.clear();
            entityListAll.addAll(entityList);
//购物车
            myRecycleViewAdapter = new MyRecycleViewAdapter(entityListAll, this);
            xre_mall.setAdapter(myRecycleViewAdapter);
//设置recycleview不可滑动
            xre_mall.setNestedScrollingEnabled(false);
            bean_sasd = MyApp.gson.fromJson(value, Bean_sasd.class);
            data = bean_sasd.getData();
            text_openTime.setText(data.getShopInfo().getOpenTime());
            phoneNum = data.getShopInfo().getShopTel();
            text_ShopAddress.setText(data.getShopInfo().getShopAddress());
        }

//        列表加
        //列表里面添加购物车
//        添加购物车返回的数据
        if (key.equals("shopping/addGou")) {
            bean_gou = MyApp.gson.fromJson(value, Bean_Gou.class);
            data_gou = bean_gou.getData();
            Log.i("asdsa", data_gou.getBuyNum() + "----");
            text_number_detail.setText(data_gou.getBuyNum() + "");
            text_Num.setText(Integer.valueOf(text_Num.getText().toString()) + 1 + "");
            text_sum.setText(Tools.Gouadd(text_sum.getText().toString() + "", data_gou.getPrice() * 0.01 + "") + "");
//            myRecycleViewAdapter.notifyDataSetChanged();
//            text_number_detail.setText(data_gou.getBuyNum()+"");
//            text_Num.setText(data_gou.getBuyNum()+"");



            Drawable drawableRed= ContextCompat.getDrawable(ActShopCenterNew.this, R.drawable.bamgyou);

            lin_ok.setBackgroundDrawable(drawableRed);

            text_jhj.setText("选好了");

        }


//        列表减


        //列表里面添加购物车
//        添加购物车返回的数据
        if (key.equals("shopping/JianGou")) {
            bean_gou = MyApp.gson.fromJson(value, Bean_Gou.class);
            data_gou = bean_gou.getData();
            Log.i("asdsa", data_gou.getBuyNum() + "----");
            text_number_detail.setText(data_gou.getBuyNum() + "");

            text_Num.setText(Integer.valueOf(text_Num.getText().toString()) - 1 + "");
            text_sum.setText(Tools.GouJian(text_sum.getText().toString() + "", data_gou.getPrice() * 0.01 + "") + "");
//            myRecycleViewAdapter.notifyDataSetChanged();
//            text_number_detail.setText(data_gou.getBuyNum()+"");
//            text_Num.setText(data_gou.getBuyNum()+"");



            if (text_Num.getText().toString().equals("0")){


                Drawable drawableRed= ContextCompat.getDrawable(ActShopCenterNew.this, R.drawable.bamgyouno);

                lin_ok.setBackgroundDrawable(drawableRed);

                text_jhj.setText("￥0起送");

            }



        }


//        详情加
        //        详情里面加减购物车
        if (key.equals("shopping/detailJia")) {
            bean_gou = MyApp.gson.fromJson(value, Bean_Gou.class);
            data_gou = bean_gou.getData();
            Log.i("shopping/detail", data_gou.getBuyNum() + "----" + positionssss);
//            myRecycleViewAdapter = new MyRecycleViewAdapter(datas,this,classId);
            datas.get(positionssss).setSortNum(data_gou.getBuyNum());
            myRecycleViewAdapter.clear_data(datas);
            myRecycleViewAdapter.notifyDataSetChanged();
//            xre_mall.setAdapter(myRecycleViewAdapter);
//            myRecycleViewAdapter.setNumBer(data_gou.getBuyNum());
            text_number_detail.setText(data_gou.getBuyNum() + "");

            text_Num.setText(Integer.valueOf(text_Num.getText().toString()) + 1 + "");
            text_sum.setText(Tools.Gouadd(text_sum.getText().toString() + "", data_gou.getPrice() * 0.01 + ""));



            Drawable drawableRed= ContextCompat.getDrawable(ActShopCenterNew.this, R.drawable.bamgyou);

            lin_ok.setBackgroundDrawable(drawableRed);

            text_jhj.setText("选好了");



        }

//        详情减

        //        详情里面加减购物车
        if (key.equals("shopping/detailJian")) {
            bean_gou = MyApp.gson.fromJson(value, Bean_Gou.class);
            data_gou = bean_gou.getData();
            Log.i("shopping/detail", data_gou.getBuyNum() + "----" + positionssss);
//            myRecycleViewAdapter = new MyRecycleViewAdapter(datas,this,classId);
            datas.get(positionssss).setSortNum(data_gou.getBuyNum());
            myRecycleViewAdapter.clear_data(datas);
            myRecycleViewAdapter.notifyDataSetChanged();
//            xre_mall.setAdapter(myRecycleViewAdapter);
//            myRecycleViewAdapter.setNumBer(data_gou.getBuyNum());
            text_number_detail.setText(data_gou.getBuyNum() + "");

            text_Num.setText(Integer.valueOf(text_Num.getText().toString()) - 1 + "");

            text_sum.setText(Tools.GouJian(text_sum.getText().toString() + "", data_gou.getPrice() * 0.01 + "") + "");

if (text_Num.getText().toString().equals("0")){
    Drawable drawableRed= ContextCompat.getDrawable(ActShopCenterNew.this, R.drawable.bamgyouno);

    lin_ok.setBackgroundDrawable(drawableRed);

    text_jhj.setText("￥0起送");
}



        }


        if (key.equals("shopping/getCartsAndBaseInfo")) {

            bean_nmn = MyApp.gson.fromJson(value, Bean_nmn.class);
            data_nmn = bean_nmn.getData();
            cartInfoCollection = data_nmn.getCartInfoCollection();
            entityLists = cartInfoCollection.getEntityList();
            entstAll.clear();
            entstAll.addAll(entityLists);

//        购物车 弹窗
            MyGouAdapter myGouAdapter = new MyGouAdapter(entstAll, this);
            list_gou.setAdapter(myGouAdapter);
        }

//        购物车添加的列表
        if (key.equals("shopping/addGouPop")) {
            Log.i("SelegouId", SelegouId + "---" + Gousize);
            text_Num.setText(Integer.valueOf(text_Num.getText().toString()) + 1 + "");
            text_number_detail.setText(Integer.valueOf(text_number_detail.getText().toString()) + 1 + "");
            text_sum.setText(Tools.Gouadd(text_sum.getText().toString() + "", pricePo * 0.01 + ""));
            for (int i = 0; i < entityListAll.size(); i++) {
                if (entityListAll.get(i).getId() == SelegouId) {
                    entityListAll.get(i).setSortNum(Gousize);
                    myRecycleViewAdapter.clear_data(entityListAll);
                    myRecycleViewAdapter.notifyDataSetChanged();
                }
            }



                Drawable drawableRed= ContextCompat.getDrawable(ActShopCenterNew.this, R.drawable.bamgyou);

                lin_ok.setBackgroundDrawable(drawableRed);

                text_jhj.setText("选好了");




        }

//        购物车减少的列表

        if (key.equals("shopping/JianGouPop")) {
            text_number_detail.setText(Integer.valueOf(text_number_detail.getText().toString()) - 1 + "");
            text_Num.setText(Integer.valueOf(text_Num.getText().toString()) - 1 + "");
            Log.i("SelegouId", SelegouId + "---" + Gousize);
            text_sum.setText(Tools.GouJian(text_sum.getText().toString() + "", pricePo * 0.01 + ""));
            for (int i = 0; i < entityListAll.size(); i++) {
                if (entityListAll.get(i).getId() == SelegouId) {
                    entityListAll.get(i).setSortNum(Gousize);
                    myRecycleViewAdapter.clear_data(entityListAll);
                    myRecycleViewAdapter.notifyDataSetChanged();
                }
            }


            bean_am = MyApp.gson.fromJson(value, Bean_am.class);
            if (bean_am.getData().getBuyNum() == 0) {
                if (text_Num.getText().toString().equals("0")) {
                    lin_mall.setVisibility(View.GONE);

                    Drawable drawableRed= ContextCompat.getDrawable(ActShopCenterNew.this, R.drawable.bamgyouno);

                    lin_ok.setBackgroundDrawable(drawableRed);

                    text_jhj.setText("￥0起送");

                } else {
                    //                  购物车列表
                    HttpUtil.addMapparams();
                    HttpUtil.params.put("shopId", shopId);
                    HttpUtil.Post_request("shopping/getCartsAndBaseInfo", HttpUtil.params);
                    getdata("shopping/getCartsAndBaseInfo");
                }
            }
        }
    }



    @BindView(R.id.text_jhj)
    TextView text_jhj;


//    添加购物车返回的数据


    private Bean_Gou bean_gou;
    private boolean success_gou;
    private int code_gou;
    private String msg_gou;
    private Bean_Gou.DataBean data_gou;


    //购物车列表的数据
    private Bean_nmn bean_nmn;
    private boolean success_nmn;
    private int code_nmn;
    private String msg_nmn;
    private Bean_nmn.DataBean data_nmn;
    private Bean_nmn.DataBean.CartInfoCollectionBean cartInfoCollection;
    private List<Bean_nmn.DataBean.CartInfoCollectionBean.EntityListBean> entityLists;
    private ArrayList<Bean_nmn.DataBean.CartInfoCollectionBean.EntityListBean> entstAll = new ArrayList<>();


    private Bean_am bean_am;
    private boolean success_am;
    private int code_am;
    private String msg_am;
    private Bean_am.DataBean data_am;


    //    购物车弹窗
    @BindView(R.id.list_gou)
    ListView list_gou;


    private int shopId;
    private int goodsId;
    private int buyNum;
    private String goodsName;
    private int price;
    //    第几行
    private int positionssss = 0;
    private Bean_mall.DataBean.SelfShopBean selfShopBean;
    ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> datas = new ArrayList<>();

    //    返回的 list
    ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> entityFan = new ArrayList<>();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //此处可以根据两个Code进行判断，本页面和结果页面跳过来的值
        if (requestCode == 1 && resultCode == 3) {
            shopId = data.getIntExtra("shopId", 0);
//总金额
            String priceAll = data.getStringExtra("priceAll");
            text_sum.setText(priceAll);
//所有数据
            entityFan.clear();
            entityFan = (ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX>) data.getSerializableExtra("entityListAll");

            Log.i("datasfan",entityFan.get(positionssss).getSortNum()+"----"+MyApp.gson.toJson(entityFan));

            text_number_detail.setText(entityFan.get(positionssss).getSortNum()+"");

//总数量
            String size = data.getStringExtra("text_Num");
            text_Num.setText(size);



            if (size.equals("0")){
                Drawable drawableRed= ContextCompat.getDrawable(ActShopCenterNew.this, R.drawable.bamgyouno);

                lin_ok.setBackgroundDrawable(drawableRed);

                text_jhj.setText("￥0起送");
            }



            myRecycleViewAdapter.clear_data(entityFan);
            myRecycleViewAdapter.notifyDataSetChanged();
//            for (int i = 0; i < datasfan.size(); i++) {
//                if (datasfan.get(i).getId() == SelegouId) {
//                    datasfan.get(i).setSortNum(Gousize);
//
//                }
//            }
        }
    }


    //展示商品详情
    private void Shopdetails(ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> datas, int position) {

//        @BindView(R.id.img_view)
//        ImageView img_view;
//        @BindView(R.id.text_shopname)
//        TextView text_shopname;
//        @BindView(R.id.text_price)
//        TextView text_price;
//        @BindView(R.id.text_yuan)
//        TextView text_yuan;
//        @BindView(R.id.text_xiao)
//        TextView text_xiao;
//        @BindView(R.id.text_context)
//        TextView text_context;

        Glide.with(this).load(datas.get(position).getLogoUrl()).into(img_view);

        text_shopname.setText(datas.get(position).getGoodsName());

        text_price.setText(Tools.chenfa(datas.get(position).getDiscountPrice()));

        text_yuan.setText(" 原价 " + Tools.chenfa(datas.get(position).getPrice()));

        text_yuan.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        text_xiao.setText(datas.get(position).getTotalSale() + "");

        text_context.setText(datas.get(position).getRemark());

        text_number_detail.setText(datas.get(position).getSortNum() + "");

        shopId = datas.get(position).getShopId();
        goodsId = datas.get(position).getId();
        buyNum = datas.get(position).getSortNum();
        goodsName = datas.get(position).getGoodsName();
        price = datas.get(position).getPrice();
        this.positionssss = position;
        this.datas.clear();
        this.datas.addAll(datas);
    }


    @BindView(R.id.img_view)
    ImageView img_view;
    @BindView(R.id.text_shopname)
    TextView text_shopname;
    @BindView(R.id.text_price)
    TextView text_price;
    @BindView(R.id.text_yuan)
    TextView text_yuan;
    @BindView(R.id.text_xiao)
    TextView text_xiao;
    @BindView(R.id.text_context)
    TextView text_context;

    @BindView(R.id.text_number_detail)
    TextView text_number_detail;


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
            convertView = inflater.inflate(R.layout.item_gou_list, parent, false);
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


}
