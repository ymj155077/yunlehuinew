package com.example.YunleHui.ui.act.actme;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.acthome.ActPayOrder;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.widget.PasswordEditText;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.YunleHui.utils.Tools.mBottomSheetPop;

//设置支付密码
public class ActSafetyCenter extends BaseAct implements View.OnClickListener, PasswordEditText.PasswordFullListener {


    @BindView(R.id.lin_safety)
    LinearLayout lin_safety;

    private int type = 0;

    @BindView(R.id.Lin_rest)
    LinearLayout Lin_rest;

    @BindView(R.id.lin_ret)
    LinearLayout lin_ret;

    @BindView(R.id.lin_replace)
    LinearLayout lin_replace;

    private String passwordone;

    @BindView(R.id.toolbar_all)
    Toolbar tool_all;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_safety_center;
    }

    @Override
    protected void findViews() {

        if (tool_all != null) {

            TextView text_center = (TextView) tool_all.findViewById(R.id.toolbar_center);
            text_center.setText("安全中心");

        }

    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.Lin_rest, R.id.lin_ret, R.id.lin_replace})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.Lin_rest:
//                设置支付密码

                type = 0;

                openPayPasswordDialog();
                break;
//                支付密码找回
            case R.id.lin_ret:

                Intent intent = new Intent(this, ActRetrieve.class);

                intent.putExtra("type", 1);

                startActivity(intent);
                break;
//                更换手机号
            case R.id.lin_replace:

                startActivity(ActBinding.class);

                break;

        }
    }

//    private BottomSheetDialog bottomSheetDialog;


    private LinearLayout mKeyBoardView;
    private PasswordEditText mPasswordEditText;
    private TextView text_passWord;


    private void openPayPasswordDialog() {
//        PayPasswordView payPasswordView = new PayPasswordView(this);
//        bottomSheetDialog = new BottomSheetDialog(this);
//        bottomSheetDialog.setContentView(payPasswordView);
//        bottomSheetDialog.setCanceledOnTouchOutside(false);
//        bottomSheetDialog.show();
        View view = Tools.setRebuildPop(this, R.layout.pay_password_layout_set, R.layout.activity_act_safety_center);
//        PayPasswordView.
//       Tools.mBottomSheetPop.setContentView(payPasswordView);
        mKeyBoardView = (LinearLayout) view.findViewById(R.id.keyboard);
        text_passWord = (TextView) view.findViewById(R.id.text_passWord);
        mPasswordEditText = (PasswordEditText) view.findViewById(R.id.passwordEdt);
        mPasswordEditText.setPasswordFullListener(this);
        setItemClickListener(mKeyBoardView);
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

    @Override
    public void passwordFull(String password) {
//        Toast.makeText(this, "你输入的密码是：" + password, Toast.LENGTH_SHORT).show();
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
                HttpUtil.params.put("userId", Integer.valueOf(MyApp.user));
//                    渠道
                HttpUtil.params.put("password", password);
                HttpUtil.Post_request("account/setPassword", HttpUtil.params);
                getdata("account/setPassword");
//                    bottomSheetDialog.dismiss();
                type = 0;
                mBottomSheetPop.dismiss();
            } else {
                Toast.makeText(ActSafetyCenter.this, "请核对2次密码是否一致！", Toast.LENGTH_SHORT).show();
//                    bottomSheetDialog.dismiss();
                type = 0;
                mBottomSheetPop.dismiss();
            }
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


//    public class PayPasswordView extends LinearLayout implements View.OnClickListener, PasswordEditText.PasswordFullListener {
//
//        private LinearLayout mKeyBoardView;
//        private PasswordEditText mPasswordEditText;
//        private TextView text_passWord;
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
//            inflate(context, R.layout.pay_password_layout_set, this);
//            mKeyBoardView = (LinearLayout)findViewById(R.id.keyboard);
//            text_passWord = (TextView) findViewById(R.id.text_passWord);
//            mPasswordEditText = (PasswordEditText)findViewById(R.id.passwordEdt);
//            mPasswordEditText.setPasswordFullListener(this);
//            setItemClickListener(mKeyBoardView);
//        }
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
//            ++type;
//            if (type==1){
//                //第一次密码输入完以后 就 清除数据
//                passwordone = password;
//                mPasswordEditText.setText("");
//            }else {
//                String passwordtwo = password;
//                if (passwordone.equals(passwordtwo)){
////                    一致调用接口
//                    HttpUtil.addMapparams();
//                    HttpUtil.params.put("userId", Integer.valueOf(MyApp.user));
////                    渠道
//                    HttpUtil.params.put("password", password);
//                    HttpUtil.Post_request("account/setPassword",HttpUtil.params);
//                    getdata("account/setPassword");
//
////                    bottomSheetDialog.dismiss();
//
//                    Tools.mBottomSheetPop.dismiss();
//
//                }else {
//                    Toast.makeText(ActSafetyCenter.this,"请核对2次密码是否一致！",Toast.LENGTH_SHORT).show();
////                    bottomSheetDialog.dismiss();
//
//                    Tools.mBottomSheetPop.dismiss();
//
//                }
//            }
//        }
//    }


    @Override
    public void StringResulit(String key, String value) {
        try {
            if (key.equals("account/setPassword")) {


            }
        } catch (Exception e) {

        }


    }
}
