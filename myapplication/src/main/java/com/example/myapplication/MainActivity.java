package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SaveUUidUtil.initSharedPreference(this);
        SaveUUidUtil.getInstance().putUUID("222222222");
        String userId = SaveUUidUtil.getInstance().getUserId();
        Log.e("tfl", "onCreate: " + userId);

        int a = 10;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 2) {
                list.remove(i);
                Log.e("yfl", "onCreate: " + 2);
            }
        }
        list.add(222);
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            Log.e("yfl", "onCreate: " + integer);
        }

    }
}
