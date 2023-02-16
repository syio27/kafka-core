package com.practice.kafka.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class CacheConfig {

    @Bean(name = "cachePurchaseRequest")
    public Cache<Integer, Boolean> cachePurchaseRequest() {
        //cache valid for 2 mins and max size of records 1000
        return Caffeine.newBuilder().expireAfterWrite(Duration.ofMinutes(2)).maximumSize(1000).build();
    }
}
