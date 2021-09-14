package org.example.service.impl;

import org.example.entity.Parcel;
import org.example.service.ICostService;
import org.example.service.WeightVolumeAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CostServiceImpl implements ICostService {
    // rules collection
    List<WeightVolumeAdapter> weightVolumeAdapters;

    @Autowired
    public CostServiceImpl(List<WeightVolumeAdapter> weightVolumeAdapters) {
        this.weightVolumeAdapters = weightVolumeAdapters;
    }

    @Override
    public BigDecimal calculateCost(Parcel parcel) {
        for (WeightVolumeAdapter adapter : weightVolumeAdapters) {
            if (adapter.support(parcel)) {
                return adapter.calculateCost(parcel);
            }
        }
        throw new RuntimeException("no adaptable rule found, please input correct weight,height,width,length!");
    }
}
