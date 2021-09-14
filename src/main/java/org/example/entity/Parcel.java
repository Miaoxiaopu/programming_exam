package org.example.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Parcel implements Serializable {
    private static final long serialVersionUID = 1L;
    private BigDecimal weight;
    private BigDecimal height;
    private BigDecimal width;
    private BigDecimal length;

    public Parcel() {
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getVolume() {
        return height.multiply(weight).multiply(length);
    }
}
