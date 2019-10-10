package com.example.YunleHui.ui.act.actme;

import android.content.Context;
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
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.YunleHui.Bean.BeanLogin;
import com.example.YunleHui.Bean.Bean_sd;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.view.ClearEditText;
import com.example.YunleHui.view.NoScrollListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

//修改个人信息

public class ActMoinfor extends BaseAct {

    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    private TextView text_center;

    @BindView(R.id.edit_name)
    ClearEditText edit_name;

    @BindView(R.id.radio)
    RadioGroup radio;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_moinfor;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
        }
    }


    private String name = "";

    private int type = 0;

    //    性别的类型
    private int Gender = -1;


    @Override
    public void initData() {

        Intent intent = getIntent();

        name = intent.getStringExtra("name");

        type = intent.getIntExtra("type", 0);

        text_center.setText(name);


        String tname = intent.getStringExtra("text_name");

        try {
            edit_name.setText(tname);
        }catch (Exception e){

        }



        if (type == 0) {

            radio.setVisibility(View.GONE);

        } else if (type == 1) {

            edit_name.setVisibility(View.GONE);

        }


        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radnan:
//                        男
                        Gender = -1;
                        break;
                    case R.id.radnv:
//                        女
                        Gender = 1;
                        break;
                }
            }
        });
    }


    @BindView(R.id.textSure)
    TextView textSure;

    @OnClick({R.id.textSure})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.textSure:
                HttpUtil.addMapparams();
                if (type == 0) {
                    if (edit_name.getText().toString().trim().length() > 0 && !edit_name.getText().toString().trim().equals(name)) {
                    HttpUtil.params.put("nickname", edit_name.getText().toString());
                    }
                } else if (type == 1) {
                    HttpUtil.params.put("gender", Gender);
                }
                HttpUtil.Post_request("user/updateUserInfo", HttpUtil.params);
                getdata("user/updateUserInfo");
                break;
        }
    }


    private Bean_sd bean_sd;
    private boolean success_sd;
    private int code_sd;
    private String msg_sd;
    private Bean_sd.DataBean data_sd;





    @Override
    public void stringResulit(String key, String value) {
        if (key.equals("user/updateUserInfo")) {
            bean_sd = MyApp.gson.fromJson(value,Bean_sd.class);
            data_sd = bean_sd.getData();
            if (type==0){
                MyApp.putSharedPreference(this, "nickName", data_sd.getNickName());

                finish();

            }else if (type==1){
                if (data_sd.getGender()==-1){
                    MyApp.putSharedPreference(this, "gender", "男");
                }else {
                    MyApp.putSharedPreference(this, "gender", "女");
                }


                finish();


            }
        }
    }
}
