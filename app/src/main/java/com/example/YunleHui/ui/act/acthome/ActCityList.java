package com.example.YunleHui.ui.act.acthome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.YunleHui.Bean.Bean_cityList;
import com.example.YunleHui.R;
import com.example.YunleHui.appManager.MyApp;
import com.example.YunleHui.base.BaseAct;
import com.example.YunleHui.utils.HttpUtil;
import com.example.YunleHui.view.cityList.BaseIndexPinyinBean;
import com.example.YunleHui.view.cityList.CommonAdapter;
import com.example.YunleHui.view.cityList.DividerItemDecoration;
import com.example.YunleHui.view.cityList.HeaderRecyclerAndFooterWrapperAdapter;
import com.example.YunleHui.view.cityList.IndexBar;
import com.example.YunleHui.view.cityList.MeiTuanBean;
import com.example.YunleHui.view.cityList.MeituanAdapter;
import com.example.YunleHui.view.cityList.MeituanHeaderBean;
import com.example.YunleHui.view.cityList.MeituanTopHeaderBean;
import com.example.YunleHui.view.cityList.OnItemClickListener;
import com.example.YunleHui.view.cityList.SuspensionDecoration;
import com.example.YunleHui.view.cityList.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.example.YunleHui.appManager.MyApp.CityName;
import static com.example.YunleHui.appManager.MyApp.city_Id;

/**
 * 城市列表
 */
public class ActCityList extends BaseAct {


    private Bean_cityList bean_cityList;
    private boolean success_cityList;
    private int code_cityList;
    private String msg_cityList;
    private List<Bean_cityList.DataBean> data_cityList;

    private ArrayList<Bean_cityList.DataBean> data_cityALL = new ArrayList<>();


    @BindView(R.id.toolbar_all)
    Toolbar toolbar_all;


    private static final String TAG = "zxt";
    private Context mContext;
    private RecyclerView mRv;
    private MeituanAdapter mAdapter;
    private HeaderRecyclerAndFooterWrapperAdapter mHeaderAdapter;
    private LinearLayoutManager mManager;

    //设置给InexBar、ItemDecoration的完整数据集
    private List<BaseIndexPinyinBean> mSourceDatas;
    //头部数据源
    private List<MeituanHeaderBean> mHeaderDatas;
    //主体部分数据源（城市数据）
    private ArrayList<Bean_cityList.DataBean> mBodyDatas;

    private SuspensionDecoration mDecoration;

    /**
     * 右侧边栏导航区域
     */
    private IndexBar mIndexBar;

    /**
     * 显示指示器DialogText
     */
    private TextView mTvSideBarHint;


    @Override
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_act_city_list;
    }

    @Override
    protected void findViews() {
        mContext = this;

        mRv = (RecyclerView) findViewById(R.id.rv);


        if (toolbar_all != null) {
            TextView text_center = toolbar_all.findViewById(R.id.toolbar_center);
            text_center.setText("城市列表");
        }

    }

    @Override
    public void initData() {


//        获取城市列表
//        HttpUtil.getAsynHttp("frontShop/allCity");
//        getdata("frontShop/allCity");







        String Value =  this.getString(R.string.cityList);

        bean_cityList = MyApp.gson.fromJson(Value, Bean_cityList.class);
        data_cityList = bean_cityList.getData();
        data_cityALL.clear();
        data_cityALL.addAll(data_cityList);

        initDatas(data_cityALL);




        mRv.setLayoutManager(mManager = new LinearLayoutManager(this));
        mSourceDatas = new ArrayList<>();
        mHeaderDatas = new ArrayList<>();
        ArrayList<Bean_cityList.DataBean> locationCity = new ArrayList<>();
        locationCity.add(new Bean_cityList.DataBean(0, "定位中", ""));
        mHeaderDatas.add(new MeituanHeaderBean(locationCity, "定位城市", "定"));





        ArrayList<Bean_cityList.DataBean> hotCitys = new ArrayList<>();
        mHeaderDatas.add(new MeituanHeaderBean(hotCitys, "热门城市", "热"));
        mSourceDatas.addAll(mHeaderDatas);

        mAdapter = new MeituanAdapter(ActCityList.this, R.layout.meituan_item_select_city, mBodyDatas);
        mHeaderAdapter = new HeaderRecyclerAndFooterWrapperAdapter(mAdapter) {
            @Override
            protected void onBindHeaderHolder(ViewHolder holder, int headerPos, int layoutId, Object o) {
                switch (layoutId) {
                    case R.layout.meituan_item_header:
                        final MeituanHeaderBean meituanHeaderBean = (MeituanHeaderBean) o;
                        //网格
                        RecyclerView recyclerView = holder.getView(R.id.rvCity);
                        recyclerView.setAdapter(
                                new CommonAdapter<Bean_cityList.DataBean>(mContext, R.layout.meituan_item_header_item, meituanHeaderBean.getCityList()) {
                                    @Override
                                    public void convert(ViewHolder holder, final String name, final int Id) {

                                        holder.setText(R.id.tvName, name);

                                        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
//                                                Toast.makeText(mContext, "cityName:" + name+"----"+Id, Toast.LENGTH_SHORT).show();
                                                CityName = name;
                                                city_Id = Id;
                                                Toast.makeText(ActCityList.this, name, Toast.LENGTH_SHORT).show();
                                                Toast.makeText(ActCityList.this, name, Toast.LENGTH_SHORT).show();
                                                Bundle bundle = new Bundle();
                                                bundle.putString("CityName", name.replace("c"," "));
                                                bundle.putInt("city_Id", Id);
                                                setResult(RESULT_CANCELED, getIntent().putExtras(bundle));
                                                finish();
                                            }
                                        });
                                    }
                                });
                        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
                        break;
                    case R.layout.meituan_item_header_top:
                        MeituanTopHeaderBean meituanTopHeaderBean = (MeituanTopHeaderBean) o;
                        holder.setText(R.id.tvCurrent, meituanTopHeaderBean.getTxt());
                        break;
                    default:
                        break;
                }
            }
        };


        mHeaderAdapter.setHeaderView(0, R.layout.meituan_item_header_top, new MeituanTopHeaderBean("当前：重庆市"));
//        mHeaderAdapter.setHeaderView(1, R.layout.meituan_item_header, mHeaderDatas.get(0));
        mHeaderAdapter.setHeaderView(2, R.layout.meituan_item_header, mHeaderDatas.get(0));
        mHeaderAdapter.setHeaderView(3, R.layout.meituan_item_header, mHeaderDatas.get(1));


//        mHeaderAdapter.setHeaderView(0, R.layout.meituan_item_header_top, new MeituanTopHeaderBean("当前：上海徐汇"));
//        mHeaderAdapter.setHeaderView(1, R.layout.meituan_item_header, mHeaderDatas.get(0));
//        mHeaderAdapter.setHeaderView(2, R.layout.meituan_item_header, mHeaderDatas.get(1));
//        mHeaderAdapter.setHeaderView(3, R.layout.meituan_item_header, mHeaderDatas.get(2));


        mRv.setAdapter(mHeaderAdapter);
        mRv.addItemDecoration(mDecoration = new SuspensionDecoration(this, mSourceDatas)
                .setmTitleHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 35, getResources().getDisplayMetrics()))
                .setColorTitleBg(0xffefefef)
                .setTitleFontSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()))
                .setColorTitleFont(mContext.getResources().getColor(android.R.color.black))
                .setHeaderViewCount(mHeaderAdapter.getHeaderViewCount() - mHeaderDatas.size()));
        mRv.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST));

        //使用indexBar
        mTvSideBarHint = (TextView) findViewById(R.id.tvSideBarHint);//HintTextView
        mIndexBar = (IndexBar) findViewById(R.id.indexBar);//IndexBar

        mIndexBar.setmPressedShowTextView(mTvSideBarHint)//设置HintTextView
                .setNeedRealIndex(true)//设置需要真实的索引
                .setmLayoutManager(mManager)//设置RecyclerView的LayoutManager
                .setHeaderViewCount(mHeaderAdapter.getHeaderViewCount() - mHeaderDatas.size());


        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, Object o, int position) {
                Log.i("asdas", position + "--" + mBodyDatas.get(position).getCityName() + "---" +
                        mBodyDatas.get(position).getId());
                CityName = mBodyDatas.get(position).getCityName();
                city_Id = mBodyDatas.get(position).getId();
                Toast.makeText(ActCityList.this, mBodyDatas.get(position).getCityName(), Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putString("CityName", mBodyDatas.get(position).getCityName().replace("c",""));
                bundle.putInt("city_Id", mBodyDatas.get(position).getId());
                setResult(RESULT_CANCELED, getIntent().putExtras(bundle));
                finish();
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, Object o, int position) {
                return false;
            }
        });


    }

    @Override
    public void StringResulit(String key, String value) {

        try {
            if (key.equals("frontShop/allCity")) {

            }
        }catch (Exception e){

        }
    }

    /**
     * 组织数据源
     * data
     *
     * @param
     * @return
     */
//    private void initDatas(final String[] data) {
    private void initDatas(final ArrayList<Bean_cityList.DataBean> data_cityALL) {


//        //延迟两秒 模拟加载数据中....
//        getWindow().getDecorView().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mBodyDatas = new ArrayList<>();
//                for (int i = 0; i < data.length; i++) {
//                    MeiTuanBean cityBean = new MeiTuanBean();
//                    cityBean.setCity(data[i]);//设置城市名称
//                    mBodyDatas.add(cityBean);
//                }
//                //先排序
//                mIndexBar.getDataHelper().sortSourceDatas(mBodyDatas);
//
//                mAdapter.setDatas(mBodyDatas);
//                mHeaderAdapter.notifyDataSetChanged();
//                mSourceDatas.addAll(mBodyDatas);
//
//                mIndexBar.setmSourceDatas(mSourceDatas)//设置数据
//                        .invalidate();
//                mDecoration.setmDatas(mSourceDatas);
//            }
//        }, 1000);


        //延迟两秒 模拟加载数据中....
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                mBodyDatas = new ArrayList<>();
                for (int i = 0; i < data_cityALL.size(); i++) {
                    Bean_cityList.DataBean cityBean = new Bean_cityList.DataBean();
                    cityBean.setCityName(data_cityALL.get(i).getCityName());//设置城市名称

                    cityBean.setId(data_cityALL.get(i).getId());//设置城市Id

                    mBodyDatas.add(cityBean);
                }
                //先排序
                mIndexBar.getDataHelper().sortSourceDatas(mBodyDatas);

                mAdapter.setDatas(mBodyDatas);
                mHeaderAdapter.notifyDataSetChanged();
                mSourceDatas.addAll(mBodyDatas);

                mIndexBar.setmSourceDatas(mSourceDatas)//设置数据
                        .invalidate();
                mDecoration.setmDatas(mSourceDatas);
            }
        }, 1000);


        //延迟两秒加载头部
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                MeituanHeaderBean header1 = mHeaderDatas.get(0);
                header1.getCityList().clear();
                header1.getCityList().add(new Bean_cityList.DataBean(310100, "上海", ""));

//                MeituanHeaderBean header2 = mHeaderDatas.get(1);
//                List<String> recentCitys = new ArrayList<>();
//                recentCitys.add("日本");
//                recentCitys.add("北京");
//                header2.setCityList(recentCitys);

                MeituanHeaderBean header3 = mHeaderDatas.get(1);
                ArrayList<Bean_cityList.DataBean> hotCitys = new ArrayList<>();
                hotCitys.add(new Bean_cityList.DataBean(310100, "上海", ""));
                hotCitys.add(new Bean_cityList.DataBean(110100, "北京", ""));
                hotCitys.add(new Bean_cityList.DataBean(330100, "杭州", ""));
                hotCitys.add(new Bean_cityList.DataBean(440100, "广州", ""));
                header3.setCityList(hotCitys);

                mHeaderAdapter.notifyItemRangeChanged(1, 3);

            }
        }, 2000);

    }

    /**
     * 更新数据源
     *
     * @param view
     */
    public void updateDatas(View view) {
        for (int i = 0; i < 5; i++) {
            mBodyDatas.add(new Bean_cityList.DataBean(0, "东京", ""));
            mBodyDatas.add(new Bean_cityList.DataBean(0, "大阪", ""));
        }
        //先排序
        mIndexBar.getDataHelper().sortSourceDatas(mBodyDatas);
        mSourceDatas.clear();
        mSourceDatas.addAll(mHeaderDatas);
        mSourceDatas.addAll(mBodyDatas);

        mHeaderAdapter.notifyDataSetChanged();
        mIndexBar.invalidate();
    }
}
