package com.example.YunleHui;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.ui.frag.fragComPur;
import com.example.YunleHui.ui.frag.fragExplosive;
import com.example.YunleHui.ui.frag.fragMe;
import com.example.YunleHui.ui.frag.fragMessage;
import com.example.YunleHui.ui.frag.fragShopMall;
import com.example.YunleHui.view.BottomBar;
import com.tbruyelle.rxpermissions.Permission;
import com.tbruyelle.rxpermissions.RxPermissions;

import rx.functions.Action1;

public class MainActivity extends BaseAct {

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this,clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }



    @Override
    public void initData() {
        RxPermissions.getInstance(MainActivity.this)

                .requestEach(Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.READ_PHONE_STATE
                )
                .subscribe(new Action1<Permission>() {
                    @Override
                    public void call(Permission permission) {
                        if (permission.name.equals(Manifest.permission.ACCESS_FINE_LOCATION)) {

                            Log.i("permissions", Manifest.permission.ACCESS_FINE_LOCATION + "：" + permission.granted);
                        }
                    }
                });

        bottomBar = findViewById(R.id.bottom_bar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            bottomBar.setContainer(R.id.fl_container)
                    .setTitleBeforeAndAfterColor("#999999", "#ff5d5e")
                    .addItem(fragExplosive.class,
                            "爆款",
                            R.drawable.item1_before,
                            R.drawable.item1_after)
                    .addItem(fragShopMall.class,
                            "商城",
                            R.drawable.item2_before,
                            R.drawable.item2_after)

                    .addItem(fragComPur.class,
                            "社区购",
                            R.drawable.shequ,
                            R.drawable.avm
                            )


                    .addItem(fragMessage.class,
                            "消息",
                            R.drawable.item3_before,
                            R.drawable.item3_after)


                    .addItem(fragMe.class,
                            "我的",
                            R.drawable.item4_after,
                            R.drawable.wode)
                    .build();
        }
    }



    String[] permissions = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.WRITE_SETTINGS,};

    public static BottomBar bottomBar;





    @Override
    protected void findViews() {

    }

    private long exitTime = 0;

    @SuppressLint("ResourceAsColor")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
//            if (bottomBar.getVisibility() == View.VISIBLE) {
                if ((System.currentTimeMillis() - exitTime) > 2000) {
                    Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    exitTime = System.currentTimeMillis();
                } else {
                    finish();
                    System.exit(0);
                }
                return true;
//            } else {
//                web_view.goBack();
//                return true;    //已处理
//            }
        }
        return super.onKeyDown(keyCode, event);
    }

    //  权限 失败 的话 就是  可以  继续 再进行 申请
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //可在此继续其他操作。
    }
















}
