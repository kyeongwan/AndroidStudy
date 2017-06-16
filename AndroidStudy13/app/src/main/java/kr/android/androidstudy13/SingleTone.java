package kr.android.androidstudy13;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by lk on 2017. 4. 9..
 */

public class SingleTone {

    private OkHttpClient okHttpClient;

    private static SingleTone instance;

    public static SingleTone getInstance(){
        if(instance == null)
            instance = new SingleTone();
        return instance;
    }

    private SingleTone(){
        okHttpClient = new OkHttpClient();
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }
}
