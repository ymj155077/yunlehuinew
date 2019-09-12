package com.example.YunleHui.ui.act.actme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.YunleHui.Bean.Bean_shopDetails;
import com.example.YunleHui.Bean.Bean_shop_center;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.actme.actbusiness.ActCoManMent;
import com.example.YunleHui.ui.act.actme.actbusiness.ActOrManaGe;
import com.example.YunleHui.ui.act.actme.actbusiness.ActPublishGoods;
import com.example.YunleHui.ui.act.actme.actbusiness.ActReCenter;
import com.example.YunleHui.ui.act.actme.actbusiness.ActWriteMerchants;
import com.example.YunleHui.ui.act.actme.actbusiness.ActWriteOffManage;
import com.example.YunleHui.utils.HttpUtil;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 商家中心
 */

public class ActBusCenter extends BaseAct {


    private Bean_shopDetails bean_shopDetails;
    private boolean success;
    private int code;
    private String msg;
    private Bean_shopDetails.DataBean data;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @BindView(R.id.img_head)
    RoundedImageView img_head;

    @BindView(R.id.text_shopName)
    TextView text_shopName;

    @BindView(R.id.text_jine)
    TextView text_jine;

    @BindView(R.id.lin_chongZhi)
    LinearLayout lin_chongZhi;

    @BindView(R.id.lin_tiXian)
    LinearLayout lin_tiXian;


    @BindView(R.id.lin_release)
    LinearLayout lin_release;

    @BindView(R.id.lin_Merchants)
    LinearLayout lin_Merchants;


    //    订单管理
    @BindView(R.id.lin_OrderMent)
    LinearLayout lin_OrderMent;



    //订单管理
    @BindView(R.id.lin_OrderManagement)
    LinearLayout lin_OrderManagement;

    //    管理商品
    @BindView(R.id.lin_ComAn)
    LinearLayout lin_ComAn;

    //    用户退款
    @BindView(R.id.Lin_UseRefund)
    LinearLayout Lin_UseRefund;



    @BindView(R.id.lin_management)
    LinearLayout lin_management;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_bus_center;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("商户中心");
        }
    }


    private Bean_shop_center bean_shop_center;
    private boolean success_center;
    private int code_center;
    private String msg_center;
    private Bean_shop_center.DataBean data_center;


    @Override
    public void initData() {
        HttpUtil.addMapparams();
        HttpUtil.Post_request("frontShop/info", HttpUtil.params);
        getdata("frontShop/info");
    }


    @OnClick({R.id.lin_OrderManagement,

            R.id.lin_release,

            R.id.lin_Merchants,

            R.id.lin_ComAn,

            R.id.lin_OrderMent,

            R.id.Lin_UseRefund,

            R.id.lin_management

    })
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.lin_OrderManagement:
//订单管理
                startActivity(ActOrManaGe.class);

                break;

//                发布商品

            case R.id.lin_release:

                startActivity(ActPublishGoods.class);

                break;
//                核销商户
            case R.id.lin_Merchants:

                startActivity(ActWriteMerchants.class);

                break;
//                管理商品
            case R.id.lin_ComAn:

                startActivity(ActCoManMent.class);

                break;
//                订单管理
            case R.id.lin_OrderMent:

                startActivity(ActOrManaGe.class);

                break;

//                用户退款

            case R.id.Lin_UseRefund:

                startActivity(ActReCenter.class);

                break;

//                核销管理

            case R.id.lin_management:

                startActivity(ActWriteOffManage.class);

                break;


        }
    }


    public void StringResulit(String key, String value) {

        try {
            if (key.equals("frontShop/info")) {
                bean_shop_center = MyApp.gson.fromJson(value, Bean_shop_center.class);
                code_center = bean_shop_center.getCode();
                data_center = bean_shop_center.getData();
            }
        }catch (Exception e){

        }


    }
}
