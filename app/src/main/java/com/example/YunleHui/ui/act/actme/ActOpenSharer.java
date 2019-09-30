package com.example.YunleHui.ui.act.actme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;


//我的达人码

public class ActOpenSharer extends BaseAct {

    @BindView(R.id.img_head)
    RoundedImageView img_head;

    @BindView(R.id.img_hei_xiao)
    ImageView img_hei_xiao;

    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this,clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_open_sharer;
    }

    @Override
    protected void findViews() {

        if (toolbar_all!=null){
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);

            text_center.setText("分享达人二维码");
        }

    }

    @Override
    public void initData() {
        Glide.with(this).load(MyApp.url_gif).into(img_head);
        Glide.with(this).load(MyApp.PUBLIC_URL + "order/generateQrCode?secret=" + MyApp.user).into(img_hei_xiao);
    }

}
