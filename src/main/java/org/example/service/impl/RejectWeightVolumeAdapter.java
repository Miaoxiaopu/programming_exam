package org.example.service.impl;

import org.example.entity.Parcel;
import org.example.service.WeightVolumeAdapter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RejectWeightVolumeAdapter implements WeightVolumeAdapter, Ordered {
    private static BigDecimal LIMIT = new BigDecimal("50");

    @Override
    public boolean support(Parcel parcel) {
        BigDecimal weight = parcel.getWeight();
        return weight.compareTo(LIMIT) > 0;
    }

    @Override
    public BigDecimal calculateCost(Parcel parcel) {
        throw new RuntimeException("parcel's weight exceeds 50kg,reject this parcel!");
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
