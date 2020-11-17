package com.napier.group2;

import java.text.DecimalFormat;

public class City {
    /**
     * City ID
     */
    private int ID;
    public int getID(){
        return ID;
    }
    public void setID(int attribute){
        this.ID = attribute;
    }

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
     * Country code
     */
    private String CountryCode;
    public String getCountryCode(){
        return CountryCode;
    }
    public void setCountryCode(String attribute){
        this.CountryCode = attribute;
    }

    /**
     * District of country
     */
    private String District;
    public String getDistrict(){
        return District;
    }
    public void setDistrict(String attribute){
        this.District = attribute;
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
