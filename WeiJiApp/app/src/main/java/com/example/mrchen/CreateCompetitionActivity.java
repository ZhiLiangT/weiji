package com.example.mrchen;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.mrchen.competition2.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import entity.Competition;
import utils.NetUtil;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class CreateCompetitionActivity extends AppCompatActivity {

    /*Button ckdPjsb1;
    ImageView ckd_top_ig;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    EditText editText7;
    EditText editText8;*/
    int userId;
    String type;
    String beginTime;
    String endTime;
    int score;
    String detail;
    String title;
    int num;

    Competition competition;

    @InjectView(R.id.textView)
    TextView textView;
    @InjectView(R.id.ckd_top_ig)
    ImageView ckdTopIg;
    @InjectView(R.id.lytop2)
    RelativeLayout lytop2;
    @InjectView(R.id.ckd_pjs_et1)
    EditText ckdPjsEt1;
    @InjectView(R.id.ckd_pjs_bt1)
    ImageButton ckdPjsBt1;
    @InjectView(R.id.ckd_pjs_et2)
    EditText ckdPjsEt2;
    @InjectView(R.id.ckd_pjs_bt2)
    ImageButton ckdPjsBt2;
    @InjectView(R.id.ckd_pjs_et3)
    EditText ckdPjsEt3;
    @InjectView(R.id.ckd_pjs_bt3)
    ImageButton ckdPjsBt3;
    @InjectView(R.id.ckd_pjs_et4)
    EditText ckdPjsEt4;
    @InjectView(R.id.ckd_pjs_bt4)
    ImageButton ckdPjsBt4;
    @InjectView(R.id.ckd_pjs_et5)
    EditText ckdPjsEt5;
    @InjectView(R.id.ckd_pjs_bt5)
    ImageButton ckdPjsBt5;
    @InjectView(R.id.ckd_pjs_et6)
    EditText ckdPjsEt6;
    @InjectView(R.id.ckd_pjs_bt6)
    ImageButton ckdPjsBt6;
    @InjectView(R.id.ckd_pjs_et7)
    EditText ckdPjsEt7;
    @InjectView(R.id.ckd_pjs_bt7)
    ImageButton ckdPjsBt7;
    @InjectView(R.id.ckd_pjs_et8)
    EditText ckdPjsEt8;
    @InjectView(R.id.ckd_pjs_bt8)
    ImageButton ckdPjsBt8;
    @InjectView(R.id.ckd_pjsb1)
    Button ckdPjsb1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_competition);
        ButterKnife.inject(this);

        /*editText1= (EditText) findViewById(R.id.editText);
        editText2= (EditText) findViewById(R.id.editText2);
        editText3= (EditText) findViewById(R.id.editText3);
        editText4= (EditText) findViewById(R.id.editText4);
        editText5= (EditText) findViewById(R.id.editText5);
        editText6= (EditText) findViewById(R.id.editText7);
        editText7= (EditText) findViewById(R.id.editText8);
        editText8= (EditText) findViewById(R.id.editText11);*/


        x.view().inject(this);

        initEvent();

    }

    private void initEvent() {


        ckdPjsb1 = (Button) findViewById(R.id.ckd_pjsb1);
        ckdTopIg = (ImageView) findViewById(R.id.ckd_top_ig);
        ckdPjsb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        ckdTopIg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateCompetitionActivity.this, PersonCompetitionActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("确认对话框");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("确认对话框提示内容");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i("CreateCompetition", "onClick: ");
                Toast.makeText(CreateCompetitionActivity.this, "确认", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CreateCompetitionActivity.this, PersonCompetitionActivity.class);

                userId = Integer.parseInt(ckdPjsEt1.getText().toString());
                type = ckdPjsEt2.getText().toString();
                beginTime = ckdPjsEt3.getText().toString();
                endTime = ckdPjsEt4.getText().toString();
                score = Integer.parseInt(ckdPjsEt5.getText().toString());
                title = ckdPjsEt6.getText().toString();
                num = Integer.parseInt(ckdPjsEt7.getText().toString());
                detail = ckdPjsEt8.getText().toString();


                competition=new Competition(userId,type,beginTime,endTime,score,title,detail,num);
                RequestParams requestParams = new RequestParams(NetUtil.url + "CreateCompetitionServlet");
                Log.i("CreateCompetition", "onClick: 1");

                //插入
                Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();

                String competitioninfo = gson.toJson(competition);

                requestParams.addQueryStringParameter("competitionInfo", competitioninfo);
                Log.i("CreateCompetition", "onClick: "+competitioninfo);


                x.http().get(requestParams, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.i("CreateCompetition", "onSuccess: ");
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.i("CreateCompetition", "onError: " + ex);
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });

                startActivity(intent);
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(CreateCompetitionActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    @OnClick({R.id.ckd_pjs_bt1, R.id.ckd_pjs_bt2, R.id.ckd_pjs_bt3, R.id.ckd_pjs_bt4, R.id.ckd_pjs_bt5, R.id.ckd_pjs_bt6, R.id.ckd_pjs_bt7, R.id.ckd_pjs_bt8})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ckd_pjs_bt1:
                break;
            case R.id.ckd_pjs_bt2:
                break;
            case R.id.ckd_pjs_bt3:
                showDialogPick((TextView) ckdPjsEt3);
                break;
            case R.id.ckd_pjs_bt4:
                showDialogPick((TextView) ckdPjsEt4);
                break;
            case R.id.ckd_pjs_bt5:
                break;
            case R.id.ckd_pjs_bt6:
                break;
            case R.id.ckd_pjs_bt7:
                break;
            case R.id.ckd_pjs_bt8:
                break;
        }
    }


    //将两个选择时间的dialog放在该函数中
    private void showDialogPick(final TextView timeText) {
        final StringBuffer time = new StringBuffer();
        //获取Calendar对象，用于获取当前时间
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        //实例化TimePickerDialog对象
        final TimePickerDialog timePickerDialog = new TimePickerDialog(CreateCompetitionActivity.this, new TimePickerDialog.OnTimeSetListener() {
            //选择完时间后会调用该回调函数
            int flag = 0;
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if (flag == 0) {
                    time.append(" " + hourOfDay + ":" + minute);
                    flag++;
                }
                Log.i("PublishActivity", "onTimeSet: 111" + time);
                //设置TextView显示最终选择的时间
                timeText.setText(time);
            }
        }, hour, minute, true);
        //实例化DatePickerDialog对象
        DatePickerDialog datePickerDialog = new DatePickerDialog(CreateCompetitionActivity.this, new DatePickerDialog.OnDateSetListener() {
            //选择完日期后会调用该回调函数
            int flag = 0;
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Log.i("PublishActivity", "onDateSet: 222" + time + "---" + flag);
                //因为monthOfYear会比实际月份少一月所以这边要加1
                if (flag == 0) {
                    time.append(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    flag++;
                }
                //选择完日期后弹出选择时间对话框
                timePickerDialog.show();
                Log.i("PublishActivity", "onDateSet:3333 " + time + "--" + flag);
            }
        }, year, month, day);
        Log.i("PublishActivity", "showDialogPick: 4444" + time);
        //弹出选择日期对话框
        datePickerDialog.show();
        Log.i("PublishActivity", "showDialogPick: 5555" + time);
    }

    public Timestamp getTimeTamp(String string) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Timestamp timestamp = null;

        timestamp = Timestamp.valueOf(string);

        return timestamp;
    }

}
