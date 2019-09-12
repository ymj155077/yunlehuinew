package com.example.YunleHui.ui.act.acthome;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.YunleHui.Bean.Bean_account;
import com.example.YunleHui.Bean.Bean_password;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.actme.ActMyOrder;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.widget.PasswordEditText;

import butterknife.BindView;

import static com.example.YunleHui.ui.act.acthome.ActDeterOrder.actDeterOrder;
import static com.example.YunleHui.utils.Tools.mBottomSheetPop;

//支付订单

public class ActPayOrder extends BaseAct implements View.OnClickListener, PasswordEditText.PasswordFullListener {


    @BindView(R.id.text_name)
    TextView text_name;

    //店铺名
    private String shop_name;


    //    订单id
    private int order_id = 0;

    //金额
    private String price;


    private String order = "";


    private RadioGroup radio;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    private int type_pay = 0;


    @BindView(R.id.text_pay)
    TextView text_pay;


    @BindView(R.id.text_price)
    TextView text_price;


    private Bean_password bean_password;
    private boolean success;
    private int code;
    private String msg;
    private Object data;


    private Bean_account bean_account;
    private boolean success_account;
    private int code_account;
    private String msg_account;
    private Bean_account.DataBean data_account;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_pay_order;
    }

    @Override
    protected void findViews() {
        radio = (RadioGroup) findViewById(R.id.radio);

        if (toolbar_all != null) {
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("支付订单");
        }


    }

    @Override
    public void initData() {

        Intent intent = getIntent();

        order = intent.getStringExtra("order");

        order_id = intent.getIntExtra("order_id", 0);

        price = intent.getStringExtra("price");

        shop_name = intent.getStringExtra("shop_name");

        text_price.setText(price);

        text_name.setText(shop_name);

        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio0:
//                        微信
                        type_pay = 2;
                        break;
                    case R.id.radio1:
//                        支付宝
                        type_pay = 3;
                        break;
                    case R.id.radio2:
//                        余额
                        type_pay = 1;
                        break;
                }
            }
        });


//      支付    的    密码
        text_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type = 0;
                HttpUtil.addMapparams();
                HttpUtil.params.put("userId", MyApp.user);
                HttpUtil.Post_request("account/checkPasswordSetting", HttpUtil.params);
                getdata("account/checkPasswordSetting");
            }
        });
    }


//    @OnClick({R.id.text_pay})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.text_pay:
//                HttpUtil.addMapparams();
//                HttpUtil.params.put("userId", MyApp.user);
//                HttpUtil.Post_request("account/checkPasswordSetting", HttpUtil.params);
//                getdata("account/checkPasswordSetting");
//                break;
//        }
//    }

//    private BottomSheetDialog bottomSheetDialog;

    private int type = 0;

//    private void openPayPasswordDialog() {
//        PayPasswordView payPasswordView = new PayPasswordView(this);
//        bottomSheetDialog = new BottomSheetDialog(this);
//        bottomSheetDialog.setContentView(payPasswordView);
//        bottomSheetDialog.setCanceledOnTouchOutside(false);
//        bottomSheetDialog.show();
//    }

//    private String passwordone;
//
//    @Override
//    public void passwordFull(String password) {
//        ++type;
//        if (type == 1) {
//            //第一次密码输入完以后 就 清除数据
//            passwordone = password;
//            mPasswordEditText.setText("");
//            text_passWord.setText("请再次确认支付密码");
//        } else {
//            String passwordtwo = password;
//            if (passwordone.equals(passwordtwo)) {
////                    一致调用接口
//                HttpUtil.addMapparams();
//                HttpUtil.params.put("userId", Integer.valueOf(MyApp.user));
////                    渠道
//                HttpUtil.params.put("password", password);
//                HttpUtil.Post_request("account/setPassword", HttpUtil.params);
//                getdata("account/setPassword");
////                    bottomSheetDialog.dismiss();
//                type = 0;
//                mBottomSheetPop.dismiss();
//            } else {
//                Toast.makeText(ActPayOrder.this, "请核对2次密码是否一致！", Toast.LENGTH_SHORT).show();
////                    bottomSheetDialog.dismiss();
//                type = 0;
//                mBottomSheetPop.dismiss();
//            }
//        }
//    }


//    public class PayPasswordView extends LinearLayout implements View.OnClickListener, PasswordEditText.PasswordFullListener {
//        private LinearLayout mKeyBoardView;
//        private PasswordEditText mPasswordEditText;
//
//        public PayPasswordView(Context context) {
//            this(context, null);
//        }
//
//        public PayPasswordView(Context context, @Nullable AttributeSet attrs) {
//            this(context, attrs, 0);
//        }
//
//        public PayPasswordView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//            super(context, attrs, defStyleAttr);
//            inflate(context, R.layout.pay_password_layout, this);
//            mKeyBoardView = findViewById(R.id.keyboard);
//            mPasswordEditText = findViewById(R.id.passwordEdt);
//            mPasswordEditText.setPasswordFullListener(this);
//            setItemClickListener(mKeyBoardView);
//        }
//
//        /**
//         * 给每一个自定义数字键盘上的View 设置点击事件
//         *
//         * @param view
//         */
//        private void setItemClickListener(View view) {
//            if (view instanceof ViewGroup) {
//                ViewGroup viewGroup = (ViewGroup) view;
//                int childCount = viewGroup.getChildCount();
//                for (int i = 0; i < childCount; i++) {
//                    //不断的给里面所有的View设置setOnClickListener
//                    View childView = ((ViewGroup) view).getChildAt(i);
//                    setItemClickListener(childView);
//                }
//            } else {
//                view.setOnClickListener(this);
//            }
//        }
//
//        @Override
//        public void onClick(View v) {
//            if (v instanceof TextView) {
//                String number = ((TextView) v).getText().toString().trim();
//                mPasswordEditText.addPassword(number);
//            }
//            if (v instanceof ImageView) {
//                mPasswordEditText.deletePassword();
//            }
//        }
//
//        @Override
//        public void passwordFull(String password) {
//            Toast.makeText(getContext(), "你输入的密码是：" + password, Toast.LENGTH_SHORT).show();
//            bottomSheetDialog.dismiss();
////            text_pay
//            Map<String, Object> params_order = new HashMap<>();
//            params_order.clear();
//            HttpUtil.addMapparams();
//            params_order.put("orderId", Integer.valueOf(order));
////                    渠道
//            params_order.put("payWay", type_pay);
//            params_order.put("tradeType", "");
//            params_order.put("userOpenId", "");
//            HttpUtil.postRaw("order/pay",
//                    params_order
//            );
//            getdata("order/pay");
//        }
//    }

    @Override
    public void StringResulit(String key, String value) {


//        if (key.equals("order/pay")) {
//
//
//        }

//        判断 是否 已经 设置了 密码

        if (key.equals("account/checkPasswordSetting")) {
            bean_password = MyApp.gson.fromJson(value, Bean_password.class);
            code = bean_password.getCode();

            Log.i("checkPasswordSetting", "-------");

//            post_PassWord();

//            openPayPasswordDialog();

            if (code == 800103) {
                //            设置密码
//                post_PassWord();

                key_type = 0;

                openPayPasswordDialog();


            } else {
//输入密码

                key_type = 1;

                openPayPasswordDialog();
            }
        }


        if (key.equals("order/pay")) {
//            private Bean_account bean_account;
//            private boolean success_account;
//            private int code_account;
//            private String msg_account;
//            private Bean_account.DataBean data_account;
            bean_account = MyApp.gson.fromJson(value, Bean_account.class);
            code_account = bean_account.getCode();
            if (code_account == 200) {
                if (MyApp.order_ty == 0) {
                    ActComdetails.actComdetails.finish();

                    actDeterOrder.finish();

//                  startActivity(ActMyOrder.class);

                    startActivity(ActOrderSucess.class);

                    finish();
                } else if (MyApp.order_ty == 1) {

                    startActivity(ActOrderSucess.class);

                    finish();
                } else if (MyApp.order_ty == 2) {

                    startActivity(ActOrderSucess.class);

                    finish();
                }
            } else {


                String msg = bean_account.getMsg();


                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            }
        }
    }


//    设置密码

//    private LinearLayout mKeyBoardView;
//    private PasswordEditText mPasswordEditText;
//    private TextView text_passWord;
//
//    private void post_PassWord() {
//        View view = Tools.setRebuildPop(this, R.layout.pay_password_layout_set, R.layout.activity_act_pay_order);
////        PayPasswordView.
////       Tools.mBottomSheetPop.setContentView(payPasswordView);
//        mKeyBoardView = (LinearLayout) view.findViewById(R.id.keyboard);
//        text_passWord = (TextView) view.findViewById(R.id.text_passWord);
//        mPasswordEditText = (PasswordEditText) view.findViewById(R.id.passwordEdt);
//        mPasswordEditText.setPasswordFullListener(this);
//        text_passWord.setText("请设置支付密码");
//        setItemClickListener(mKeyBoardView);
//    }
//    /**
//     * 给每一个自定义数字键盘上的View 设置点击事件
//     *
//     * @param view
//     */
//    private void setItemClickListener(View view) {
//        if (view instanceof ViewGroup) {
//            ViewGroup viewGroup = (ViewGroup) view;
//            int childCount = viewGroup.getChildCount();
//            for (int i = 0; i < childCount; i++) {
//                //不断的给里面所有的View设置setOnClickListener
//                View childView = ((ViewGroup) view).getChildAt(i);
//                setItemClickListener(childView);
//            }
//        } else {
//            view.setOnClickListener(this);
//        }
//    }


    private LinearLayout mKeyBoardView;
    private PasswordEditText mPasswordEditText;
    private TextView text_passWord;

//等于0的时候就是去创建支付密码

    //    等于1的时候去写密码
    int key_type = 0;


    private void openPayPasswordDialog() {
//        PayPasswordView payPasswordView = new PayPasswordView(this);
//        bottomSheetDialog = new BottomSheetDialog(this);
//        bottomSheetDialog.setContentView(payPasswordView);
//        bottomSheetDialog.setCanceledOnTouchOutside(false);
//        bottomSheetDialog.show();

        View view;


        if (key_type == 0) {
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


    private String passwordone;

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

    @Override
    public void passwordFull(String password) {
//        Toast.makeText(this, "你输入的密码是：" + password, Toast.LENGTH_SHORT).show();
//        创建密码
        if (key_type == 0) {
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
                    Toast.makeText(ActPayOrder.this, "请核对2次密码是否一致！", Toast.LENGTH_SHORT).show();
//                    bottomSheetDialog.dismiss();
                    type = 0;
                    mBottomSheetPop.dismiss();
                }
            }
        } else {
//            去支付密码
            HttpUtil.addMapparams();
            HttpUtil.params.put("userId", MyApp.user);
            HttpUtil.params.put("orderId", order_id);

            HttpUtil.params.put("payWay", type_pay);

//          HttpUtil.params.put("tradeAmount", Double.valueOf(text_price.getText().toString())*100);

            HttpUtil.params.put("pwd", password);
//            HttpUtil.params.put("userOpenId", MyApp.user);
//            HttpUtil.postRaw("order/pay", HttpUtil.params);


            HttpUtil.Post_request("order/pay", HttpUtil.params);

            getdata("order/pay");
            Log.i("orderididid", order_id + "----------");
            mBottomSheetPop.dismiss();
        }
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


}
