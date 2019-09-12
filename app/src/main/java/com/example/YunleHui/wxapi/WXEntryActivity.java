package com.example.YunleHui.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.appManager.OkHttpUtils;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import cn.sharesdk.wechat.utils.WechatHandlerActivity;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import static com.example.YunleHui.appManager.MyApp.gson;
import static com.example.YunleHui.appManager.MyApp.mOkHttpClient;
import static com.example.YunleHui.base.BaseAct.alertDialog;


public class WXEntryActivity extends WechatHandlerActivity implements IWXAPIEventHandler {



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

    private IWXAPI iwxapi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxpay_entry);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        iwxapi = WXAPIFactory.createWXAPI(this, "wx02a134a6981a0b07", false);

        iwxapi.handleIntent(getIntent(), this);
    }


    @Override
    public void onReq(BaseReq baseReq) {
        Log.i("sddsssds", "errCode:---->" + baseReq.getType());
    }


    @Override
    public void onResp(BaseResp baseResp) {

        switch (baseResp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                String code = ((SendAuth.Resp) baseResp).code;
                getAccessToken(code);
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:

                if (null != alertDialog && alertDialog.isShowing()) {
                    alertDialog.dismiss();
                }

                finish();
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:

                if (null != alertDialog && alertDialog.isShowing()) {
                    alertDialog.dismiss();
                }

                finish();
                break;
            default:

                if (null != alertDialog && alertDialog.isShowing()) {
                    alertDialog.dismiss();
                }

                finish();
                break;
        }
    }


    private void getAccessToken(String code) {
        StringBuffer loginUrl = new StringBuffer();
        loginUrl.append("https://api.weixin.qq.com/sns/oauth2/access_token")
                .append("?appid=")
                .append("wx3a24619463b4acce")
                .append("&secret=")
                .append("701c9cc93325e07c468d82b88d09785b")
                .append("&code=")
                .append(code)
                .append("&grant_type=authorization_code");
        OkHttpUtils.ResultCallback<String> resultCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                String access = null;
                String openId = null;
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    access = jsonObject.getString("access_token");
                    openId = jsonObject.getString("openid");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String getUserInfo = "https://api.weixin.qq.com/sns/userinfo?access_token=" + access + "&openid=" + openId;
                OkHttpUtils.ResultCallback<String> reCallback = new OkHttpUtils.ResultCallback<String>() {
                    @Override
                    public void onSuccess(String responses) {
                        try {
                            JSONObject jsonObject = new JSONObject(responses);
//                            openid = jsonObject.getString("openid");
//                            nickName = jsonObject.getString("nickname");
//                            sex = jsonObject.getString("sex");
//                            city = jsonObject.getString("city");
//                            province = jsonObject.getString("province");
//                            country = jsonObject.getString("country");
//                            headimgurl = jsonObject.getString("headimgurl");
//                            unionid = jsonObject.getString("unionid");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
//                                    post_modify(unionid, headimgurl, nickName);
                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(WXEntryActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                };
                OkHttpUtils.get(getUserInfo, reCallback);
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(WXEntryActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                finish();
            }
        };
        OkHttpUtils.get(loginUrl.toString(), resultCallback);
    }

    @Override
    protected void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
    }

    private void post_modify(final String openId, final String headimgurl, String nickName) {
        MyApp.putSharedPreference(this, "headimgurl", headimgurl + "");
        MyApp.putSharedPreference(this, "nickName", nickName + "");
        MyApp.nickName = nickName;
        Map<String, String> paramsheads = new HashMap<>();
        paramsheads.clear();
        paramsheads.put("nickname", nickName);
        paramsheads.put("headImg", headimgurl);
        paramsheads.put("unionId", openId);
        paramsheads.put("type", "WECHAT");
//        paramsheads.put("pushId", MyApp.push_RegistrationID);
        Request request = new Request.Builder().
                url(MyApp.PUBLIC_URL + "user/register")
                .post(RequestBody.create(MediaType.parse("application/json"), gson.toJson(paramsheads)))
                .build();
        okhttp3.Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                final String resp = response.body().string();
                Log.i("resp_Runnable", resp);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
                try {
//                    bean_wei_login = gson.fromJson(resp, Bean_wei_Login.class);
//                    data = bean_wei_login.getData();
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(WXEntryActivity.this, bean_wei_login.getMessage(), Toast.LENGTH_SHORT).show();
//                            MyApp.user = data.getUserNo();
//                            MyApp.access_token = data.getAccessToken();
//
//                            MyApp.putSharedPreference(WXEntryActivity.this, "user", data.getUserNo() + "");
//                            MyApp.putSharedPreference(WXEntryActivity.this, "access_token", data.getAccessToken() + "");
//                            MyApp.putSharedPreference(WXEntryActivity.this, "wxOpenId", data.getWxOpenId() + "");
//
//
//                            if (null != alertDialog && alertDialog.isShowing()) {
//                                alertDialog.dismiss();
//                            }
//
//
//                            ActLogin.actLogin.finish();
//                        }
//                    });
                } catch (Exception e) {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            if (null != alertDialog && alertDialog.isShowing()) {
                                alertDialog.dismiss();
                            }
//                            Toast.makeText(WXEntryActivity.this, bean_wei_login.getMessage() + "", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}
