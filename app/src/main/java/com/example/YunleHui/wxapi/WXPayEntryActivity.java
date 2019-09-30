package com.example.YunleHui.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.YunleHui.R;
import com.example.YunleHui.ui.act.ActComPur.ActComMall;
import com.example.YunleHui.ui.act.acthome.ActComdetails;
import com.example.YunleHui.ui.act.acthome.ActOrderSucess;
import com.example.YunleHui.ui.act.actme.ActMyOrder;
import com.example.YunleHui.ui.act.actme.actbusiness.ActBusDistribution;
import com.example.YunleHui.ui.act.actme.actbusiness.ActOrderPayCom;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import static com.example.YunleHui.appManager.MyApp.orderNatureAll;
import static com.example.YunleHui.appManager.MyApp.typeNoAll;
import static com.example.YunleHui.ui.act.acthome.ActDeterOrder.actDeterOrder;
import static com.example.YunleHui.ui.act.acthome.ActPayOrder.actPayOrder;
import static com.example.YunleHui.ui.act.actme.ActTodetails.actTodetails;


public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    public static int zhifu_shangjia = 0;
    public static String shangjiaid = "";

    public void onGetMessageFromWXReq(WXMediaMessage msg) {
        if (msg != null) {
            Intent iLaunchMyself = getPackageManager().getLaunchIntentForPackage(getPackageName());
            startActivity(iLaunchMyself);
        }
    }

    public void onShowMessageFromWXReq(WXMediaMessage msg) {
        if (msg != null && msg.mediaObject != null
                && (msg.mediaObject instanceof WXAppExtendObject)) {
            WXAppExtendObject obj = (WXAppExtendObject) msg.mediaObject;
            Toast.makeText(this, obj.extInfo, Toast.LENGTH_SHORT).show();
        }
    }

    private IWXAPI api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxpay_entry_pay);
        api = WXAPIFactory.createWXAPI(this, "wxe9265d93cda255a9");
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq baseReq) {
        Log.i("sddsssds", "errCode:---->" + baseReq.getType());
    }

    @Override
    public void onResp(BaseResp resp) {
        int errCode = resp.errCode;
        Log.i("sddsds", "errCode:---->" + errCode);
        String result = "";
        switch (errCode) {
            case 0:
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WXPayEntryActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
//                        qiehuan();
//                        WebDetails.webDetails.finish();
                        //                正常的支付
                        if (typeNoAll == 0) {
//                爆款
                            if (orderNatureAll == 0) {
                                ActComdetails.actComdetails.finish();
                                actDeterOrder.finish();
                                actPayOrder.finish();
//                                Intent intent = new Intent(WXPayEntryActivity.this,ActOrderSucess.class);
//                                startActivity(intent);
                                Intent intent = new Intent(WXPayEntryActivity.this,ActMyOrder.class);
                                startActivity(intent);
                                finish();
                            } else if (orderNatureAll == 1) {
//                社区购
                                ActComMall.actComMall.finish();
                                ActOrderPayCom.actOrderPayCom.finish();
                                actPayOrder.finish();
                                Intent intent = new Intent(WXPayEntryActivity.this,ActMyOrder.class);

                                startActivity(intent);
                                finish();
                            }
                        } else if (typeNoAll == 1) {
//                    待支付里面进来的
                            ActBusDistribution.actBusDistribution.finish();
                            actPayOrder.finish();
                            finish();
                        } else if (typeNoAll == 2) {
                            actTodetails.finish();
                            actPayOrder.finish();
                            finish();
                        }
                    }
                });
                break;
            case -1:

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WXPayEntryActivity.this, "支付失败,请重试", Toast.LENGTH_SHORT).show();
//                        qiehuan();
//                        WebDetails.webDetails.finish();
                        finish();
                    }
                });
                break;
            case -2:
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WXPayEntryActivity.this, "您取消了支付", Toast.LENGTH_SHORT).show();
//                        qiehuan();
//                        WebDetails.webDetails.finish();
                        finish();
                    }
                });

                break;
        }
    }
}
