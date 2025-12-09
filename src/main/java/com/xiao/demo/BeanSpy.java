package com.xiao.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.beans.factory.config.BeanDefinition;

@Configuration
public class BeanSpy {

    @Bean
CommandLineRunner showBeans(ConfigurableApplicationContext ctx) {
    return args -> {
        BeanDefinition bd = ctx.getBeanFactory().getBeanDefinition("demoApplication");
        System.out.println(">>> CREATED BY: " + bd.getResourceDescription());
        System.out.println(">>> SCOPE      : " + bd.getScope());
        System.out.println(">>> CLASS      : " + ctx.getBean("demoApplication").getClass().getName());
    };
}
@Bean
CommandLineRunner timeStamp() {
    return args -> System.out.println(">>> JVM TIME WHEN BEAN READY: " + System.currentTimeMillis());
}
@Bean
CommandLineRunner howCreated(ConfigurableApplicationContext ctx) {
    return args -> {
        String[] sources = ctx.getEnvironment().getProperty("spring.main.sources", "").split(",");
        System.out.println(">>> PRIMARY SOURCE: " + ctx.getEnvironment().getProperty("spring.main.sources", "<default>"));
    };
}
}
