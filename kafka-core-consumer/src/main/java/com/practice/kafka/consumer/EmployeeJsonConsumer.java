package com.practice.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.kafka.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeJsonConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeJsonConsumer.class);

    @KafkaListener(topics = "t-employee")
    public void consume(String message) throws JsonProcessingException {
        var emp = objectMapper.readValue(message, Employee.class);
        LOG.info("Employee id: {}, {}", emp.getId(), emp);
    }
}
