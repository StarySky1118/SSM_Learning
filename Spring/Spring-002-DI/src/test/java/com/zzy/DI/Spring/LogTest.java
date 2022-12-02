package com.zzy.DI.Spring;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
    @Test
    public void testLog() {
        Logger logger = LoggerFactory.getLogger(LogTest.class);

        logger.info("输出 info 信息");
    }
}
