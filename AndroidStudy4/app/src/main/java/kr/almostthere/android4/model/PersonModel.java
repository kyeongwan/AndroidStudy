package kr.almostthere.android4.model;

/**
 * Created by lk on 2017. 3. 7..
 */

public class PersonModel {

    int res;
    String name;
    String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRes() {

        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public PersonModel(int res, String name, String phone) {

        this.res = res;
        this.name = name;
        this.phone = phone;
    }
}
