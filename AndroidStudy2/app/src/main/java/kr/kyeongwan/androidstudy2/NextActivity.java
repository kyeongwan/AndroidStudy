package kr.kyeongwan.androidstudy2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lk on 2017. 2. 27..
 */

public class NextActivity extends AppCompatActivity {

    int num;
    TextView tv;
    Intent intent;

    @Override
    public void onCreate(Bundle d){
        super.onCreate(d);
        setContentView(R.layout.layout2);

        intent = getIntent();                        // getIntent() 호출될때 받았던 인덴트를 가져올 수 있음

        num = intent.getIntExtra("Data", -1);          // get Type Extra(key, defult value) 로 값을 가져올 수 있음.

        Log.e("Data", "Data is " + num);          // 로그캣에 찍히는 내용. name, msg 가 있는데 System.out.print() 도 로그캣에 찍힘.

        tv = (TextView) findViewById(R.id.textView);
        tv.setText(num + "");

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("Data", num);          // 다시 인덴트에 값을 할당
                setResult(RESULT_OK, intent);        // 액티비티가 종료되면서 다시 인덴트를 실어 보냄
                finish();                       // 종료
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
        num++;
        tv.setText(num + "");
    }
}
