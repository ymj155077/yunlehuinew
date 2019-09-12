package com.example.YunleHui.ui.frag;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.BeanHomeList;
import com.example.YunleHui.Bean.Bean_banner;
import com.example.YunleHui.Bean.Bean_cai;
import com.example.YunleHui.Bean.Bean_cityList;
import com.example.YunleHui.R;
import com.example.YunleHui.adpter.MyRecycleViewAdapter;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseFrag;
import com.example.YunleHui.ui.act.acthome.ActCityList;
import com.example.YunleHui.ui.act.acthome.ActSearch;
import com.example.YunleHui.utils.GridSpacingItemDecoration;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.MyAdapter;
import com.example.YunleHui.view.MyXrecycleview;
import com.example.YunleHui.view.PagerGridLayoutManager;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.YunleHui.appManager.MyApp.cityName;
import static com.example.YunleHui.appManager.MyApp.city_Id;
import static com.example.YunleHui.appManager.MyApp.gson;
import static com.example.YunleHui.utils.HttpUtil.params;

/*
 * 爆款
 * */
public class fragExplosive extends BaseFrag implements PagerGridLayoutManager.PageListener {


    private Bean_cityList bean_cityList;
    private boolean success_cityList;
    private int code_cityList;
    private String msg_cityList;
    private List<Bean_cityList.DataBean> data_city;
    private List<Bean_cityList.DataBean> data_cityAll = new ArrayList<>();


    private Bean_banner bean_banner;
    private boolean success_banner;
    private int code_banner;
    private String msg_banner;
    private Bean_banner.DataBean data_banner;

    private List<Bean_banner.DataBean.VoListBean> voList_banner;


    private ArrayList<Bean_banner.DataBean.VoListBean> voList_banner_all = new ArrayList<>();


    private MyAdapter mAdapter;
    private Bean_cai bean_cai;
    private List<Bean_cai.DataBean> data_cai;
    //    private TextView mPageTotal;        // 总页数
//    private TextView mPageCurrent;      // 当前页数
    private RecyclerView grid_rv;
    private PagerGridLayoutManager mLayoutManager;
    private int mRows = 2;
    private int mColumns = 5;
    private int mTotal = 0;
    private int mCurrent = 0;
    private BeanHomeList beanHomeList;
    private boolean success;
    private int code;
    private String msg;
    private BeanHomeList.DataBean data;

    private List<BeanHomeList.DataBean.VoListBean> voList;

    private ArrayList<BeanHomeList.DataBean.VoListBean> voList_all = new ArrayList<>();

    private MyRecycleViewAdapter myRecycleViewAdapter;


    @BindView(R.id.xr_explosive)
    MyXrecycleview xr_explosive;


    private MZBannerView mMZBanner;

    private TextView text_choose;


    LinearLayout lin_search;


    private ImageView img_add;


    @Override
    protected int getLayoutId() {
        return R.layout.frag_explosive;
    }

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(), clz));
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        lin_search = (LinearLayout)view.findViewById(R.id.lin_search);

        img_add = (ImageView) view.findViewById(R.id.img_add);

        text_choose = view.findViewById(R.id.text_choose);
    }

    @Override
    protected void initData() {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_head, null);

        mMZBanner = (MZBannerView) view.findViewById(R.id.banner);

        grid_rv = (RecyclerView) view.findViewById(R.id.grid_rv);


        xr_explosive.addHeaderView(view);

        xr_explosive.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
//                page = 1;
//                type = 0;
//                HttpUtil.addMapparams();
//                params.put("longitude", "");
//                params.put("latitude", "");
//                params.put("shopClassId", "");
//                params.put("shopCityId", "");
//                params.put("offset", "");
//                HttpUtil.Post_request("frontShop/recommendGoods", params);

                HttpUtil.getAsynHttp("frontShop/recommendGoods?" +
                        "longitude=" + "" +
                        "&latitude=" + "" +
                        "&shopClassId=" + -1 +
                        "&shopCityId=" + "" +
                        "&offset=" + ""
                );

                getdata("frontShop/recommendGoods");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xr_explosive.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {
//                ++page;
//                type = 2;
//                HttpUtil.addMapparams();
//                params.put("longitude", "");
//                params.put("latitude", "");
//                params.put("shopClassId", "");
//                params.put("shopCityId", "");
//                params.put("offset", "");
//                HttpUtil.Post_request("frontShop/recommendGoods", params);
                HttpUtil.getAsynHttp("frontShop/recommendGoods?" +
                        "longitude=" + "" +
                        "&latitude=" + "" +
                        "&shopClassId="  +
                        "&shopCityId=" + "" +
                        "&offset=" + ""
                );

                getdata("frontShop/recommendGoods");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xr_explosive.loadMoreComplete();
                    }
                }, 1000);
            }
        });



        lin_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getActivity(),ActSearch.class);

                intent.putExtra("foodName","全部");

                startActivity(intent);

            }
        });


        text_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ActCityList.class);
            }
        });
        xr_explosive.setHasFixedSize(true);
        xr_explosive.setNestedScrollingEnabled(false);
        xr_explosive.setItemViewCacheSize(100);
        xr_explosive.refresh();
    }


    @Override
    public void onPause() {
        super.onPause();
//        mMZBanner.pause();//暂停轮播
    }


    @Override
    public void onResume() {
        super.onResume();
//        轮播图
        Log.i("onResume", cityName + "-----" + city_Id);
        if (null != cityName) {
            text_choose.setText(cityName);
        }
//        获取轮播图

        HttpUtil.getAsynHttp("frontShop/getBanner?moduleType=" + 1 + "&userType=" + MyApp.userType);
        getdata("frontShop/getBanner");
//获取商家分类列表
        HttpUtil.addMapparams();
//      HttpUtil.params.put("userId", MyApp.user);
        HttpUtil.getAsynHttp("frontShop/allClass?userId=" + MyApp.user);
        getdata("frontShop/allClass");
        Tools.setManger(xr_explosive, getActivity());
    }


    @Override
    public void StringResulit(String key, String value) {

        try {
            if (key.equals("frontShop/recommendGoods")) {
                voList_all.clear();
                beanHomeList = MyApp.gson.fromJson(value, BeanHomeList.class);
                data = beanHomeList.getData();
                voList = data.getVoList();
                voList_all.addAll(voList);
                myRecycleViewAdapter = new MyRecycleViewAdapter(voList_all, getActivity());
                xr_explosive.setAdapter(myRecycleViewAdapter);
            }
        } catch (Exception e) {

        }

        try {
            //        商品列表
            if (key.equals("frontShop/allClass")) {
//            Bean_cai
//            private boolean success;
//            private int code;
//            private String msg;
//            private List<Bean_cai.DataBean> data;
                ArrayList<Bean_cai.DataBean> data = new ArrayList<>();
                data.clear();
                bean_cai = MyApp.gson.fromJson(value, Bean_cai.class);
                data_cai = bean_cai.getData();
                data.addAll(data_cai);
                mLayoutManager = new PagerGridLayoutManager(mRows, mColumns, PagerGridLayoutManager
                        .HORIZONTAL);
                grid_rv.setLayoutManager(new GridLayoutManager(getActivity(), 5));
                // 水平分页布局管理器
                mLayoutManager.setPageListener(this);    // 设置页面变化监听器
                grid_rv.setLayoutManager(mLayoutManager);
                // 使用原生的 Adapter 即可
                mAdapter = new MyAdapter(data, getActivity());
                grid_rv.setAdapter(mAdapter);


            }
        } catch (Exception e) {

        }

        try {
            //        获取 banner 图
            if (key.equals("frontShop/getBanner")) {

//            private Bean_banner bean_banner;
//            private boolean success_banner;
//            private int code_banner;
//            private String msg_banner;
//            private Bean_banner.DataBean data_banner;

                bean_banner = MyApp.gson.fromJson(value, Bean_banner.class);

                data_banner = bean_banner.getData();

                voList_banner = data_banner.getVoList();

                voList_banner_all.clear();

                voList_banner_all.addAll(voList_banner);

                ArrayList<String> imgs = new ArrayList<>();
                imgs.clear();

                for (int i = 0; i < voList_banner_all.size(); i++) {
                    imgs.add(voList_banner_all.get(i).getUrl());
                }
                try {
                    // 设置数据
                    mMZBanner.setPages(imgs, new MZHolderCreator<BannerViewHolder>() {
                        @Override
                        public BannerViewHolder createViewHolder() {
                            return new BannerViewHolder();
                        }
                    });
                    mMZBanner.start();//开始轮播
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void onPageSizeChanged(int pageSize) {
        mTotal = pageSize;
        Log.e("TAG", "总页数 = " + pageSize);
//        mPageTotal.setText("共 " + pageSize + " 页");
    }

    @Override
    public void onPageSelect(int pageIndex) {
        mCurrent = pageIndex;
        Log.e("TAG", "选中页码 = " + pageIndex);
//        mPageCurrent.setText("第 " + (pageIndex + 1) + " 页");
    }

    public static class BannerViewHolder implements MZViewHolder<Object> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Object data) {
            // 数据绑定
//            mImageView.setImageResource( data);
            Glide.with(MyApp.context).load(data).into(mImageView);
        }
    }
}
