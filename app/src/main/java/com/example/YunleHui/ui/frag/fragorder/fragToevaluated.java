package com.example.YunleHui.ui.frag.fragorder;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.YunleHui.Bean.Bean_no_use;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseFrag;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.MyXrecycleview;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *
 *
 * 待评价
 *
 * */



public class fragToevaluated extends BaseFrag {

    private int offset = 1;
    private int max = 10;
    private int type = 0;

    @BindView(R.id.xrecyc_beevaluated)
    MyXrecycleview xrecyc_beevaluated;



    private Bean_no_use bean_no_use;
    private boolean success;
    private int code;
    private String msg;
    private Bean_no_use.DataBean data;


    private List<Bean_no_use.DataBean.VoListBean> voList;

    private ArrayList<Bean_no_use.DataBean.VoListBean> voList_ = new ArrayList<>();


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(),clz));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragtoevaluated;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

        Tools.setManger(xrecyc_beevaluated, getActivity());

        try {
            xrecyc_beevaluated.setLoadingListener(new XRecyclerView.LoadingListener() {
                @Override
                public void onRefresh() {

//                    offset = 1;
//                    type = 0;
//                    HttpUtil.addMapparams();
//                    HttpUtil.params.put("userId", MyApp.user);
//                    HttpUtil.params.put("state", 6);
//                    HttpUtil.params.put("sort", 0);
//                    HttpUtil.params.put("offset", offset);
//                    HttpUtil.params.put("max", max);
//                    HttpUtil.postRaw("orderFull/list", HttpUtil.params);
//                    getdata("3_list");

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            xrecyc_beevaluated.refreshComplete();
                        }
                    }, 1000);
                }

                @Override
                public void onLoadMore() {

                    offset = 1;
                    type = 0;
//                    HttpUtil.addMapparams();
//                    HttpUtil.params.put("userId", MyApp.user);
//                    HttpUtil.params.put("state", 6);
//                    HttpUtil.params.put("sort", 0);
//                    HttpUtil.params.put("offset", offset);
//                    HttpUtil.params.put("max", max);
//                    HttpUtil.postRaw("orderFull/list", HttpUtil.params);
//                    getdata("3_list");

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            xrecyc_beevaluated.loadMoreComplete();
                        }
                    }, 1000);
                }
            });

        } catch (Exception e) {

        }
        xrecyc_beevaluated.refresh();
    }
}
