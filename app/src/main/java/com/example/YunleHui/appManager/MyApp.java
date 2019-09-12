package com.example.YunleHui.appManager;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.gson.Gson;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.EaseUI;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator
 * on 2018/11/20 0020
 * <p>
 * <p>
 * recycle_order_right.setHasFixedSize(true);
 * recycle_order_right.setNestedScrollingEnabled(false);
 */
public class MyApp extends Application {



    public static int city_Id = 0;
    public static String cityName;



    public static String url_gif = "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2568084371,574107025&fm=26&gp=0.jpg";

//    订单的类型


//    根据订单的类型去 选择 销毁 那些界面

    public static int order_ty = 0;

    public static String PUBLIC_URL= "http://192.168.110.9:12010/";

    public static int userType = 1;
//  public static String PUBLIC_URL ="http://localhost:12010/";
    public static int currentCheckedIndex;

    public static int target = -1;
    public static Call call;

    public static OkHttpClient mOkHttpClient = new OkHttpClient();

    public static OkHttpClient.Builder Cookiebuilder = new OkHttpClient.Builder();
    public static Context context;

    //随机数
    public static String ran_number = "";
    //时间戳
    public static String Time_stamp = "";


    public static String mig_url = "";

    public static String mig_url_two = "";

    public static String page = "1";

    public static int pageSize = 10;

    //    用户鉴权
    public static String access_token = "";
    //    签名
    public static String sign = "";
    //    请求时间
    public static String timestamp = "";
    //    随机数
    public static String nonce = "";
    //    用户号
    public static int user = 0;
    public static String nickName;

    //    用户电话
    public static String phone;
    public static String wxOpenId;
    //头像
    public static String headImg;

    public static Gson gson;

    @Override
    public void onCreate() {
        super.onCreate();
        //获取Context
        context = getApplicationContext();
//      AutoLayoutConifg.getInstance().useDeviceSize();
        mOkHttpClient.cookieJar();
        gson = new Gson();

        File sdcache = getExternalCacheDir();

        long maxCacheSize = 100 * 1024 * 1024;

        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLogger());
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Cookiebuilder.cookieJar(new CookiesManager())
//                .addNetworkInterceptor(new CacheInterceptor())
                .addNetworkInterceptor(logInterceptor)
                .cache(new Cache(sdcache.getAbsoluteFile(), maxCacheSize))
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
//                .addInterceptor(loggingInterceptor)
                .build();
        user = (Integer) MyApp.getSharedPreference(context, "user", 0);
//        access_token = (String) MyApp.getSharedPreference(context, "access_token", "");

        access_token = (String) MyApp.getSharedPreference(context, "access_token", "");

        wxOpenId = (String) MyApp.getSharedPreference(context, "wxOpenId", "");


        userType = (Integer) MyApp.getSharedPreference(context, "userType", 0);




        nickName = (String) MyApp.getSharedPreference(context, "nickName", "");

        phone = (String) MyApp.getSharedPreference(context, "phone", "");

        headImg = (String) MyApp.getSharedPreference(context, "headImg", "");


//        ZXingLibrary.initDisplayOpinion(this);

//        MobSDK.init(this);
//        // 极光初始化
//        JPushInterface.init(this);
//        JPushInterface.setDebugMode(true);
//        JPushInterface.getRegistrationID(context);
//
////非wifi情况下，主动下载x5内核
//        QbSdk.setDownloadWithoutWifi(true);
//        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
//        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
//            @Override
//            public void onViewInitFinished(boolean arg0) {
//                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
//                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
//                Log.e("@@", "加载内核是否成功:" + arg0);
//            }
//
//            @Override
//            public void onCoreInitFinished() {
//                //x5内核初始化完成回调接口，此接口回调并表示已经加载起来了x5，有可能特殊情况下x5内核加载失败，切换到系统内核。
//            }
//        };
//        //x5内核初始化接口
//        QbSdk.initX5Environment(getApplicationContext(), cb);
//        loginService = new LoginService();





//
////环信加的
//
//        EMOptions options = new EMOptions();
//// 默认添加好友时，是不需要验证的，改成需要验证
//        options.setAcceptInvitationAlways(false);
//// 是否自动将消息附件上传到环信服务器，默认为True是使用环信服务器上传下载，如果设为 false，需要开发者自己处理附件消息的上传和下载
//        options.setAutoTransferMessageAttachments(true);
//// 是否自动下载附件类消息的缩略图等，默认为 true 这里和上边这个参数相关联
//        options.setAutoDownloadThumbnail(true);
//
//
////是否让用户自动登录
//        options.setAutoLogin(true);
//
////...
////初始化
//        EMClient.getInstance().init(context, options);
////在做打包混淆时，关闭debug模式，避免消耗不必要的资源
//        EMClient.getInstance().setDebugMode(true);
//
//
//
//        int pid = android.os.Process.myPid();
//        String processAppName = getAppName(pid);
//// 如果APP启用了远程的service，此application:onCreate会被调用2次
//// 为了防止环信SDK被初始化2次，加此判断会保证SDK被初始化1次
//// 默认的APP会在以包名为默认的process name下运行，如果查到的process name不是APP的process name就立即返回
//
//        if (processAppName == null ||!processAppName.equalsIgnoreCase(context.getPackageName())) {
//            Log.e("---", "enter the service process!");
//
//            // 则此application::onCreate 是被service 调用的，直接返回
//            return;
//        }

//        EMOptions options = new EMOptions();
//// 默认添加好友时，是不需要验证的，改成需要验证
//        options.setAcceptInvitationAlways(false);
////...
//        EaseUI.getInstance().init(context, options);


    }




    private String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = this.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pID) {
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
                // Log.d("Process", "Error>> :"+ e.toString());
            }
        }
        return processName;
    }




    //返回
    public static Context getContextObject() {
        return context;
    }

    public class CacheInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            Response response1 = response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    //cache for 30 days
                    .header("Cache-Control", "max-age=" + 3600 * 24 * 30)
                    .build();
            return response1;
        }
    }


    public class HttpLogger implements HttpLoggingInterceptor.Logger {
        @Override
        public void log(String message) {
            Log.d("HttpLogInfo", message);
        }
    }


    //存储
    public static void putSharedPreference(Context context, String key, Object object) {
        SharedPreferences sp = context.getSharedPreferences("jinLife", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }
        editor.commit();
    }
    //获取
    public static Object getSharedPreference(Context context, String key, Object defaultObject) {
        SharedPreferences sp = context.getSharedPreferences("jinLife", Context.MODE_PRIVATE);
        if (defaultObject instanceof String) {
            return sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sp.getLong(key, (Long) defaultObject);
        }
        return null;
    }
    //清除
    public static void clear(Context context) {
        SharedPreferences sp = context.getSharedPreferences("jinLife", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }
}
