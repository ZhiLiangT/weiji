package com.example.mrchen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.mrchen.competition2.R;

import myFragment.communicateFragment;
import myFragment.competitionFragment;
import myFragment.meFragment;
import myFragment.sportFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.fragment)
    FrameLayout fragment;
    @InjectView(R.id.sportImageButton)
    ImageButton sportImageButton;
    @InjectView(R.id.sport)
    LinearLayout sport;
    @InjectView(R.id.communityImageButton)
    ImageButton communityImageButton;
    @InjectView(R.id.community)
    LinearLayout community;
    @InjectView(R.id.competitionImageButton)
    ImageButton competitionImageButton;
    @InjectView(R.id.competition)
    LinearLayout competition;
    @InjectView(R.id.meImageButton)
    ImageButton meImageButton;
    @InjectView(R.id.me)
    LinearLayout me;

    private Fragment fragment01;
    private Fragment fragment02;
    private Fragment fragment03;
    private Fragment fragment04;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        setSelect(2);
    }





    /**
     * 把图片设置为亮的
     * 设置内容区域
     * @param i
     */

    private void setSelect(int i){

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ts=fm.beginTransaction();

        hideFragment(ts);
        resetImgs();
        switch (i){
            case 0:
                sportImageButton.setImageResource(R.mipmap.ic_launcher);
                if (fragment01==null){
                    fragment01=new sportFragment();
                    ts.add(R.id.fragment,fragment01);
                }else {
                    ts.show(fragment01);
                }

                break;
            case 1:
                communityImageButton.setImageResource(R.mipmap.ic_launcher);
                if (fragment02==null){
                    fragment02=new communicateFragment();
                    ts.add(R.id.fragment,fragment02);
                }else {
                    ts.show(fragment02);
                }

                break;
            case 2:
                competitionImageButton.setImageResource(R.mipmap.ic_launcher);
                if (fragment03==null){
                    fragment03=new competitionFragment();
                    ts.add(R.id.fragment,fragment03);
                }else {
                    ts.show(fragment03);
                }

                break;
            case 3:
                meImageButton.setImageResource(R.mipmap.ic_launcher);
                if (fragment04==null){
                    fragment04=new meFragment();
                    ts.add(R.id.fragment,fragment04);
                }else {
                    ts.show(fragment04);
                }

                break;
            default:
                break;
        }

        ts.commit();

    }


    private void hideFragment(FragmentTransaction ts) {
        if (fragment01!=null){
            ts.hide(fragment01);
        }

        if (fragment02!=null){
            ts.hide(fragment02);
        }

        if (fragment03!=null){
            ts.hide(fragment03);
        }

        if (fragment04!=null){
            ts.hide(fragment04);
        }

    }

    @OnClick({R.id.sportImageButton, R.id.communityImageButton, R.id.competitionImageButton, R.id.meImageButton})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.sportImageButton:
                setSelect(0);
                break;
            case R.id.communityImageButton:
                setSelect(1);
                break;
            case R.id.competitionImageButton:
                setSelect(2);
                break;
            case R.id.meImageButton:
                setSelect(3);
                break;
        }
    }

    private void resetImgs() {

        sportImageButton.setImageResource(R.mipmap.zhanghao);
        communityImageButton.setImageResource(R.mipmap.zhanghao);
        competitionImageButton.setImageResource(R.mipmap.zhanghao);
        meImageButton.setImageResource(R.mipmap.zhanghao);

    }
}
