package com.oic.app.customview;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

/**
 * Created by khacpham on 7/25/17.
 */

public class MyLocalBindService extends Service {

    public class LocalBinder extends Binder {

        public MyLocalBindService getService(){
            return MyLocalBindService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // only execute once
        // called if someone call bindService() but has not existed
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // called every time when be bound
        return new LocalBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        // called every time when unbound.
        // true: rebind, false: unbind
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        // called if onUnbind() return true
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // when no one is binding this service, auto destroy
    }
}
