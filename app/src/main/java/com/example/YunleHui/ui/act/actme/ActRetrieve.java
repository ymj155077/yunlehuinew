package com.example.YunleHui.ui.act.actme;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.widget.PasswordEditText;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.YunleHui.ui.act.actme.ActBinding.actBinding;

/**
 * 绑定手机
 */
public class ActRetrieve extends BaseAct implements View.OnClickListener, PasswordEditText.PasswordFullListener {




    @BindView(R.id.edit_phone)
    EditText edit_phone;

    @BindView(R.id.edit_code)
    EditText edit_code;


    @BindView(R.id.text_yan)
    TextView text_yan;


    @BindView(R.id.text_binding)
    TextView text_binding;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    private TextView text_center;
    private int type;
    private int type_name;

    private TimeCount time;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_retrieve;
    }

    @Override
    protected void findViews() {

        if (toolbar_all!=null){
            text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
        }

    }

    @Override
    public void initData() {

        time = new TimeCount(60000, 1000);



        Intent intent = getIntent();

        type_name = intent.getIntExtra("type",0);

        if (type_name==1){

            text_center.setText("支付密码找回");


            text_binding.setText("下一步");


        }else {
            text_center.setText("绑定手机");
        }





    }


    @OnClick({R.id.text_yan, R.id.text_binding})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.text_yan:

                text_yan.setClickable(false);
                time.start();

                break;

            case R.id.text_binding:

                if (type_name==1){
                    type = 0;
                    openPayPasswordDialog();

                }else {

                    actBinding.finish();

                    finish();

                }


                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (time != null) {
            time.cancel();
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

    private String passwordone;

    @Override
    public void passwordFull(String password) {
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
                Tools.mBottomSheetPop.dismiss();
            } else {
                Toast.makeText(ActRetrieve.this, "请核对2次密码是否一致！", Toast.LENGTH_SHORT).show();
//                    bottomSheetDialog.dismiss();
                type = 0;
                Tools.mBottomSheetPop.dismiss();
            }
        }
    }

    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            text_yan.setClickable(false);
            text_yan.setText("(" + millisUntilFinished / 1000 + ") 秒");
        }

        @Override
        public void onFinish() {
            text_yan.setText("重新获取");
            text_yan.setClickable(true);
        }

    }











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


        text_passWord.setText("请输入新的支付密码");



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









}
