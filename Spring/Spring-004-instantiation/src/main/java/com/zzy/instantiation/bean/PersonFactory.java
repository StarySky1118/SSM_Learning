package com.zzy.instantiation.bean;

import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;

public class PersonFactory implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }
}
