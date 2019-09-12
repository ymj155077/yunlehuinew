package com.example.YunleHui.adpter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.BeanHomeList;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.ui.act.acthome.ActComdetails;

import java.util.ArrayList;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {

    private LayoutInflater inflater;

    private ArrayList<BeanHomeList.DataBean.VoListBean> datas = new ArrayList<>();

    private Context context;

    public MyRecycleViewAdapter(ArrayList<BeanHomeList.DataBean.VoListBean> datas, Context context) {

        this.datas.clear();

        this.datas.addAll(datas);

        this.context = context;

        this.inflater = LayoutInflater.from(context);

    }


    public void clear_data(ArrayList<BeanHomeList.DataBean.VoListBean> datas) {

        this.datas.clear();
        this.datas.addAll(datas);

        notifyDataSetChanged();

    }


    public void add_data(ArrayList<BeanHomeList.DataBean.VoListBean> datas) {

        this.datas.addAll(datas);

        notifyDataSetChanged();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hone, parent, false);
        return new MyRecycleViewAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
//            try {

//                Glide.with(context).load(datas.get(position).getLogoUrl()).into(holder.img_home);

        holder.text_peice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);

        holder.text_peice.setText(datas.get(position).getOriginalPrice() * 0.01 + "");

//        private TextView text_shop_name;

        holder.text_shop_name.setText(datas.get(position).getName());
//
//        private TextView text_context;

        holder.text_context.setText(datas.get(position).getIntro() + "");

        holder.text_size.setText("销量" + datas.get(position).getSalesVolume() + "");

        try {
            holder.text_juli.setText(datas.get(position).getDistance());
        }catch (Exception e){

        }
        
//        private ImageView img_home;
//
//        private TextView price_down;
//
//        private TextView text_peice;
//
//        private TextView text_size;
//
//        private TextView text_Commission;


        Glide.with(context).load(datas.get(position).getLogoUrl()).into(holder.img_home);

        holder.price_down.setText(datas.get(position).getPrice() * 0.01 + "");

        holder.text_Commission.setText("佣金￥" + datas.get(position).getCommission() * 0.01 + "");


//            } catch (Exception e) {

        holder.linfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(context, ActComdetails.class);

                MyApp.order_ty = 0;

                intent.putExtra("shop_id", datas.get(position).getId());

                context.startActivity(intent);
            }
        });


//            }
    }

    @Override
    public int getItemCount() {
        return
                datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView text_shop_name;

        private TextView text_context;


        private ImageView img_home;

        private TextView price_down;

        private TextView text_peice;

        private TextView text_size;

        private TextView text_Commission;


        private LinearLayout linfood;

        private TextView text_juli;


        public ViewHolder(View itemView) {
            super(itemView);


            text_shop_name = (TextView) itemView.findViewById(R.id.text_shop_name);
            text_context = (TextView) itemView.findViewById(R.id.text_context);
            price_down = (TextView) itemView.findViewById(R.id.price_down);
            text_size = (TextView) itemView.findViewById(R.id.text_size);
            text_Commission = (TextView) itemView.findViewById(R.id.text_Commission);


            img_home = (ImageView) itemView.findViewById(R.id.img_home);
            text_peice = (TextView) itemView.findViewById(R.id.text_peice);


            linfood = (LinearLayout) itemView.findViewById(R.id.linfood);

            text_juli = (TextView) itemView.findViewById(R.id.text_juli);

        }
    }
}



