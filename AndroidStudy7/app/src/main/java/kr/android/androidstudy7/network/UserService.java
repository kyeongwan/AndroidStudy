package kr.android.androidstudy7.network;

import java.util.List;

import kr.android.androidstudy7.model.UserModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {
  @GET("/user/{id}")          // @이노테이션으로 GET POST UPDATE DELETE 설정
  Call<UserModel> getUser(@Path("id") int id);      // @PATH 이노테이션으로 {} 에 있는 변수 치환

  @GET("/user/")
  Call<List<UserModel>> getUserList();      // 반환형은 Call<T>

  @POST("/user/")
  Call<UserModel> createUser(@Body UserModel user);   // @BODY 로 POST 할 데이터 설정


  @POST("/user/login/")
  Call<LoginModel> login(@Body LoginModel model);

}