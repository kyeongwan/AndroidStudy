package kr.almostthere.android4.activity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){

    }

    @Override
    public void onDestroy(){

    }
}
