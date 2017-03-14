package kr.almostthere.androidstudy6;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by lk on 2017. 3. 13..
 */

public class Activity extends AppCompatActivity implements View.OnClickListener{

    private Boolean isFragmentB = true;
    @Override
    public void onCreate(Bundle savedB){
        super.onCreate(savedB);
        setContentView(R.layout.main_test);

        FrameLayout layout = (FrameLayout) findViewById(R.id.frame);

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frame, new FragmentB());
        transaction.commit();

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (view.getId()){
            case R.id.button1:
                transaction.add(R.id.frame, new FragmentA());
                break;
            case R.id.button2:
                transaction.add(R.id.frame, new FragmentB());
                break;
            case R.id.button3:
                transaction.add(R.id.frame, new FragmentC());
                break;
            case R.id.button4:
                transaction.add(R.id.frame, new FragmentB());
                break;

        }
        transaction.commit();
    }
}
