package com.zzy.instantiation.bean;

import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFactory implements FactoryBean<Date> {
    private String dateStr;

    public DateFactory() {
    }

    public DateFactory(String dateStr) {
        this.dateStr = dateStr;
    }

    @Override
    public Date getObject() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(dateStr);
        return date;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
