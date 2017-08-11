package com.oic.app.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    String text;

    TextView tvMessage;

    MyClickListener mMyClickListener = new MyClickListener();

    public static class MyClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvMessage = (TextView)findViewById(R.id.tv_message);
        Button btnOk = (Button) findViewById(R.id.btn_Ok);



        text = getIntent().getStringExtra("message");

        tvMessage.setText(text);
    }

    public void onBtnOkClick(View view){
        setResult(2);
        finish();
    }
}
