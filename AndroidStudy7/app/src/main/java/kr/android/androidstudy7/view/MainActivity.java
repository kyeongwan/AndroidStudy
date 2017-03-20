package kr.android.androidstudy7.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.android.androidstudy7.R;
import kr.android.androidstudy7.adapter.UserListAdapter;
import kr.android.androidstudy7.model.UserModel;
import kr.android.androidstudy7.network.UserService;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    OkHttpClient okHttpClient;
    Retrofit retrofit;
    UserService service;
    UserListAdapter listAdapter;

    @Bind(R.id.list) ListView listView;     // 버터나이프 바인딩

    @OnClick(R.id.button)                   // 버터나이프 클릭이벤트
    void createUser() {

        service = retrofit.create(UserService.class);       // 인터페이스를 구현

        service.createUser(new UserModel("aaa", "bbb")).enqueue(new Callback<UserModel>() {      // 구현체를 이용해서 새로운 HTTP통신을 시작. enqueue에 콜백을 넣어줌
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                int statusCode = response.code();
                UserModel model = response.body();
                Log.e("list", "status" + statusCode);

                Log.e("list", statusCode + " / " + model.toString());
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Log.e("error", t.toString());
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);                 // 버터나이프에 현재 뷰 바인드
        init();
        aboutRetrofit();
    }

    private void aboutRetrofit() {


        retrofit = new Retrofit.Builder()                               // 레트로핏 빌더로 시작
                .client(okHttpClient)                                   // 클라이언트에 okHTTP 붙이기
                .baseUrl("http://150.95.135.222:1337")                  // baseURL 설정
                .addConverterFactory(GsonConverterFactory.create())     // 컨버터 설정 ( json 직렬화 / 역직렬화 GSON 라이브러리 )
                .build();                                               // 최종완성

        service = retrofit.create(UserService.class);


        Call<List<UserModel>> userListCall = service.getUserList();
        userListCall.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                int statusCode = response.code();
                List<UserModel> list = response.body();
                Log.e("list", "status" + statusCode);
                Log.e("list", statusCode + " / " + list.toString());
                listAdapter.setList(list);
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                Log.e("error", t.toString());
            }
        });
    }

    private void init() {
        listAdapter = new UserListAdapter(getApplicationContext());
        listView.setAdapter(listAdapter);
        okHttpClient = new OkHttpClient();
    }
}
