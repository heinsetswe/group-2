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
    private BigInteger City;
    public BigInteger getCity() { return City; }
    public void setCity(BigInteger attribute){
        this.City = attribute;
    }
}
