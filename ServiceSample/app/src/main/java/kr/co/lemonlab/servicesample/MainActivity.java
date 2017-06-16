package kr.co.lemonlab.servicesample;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvCounter;
    private Button btnStart;
    private Button btnStop;
    private IMyCounterService binder;
    private boolean running = true;
    Handler handler = new Handler();


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            /** * Service가 가지고있는 binder를 전달받는다. * 즉, Service에서 구체화한 getCount() 메소드를 받았습니다. */
            binder = IMyCounterService.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        };
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int count = 0;
//                while(true){
//                    count++;
//                    Integer integer = new Integer(count);
//                    Message m = new Message();
//                    m.what= 100;
//                    m.arg1 = count;
//                    m.obj = integer;
//                    Integer i = (Integer) m.obj;
//                    handler.sendMessage(m);
//                }
//
//            }
//        });
//
//        handler.post(t);
//        handler.post(r);

        MyApplication.BData = 10;




        tvCounter = (TextView) findViewById(R.id.tvCounter);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // START 버튼을 누르면 MyCounterService 시작
                Log.i("MainActivity", "Start Button Click");
                Intent intent = new Intent(MainActivity.this, MyCounterService.class);
//                startService(intent);
                bindService(intent, connection, BIND_AUTO_CREATE);
                running = true;
                new Thread(new GetCountThread()).start();

            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // STOP 버튼을 누르면 MyCounterService 종료
                Intent intent = new Intent(MainActivity.this, MyCounterService.class);
//                stopService(intent);
                unbindService(connection);
                running = false;

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class GetCountThread implements Runnable {
        // binder에서 count가져와서 set시키려면 handler 필요
        private Handler handler = new Handler();

        @Override
        public void run() {
            while (running) {
                if (binder == null) {
                    continue;
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Log.i("MainActivity", binder.getCount() + "");
                            tvCounter.setText(binder.getCount() + "");
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }); // 1초 텀을 준다.
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
