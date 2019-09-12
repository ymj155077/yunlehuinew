package com.example.YunleHui.ui.act.actme;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.view.timepick.WeekCalendar;

import java.util.ArrayList;

import butterknife.BindView;


/**
 *
 *
 * 提现记录
 *
 *
 * */

public class ActDisRecord extends BaseAct {



    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    private WeekCalendar weekCalendar;//自定义日历控件


    @BindView(R.id.lis_Record)
    ListView lis_Record;


    private MyAdapter myAdapter;



    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this,clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_dis_record;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            TextView text_center = toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("提现记录");
        }
        weekCalendar = (WeekCalendar) findViewById(R.id.week_calendar);
    }

    @Override
    public void initData() {
        //设置日历点击事件
        weekCalendar.setOnDateClickListener(new WeekCalendar.OnDateClickListener() {
            @Override
            public void onDateClick(String time) {
                Toast.makeText(ActDisRecord.this, time, Toast.LENGTH_SHORT).show();
            }
        });

        weekCalendar.setOnCurrentMonthDateListener(new WeekCalendar.OnCurrentMonthDateListener() {
            @Override
            public void onCallbackMonthDate(String year, String month) {
                Toast.makeText(ActDisRecord.this, year + "-" + month, Toast.LENGTH_SHORT).show();
            }
        });
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.clear();
        for (int i = 0; i < 6; i++) {
            arrayList.add("");
        }


        myAdapter = new MyAdapter(arrayList, ActDisRecord.this);

        lis_Record.setAdapter(myAdapter);
    }




    public class MyAdapter extends BaseAdapter {


        public ArrayList<String> datas = new ArrayList<>();

        private LayoutInflater inflater;


        public MyAdapter(ArrayList<String> datas, Context context) {
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
        public View getView(int position, View convertView, ViewGroup parent) {

            MyAdapter.MyViewHolder myViewHolder = new MyAdapter.MyViewHolder();


            if (convertView == null) {

                convertView = inflater.inflate(R.layout.item_bill, parent, false);


                convertView.setTag(myViewHolder);
            } else {

                myViewHolder = (MyAdapter.MyViewHolder) convertView.getTag();

            }


            return convertView;
        }


        public class MyViewHolder {


        }


    }



}
