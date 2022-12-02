package com.zzy.DI.bean;

import java.util.Map;

public class Person {
    private String name;
    private Map<String, String> phones;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhones(Map<String, String> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phones=" + phones +
                '}';
    }
}
