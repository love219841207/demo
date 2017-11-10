package com.cookie.home.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations={"classpath:dubbo-spring.xml"})
public class DubboConfig {
}
