package org.example.service.impl;

import org.example.entity.Parcel;
import org.example.service.WeightVolumeAdapter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LargeParcelWeightVolumeAdatper implements WeightVolumeAdapter, Ordered {
    @Override
    public boolean support(Parcel parcel) {
        return true;
    }

    @Override
    public BigDecimal calculateCost(Parcel parcel) {
        return new BigDecimal("0.05").multiply(parcel.getVolume());
    }

    @Override
    public int getOrder() {
        return 5;
    }
}
