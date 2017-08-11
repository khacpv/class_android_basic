package com.oic.app.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class StopwatchActivity extends Activity {

    int time = 0;

    TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        Log.e("StopwatchActivity", "onCreated");

        tvTime = (TextView) this.findViewById(R.id.tv_time);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("StopwatchActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("StopwatchActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("StopwatchActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("StopwatchActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("StopwatchActivity", "onDestroy");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e("StopwatchActivity", "onConfigurationChanged");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("StopwatchActivity", "save info");
    }

    Handler handler = new Handler();

    public void onClickStart(View view) {
        Log.e("StopwatchActivity", "bat dau dem");

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time++;
                updateTime();

                handler.postDelayed(this, 1000);
            }
        }, 1000);
    }

    public void onClickStop(View view) {
        Log.e("StopwatchActivity", "tam dung dem");
    }

    public void onClickReset(View view) {
        Log.e("StopwatchActivity", "reset time");
    }

    public void onClickStartSecondActivity(View view){
        // goi sang Activity Second
        //Intent intent = new Intent(this, SecondActivity.class);
        //intent.putExtra("message","Hello Second Activity");
        ////startActivity(intent);
        //startActivityForResult(intent, 1);


        Intent viewIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(viewIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("StopwatchActivity", "req:"+requestCode+" result:"+resultCode);
    }

    private void updateTime(){
        int hour = time / 3600;
        int min = (time % 3600) / 60;
        int second = time % 60;
        //tvTime.setText(hour + ":" + min + ":" + second);
        tvTime.setText(String.format("%s:%s:%s", hour, min, second));
    }
}
