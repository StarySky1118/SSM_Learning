package com.zzy.instantiation.bean;

import java.util.Date;

public class Person {
    private Date birth;

    public Person() {
    }

    public Person(Date birth) {
        this.birth = birth;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "birth=" + birth +
                '}';
    }
}
