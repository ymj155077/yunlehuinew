package com.example.YunleHui.ui.act.actme.actbusiness;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;

import butterknife.BindView;
import butterknife.OnClick;

public class ActWriteCode extends BaseAct {


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

//    商家id
    private int shopId = 0;

    @BindView(R.id.img_er)
    ImageView img_er;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this,clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_write_code;
    }


    @SuppressLint("ResourceType")
    @Override
    protected void findViews() {

        if (toolbar_all!=null){
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);

            text_center.setText("核销码");

            text_center.setTextColor(this.getResources().getColor(R.color.Write));
            toolbar_all.setBackground(new ColorDrawable(Color.parseColor(getString(R.color.erback))));
        }

    }

    @Override
    public void initData() {

        Intent intent = getIntent();

        shopId = intent.getIntExtra("shopId",0);


        Glide.with(this).load(MyApp.PUBLIC_URL + "order/generateQrCode?secret=" + shopId).into(img_er);


    }






    @OnClick({R.id.lin_his})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.lin_his:

                startActivity(ActWriteHistory.class);

                break;
        }
    }











}
