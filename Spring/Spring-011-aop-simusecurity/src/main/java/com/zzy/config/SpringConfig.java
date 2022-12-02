package com.zzy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // 配置类
@ComponentScan({"com.zzy.service", "com.zzy.aspect"}) // 组件扫描
@EnableAspectJAutoProxy // 启动 AspectJ 自动代理
public class SpringConfig {
}
