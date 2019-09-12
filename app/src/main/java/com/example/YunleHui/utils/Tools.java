package com.example.YunleHui.utils;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.YunleHui.R;
import com.example.YunleHui.view.MyXrecycleview;
import com.jcodecraeer.xrecyclerview.ProgressStyle;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2019/8/12 0012.
 */

public class Tools {

    public static PopupWindow mPopupWindow;


    public static void i(String tag, String msg) {  //信息太长,分段打印
        //因为String的length是字符数量不是字节数量所以为了防止中文字符过多，
        //  把4*1024的MAX字节打印长度改为2001字符数
        int max_str_length = 2001 - tag.length();
        //大于4000时
        while (msg.length() > max_str_length) {
            Log.i(tag, msg.substring(0, max_str_length));
            msg = msg.substring(max_str_length);
        }
        //剩余部分
        Log.i(tag, msg);
    }

    public static void setManger(MyXrecycleview xRecyclerView, Context context) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);
        xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallPulse);
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallPulse);
    }


    public static void setShoppingManger(MyXrecycleview xRecyclerView, Context context) {

        xRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallPulse);
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallPulse);

    }


//    public static View showPopUp(View view, Context context) {
//
//        View contentView = LayoutInflater.from(context).inflate(R.layout.result_page_popup_window, null);
//
//        TextView popupText = contentView.findViewById(R.id.play_again_text);
//        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("Play the game \nagain");
//        popupText.setText(spannableStringBuilder);
//
//        mPopupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
//        mPopupWindow.setTouchable(true);
//        mPopupWindow.setOutsideTouchable(true);
//        mPopupWindow.setTouchInterceptor(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return false;
//            }
//        });
//        mPopupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.color.popup_background));
//        int width = mPopupWindow.getWidth();
//        int[] xy = new int[2];
//        view.getLocationInWindow(xy);
//        mPopupWindow.showAtLocation(view, Gravity.NO_GRAVITY,
//                xy[0] + (DimenUtils.dp2px(width) - view.getWidth()) / 2, xy[1] - DimenUtils.dp2px(50));
//    }


    //    获取支付的类型
    public static String payWay(int payWay) {
        if (payWay == 0) {
            return "支付宝";
        } else if (payWay == 1) {
            return "余额";
        } else if (payWay == 2) {
            return "微信";
        }
        return "未知";
    }


    public static BigDecimal chenfa(double x) {
        BigDecimal a = BigDecimal.valueOf(x);
        BigDecimal b = BigDecimal.valueOf(0.01);
        BigDecimal c = a.multiply(b);
        return c;
    }


    public static PopupWindow mBottomSheetPop;


    //全局的自定义的弹窗
    public static View setRebuildPop(Context context,

//    当前pop的布局
                                     @LayoutRes int layoutResID_pop,
//    当前activity的布局
                                     @LayoutRes int layoutResID_act
    ) {

        View view = LayoutInflater.from(context)
                .inflate(layoutResID_pop, null);
        //设置contentView
        mBottomSheetPop = new PopupWindow(view,
                LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                LinearLayoutCompat.LayoutParams.MATCH_PARENT, true);
        mBottomSheetPop.setContentView(view);

//        mBottomSheetPop.setFocusable(false);// 这个很重要

        //显示PopupWindow  act_hotel_book_layout
        View rootview = LayoutInflater.from(context).inflate(layoutResID_act, null);

        view.setFocusable(true);//comment by danielinbiti,设置view能够接听事件，标注1

        //设置触摸
        mBottomSheetPop.setTouchable(true);

        view.setFocusableInTouchMode(true); //comment by danielinbiti,设置view能够接听事件 标注2
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
                if (arg1 == KeyEvent.KEYCODE_BACK) {
                    if (mBottomSheetPop != null) {

                        Log.i("onKey", "--------------");

                        mBottomSheetPop.dismiss();
                    }
                }
                return false;
            }
        });
////        点击取消
//        LinearLayout lin_pop_type = (LinearLayout) view.findViewById(R.id.lin_pop_type);
//        lin_pop_type.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mBottomSheetPop.dismiss();
//            }
//        });

//        mBottomSheetPop.setAnimationStyle(R.style.popwin_anim_style);
        mBottomSheetPop.showAtLocation(rootview, Gravity.CENTER_VERTICAL, 0, 0);

        mBottomSheetPop.setClippingEnabled(false);

        return view;
    }





    /*
     * 将时间戳转换为时间
     *
     * s就是时间戳
     */

    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //如果它本来就是long类型的,则不用写这一步
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }




}