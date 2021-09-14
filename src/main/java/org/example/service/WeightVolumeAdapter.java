package org.example.service;

import org.example.entity.Parcel;

import java.math.BigDecimal;

public interface WeightVolumeAdapter {
    /**
     * is matched a rule
     *
     * @param parcel
     * @return
     */
    boolean support(Parcel parcel);

    /**
     * when matched a rule, then calculate the cost
     * @param parcel
     * @return
     */
    BigDecimal calculateCost(Parcel parcel);
}
