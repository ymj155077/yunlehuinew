package com.example.YunleHui.ui.act.ActComPur;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.actme.ActRecharge;
import com.example.YunleHui.ui.act.actme.actbusiness.ActBusDetails;
import com.example.YunleHui.ui.act.actme.actbusiness.ActOrderPayCom;
import com.example.YunleHui.ui.frag.fragComPur;
import com.example.YunleHui.ui.frag.fragExplosive;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.HorizontalListView;
import com.example.YunleHui.view.MyXrecycleview;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 社区商城
 */


public class ActComMall extends BaseAct {


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

    @Override
    public void initData() {


        View view = LayoutInflater.from(this).inflate(R.layout.layout_caidan, null);



        TextView text_shop = (TextView) view.findViewById(R.id.text_shop);


        text_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ActNearMer.class);
            }
        });





        HorizontalListView list_cai = (HorizontalListView) view.findViewById(R.id.list_cai);

        ArrayList<String> datas = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            datas.add("");
        }


        myListAdapter = new MyListAdapter(datas, this);


        list_cai.setAdapter(myListAdapter);


        myListAdapter.setCurrentItem(hffhfh);
        myListAdapter.setClick(true);
        list_cai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                myListAdapter.setCurrentItem(i);
                myListAdapter.setClick(true);
                myListAdapter.notifyDataSetChanged();
                hffhfh = i;
            }
        });


        ArrayList<String> imgs
                = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567229180286&di=fe953e1fe96ffa6556cfd9c717e3c7a4&imgtype=0&src=http%3A%2F%2Fmmbiz.qpic.cn%2Fmmbiz%2FMTQFkr8uzAktEt5nrK2YITeSFQyUqVTUVbfibNzqjwaaDCvtlll9DiaHJRoD4uZ2foXSfGn7ajvyXCNwP7iadBj3g%2F0");
        }
        MZBannerView mMZBanner = (MZBannerView) view.findViewById(R.id.banner);
        // 设置数据
        mMZBanner.setPages(imgs, new MZHolderCreator<fragExplosive.BannerViewHolder>() {
            @Override
            public fragExplosive.BannerViewHolder createViewHolder() {
                return new fragExplosive.BannerViewHolder();
            }
        });

        mMZBanner.start();//开始轮播

        xre_mall.addHeaderView(view);

        Tools.setManger(xre_mall, this);



        ArrayList<Integer> dats = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            dats.add(0);
        }



        MyRecycleViewAdapter myRecycleViewAdapter = new MyRecycleViewAdapter(dats, this);

        xre_mall.setAdapter(myRecycleViewAdapter);







//        购物车 弹窗
        ArrayList<String> datass = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            datass.add("");
        }
        MyGouAdapter myGouAdapter = new MyGouAdapter(datass, this);

        list_gou.setAdapter(myGouAdapter);

    }


    @OnClick({R.id.lin_boom_gou, R.id.lin_pop_type,R.id.lin_ok})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.lin_boom_gou:
                if (lin_mall.getVisibility() == View.GONE) {
                    lin_mall.setVisibility(View.VISIBLE);
                } else {
                    lin_mall.setVisibility(View.GONE);
                }
                break;
            case R.id.lin_pop_type:
                lin_mall.setVisibility(View.GONE);
                break;
            case R.id.lin_ok:

                startActivity(ActOrderPayCom.class);

                break;
        }
    }


    private MyListAdapter myListAdapter;


    public class MyListAdapter extends BaseAdapter {


        private int mCurrentItem = 0;
        private boolean isClick = false;


        private ArrayList<String> datas = new ArrayList<>();

        private LayoutInflater inflater;

        public MyListAdapter(ArrayList<String> datas, Context context) {

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
        private LayoutInflater inflater;
        private ArrayList<Integer> datas = new ArrayList<>();
        private Context context;
        public MyRecycleViewAdapter(ArrayList<Integer> datas, Context context) {
            this.datas.clear();
            this.datas.addAll(datas);
            this.context = context;
            this.inflater = LayoutInflater.from(context);
        }
        public void clear_data(ArrayList<Integer> datas) {
            this.datas.clear();
            this.datas.addAll(datas);
            notifyDataSetChanged();
        }
        public void add_data(ArrayList<Integer> datas) {
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


            holder.text_number.setText(datas.get(position)+"");


            holder.lin_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, ActBusDetails.class));
                }
            });
            holder.img_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.text_number.setText(Integer.valueOf(holder.text_number.getText().toString()) + 1 +  "");

                    datas.set(position,Integer.valueOf(holder.text_number.getText().toString()));

                    notifyDataSetChanged();

                    text_Num.setText(Integer.valueOf(text_Num.getText().toString())+1+"");

                }
            });
            holder.img_jian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Integer.valueOf(holder.text_number.getText().toString()) == 0) {
                        Toast.makeText(context, "没有了！！！", Toast.LENGTH_SHORT).show();
                    } else {
                        holder.text_number.setText(Integer.valueOf(holder.text_number.getText().toString()) - 1 + "");

                        datas.set(position,Integer.valueOf(holder.text_number.getText().toString()));

                        notifyDataSetChanged();


                        text_Num.setText(Integer.valueOf(text_Num.getText().toString())-1+"");


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
            private LinearLayout lin_details;
            private ImageView img_jian;
            private ImageView img_add;
            private TextView text_number;
            public ViewHolder(View itemView) {
                super(itemView);
                lin_details = (LinearLayout) itemView.findViewById(R.id.lin_details);
                img_jian = (ImageView) itemView.findViewById(R.id.img_jian);
                img_add = (ImageView) itemView.findViewById(R.id.img_add);
                text_number = (TextView) itemView.findViewById(R.id.text_number);
            }
        }
    }







































    //    购物车的adpter
    public class MyGouAdapter extends BaseAdapter {


        private ArrayList<String> datas = new ArrayList<>();

        private LayoutInflater inflater;


        public MyGouAdapter(ArrayList<String> datas, Context context) {

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

            MyViewHolder myViewHolder = new MyViewHolder();


            convertView = inflater.inflate(R.layout.item_gou_list, parent, false);


            return convertView;
        }


        public class MyViewHolder {


        }


    }





}
