package org.example.controller;


import org.example.entity.Parcel;
import org.example.service.ICostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cost")
public class CostController {
    private ICostService costService;

    @Autowired
    public CostController(ICostService costService) {
        this.costService = costService;
    }

    @RequestMapping("/calc")
    public Map<String, Object> calculateCost(@RequestBody Parcel parcel) {
        BigDecimal cost = costService.calculateCost(parcel);
        return new HashMap<String, Object>() {{
            put("cost", cost);
        }};
    }
}
