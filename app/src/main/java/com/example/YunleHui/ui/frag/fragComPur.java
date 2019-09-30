package com.example.YunleHui.ui.frag;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.BeanHomeList;
import com.example.YunleHui.Bean.Bean_banner;
import com.example.YunleHui.Bean.Bean_list;
import com.example.YunleHui.Bean.Bean_shequ;
import com.example.YunleHui.R;
import com.example.YunleHui.adpter.MyRecycleViewAdapter;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseFrag;
import com.example.YunleHui.ui.act.ActComPur.ActColresi;
import com.example.YunleHui.ui.act.ActComPur.ActComMall;
import com.example.YunleHui.ui.act.acthome.ActComdetails;
import com.example.YunleHui.ui.act.acthome.ActSearch;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.MyXrecycleview;
import com.example.YunleHui.view.PagerGridLayoutManager;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by admin on 2019/8/29 0029.
 * <p>
 * <p>
 * 社区购
 */

public class fragComPur extends BaseFrag implements PagerGridLayoutManager.PageListener {

    //    区的id
    private int area_Id = 0;


    @BindView(R.id.text_choose)
    TextView text_choose;


    @BindView(R.id.xre_pur)
    MyXrecycleview xre_pur;


    private MyRecycleViewAdapter myRecycleViewAdapter;


    @BindView(R.id.lin_area)
    LinearLayout lin_area;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(), clz));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_com_pur;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    private MZBannerView mMZBanner;

    private Bean_shequ bean_shequ;
    private boolean success_shequ;
    private int code_shequ;
    private String msg_shequ;
    private Bean_shequ.DataBean data_shequ;

    private Bean_shequ.DataBean.CommunityInfoCollectionBean communityInfoCollection;

    private List<Bean_shequ.DataBean.CommunityInfoCollectionBean.EntityListBean> entityList;

    private ArrayList<Bean_shequ.DataBean.CommunityInfoCollectionBean.EntityListBean> entityListAll = new ArrayList<>();


    private int offset = 1;
    private int type = 0;


    @Override
    protected void initData() {
        Tools.setManger(xre_pur, getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.shequ_head, null);
        mMZBanner = (MZBannerView) view.findViewById(R.id.banner);
        xre_pur.addHeaderView(view);

        //        获取轮播图
        HttpUtil.getAsynHttp("frontShop/getBanner?moduleType=" + 1 + "&userType=" + MyApp.userType);
        getdata("She/getBanner");

        xre_pur.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                offset = 1;
                type = 0;

                HttpUtil.addMapparams();
                HttpUtil.params.put("page", offset);
                HttpUtil.params.put("size", 10);
                HttpUtil.params.put("communityName", "");
                HttpUtil.params.put("communityAddress", "");
                HttpUtil.params.put("areaCode", "500000");
                HttpUtil.params.put("distance", -1);
                HttpUtil.params.put("longitude", -1);
                HttpUtil.params.put("latitude", -1);
                HttpUtil.params.put("customerId", "");
                HttpUtil.postRaw("community/list",
                        HttpUtil.params
                );
                getdata("community/list");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xre_pur.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {
                ++offset;
                type = 2;

                HttpUtil.addMapparams();
                HttpUtil.params.put("page", offset);
                HttpUtil.params.put("size", 10);
                HttpUtil.params.put("communityName", "");
                HttpUtil.params.put("communityAddress", "");
                HttpUtil.params.put("areaCode", "500000");
                HttpUtil.params.put("distance", -1);
                HttpUtil.params.put("longitude", -1);
                HttpUtil.params.put("latitude", -1);
                HttpUtil.params.put("customerId", "");
                HttpUtil.postRaw("community/list",
                        HttpUtil.params
                );
                getdata("community/list");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xre_pur.loadMoreComplete();
                    }
                }, 1000);
            }
        });


        xre_pur.refresh();


    }

    public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {


        private LayoutInflater inflater;

        private ArrayList<Bean_shequ.DataBean.CommunityInfoCollectionBean.EntityListBean> datas = new ArrayList<>();

        private Context context;

        public MyRecycleViewAdapter(ArrayList<Bean_shequ.DataBean.CommunityInfoCollectionBean.EntityListBean> datas, Context context) {

            this.datas.clear();

            this.datas.addAll(datas);

            this.context = context;

            this.inflater = LayoutInflater.from(context);

        }


        public void clear_data(ArrayList<Bean_shequ.DataBean.CommunityInfoCollectionBean.EntityListBean> datas) {

            this.datas.clear();
            this.datas.addAll(datas);

            notifyDataSetChanged();

        }


        public void add_data(ArrayList<Bean_shequ.DataBean.CommunityInfoCollectionBean.EntityListBean> datas) {

            this.datas.addAll(datas);

            notifyDataSetChanged();

        }

        @Override
        public MyRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wanda, parent, false);
            return new MyRecycleViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyRecycleViewAdapter.ViewHolder holder, final int position) {

//            private ImageView img_shop;
//            private TextView text_details;
//            private TextView text_address;
//            private TextView text_name;

            Glide.with(context).load(datas.get(position).getLogoUrl()).into(holder.img_shop);

            holder.text_details.setText(datas.get(position).getCommunityName());

            holder.text_address.setText(datas.get(position).getCommunityAddress());

            holder.text_name.setText(datas.get(position).getDescription());

//            holder.text_disJu.setText(datas.get(position).getDistance());

            holder.lin_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ActComMall.class);
                    intent.putExtra("communityId", datas.get(position).getId());
//                    社区代理的名字
                    intent.putExtra("agent", datas.get(position).getDescription());
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private LinearLayout lin_details;

            private ImageView img_shop;
            private TextView text_details;
            private TextView text_address;
            private TextView text_name;
            private TextView text_disJu;

            public ViewHolder(View itemView) {
                super(itemView);

                lin_details = (LinearLayout) itemView.findViewById(R.id.lin_details);

                img_shop = (ImageView) itemView.findViewById(R.id.img_shop);
                text_details = (TextView) itemView.findViewById(R.id.text_details);
                text_address = (TextView) itemView.findViewById(R.id.text_address);
                text_name = (TextView) itemView.findViewById(R.id.text_name);

            }
        }
    }


    private Bean_list bean_list;
    private boolean success;
    private int code;
    private String msg;
    private List<Bean_list.DataBean> data;

    private ArrayList<Bean_list.DataBean> data_all = new ArrayList<>();


    @Override
    public void StringResulit(String key, String value) {


        if (key.equals("community/list")) {


//            private Bean_shequ bean_shequ;
//            private boolean success_shequ;
//            private int code_shequ;
//            private String msg_shequ;
//            private Bean_shequ.DataBean data_shequ;


            bean_shequ = MyApp.gson.fromJson(value, Bean_shequ.class);
            data_shequ = bean_shequ.getData();
            communityInfoCollection = data_shequ.getCommunityInfoCollection();

            entityList = communityInfoCollection.getEntityList();

            entityListAll.clear();

            entityListAll.addAll(entityList);


            if (type == 0) {


                myRecycleViewAdapter = new MyRecycleViewAdapter(entityListAll, getActivity());

                xre_pur.setAdapter(myRecycleViewAdapter);


            } else {

                myRecycleViewAdapter.add_data(entityListAll);
                myRecycleViewAdapter.notifyDataSetChanged();

            }


        }


        try {
            //        获取 banner 图
            if (key.equals("She/getBanner")) {
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


        if (key.equals("frontShop/getAllArea")) {
            bean_list = MyApp.gson.fromJson(value, Bean_list.class);
            data = bean_list.getData();
            data_all.clear();
            data_all.addAll(data);
//在指定位置弹出弹框
            showPopupWindow2(text_choose, data_all);
        }


    }

    private int mTotal = 0;
    private int mCurrent = 0;
    private Bean_banner bean_banner;
    private boolean success_banner;
    private int code_banner;
    private String msg_banner;
    private Bean_banner.DataBean data_banner;
    private List<Bean_banner.DataBean.VoListBean> voList_banner;
    private ArrayList<Bean_banner.DataBean.VoListBean> voList_banner_all = new ArrayList<>();


    @Override
    public void onPageSizeChanged(int pageSize) {
        mTotal = pageSize;
        Log.e("pageIndex", "总页数 = " + pageSize);
    }

    @Override
    public void onPageSelect(int pageIndex) {
        mCurrent = pageIndex;
        Log.e("pageIndex", "选中页码 = " + pageIndex);
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

    @OnClick({R.id.lin_area})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.lin_area:


                HttpUtil.getAsynHttp("frontShop/getAllArea?" + "code=" + 500000);

                getdata("frontShop/getAllArea");


                break;
        }
    }


    //控件下方弹出窗口  全城的列表
    private void showPopupWindow2(View view1, ArrayList<Bean_list.DataBean> data_all) {
        //自定义布局，显示内容
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.pop_areaaa, null);
        ListView no_list_pop = view.findViewById(R.id.no_list_pop);
        MyAraeAdapter myAraeAdapter = new MyAraeAdapter(data_all, getActivity());
        no_list_pop.setAdapter(myAraeAdapter);
        window = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        window.setTouchable(true);
        window.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                //这里如果返回true的话，touch事件将被拦截
                //拦截后 PoppWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        //（注意一下！！）如果不设置popupWindow的背景，无论是点击外部区域还是Back键都无法弹框
        window.setBackgroundDrawable(null);

        window.showAsDropDown(view1);

    }

    private PopupWindow window;

    public class MyAraeAdapter extends BaseAdapter {

        private ArrayList<Bean_list.DataBean> datas = new ArrayList<>();
        private LayoutInflater inflater;


        public MyAraeAdapter(ArrayList<Bean_list.DataBean> datas, Context context) {
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

            MyAraeAdapter.MyViewHolder myViewHolder = new MyAraeAdapter.MyViewHolder();


            convertView = inflater.inflate(R.layout.item_area, parent, false);

            myViewHolder.lin_are = (LinearLayout) convertView.findViewById(R.id.lin_are);

            myViewHolder.text_qu = (TextView) convertView.findViewById(R.id.text_qu);


            myViewHolder.text_qu.setText(datas.get(position).getAreaName());


            myViewHolder.lin_are.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    area_Id = datas.get(position).getId();

                    type = 0;

                    xre_pur.refresh();

                    text_choose.setText(datas.get(position).getAreaName());

                    window.dismiss();
                }
            });
            return convertView;
        }

        public class MyViewHolder {

            private TextView text_qu;

            private LinearLayout lin_are;
        }
    }


}
