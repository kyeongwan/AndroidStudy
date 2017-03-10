package kr.almostthere.android4.model;

import io.realm.RealmObject;

public class UserModel extends RealmObject {

    private String          name;
    private int             age;

    public String getName() { return name; }
    public void   setName(String name) { this.name = name; }
    public int    getAge() { return age; }
    public void   setAge(int age) { this.age = age; }

}