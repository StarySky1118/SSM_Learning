package com.zzy.introduction.spring;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
    @Test
    public void testLog() {
        Logger logger = LoggerFactory.getLogger(SpringTest.class);
        logger.info("我是一个一个日志信息啊啊啊");
        logger.error("我是一个一个错误信息啊啊啊");
    }
}
