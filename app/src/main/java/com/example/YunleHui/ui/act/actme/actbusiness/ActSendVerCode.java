package com.example.YunleHui.ui.act.actme.actbusiness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.YunleHui.ui.act.actme.actbusiness.ActBusSearch.actBusSearch;

public class ActSendVerCode extends BaseAct {


    @BindView(R.id.text_fase)
    TextView text_fase;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_send_ver_code;
    }

    @Override
    protected void findViews() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.text_fase})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.text_fase:
                actBusSearch.finish();
                finish();
                break;
        }
    }
}
