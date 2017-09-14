package com.example.mrchen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.ant.liao.GifView;
import com.example.mrchen.competition2.R;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.DecimalFormat;
import java.util.Calendar;

import entity.BqueryRun;
import utils.NetUtil;


@SuppressLint("HandlerLeak")
public class StepCounterActivity extends Activity {

    private TextView tv_show_step;// 锟斤拷锟斤拷
    private TextView tv_week_day;// 星期
    private TextView tv_date;// 日期

    private TextView tv_timer;// 时间

    private TextView tv_gongli;
    private TextView tv_distance;// 距离
    private TextView tv_calories;// 卡路里
    private TextView tv_velocity;// 速度

    private Button btn_start;// 开始
    private Button btn_stop;// 停止
    private ImageButton btu_jiantou;

    private GifView gifView;//图片展示
    private boolean isRun = false;

    private long timer = 0;// 锟剿讹拷时锟斤拷
    private  long startTimer = 0;// 锟斤拷始时锟斤拷

    private  long tempTime = 0;

    private Double distance = 0.0;// 距离
    private Double calories = 0.0;// 卡路里
    private Double velocity = 0.0;// 速度

    private int step_length = 0;  //步长
    private int weight = 0;       //体重
    private int total_step = 0;   //总步数

    private Thread thread;  //锟斤拷锟斤拷锟竭程讹拷锟斤拷

    private TableRow hide1, hide2;
    private TextView step_counter;

    //定义数据:距离、日期、星期、时长、卡路里、速度、步数
    String runMileage;//距离
    String runMileages;//公里
    int months;
    int days;
    String weekDays;
    String runTimeLength;
    String runCalory;
    String runAverageSpend;
    int runStepCount;
    int userId=1;


    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);

            countDistance();

            if (timer != 0 && distance != 0.0) {  //判断时间、距离


                calories = weight * distance * 0.001;//卡路里算法

                velocity = distance * 1000 / timer; //速度
            } else {
                calories = 0.0;
                velocity = 0.0;
            }

            countStep();          //锟斤拷锟矫诧拷锟斤拷

            tv_show_step.setText(total_step + "");// 锟斤拷示锟斤拷前锟斤拷锟斤拷
            runStepCount=total_step;

            tv_distance.setText(formatDouble(distance));// 锟斤拷示路锟斤拷
            runMileage=formatDouble(distance);
            tv_gongli.setText(formatDouble((Double.parseDouble(runMileage))/1000));


            tv_calories.setText(formatDouble(calories));// 锟斤拷示锟斤拷路锟斤拷
            runCalory=formatDouble(calories);

            tv_velocity.setText(formatDouble(velocity));// 锟斤拷示锟劫讹拷
            runAverageSpend=formatDouble(velocity);

            tv_timer.setText(getFormatTime(timer));// 锟斤拷示锟斤拷前锟斤拷锟斤拷时锟斤拷
            runTimeLength=getFormatTime(timer);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.main);  //锟斤拷锟矫碉拷前锟斤拷幕

        if (SettingsActivity.sharedPreferences == null) {
            SettingsActivity.sharedPreferences = this.getSharedPreferences(
                    SettingsActivity.SETP_SHARED_PREFERENCES,
                    Context.MODE_PRIVATE);
        }

        Bundle extras = getIntent().getExtras();
        isRun = extras.getBoolean("run");

        if (thread == null) {

            thread = new Thread() {// 锟斤拷锟竭筹拷锟斤拷锟节硷拷锟斤拷前锟斤拷锟斤拷谋浠�

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    super.run();
                    int temp = 0;
                    while (true) {
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        if (StepCounterService.FLAG) {
                            Message msg = new Message();
                            if (temp != StepDetector.CURRENT_SETP) {
                                temp = StepDetector.CURRENT_SETP;
                            }
                            if (startTimer != System.currentTimeMillis()) {
                                timer = tempTime + System.currentTimeMillis()
                                        - startTimer;
                            }
                            handler.sendMessage(msg);// 通知锟斤拷锟竭筹拷
                        }
                    }
                }
            };
            thread.start();
        }
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();


        // 锟斤拷取锟斤拷锟斤拷丶锟�
        addView();

        // 锟斤拷始锟斤拷锟截硷拷
        init();

    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    /**
     * 锟斤拷取Activity锟斤拷乜丶锟�
     */
    private void addView() {
        tv_show_step = (TextView) this.findViewById(R.id.show_step);
        tv_week_day = (TextView) this.findViewById(R.id.week_day);
        tv_date = (TextView) this.findViewById(R.id.date);

        tv_timer = (TextView) this.findViewById(R.id.timer);

        tv_gongli   = (TextView) this.findViewById(R.id.gongli_zhi_sport);
        tv_distance = (TextView) this.findViewById(R.id.distance);
        tv_calories = (TextView) this.findViewById(R.id.calories);
        tv_velocity = (TextView) this.findViewById(R.id.velocity);

        btn_start = (Button) this.findViewById(R.id.start);
        btn_stop = (Button) this.findViewById(R.id.stop);
        btu_jiantou= (ImageButton) this.findViewById(R.id.sport_jiantou_yundong);

        hide1 = (TableRow)findViewById(R.id.hide1);
        hide2 = (TableRow)findViewById(R.id.hide2);
        step_counter = (TextView)findViewById(R.id.step_counter);


        btu_jiantou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if(isRun){
            hide1.setVisibility(View.GONE);
            hide2.setVisibility(View.GONE);
            step_counter.setText("锟斤拷锟斤拷");
        }

        Intent service = new Intent(this, StepCounterService.class);
        stopService(service);
        StepDetector.CURRENT_SETP = 0;
        tempTime = timer = 0;
        tv_timer.setText(getFormatTime(timer));      //锟斤拷锟截憋拷之锟襟，革拷式锟斤拷时锟斤拷
        tv_show_step.setText("0");
        tv_distance.setText(formatDouble(0.0));
        tv_calories.setText(formatDouble(0.0));
        tv_velocity.setText(formatDouble(0.0));

        handler.removeCallbacks(thread);

    }

    /**
     * 锟斤拷始锟斤拷锟斤拷锟斤拷
     */
    private void init() {

        step_length = SettingsActivity.sharedPreferences.getInt(
                SettingsActivity.STEP_LENGTH_VALUE, 70);
        weight = SettingsActivity.sharedPreferences.getInt(
                SettingsActivity.WEIGHT_VALUE, 50);

        countDistance();
        countStep();
        if ((timer += tempTime) != 0 && distance != 0.0) {  //tempTime锟斤拷录锟剿讹拷锟斤拷锟斤拷时锟戒，timer锟斤拷录每锟斤拷锟剿讹拷时锟斤拷

            // 锟斤拷锟截★拷锟斤拷锟斤拷
            // 锟杰诧拷锟斤拷锟斤拷锟斤拷kcal锟斤拷锟斤拷锟斤拷锟截ｏ拷kg锟斤拷锟斤拷锟斤拷锟诫（锟斤拷锟斤）锟斤拷1.036锟斤拷锟斤拷锟斤拷一锟斤拷
            calories = weight * distance * 0.001;

            velocity = distance * 1000 / timer;
        } else {
            calories = 0.0;
            velocity = 0.0;
        }

        tv_timer.setText(getFormatTime(timer + tempTime));

        tv_distance.setText(formatDouble(distance));
        tv_calories.setText(formatDouble(calories));
        tv_velocity.setText(formatDouble(velocity));

        tv_show_step.setText(total_step + "");


        btn_start.setEnabled(!StepCounterService.FLAG);
        btn_stop.setEnabled(StepCounterService.FLAG);

        if (StepCounterService.FLAG) {
            btn_stop.setText(getString(R.string.pause));
        } else if (StepDetector.CURRENT_SETP > 0) {
            btn_stop.setEnabled(true);
            btn_stop.setText(getString(R.string.cancel));
        }

        setDate();
    }

    /**
     * 锟斤拷锟斤拷锟斤拷示锟斤拷锟斤拷锟斤拷
     */
    private void setDate() {
        Calendar mCalendar = Calendar.getInstance();// 锟斤拷取锟斤拷锟斤拷Calendar锟斤拷锟斤拷
        int weekDay = mCalendar.get(Calendar.DAY_OF_WEEK);// 锟斤拷锟斤拷锟斤拷锟斤拷锟�
        int month = mCalendar.get(Calendar.MONTH) + 1;// 锟斤拷前锟铰凤拷
        int day = mCalendar.get(Calendar.DAY_OF_MONTH);// 锟斤拷前锟斤拷锟斤拷


        tv_date.setText(month + getString(R.string.month) + day
                + getString(R.string.day));// 锟斤拷示锟斤拷前锟斤拷锟斤拷
        months=month;
        days=day;

        String week_day_str = new String();
        switch (weekDay) {
            case Calendar.SUNDAY:// 锟斤拷锟斤拷锟斤拷
                week_day_str = getString(R.string.sunday);
                break;

            case Calendar.MONDAY:// 锟斤拷锟斤拷一
                week_day_str = getString(R.string.monday);
                break;

            case Calendar.TUESDAY:// 锟斤拷锟节讹拷
                week_day_str = getString(R.string.tuesday);
                break;

            case Calendar.WEDNESDAY:// 锟斤拷锟斤拷锟斤拷
                week_day_str = getString(R.string.wednesday);
                break;

            case Calendar.THURSDAY:// 锟斤拷锟斤拷锟斤拷
                week_day_str = getString(R.string.thursday);
                break;

            case Calendar.FRIDAY:// 锟斤拷锟斤拷锟斤拷
                week_day_str = getString(R.string.friday);
                break;

            case Calendar.SATURDAY:// 锟斤拷锟斤拷锟斤拷
                week_day_str = getString(R.string.saturday);
                break;
        }
        tv_week_day.setText(week_day_str);

        weekDays=week_day_str;
    }

    /**
     * 锟斤拷锟姐并锟斤拷式锟斤拷doubles锟斤拷值锟斤拷锟斤拷锟斤拷锟斤拷位锟斤拷效锟斤拷锟斤拷
     *
     * @param doubles
     * @return 锟斤拷锟截碉拷前路锟斤拷
     */
    private String formatDouble(Double doubles) {
        DecimalFormat format = new DecimalFormat("####.##");
        String distanceStr = format.format(doubles);
        return distanceStr.equals(getString(R.string.zero)) ? getString(R.string.double_zero)
                : distanceStr;
    }

    public void onClick(View view) {
        Intent service = new Intent(this, StepCounterService.class);
        switch (view.getId()) {
            case R.id.start:
//                gifView.showAnimation();
                startService(service);
                btn_start.setEnabled(false);
                btn_stop.setEnabled(true);
                btn_stop.setText(getString(R.string.pause));
                startTimer = System.currentTimeMillis();
                tempTime = timer;
                break;

            case R.id.stop:
                stopService(service);
//                gifView.showCover();
                if (StepCounterService.FLAG && StepDetector.CURRENT_SETP > 0) {
                    btn_stop.setText(getString(R.string.cancel));
                } else {
                    StepDetector.CURRENT_SETP = 0;
                    tempTime = timer = 0;

                    btn_stop.setText(getString(R.string.pause));
                    btn_stop.setEnabled(false);

                    tv_timer.setText(getFormatTime(timer));      //锟斤拷锟截憋拷之锟襟，革拷式锟斤拷时锟斤拷

                    tv_show_step.setText("0");
                    tv_distance.setText(formatDouble(0.0));
                    tv_calories.setText(formatDouble(0.0));
                    tv_velocity.setText(formatDouble(0.0));

                    initTadeKing();
                    handler.removeCallbacks(thread);
                }
                btn_start.setEnabled(true);
                break;
        }
    }

    /**
     * 锟矫碉拷一锟斤拷锟斤拷式锟斤拷锟斤拷时锟斤拷
     *
     * @param time
     *            时锟斤拷 锟斤拷锟斤拷
     * @return 时锟斤拷锟街ｏ拷锟诫：锟斤拷锟斤拷
     */
    private String getFormatTime(long time) {
        time = time / 1000;
        long second = time % 60;
        long minute = (time % 3600) / 60;
        long hour = time / 3600;

        // 锟斤拷锟斤拷锟斤拷锟斤拷示锟斤拷位
        // String strMillisecond = "" + (millisecond / 10);
        // 锟斤拷锟斤拷示锟斤拷位
        String strSecond = ("00" + second)
                .substring(("00" + second).length() - 2);
        // 锟斤拷锟斤拷示锟斤拷位
        String strMinute = ("00" + minute)
                .substring(("00" + minute).length() - 2);
        // 时锟斤拷示锟斤拷位
        String strHour = ("00" + hour).substring(("00" + hour).length() - 2);

        return strHour + ":" + strMinute + ":" + strSecond;
        // + strMillisecond;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_step, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.menu_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;

            case R.id.ment_information:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 锟斤拷锟斤拷锟斤拷锟竭的撅拷锟斤拷
     */
    private void countDistance() {
        if (StepDetector.CURRENT_SETP % 2 == 0) {
            distance = (StepDetector.CURRENT_SETP / 2) * 3 * step_length * 0.01;
        } else {
            distance = ((StepDetector.CURRENT_SETP / 2) * 3 + 1) * step_length * 0.01;
        }
    }

    /**
     * 实锟绞的诧拷锟斤拷
     */
    private void countStep() {
        if (StepDetector.CURRENT_SETP % 2 == 0) {
            total_step = StepDetector.CURRENT_SETP;
        } else {
            total_step = StepDetector.CURRENT_SETP +1;
        }

        total_step = StepDetector.CURRENT_SETP;
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        finish();
    }

    //弹出选择框
    public void initTadeKing(){
        Dialog dialog=new AlertDialog.Builder(this).setTitle("保存记录").setIcon(R.mipmap.ic_launcher)
                .setMessage("是否保存记录并分享？").setPositiveButton("是，保存并分享", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(StepCounterActivity.this, "这个等会", Toast.LENGTH_SHORT).show();
                    }
                }).setNeutralButton("否,只保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        RequestParams requestParams=new RequestParams(NetUtil.url+"InsertRunServlet");

                        //requestParams.addQueryStringParameter("userId",((MyApplication)getActivity().getApplication()).getUser().getUserId()+"");

                        runMileages=formatDouble((Double.parseDouble(runMileage))/1000);


                        BqueryRun bqueryRun=new BqueryRun(userId,months,days,runStepCount,runMileages,runMileage,
                                weekDays,runTimeLength,runCalory,runAverageSpend);

                        Gson gson=new Gson();
                        String toRun=gson.toJson(bqueryRun);
                        requestParams.addQueryStringParameter("toRun",toRun);

                        x.http().get(requestParams, new Callback.CommonCallback<String>() {
                            @Override
                            public void onSuccess(String result) {
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
                }).create();
        dialog.show();
    }

}
