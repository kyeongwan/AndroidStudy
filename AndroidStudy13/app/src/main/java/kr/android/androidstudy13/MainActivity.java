package kr.android.androidstudy13;

import android.app.Application;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SingleTone.getInstance().getOkHttpClient();

        TextView tv;
        App app = (App) getApplicationContext();

        app.getOkHttpClient();
//
//        ListView listView = null;
//        ListAdapter adapter = new ();
//        listView.setAdapter(adapter);
    }
}
