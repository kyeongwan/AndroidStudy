package kr.almostthere.androidstudy5;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    //http://gun0912.tistory.com/17
    //이미지 라이브러리 비교

    /**
     *   이미지 라이브러리 : 피카소 , Glide
     *   네트워크 라이브러리 : okHTTP, Retrofit
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkHttpClient client = new OkHttpClient();
        String json = bowlingJson("Jesse", "Jake");


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String response = getREST("https://raw.github.com/square/okhttp/master/README.md");

                    Log.e("result", response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();


        /**
         * 권한 요청 부분
         */

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            // 이 권한을 필요한 이유를 설명해야하는가?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)) {
                // 다이어로그같은것을 띄워서 사용자에게 해당 권한이 필요한 이유에 대해 설명합니다
                // 해당 설명이 끝난뒤 requestPermissions()함수를 호출하여 권한허가를 요청해야 합니다
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        100);
                // 필요한 권한과 요청 코드를 넣어서 권한허가요청에 대한 결과를 받아야 합니다
            }
        }

    }


    private String getREST(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
    String json  = "{\"name\" : \"aaa\"," +
            " \"pw\" : \"bbb\"," +
            "}";

    String url = "http://150.95.135.222:1337/user";
    private String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    private String bowlingJson(String player1, String player2) {
        return "";
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 100:

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 권한 허가
                } else {
                    // 권한 거부
                }
                return;
        }
    }

    void run(String url) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String myResponse = response.body().string();

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // do something
                    }
                });

            }
        });
    }

    /**
     * 과제
     *
     * 서버 : nodejs  + sails 프레임워크
     *  http://sailsjs.com/
     *
     *  http://dic.daum.net/search.do?q=사과dic=eng
     *  형식으로 EditText 에 있는 단어 영어 뜻 가져오기.
     *  가져와서 리스트 뷰에 추가하기.
     *
     *  +
     *
     *  Picasso, Glide, Retrofit, okHttp 익혀보기
     *
     */

}


