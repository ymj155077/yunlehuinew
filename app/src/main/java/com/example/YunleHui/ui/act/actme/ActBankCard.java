package com.example.YunleHui.ui.act.actme;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseAct;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


//银行卡列表
public class ActBankCard extends BaseAct {


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;

    @BindView(R.id.list_card)
    ListView list_card;

    @BindView(R.id.text_add)
    TextView text_add;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_bank_card;
    }

    @Override
    protected void findViews() {
        if (toolbar_all != null) {
            TextView text_center = (TextView) toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("银行卡");
        }
    }

    @Override
    public void initData() {

        ArrayList<String> datas = new ArrayList<>();

        datas.clear();


        for (int i = 0; i < 4; i++) {
            datas.add("");
        }

        myListAdapter = new MyListAdapter(datas, this);

        list_card.setAdapter(myListAdapter);


    }


    @OnClick({R.id.text_add})
    public void OnClick(View view) {

        switch (view.getId()) {
            case R.id.text_add:

                startActivity(ActAddCard.class);

                break;
        }

    }


    private MyListAdapter myListAdapter;


    public class MyListAdapter extends BaseAdapter {


        private ArrayList<String> datas = new ArrayList<>();

        private LayoutInflater inflater;

        public MyListAdapter(ArrayList<String> datas, Context context) {

            this.datas.clear();
            this.datas.addAll(datas);

            this.inflater = LayoutInflater.from(context);

        }


        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int i) {
            return datas.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            final MyViewHolder myViewHolder = new MyViewHolder();

            convertView = inflater.inflate(R.layout.item_card, parent, false);


            return convertView;

        }


        public class MyViewHolder {


        }


    }


}
