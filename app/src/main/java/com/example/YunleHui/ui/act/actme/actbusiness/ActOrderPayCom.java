package com.example.YunleHui.ui.act.actme.actbusiness;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.view.NoScrollListView;
import com.example.YunleHui.view.datePicker.DoubleTimeSelectDialog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 下单支付 社区购
 */

public class ActOrderPayCom extends BaseAct implements CompoundButton.OnCheckedChangeListener {


    @BindView(R.id.no_list)
    NoScrollListView no_list;


    //  配送方式 选择
    @BindView(R.id.lin_pay_type)
    LinearLayout lin_pay_type;


    @BindView(R.id.lin_pay)
    LinearLayout lin_pay;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_order_pay_deli;
    }

    @Override
    protected void findViews() {


        if (toolbar_all!=null){
            TextView textView = toolbar_all.findViewById(R.id.toolbar_center);
            textView.setText("下单支付");
        }



        checkBoxes[0] = (RadioButton) findViewById(R.id.radio00);
        checkBoxes[1] = (RadioButton) findViewById(R.id.radio01);
        checkBoxes[2] = (RadioButton) findViewById(R.id.radio02);
        checkBoxes[3] = (RadioButton) findViewById(R.id.radio03);


        checkBoxes[0].setOnCheckedChangeListener(this);
        checkBoxes[1].setOnCheckedChangeListener(this);
        checkBoxes[2].setOnCheckedChangeListener(this);
        checkBoxes[3].setOnCheckedChangeListener(this);











//        radio_order = (RadioGroup) findViewById(R.id.radio_order);
    }

//    private RadioGroup radio_order;

    @BindView(R.id.text_start)
    TextView text_start;

    @BindView(R.id.text_end)
    TextView text_end;



    private String [] stringCkeck = {"门店自提","社区店自提","商家配送","社区点配送"};

    private RadioButton[] checkBoxes = new RadioButton[4];

    @Override
    public void initData() {

//        radio_order.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
//                    case R.id.radio00:
//
//                        lin_pay_type.setVisibility(View.GONE);
//
//                        Toast.makeText(ActOrderPayCom.this, "门店自取", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.radio01:
//
//                        lin_pay_type.setVisibility(View.VISIBLE);
//
//                        Toast.makeText(ActOrderPayCom.this, "社区自提", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.radio02:
//                        Toast.makeText(ActOrderPayCom.this, "商家配送", Toast.LENGTH_SHORT).show();
//                        break;
//
//
//                    case R.id.radio03:
//
//                        Toast.makeText(ActOrderPayCom.this, "社区点配送", Toast.LENGTH_SHORT).show();
//                        break;
//
//
//                }
//            }
//        });


        ArrayList<String> datas = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            datas.add("");
        }


        MyListAdapter myListAdapter = new MyListAdapter(datas, this);


        no_list.setAdapter(myListAdapter);


    }


    @OnClick({R.id.lin_pay})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.lin_pay:

                showCustomTimePicker();

                break;
        }
    }

    /**
     * 默认的周开始时间，格式如：yyyy-MM-dd
     **/
    public String defaultWeekBegin;
    /**
     * 默认的周结束时间，格式如：yyyy-MM-dd
     */
    public String defaultWeekEnd;

    private DoubleTimeSelectDialog mDoubleTimeSelectDialog;

    public void showCustomTimePicker() {
        String beginDeadTime = "2017-01-01";
        if (mDoubleTimeSelectDialog == null) {
            mDoubleTimeSelectDialog = new DoubleTimeSelectDialog(this, beginDeadTime, defaultWeekBegin, defaultWeekEnd);
            mDoubleTimeSelectDialog.setOnDateSelectFinished(new DoubleTimeSelectDialog.OnDateSelectFinished() {
                @Override
                public void onSelectFinished(String startTime, String endTime) {


//                    text_time.setText(startTime.replace("-", ".") + "至\n" + endTime.replace("-", "."));


                    text_start.setText(startTime.replace("-", "."));

                    text_end.setText(endTime.replace("-", "."));

                }
            });

            mDoubleTimeSelectDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                }
            });
        }
        if (!mDoubleTimeSelectDialog.isShowing()) {
            mDoubleTimeSelectDialog.recoverButtonState();
            mDoubleTimeSelectDialog.show();
        }
    }



    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b) {
            for (int i = 0; i < checkBoxes.length; i++) {
                //不等于当前选中的就变成false
                if (checkBoxes[i].getText().toString().equals(compoundButton.getText().toString())) {
                    checkBoxes[i].setChecked(true);

                    if (checkBoxes[i].getText().toString().equals("门店自提")){

                        lin_pay_type.setVisibility(View.GONE);

                    }

                    if (checkBoxes[i].getText().toString().equals("社区点自提")){

                        lin_pay_type.setVisibility(View.GONE);

                    }

                    if (checkBoxes[i].getText().toString().equals("商家配送")){

                        lin_pay_type.setVisibility(View.VISIBLE);

                    }

                    if (checkBoxes[i].getText().toString().equals("社区点配送")){

                        lin_pay_type.setVisibility(View.VISIBLE);

                    }

                    Toast.makeText(ActOrderPayCom.this,compoundButton.getText().toString(),Toast.LENGTH_SHORT).show();


                } else {
                    checkBoxes[i].setChecked(false);
                }
            }
        }
    }


    public class MyListAdapter extends BaseAdapter {

        private ArrayList<String> datas = new ArrayList<>();

        private LayoutInflater inflater;

        private Context context;

        public MyListAdapter(ArrayList<String> datas, Context context) {
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

            MyViewHolder myViewHolder = null;

            if (convertView == null) {
                myViewHolder = new MyViewHolder();
                convertView = inflater.inflate(R.layout.item_com, parent, false);

                convertView.setTag(myViewHolder);
            } else {
                myViewHolder = (MyViewHolder) convertView.getTag();
            }


            return convertView;
        }


        public class MyViewHolder {


        }


    }


}
