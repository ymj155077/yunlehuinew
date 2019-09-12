package com.example.YunleHui.ui.act.actme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.YunleHui.Bean.Bean_Profit;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.HttpUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的收益
 */

public class ActProfit extends BaseAct {


    private Bean_Profit bean_profit;
    private boolean success;
    private int code;
    private String msg;
    private Bean_Profit.DataBean data;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @BindView(R.id.text_all)
    TextView text_all;

    @BindView(R.id.text_zuo)
    TextView text_zuo;

    @BindView(R.id.text_you)
    TextView text_you;


    @BindView(R.id.lin_Team)
    LinearLayout lin_Team;

    @BindView(R.id.lin_customer)
    LinearLayout lin_customer;

    @BindView(R.id.lin_share)
    LinearLayout lin_share;

    @BindView(R.id.lin_Commission)
    LinearLayout lin_Commission;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_profit;
    }

    @Override
    protected void findViews() {

        if (toolbar_all != null) {
            TextView text_center = toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("我的收益");
        }

    }

    @Override
    public void initData() {

        HttpUtil.addMapparams();
        HttpUtil.params.put("userId", MyApp.user);

        HttpUtil.Post_request("sell/searchCommissions", HttpUtil.params);
        getdata("sell/searchCommissions");

    }


    @OnClick({R.id.lin_Team,R.id.lin_customer,R.id.lin_share,R.id.lin_Commission})
    public void OnClick(View view) {
        switch (view.getId()) {

//            我的团队
            case R.id.lin_Team:

                startActivity(ActMyCustomer.class);

                break;
//                我的顾客
            case R.id.lin_customer:

                startActivity(ActMyTeam.class);

                break;
//                我的分享
            case R.id.lin_share:

startActivity(ActMyShare.class);

                break;
//                佣金明细
            case R.id.lin_Commission:

                startActivity(ActDetaCom.class);

                break;

        }
    }


    public void StringResulit(String key, String value) {
try {
    if (key.equals("sell/searchCommissions")) {
        bean_profit = MyApp.gson.fromJson(value, Bean_Profit.class);
        data = bean_profit.getData();
        text_all.setText(data.getTotalCommission() * 0.01 + "");
        text_zuo.setText(data.getSettledCommission() * 0.01 + "");
        text_you.setText(data.getNotSettleCommission() * 0.01 + "");
    }
}catch (Exception e){

}

    }

}
