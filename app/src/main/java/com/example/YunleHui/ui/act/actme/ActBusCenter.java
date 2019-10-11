package com.example.YunleHui.ui.act.actme;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.Bean_shopDetails;
import com.example.YunleHui.Bean.Bean_shop_center;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.act.actme.actbusiness.ActCoManMent;
import com.example.YunleHui.ui.act.actme.actbusiness.ActEvalmanage;
import com.example.YunleHui.ui.act.actme.actbusiness.ActOrManaGe;
import com.example.YunleHui.ui.act.actme.actbusiness.ActPublishGoods;
import com.example.YunleHui.ui.act.actme.actbusiness.ActReCenter;
import com.example.YunleHui.ui.act.actme.actbusiness.ActRefunds;
import com.example.YunleHui.ui.act.actme.actbusiness.ActTemplate;
import com.example.YunleHui.ui.act.actme.actbusiness.ActWriteCode;
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


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    @BindView(R.id.img_shop)
    RoundedImageView img_shop;

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


    @BindView(R.id.lin_management)
    LinearLayout lin_management;

    private int TypeId = 0;
    private String shopName = "";
    private String shopLogoUrl = "";
    private String shopTel = "";
    private int ShopNature = 0;
    private String money;


    //社区购+营销+核销
    @BindView(R.id.lin_Marketing)
    LinearLayout lin_Marketing;


    //核销商户管理
    @BindView(R.id.lin_Writeoff)
    LinearLayout lin_Writeoff;
    //所有的
    @BindView(R.id.lin_all)
    LinearLayout lin_all;


    @BindView(R.id.lin_he)
    LinearLayout lin_he;


    //  核销+营销的商家
    @BindView(R.id.lin_DoubleShop)
    LinearLayout lin_DoubleShop;


    //    评价管理
    @BindView(R.id.lin_pingjia)
    LinearLayout lin_pingjia;


    //商家ID
    private int shopId = 0;



    @BindView(R.id.lin_shopguan)
    LinearLayout lin_shopguan;


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


        Intent intent = getIntent();

        TypeId = intent.getIntExtra("TypeId", 0);
        shopName = intent.getStringExtra("shopName");
        shopLogoUrl = intent.getStringExtra("shopLogoUrl");
        shopTel = intent.getStringExtra("shopTel");
        ShopNature = intent.getIntExtra("ShopNature", 0);
        money = intent.getStringExtra("money");
        shopId = intent.getIntExtra("shopId", 0);
        Glide.with(this).load(shopLogoUrl).into(img_shop);
        text_shopName.setText(shopName);
        text_jine.setText(money);
        Log.i("TypeId", TypeId + "---");
//            营销
        if (TypeId == 1) {
            lin_Marketing.setVisibility(View.VISIBLE);
//            核销
        } else if (TypeId == 2) {
            lin_Writeoff.setVisibility(View.VISIBLE);
//            核销加营销
        } else if (TypeId == 3) {
            lin_all.setVisibility(View.VISIBLE);
        }


        Log.i("ShopNature", ShopNature + "----");


    }


    @BindView(R.id.lin_heg)
    LinearLayout lin_heg;


    @OnClick({R.id.lin_OrderManagement,

            R.id.lin_release,

            R.id.lin_Merchants,

            R.id.lin_ComAn,

            R.id.lin_OrderMent,

            R.id.lin_management,

            R.id.lin_he,

            R.id.lin_DoubleShop,

            R.id.lin_pingjia,

            R.id.lin_shopguan

    })
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.lin_OrderManagement:
//订单管理
                startActivity(ActOrManaGe.class);

                break;
//                发布商品
            case R.id.lin_release:
                if (ShopNature == 0) {
//爆款发布
                    startActivity(ActRefunds.class);
                } else if (ShopNature == 1) {
//社区购
                    startActivity(ActPublishGoods.class);
                }
                break;
//                核销商户
            case R.id.lin_Merchants:

                startActivity(ActWriteMerchants.class);

                break;
//          营销商户      管理商品
            case R.id.lin_ComAn:

                startActivity(ActCoManMent.class);

                break;

//          营销商户 + 核销商户      管理商品
            case R.id.lin_shopguan:

                startActivity(ActCoManMent.class);

                break;



//                订单管理
            case R.id.lin_OrderMent:
//                    三个标签  爆款
//                if (ShopNature==0){
////                    五个标签
//                }else if (ShopNature == 1){
                    //爆款商户和社区商户功能都开通的时候
                    startActivity(ActOrManaGe.class);
//                }
                break;

//                核销管理

            case R.id.lin_management:

                startActivity(ActWriteOffManage.class);

                break;

//                核销码
            case R.id.lin_he:

                Intent intent = new Intent(this, ActWriteCode.class);

                intent.putExtra("shopId", shopId);


                startActivity(intent);

                break;
//               核销管理
            case R.id.lin_heg:

                startActivity(ActWriteOffManage.class);

                break;
//                核销+营销
            case R.id.lin_DoubleShop:
//爆款    +   社区购
//          startActivity(ActTemplate.class);
                if (ShopNature == 0) {
//爆款发布
                    startActivity(ActRefunds.class);
                } else if (ShopNature == 1) {
//社区购
                    startActivity(ActPublishGoods.class);
                }
                break;
//                评价管理
            case R.id.lin_pingjia:

                startActivity(ActEvalmanage.class);

                break;

        }
    }


    @Override
    public void stringResulit(String key, String value) {

    }
}
