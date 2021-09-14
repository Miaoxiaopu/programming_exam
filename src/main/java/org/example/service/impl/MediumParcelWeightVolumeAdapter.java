package org.example.service.impl;

import org.example.entity.Parcel;
import org.example.service.WeightVolumeAdapter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MediumParcelWeightVolumeAdapter implements WeightVolumeAdapter, Ordered {
    private static BigDecimal LIMIT_VOLUME = new BigDecimal("1500");

    @Override
    public boolean support(Parcel parcel) {
        return parcel.getVolume().compareTo(LIMIT_VOLUME) < 0;
    }

    @Override
    public BigDecimal calculateCost(Parcel parcel) {
        return new BigDecimal("0.04").multiply(parcel.getVolume());
    }

    @Override
    public int getOrder() {
        return 4;
    }
}
