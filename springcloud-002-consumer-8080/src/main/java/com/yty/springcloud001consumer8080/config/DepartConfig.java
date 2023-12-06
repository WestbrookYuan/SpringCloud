package com.yty.springcloud001consumer8080.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Configuration
public class DepartConfig {
    @LoadBalanced // 以负载均衡的方式调用
    @Bean
    public RestTemplate restTemplate(){return new RestTemplate();}
}
