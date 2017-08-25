package com.oic.app.a10service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import java.io.File;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //startActivity(BActivity.getBIntent(this, "http://google.com"));
        File folder = new File(Environment.DIRECTORY_PICTURES);
    }

    public void startActivityB(View view){
        startActivity(new Intent(this, BActivity.class));
    }

    public void startMyService(View view) {
        Log.e("TAG","start myService...");
        Intent intentMyService = new Intent(this, MyService.class);
        intentMyService.putExtra("url","http://google.com");
        startService(intentMyService);
    }

    public void bindMyService(View view){
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
