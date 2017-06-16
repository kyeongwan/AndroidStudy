package kr.android.androidstudy13;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by lk on 2017. 4. 9..
 */

public class CustomService extends Service {

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate(){
//        jfkalsdjfklajkljksadl

        startActivity();
    }



    public void onDestroy(){
        //jkdlfjkls
    }


}
