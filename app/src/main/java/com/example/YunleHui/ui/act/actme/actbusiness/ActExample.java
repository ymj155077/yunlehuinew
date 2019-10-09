package com.example.YunleHui.ui.act.actme.actbusiness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;

import butterknife.BindView;
import butterknife.ButterKnife;

//查看示例
public class ActExample extends BaseAct {


    @BindView(R.id.img_one)
    ImageView imgOne;
    @BindView(R.id.img_two)
    ImageView imgTwo;
    @BindView(R.id.img_three)
    ImageView imgThree;
    @BindView(R.id.img_four)
    ImageView imgFour;


    private int type = 0;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_example;
    }

    @Override
    protected void findViews() {

    }

    @Override
    public void initData() {

        Intent intent = getIntent();

        type = intent.getIntExtra("type", 0);

        if (type == 1){

            imgOne.setVisibility(View.VISIBLE);

        }else if (type == 2){
            imgTwo.setVisibility(View.VISIBLE);
        }else if (type == 3){
            imgThree.setVisibility(View.VISIBLE);
        }else if (type == 4){
            imgFour.setVisibility(View.VISIBLE);
        }


    }


}
