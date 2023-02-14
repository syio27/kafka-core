package com.practice.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

//@Service
public class FixedRate2Producer {

    private static final Logger LOG = LoggerFactory.getLogger(FixedRate2Producer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private AtomicInteger counter = new AtomicInteger();

//    @Scheduled(fixedRate = 1000)
    public void send(){
        var i = counter.incrementAndGet();
        LOG.info("FIXEDRATE-2: current counter is - {}", i);
        kafkaTemplate.send("t-fixedrate-2", "FixedRate-2 + " + i);
    }
}
