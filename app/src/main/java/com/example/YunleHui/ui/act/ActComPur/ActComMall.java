package com.example.YunleHui.ui.act.ActComPur;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.actme.actbusiness.ActBusDetails;
import com.example.YunleHui.ui.act.actme.actbusiness.ActOrderPayCom;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.HorizontalListView;
import com.example.YunleHui.view.MyXrecycleview;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 社区商城
 */


public class ActComMall extends BaseAct {


    @BindView(R.id.text_jhj)
    TextView text_jhj;

    //  购物车ID,
    private int SelegouId = 0;


    //    数量
    private int Gousize = 0;


    //    购物车的价钱
    private int pricePo = 0;


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


    @BindView(R.id.img_jian_detail)
    ImageView img_jian_detail;

    @BindView(R.id.text_number_detail)
    TextView text_number_detail;

    @BindView(R.id.img_add_detail)
    ImageView img_add_detail;


//    详情页

    @BindView(R.id.scr_mall)
    ScrollView scr_mall;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


//    @BindView(R.id.xre_mall)
//    MyXrecycleview xre_mall;


    @BindView(R.id.xre_mall)
    MyXrecycleview xre_mall;


    //    购物车弹窗
    @BindView(R.id.list_gou)
    ListView list_gou;


//    整个弹窗

    @BindView(R.id.lin_mall)
    LinearLayout lin_mall;


//    点击显示隐藏 购物车

    @BindView(R.id.lin_boom_gou)
    LinearLayout lin_boom_gou;


    @BindView(R.id.lin_pop_type)
    LinearLayout lin_pop_type;


    @BindView(R.id.text_Num)
    TextView text_Num;

    @BindView(R.id.lin_ok)
    LinearLayout lin_ok;

    //社区Id
    private int communityId = 0;


    public static ActComMall actComMall;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_com_mall;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            TextView text_center = toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("社区商城");
        }
    }

    private int hffhfh = 0;
    private int offset = 1;
    private int type = 0;
    private HorizontalListView list_cai;
    private ImageView img_she;
    private TextView text_name;
    private TextView text_daili;
    private TextView text_phone;
    private TextView text_address;
    private String urlImg = "";
    private TextView text_shop;


    @Override
    public void initData() {

        actComMall = this;

        Intent intent = getIntent();

        communityId = intent.getIntExtra("communityId", 0);

//社区代理的名字
        agent = intent.getStringExtra("agent");

        Log.i("communityId", communityId + "---");

        View view = LayoutInflater.from(this).inflate(R.layout.layout_caidan, null);


        img_she = view.findViewById(R.id.img_she);

        text_name = view.findViewById(R.id.text_name);

        text_daili = view.findViewById(R.id.text_daili);

        text_phone = view.findViewById(R.id.text_phone);

        text_address = view.findViewById(R.id.text_address);

        text_shop = (TextView) view.findViewById(R.id.text_shop);

        text_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shopInfoListAll.size() > 0) {
                    Intent intent_nearby = new Intent(ActComMall.this, ActNearMer.class);
                    intent_nearby.putExtra("name", text_name.getText().toString());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("shopInfoListAll", (Serializable) shopInfoListAll);
                    intent_nearby.putExtras(bundle);
                    intent_nearby.putExtra("img_she", urlImg);
                    startActivity(intent_nearby);
                } else {
                    Toast.makeText(ActComMall.this, "暂无附近商铺!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        list_cai = (HorizontalListView) view.findViewById(R.id.list_cai);
        list_cai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                myListAdapter.setCurrentItem(i);
                myListAdapter.setClick(true);
                myListAdapter.notifyDataSetChanged();
                hffhfh = i;
                classId = entityListBeans.get(i).getId();
                myRecycleViewAdapter.setClassId(entityListBeans.get(i).getId());
                myRecycleViewAdapter.notifyDataSetChanged();
            }
        });
        xre_mall.addHeaderView(view);
        Tools.setManger(xre_mall, this);
//        ArrayList<Integer> dats = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            dats.add(0);
//        }
//社区列表
        offset = 1;
        type = 0;
        HttpUtil.getAsynHttp("community/findCommunity?communityId=" + communityId + "&userId=" + MyApp.user);
        getdata("community/findCommunity");
//        社区列表
        xre_mall.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
//                offset = 1;
//                type = 0;
//                HttpUtil.getAsynHttp("community/findCommunity?communityId="+communityId+"&userId="+MyApp.user);
//                getdata("community/findCommunity");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xre_mall.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {
//                ++offset;
//                type = 2;
//                HttpUtil.getAsynHttp("community/findCommunity?communityId="+communityId+"&userId="+MyApp.user);
//                getdata("community/findCommunity");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xre_mall.loadMoreComplete();
                    }
                }, 1000);
            }
        });
//        xre_mall.refresh();
        xre_mall.setHasFixedSize(true);
        xre_mall.setNestedScrollingEnabled(false);
        xre_mall.setItemViewCacheSize(100);

    }

    //总金额
    @BindView(R.id.text_sum)
    TextView text_sum;

    @OnClick({
            R.id.lin_boom_gou,
            R.id.lin_pop_type,
            R.id.lin_ok,
            R.id.img_jian_detail,
            R.id.img_add_detail
    })
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
            case R.id.lin_pop_type:
                lin_mall.setVisibility(View.GONE);
                break;
            case R.id.lin_ok:
                if (text_Num.getText().toString().equals("0")) {
                    Toast.makeText(this, "请添加商品", Toast.LENGTH_SHORT).show();
                } else {
                    if (lin_mall.getVisibility() == View.VISIBLE) {
                        lin_mall.setVisibility(View.GONE);
                    }
                    Intent intent = new Intent(this, ActOrderPayCom.class);
                    //                        所有的数据
                    intent.putExtra("text_Num", text_Num.getText().toString());
//                    社区Id
                    intent.putExtra("communityId", communityId);
                    Bundle bundle = new Bundle();
                    entitychuan = myRecycleViewAdapter.getDatas();
                    bundle.putSerializable("entityListAll", entitychuan);
//                    总的商品的数量
                    intent.putExtras(bundle);
                    intent.putExtra("shopId", shopId);
                    intent.putExtra("priceAll", text_sum.getText().toString());
                    startActivityForResult(intent, 1);
                }
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
        }
    }


    private MyListAdapter myListAdapter;

    private MyRecycleViewAdapter myRecycleViewAdapter;

    private Myasdas myasdas;


    public class MyListAdapter extends BaseAdapter {


        private int mCurrentItem = 0;
        private boolean isClick = false;


        private ArrayList<Bean_mall.DataBean.GoodsClassInfoCollectionBean.EntityListBean> datas = new ArrayList<>();

        private LayoutInflater inflater;

        public MyListAdapter(List<Bean_mall.DataBean.GoodsClassInfoCollectionBean.EntityListBean> datas, Context context) {
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
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


            MyViewHolder myViewHolder = new MyViewHolder();


            convertView = inflater.inflate(R.layout.item_horlist, parent, false);

            //            text_hhh"lin_kack


            myViewHolder.text_hhh = (TextView) convertView.findViewById(R.id.text_hhh);

            myViewHolder.lin_kack = convertView.findViewById(R.id.lin_kack);


            if (mCurrentItem == position & isClick) {

                myViewHolder.text_hhh.setTextColor(Color.parseColor("#FF6C4B"));


                Resources resources = getBaseContext().getResources();
                Drawable drawable = resources.getDrawable(R.drawable.order);
                myViewHolder.text_hhh.setBackgroundDrawable(drawable);

            } else {

                myViewHolder.text_hhh.setBackgroundDrawable(null);

                myViewHolder.text_hhh.setTextColor(Color.parseColor("#333333"));
            }

            myViewHolder.text_hhh.setText(datas.get(position).getClassName());


            return convertView;
        }


        public class MyViewHolder {
            private TextView text_hhh;
            private LinearLayout lin_kack;
        }

        public void setCurrentItem(int currentItem) {
            this.mCurrentItem = currentItem;
        }

        public void setClick(boolean click) {
            this.isClick = click;
        }

    }


    public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {


        public ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> getReData() {


            return datas;

        }


        private int classId = 0;
        MyRecycleViewAdapter.ViewHolder holder;
        private int psojfas = 0;
        private LayoutInflater inflater;
        private ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> datas = new ArrayList<>();
        private Context context;


//        获取所有的 数据

        private ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> getDatas() {
            return datas;
        }


        public MyRecycleViewAdapter(ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> datas, Context context, int classId) {
            this.datas.clear();
            this.datas.addAll(datas);
            this.context = context;
            this.inflater = LayoutInflater.from(context);
            this.classId = classId;
        }


        @Override
        public long getItemId(int position) {
            return position;
        }


        public void setClassId(int classId) {
            this.classId = classId;
            notifyDataSetChanged();
        }


//        /**
//         * @param holder
//         * @param position
//         * @param payloads   用于标识 刷新布局里面的那个具体控件
//         */
//        @Override
//        public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
//            System.out.println(">>>>payloads"+payloads);
//
//
//            final ViewHolder myviewHolder = (ViewHolder)holder;
//
//
//            if (payloads.isEmpty()){
//
//                super.onBindViewHolder(holder, position, payloads);
//                return;
//            }
//            //循环得到payloads里面的参数
//            for (Object payload:payloads) {
//                switch (String.valueOf(payload)){
//                    case "one":
//                        Log.i("asdsad",numBer+"--"+datas.get(psojfas).getSortNum());
//
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                myviewHolder.text_number.setText(numBer + "");
//                            }
//                        });
//
//
//                        break;
//                }
//            }
//        }


        private int numBer = 0;


        //        改变数量
        public void setNumBer(int numBer) {
            this.datas.get(psojfas).setSortNum(numBer);
            this.numBer = numBer;
            Log.i("holder", numBer + "----" + psojfas);


            holder.text_number.setText(datas.get(positionssss).getSortNum() + 1 + "");


//            holder.text_number.setText(numBer + "");
////            myRecycleViewAdapter.notifyItemChanged(psojfas,"sadffd");
//
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    myRecycleViewAdapter.notifyItemChanged(psojfas,"one");
//                }
//            });
//            notifyDataSetChanged();
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
//}

            Log.i("claId", datas.get(position).getClassId() + "---" + classId);

            if (classId == 1) {
                holder.lin_asd.setVisibility(View.VISIBLE);
            } else {
                if (datas.get(position).getClassId() != classId) {
                    holder.lin_asd.setVisibility(View.GONE);
                } else {

                    Log.i("classIdclassId", datas.get(position).getId() + "-----" + datas.get(position).getClassId() + "---" + classId);

                }
            }
//            else {
//                holder.lin_asd.setVisibility(View.VISIBLE);
//            }
            holder.text_number.setText(datas.get(position).getSortNum() + "");

            holder.lin_asd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    context.startActivity(new Intent(context, ActBusDetails.class));
                    scr_mall.setVisibility(View.VISIBLE);
//                    xre_mall.setVisibility(View.GONE);
//                    展示商品详情

                    Log.i("asdas", position + "---");

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
            return
                    datas.size();
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
                    Log.i("Gousize", Gousize + "---" + datas.get(position).getShopId() + "----" + datas.get(position).getGoodsId() + "--" + datas.get(position).getId());
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
                        Log.i("Gousize", Gousize + "---" + datas.get(position).getShopId() + "----" + datas.get(position).getGoodsId() + "--" + Integer.valueOf(myViewHolder.text_size.getText().toString()) + "--" + datas.get(position).getId());
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


    private Bean_mall bean_mall;
    private boolean success_mall;
    private int code_mall;
    private String msg_mall;
    private Bean_mall.DataBean data_mall;


    private Bean_mall.DataBean.GoodsInfoCollectionBean goodsInfoCollectionBean;


//    赛选列表的数据


    private Bean_mall.DataBean.GoodsClassInfoCollectionBean goodsClassInfoCollectionBean;


    private List<Bean_mall.DataBean.GoodsClassInfoCollectionBean.EntityListBean> entityListBeans;


    //    类型ID
    private int classId = 0;


    private List<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> entityList;

    //    第一次 返回的 数据
    private ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> entityListAll = new ArrayList<>();


    //传递过去的数据
    private ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> entitychuan = new ArrayList<>();

    //    代理
    private String agent;


    //附近商家的列表
    private List<Bean_mall.DataBean.ShopInfoListBean> shopInfoList;
    private ArrayList<Bean_mall.DataBean.ShopInfoListBean> shopInfoListAll = new ArrayList<>();


    @Override
    public void stringResulit(String key, String value) {

        try {
            if (key.equals("community/findCommunity")) {

//            private Bean_mall bean_mall;
//            private boolean success_mall;
//            private int code_mall;
//            private String msg_mall;
//            private Bean_mall.DataBean data_mall;
//          社区商城的列表
                bean_mall = MyApp.gson.fromJson(value, Bean_mall.class);
                data_mall = bean_mall.getData();
                goodsInfoCollectionBean = data_mall.getGoodsInfoCollection();
//商城所有的列表的数据
                entityList = goodsInfoCollectionBean.getEntityList();
                entityListAll.clear();
                entityListAll.addAll(entityList);
                goodsClassInfoCollectionBean = data_mall.getGoodsClassInfoCollection();
//列表的所有的类型
                entityListBeans = goodsClassInfoCollectionBean.getEntityList();
                for (int i = 0; i < entityListBeans.size(); i++) {
                    classId = entityListBeans.get(0).getId();
                }
                myListAdapter = new MyListAdapter(entityListBeans, this);
                list_cai.setAdapter(myListAdapter);
                myListAdapter.setCurrentItem(hffhfh);
                myListAdapter.setClick(true);
                myRecycleViewAdapter = new MyRecycleViewAdapter(entityListAll, this, classId);
//图片闪烁才加的
                myRecycleViewAdapter.setHasStableIds(true);
//            myasdas = new Myasdas(entityListAll, this, classId);
                xre_mall.setAdapter(myRecycleViewAdapter);
//自营店的店铺ID
                selfShopBean = bean_mall.getData().getSelfShop();
                shopId = selfShopBean.getId();
                urlImg = selfShopBean.getShopLogoUrl();
                Glide.with(this).load(selfShopBean.getShopLogoUrl()).into(img_she);
                text_name.setText(selfShopBean.getShopName());
                text_daili.setText(agent);
                text_phone.setText("电话  " + selfShopBean.getShopTel());
                text_address.setText(selfShopBean.getShopAddress());
//            private List<Bean_mall.DataBean.ShopInfoListBean> shopInfoList;
//            private List<Bean_mall.DataBean.ShopInfoListBean> shopInfoListAll = new ArrayList<>();
                shopInfoList = data_mall.getShopInfoList();
                shopInfoListAll.clear();
                shopInfoListAll.addAll(shopInfoList);


                if (shopInfoListAll != null && !shopInfoListAll.isEmpty()) {
//不为空的情况


                } else {
//为空的情况

                    text_shop.setText("");
                    text_shop.setClickable(false);

                }


            }
        }catch (Exception e){

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

            Drawable drawableRed = ContextCompat.getDrawable(ActComMall.this, R.drawable.bamgyou);
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

            if (text_Num.getText().toString().equals("0")) {

                Drawable drawableRed = ContextCompat.getDrawable(ActComMall.this, R.drawable.bamgyouno);
                lin_ok.setBackgroundDrawable(drawableRed);
                text_jhj.setText("￥0起送");

            }

        }


//        详情加
        //        详情里面加减购物车
        if (key.equals("shopping/detailJia")) {
            bean_gou = MyApp.gson.fromJson(value, Bean_Gou.class);
            data_gou = bean_gou.getData();
            Log.i("shopping/detail", data_gou.getBuyNum() + "----");
//            myRecycleViewAdapter = new MyRecycleViewAdapter(datas,this,classId);
            datas.get(positionssss).setSortNum(data_gou.getBuyNum());
            myRecycleViewAdapter.clear_data(datas);
            myRecycleViewAdapter.notifyDataSetChanged();
//            xre_mall.setAdapter(myRecycleViewAdapter);
//            myRecycleViewAdapter.setNumBer(data_gou.getBuyNum());
            text_number_detail.setText(data_gou.getBuyNum() + "");

            text_Num.setText(Integer.valueOf(text_Num.getText().toString()) + 1 + "");
            text_sum.setText(Tools.Gouadd(text_sum.getText().toString() + "", data_gou.getPrice() * 0.01 + ""));

            Drawable drawableRed = ContextCompat.getDrawable(ActComMall.this, R.drawable.bamgyou);
            lin_ok.setBackgroundDrawable(drawableRed);
            text_jhj.setText("选好了");
        }

//        详情减

        //        详情里面加减购物车
        if (key.equals("shopping/detailJian")) {
            bean_gou = MyApp.gson.fromJson(value, Bean_Gou.class);
            data_gou = bean_gou.getData();
            Log.i("shopping/detail", data_gou.getBuyNum() + "----");
//            myRecycleViewAdapter = new MyRecycleViewAdapter(datas,this,classId);
            datas.get(positionssss).setSortNum(data_gou.getBuyNum());
            myRecycleViewAdapter.clear_data(datas);
            myRecycleViewAdapter.notifyDataSetChanged();
//            xre_mall.setAdapter(myRecycleViewAdapter);
//            myRecycleViewAdapter.setNumBer(data_gou.getBuyNum());
            text_number_detail.setText(data_gou.getBuyNum() + "");

            text_Num.setText(Integer.valueOf(text_Num.getText().toString()) - 1 + "");

            text_sum.setText(Tools.GouJian(text_sum.getText().toString() + "", data_gou.getPrice() * 0.01 + "") + "");


            if (text_Num.getText().toString().equals("0")) {

                Drawable drawableRed = ContextCompat.getDrawable(ActComMall.this, R.drawable.bamgyouno);
                lin_ok.setBackgroundDrawable(drawableRed);
                text_jhj.setText("￥0起送");

            }


        }


        if (key.equals("shopping/getCartsAndBaseInfo")) {


//            private Bean_nmn bean_nmn;
//            private boolean success_nmn;
//            private int code_nmn;
//            private String msg_nmn;
//            private Bean_nmn.DataBean data_nmn;


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
            Drawable drawableRed = ContextCompat.getDrawable(ActComMall.this, R.drawable.bamgyou);
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

                    Drawable drawableRed = ContextCompat.getDrawable(ActComMall.this, R.drawable.bamgyouno);
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


    private Bean_am bean_am;
    private boolean success_am;
    private int code_am;
    private String msg_am;
    private Bean_am.DataBean data_am;


    //购物车列表的数据
    private Bean_nmn bean_nmn;
    private boolean success_nmn;
    private int code_nmn;
    private String msg_nmn;
    private Bean_nmn.DataBean data_nmn;
    private Bean_nmn.DataBean.CartInfoCollectionBean cartInfoCollection;
    private List<Bean_nmn.DataBean.CartInfoCollectionBean.EntityListBean> entityLists;
    private ArrayList<Bean_nmn.DataBean.CartInfoCollectionBean.EntityListBean> entstAll = new ArrayList<>();


//    添加购物车返回的数据


    private Bean_Gou bean_gou;
    private boolean success_gou;
    private int code_gou;
    private String msg_gou;
    private Bean_Gou.DataBean data_gou;


    public class Myasdas extends BaseAdapter {


        private int classId = 0;


        private LayoutInflater inflater;
        private ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> datas = new ArrayList<>();
        private Context context;


        public Myasdas(ArrayList<Bean_mall.DataBean.GoodsInfoCollectionBean.EntityListBeanX> datas, Context context, int classId) {
            this.datas.clear();
            this.datas.addAll(datas);
            this.context = context;
            this.inflater = LayoutInflater.from(context);
            this.classId = classId;
        }


        public void setClassId(int classId) {
            this.classId = classId;
            notifyDataSetChanged();
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

//if (convertView == null){


            convertView = inflater.inflate(R.layout.item_wandax, parent, false);
            myViewHolder = new MyViewHolder();
            myViewHolder.img_jian = (ImageView) convertView.findViewById(R.id.img_jian);
            myViewHolder.img_add = (ImageView) convertView.findViewById(R.id.img_add);
            myViewHolder.text_number = (TextView) convertView.findViewById(R.id.text_number);
            myViewHolder.lin_asd = (LinearLayout) convertView.findViewById(R.id.lin_asd);
            myViewHolder.img_shop = (ImageView) convertView.findViewById(R.id.img_shop);

            convertView.setTag(myViewHolder);
//}else {
//    myViewHolder = (MyViewHolder) convertView.getTag();


            myViewHolder.text_details = (TextView) convertView.findViewById(R.id.text_details);
            myViewHolder.text_pay = (TextView) convertView.findViewById(R.id.text_pay);
            myViewHolder.text_yuanjia = (TextView) convertView.findViewById(R.id.text_yuanjia);
            myViewHolder.text_size = (TextView) convertView.findViewById(R.id.text_size);
            myViewHolder.text_gui = (TextView) convertView.findViewById(R.id.text_gui);


            Glide.with(context).load(datas.get(position).getLogoUrl()).into(myViewHolder.img_shop);

            //            private TextView text_details;
//            private TextView text_pay;
//            private TextView text_yuanjia;
//            private TextView text_size;
//            private TextView text_gui;
            myViewHolder.text_details.setText(datas.get(position).getGoodsName());
            myViewHolder.text_pay.setText(Tools.chenfa(datas.get(position).getDiscountPrice()) + "");
            myViewHolder.text_yuanjia.setText(Tools.chenfa(datas.get(position).getPrice()) + "");
            myViewHolder.text_size.setText(datas.get(position).getTotalSale() + "");
            myViewHolder.text_gui.setText(datas.get(position).getSpecifications());
            myViewHolder.text_yuanjia.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
//}

            Log.i("classIdclassId", datas.get(position).getClassId() + "---" + classId);

            if (datas.get(position).getClassId() != classId) {
                myViewHolder.lin_asd.setVisibility(View.GONE);
            }
//            else {
//                holder.lin_asd.setVisibility(View.VISIBLE);
//            }
            myViewHolder.text_number.setText(datas.get(position).getSortNum() + "");

            myViewHolder.lin_asd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, ActBusDetails.class));
                }
            });
            MyViewHolder finalMyViewHolder = myViewHolder;
            myViewHolder.img_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finalMyViewHolder.text_number.setText(datas.get(position).getSortNum() + 1 + "");
                    datas.get(position).setSortNum(Integer.valueOf(finalMyViewHolder.text_number.getText().toString()));
//                    notifyDataSetChanged();
                    text_Num.setText(Integer.valueOf(text_Num.getText().toString()) + 1 + "");
                }
            });
            MyViewHolder finalMyViewHolder1 = myViewHolder;
            myViewHolder.img_jian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Integer.valueOf(finalMyViewHolder1.text_number.getText().toString()) == 0) {
                        Toast.makeText(context, "没有了！！！", Toast.LENGTH_SHORT).show();
                    } else {
                        finalMyViewHolder1.text_number.setText(Integer.valueOf(finalMyViewHolder1.text_number.getText().toString()) - 1 + "");
//                        datas.set(position,Integer.valueOf(holder.text_number.getText().toString()));
                        datas.get(position).setSortNum(Integer.valueOf(finalMyViewHolder1.text_number.getText().toString()));
//                        notifyDataSetChanged();
                        text_Num.setText(Integer.valueOf(text_Num.getText().toString()) - 1 + "");
                    }
                }
            });
            return convertView;
        }

        public class MyViewHolder {
            private ImageView img_jian;
            private ImageView img_add;
            private TextView text_number;
            private ImageView img_shop;
            private LinearLayout lin_asd;
            private TextView text_details;
            private TextView text_pay;
            private TextView text_yuanjia;
            private TextView text_size;
            private TextView text_gui;
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (lin_mall.getVisibility() == View.VISIBLE) {
                lin_mall.setVisibility(View.GONE);
            } else if (scr_mall.getVisibility() == View.VISIBLE) {
                scr_mall.setVisibility(View.GONE);
            } else {
                finish();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
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
            Log.i("datasfan", entityFan.get(positionssss).getSortNum() + "----" + MyApp.gson.toJson(entityFan));

            text_number_detail.setText(entityFan.get(positionssss).getSortNum() + "");

//总数量
            String size = data.getStringExtra("text_Num");
            text_Num.setText(size);


            if (size.equals("0")) {
                Drawable drawableRed = ContextCompat.getDrawable(ActComMall.this, R.drawable.bamgyouno);

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
}
