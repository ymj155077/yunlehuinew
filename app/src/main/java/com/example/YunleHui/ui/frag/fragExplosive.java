package com.example.YunleHui.ui.frag;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.BeanHomeList;
import com.example.YunleHui.Bean.Bean_banner;
import com.example.YunleHui.Bean.Bean_cai;
import com.example.YunleHui.Bean.Bean_cityList;
import com.example.YunleHui.R;
import com.example.YunleHui.adpter.MyRecycleViewAdapter;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseFrag;
import com.example.YunleHui.ui.act.ActComPur.ActColresi;
import com.example.YunleHui.ui.act.actReper.ActRepers;
import com.example.YunleHui.ui.act.acthome.ActCityList;
import com.example.YunleHui.ui.act.acthome.ActSearch;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.MyXrecycleview;
import com.example.YunleHui.view.PagerGridLayoutManager;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static android.app.Activity.RESULT_CANCELED;
import static com.example.YunleHui.appManager.MyApp.CityName;
import static com.example.YunleHui.appManager.MyApp.city_Id;


/*
 * 爆款
 * */


public class fragExplosive extends BaseFrag implements PagerGridLayoutManager.PageListener {


    private int offset = 1;
    private int max = 10;
    private int type = 0;
    private int shopClassId = -1;
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


    @BindView(R.id.lin_sao)
    LinearLayout lin_sao;

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
        lin_search = (LinearLayout) view.findViewById(R.id.lin_search);


        text_choose = view.findViewById(R.id.text_choose);
    }

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation != null) {
                if (aMapLocation.getErrorCode() == 0) {
                    aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                    aMapLocation.getLatitude();//获取纬度
                    aMapLocation.getLongitude();//获取经度
                    aMapLocation.getAccuracy();//获取精度信息
                    aMapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                    aMapLocation.getCountry();//国家信息
                    aMapLocation.getProvince();//省信息
                    aMapLocation.getCity();//城市信息
                    aMapLocation.getDistrict();//城区信息
                    aMapLocation.getStreet();//街道信息
                    aMapLocation.getStreetNum();//街道门牌号信息
                    aMapLocation.getCityCode();//城市编码
                    aMapLocation.getAdCode();//地区编码
                    aMapLocation.getAoiName();//获取当前定位点的AOI信息
                    aMapLocation.getBuildingId();//获取当前室内定位的建筑物Id
                    aMapLocation.getFloor();//获取当前室内定位的楼层
                    aMapLocation.getGpsAccuracyStatus();//获取GPS的当前状态
//获取定位时间
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date(aMapLocation.getTime());
                    df.format(date);
//可在其中解析amapLocation获取相应内容。
                    Log.i("CityName", aMapLocation.getCity() + "---" +
                            aMapLocation.getLatitude() + "---" +
                            aMapLocation.getLongitude());
                    if (CityName == null) {
                        text_choose.setText(CityName);
                    }
                    String Latitudess = (String) MyApp.getSharedPreference(getActivity(), "Latitude", "");

                    if (CityName != null && CityName.length() > 0) {

                        if (MyApp.Latitude.equals(Latitudess + "")) {
//                            MyApp.putSharedPreference(getActivity(), "CityName", aMapLocation.getCity() + "");
//                            //获取纬度
//                            MyApp.putSharedPreference(getActivity(), "Latitude", aMapLocation.getLatitude() + "");
//                            //获取经度
//                            MyApp.putSharedPreference(getActivity(), "Longitude", aMapLocation.getLongitude() + "");


                        } else {

                            View view_ = Tools.setRebuildPop(getActivity(), R.layout.pop_home_view, R.layout.frag_explosive);

                            TextView text_cijd = (TextView) view_.findViewById(R.id.text_cijd);

                            TextView text_cancel = (TextView) view_.findViewById(R.id.text_cancel);

                            text_cancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Tools.mBottomSheetPop.dismiss();
                                }
                            });


                            TextView text_Sure = (TextView) view_.findViewById(R.id.text_Sure);

                            text_Sure.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    MyApp.putSharedPreference(getActivity(), "CityName", aMapLocation.getCity() + "");
                                    //获取纬度
                                    MyApp.putSharedPreference(getActivity(), "Latitude", aMapLocation.getLatitude() + "");
                                    //获取经度
                                    MyApp.putSharedPreference(getActivity(), "Longitude", aMapLocation.getLongitude() + "");

                                    MyApp.Longitude = (String) MyApp.getSharedPreference(getActivity(), "Latitude", "");

                                    MyApp.Latitude = (String) MyApp.getSharedPreference(getActivity(), "Longitude", "");

                                    MyApp.CityName = (String) MyApp.getSharedPreference(getActivity(), "CityName", "");

                                    text_cijd.setText(aMapLocation.getCity());

                                    xr_explosive.refresh();
                                }
                            });

                            LinearLayout lin_pop_type = (LinearLayout) view_.findViewById(R.id.lin_pop_type);
                            lin_pop_type.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Tools.mBottomSheetPop.dismiss();
                                }
                            });
                        }
                    } else {
                        MyApp.putSharedPreference(getActivity(), "CityName", aMapLocation.getCity() + "");
                        //获取纬度
                        MyApp.putSharedPreference(getActivity(), "Latitude", aMapLocation.getLatitude() + "");
                        //获取经度
                        MyApp.putSharedPreference(getActivity(), "Longitude", aMapLocation.getLongitude() + "");
                        text_choose.setText(aMapLocation.getCity());
                    }
                } else {
                    //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                    Log.e("AmapError", "location Error, ErrCode:"
                            + aMapLocation.getErrorCode() + ", errInfo:"
                            + aMapLocation.getErrorInfo());
                }
            }
        }
    };

    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;

    @Override
    protected void initData() {
        //        轮播图
        Log.i("onResume", CityName + "-----" + city_Id);
//        获取轮播图
        HttpUtil.getAsynHttp("frontShop/getBanner?moduleType=" + 1 + "&userType=" + MyApp.userType);
        getdata("frontShop/getBanner");
//获取商家分类列表
        HttpUtil.addMapparams();
//      HttpUtil.params.put("userId", MyApp.user);
        HttpUtil.getAsynHttp("frontShop/allClass?userId=" + MyApp.user);
        getdata("frontShop/allClass");
        Tools.setManger(xr_explosive, getActivity());
        if (CityName != null) {
            text_choose.setText(CityName);
        }
        mLocationClient = new AMapLocationClient(getActivity());
        mLocationClient.setLocationListener(mLocationListener);
        mLocationOption = new AMapLocationClientOption();
        AMapLocationClientOption option = new AMapLocationClientOption();
        option.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.SignIn);
        if (null != mLocationClient) {
            mLocationClient.setLocationOption(option);
            mLocationClient.stopLocation();
            mLocationClient.startLocation();
        }
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
        mLocationOption.setOnceLocation(true);
        mLocationOption.setOnceLocationLatest(true);
        mLocationOption.setNeedAddress(true);
        mLocationClient.setLocationOption(mLocationOption);
        mLocationClient.startLocation();

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_head, null);

        mMZBanner = (MZBannerView) view.findViewById(R.id.banner);

        grid_rv = (RecyclerView) view.findViewById(R.id.grid_rv);

        xr_explosive.addHeaderView(view);

        xr_explosive.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                offset = 1;
                type = 0;
                HttpUtil.getAsynHttp("frontShop/recommendGoods?" +
                        "longitude=" + MyApp.Longitude +
                        "&latitude=" + MyApp.Latitude +
                        "&shopClassId=" + shopClassId +
                        "&shopCityId=" + MyApp.city_Id +
                        "&offset=" + offset +
                        "&max=" + max
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
                ++offset;
                type = 2;
                HttpUtil.getAsynHttp("frontShop/recommendGoods?" +
                        "longitude=" + MyApp.Longitude +
                        "&latitude=" + MyApp.Latitude +
                        "&shopClassId=" + shopClassId +
                        "&shopCityId=" + MyApp.city_Id +
                        "&offset=" + offset +
                        "&max=" + max
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

                Intent intent = new Intent(getActivity(), ActSearch.class);

                intent.putExtra("foodName", "全部");

                startActivity(intent);

            }
        });


        text_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent Intent = new Intent(getActivity(), ActCityList.class);

                startActivityForResult(Intent, Activity.RESULT_FIRST_USER);
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
//      mMZBanner.pause();//暂停轮播
    }


    @Override
    public void onResume() {
        super.onResume();
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
                if (type == 0) {
                    myRecycleViewAdapter = new MyRecycleViewAdapter(voList_all, getActivity());
                    xr_explosive.setAdapter(myRecycleViewAdapter);
                } else {
                    myRecycleViewAdapter.add_data(voList_all);
                    myRecycleViewAdapter.notifyDataSetChanged();
                }
            }
        } catch (Exception e) {

        }

        try {
            //        商品列表
            if (key.equals("frontShop/allClass")) {
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


                mAdapter.setCurrentItem(0);
                mAdapter.setClick(true);
                mAdapter.notifyDataSetChanged();


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
                    mMZBanner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
                        @Override
                        public void onPageClick(View view, int position) {
                            Toast.makeText(getActivity(), "click page:" + position, Toast.LENGTH_LONG).show();
                            if (position == 0) {
//欢迎加入成为社区团长
                                startActivity(ActColresi.class);
                            }
                        }
                    });
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


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Activity.RESULT_FIRST_USER) {
            try {
                if (resultCode == RESULT_CANCELED) {
                    Bundle bundle = data.getExtras();
                    city_Id = bundle.getInt("city_Id");
                    CityName = bundle.getString("CityName");
                    text_choose.setText(CityName);
                    xr_explosive.refresh();
                } else
                /**
                 * 处理二维码扫描结果
                 */
                    if (requestCode == REQUEST_CODE) {
                        //处理扫描结果（在界面上显示）
                        if (null != data) {
                            Bundle bundle = data.getExtras();
                            if (bundle == null) {
                                return;
                            }
                            if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                                String result = bundle.getString(CodeUtils.RESULT_STRING);
                                Toast.makeText(getActivity(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                            } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                                Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
            } catch (Exception e) {

            }
        }
    }


    @OnClick({R.id.lin_sao})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.lin_sao:
                startActivity(ActRepers.class);
//              RxPermissions.getInstance(getActivity())
//                        .requestEach( Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                                Manifest.permission.READ_EXTERNAL_STORAGE,
//                                Manifest.permission.CAMERA
//                        )
//                        .subscribe(new Action1<Permission>() {
//                            @Override
//                            public void call(Permission permission) {
//                                if (permission.name.equals(Manifest.permission.CAMERA)) {
//
//                                    Log.i("permissions", Manifest.permission.CAMERA + "：" + permission.granted);
//
//                                    Intent intent = new Intent(getActivity(), CaptureActivity.class);
//                                    startActivityForResult(intent, REQUEST_CODE);
//
//                                }
//                            }
//                        });
                break;
        }
    }

    /**
     * 扫描跳转Activity RequestCode
     */
    public static final int REQUEST_CODE = 111;

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        ArrayList<Bean_cai.DataBean> data = new ArrayList<>();

        private Context context;

        private int mCurrentItem = 0;
        private boolean isClick = false;

        private int id;

        public MyAdapter(ArrayList<Bean_cai.DataBean> datas, Context context) {
            this.data.clear();
            this.data.addAll(datas);
            this.context = context;
        }


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //    Log.i("GCS", "onCreateViewHolder");
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.layout_item, parent, false);
            return new MyViewHolder(view);
        }

        public void setCurrentItem(int currentItem) {
            this.mCurrentItem = currentItem;
        }


        public void setClick(boolean click) {
            this.isClick = click;
        }


        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            if (mCurrentItem == position & isClick) {
                holder.tv_title.setTextColor(Color.parseColor("#FF6C4B"));
                holder.tv_title.setTextSize(16);
            } else {
                holder.tv_title.setTextColor(Color.parseColor("#181931"));
                holder.tv_title.setTextSize(14);
            }
            //   Log.i("GCS","onBindViewHolder = "+position);
            final String title = data.get(position).getClassName();
            holder.tv_title.setText(title);

            Glide.with(context).load(data.get(position).getClassLogoUrl()).into(holder.round_me);


            id = data.get(position).getId();


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAdapter.setCurrentItem(position);
                    mAdapter.setClick(true);
                    mAdapter.notifyDataSetChanged();
//                Toast.makeText(v.getContext(), "item" + title + " 被点击了" + "---" + data.get(position).getId(), Toast.LENGTH_SHORT).show();
//                holder.tv_title.setText("G "+title);
//                notifyItemChanged(position);
//                Intent intent = new Intent(context,ActSearch.class);
//                intent.putExtra("shopClassId",data.get(position).getId());
//                intent.putExtra("foodName",data.get(position).getClassName());
//                context.startActivity(intent);

                    shopClassId = data.get(position).getId();
                    xr_explosive.refresh();

                    Log.i("GCS", "onBindViewHolder = " + data.get(position).getId() + "---" + shopClassId);

                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv_title;
            RoundedImageView round_me;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv_title = (TextView) itemView.findViewById(R.id.tv_title);
                round_me = (RoundedImageView) itemView.findViewById(R.id.round_me);
            }
        }
    }


}
