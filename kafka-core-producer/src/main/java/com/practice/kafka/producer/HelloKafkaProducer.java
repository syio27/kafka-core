package com.practice.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//@Service
public class HelloKafkaProducer {
    @Autowired
    //handle publish to kafka server
    //<K,V> - key value
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendHello(String name){
        //takes as param Topic, and Message
        //without key, which means it is default
        kafkaTemplate.send("t-hello", "Hello, " + name);
    }
}
