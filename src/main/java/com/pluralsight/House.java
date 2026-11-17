package com.pluralsight;

import java.math.BigDecimal;

public class House extends Asset {

    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    //constructor with wuper class attributes
    public House(String description, String dateAcquired,
                 BigDecimal originalCost, String address, int condition,
                 int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }


    @Override
    public BigDecimal getValue() {
        //store the int as a bigDecimal to perform calculations
        BigDecimal squareFoot = BigDecimal.valueOf(getSquareFoot());
        //BigDecimal to add the 25 cents for each of the lot
        BigDecimal lotValue = new BigDecimal("0.25").multiply(BigDecimal.valueOf(getLotSize()));
        //switch statements and make calculations depending on the which condtion the house is in
        switch (condition) {
            case 1:
                return BigDecimal.valueOf(180).multiply(squareFoot).add(lotValue);
            case 2:
                return BigDecimal.valueOf(130).multiply(squareFoot).add(lotValue);
            case 3:
                return BigDecimal.valueOf(90).multiply(squareFoot).add(lotValue);
            case 4:
                return BigDecimal.valueOf(80).multiply(squareFoot).add(lotValue);
            default:
                return BigDecimal.ZERO;
        }
    }

}
