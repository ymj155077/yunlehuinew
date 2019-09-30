package com.example.YunleHui.ui.act.actme;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.CommonUtil;
import com.example.YunleHui.utils.Tools;
import com.example.YunleHui.view.CircleImageView;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.YunleHui.utils.Tools.mBottomSheetPop;

/**
 * 达人的界面
 */

public class ActDaren extends BaseAct {


    @BindView(R.id.lin_share)
    LinearLayout lin_share;

    @BindView(R.id.lin_finsh)
    LinearLayout lin_finsh;


    @BindView(R.id.lin_act)
    LinearLayout lin_act;

    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_daren2;
    }

    @Override
    protected void findViews() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.lin_finsh,R.id.lin_share,R.id.lin_act})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.lin_finsh:
                finish();
                break;
            case R.id.lin_share:
                View viewss = Tools.setRebuildPop(this, R.layout.item_shareda, R.layout.activity_act_daren2);
                FrameLayout lin_frame = (FrameLayout) viewss.findViewById(R.id.lin_frame);
                RoundedImageView cir_head = (RoundedImageView) viewss.findViewById(R.id.cir_head);
                TextView text_name = (TextView) viewss.findViewById(R.id.text_name);
                ImageView img_er = (ImageView) viewss.findViewById(R.id.img_er);
                TextView text_Close = (TextView) viewss.findViewById(R.id.text_Close);
                String avatarUrl = (String) MyApp.getSharedPreference(this, "avatarUrl", "");

                Glide.with(this).load(avatarUrl).into(cir_head);

                Glide.with(this).load(MyApp.PUBLIC_URL + "order/generateQrCode?secret=" + MyApp.user).into(img_er);

                String name = (String) MyApp.getSharedPreference(this, "nickName", "");
                text_name.setText(name);
                TextView textSave = (TextView) viewss.findViewById(R.id.textSave);
                textSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bitmap ret = Bitmap.createBitmap(lin_frame.getWidth(),
                                lin_frame.getHeight(),
                                Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(ret);
                        Drawable bgDrawable = lin_frame.getBackground();
                        if (bgDrawable != null) {
                            bgDrawable.draw(canvas);
                        } else {
                            canvas.drawColor(Color.WHITE);
                        }
                        lin_frame.draw(canvas);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (ret == null) {
                                            Log.i("bitmap", "没有生成" );
                                        } else {
                                            Log.i("bitmap", ret + "-----" );
                                        }
//                                      showShare(type, ret);
                                        CommonUtil.saveBitmap2file(ret, getApplicationContext());
                                        mBottomSheetPop.dismiss();
                                    }
                                }, 2000);
                            }
                        });
                    }
                });
                text_Close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mBottomSheetPop.dismiss();
                    }
                });
                Tools.fitPopupWindowOverStatusBar(mBottomSheetPop,true);
                break;
            case R.id.lin_act:
                ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
// 将文本内容放到系统剪贴板里。
                cm.setText("https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&ch=2&tn=98010089_dg&wd=android%E7%82%B9%E5%87%BB%E5%A4%8D%E5%88%B6%E6%8C%89%E9%92%AE%E5%A4%8D%E5%88%B6%E9%93%BE%E6%8E%A5&oq=android%25E7%2582%25B9%25E5%2587%25BB%25E5%25A4%258D%25E5%2588%25B6%25E9%2593%25BE%25E6%258E%25A5&rsv_pq=a47500830015875e&rsv_t=9e07VfuY%2FY4AG5bZWLOFXn1NYyfyromRxyMnK5peO%2FCFX%2B1qj1hh5Lm25d7X8DOQJks&rqlang=cn&rsv_enter=1&rsv_dl=tb&rsv_sug3=9&rsv_sug2=0&inputT=5680&rsv_sug4=6953");
               Toast.makeText(ActDaren.this, "复制成功",Toast.LENGTH_SHORT).show();//自定义的toast
                break;
        }
    }
}
