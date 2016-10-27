package ly.generalassemb.drewmahrt.searchviewdemo;

/**
 * Created by drewmahrt on 10/26/16.
 */

public class Person {
    private String mName;
    private int mAge;

    public Person(String name, int age) {
        mName = name;
        mAge = age;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }
}
