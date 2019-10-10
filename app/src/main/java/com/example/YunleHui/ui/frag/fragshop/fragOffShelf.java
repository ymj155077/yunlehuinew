package com.example.YunleHui.ui.frag.fragshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.YunleHui.Bean.Bean_spgl;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseFrag;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.ClearEditText;
import com.example.YunleHui.view.MyXrecycleview;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by admin on 2019/8/30 0030.
 * <p>
 * <p>
 * 已下架
 */

public class fragOffShelf extends BaseFrag {


    @BindView(R.id.xre_shelf)
    MyXrecycleview xre_shelf;


    @BindView(R.id.frag_chu)
    FrameLayout frag_chu;

    @BindView(R.id.text_sure)
    TextView text_sure;

    private MyRecycleViewAdapter myRecycleViewAdapter;

    @BindView(R.id.text_title)
    TextView text_title;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(), clz));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_off_shelf;
    }

    @BindView(R.id.edit_earch)
    ClearEditText edit_earch;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        edit_earch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // 先隐藏键盘       
                    //接下来写点击搜索按钮之后的逻辑     
                    ((InputMethodManager)getActivity().getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                    goodsName = v.getText().toString();
                    xre_shelf.refresh();

                    return true;
                }
                return false;
            }
        });
    }


    private String goodsName = "";

    private int state = 2;


    @Override
    protected void initData() {
        Tools.setManger(xre_shelf, getActivity());


        xre_shelf.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
//                page = 1;
//                type = 0;
//                HttpUtil.addMapparams();
//                params.put("longitude", "");
//                params.put("latitude", "");
//                params.put("shopClassId", "");
//                params.put("shopCityId", "");
//                params.put("offset", "");
                HttpUtil.addMapparams();
                HttpUtil.params.put("goodsName", goodsName);

                HttpUtil.params.put("state", state);

                HttpUtil.Post_request("backShop/goods/list", HttpUtil.params);

                getdata("backShop/two");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xre_shelf.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {
//                ++page;
//                type = 2;
//                HttpUtil.addMapparams();
//                params.put("longitude", "");
//                params.put("latitude", "");
//                params.put("shopClassId", "");
//                params.put("shopCityId", "");
//                params.put("offset", "");
//                HttpUtil.Post_request("frontShop/recommendGoods", params);
//                HttpUtil.getAsynHttp("frontShop/recommendGoods?" +
//                        "longitude=" + "" +
//                        "&latitude=" + "" +
//                        "&shopClassId=" + "" +
//                        "&shopCityId=" + "" +
//                        "&offset=" + ""
//                );
//                getdata("frontShop/recommendGoods");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xre_shelf.loadMoreComplete();
                    }
                }, 1000);
            }
        });


        xre_shelf.refresh();


    }


    public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {


        private LayoutInflater inflater;

        private ArrayList<Bean_spgl.DataBean> datas = new ArrayList<>();

        private Context context;

        public MyRecycleViewAdapter(List<Bean_spgl.DataBean> datas, Context context) {

            this.datas.clear();

            this.datas.addAll(datas);

            this.context = context;

            this.inflater = LayoutInflater.from(context);

        }


        public void clear_data(ArrayList<Bean_spgl.DataBean> datas) {

            this.datas.clear();
            this.datas.addAll(datas);

            notifyDataSetChanged();

        }


        public void add_data(ArrayList<Bean_spgl.DataBean> datas) {

            this.datas.addAll(datas);

            notifyDataSetChanged();

        }

        @Override
        public MyRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ietm_xiajia, parent, false);
            return new MyRecycleViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyRecycleViewAdapter.ViewHolder holder, final int position) {

//            private ImageView img_shop;
//            private TextView text_details;
//            private TextView text_t;
//            private TextView text_price;
//            private TextView text_number;
//            private TextView text_deltel;
//            private TextView text_Reinstall;


            Glide.with(getActivity()).load(datas.get(position).getLogoUrl()).into(holder.img_shop);
            holder.text_details.setText(datas.get(position).getGoodsName());
            try {
                holder.text_t.setText(datas.get(position).getSetMealList().get(0).getSetMealName());
            } catch (Exception e) {

            }

            holder.text_price.setText(Tools.chenfa(datas.get(position).getSetMealList().get(0).getPrice()));
            holder.text_number.setText(datas.get(position).getSaleNum() + "");


//删除
            holder.text_deltel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    text_title.setText("是否删除");
                    type = 0;
                    if (frag_chu.getVisibility() == View.VISIBLE) {
                        frag_chu.setVisibility(View.GONE);
                    } else {
                        frag_chu.setVisibility(View.VISIBLE);
                    }
                }
            });
//上架
            holder.text_Reinstall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    text_title.setText("是否上架");
                    goodsId = datas.get(position).getId();
                    type = 1;
                    if (frag_chu.getVisibility() == View.VISIBLE) {
                        frag_chu.setVisibility(View.GONE);
                    } else {
                        frag_chu.setVisibility(View.VISIBLE);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private LinearLayout lin_details;

            private ImageView img_shop;
            private TextView text_details;
            private TextView text_t;
            private TextView text_price;
            private TextView text_number;
            private TextView text_deltel;
            private TextView text_Reinstall;

            public ViewHolder(View itemView) {
                super(itemView);
                lin_details = (LinearLayout) itemView.findViewById(R.id.lin_details);
                img_shop = (ImageView) itemView.findViewById(R.id.img_shop);
                text_details = (TextView) itemView.findViewById(R.id.text_details);
                text_t = (TextView) itemView.findViewById(R.id.text_t);
                text_price = (TextView) itemView.findViewById(R.id.text_price);
                text_number = (TextView) itemView.findViewById(R.id.text_number);
                text_deltel = (TextView) itemView.findViewById(R.id.text_deltel);
                text_Reinstall = (TextView) itemView.findViewById(R.id.text_Reinstall);

            }
        }
    }


    private Bean_spgl bean_spgl;
    private boolean success;
    private int code;
    private String msg;
    private List<Bean_spgl.DataBean> data;


    @Override
    public void stringResulit(String key, String value) {

        if (key.equals("backShop/two")) {


            bean_spgl = MyApp.gson.fromJson(value, Bean_spgl.class);
            code = bean_spgl.getCode();

            if (code == 200) {
                data = bean_spgl.getData();
                myRecycleViewAdapter = new MyRecycleViewAdapter(data, getActivity());
                xre_shelf.setAdapter(myRecycleViewAdapter);
            }
        }


        if (key.equals("backShop/goods/updateGoodsState")) {
            xre_shelf.refresh();
        }

    }


    private int type = 0;

    private int goodsId = 0;


    @OnClick({R.id.text_sure, R.id.text_cancel})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.text_sure:
//删除
                if (type == 0) {
                    Toast.makeText(getActivity(), "确定", Toast.LENGTH_SHORT).show();

                    frag_chu.setVisibility(View.GONE);

//                    HttpUtil.addMapparams();
//
//                    HttpUtil.params.put("state", 1);
//
//                    HttpUtil.params.put("goodsId", goodsId);
//
//                    HttpUtil.deleteRequest("backShop/goods/updateGoodsState", HttpUtil.params);
//
//                    getdata("backShop/goods/updateGoodsState");
                } else {
//                    更新
                    Toast.makeText(getActivity(), "确定", Toast.LENGTH_SHORT).show();

                    frag_chu.setVisibility(View.GONE);

                    HttpUtil.addMapparams();

                    HttpUtil.params.put("state", 1);

                    HttpUtil.params.put("goodsId", goodsId);

                    HttpUtil.put_Request("backShop/goods/updateGoodsState", HttpUtil.params);

                    getdata("backShop/goods/updateGoodsState");
                }


                break;
            case R.id.text_cancel:

                Toast.makeText(getActivity(), "取消", Toast.LENGTH_SHORT).show();

                frag_chu.setVisibility(View.GONE);

                break;
        }
    }

}
