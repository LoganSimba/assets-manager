package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.time.LocalDate.now;

public class Vehicle extends Asset {
    private String MakeModel;
    private int year;
    private int odometer;


    public Vehicle(String description, String dateAcquired, BigDecimal originalCost,
                   String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        MakeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return MakeModel;
    }

    public void setMakeModel(String makeModel) {
        MakeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }


    public BigDecimal getValue() {
        //get the difference between current year and the year of the car
        int carAge = LocalDate.now().getYear() - year;
        BigDecimal cost = getOriginalCost();//get the original cost
        BigDecimal percentCalculation = null;

        if (carAge <= 3) {//if the car age is > 3, perform calculations with big decimal to calculate -3%
             percentCalculation = new BigDecimal("0.03").multiply(BigDecimal.valueOf(carAge));
            return cost.multiply(BigDecimal.ONE.subtract(percentCalculation));
        } else if (carAge >= 4 && carAge <= 6) {//if the car age is > 3, perform calculations with big decimal to calculate -6%
            percentCalculation = new BigDecimal("0.06").multiply(BigDecimal.valueOf(carAge));
            return cost.multiply(BigDecimal.ONE.subtract(percentCalculation));

        } else if (carAge >= 7 && carAge <= 10) {//if the car age is > 3, perform calculations with big decimal to calculate 10%
            percentCalculation = new BigDecimal("0.08").multiply(BigDecimal.valueOf(carAge));
            return cost.multiply(BigDecimal.ONE.subtract(percentCalculation));
        }
        if (carAge >= 10) {// perfomr calculations if car age greater than 10! will make this better!!
            percentCalculation = new BigDecimal("0.10").multiply(BigDecimal.valueOf(carAge));
            return cost.multiply(BigDecimal.ONE.subtract(percentCalculation));
        }
        return cost;
    }
}

