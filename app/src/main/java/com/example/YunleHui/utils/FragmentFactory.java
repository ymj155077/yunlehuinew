package com.example.YunleHui.utils;

import android.support.v4.app.Fragment;

import com.example.YunleHui.ui.frag.fragSheQu.fragCommodity;
import com.example.YunleHui.ui.frag.fragSheQu.fragbusiness;
import com.example.YunleHui.ui.frag.fragShopEvalu.fragAnswered;
import com.example.YunleHui.ui.frag.fragShopEvalu.fragReplied;
import com.example.YunleHui.ui.frag.fragShopMalls.fragbeauty;
import com.example.YunleHui.ui.frag.fragShopMalls.fragbefood;
import com.example.YunleHui.ui.frag.fragShopMalls.frageducation;
import com.example.YunleHui.ui.frag.fragShopMalls.fragentment;
import com.example.YunleHui.ui.frag.fragShopMalls.fragtravel;
import com.example.YunleHui.ui.frag.fragmessage.fragGoodfriend;
import com.example.YunleHui.ui.frag.fragmessage.fragNotice;
import com.example.YunleHui.ui.frag.fragmessage.fragchat;
import com.example.YunleHui.ui.frag.fragorder.fragToevaluated;
import com.example.YunleHui.ui.frag.fragorder.fragToused;
import com.example.YunleHui.ui.frag.fragorder.fragUsed;
import com.example.YunleHui.ui.frag.fragorder.fragnoTused;
import com.example.YunleHui.ui.frag.fragorder.fragrefund;
import com.example.YunleHui.ui.frag.fragshop.fragAdded;
import com.example.YunleHui.ui.frag.fragshop.fragConsumed;
import com.example.YunleHui.ui.frag.fragshop.fragOffShelf;
import com.example.YunleHui.ui.frag.fragshop.fragOnSale;
import com.example.YunleHui.ui.frag.fragshop.fragToVerified;
import com.example.YunleHui.ui.frag.fragshop.fragUnorders;


/**
 * Created by shan_yao on 2016/6/17.
 */
public class FragmentFactory {
    public static Fragment createForNoExpand(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
//                美食
                fragment = new fragbefood();
                break;
            case 1:
//                娱乐
                fragment = new fragentment();
                break;
            case 2:
//                丽人
                fragment = new fragbeauty();
                break;

            case 3:
//              旅游
                fragment = new fragtravel();
                break;
//教育
            case 4:
                fragment = new frageducation();
                break;
        }
        return fragment;
    }






    //商品管理
    public static Fragment ComAnagement(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new fragOnSale();
                break;
            case 1:
                fragment = new fragOffShelf();
                break;
        }
        return fragment;
    }




    //商户评价管理
    public static Fragment EvaManage(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new fragAnswered();
                break;
            case 1:
                fragment = new fragReplied();
                break;
        }
        return fragment;
    }




//核销商户
    public static Fragment createWriteoff(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new fragAdded();
                break;
            case 1:
                fragment = new fragToVerified();
                break;
        }
        return fragment;
    }




    public static Fragment createbill(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new fragToused();
                break;
            case 1:
                fragment = new fragnoTused();
                break;
            case 2:
                fragment = new fragUsed();
                break;
            case 3:
                fragment = new fragToevaluated();
                break;
            case 4:
                fragment = new fragrefund();
                break;
        }
        return fragment;
    }





//    消息管理



    public static Fragment createChat(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new fragNotice();
                break;
            case 1:
                fragment = new fragchat();
                break;
            case 2:
                fragment = new fragGoodfriend();
                break;
        }
        return fragment;
    }







//    评价管理


    public static Fragment createEvalman(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
//                fragment = new fragNoRes();
//                break;
//            case 1:
//                fragment = new fragReplied();
//                break;
//            case 2:
//                fragment = new fragAll();
                break;
        }
        return fragment;
    }





    public static Fragment ShopCenter(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new fragCommodity();
                break;
            case 1:
                fragment = new fragbusiness();
                break;
        }
        return fragment;
    }
















}
