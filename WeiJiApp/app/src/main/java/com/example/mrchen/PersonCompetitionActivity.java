package com.example.mrchen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrchen.competition2.R;

import myFragment.personFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class PersonCompetitionActivity extends AppCompatActivity {

    @InjectView(R.id.textView)
    TextView textView;
    @InjectView(R.id.ckd_top_ig)
    ImageView ckdTopIg;
    @InjectView(R.id.ckd_pjsR)
    FrameLayout ckdPjsR;
    @InjectView(R.id.ckd_pjst1)
    TextView ckdPjst1;
    @InjectView(R.id.ckd_pjst2)
    TextView ckdPjst2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_competition);
        ButterKnife.inject(this);


        personFragment fragment = new personFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ts = fm.beginTransaction();
        ts.replace(R.id.ckd_pjsR, fragment);
        ts.commit();


    }

    @OnClick({R.id.ckd_top_ig, R.id.ckd_pjst1, R.id.ckd_pjst2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ckd_top_ig:
                Intent intent =new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.ckd_pjst1:
                Intent intent01 =new Intent(this,CreateCompetitionActivity.class);
                startActivity(intent01);
                break;
            case R.id.ckd_pjst2:
                break;
        }
    }
}
