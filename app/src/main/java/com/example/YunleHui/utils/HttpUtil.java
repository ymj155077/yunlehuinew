package com.example.YunleHui.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;

import com.example.YunleHui.appManager.MyApp;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import static com.example.YunleHui.appManager.MyApp.Cookiebuilder;
import static com.example.YunleHui.appManager.MyApp.PUBLIC_URL;
import static com.example.YunleHui.appManager.MyApp.Time_stamp;
import static com.example.YunleHui.appManager.MyApp.gson;
import static com.example.YunleHui.appManager.MyApp.mOkHttpClient;
import static com.example.YunleHui.appManager.MyApp.ran_number;
import static com.example.YunleHui.appManager.MyApp.sign;


/**
 * Created by Administrator
 * on 2018/11/22 0022
 */
public class HttpUtil {

    public static Map<Object, Object> params;

    public static void addMapparams() {
        params = new HashMap<>();
        params.clear();
    }


    public static Map<String, String> paramsheads;


    public static void addMapheads() {
        paramsheads = new HashMap<>();
        paramsheads.clear();
    }


    //    form-data
    public static void Post_request(String url, Map<Object, Object> params) {

//       String vale =  gson.toJson(params).replace("\\\"","");
        Request request;
//      RequestBody formBody = null;
        FormBody.Builder builder;
        if ((Integer) MyApp.getSharedPreference(MyApp.context, "user", 0) == 0) {
//            RequestBody formBody = new FormBody.Builder().build();
//                    .add("clientNo", "1001")
//                    .add("timestamp", "" + time)
//                    .add("version", "1.0")
//                    .add("mac", "" + md5_lun);
//            for (String keys : params.keySet()) {
////                formBody().ad(keys, params.get(keys));
//                formBody = new FormBody.Builder().add(keys,(String) params.get(keys)).build();
//            }
//            request = new Request.Builder().
//                    url( PUBLIC_URL + url)
//                    .post(formBody)
//                    .build();
//           MyApp.call  = mOkHttpClient.newCall(request);
//            request = new Request.Builder().url(PUBLIC_URL + url)
//                    .post(RequestBody.create(MediaType.parse("application/json"), gson.toJson(params)))
//                    .build();
//            Log.i(url, gson.toJson(params));
            builder = new FormBody.Builder();

            for (Object key : params.keySet()) {
                //追加表单信息
                builder.add((String) key, (String) params.get(key));
                Log.i("key_all", (String) params.get(key));
            }
            RequestBody formBody = builder.build();
            request = new Request.Builder().url(PUBLIC_URL + url).post(formBody).build();
        } else {
//            登录了的
//            ran_number = HttpUtil.getNumberString();
//            Time_stamp = HttpUtil.getSecondTimestamp();
//            sign = HttpUtil.getSignature(ran_number,
//                    Time_stamp,
//                    "hello");
            Log.i("登陆了以后", "登陆了以后" + "Bearer " + MyApp.access_token + "--------" + MyApp.user + "---" + sign + "-----"
                    +
                    params
            );
            HttpUtil.addMapheads();
            HttpUtil.paramsheads.put("Authorization", "Bearer " + MyApp.access_token);
//            HttpUtil.paramsheads.put("sign", sign);
//            HttpUtil.paramsheads.put("timestamp", Time_stamp);
//            HttpUtil.paramsheads.put("nonce", ran_number);
//            HttpUtil.paramsheads.put("user", MyApp.user);
//            request = new Request.Builder().url(PUBLIC_URL + url)
//                    .post(RequestBody.create(MediaType.parse("application/json"), gson.toJson(params)))
//                    .headers(Headers.of(paramsheads))
//                    .build();
//            for (String keys : params.keySet()) {
////                formBody().ad(keys, params.get(keys));
//                formBody = new FormBody.Builder().add(keys,(String) params.get(keys)).build();
//            }
//            request = new Request.Builder().
//                    url( PUBLIC_URL + url)
//                    .post(formBody)
//                    .headers(Headers.of(paramsheads))
//                    .build();
            builder = new FormBody.Builder();
            try {
//                多个 的
                for (Object key : params.keySet()) {
                    //追加表单信息
                    builder.add((String) key, params.get(key) + "");
                    Log.i("key_all_duo", params.get(key) + "");
                }


                RequestBody formBody = builder.build();
                request = new Request.Builder().url(PUBLIC_URL + url).post(formBody).headers(Headers.of(paramsheads)).build();

            } catch (Exception e) {
////                单个  的
//                for (String key : params.keySet()) {
//                    //追加表单信息
//                    builder.add(key, params+"");
//                    Log.i("key_all_dan",MyApp.gson.toJson(params)+"---"+params);


                request = new Request.Builder().url(PUBLIC_URL + url).headers(Headers.of(paramsheads)).build();

            }
//            }

//            MyApp.call  = mOkHttpClient.newCall(request);

        }
//        if (paramsheads!=null){
//            for (String keys : paramsheads.keySet()) {
//                request.newBuilder().addHeader(keys, paramsheads.get(keys));
//            }
//        }
//        request.newBuilder().put(RequestBody.create(MediaType.parse("application/json"),gson.toJson(params)));
        MyApp.call = Cookiebuilder.build().newCall(request);
    }


//全Json

    public static void postRaw(String url, Map<Object, Object> params) {
        Request request;
        if ((Integer) MyApp.getSharedPreference(MyApp.context, "user", 0) == 0) {
            request = new Request.Builder().url(PUBLIC_URL + url)
                    .post(RequestBody.create(MediaType.parse("application/json"),
                            gson.toJson(
                                    params
                            )
                    ))
                    .build();
            Log.i(url,
                    gson.toJson(params)
            );
        } else {
//            登录了的
//            ran_number = HttpUtil.getNumberString();
//            Time_stamp = HttpUtil.getSecondTimestamp();
//            sign = HttpUtil.getSignature(ran_number,
//                    Time_stamp,
//                    "hello");
            Log.i(url, ran_number + "===" + Time_stamp + "---" + MyApp.access_token + "---" + MyApp.user + "---" + sign + "-----"
                    +
                    gson.toJson(params)
            );

            HttpUtil.addMapheads();
            HttpUtil.paramsheads.put("Authorization", "Bearer " + MyApp.access_token);
            request = new Request.Builder().url(PUBLIC_URL + url)
                    .post(RequestBody.create(MediaType.parse("application/json"),
                            gson.toJson(
                                    params
                            )
                    ))
                    .headers(Headers.of(paramsheads))
                    .build();
        }

        MyApp.call = Cookiebuilder.build().newCall(request);

    }


    public static void getRaw(String url, Map<Object, Object> map) {

        Request request;

        if ((Integer) MyApp.getSharedPreference(MyApp.context, "user", 0) == 0) {

            HttpUtil.addMapheads();
            HttpUtil.paramsheads.put("Authorization", "Bearer " + MyApp.access_token);

            Request.Builder requestBuilder = new Request.Builder().url(MyApp.PUBLIC_URL
                    + url);
            request = requestBuilder.build();
        } else {
            HttpUtil.addMapheads();
            HttpUtil.paramsheads.put("Authorization", "Bearer " + MyApp.access_token);

            Request.Builder requestBuilder = new Request.Builder().url(MyApp.PUBLIC_URL + url);
            //可以省略，默认是GET请求
//            requestBuilder.method("GET",null);
            request = requestBuilder.headers(Headers.of(paramsheads)).build();
        }
        MyApp.call = Cookiebuilder.build().newCall(request);
    }


    //第一个键值对，第二个 json字符串
    public static void PostFaBu(String url,String setMeal,String verify,Map<Object, Object> paramss){
        Request request;
        HttpUtil.addMapheads();
        HttpUtil.paramsheads.put("Authorization", "Bearer " + MyApp.access_token);
//      request = new Request.Builder().url(PUBLIC_URL + url+"?setMealDtoList="+"\""+setMeal+"\""+"&verifyPowerDtoList="+"\""+verify+"\"").
        request = new Request.Builder().url(PUBLIC_URL + url).
        post(RequestBody.create(MediaType.parse("application/json"),gson.toJson(paramss)))
                .headers(Headers.of(paramsheads)).build();
//.post(formBody)
        MyApp.call = Cookiebuilder.build().newCall(request);
//        Log.i(url, "-------"+MyApp.gson.toJson(paramss));
//        Log.i(url,PUBLIC_URL + url+"?setMealDtoList="+"\""+setMeal+"\""+"&verifyPowerDtoList="+"\""+verify+"\""+"-------"+gson.toJson(paramss)+"");
    }



    public static void getAsynHttp(String url) {

        Request request;

        if ((Integer) MyApp.getSharedPreference(MyApp.context, "user", 0) == 0) {

            HttpUtil.addMapheads();
            HttpUtil.paramsheads.put("Authorization", "Bearer " + MyApp.access_token);

            Request.Builder requestBuilder = new Request.Builder().url(MyApp.PUBLIC_URL
                    + url);
            //可以省略，默认是GET请求
//            requestBuilder.method("GET",null);
            request = requestBuilder.build();
        } else {
            HttpUtil.addMapheads();
            HttpUtil.paramsheads.put("Authorization", "Bearer " + MyApp.access_token);

            Request.Builder requestBuilder = new Request.Builder().url(MyApp.PUBLIC_URL + url);
            //可以省略，默认是GET请求
//            requestBuilder.method("GET",null);
            request = requestBuilder.headers(Headers.of(paramsheads)).build();
        }
        MyApp.call = Cookiebuilder.build().newCall(request);

        Log.i(url,MyApp.PUBLIC_URL + url);

    }


    public static void Post_orde(String url, String key, Map<String, Object> params) {

//       String vale =  gson.toJson(params).replace("\\\"","");
        Request request;
//        RequestBody formBody = null;
        FormBody.Builder builder;
        if ((Integer) MyApp.getSharedPreference(MyApp.context, "user", 0) == 0) {
//            RequestBody formBody = new FormBody.Builder().build();
//                    .add("clientNo", "1001")
//                    .add("timestamp", "" + time)
//                    .add("version", "1.0")
//                    .add("mac", "" + md5_lun);
//            for (String keys : params.keySet()) {
////                formBody().ad(keys, params.get(keys));
//                formBody = new FormBody.Builder().add(keys,(String) params.get(keys)).build();
//            }
//            request = new Request.Builder().
//                    url( PUBLIC_URL + url)
//                    .post(formBody)
//                    .build();
//           MyApp.call  = mOkHttpClient.newCall(request);
//            request = new Request.Builder().url(PUBLIC_URL + url)
//                    .post(RequestBody.create(MediaType.parse("application/json"), gson.toJson(params)))
//                    .build();
//            Log.i(url, gson.toJson(params));
            builder = new FormBody.Builder();

//            for (String key : params.keySet()) {
//                //追加表单信息
//                builder.add(key, (String) params.get(key));
//                Log.i("key_all",(String) params.get(key));
//            }
//            RequestBody formBody=builder.build();
//            request=new Request.Builder().url(PUBLIC_URL + url).post(formBody).build();
        } else {
//            登录了的
//            ran_number = HttpUtil.getNumberString();
//            Time_stamp = HttpUtil.getSecondTimestamp();
//            sign = HttpUtil.getSignature(ran_number,
//                    Time_stamp,
//                    "hello");
            Log.i(url, ran_number + "===" + Time_stamp + "---" + MyApp.access_token + "---" + MyApp.user + "---" + sign + "-----"
                    +
                    params
            );
            HttpUtil.addMapheads();
            HttpUtil.paramsheads.put("Authorization", "Bearer " + MyApp.access_token);
//            HttpUtil.paramsheads.put("sign", sign);
//            HttpUtil.paramsheads.put("timestamp", Time_stamp);
//            HttpUtil.paramsheads.put("nonce", ran_number);
//            HttpUtil.paramsheads.put("user", MyApp.user);
//            request = new Request.Builder().url(PUBLIC_URL + url)
//                    .post(RequestBody.create(MediaType.parse("application/json"), gson.toJson(params)))
//                    .headers(Headers.of(paramsheads))
//                    .build();
//            for (String keys : params.keySet()) {
////                formBody().ad(keys, params.get(keys));
//                formBody = new FormBody.Builder().add(keys,(String) params.get(keys)).build();
//            }
//            request = new Request.Builder().
//                    url( PUBLIC_URL + url)
//                    .post(formBody)
//                    .headers(Headers.of(paramsheads))
//                    .build();


            builder = new FormBody.Builder();
//                单个  的
            //追加表单信息
            builder.add(key, gson.toJson(params));
            Log.i("key_all", MyApp.gson.toJson(params) + "---" + params);

        }

        RequestBody formBody = builder.build();
        request = new Request.Builder().url(PUBLIC_URL + url).post(formBody).headers(Headers.of(paramsheads)).build();

//            MyApp.call  = mOkHttpClient.newCall(request);
//        if (paramsheads!=null){
//            for (String keys : paramsheads.keySet()) {
//                request.newBuilder().addHeader(keys, paramsheads.get(keys));
//            }
//        }
//        request.newBuilder().put(RequestBody.create(MediaType.parse("application/json"),gson.toJson(params)));
        MyApp.call = Cookiebuilder.build().newCall(request);
    }


    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

//    ran_number = HttpUtil.getNumberString();
//    Time_stamp = HttpUtil.getSecondTimestamp();
//    sign =  HttpUtil.sortString(ran_number,
//    Time_stamp,
//            "hello");

    //    得到 sign
    public static String getSign(String NumberString, String SecondTimestamp) {
        return HttpUtil.sortString(NumberString,
                SecondTimestamp,
                "hello");
    }


    public static String sortString(String timestamp, String nonce, String key) {
        //对token,timestamp nonce 按字典排序
        String[] paramArr = new String[]{key, timestamp, nonce};
        Arrays.sort(paramArr);
        //将排序后的结果拼接成一个字符串
        return paramArr[0].concat(paramArr[1]).concat(paramArr[2]);
    }

    /**
     * 生成签名 android使用
     *
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @return
     */
    public static String getSignature(String timestamp, String nonce, String key) {
        String content = sortString(timestamp, nonce, key);
        if (TextUtils.isEmpty(content)) {
            return null;
        }
        String ciphertext = null;

        try {
            //对拼接后的字符串进行sha1加密 update
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            // 使用指定的字节数组对摘要进行最后更新
            byte[] digest = md.digest(content.getBytes());
            //完成摘要计算
            ciphertext = byteToStr(digest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ciphertext;
    }

    /**
     * 将字节数组转换成十六进制字符串
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    private static String byteToHexStr(byte mByte) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }

//获取时间蹉

//    方法一：通过String.substring()方法将最后的三位去掉

    /**
     * 获取精确到秒的时间戳
     *
     * @return
     */
    public static String getSecondTimestamp() {
        String timeStampSec = System.currentTimeMillis() + "";
//        String timestamp = String.format("%010d", timeStampSec);
        return timeStampSec;
    }

//获取  随机数

    public static String getNumberString() {

        String ran = Math.random() * 100 + "";

        return ran;

    }





















    public static void put_Request(String url, Map<Object, Object> params) {
        Request request;
        FormBody.Builder builder;
        if ((Integer) MyApp.getSharedPreference(MyApp.context, "user", 0) == 0) {

            builder = new FormBody.Builder();

            for (Object key : params.keySet()) {
                //追加表单信息
                builder.add((String) key, (String) params.get(key));
                Log.i("key_all", (String) params.get(key));
            }
            RequestBody formBody = builder.build();
            request = new Request.Builder().url(PUBLIC_URL + url).post(formBody).build();
        } else {

            Log.i("登陆了以后", "登陆了以后" + "Bearer " + MyApp.access_token + "--------" + MyApp.user + "---" + sign + "-----"
                    +
                    params
            );
            HttpUtil.addMapheads();
            HttpUtil.paramsheads.put("Authorization", "Bearer " + MyApp.access_token);
            builder = new FormBody.Builder();
            try {
//                多个 的
                for (Object key : params.keySet()) {
                    //追加表单信息
                    builder.add((String) key, params.get(key) + "");
                    Log.i("key_all_duo", params.get(key) + "");
                }
                RequestBody formBody = builder.build();
                request = new Request.Builder().url(PUBLIC_URL + url).put(formBody).headers(Headers.of(paramsheads)).build();
            } catch (Exception e) {
                request = new Request.Builder().url(PUBLIC_URL + url).headers(Headers.of(paramsheads)).build();
            }
            MyApp.call = Cookiebuilder.build().newCall(request);
        }
    }




    public static void deleteRequest(String url, Map<Object, Object> params) {
        Request request;
        FormBody.Builder builder;
        if ((Integer) MyApp.getSharedPreference(MyApp.context, "user", 0) == 0) {

            builder = new FormBody.Builder();

            for (Object key : params.keySet()) {
                //追加表单信息
                builder.add((String) key, (String) params.get(key));
                Log.i("key_all", (String) params.get(key));
            }
            RequestBody formBody = builder.build();
            request = new Request.Builder().url(PUBLIC_URL + url).post(formBody).build();
        } else {
            Log.i("登陆了以后", "登陆了以后" + "Bearer " + MyApp.access_token + "--------" + MyApp.user + "---" + sign + "-----"
                    +
                    params
            );
            HttpUtil.addMapheads();
            HttpUtil.paramsheads.put("Authorization", "Bearer " + MyApp.access_token);
            builder = new FormBody.Builder();
            try {
//                多个 的
                for (Object key : params.keySet()) {
                    //追加表单信息
                    builder.add((String) key, params.get(key) + "");
                    Log.i("key_all_duo", params.get(key) + "");
                }
                RequestBody formBody = builder.build();
                request = new Request.Builder().url(PUBLIC_URL + url).delete(formBody).headers(Headers.of(paramsheads)).build();
            } catch (Exception e) {
                request = new Request.Builder().url(PUBLIC_URL + url).headers(Headers.of(paramsheads)).build();
            }
            MyApp.call = Cookiebuilder.build().newCall(request);
        }
    }







}






