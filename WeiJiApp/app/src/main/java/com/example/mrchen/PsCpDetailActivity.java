package com.example.mrchen;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mrchen.competition2.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import entity.Competition;
import entity.User;
import utils.CommonAdapter;
import utils.NetUtil;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PsCpDetailActivity extends AppCompatActivity {


    Competition competition;
    MyPageAdapter myPageAdapter;
    private ViewPager pscpViewPager;
    TextView pscpJsTV;
    TextView pscpLyTV;
    TextView pscpTv1;
    TextView pscpTv2;
    private List<View> views = new ArrayList<View>();

    List<User> users = new ArrayList<>();
    CommonAdapter userAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ps_cp_detail);
        ButterKnife.inject(this);

        pscpViewPager = (ViewPager) findViewById(R.id.pscp_vp);
        pscpJsTV = (TextView) findViewById(R.id.pscp_jstv);
        pscpLyTV = (TextView) findViewById(R.id.pscp_lytv);
        pscpTv1= (TextView) findViewById(R.id.pscp_tv1);
        pscpTv2= (TextView) findViewById(R.id.pscp_tv2);




        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view1 = layoutInflater.inflate(R.layout.pscp_detail_lv1, null);
        View view2 = layoutInflater.inflate(R.layout.pscp_detail_lv2, null);

        views.add(view1);
        views.add(view2);

        myPageAdapter = new MyPageAdapter();
        pscpViewPager.setAdapter(myPageAdapter);

        initEvents();
        initData();

    }

    private void initData() {

        Intent intent=getIntent();
        competition=intent.getParcelableExtra("competition");
        Log.i("PsCpDetailActivity", "initData: competition"+competition);

        //必须为字符串才行
        pscpTv1.setText(competition.getBeginTime()+"");
        pscpTv2.setText(competition.getScore()+"");

        getUserData();

    }

    public void getUserData(){
        RequestParams requestParams = new RequestParams(NetUtil.url + "SelectCompetitionServlet");
        x.http().get(requestParams, new Callback.CommonCallback<String>() {


            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                Type type = new TypeToken<List<User>>(){}.getType();

                users=gson.fromJson(result, type);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


    private void initEvents() {

        pscpViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int currentItem = pscpViewPager.getCurrentItem();
                resetImg();
                switch (currentItem) {
                    case 0:
                        pscpJsTV.setTextColor(Color.BLUE);
                        break;

                    case 1:
                        pscpLyTV.setTextColor(Color.BLUE);
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @OnClick({R.id.pscp_jstv, R.id.pscp_lytv})
    public void onClick(View view) {
        resetImg();
        switch (view.getId()) {
            case R.id.pscp_jstv:
                pscpViewPager.setCurrentItem(0);
                pscpJsTV.setTextColor(Color.BLUE);
                break;
            case R.id.pscp_lytv:
                pscpViewPager.setCurrentItem(1);
                break;
        }
    }

    class MyPageAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView(views.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View view = views.get(position);
            container.addView(view);

            return view;
        }

    }

    //重置颜色方法
    private void resetImg() {

        pscpJsTV.setTextColor(Color.BLACK);
        pscpLyTV.setTextColor(Color.BLACK);

    }


}