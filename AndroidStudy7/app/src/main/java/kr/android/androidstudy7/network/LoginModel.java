package kr.android.androidstudy7.network;

/**
 * Created by lk on 2017. 4. 7..
 */
public class LoginModel {

    String user_id;
    String password;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginModel(String user_id, String password) {

        this.user_id = user_id;
        this.password = password;
    }
}
