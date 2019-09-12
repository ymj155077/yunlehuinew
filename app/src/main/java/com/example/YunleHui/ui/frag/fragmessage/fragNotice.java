package com.example.YunleHui.ui.frag.fragmessage;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseFrag;

import java.util.ArrayList;

import butterknife.BindView;

/**
 *
 *
 * 通知
 *
 *
 * */

public class fragNotice extends BaseFrag {



    @BindView(R.id.list_notice)
    ListView list_notice;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(),clz));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_notice;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {


        ArrayList<String> datas = new ArrayList<>();

        datas.clear();
        for (int i = 0; i < 10; i++) {
            datas.add("");
        }


        MyAdapter myAdapter = new MyAdapter(datas,getActivity());
        list_notice.setAdapter(myAdapter);


    }






    public class MyAdapter extends BaseAdapter{


        ArrayList<String> datas = new ArrayList<>();

        private LayoutInflater inflater;


        public MyAdapter(ArrayList<String> datas, Context context){
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

            MyViewHolder myViewHolder = null;

            if (convertView==null){
                convertView = inflater.inflate(R.layout.item_notion,parent,false);

                convertView.setTag(myViewHolder);

            }else {
              myViewHolder = (MyViewHolder) convertView.getTag();
            }


            return convertView;
        }


        public class MyViewHolder{

        }



    }













}
