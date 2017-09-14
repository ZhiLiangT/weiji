package com.example.mrchen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mrchen.competition2.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.List;

import entity.Run;
import myApplication.MyApplication;
import utils.CommonAdapter;
import utils.NetUtil;
import utils.ViewHolder;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class RunRecordActivity extends AppCompatActivity {

    @InjectView(R.id.rela_top)
    RelativeLayout relaTop;
    @InjectView(R.id.quan_sport_record)
    ListView quanSportRecord;
    @InjectView(R.id.sport_jiantou_imagebtu)
    ImageButton jiantou;

    CommonAdapter<Run> runAdap;
    List<Run> runs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_record);
        ButterKnife.inject(this);

        jiantou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initDate();
    }

    public void initDate() {
        //获取网络数据
        RequestParams requestParams=new RequestParams(NetUtil.url+"QueryRunServlet");
        requestParams.addQueryStringParameter("userId",((MyApplication)this.getApplication()).getUser().getUserId()+"");
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("hhhhhh", "onSuccess: "+result);
                Gson gson=new Gson();
                Type type=new TypeToken<List<Run>>(){}.getType();
               runs=gson.fromJson(result,type);
                if (runAdap==null){
                   runAdap=new CommonAdapter<Run>(RunRecordActivity.this,runs, R.layout.list_item_record) {
                       @Override
                       public void convert(ViewHolder viewHolder, Run run, int position) {
                           Log.i("hhhhhh", "convert: ");
                           init(viewHolder,run,position);
                       }
                   };
                    quanSportRecord.setAdapter(runAdap);
                }else {
                    runAdap.notifyDataSetChanged();
                }
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.i("hhhhhh", "onError: "+ex);
            }
            @Override
            public void onCancelled(CancelledException cex) {
            }
            @Override
            public void onFinished() {
            }
        });

        quanSportRecord.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(RunRecordActivity.this,RunInFoActivity.class);
                intent.putExtra("run", runs.get(position));
                startActivity(intent);
            }
        });
    }

    public void init(ViewHolder viewHolder, Run run, int position){
        Log.i("hhhhhh", "init: ");
        TextView tvRiQi=viewHolder.getViewById(R.id.riqi_sport_record);
        tvRiQi.setText(run.getMonth()+"月"+run.getDay()+"日");
        TextView tvBuShu=viewHolder.getViewById(R.id.sport_bushu);
        tvBuShu.setText("步数  "+run.getStepCount());
        TextView tvShiChang=viewHolder.getViewById(R.id.sport_shichang);
        tvShiChang.setText("时长  "+run.getTimeLength());
        TextView tvGongLi=viewHolder.getViewById(R.id.sport_gongli_wobuzhidao);
        tvGongLi.setText(run.getMileages());
    }

}
