package com.practice.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RebalanceProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private AtomicInteger counter = new AtomicInteger();

    @Scheduled(fixedRate = 1000)
    public void send(){
        kafkaTemplate.send("t-rebalance", "Counter " + counter.incrementAndGet());
    }
}
