package kr.android.androidstudy7.model;

/**
 * Created by lk on 2017. 3. 17..
 */
public class UserModel {
    String name;
    String pw;
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserModel(String name, String pw) {
        this.name = name;
        this.pw = pw;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", pw='" + pw + '\'' +
                ", id=" + id +
                '}';
    }
}
