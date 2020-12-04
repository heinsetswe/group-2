package com.napier.group2;

import java.math.BigInteger;

public class Population {

    /**
     * City name
     */
    private String Name;
    public String getName(){
        return Name;
    }
    public void setName(String attribute){
        this.Name = attribute;
    }

    /**
     * Total
     */
    private BigInteger Total;
    public BigInteger getTotal() { return Total; }
    public void setTotal(BigInteger attribute){
        this.Total = attribute;
    }

    /**
     * City
     */
    private BigInteger CityPopu;
    public BigInteger getCityPopu() { return CityPopu; }
    public void setCityPopu(BigInteger attribute){
        this.CityPopu = attribute;
    }

    /**
     * Population of city
     */
    private int Population;
    public int getPopulation(){
        return Population;
    }
    public void setPopulation(int attribute){
        this.Population = attribute;
    }
}
