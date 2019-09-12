package com.example.YunleHui.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.YunleHui.R;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;



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
        api = WXAPIFactory.createWXAPI(this, "wx02a134a6981a0b07");
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
                        finish();
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
