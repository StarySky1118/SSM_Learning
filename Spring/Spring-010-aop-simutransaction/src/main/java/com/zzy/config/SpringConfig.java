package com.zzy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Spring 配置类
 */
@Configuration // 配置类
@ComponentScan({"com.zzy.service"}) // 开启组件扫描
@EnableAspectJAutoProxy // 启用 AspectJ 自动代理
public class SpringConfig {
}
