package com.example.YunleHui.ui.act.actme;

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
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.Bean_Calist;
import com.example.YunleHui.Bean.Bean_detail;
import com.example.YunleHui.Bean.Bean_password;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.acthome.ActComdetails;
import com.example.YunleHui.ui.act.acthome.ActPayOrder;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.widget.PasswordEditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.YunleHui.utils.Tools.mBottomSheetPop;


//充值
public class ActRecharge extends BaseAct implements View.OnClickListener, PasswordEditText.PasswordFullListener {


    private int tixian = 0;

    @BindView(R.id.text_one)
    TextView text_one;

    @BindView(R.id.text_two)
    TextView text_two;


        //    是否
    private int type_charege;


    private Bean_Calist bean_calist;
    private int code;
    private String msg;
    private boolean success;
    private List<Bean_Calist.DataBean> data;

    private ArrayList<Bean_Calist.DataBean> data_lis = new ArrayList<>();


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @BindView(R.id.text_Recharge)
    TextView text_Recharge;

    //    选中的那一项
    private int hffhfh = 0;


    private MyListAdpter myListAdpter;


    @BindView(R.id.text_choice)
    TextView text_choice;

    private LinearLayout lin_back;

    private TextView text_title;

    private TextView text_cancel;

    private TextView text_sure;

    private LinearLayout lin_pop_type;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_recharge;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("充值");
        }
        lin_back = (LinearLayout) findViewById(R.id.lin_back);
        text_title = findViewById(R.id.text_title);
        text_cancel = (TextView) findViewById(R.id.text_cancel);
        text_sure = (TextView) findViewById(R.id.text_sure);

        //        点击取消
        lin_pop_type = (LinearLayout) findViewById(R.id.lin_pop_type);
    }

    @Override
    public void initData() {



        Intent intent = getIntent();

        tixian =  intent.getIntExtra("tixian",0);


        if (tixian == 11){
            text_one.setText("提现银行卡");
            text_two.setText("提现金额");
            text_choice.setText("暂无提现方式请绑定");

            text_Recharge.setText("提现");


        }



//        text_cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                lin_back.setVisibility(View.GONE);
//            }
//        });
//        text_sure.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                lin_back.setVisibility(View.GONE);
//                startActivity(ActBankCard.class);
//            }
//        });
//        lin_pop_type.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                lin_back.setVisibility(View.GONE);
//            }
//        });
        text_title.setText("暂无提现账户，请绑定银行卡");
//        先判断这是否 有银行卡
        HttpUtil.getAsynHttp("account/listWithdrawWay?userId=" + MyApp.user);
        getdata("account/listWithdrawWay");
    }


    ListView list_Pay_method;

    @OnClick({R.id.text_choice, R.id.text_Recharge,
            R.id.text_cancel, R.id.text_sure,
            R.id.lin_pop_type,})
    public void OnClick(View view) {
        switch (view.getId()) {

            case R.id.text_cancel:

                lin_back.setVisibility(View.GONE);


                break;

            case R.id.text_sure:

                lin_back.setVisibility(View.GONE);
                startActivity(ActBankCard.class);

                break;


            case R.id.lin_pop_type:

                lin_back.setVisibility(View.GONE);

                break;

            case R.id.text_choice:
                View view_list = Tools.setRebuildPop(this, R.layout.pop_wall_list, R.layout.activity_act_recharge);
                list_Pay_method = view_list.findViewById(R.id.list_Pay_method);
                LinearLayout lin_add_Card = (LinearLayout) view_list.findViewById(R.id.lin_add_Card);

                lin_add_Card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(ActRecharge.this, "tian lin_add_Card", Toast.LENGTH_SHORT).show();

                        startActivity(ActBankCard.class);
                        Tools.mBottomSheetPop.dismiss();
                    }
                });


                LinearLayout lin_weixin = view_list.findViewById(R.id.lin_weixin);

                lin_weixin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(ActRecharge.this, "tian lin_weixin", Toast.LENGTH_SHORT).show();
                        startActivity(ActBankCard.class);
                        Tools.mBottomSheetPop.dismiss();
                    }
                });

                TextView text_click = view_list.findViewById(R.id.text_click);
                text_click.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Tools.mBottomSheetPop.dismiss();
                    }
                });

                ArrayList<String> datas = new ArrayList<>();
                datas.clear();
                for (int i = 0; i < 6; i++) {
                    datas.add("");
                }
                myListAdpter = new MyListAdpter(datas, this);
                list_Pay_method.setAdapter(myListAdpter);
                myListAdpter.setCurrentItem(hffhfh);
                myListAdpter.setClick(true);
                list_Pay_method.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        myListAdpter.setCurrentItem(i);
                        myListAdpter.setClick(true);
                        myListAdpter.notifyDataSetChanged();
                        hffhfh = i;
                    }
                });
                LinearLayout lin_pop_type = (LinearLayout) view_list.findViewById(R.id.lin_pop_type);
                lin_pop_type.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Tools.mBottomSheetPop.dismiss();
                    }
                });


                break;
//              判断是否有密码和提现密码
            case R.id.text_Recharge:
                if (text_choice.getText().toString().equals("暂无充值方式请绑定")||text_choice.getText().toString().equals("暂无提现方式请绑定")) {
                    View view_li = Tools.setRebuildPop(this, R.layout.pop_wall_list, R.layout.activity_act_recharge);
                    list_Pay_method = view_li.findViewById(R.id.list_Pay_method);
                    ArrayList<String> datass = new ArrayList<>();
                    datass.clear();
                    for (int i = 0; i < 6; i++) {
                        datass.add("");
                    }
                    myListAdpter = new MyListAdpter(datass, this);
                    list_Pay_method.setAdapter(myListAdpter);
                    myListAdpter.setCurrentItem(hffhfh);
                    myListAdpter.setClick(true);
                    list_Pay_method.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            myListAdpter.setCurrentItem(i);
                            myListAdpter.setClick(true);
                            myListAdpter.notifyDataSetChanged();
                            hffhfh = i;
                        }
                    });
                    LinearLayout lin_pop_typ = (LinearLayout) view_li.findViewById(R.id.lin_pop_type);
                    lin_pop_typ.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Tools.mBottomSheetPop.dismiss();
                        }
                    });
                    TextView text_clic = view_li.findViewById(R.id.text_click);
                    text_clic.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Tools.mBottomSheetPop.dismiss();
                        }
                    });


                    LinearLayout lin_add_Car = (LinearLayout) view_li.findViewById(R.id.lin_add_Card);

                    lin_add_Car.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Toast.makeText(ActRecharge.this, "tian lin_add_Card", Toast.LENGTH_SHORT).show();

                            startActivity(ActBankCard.class);
                            Tools.mBottomSheetPop.dismiss();
                        }
                    });


                    LinearLayout lin_weixi = view_li.findViewById(R.id.lin_weixin);

                    lin_weixi.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Toast.makeText(ActRecharge.this, "tian lin_weixin", Toast.LENGTH_SHORT).show();
                            startActivity(ActBankCard.class);
                            Tools.mBottomSheetPop.dismiss();
                        }
                    });

                } else {
                    type_charege = 0;
                    HttpUtil.addMapparams();
                    HttpUtil.params.put("userId", MyApp.user);
                    HttpUtil.Post_request("account/checkPasswordSetting", HttpUtil.params);
                    getdata("account/checkPasswordSetting");
                }
                break;
        }
    }

    private int type = 0;

    private String passwordone;

    @Override
    public void passwordFull(String password) {
        //        创建密码
        if (type_charege == 0) {
            ++type;
            if (type == 1) {
                //第一次密码输入完以后 就 清除数据
                passwordone = password;
                mPasswordEditText.setText("");
                text_passWord.setText("请再次确认支付密码");
            } else {
                String passwordtwo = password;
                if (passwordone.equals(passwordtwo)) {
//                    一致调用接口
                    HttpUtil.addMapparams();
                    HttpUtil.params.put("userId", MyApp.user);
//                    渠道
                    HttpUtil.params.put("password", password);
                    HttpUtil.Post_request("account/setPassword", HttpUtil.params);
                    getdata("account/setPassword");
//                    bottomSheetDialog.dismiss();
                    type = 0;
                    mBottomSheetPop.dismiss();
                } else {
                    Toast.makeText(ActRecharge.this, "请核对2次密码是否一致！", Toast.LENGTH_SHORT).show();
//                    bottomSheetDialog.dismiss();
                    type = 0;
                    mBottomSheetPop.dismiss();
                }
            }
        } else {
//            去充值
//            HttpUtil.addMapparams();
//            HttpUtil.params.put("userId", MyApp.user);
//            HttpUtil.params.put("orderId", order_id);
//            HttpUtil.params.put("payWay", type_pay);
////          HttpUtil.params.put("tradeAmount", Double.valueOf(text_price.getText().toString())*100);
//            HttpUtil.params.put("pwd", password);
////            HttpUtil.params.put("userOpenId", MyApp.user);
////            HttpUtil.postRaw("order/pay", HttpUtil.params);
//            HttpUtil.Post_request("order/pay", HttpUtil.params);
//            getdata("order/pay");
//            Log.i("orderididid", order_id + "----------");
            if (tixian== 11){

                Toast.makeText(ActRecharge.this,"提现",Toast.LENGTH_SHORT).show();

            }else {

                Toast.makeText(ActRecharge.this,"充值",Toast.LENGTH_SHORT).show();

            }
            mBottomSheetPop.dismiss();
        }
    }

    @Override
    public void onClick(View view) {
        if (view instanceof TextView) {
            String number = ((TextView) view).getText().toString().trim();
            mPasswordEditText.addPassword(number);
        }
        if (view instanceof ImageView) {
            mPasswordEditText.deletePassword();
        }
    }


    public class MyListAdpter extends BaseAdapter {


        private int mCurrentItem = 0;
        private boolean isClick = false;


        private ArrayList<String> datas = new ArrayList<>();

        private LayoutInflater inflater;


        public MyListAdpter(List<String> datas, Context context) {
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
            final MyViewHolder myViewHolder = new MyViewHolder();
            convertView = inflater.inflate(R.layout.item_method, parent, false);
            myViewHolder.img_choose = (ImageView) convertView.findViewById(R.id.img_choose);
//            myViewHolder.lin_item.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                }
//            });
            if (mCurrentItem == position & isClick) {
                Glide.with(ActRecharge.this).load(R.drawable.icon_choose).into(myViewHolder.img_choose);
            } else {
                Glide.with(ActRecharge.this).load(R.drawable.hui).into(myViewHolder.img_choose);
            }
            return convertView;
        }


        public class MyViewHolder {
            private ImageView img_choose;
        }

        public void setCurrentItem(int currentItem) {
            this.mCurrentItem = currentItem;
        }

        public void setClick(boolean click) {
            this.isClick = click;
        }

    }


    private Bean_password bean_password;
    private boolean success_password;
    private int code_password;
    private String msg_password;
    private Object data_password;

    private LinearLayout mKeyBoardView;
    private PasswordEditText mPasswordEditText;
    private TextView text_passWord;

    @Override
    public void StringResulit(String key, String value) {


        try {
            //银行卡列表
            if (key.equals("account/listWithdrawWay")) {
//            private Bean_Calist bean_calist;
//            private int code;
//            private String msg;
//            private boolean success;
//            private List<Bean_Calist.DataBean> data;
//            private ArrayList<Bean_Calist.DataBean> data_lis = new ArrayList<>();

                bean_calist = MyApp.gson.fromJson(value, Bean_Calist.class);
                data = bean_calist.getData();
                data_lis.clear();
                data_lis.addAll(data);
                if (null == data_lis || data_lis.size() == 0) {

                } else {
                    //            判断 是否 有 账号
                    text_choice.setText(data_lis.get(0).getInfo1());
                }

            }
        }catch (Exception er){

        }


        try {

            if (key.equals("account/checkPasswordSetting")) {
                bean_password = MyApp.gson.fromJson(value, Bean_password.class);
                code= bean_password.getCode();

                Log.i("checkPasswordSetting", "-------");

//            post_PassWord();

//            openPayPasswordDialog();

                if (code == 800103) {
                    //            设置密码
//                post_PassWord();

                    type_charege = 0;

                    openPayPasswordDialog();


                } else {
//输入密码

                    type_charege = 1;

                    openPayPasswordDialog();
                }
            }
        }catch (Exception e){

        }

    }


    private void openPayPasswordDialog() {
//        PayPasswordView payPasswordView = new PayPasswordView(this);
//        bottomSheetDialog = new BottomSheetDialog(this);
//        bottomSheetDialog.setContentView(payPasswordView);
//        bottomSheetDialog.setCanceledOnTouchOutside(false);
//        bottomSheetDialog.show();

        View view;


        if (type_charege == 0) {
            view = Tools.setRebuildPop(this, R.layout.pay_password_layout_set, R.layout.activity_act_pay_order);
        } else {
            view = Tools.setRebuildPop(this, R.layout.pay_password, R.layout.activity_act_pay_order);
        }

//        PayPasswordView.
//       Tools.mBottomSheetPop.setContentView(payPasswordView);
        mKeyBoardView = (LinearLayout) view.findViewById(R.id.keyboard);
        text_passWord = (TextView) view.findViewById(R.id.text_passWord);
        mPasswordEditText = (PasswordEditText) view.findViewById(R.id.passwordEdt);
        mPasswordEditText.setPasswordFullListener(this);
        setItemClickListener(mKeyBoardView);
    }


    /**
     * 给每一个自定义数字键盘上的View 设置点击事件
     *
     * @param view
     */
    private void setItemClickListener(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                //不断的给里面所有的View设置setOnClickListener
                View childView = ((ViewGroup) view).getChildAt(i);
                setItemClickListener(childView);
            }
        } else {
            view.setOnClickListener(this);
        }
    }





    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (Tools.mBottomSheetPop!=null){
            Tools.mBottomSheetPop.dismiss();
        }
    }




}
