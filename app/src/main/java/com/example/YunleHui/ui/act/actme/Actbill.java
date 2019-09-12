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

import com.example.YunleHui.Bean.Bean_bill;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.view.timepick.WeekCalendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;


/**
 * 账单
 */

public class Actbill extends BaseAct {





    private Bean_bill bean_bill;
    private boolean success;
    private int code;
    private String msg;
    private Bean_bill.DataBean data;

    private List<Bean_bill.DataBean.VoListBean> voList;

    private ArrayList<Bean_bill.DataBean.VoListBean> voList_all = new ArrayList<>();




    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    private WeekCalendar weekCalendar;//自定义日历控件


    @BindView(R.id.lis_bill)
    ListView lis_bill;


    private MyAdapter myAdapter;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_actbill;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            TextView text_center = toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("账单");
        }
        weekCalendar = (WeekCalendar) findViewById(R.id.week_calendar);
    }

    @Override
    public void initData() {

        Map<Object, Object> params_order = new HashMap<>();

        params_order.clear();

        HttpUtil.addMapparams();

        params_order.put("max", 10);

        params_order.put("offset", 1);

        Map<Object, Object> a = new HashMap<>();
        a.clear();
        a.put("beginDate", "");
        a.put("endDate", "");
        a.put("userId", MyApp.user);
        params_order.put("searchCondition", a);

        Map<Object, Object> aa = new HashMap<>();
        aa.clear();
        aa.put("id", 0);
        params_order.put("sortCondition", aa);

        HttpUtil.postRaw("account/searchAccountLog",
                params_order
        );
        getdata("account/searchAccountLog");


//        ArrayList<String> list = new ArrayList<>();
//        list.add("2016-09-13");
//        list.add("2016-10-13");
//        list.add("2016-10-11");
//        list.add("2016-10-10");
//        list.add("2016-10-16");
//        weekCalendar.setSelectDates(list);
        //设置日历点击事件
        weekCalendar.setOnDateClickListener(new WeekCalendar.OnDateClickListener() {
            @Override
            public void onDateClick(String time) {
                Toast.makeText(Actbill.this, time, Toast.LENGTH_SHORT).show();
            }
        });

        weekCalendar.setOnCurrentMonthDateListener(new WeekCalendar.OnCurrentMonthDateListener() {
            @Override
            public void onCallbackMonthDate(String year, String month) {
                Toast.makeText(Actbill.this, year + "-" + month, Toast.LENGTH_SHORT).show();
            }
        });






    }


    public class MyAdapter extends BaseAdapter {

        public ArrayList<Bean_bill.DataBean.VoListBean> datas = new ArrayList<>();

        private LayoutInflater inflater;

        private Context context;

        public MyAdapter(ArrayList<Bean_bill.DataBean.VoListBean> datas, Context context) {
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
        public View getView(int position, View convertView, ViewGroup parent) {

            MyViewHolder myViewHolder = new MyViewHolder();

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.item_bill, parent, false);

                myViewHolder.text_name = (TextView) convertView.findViewById(R.id.text_name);

                myViewHolder.text_price = (TextView) convertView.findViewById(R.id.text_price);

                myViewHolder.text_time = (TextView) convertView.findViewById(R.id.text_time);


                convertView.setTag(myViewHolder);
            } else {
                myViewHolder = (MyViewHolder) convertView.getTag();
            }





            int out = datas.get(position).getInOut();
//收入
            if (out==0){
                myViewHolder.text_price.setTextColor(context.getResources().getColor(R.color.login));
                myViewHolder.text_price.setText("+"+datas.get(position).getTradeAmount()*0.01+"");

            }else
//                支出
                {
                    myViewHolder.text_price.setText("-"+datas.get(position).getTradeAmount()*0.01+"");
            }

            myViewHolder.text_name.setText(datas.get(position).getTradeDesc());

myViewHolder.text_time.setText(datas.get(position).getTradeTime());


            return convertView;
        }

        public class MyViewHolder {


            private TextView text_name;
            private TextView text_time;
            private TextView text_price;

        }
    }

    @Override
    public void StringResulit(String key, String value) {
try {
    if (key.equals("account/searchAccountLog")) {
//            private Bean_bill bean_bill;
//            private boolean success;
//            private int code;
//            private String msg;
//            private Bean_bill.DataBean data;
//            private List<Bean_bill.DataBean.VoListBean> voList;
//            private ArrayList<Bean_bill.DataBean.VoListBean> voList_all = new ArrayList<>();
        bean_bill = MyApp.gson.fromJson(value,Bean_bill.class);
        data = bean_bill.getData();
        voList = data.getVoList();
        voList_all.clear();
        voList_all.addAll(voList);

        myAdapter = new MyAdapter(voList_all, Actbill.this);

        lis_bill.setAdapter(myAdapter);





    }
}catch (Exception e){

}


    }


}
