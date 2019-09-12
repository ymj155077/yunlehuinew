package com.example.YunleHui.ui.frag.fragShopMalls;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.YunleHui.R;
import com.example.YunleHui.base.BaseFrag;
import com.example.YunleHui.utils.SpacesItemDecoration;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.MyXrecycleview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by admin on 2019/8/13 0013.
 *
 * 美食
 *
 */

public class fragbefood extends BaseFrag{

    private MasonryAdapter masonryAdapter;


    @BindView(R.id.xrecyle_food)
    MyXrecycleview xrecyle_food;

    @Override
    protected int getLayoutId() {
        return R.layout.fragbefood;
    }

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(),clz));
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {
        
        Tools.setShoppingManger(xrecyle_food,getActivity());

        ArrayList<Integer> datas = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            datas.add(R.drawable.timg);
        }


        masonryAdapter = new MasonryAdapter(datas);

        xrecyle_food.setAdapter(masonryAdapter);

        //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        xrecyle_food.addItemDecoration(decoration);

    }

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        private int space;

        public SpacesItemDecoration(int space) {
            this.space=space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left=space;
            outRect.right=space;
            outRect.bottom=space;
            if(parent.getChildAdapterPosition(view)==0){
                outRect.top=space;
            }
        }
    }







    public class MasonryAdapter extends RecyclerView.Adapter<MasonryAdapter.MasonryView>{
        private List<Integer> products;


        public MasonryAdapter(List<Integer> list) {
            products=list;
        }

        @Override
        public MasonryView onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.masonry_item, viewGroup, false);
            return new MasonryView(view);
        }

        @Override
        public void onBindViewHolder(MasonryView masonryView, int position) {
            masonryView.imageView.setImageResource(products.get(position));


        }

        @Override
        public int getItemCount() {
            return products.size();
        }

        public  class MasonryView extends  RecyclerView.ViewHolder{

            ImageView imageView;
            TextView textView;

            public MasonryView(View itemView){
                super(itemView);
                imageView= (ImageView) itemView.findViewById(R.id.masonry_item_img );
//                textView= (TextView) itemView.findViewById(R.id.masonry_item_title);
            }

        }

    }






}
