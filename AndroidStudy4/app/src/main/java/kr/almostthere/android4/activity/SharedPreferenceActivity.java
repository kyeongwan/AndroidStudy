package kr.almostthere.android4.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import kr.almostthere.android4.R;

public class SharedPreferenceActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedBundle){
        super.onCreate(savedBundle);
        setContentView(R.layout.nextlayout);


        SharedPreferences sharedPreference = getSharedPreferences("pref", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putInt("a", 0);
        editor.commit();

        sharedPreference.getInt("a", 100);

        // SharedPreferenceActivity 사용 예제
        // http://arabiannight.tistory.com/entry/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9CAndroid-SharedPreferences-%EC%82%AC%EC%9A%A9-%EC%98%88%EC%A0%9C


    }
}
