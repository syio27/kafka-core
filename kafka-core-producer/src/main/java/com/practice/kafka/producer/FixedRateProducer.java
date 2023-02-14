package com.practice.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

//@Service
public class FixedRateProducer {

    private static final Logger LOG = LoggerFactory.getLogger(FixedRateProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private AtomicInteger counter = new AtomicInteger();

    //@Scheduled(fixedRate = 1000)
    public void send(){
        var i = counter.incrementAndGet();
        LOG.info("FIXEDRATE: current counter is - {}", i);
        kafkaTemplate.send("t-fixedrate", "FixedRate + " + i);
    }
}
