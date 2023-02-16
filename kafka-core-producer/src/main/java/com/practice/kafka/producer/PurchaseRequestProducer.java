package com.practice.kafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.kafka.entity.PurchaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PurchaseRequestProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private ObjectMapper mapper;

    public void send(PurchaseRequest purchaseRequest) throws JsonProcessingException {
        var json = mapper.writeValueAsString(purchaseRequest);
        kafkaTemplate.send("t-purchase-request", purchaseRequest.getPrNumber(), json);
    }
}
