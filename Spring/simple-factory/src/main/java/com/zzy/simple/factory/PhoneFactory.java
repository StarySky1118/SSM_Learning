package com.zzy.simple.factory;

import com.zzy.simple.exception.NoSuchPhoneException;
import com.zzy.simple.product.IQOONeo3;
import com.zzy.simple.product.Phone;
import com.zzy.simple.product.VivoX90;

public class PhoneFactory {
    public static Phone getPhone(String name) {
        Phone phone = null;

        if ("IQOONeo3".equals(name)) {
            phone = new IQOONeo3();
        } else if ("VivoX90".equals(name)) {
            phone = new VivoX90();
        } else {
            throw new NoSuchPhoneException("没有这样的手机型号！");
        }

        return phone;
    }
}
