package com.zzy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.zzy.dao", "com.zzy.service"})
public class SpringConfig {
}
