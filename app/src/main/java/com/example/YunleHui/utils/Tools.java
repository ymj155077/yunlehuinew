package com.example.YunleHui.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.ui.act.actme.ActLogin;
import com.example.YunleHui.view.MyXrecycleview;
import com.jcodecraeer.xrecyclerview.ProgressStyle;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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

//乘以0.01
    public static String chenfa(double x) {

        BigDecimal a = BigDecimal.valueOf(x);
        BigDecimal b = BigDecimal.valueOf(0.01);
        BigDecimal c = a.multiply(b);

        DecimalFormat format = new DecimalFormat("0.00");
        String abc = c + "";
        String aaa = format.format(new BigDecimal(abc));

        return aaa;
    }
//乘以100
    public static String chenfaadd(double x) {

        BigDecimal a = BigDecimal.valueOf(x);
        BigDecimal b = BigDecimal.valueOf(100);
        BigDecimal c = a.multiply(b);

        DecimalFormat format = new DecimalFormat("0.00");
        String abc = c + "";
        String aaa = format.format(new BigDecimal(abc));

        return aaa;
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

    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //如果它本来就是long类型的,则不用写这一步
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    //保留两位小数
    public static String LiangWei() {
        DecimalFormat format = new DecimalFormat("0.00");
        String abc = "100.456";
        String a = format.format(new BigDecimal(abc));
        return a;
    }


//    判断是否已经登录了


    public static int IsLogin(Context context) {

        int user = (Integer) MyApp.getSharedPreference(context, "user", 0);
        Log.i("withirederence", user + "---");
        return user;
    }


    // 默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;


    /**
     * 说明：
     * 提供精确的加法运算
     * 创建人: 李林君 邮箱：
     * 创建日期: 2013-9-28
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static String Gouadd(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        // 建议写string类型的参数，下同
        BigDecimal b2 = new BigDecimal(v2);


        DecimalFormat format = new DecimalFormat("0.00");
        String abc = b1.add(b2).toString();
        String aaa = format.format(new BigDecimal(abc));


        return aaa;
    }

    /**
     * 说明：
     * 提供精确的减法运算
     * 创建人: 李林君 邮箱：
     * 创建日期: 2013-9-28
     *
     * @param v1
     * @param v2
     * @return
     */
    public static String GouJian(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);


        DecimalFormat format = new DecimalFormat("0.00");


        String abc = b1.subtract(b2).toString();
        String aaa = format.format(new BigDecimal(abc));


        return aaa;
    }

    /**
     * 说明：
     * 提供精确的乘法运算
     * 创建日期: 2013-9-28
     *
     * @param v1
     * @param v2
     * @return
     */
    public static double GouChen(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 说明：
     * 提供相对精确的除法运算，当发生除不尽的情况，精确到.后10位
     * 创建人: 李林君 邮箱
     * 创建日期: 2013-9-28
     *
     * @param v1
     * @param v2
     * @return
     */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 说明：
     * 创建人: 李林君 邮箱：
     * 创建日期: 2013-9-28
     *
     * @param v1
     * @param v2
     * @param scale
     * @return
     */
    private static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(" the scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
        // scale 后的四舍五入
    }

//
    public static String getStarPhone(String mobile) {
        if (!TextUtils.isEmpty(mobile)) {
            if (mobile.length() >= 11) {
                return mobile.substring(0, 3) + "****" + mobile.substring(7, mobile.length());
            }
        } else {
            return "";
        }
        return mobile;
    }




    //全局的自定义的弹窗
    public static View setPop(Context context,

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
        mBottomSheetPop.showAtLocation(rootview, Gravity.CENTER_VERTICAL, 0, 0);
        view.setFocusable(true);//comment by danielinbiti,设置view能够接听事件，标注1
        view.setFocusableInTouchMode(true); //comment by danielinbiti,设置view能够接听事件 标注2
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
                if (arg1 == KeyEvent.KEYCODE_BACK) {
                    if (mBottomSheetPop != null) {
                        mBottomSheetPop.dismiss();
                    }
                }
                return false;
            }
        });
//        点击取消
        LinearLayout lin_pop_type = (LinearLayout) view.findViewById(R.id.lin_pop_type);
        lin_pop_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetPop.dismiss();
            }
        });

        mBottomSheetPop.setAnimationStyle(R.style.popwin_anim_style);

        return view;
    }










    public static void fitPopupWindowOverStatusBar(PopupWindow mPopupWindow, boolean needFullScreen) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                Field mLayoutInScreen = PopupWindow.class.getDeclaredField("mLayoutInScreen");
                mLayoutInScreen.setAccessible(needFullScreen);
                mLayoutInScreen.set(mPopupWindow, needFullScreen);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }









}