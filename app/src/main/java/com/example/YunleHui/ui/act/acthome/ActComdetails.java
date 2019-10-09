package com.example.YunleHui.ui.act.acthome;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.BeanHomeList;
import com.example.YunleHui.Bean.Bean_detail;
import com.example.YunleHui.R;
import com.example.YunleHui.adpter.MyRecycleViewAdapter;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.actme.ActLogin;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.ListViewForScrollView;
import com.example.YunleHui.view.Nine.TNinePlaceGridView;
import com.example.YunleHui.view.NoScrollListView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.YunleHui.R.drawable.baqsneh;
import static com.example.YunleHui.utils.Tools.mBottomSheetPop;


public class ActComdetails extends BaseAct {

//    套餐数量
    private int NumPs;
//    @BindView(R.id.img_share)
//    ImageView img_share;

    private MyListNoRes myListNoRes;
    //    评价列表
    @BindView(R.id.list_evaluate)
    RecyclerView list_evaluate;
    public static ActComdetails actComdetails;
    @BindView(R.id.lin_back)
    LinearLayout lin_back;
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

    @BindView(R.id.banner)
    MZBannerView mzBannerView;


    @BindView(R.id.lin_shopping)
    LinearLayout lin_shopping;



    @BindView(R.id.text_buy)
    TextView text_buy;


    private int shop_id = 0;

    private Bean_detail bean_detail;
    private boolean success_detail;
    private int code_detail;
    private String msg_detail;
    private Bean_detail.DataBean data_detail;


    //banner
    private List<String> bannerUrlList;

    //套餐
    private List<Bean_detail.DataBean.GoodsSetMealListBean> goodsSetMealList;


//    附近的门店

    private List<Bean_detail.DataBean.ShopListBean> shopList;


    @BindView(R.id.text_name)
    TextView text_name;


    @BindView(R.id.text_introduce)
    TextView text_introduce;

    @BindView(R.id.text_Current_price)
    TextView text_Current_price;

    @BindView(R.id.text_Commiss)
    TextView text_Commiss;


    @BindView(R.id.text_peice)
    TextView text_peice;

    @BindView(R.id.text_time)
    TextView text_time;

    @BindView(R.id.lin_Set_meal)
    LinearLayout lin_Set_meal;


    @BindView(R.id.no_list_tao)
    NoScrollListView no_list_tao;


    @BindView(R.id.no_list_shop)
    NoScrollListView no_list_shop;


    @BindView(R.id.text_context)
    TextView text_context;


    @BindView(R.id.img)
    ImageView img;

    @BindView(R.id.img_two)
    ImageView img_two;


    @BindView(R.id.lin_home)
    LinearLayout lin_home;


    @BindView(R.id.lin_share)
    LinearLayout lin_share;


    @BindView(R.id.text_more)
    TextView text_more;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_comdetails;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            TextView textView_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            textView_center.setText("商品详情");
        }
    }

    @Override
    public void initData() {
        actComdetails = this;
        lin_back.setFocusable(true);
        lin_back.setFocusableInTouchMode(true);
        lin_back.requestFocus();
        text_peice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        Intent intent = getIntent();
        shop_id = intent.getIntExtra("shop_id", 0);
        HttpUtil.getAsynHttp("frontShop/goodsDetail?goodsId=" + shop_id);
        getdata("frontShop/goodsDetail");
        no_list_tao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                myListAdpter.setCurrentItem(i);
                myListAdpter.setClick(true);
                myListAdpter.notifyDataSetChanged();
                goodsSetId = goodsSetMealList.get(i).getId() + "";
                text_Current_price.setText(Tools.chenfa(goodsSetMealList.get(i).getPrice()) + "元");
//              原价
                text_peice.setText("原价：" + Tools.chenfa(goodsSetMealList.get(i).getOriginalPrice()) + "元");
                text_Commiss.setText("佣金" + Tools.chenfa(goodsSetMealList.get(i).getCommission()) + "元");
                text_introduce.setText(goodsSetMealList.get(i).getName());
                goodsSetId = goodsSetMealList.get(i).getId() + "";
                url = goodsSetMealList.get(i).getLogoUrl();
                content = goodsSetMealList.get(i).getName();
                price_tao = goodsSetMealList.get(i).getPrice();


                if (goodsSetMealList.get(i).getStock()==0){
                    Drawable drawable = ContextCompat.getDrawable(ActComdetails.this, R.drawable.baqsneh);
                    lin_shopping.setBackground(drawable);//使用固定大小的drawable
                    lin_shopping.setClickable(false);
                    text_buy.setText("暂无库存");
                }else {
                    lin_shopping.setClickable(true);
                    Drawable drawable = ContextCompat.getDrawable(ActComdetails.this, R.drawable.baqsne);
                    lin_shopping.setBackground(drawable);//使用固定大小的drawable
                    text_buy.setText("立即购买");
                }




            }
        });
//        获取评论的列表
        Map<Object, Object> params_order = new HashMap<>();
        params_order.clear();
        HttpUtil.addMapparams();
        params_order.put("max", 0);
//                    渠道
        params_order.put("offset", 0);
        Map<Object, Object> a = new HashMap<>();
        a.clear();
        a.put("goodsId", shop_id);
        a.put("picture", 0);
        a.put("score", 0);
        params_order.put("searchCondition", a);
        Map<Object, Object> aa = new HashMap<>();
        aa.put("date", 0);
        aa.put("star", 0);
        params_order.put("typeId", 0);

        HttpUtil.postRaw("frontShop/shop/getComment",
                params_order
        );
        getdata("frontShop/shop/getComment");

        ArrayList<String> datas = new ArrayList<>();
        datas.clear();
        for (int i = 0; i < 6; i++) {
            datas.add("");
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        list_evaluate.setLayoutManager(layoutManager);
        MyRecycleViewAdapter myRecycleViewAdapter = new MyRecycleViewAdapter(datas, this);
        list_evaluate.setAdapter(myRecycleViewAdapter);
        list_evaluate.setNestedScrollingEnabled(false);

    }

    @Override
    public void onPause() {
        super.onPause();
        mzBannerView.pause();//暂停轮播
    }

    @Override
    public void onResume() {
        super.onResume();
        mzBannerView.start();
        //开始轮播
    }


    @OnClick({R.id.lin_shopping, R.id.lin_Set_meal, R.id.lin_home, R.id.lin_share, R.id.img_share, R.id.text_more})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.lin_shopping:

                if (Tools.IsLogin(this) == 0) {
                    startActivity(new Intent(this, ActLogin.class));
                } else {
                    Intent intent = new Intent(this, ActDeterOrder.class);
                    intent.putExtra("goodsSetId", goodsSetId);
                    intent.putExtra("goodsId", goodsId);
                    intent.putExtra("name", name);
                    intent.putExtra("url", url);
                    intent.putExtra("content", content);
                    intent.putExtra("price_tao", price_tao);
                    startActivity(intent);
                }
                break;
            case R.id.lin_Set_meal:
                if (no_list_tao.getVisibility() == View.VISIBLE) {
                    no_list_tao.setVisibility(View.GONE);
                } else {
                    no_list_tao.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.lin_home:
                finish();
                break;
            case R.id.lin_share:

                break;
            case R.id.img_share:
                shareImage();
                break;
//                查看更多
            case R.id.text_more:

                startActivity(ActAllCom.class);

                break;
        }
    }

    //    分享图片
    private void shareImage() {
        HttpUtil.getAsynHttp("sell/getSellGoods?sellGoodsId=" + shop_id);
        getdata("sell/getSellGoods");
    }

    private MyListAdpteraa myListAdpteraa;

    private MyListAdpter myListAdpter;

    @Override
    public void StringResulit(String key, String value) {
        try {
            if (key.equals("frontShop/goodsDetail")) {

                bean_detail = MyApp.gson.fromJson(value, Bean_detail.class);
                data_detail = bean_detail.getData();
                bannerUrlList = data_detail.getBannerUrlList();
                List<String> result = new ArrayList<>();
                result.clear();
                result = Arrays.asList(bannerUrlList.get(0).split(","));
// 设置数据
                mzBannerView.setPages(result, new MZHolderCreator<BannerViewHolder>() {
                    @Override
                    public BannerViewHolder createViewHolder() {
                        return new BannerViewHolder();
                    }
                });
//套餐
                goodsSetMealList = data_detail.getGoodsSetMealList();
                if (goodsSetMealList.size() > 0) {
                    goodsSetId = goodsSetMealList.get(0).getId() + "";
                    url = goodsSetMealList.get(0).getLogoUrl();
                    content = goodsSetMealList.get(0).getName();
                    price_tao = goodsSetMealList.get(0).getPrice();
                    myListAdpter = new MyListAdpter(goodsSetMealList, this);
                    no_list_tao.setAdapter(myListAdpter);
                    myListAdpter.setCurrentItem(0);
                    myListAdpter.setClick(true);
                    myListAdpter.notifyDataSetChanged();
//库存
                    if (goodsSetMealList.get(0).getStock()==0){
                        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.baqsneh);
                        lin_shopping.setBackground(drawable);//使用固定大小的drawable
                        lin_shopping.setClickable(false);
                        text_buy.setText("暂无库存");
                    }
                }
                goodsId = data_detail.getId() + "";
                name = data_detail.getName();
                shopList = data_detail.getShopList();
                if (shopList.size() > 0) {
                    myListAdpteraa = new MyListAdpteraa(shopList, this);
                    no_list_shop.setAdapter(myListAdpteraa);
                }
                text_Current_price.setText(Tools.chenfa(goodsSetMealList.get(0).getPrice()) + "元");
                text_peice.setText("原价：" + Tools.chenfa(goodsSetMealList.get(0).getOriginalPrice()) + "元");
                text_Commiss.setText("佣金" + Tools.chenfa(goodsSetMealList.get(0).getCommission()) + "元");
                text_introduce.setText(goodsSetMealList.get(0).getName());
                text_name.setText(data_detail.getName());
                text_time.setText(data_detail.getGoodsEffectiveTime() + "");
                Glide.with(this).load(data_detail.getLogoUrl()).into(img);
                Glide.with(this).load(data_detail.getLogoUrl()).into(img_two);
            }
        } catch (Exception e) {

        }


        if (key.equals("frontShop/shop/getComment")) {

        }


        if (key.equals("sell/getSellGoods")) {

            View view = Tools.setRebuildPop(this, R.layout.layout_pop_vegetables, R.layout.activity_act_comdetails);
            LinearLayout lin_pop_type = (LinearLayout) view.findViewById(R.id.lin_pop_type);
            lin_pop_type.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mBottomSheetPop.dismiss();
                }
            });

        }

    }


    public class MyListAdpter extends BaseAdapter {


        private int mCurrentItem = 0;
        private boolean isClick = false;


        private ArrayList<Bean_detail.DataBean.GoodsSetMealListBean> datas = new ArrayList<>();

        private LayoutInflater inflater;


        public MyListAdpter(List<Bean_detail.DataBean.GoodsSetMealListBean> datas, Context context) {
            this.datas.clear();
            this.datas.addAll(datas);

            this.inflater = LayoutInflater.from(context);

        }


        public void setDefSelect(int position) {
            this.mCurrentItem = position;
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
            final MyViewHolder myViewHolder = new MyViewHolder();
            convertView = inflater.inflate(R.layout.item_detail, parent, false);
            myViewHolder.lin_tao = (LinearLayout) convertView.findViewById(R.id.lin_tao);
            myViewHolder.img_head = (ImageView) convertView.findViewById(R.id.img_head);
            myViewHolder.text_address = (TextView) convertView.findViewById(R.id.text_address);
            Glide.with(ActComdetails.this).load(datas.get(position).getLogoUrl()).into(myViewHolder.img_head);
            myViewHolder.text_address.setText(datas.get(position).getName());
//套餐量
            NumPs =  datas.get(position).getStock();
            if (mCurrentItem == position & isClick) {
                myViewHolder.lin_tao.setBackgroundColor(Color.parseColor("#E5E5E5"));
            } else {
                myViewHolder.lin_tao.setBackgroundColor(Color.parseColor("#F7F7F7"));
            }
            return convertView;
        }
        public class MyViewHolder {
            private LinearLayout lin_tao;
            private ImageView img_head;
            private TextView text_address;
        }
        public void setCurrentItem(int currentItem) {
            this.mCurrentItem = currentItem;
        }
        public void setClick(boolean click) {
            this.isClick = click;
        }
    }


    public class MyListAdpteraa extends BaseAdapter {


        private ArrayList<Bean_detail.DataBean.ShopListBean> datas = new ArrayList<>();

        private LayoutInflater inflater;
        private Context context;


        public MyListAdpteraa(List<Bean_detail.DataBean.ShopListBean> datas, Context context) {
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
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            MyViewHolder myViewHolder = new MyViewHolder();

            convertView = inflater.inflate(R.layout.item_shop, parent, false);

            myViewHolder.text_address = (TextView) convertView.findViewById(R.id.text_address);

            myViewHolder.img_head = (RoundedImageView) convertView.findViewById(R.id.img_head);

            myViewHolder.lin_call = (LinearLayout) convertView.findViewById(R.id.lin_call);

            myViewHolder.lin_call.setVisibility(View.VISIBLE);

            Glide.with(context).load(datas.get(position).getLogoUrl()).into(myViewHolder.img_head);

            myViewHolder.text_address.setText(datas.get(position).getName() + "  " + datas.get(position).getAddress());

            myViewHolder.lin_call.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    Uri data = Uri.parse("tel:" + datas.get(position).getPhone());
                    intent.setData(data);
                    startActivity(intent);
                }
            });

            return convertView;
        }


        public class MyViewHolder {
            private RoundedImageView img_head;
            private TextView text_address;
            private LinearLayout lin_call;
        }
    }


    public class BannerViewHolder implements MZViewHolder<String> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, String data) {
            // 数据绑定
//            mImageView.setImageResource((Integer) data);
            Glide.with(ActComdetails.this).load(data).into(mImageView);

        }
    }


//    评价的adapter


    public class MyListNoRes extends BaseAdapter {

        private String evaluationNo;
        private LayoutInflater inflater;
        private Context context;
        private ArrayList<String> datas = new ArrayList<>();

        public MyListNoRes(ArrayList<String> datas, Context context) {
            this.datas.clear();
            this.datas.addAll(datas);
            this.inflater = LayoutInflater.from(context);
            this.context = context;
        }

        //        刷新  数据
        public void clear_data(ArrayList<String> datas) {
            this.datas.clear();
            this.datas.addAll(datas);
            notifyDataSetChanged();
        }

        //        添加  数据
        public void add_data(ArrayList<String> datas) {
            this.datas.addAll(datas);
            notifyDataSetChanged();
        }

        public String getPostion() {
            return evaluationNo;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            MyViewHolder myViewHolder = null;
            if (convertView == null) {
                myViewHolder = new MyViewHolder();
                convertView = inflater.inflate(R.layout.layout_unanswered, parent, false);
                myViewHolder.ninePlaceGridView = (TNinePlaceGridView) convertView.findViewById(R.id.ninePlaceGridView);
                convertView.setTag(myViewHolder);
            } else {
                myViewHolder = (MyViewHolder) convertView.getTag();
            }
            List<Object> urls = new ArrayList<>();
            urls.clear();
            for (int i = 0; i < 6; i++) {
                urls.add(R.drawable.timg);
            }
            myViewHolder.ninePlaceGridView.setImageNames(urls);
            return convertView;
        }

        public class MyViewHolder {
            private TNinePlaceGridView ninePlaceGridView;
        }
    }


    public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {

        private LayoutInflater inflater;

        private ArrayList<String> datas = new ArrayList<>();

        private Context context;

        public MyRecycleViewAdapter(ArrayList<String> datas, Context context) {

            this.datas.clear();

            this.datas.addAll(datas);

            this.context = context;

            this.inflater = LayoutInflater.from(context);

        }


        public void clear_data(ArrayList<String> datas) {

            this.datas.clear();
            this.datas.addAll(datas);

            notifyDataSetChanged();

        }


        public void add_data(ArrayList<String> datas) {

            this.datas.addAll(datas);

            notifyDataSetChanged();

        }

        @Override
        public MyRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_unanswered, parent, false);
            return new MyRecycleViewAdapter.ViewHolder(view);

        }

        @Override
        public void onBindViewHolder(MyRecycleViewAdapter.ViewHolder holder, final int position) {


            List<Object> urls = new ArrayList<>();
            urls.clear();
            for (int i = 0; i < 6; i++) {
                urls.add(R.drawable.timg);
            }
            holder.ninePlaceGridView.setImageNames(urls);


        }

        @Override
        public int getItemCount() {
            return
                    datas.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {


            private TNinePlaceGridView ninePlaceGridView;


            public ViewHolder(View itemView) {
                super(itemView);


                ninePlaceGridView = itemView.findViewById(R.id.ninePlaceGridView);

            }
        }
    }


}
