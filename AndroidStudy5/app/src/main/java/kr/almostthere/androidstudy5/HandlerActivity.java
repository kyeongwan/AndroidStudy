package kr.almostthere.androidstudy5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by lk on 2017. 3. 10..
 */

public class HandlerActivity extends AppCompatActivity {

    public void onCreate(Bundle savedBundle){
        super.onCreate(savedBundle);

        /**
         * 핸들러 Msg.what 을 쓸 때 final 로 선언해놓고 쓰면 가독성이 좋다.
         */
        final int START_ACTIVITY = 100;
        final int FINISH_ACTIVITY = 200;

        Handler handler = new Handler(){

            /**
             * handlerMessage 를 Override 해서 핸들러를 구현하자
             */
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                switch (msg.what){
                    case START_ACTIVITY:
                        Intent intent = new Intent();
                        intent.putExtra("aa", (String)msg.obj);
                        break;
                    case FINISH_ACTIVITY:
                        finish();
                        break;
                    default:
                        break;
                }


            }
        };
        Message message = new Message();
        message.what = START_ACTIVITY;
        message.obj = (Object) "ㅁㅁㅁㅁㅁㅁㅁ";


        Message message1 = new Message();
        message1.what = FINISH_ACTIVITY;

        handler.sendMessage(message);

        handler.sendMessageDelayed(message1, 1000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "1초 지남", Toast.LENGTH_SHORT).show();
            }
        },1000);


    }
}
