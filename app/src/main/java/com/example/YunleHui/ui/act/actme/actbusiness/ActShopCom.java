package com.example.YunleHui.ui.act.actme.actbusiness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.view.Nine.TNinePlaceGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 商家评价详情
 */

public class ActShopCom extends BaseAct {


    @BindView(R.id.text_send)
    TextView text_send;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_shop_com;
    }

    @Override
    protected void findViews() {


        if (toolbar_all != null) {
            TextView text_detail = toolbar_all.findViewById(R.id.toolbar_center);
            text_detail.setText("评价详情");
        }


        ninePlaceGridView = (TNinePlaceGridView) findViewById(R.id.ninePlaceGridView);
    }


    private TNinePlaceGridView ninePlaceGridView;


    @Override
    public void initData() {
        List<Object> urls = new ArrayList<>();
        urls.clear();
        for (int i = 0; i < 6; i++) {
            urls.add(R.drawable.timg);
        }
        ninePlaceGridView.setImageNames(urls);
    }


    @OnClick({R.id.text_send})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.text_send:

                if (edit_context.getText().toString().trim() != null && edit_context.getText().toString().length() > 0) {

                    HttpUtil.addMapparams();
//              评论的id
                    HttpUtil.params.put("replyId", 123);
                    HttpUtil.params.put("replyContent", edit_context.getText().toString().trim());
                    HttpUtil.Post_request("frontShop/addShopReply", HttpUtil.params);
                    getdata("frontShop/addShopReply");

                }else {
                    Toast.makeText(ActShopCom.this,"请输入内容！",Toast.LENGTH_SHORT).show();
                }



                break;
        }
    }

    @BindView(R.id.edit_context)
    EditText edit_context;

    @Override
    public void stringResulit(String key, String value) {


        if (key.equals("frontShop/addShopReply")) {

            finish();

        }


    }


}
