package com.practice.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.kafka.entity.CarLocation;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CarLocationConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(CarLocationConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "t-location", groupId = "cg-all-location")
    public void consumeAll(String message) throws JsonProcessingException {
        var carLocation = objectMapper.readValue(message, CarLocation.class);
        LOG.info("listens all: {}", carLocation);
    }

    @KafkaListener(topics = "t-location", groupId = "cg-far-location", containerFactory = "farLocationContainerFactory")
    public void consumeFar(String message) throws JsonProcessingException {
        var carLocation = objectMapper.readValue(message, CarLocation.class);
        LOG.info("listens only far: {}", carLocation);
    }
}
