package com.practice.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaKeyProducer {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaKeyProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String key, String value){
        kafkaTemplate.send("t-multi-partitions", key, value);
    }
}
