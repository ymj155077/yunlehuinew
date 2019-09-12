package com.example.YunleHui.ui.act.acthome;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.BeanHomeList;
import com.example.YunleHui.Bean.Bean_list;
import com.example.YunleHui.R;
import com.example.YunleHui.adpter.MyRecycleViewAdapter;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.MyXrecycleview;
import com.example.YunleHui.view.NoScrollListView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


//首页 搜索

public class ActSearch extends BaseAct {

    //    区的id
    private int area_Id = 0;

    @BindView(R.id.edit_earch)
    EditText edit_earch;

    @BindView(R.id.text_search)
    TextView text_search;

    @BindView(R.id.text_area)
    TextView text_area;


    @BindView(R.id.xr_search)
    MyXrecycleview xr_search;


    private int shopClassId = 0;

    //   搜索类型
    private String foodName = "";


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    private int offset = 1;

    private int max = 10;

    private int type = 0;


    @BindView(R.id.text_sort)
    TextView text_sort;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_search;
    }

    @Override
    protected void findViews() {

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void initData() {


        Intent intent = getIntent();

        shopClassId = intent.getIntExtra("shopClassId", 0);

        foodName = intent.getStringExtra("foodName");


        if (toolbar_all != null) {
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText(foodName);
        }


        edit_earch.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // et.getCompoundDrawables()得到一个长度为4的数组，分别表示左右上下四张图片
                Drawable drawable = edit_earch.getCompoundDrawables()[2];
                //如果右边没有图片，不再处理
                if (drawable == null) {
                    return false;
                }
                //如果不是按下事件，不再处理
                if (event.getAction() != MotionEvent.ACTION_UP) {
                    return false;
                }
                if (event.getX() > edit_earch.getWidth()
                        - edit_earch.getPaddingRight()
                        - drawable.getIntrinsicWidth()) {
                    edit_earch.setText("");
                }
                return false;
            }
        });


        Tools.setManger(xr_search, ActSearch.this);


        xr_search.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                offset = 1;
                type = 0;

                HttpUtil.getAsynHttp("frontShop/goodsSearch?" +
                        "goodsName=" + foodName +
                        "&shopClassId=" + shopClassId +
                        "&shopCityId=" + "" +
                        "&shopAreaId=" + area_Id +
                        "&shopId=" + "" +
                        "&recommend=" + "" +
                        "&longitude=" + "" +
                        "&latitude=" + "" +
                        "&distance=" + "" +
                        "&sellOut=" + "" +
                        "&commission=" + "" +
                        "&expire=" + "" +
                        "&sortNum=" + "" +
                        "&salesVolume=" + "" +
                        "&offset=" + offset +
                        "&max=" + max
                );

                getdata("frontShop/goodsSearch");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xr_search.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {
                ++offset;
                type = 2;
                HttpUtil.getAsynHttp("frontShop/goodsSearch?" +
                        "goodsName=" + foodName +
                        "&shopClassId=" + shopClassId +
                        "&shopCityId=" + "" +
                        "&shopAreaId=" + area_Id +
                        "&shopId=" + "" +
                        "&recommend=" + "" +
                        "&longitude=" + "" +
                        "&latitude=" + "" +
                        "&distance=" + "" +
                        "&sellOut=" + "" +
                        "&commission=" + "" +
                        "&expire=" + "" +
                        "&sortNum=" + "" +
                        "&salesVolume=" + "" +
                        "&offset=" + offset +
                        "&max=" + max);
                getdata("frontShop/goodsSearch");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xr_search.loadMoreComplete();
                    }
                }, 1000);
            }
        });
        xr_search.refresh();
    }

    @OnClick({R.id.text_search, R.id.text_area, R.id.text_sort})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.text_search:
                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_area:
                if (window != null) {
                    window.dismiss();
                }

                HttpUtil.getAsynHttp("frontShop/getAllArea?" + "code=" + 500000);
                getdata("frontShop/getAllArea");

                break;
            case R.id.text_sort:
                if (window != null) {
                    window.dismiss();
                }
                InteSorting(text_sort);

                break;
        }
    }

    private PopupWindow window;

    //控件下方弹出窗口  全城的列表
    private void showPopupWindow2(View view1, ArrayList<Bean_list.DataBean> data_all) {
        //自定义布局，显示内容
        View view = LayoutInflater.from(ActSearch.this).inflate(R.layout.pop_area, null);
        ListView no_list_pop = view.findViewById(R.id.no_list_pop);
        MyAraeAdapter myAraeAdapter = new MyAraeAdapter(data_all, ActSearch.this);
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

    //    智能列表排序
    private void InteSorting(View view1) {
        ArrayList<String> datas = new ArrayList<>();
        datas.clear();
        datas.add("智能排序");
        datas.add("离我最近");
        datas.add("售量最高");
        datas.add("新品上线");
        //自定义布局，显示内容
        View view = LayoutInflater.from(ActSearch.this).inflate(R.layout.pop_area, null);
        ListView no_list_pop = view.findViewById(R.id.no_list_pop);
        MyZhiNengAdapter myAraeAdapter = new MyZhiNengAdapter(datas, ActSearch.this);
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


    public class MyZhiNengAdapter extends BaseAdapter {

        private ArrayList<String> datas = new ArrayList<>();
        public LayoutInflater inflater;


        public MyZhiNengAdapter(ArrayList<String> datas, Context context) {
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
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


            MyViewHolder myViewHolder = null;

            if (convertView == null) {

                myViewHolder = new MyViewHolder();
                convertView = inflater.inflate(R.layout.item_leixing, parent, false);

                myViewHolder.lin_leixing = (LinearLayout) convertView.findViewById(R.id.lin_leixing);
                myViewHolder.text_qu = (TextView) convertView.findViewById(R.id.text_qu);


                convertView.setTag(myViewHolder);
            } else {
                myViewHolder = (MyViewHolder) convertView.getTag();
            }


            myViewHolder.text_qu.setText(datas.get(position));


            myViewHolder.lin_leixing.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    text_sort.setText(datas.get(position));

                    window.dismiss();
                }
            });
            return convertView;
        }

        public class MyViewHolder {
            private LinearLayout lin_leixing;
            private TextView text_qu;
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


        if (key.equals("frontShop/getAllArea")) {
            bean_list = MyApp.gson.fromJson(value, Bean_list.class);
            data = bean_list.getData();
            data_all.clear();
            data_all.addAll(data);
//在指定位置弹出弹框
            showPopupWindow2(text_area, data_all);
        }

        try {
            if (key.equals("frontShop/goodsSearch")) {
                voListHomeList.clear();
                beanHomeList = MyApp.gson.fromJson(value, BeanHomeList.class);
                dataHomeList = beanHomeList.getData();
                voListHomeList = dataHomeList.getVoList();
                voList_allHomeList.addAll(voListHomeList);
                if (type == 0) {
                    myRecycleViewAdapter = new MyRecycleViewAdapter(voList_allHomeList, this);
                    xr_search.setAdapter(myRecycleViewAdapter);
                }
//                刷新
                else if (type == 1) {

                }
//                加载更多
                else if (type == 2) {
                    myRecycleViewAdapter.add_data(voList_allHomeList);
                    myRecycleViewAdapter.notifyDataSetChanged();
                }
            }
        } catch (Exception e) {

        }


    }


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

            MyViewHolder myViewHolder = new MyViewHolder();


            convertView = inflater.inflate(R.layout.item_area, parent, false);

            myViewHolder.lin_are = (LinearLayout) convertView.findViewById(R.id.lin_are);

            myViewHolder.text_qu = (TextView) convertView.findViewById(R.id.text_qu);


            myViewHolder.text_qu.setText(datas.get(position).getAreaName());


            myViewHolder.lin_are.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    area_Id = datas.get(position).getId();

                    type = 0;

                    xr_search.refresh();

                    text_area.setText(datas.get(position).getAreaName());

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


    public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {


        private LayoutInflater inflater;

//        private ArrayList<BeanHomeList.DataBean.VoListBean> datas = new ArrayList<>();

        private ArrayList<BeanHomeList.DataBean.VoListBean> datas = new ArrayList<>();

        private Context context;

        public MyRecycleViewAdapter(ArrayList<BeanHomeList.DataBean.VoListBean> datas, Context context) {

            this.datas.clear();

            this.datas.addAll(datas);

            this.context = context;

            this.inflater = LayoutInflater.from(context);

        }


        public void clear_data(ArrayList<BeanHomeList.DataBean.VoListBean> datas) {

            this.datas.clear();
            this.datas.addAll(datas);

            notifyDataSetChanged();

        }


        public void add_data(ArrayList<BeanHomeList.DataBean.VoListBean> datas) {

            this.datas.addAll(datas);

            notifyDataSetChanged();

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hone, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {

            holder.text_peice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);

            holder.text_peice.setText(datas.get(position).getOriginalPrice() * 0.01 + "");

//        private TextView text_shop_name;

            holder.text_shop_name.setText(datas.get(position).getName());
//
//        private TextView text_context;

            holder.text_context.setText(datas.get(position).getIntro() + "");

            holder.text_size.setText("销量" + datas.get(position).getSalesVolume() + "");

            try {
                holder.text_juli.setText(datas.get(position).getDistance());
            } catch (Exception e) {

            }
            Glide.with(context).load(datas.get(position).getLogoUrl()).into(holder.img_home);

            holder.price_down.setText(datas.get(position).getPrice() * 0.01 + "");

            holder.text_Commission.setText("佣金￥" + datas.get(position).getCommission() * 0.01 + "");
//            } catch (Exception e) {

            holder.linfood.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent intent = new Intent(context, ActComdetails.class);

                    MyApp.order_ty = 0;

                    intent.putExtra("shop_id", datas.get(position).getId());

                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return
                    datas.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private TextView text_shop_name;

            private TextView text_context;
            private ImageView img_home;

            private TextView price_down;

            private TextView text_peice;

            private TextView text_size;

            private TextView text_Commission;

            private LinearLayout linfood;

            private TextView text_juli;

            public ViewHolder(View itemView) {
                super(itemView);


                text_shop_name = (TextView) itemView.findViewById(R.id.text_shop_name);
                text_context = (TextView) itemView.findViewById(R.id.text_context);
                price_down = (TextView) itemView.findViewById(R.id.price_down);
                text_size = (TextView) itemView.findViewById(R.id.text_size);
                text_Commission = (TextView) itemView.findViewById(R.id.text_Commission);


                img_home = (ImageView) itemView.findViewById(R.id.img_home);
                text_peice = (TextView) itemView.findViewById(R.id.text_peice);


                linfood = (LinearLayout) itemView.findViewById(R.id.linfood);

                text_juli = (TextView) itemView.findViewById(R.id.text_juli);

            }
        }
    }


    private BeanHomeList beanHomeList;
    private boolean successHomeList;
    private int codeHomeList;
    private String msgHomeList;
    private BeanHomeList.DataBean dataHomeList;

    private List<BeanHomeList.DataBean.VoListBean> voListHomeList;

    private ArrayList<BeanHomeList.DataBean.VoListBean> voList_allHomeList = new ArrayList<>();


    private MyRecycleViewAdapter myRecycleViewAdapter;


}
