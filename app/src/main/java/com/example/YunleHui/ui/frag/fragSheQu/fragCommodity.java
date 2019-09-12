package com.example.YunleHui.ui.frag.fragSheQu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseFrag;
import com.example.YunleHui.ui.act.ActComPur.ActComMall;
import com.example.YunleHui.ui.act.actme.actbusiness.ActBusDetails;
import com.example.YunleHui.ui.act.actme.actbusiness.ActOrderPayCom;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.MyXrecycleview;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by admin on 2019/9/2 0002.
 * <p>
 * <p>
 * <p>
 * 商品
 */

public class fragCommodity extends BaseFrag {


    @BindView(R.id.lin_ok)
LinearLayout lin_ok;

    @BindView(R.id.lin_mall)
    LinearLayout lin_mall;


//    弹窗的list


    @BindView(R.id.list_gou)
    ListView list_gou;


    @BindView(R.id.text_Num)
    TextView text_Num;




    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(), clz));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_commodity;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }


    @BindView(R.id.xre_mall)
    MyXrecycleview xre_mall;

    @Override
    protected void initData() {

        Tools.setManger(xre_mall, getActivity());
//购物车
        ArrayList<Integer> dats = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            dats.add(0);
        }
        MyRecycleViewAdapter myRecycleViewAdapter = new MyRecycleViewAdapter(dats, getActivity());

        xre_mall.setAdapter(myRecycleViewAdapter);


        //        购物车 弹窗
        ArrayList<String> datass = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            datass.add("");
        }
        MyPopAdapter myGouAdapter = new MyPopAdapter(datass, getActivity());

        list_gou.setAdapter(myGouAdapter);


    }


    @OnClick({R.id.lin_boom_gou,R.id.lin_ok})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.lin_boom_gou:


                if (lin_mall.getVisibility() == View.GONE) {
                    lin_mall.setVisibility(View.VISIBLE);
                } else {
                    lin_mall.setVisibility(View.GONE);
                }


                break;
            case R.id.lin_ok:
                startActivity(ActOrderPayCom.class);
                break;
        }
    }


    public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {
        private LayoutInflater inflater;
        private ArrayList<Integer> datas = new ArrayList<>();
        private Context context;

        public MyRecycleViewAdapter(ArrayList<Integer> datas, Context context) {
            this.datas.clear();
            this.datas.addAll(datas);
            this.context = context;
            this.inflater = LayoutInflater.from(context);
        }

        public void clear_data(ArrayList<Integer> datas) {
            this.datas.clear();
            this.datas.addAll(datas);
            notifyDataSetChanged();
        }

        public void add_data(ArrayList<Integer> datas) {
            this.datas.addAll(datas);
            notifyDataSetChanged();
        }

        @Override
        public MyRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wandax, parent, false);
            return new MyRecycleViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyRecycleViewAdapter.ViewHolder holder, final int position) {


            holder.text_number.setText(datas.get(position) + "");


            holder.lin_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, ActBusDetails.class));
                }
            });
            holder.img_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.text_number.setText(Integer.valueOf(holder.text_number.getText().toString()) + 1 + "");

                    datas.set(position, Integer.valueOf(holder.text_number.getText().toString()));

                    notifyDataSetChanged();

                    text_Num.setText(Integer.valueOf(text_Num.getText().toString()) + 1 + "");

                }
            });
            holder.img_jian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Integer.valueOf(holder.text_number.getText().toString()) == 0) {
                        Toast.makeText(context, "没有了！！！", Toast.LENGTH_SHORT).show();
                    } else {
                        holder.text_number.setText(Integer.valueOf(holder.text_number.getText().toString()) - 1 + "");

                        datas.set(position, Integer.valueOf(holder.text_number.getText().toString()));

                        notifyDataSetChanged();


                        text_Num.setText(Integer.valueOf(text_Num.getText().toString()) - 1 + "");


                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return
                    datas.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private LinearLayout lin_details;
            private ImageView img_jian;
            private ImageView img_add;
            private TextView text_number;

            public ViewHolder(View itemView) {
                super(itemView);
                lin_details = (LinearLayout) itemView.findViewById(R.id.lin_details);
                img_jian = (ImageView) itemView.findViewById(R.id.img_jian);
                img_add = (ImageView) itemView.findViewById(R.id.img_add);
                text_number = (TextView) itemView.findViewById(R.id.text_number);
            }
        }
    }


//弹窗的adpter


    public class MyPopAdapter extends BaseAdapter {

        private ArrayList<String> datas = new ArrayList<>();
        private LayoutInflater inflater;

        public MyPopAdapter(ArrayList<String> datas, Context context) {

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
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


            MyViewHolder myViewHolder = new MyViewHolder();


            convertView = inflater.inflate(R.layout.item_gou_list, parent, false);


            return convertView;
        }


        public class MyViewHolder {


        }


    }


}
