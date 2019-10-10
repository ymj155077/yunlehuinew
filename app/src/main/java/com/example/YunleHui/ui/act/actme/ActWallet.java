package com.example.YunleHui.ui.act.actme;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.HttpUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class ActWallet extends BaseAct {


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @BindView(R.id.lin_Recharge)
    LinearLayout lin_Recharge;

    @BindView(R.id.lin_tixian)
    LinearLayout lin_tixian;

    @BindView(R.id.lin_zhangdan)
    LinearLayout lin_zhangdan;

    @BindView(R.id.lin_jilu)
    LinearLayout lin_jilu;


    private String text_money;


    @BindView(R.id.text_all)
    TextView text_all;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_wallet;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            TextView text_center = toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("钱包");
        }
    }

    @Override
    public void initData() {

        Intent intent = getIntent();

        text_money = intent.getStringExtra("text_money");

        text_all.setText(text_money);


    }

    @OnClick({
            R.id.lin_Recharge,
            R.id.lin_tixian,
            R.id.lin_zhangdan,
            R.id.lin_jilu
    })
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.lin_Recharge:
                startActivity(ActRecharge.class);
                break;
            case R.id.lin_tixian:
                Intent intent = new Intent(this, ActRecharge.class);
                intent.putExtra("tixian", 11);
                startActivity(intent);
                break;
//                账单
            case R.id.lin_zhangdan:
                startActivity(Actbill.class);
                break;
//               提现记录
            case R.id.lin_jilu:
                startActivity(ActDisRecord.class);
                break;
        }
    }


    public void stringResulit(String key, String value) {


    }


}
