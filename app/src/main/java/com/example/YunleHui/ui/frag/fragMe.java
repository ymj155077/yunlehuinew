package com.example.YunleHui.ui.frag;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.Bean_acc;
import com.example.YunleHui.Bean.Bean_shopDetails;
import com.example.YunleHui.Bean.Bean_shop_center;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseFrag;
import com.example.YunleHui.ui.act.actme.ActBusApp;
import com.example.YunleHui.ui.act.actme.ActBusCenter;
import com.example.YunleHui.ui.act.actme.ActOpenSharer;
import com.example.YunleHui.ui.act.actme.ActProfit;
import com.example.YunleHui.ui.act.actme.ActWallet;
import com.example.YunleHui.ui.act.actme.ActDaren;
import com.example.YunleHui.ui.act.actme.ActPerinform;
import com.example.YunleHui.ui.act.actme.ActMyOrder;
import com.example.YunleHui.ui.act.actme.ActSetUp;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.CircleImageView;

import butterknife.BindView;
import butterknife.OnClick;

public class fragMe extends BaseFrag {


    @BindView(R.id.text_name)
    TextView text_name;
    private Bean_shop_center bean_shop_center;
    private boolean success_center;
    private int code_center;
    private String msg_center;
    private Bean_shop_center.DataBean data_center;
    @BindView(R.id.lin_behalf)
    LinearLayout lin_behalf;
    @BindView(R.id.lin_not_used)
    LinearLayout lin_not_used;
    @BindView(R.id.lin_Used)
    LinearLayout lin_Used;
    @BindView(R.id.lin_refund)
    LinearLayout lin_refund;


    @BindView(R.id.lin_information)
    LinearLayout lin_information;


    //    设置
    @BindView(R.id.lin_Set_up)
    LinearLayout lin_Set_up;


    @BindView(R.id.lin_wallet)
    LinearLayout lin_wallet;


//    分享达人码

    @BindView(R.id.lin_share)
    LinearLayout lin_share;
//    商户申请入驻

    @BindView(R.id.lin_Merchant)
    LinearLayout lin_Merchant;


    @BindView(R.id.lin_Daren)
    LinearLayout lin_Daren;


    @BindView(R.id.text_money)
    TextView text_money;


    @BindView(R.id.lin_pingjia)
    LinearLayout lin_pingjia;


    @BindView(R.id.img_head)
    ImageView img_head;
//    ActMyOrder


    private Bean_acc bean_acc;
    private boolean success;
    private int code;
    private String msg;
    private Bean_acc.DataBean data;


    @BindView(R.id.lin_shar)
    LinearLayout lin_shar;

    @Override
    protected int getLayoutId() {
        return R.layout.frag_me;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

//      Glide.with(this).load(MyApp.url_gif).into(img_head);
//      Glide.with(getActivity()).asGif().load(MyApp.url_gif).into(img_head);
        HttpUtil.addMapparams();
        HttpUtil.params.put("userId", MyApp.user);
        HttpUtil.Post_request("account/getByUser", HttpUtil.params);
        getdata("account/getByUser");
    }

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(), clz));
    }


//    @BindView(R.id.lin_behalf)
//    LinearLayout lin_behalf;
//
//    @BindView(R.id.lin_not_used)
//    LinearLayout lin_not_used;
//
//    @BindView(R.id.lin_Used)
//    LinearLayout lin_Used;
//
//    @BindView(R.id.lin_refund)
//    LinearLayout lin_refund;


    @OnClick({
            R.id.lin_behalf,
            R.id.lin_not_used,
            R.id.lin_Used,
            R.id.lin_refund,
            R.id.lin_Set_up,
            R.id.lin_information,
            R.id.lin_wallet,
            R.id.lin_share,
            R.id.lin_Merchant,
            R.id.lin_Daren,
            R.id.lin_Profit,
            R.id.text_money,
            R.id.lin_pingjia,
            R.id.img_head,
            R.id.lin_shar
    })
    public void OnClick(View view) {

        Intent intent;

        switch (view.getId()) {
            case R.id.lin_behalf:
                startActivity(ActMyOrder.class);
                break;

            case R.id.lin_not_used:
                intent = new Intent(getActivity(), ActMyOrder.class);

                intent.putExtra("type", 1);

                startActivity(intent);
                break;

            case R.id.lin_Used:
                intent = new Intent(getActivity(), ActMyOrder.class);

                intent.putExtra("type", 2);

                startActivity(intent);
                break;

            case R.id.lin_refund:
                intent = new Intent(getActivity(), ActMyOrder.class);
                intent.putExtra("type", 4);
                startActivity(intent);
                break;
//                设置
            case R.id.lin_Set_up:
                startActivity(ActSetUp.class);
                break;
//                个人信息
            case R.id.lin_information:
                startActivity(ActPerinform.class);
                break;
//                钱包
            case R.id.lin_wallet:
                Intent intent1 = new Intent(getActivity(), ActWallet.class);

                intent1.putExtra("text_money", text_money.getText().toString());

                startActivity(intent1);
                break;
//                分享达人
            case R.id.lin_share:
                startActivity(ActOpenSharer.class);
                break;
//商家申请
            case R.id.lin_Merchant:
                HttpUtil.addMapparams();
                HttpUtil.Post_request("frontShop/info", HttpUtil.params);
                getdata("frontShop/info");
//              startActivity(ActBusCenter.class);
                break;
//达人分享
            case R.id.lin_Daren:
                startActivity(ActDaren.class);
                break;
//                我的收益
            case R.id.lin_Profit:
                startActivity(ActProfit.class);
                break;
            case R.id.lin_pingjia:
                intent = new Intent(getActivity(), ActMyOrder.class);
                intent.putExtra("type", 3);
                startActivity(intent);
                break;
            case R.id.img_head:
                startActivity(ActPerinform.class);
                break;
            case R.id.lin_shar:
                startActivity(ActPerinform.class);
                break;
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        String name = (String) MyApp.getSharedPreference(getActivity(), "nickName", "");
        String xinBie = (String) MyApp.getSharedPreference(getActivity(), "gender", "");
        String avatarUrl = (String) MyApp.getSharedPreference(getActivity(), "avatarUrl", "");
        Glide.with(this).load(avatarUrl).into(img_head);
        text_name.setText(name);
        Log.i("nickName", name + "----" + xinBie+"---"+avatarUrl);
    }


    private Bean_shop_center.DataBean databus;


    @Override
    public void StringResulit(String key, String value) {
        try {
            if (key.equals("account/getByUser")) {
                bean_acc = MyApp.gson.fromJson(value, Bean_acc.class);
                data = bean_acc.getData();
                String money = Tools.chenfa(data.getUserBalance()) + "";
                text_money.setText(money);
            }
        } catch (Exception e){

        }
        if (key.equals("frontShop/info")) {
            try {
                bean_shop_center = MyApp.gson.fromJson(value, Bean_shop_center.class);
                code_center = bean_shop_center.getCode();

                databus = bean_shop_center.getData();

                if (code_center == 200) {
                    //   商家已有 店铺
                    Intent intent = new Intent(getActivity(), ActBusCenter.class);
                    intent.putExtra("shopName",databus.getShopName());
                    intent.putExtra("shopLogoUrl",databus.getShopLogoUrl());
                    intent.putExtra("shopTel",databus.getShopTel());
                    intent.putExtra("ShopNature",databus.getShopNature());
                    intent.putExtra("TypeId", databus.getTypeId());
                    intent.putExtra("money",text_money.getText().toString());
                    intent.putExtra("shopId",databus.getId());
//设置商家的id
                    MyApp.shopId = databus.getId();
                    startActivity(intent);
                }
                //            去申请
                else if (code_center == 10001) {
                    startActivity(ActBusApp.class);
                } else if (code_center == 10002) {
                    Toast.makeText(getActivity(), "审核中！", Toast.LENGTH_SHORT).show();
                } else if (code_center == 10003) {
                    //   商家已有 店铺
                    startActivity(ActBusCenter.class);
                } else if (code_center == 10004) {
                    Toast.makeText(getActivity(), "商户申请失败，请重新申请！", Toast.LENGTH_SHORT).show();
                    startActivity(ActBusApp.class);
                }
            } catch (Exception e) {

            }
//                  到商家
//                  startActivity(ActBusCenter.class);
        }
    }
}
