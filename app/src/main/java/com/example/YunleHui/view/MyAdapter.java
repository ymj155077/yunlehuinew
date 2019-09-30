/*
 * Copyright 2017 GcsSloop
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Last modified 2017-09-18 23:47:01
 *
 * GitHub: https://github.com/GcsSloop
 * WeiBo: http://weibo.com/GcsSloop
 * WebSite: http://www.gcssloop.com
 */

package com.example.YunleHui.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.Bean_cai;
import com.example.YunleHui.R;
import com.example.YunleHui.ui.act.acthome.ActSearch;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;


//public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
//
//    ArrayList<Bean_cai.DataBean> data = new ArrayList<>();
//
//    private Context context;
//
//    private int mCurrentItem = 0;
//    private boolean isClick = false;
//
//    private int id;
//
//    public MyAdapter(ArrayList<Bean_cai.DataBean> datas, Context context) {
//
//        this.data.clear();
//        this.data.addAll(datas);
//        this.context = context;
//
//    }
//
//
//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        //    Log.i("GCS", "onCreateViewHolder");
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View view = inflater.inflate(R.layout.layout_item, parent, false);
//        return new MyViewHolder(view);
//    }
//
//    public void setCurrentItem(int currentItem) {
//        this.mCurrentItem = currentItem;
//    }
//
//
//    public void setClick(boolean click) {
//        this.isClick = click;
//    }
//
//
//    @Override
//    public void onBindViewHolder(final MyViewHolder holder, final int position) {
//
//
//
//
//        if (mCurrentItem == position & isClick) {
//            holder.tv_title.setTextColor(Color.parseColor("#FF6C4B"));
//        } else {
//            holder.tv_title.setTextColor(Color.parseColor("#181931"));
//        }
//
//
//
//
//
//        //   Log.i("GCS","onBindViewHolder = "+position);
//        final String title = data.get(position).getClassName();
//        holder.tv_title.setText(title);
//
//        Glide.with(context).load(data.get(position).getClassLogoUrl()).into(holder.round_me);
//
//
//        id = data.get(position).getId();
//        Log.i("GCS", "onBindViewHolder = " + id);
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//                myListAdpter.setCurrentItem(position);
//                myListAdpter.setClick(true);
//                myListAdpter.notifyDataSetChanged();
//
//
//
//
////                Toast.makeText(v.getContext(), "item" + title + " 被点击了" + "---" + data.get(position).getId(), Toast.LENGTH_SHORT).show();
////                holder.tv_title.setText("G "+title);
//
////                notifyItemChanged(position);
////                Intent intent = new Intent(context,ActSearch.class);
////
////                intent.putExtra("shopClassId",data.get(position).getId());
////
////                intent.putExtra("foodName",data.get(position).getClassName());
////
////                context.startActivity(intent);
//
//
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return data.size();
//    }
//
//    class MyViewHolder extends RecyclerView.ViewHolder {
//        TextView tv_title;
//        RoundedImageView round_me;
//
//        public MyViewHolder(View itemView) {
//            super(itemView);
//            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
//            round_me = (RoundedImageView) itemView.findViewById(R.id.round_me);
//        }
//    }
//}
