package com.napier.group2;

import java.text.DecimalFormat;

public class Country {
    /**
     * Country code
     */
    private String Code;
    public String getCode(){
        return Code;
    }
    public void setCode(String attribute){
        this.Code = attribute;
    }

    /**
     * Country name
     */
    private String Name;
    public String getName(){
        return Name;
    }
    public void setName(String attribute){
        this.Name = attribute;
    }

    /**
     * Continent of country
     */
    private String Continent;
    public String getContinent(){
        return Continent;
    }
    public void setContinent(String attribute){
        this.Continent = attribute;
    }

    /**
     * Region of country
     */
    private String Region;
    public String getRegion(){
        return Region;
    }
    public void setRegion(String attribute){
        this.Region = attribute;
    }

    /**
     * SurfaceArea of country
     */
    private Float SurfaceArea;
    public Float getSurfaceArea(){
        return SurfaceArea;
    }
    public void setSurfaceArea(Float attribute){
        this.SurfaceArea = attribute;
    }

    /**
     * Independent year
     */
    private int IndepYear;
    public int getIndepYear(){
        return IndepYear;
    }
    public void setIndepYear(int attribute){
        this.IndepYear = attribute;
    }

    /**
     * Population of country
     */
    private int Population;
    public int getPopulation(){
        return Population;
    }
    public void setPopulation(int attribute){
        this.Population = attribute;
    }

    /**
     * LifeExpectancy of country
     */
    private float LifeExpectancy;
    public float getLifeExpectancy(){
        return LifeExpectancy;
    }
    public void setLifeExpectancy(float attribute){
        this.LifeExpectancy = attribute;
    }

    /**
     * GNP of country
     */
    private float GNP;
    public float getGNP(){
        return GNP;
    }
    public void setGNP(float attribute){
        this.GNP = attribute;
    }

    /**
     * GNPOld of country
     */
    private float GNPOld;
    public float getGNPOld(){
        return GNPOld;
    }
    public void setGNPOld(float attribute){
        this.GNPOld = attribute;
    }

    /**
     * LocalName of country
     */
    private String LocalName;
    public String getLocalName(){
        return LocalName;
    }
    public void setLocalName(String attribute){
        this.LocalName = attribute;
    }

    /**
     * GovernmentForm of country
     */
    private int GovernmentForm;
    public int getGovernmentForm(){
        return GovernmentForm;
    }
    public void setGovernmentForm(int attribute){
        this.GovernmentForm = attribute;
    }

    /**
     * Head of State
     */
    private String HeadOfState;
    public String getHeadOfState(){
        return HeadOfState;
    }
    public void setHeadOfState(String attribute){
        this.HeadOfState = attribute;
    }

    /**
     * Capital of country
     */
    private int Capital;
    public int getCapital(){
        return Capital;
    }
    public void setCapital(int attribute){
        this.Capital = attribute;
    }

    /**
     * Country's code-2
     */
    private String Code2;
    public String getCode2(){
        return Code2;
    }
    public void setCode2(String attribute){
        this.Code2 = attribute;
    }
}