package com.oic.app.a10service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.net.URI;

public class BActivity extends AppCompatActivity {
    public static String EXTRA_URI = "uri";

    MyService mMyService;

    ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder binder = (MyService.MyBinder)service;
            mMyService = binder.getMyService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mMyService = null;
        }
    };


    public static Intent getBIntent(Context context, String url){
        Intent intentB = new Intent(context, BActivity.class);
        intentB.putExtra(EXTRA_URI,"htpp://google.com");
        return intentB;
    }

    public static Intent getBIntent(Context context, Uri url){
        Intent intentB = new Intent(context, BActivity.class);
        intentB.putExtra("uri","htpp://google.com");
        return intentB;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        if(getIntent().hasExtra(EXTRA_URI)) {
            String url = getIntent().getStringExtra("url");
            // hient thi url
        }else if(getIntent().hasExtra("uri")){
            String uri = getIntent().getStringExtra("uri");
            // hien thi uri
        }


        // display web url...
        Intent intentMyService = new Intent(this, MyService.class);
        intentMyService.putExtra("url","http://google.com");
        bindService(intentMyService, myConnection,BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(myConnection);
    }
}
