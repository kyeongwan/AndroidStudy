package kr.kyeongwan.androidstudy2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button);
        Log.e("Name", "onCreate");

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();                                        // 인덴트 선언
                i.setClass(getApplicationContext(), NextActivity.class);        // 만든 인덴트에다가 클래스 선언해줌 context, ClassName
                i.putExtra("Data", num);                                          // putExtra(key value) 인덴트에다가 데이터를 실어 보낼때
                startActivityForResult(i, 100);                                 // 보통은 startActivity(intent) , startActivityForResult(intent, reqcode) 다시 이 액티비티가 호출되었을 때
                                                                                // onActivityResult() 를 호출합니다
            }
        });
    }

    @Override
    protected void onActivityResult(int rqCode, int resultCode, Intent data) {
        Log.e("onActivityResult", "requestCode" + rqCode + " / resultCode" + resultCode);
        if (rqCode == 100) {

            if(resultCode == RESULT_OK) {
                int beforeNum = data.getIntExtra("Data", -1);
                Log.e("Data", "Data is " + beforeNum);
                num = beforeNum;
                tv.setText(beforeNum + " ");
                Toast.makeText(getApplicationContext(), "Data is " + num, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Name", "onStart");
        num++;
        init();

    }

    public void init() {
        tv = (TextView) findViewById(R.id.tv_helloworld);
        tv.setText(num + "");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Name", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Name", "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Name", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Name", "onRestart");
    }
}
