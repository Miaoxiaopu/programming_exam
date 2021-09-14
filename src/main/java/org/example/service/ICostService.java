package org.example.service;

import org.example.entity.Parcel;

import java.math.BigDecimal;

public interface ICostService {
    /**
     * according to the entered params to calculate the cost
     * @param parcel
     * @return
     */
    BigDecimal calculateCost(Parcel parcel);
}
