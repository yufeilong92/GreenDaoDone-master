package com.example.myapplication;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity {
    private Chronometer timer;
    private Timer timer1;
    private TextView textView;
    private TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        timer = (Chronometer) findViewById(R.id.timer);
        textView = (TextView) findViewById(R.id.text);
        timer1 = new Timer();
        BigDecimal b1 = new BigDecimal(Double.toString(15));
        BigDecimal b2 = new BigDecimal(Double.toString(85));
        //默认保留两位会有错误，这里设置保留小数点后4位
        double v1 = b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
        Log.e("===" ,"onCreate: "+(int)(v1 *100));
    }

    public void btnClick(View view) {
        timer.setBase(SystemClock.elapsedRealtime());//计时器清零
        int hour = (int) ((SystemClock.elapsedRealtime() - timer.getBase()) / 1000 / 60);
        timer.setFormat("0" + String.valueOf(hour) + ":%s");
        timer.start();
    }

    public void stopClick(View view) {
        timer.stop();
    }

    public void startClick(View view) {
        timerTask = new TimerTask() {
            int cnt = 0;

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(getStringTime(cnt++));
                    }
                });
            }
        };
        timer1.schedule(timerTask, 0, 1000);
    }

    private String getStringTime(int cnt) {
        int hour = cnt / 3600;
        int min = cnt % 3600 / 60;
        int second = cnt % 60;
        return String.format(Locale.CHINA, "%02d:%02d:%02d", hour, min, second);
    }

    public void stopClick1(View view) {
        if (!timerTask.cancel()) {
            timerTask.cancel();
            timer1.cancel();
        }
    }
}

