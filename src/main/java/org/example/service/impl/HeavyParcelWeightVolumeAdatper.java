package org.example.service.impl;

import org.example.entity.Parcel;
import org.example.service.WeightVolumeAdapter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class HeavyParcelWeightVolumeAdatper implements WeightVolumeAdapter, Ordered {
    private static BigDecimal LIMIT = new BigDecimal("10");

    @Override
    public boolean support(Parcel parcel) {
        BigDecimal weight = parcel.getWeight();
        return weight.compareTo(LIMIT) > 0;
    }

    @Override
    public BigDecimal calculateCost(Parcel parcel) {
        // assert weight not null
        BigDecimal weight = parcel.getWeight();
        return new BigDecimal("20").multiply(weight);
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
