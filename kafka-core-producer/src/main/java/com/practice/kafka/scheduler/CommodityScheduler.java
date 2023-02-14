package com.practice.kafka.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.practice.kafka.entity.Commodity;
import com.practice.kafka.producer.CommodityProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommodityScheduler {

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private CommodityProducer producer;

    @Scheduled(fixedRate = 5000)
    public void fetchCommodities() {
        var commodities = restTemplate.exchange("http://localhost:8080/api/v1/commodity/all", HttpMethod.GET, null
                , new ParameterizedTypeReference<List<Commodity>>() {}).getBody();

        commodities.forEach(t -> {
            try {
                producer.send(t);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
