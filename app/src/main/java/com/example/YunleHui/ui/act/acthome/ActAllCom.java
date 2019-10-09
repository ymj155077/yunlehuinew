package com.example.YunleHui.ui.act.acthome;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.actme.actbusiness.ActOrderPayCom;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.MyXrecycleview;
import com.example.YunleHui.view.Nine.TNinePlaceGridView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ActAllCom extends BaseAct implements CompoundButton.OnCheckedChangeListener {


    @BindView(R.id.recycleview)
    MyXrecycleview recycleview;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this,clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_all_com;
    }

    @Override
    protected void findViews() {
        checkBoxes[0] = (RadioButton) findViewById(R.id.radio00);
        checkBoxes[1] = (RadioButton) findViewById(R.id.radio01);
        checkBoxes[2] = (RadioButton) findViewById(R.id.radio02);
        checkBoxes[0].setOnCheckedChangeListener(this);
        checkBoxes[1].setOnCheckedChangeListener(this);
        checkBoxes[2].setOnCheckedChangeListener(this);
        if (toolbar_all!=null){
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("全部评论");
        }
    }


    private RadioButton[] checkBoxes = new RadioButton[3];
    @SuppressLint("ResourceAsColor")
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b) {
            for (int i = 0; i < checkBoxes.length; i++) {
                //不等于当前选中的就变成false
                if (checkBoxes[i].getText().toString().equals(compoundButton.getText().toString())) {
                    checkBoxes[i].setChecked(true);
                    checkBoxes[i].setTextColor(Color.parseColor("#FF5B05"));
                    Resources resources = getBaseContext().getResources();
                    Drawable drawable = resources.getDrawable(R.drawable.pinlunyes);
                    checkBoxes[i].setBackgroundDrawable(drawable);
                } else {
                    checkBoxes[i].setChecked(false);
                    Resources resources = getBaseContext().getResources();
                    Drawable drawable = resources.getDrawable(R.drawable.pinlunno);
                    checkBoxes[i].setBackgroundDrawable(drawable);
                    checkBoxes[i].setTextColor(Color.parseColor("#333333"));
                }
            }
        }
    }

    @Override
    public void initData() {

        ArrayList<String> datas = new ArrayList<>();
        datas.clear();
        for (int i = 0; i < 6; i++) {
            datas.add("");
        }

        Tools.setManger(recycleview,this);

        MyRecycleViewAdapter myRecycleViewAdapter = new MyRecycleViewAdapter(datas, this);
        recycleview.setAdapter(myRecycleViewAdapter);

        recycleview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

//                HttpUtil.getAsynHttp("frontShop/recommendGoods?" +
//                        "longitude=" + "" +
//                        "&latitude=" + "" +
//                        "&shopClassId=" + -1 +
//                        "&shopCityId=" + "" +
//                        "&offset=" + ""
//                );
//                getdata("frontShop/recommendGoods");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recycleview.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {

//                HttpUtil.getAsynHttp("frontShop/recommendGoods?" +
//                        "longitude=" + "" +
//                        "&latitude=" + "" +
//                        "&shopClassId="  +
//                        "&shopCityId=" + "" +
//                        "&offset=" + ""
//                );
//
//                getdata("frontShop/recommendGoods");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recycleview.loadMoreComplete();
                    }
                }, 1000);
            }
        });

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
            return datas.size();
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
