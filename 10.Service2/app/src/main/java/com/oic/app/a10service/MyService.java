package com.oic.app.a10service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG","oncreate service");
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
        Log.e("TAG","onStartCommand");
        String url = intent.getStringExtra("url");
        Log.e("TAG","url: "+url);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG","onDestroy");
    }

    public void myFunc(){

    }





    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public class MyBinder extends Binder {

        public MyService getMyService(){
            return MyService.this;
        }
    }
}
