package com.example.mrchen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mrchen.competition2.R;

import entity.Run;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class RunInFoActivity extends AppCompatActivity {


    @InjectView(R.id.jilu66_yundong)
    LinearLayout jilu66Yundong;
    @InjectView(R.id.shuzhi2_gongli)
    TextView shuzhi2Gongli;
    @InjectView(R.id.gongli_yundongjilu)
    TextView gongliYundongjilu;
    @InjectView(R.id.suibianla)
    LinearLayout suibianla;
    @InjectView(R.id.suibianView)
    View suibianView;
    @InjectView(R.id.one_tupian)
    ImageView oneTupian;
    @InjectView(R.id.shichang_one)
    TextView shichangOne;
    @InjectView(R.id.textView2)
    TextView textView2;
    @InjectView(R.id.two_tupian)
    ImageView twoTupian;
    @InjectView(R.id.pingjunsudu_one)
    TextView pingjunsuduOne;
    @InjectView(R.id.pingjunsudu_two)
    TextView pingjunsuduTwo;
    @InjectView(R.id.detail_one)
    RelativeLayout detailOne;
    @InjectView(R.id.suibianView_two)
    View suibianViewTwo;
    @InjectView(R.id.three_tupian)
    ImageView threeTupian;
    @InjectView(R.id.daka)
    TextView daka;
    @InjectView(R.id.kaluli)
    TextView kaluli;
    @InjectView(R.id.four_tupian)
    ImageView fourTupian;
    @InjectView(R.id.bulv)
    TextView bulv;
    @InjectView(R.id.bulv_fenzhong)
    TextView bulvFenzhong;
    @InjectView(R.id.detail_two)
    RelativeLayout detailTwo;
    @InjectView(R.id.suibianView_three)
    View suibianViewThree;
    @InjectView(R.id.bushu_zhiqqq)
    TextView bushuZhiqqq;
    @InjectView(R.id.buzhu_vulr)
    TextView buzhuVulr;
    @InjectView(R.id.meiyouidnayoujiantou)
    ImageButton meiyouidnayoujiantou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_in_fo);
        ButterKnife.inject(this);


        Intent intent = getIntent();
        Run run = intent.getParcelableExtra("run");

        shuzhi2Gongli.setText(run.getMileages());
        shichangOne.setText(run.getTimeLength());
        daka.setText(run.getCalories());
        bulv.setText(run.getVelocity());
        buzhuVulr.setText(run.getStepCount());
        pingjunsuduOne.setText(run.getMileage());


        meiyouidnayoujiantou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
