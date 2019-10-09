package com.example.YunleHui.ui.act.actme.actbusiness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;

import butterknife.BindView;


/**
 * 选择发布模板
 */

public class ActTemplate extends BaseAct {


    @BindView(R.id.radio)
    RadioGroup radio;


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_template;
    }

    @Override
    protected void findViews() {


        if (toolbar_all != null) {
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("选择发布模板");

            TextView toolbar_right = toolbar_all.findViewById(R.id.toolbar_right);

            toolbar_right.setText("完成");

            toolbar_right.setVisibility(View.VISIBLE);

            toolbar_right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if (type_pay == 0) {


                        //社区购
                        startActivity(ActPublishGoods.class);

                    } else if (type_pay == 1) {
//爆款发布
                        startActivity(ActRefunds.class);

                    }



                }
            });
        }
    }

    private int type_pay = 0;

    @Override
    public void initData() {


        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio0:
//                        社区购商品录入
                        type_pay = 0;
                        break;
                    case R.id.radio1:
//                        爆款商品录入
                        type_pay = 1;
                        break;
                }
            }
        });


    }
}
