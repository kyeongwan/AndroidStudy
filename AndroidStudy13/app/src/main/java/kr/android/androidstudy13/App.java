package kr.android.androidstudy13;

import android.app.Application;

import okhttp3.OkHttpClient;

/**
 * Created by lk on 2017. 4. 9..
 */

public class App extends Application {

    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public OkHttpClient okHttpClient;

    public App(){
        okHttpClient = new OkHttpClient();
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }
}
