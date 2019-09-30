package com.example.YunleHui.ui.act.acthome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.YunleHui.Bean.BeanWechat;
import com.example.YunleHui.Bean.Bean_account;
import com.example.YunleHui.Bean.Bean_dea;
import com.example.YunleHui.Bean.Bean_password;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.ActComPur.ActComMall;
import com.example.YunleHui.ui.act.actme.ActMyOrder;
import com.example.YunleHui.ui.act.actme.actbusiness.ActBusDistribution;
import com.example.YunleHui.ui.act.actme.actbusiness.ActOrderPayCom;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.widget.PasswordEditText;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import butterknife.BindView;

import static com.example.YunleHui.appManager.MyApp.orderNatureAll;
import static com.example.YunleHui.ui.act.acthome.ActDeterOrder.actDeterOrder;
import static com.example.YunleHui.ui.act.actme.ActTodetails.actTodetails;
import static com.example.YunleHui.utils.Tools.mBottomSheetPop;

//支付订单

public class ActPayOrder extends BaseAct implements View.OnClickListener, PasswordEditText.PasswordFullListener {


    //未支付订单 到这边进行支付

    private int typeNo = 0;


    //爆款0，社区购1
    private int orderNature = 0;
    @BindView(R.id.text_name)
    TextView text_name;
    //店铺名
    private String shop_name;
    //    订单id
    private String OrderNumber = "";
    //金额
    private String price;
    private String order = "";
    private RadioGroup radio;
    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;
    private int type_pay = 2;
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


    public static ActPayOrder actPayOrder;

//    描述账单的内容
    private String Content = "";


    @Override
    public void initData() {


        actPayOrder = this;


        Intent intent = getIntent();
//判断是否是为未支付的   1是社区购的 未支付，2是爆款的 未支付
        typeNo = intent.getIntExtra("typeNo", 0);
//订单号
        OrderNumber = intent.getStringExtra("OrderNumber");
        price = intent.getStringExtra("price");
        shop_name = intent.getStringExtra("shop_name");
        orderNature = intent.getIntExtra("orderNature", 0);

        Content = intent.getStringExtra("Content");

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

//                微信支付
                if (type_pay == 2) {
                    HttpUtil.addMapparams();
                    HttpUtil.params.put("orderNum", OrderNumber);

                    if (orderNature == 0){
                        HttpUtil.params.put("payDes", "微信支付【" + text_name.getText().toString() + Content+"金额：" + text_price.getText().toString() + "元】");
                    }else {
                        HttpUtil.params.put("payDes", "微信支付【" + text_name.getText().toString() + "金额：" + text_price.getText().toString() + "元】");
                    }

                    HttpUtil.params.put("payType", 0);
                    HttpUtil.params.put("totalAmount", Double.valueOf(text_price.getText().toString()) * 100);
                    HttpUtil.params.put("tradeType", "APP");
                    HttpUtil.params.put("userId", MyApp.user);
                    HttpUtil.params.put("userOpenId", "");
                    HttpUtil.params.put("payNum", "");
                    HttpUtil.params.put("orderNature", orderNature);

                    HttpUtil.postRaw("payWechat/placeOrder", HttpUtil.params);
                    getdata("payWechat/placeOrder");

                } else {

                    type = 0;
                    HttpUtil.addMapparams();
                    HttpUtil.params.put("userId", MyApp.user);
                    HttpUtil.Post_request("account/checkPasswordSetting", HttpUtil.params);
                    getdata("account/checkPasswordSetting");

                }

            }
        });
    }

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
//                正常的支付
                if (typeNo == 0) {
//                爆款
                    if (orderNature == 0) {
                        ActComdetails.actComdetails.finish();
                        actDeterOrder.finish();
                        startActivity(ActOrderSucess.class);
                        finish();
                    } else if (orderNature == 1) {
//                社区购
                        ActComMall.actComMall.finish();
                        ActOrderPayCom.actOrderPayCom.finish();
                        startActivity(ActMyOrder.class);
                        finish();
                    }
                } else if (typeNo == 1) {
//                    待支付里面进来的
                    ActBusDistribution.actBusDistribution.finish();
                    finish();
                } else if (typeNo == 2) {
                    actTodetails.finish();
                    finish();
                }
            } else {
                String msg = bean_account.getMsg();
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            }
        }


        try {
            if (key.equals("payWechat/placeOrder")) {

                beanWechat = MyApp.gson.fromJson(value, BeanWechat.class);
                dataWechat = beanWechat.getData();

                String prepayJson = dataWechat.getPrepayJson();

                bean_dea = MyApp.gson.fromJson(prepayJson, Bean_dea.class);
                IWXAPI wxAPI = WXAPIFactory.createWXAPI(this, bean_dea.getAppId());
                wxAPI.registerApp(bean_dea.getAppId());
                PayReq req = new PayReq();
                req.appId = bean_dea.getAppId();
                req.partnerId = bean_dea.getPartnerId();
                req.prepayId = bean_dea.getPrepayId();
                req.packageValue = bean_dea.getPackageValue();
                req.nonceStr = bean_dea.getNonceStr();
                req.timeStamp = bean_dea.getTimeStamp() + "";
                req.sign = bean_dea.getSign();
                wxAPI.sendReq(req);

                MyApp.typeNoAll = typeNo;
                MyApp.orderNatureAll = orderNature ;
            }
        } catch (Exception e) {

        }


    }


    private BeanWechat beanWechat;
    private boolean successWechat;
    private int codeWechat;
    private String msgWechat;
    private BeanWechat.DataBean dataWechat;


    //微信详情
    private Bean_dea bean_dea;
    private String timeStamp;
    private String packageValue;
    private String appId;
    private String sign;
    private String prepayId;
    private String partnerId;
    private String nonceStr;


    private LinearLayout mKeyBoardView;
    private PasswordEditText mPasswordEditText;
    private TextView text_passWord;

//等于0的时候就是去创建支付密码

    //    等于1的时候去写密码
    int key_type = 0;


    private void openPayPasswordDialog() {
        View view;
        if (key_type == 0) {
            view = Tools.setRebuildPop(this, R.layout.pay_password_layout_set, R.layout.activity_act_pay_order);
        } else {
            view = Tools.setRebuildPop(this, R.layout.pay_password, R.layout.activity_act_pay_order);
        }
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
                    type = 0;
                    mBottomSheetPop.dismiss();
                } else {
                    Toast.makeText(ActPayOrder.this, "请核对2次密码是否一致！", Toast.LENGTH_SHORT).show();
                    type = 0;
                    mBottomSheetPop.dismiss();
                }
            }
        } else {
//          去支付密码
            HttpUtil.addMapparams();
            HttpUtil.params.put("orderNum", OrderNumber);
            HttpUtil.params.put("payWay", type_pay);
            HttpUtil.params.put("pwd", password);
//          支付类型
            HttpUtil.params.put("orderNature", orderNature);
            HttpUtil.Post_request("order/pay", HttpUtil.params);
            getdata("order/pay");
            Log.i("orderididid", OrderNumber + "----------" + orderNature);
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //                爆款
            if (orderNature == 0) {
                ActComdetails.actComdetails.finish();
                actDeterOrder.finish();
                startActivity(ActMyOrder.class);
                finish();
            } else if (orderNature == 1) {
//                    社区购
                ActComMall.actComMall.finish();
                ActOrderPayCom.actOrderPayCom.finish();
                startActivity(ActMyOrder.class);
                finish();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }


}
