package com.example.YunleHui.ui.act.actme.actbusiness;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.Bean_detail;
import com.example.YunleHui.Bean.Bean_sel;
import com.example.YunleHui.Bean.Bean_xiao;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.acthome.ActComdetails;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.view.NoScrollListView;
import com.example.YunleHui.view.starttime.TimeSelectPicker;

import org.jaaksi.pickerview.topbar.DefaultTopBar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.OnClick;


//选择核销商户


public class ActSelecBus extends BaseAct {


    @BindView(R.id.text_complete)
    TextView text_complete;


    private int positionss = 0;


    private Bean_sel bean_sel;
    private boolean success;
    private int code;
    private String msg;
    private List<Bean_sel.DataBean> data;
    //  最前面的数据
    private ArrayList<Boolean> datatr = new ArrayList<>();
    //    是否是默认的全天
    private ArrayList<Boolean> dataDay = new ArrayList<>();
    //    24小时
    private ArrayList<String> datatime = new ArrayList<>();


    private ArrayList<Bean_sel.DataBean> datasss = new ArrayList<>();


    @BindView(R.id.scro_list)
    NoScrollListView scro_list;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_selec_bus;
    }

    @Override
    protected void findViews() {

        if (toolbar_all != null) {
            TextView text_center = toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("选择核销商户");
        }

    }

    @Override
    public void initData() {
        datatr.clear();
        dataDay.clear();
        datatime.clear();
        datasss.clear();
        HttpUtil.getAsynHttp("backShop/shop/linkShop");
        getdata("backShop/shop/linkShop");
    }


    @Override
    public void stringResulit(String key, String value) {
        if (key.equals("backShop/shop/linkShop")) {
            bean_sel = MyApp.gson.fromJson(value, Bean_sel.class);
            data = bean_sel.getData();

            datasss.addAll(data);

            for (int i = 0; i < datasss.size(); i++) {

                if (i == 0) {
                    datatr.add(true);
                    dataDay.add(true);
                } else {
                    datatr.add(false);
                    dataDay.add(false);
                }
                datatime.add("自定义");
            }

            myAdapterNo = new MyAdapterNo(datasss, datatr, dataDay, datatime, ActSelecBus.this);

            scro_list.setAdapter(myAdapterNo);
        }
    }


    ArrayList<Bean_xiao> datsds = new ArrayList<Bean_xiao>();


    @OnClick({R.id.text_complete})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.text_complete:
                datsds.clear();
                for (int i = 0; i < datatr.size(); i++) {
                    if (datatr.get(i)) {
                        /**
                         * shopName : 麒麟店铺
                         * id : 381
                         * startTime : 00:00
                         * endTime : 24:00
                         */

                        datsds.add(new Bean_xiao(datasss.get(i).getShopName(), datasss.get(i).getId() + "", "00:00", "00:00"));


                    }
                }
                if (datsds.size() > 0) {
                    Intent data = new Intent();

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("gates", datsds);

                    data.putExtras(bundle);

                    setResult(148, data);
                    finish();

                } else {
                    Toast.makeText(ActSelecBus.this, "至少选中一家核销商户!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    private MyAdapterNo myAdapterNo;


    public class MyAdapterNo extends BaseAdapter {


        private ArrayList<Bean_sel.DataBean> datas = new ArrayList<>();

        private ArrayList<Boolean> list = new ArrayList<>();

        private ArrayList<Boolean> dataDay = new ArrayList<>();

        private ArrayList<String> datatime = new ArrayList<>();

        private LayoutInflater inflater;


        private int mCurrentItem = 0;
        private boolean isClick = false;


        public MyAdapterNo(ArrayList<Bean_sel.DataBean> datas, ArrayList<Boolean> list, ArrayList<Boolean> dataDay, ArrayList<String> datatime, Context context) {

            this.datas.clear();
            this.datas.addAll(datas);

            this.list.clear();
            this.list.addAll(list);

            this.dataDay.clear();
            this.dataDay.addAll(dataDay);

            this.datatime.clear();
            this.datatime.addAll(datatime);

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
            return datas.size();
        }

        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            MyViewHolder myViewHolder = null;

            myViewHolder = new MyViewHolder();

            convertView = inflater.inflate(R.layout.item_bus, parent, false);

            myViewHolder.checko00 = (CheckBox) convertView.findViewById(R.id.checko00);

            myViewHolder.img_s = (CheckBox) convertView.findViewById(R.id.img_s);

            myViewHolder.text_time = (TextView) convertView.findViewById(R.id.text_time);

            myViewHolder.lin_timmmss = (LinearLayout) convertView.findViewById(R.id.lin_timmmss);

            myViewHolder.lin_choice = (LinearLayout) convertView.findViewById(R.id.lin_choice);

            myViewHolder.shop_name = (TextView) convertView.findViewById(R.id.shop_name);

            Log.i("datatr.get(position)", datatr.get(position) + "--");

            if (datatr.get(position)) {
                myViewHolder.img_s.setChecked(true);
                if (dataDay.get(position)) {
                    myViewHolder.checko00.setChecked(true);
                }

            } else {
                myViewHolder.img_s.setChecked(false);
                myViewHolder.checko00.setChecked(false);

            }


            myViewHolder.text_time.setText(datatime.get(position));


            myViewHolder.shop_name.setText(datas.get(position).getShopName());


            myViewHolder.img_s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//
//                    ArrayList<Integer> sizesss = new ArrayList<>();
//                    sizesss.clear();
//
//                    for (int i = 0; i < datatr.size(); i++) {
//                        if (datatr.get(i)) {
//                            sizesss.add(0);
//                        }
//                    }
//                    if (sizesss.size() > 1) {
                    if (b) {
                        datatr.set(position, true);
                        dataDay.set(position, true);
                    } else {
                        datatr.set(position, false);
                        dataDay.set(position, false);
                        datatime.set(position, "自定义");
                    }
                    myAdapterNo = new MyAdapterNo(datasss, datatr, dataDay, datatime, ActSelecBus.this);
                    scro_list.setAdapter(myAdapterNo);
                    myAdapterNo.notifyDataSetChanged();
//                    } else {
//                        Toast.makeText(ActSelecBus.this, "至少需要选中一家商户核销!", Toast.LENGTH_SHORT).show();
//                    }
                }
            });


            myViewHolder.checko00.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                buttonView 选中状态发生改变的那个按钮
//isChecked 表示按钮新的状态（true/false）
                    if (isChecked) {
//显示一个提示信息　　
                        Toast.makeText(ActSelecBus.this, buttonView.getText() + "选中", Toast.LENGTH_SHORT).show();

                        if (datatr.get(position)) {

                        } else {
                            datatr.set(position, true);
                        }
                        dataDay.set(position, true);


                        myAdapterNo = new MyAdapterNo(datasss, datatr, dataDay, datatime, ActSelecBus.this);

                        scro_list.setAdapter(myAdapterNo);
                        myAdapterNo.notifyDataSetChanged();


                    } else {
                        Toast.makeText(ActSelecBus.this, buttonView.getText() + "取消选中", Toast.LENGTH_SHORT).show();
                        dataDay.set(position, false);


                        myAdapterNo = new MyAdapterNo(datasss, datatr, dataDay, datatime, ActSelecBus.this);

                        scro_list.setAdapter(myAdapterNo);

                        myAdapterNo.notifyDataSetChanged();
                    }
                }
            });


            myViewHolder.lin_timmmss.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    ChooseTime(position);


                }
            });


            return convertView;
        }


        public class MyViewHolder {

            private LinearLayout lin_choice;

            private CheckBox img_s;

            private CheckBox checko00;

            private TextView text_time;

            private LinearLayout lin_timmmss;

            private TextView shop_name;


        }


        public void setCurrentItem(int currentItem) {
            this.mCurrentItem = currentItem;
        }

        public void setClick(boolean click) {
            this.isClick = click;
        }

    }


    //    时间选择器

    private void ChooseTime(int position) {

        long nowTime = System.currentTimeMillis();

        long todayStartTime = nowTime - (nowTime + TimeZone.getDefault().getRawOffset()) % (1000 * 3600 * 24);

        Log.i("sadsd", System.currentTimeMillis() + "-----");

        TimeSelectPicker mTimePicker = new TimeSelectPicker.Builder(ActSelecBus.this, TimeSelectPicker.TYPE_TIME, new TimeSelectPicker.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(TimeSelectPicker picker, Date date, Date datestart) {
//              Toast.makeText(MainActivity.this, picker.last + "", Toast.LENGTH_SHORT).show();
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                String t1 = format.format(date);
                String t2 = format.format(datestart);


//                private ArrayList<Boolean> dataDay = new ArrayList<>();
//
//                private ArrayList<String> datatime = new ArrayList<>();

                if (datatr.get(position)) {

                } else {
                    datatr.set(position, true);
                }

                dataDay.set(position, false);
                datatime.set(position, t1 + "-" + t2);


                myAdapterNo = new MyAdapterNo(datasss, datatr, dataDay, datatime, ActSelecBus.this);

                scro_list.setAdapter(myAdapterNo);
                myAdapterNo.notifyDataSetChanged();
                Toast.makeText(ActSelecBus.this, t1 + "`" + t2, Toast.LENGTH_LONG).show();


            }
        })
                // 设置不包含超出的结束时间<=
                .setContainsEndDate(false)
                // 设置时间间隔为30分钟
                .setTimeMinuteOffset(30)
//                        .setRangDate(System.currentTimeMillis(), 1577976666000L)
                .setRangDate(todayStartTime, 1577976666000L)

                .create();


        // 2018/2/5 03:14:11 - 2020/1/2 22:51:6
        Dialog pickerDialog = mTimePicker.getPickerDialog();
        pickerDialog.setCanceledOnTouchOutside(true);
        DefaultTopBar topBar = (DefaultTopBar) mTimePicker.getTopBar();
        topBar.getTitleView().setText("请选择时间");
        pickerDialog.show();
    }


}
