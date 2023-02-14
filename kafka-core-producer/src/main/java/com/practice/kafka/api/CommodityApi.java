package com.practice.kafka.api;

import com.practice.kafka.Service.CommodityService;
import com.practice.kafka.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/commodity")
public class CommodityApi {

    @Autowired
    private CommodityService commodityService;

    @GetMapping(value = "/all")
    public List<Commodity> generateAllCommodities() {
        return commodityService.createDummyCommodities();
    }
}
