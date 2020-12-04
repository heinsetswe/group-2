package com.napier.group2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;

public class CountryLanguage {
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
     * Language
     */
    private String Language;
    public String getLanguage() { return Language; }
    public void setLanguage(String attribute) { this.Language = attribute; }

    /**
     * IsOfficial of language
     */
    private String IsOfficial;
    public String getIsOfficial() { return IsOfficial; }
    public void setIsOfficial(String attribute) { this.IsOfficial = attribute; }

    /**
     * Percentage of people
     */
    private BigDecimal Percentage;
    public BigDecimal getPercentage() { return Percentage; }
    public void setPercentage(BigDecimal attribute) { this.Percentage = attribute; }

    /**
     * Population of country
     */
    private BigDecimal Population;
    public BigDecimal getPopulation(){
        return Population;
    }
    public void setPopulation(BigDecimal attribute){
        this.Population = attribute;
    }

    /**
     * Population of country
     */
    private BigInteger totalPopu;
    public BigInteger getTotalPopu(){
        return totalPopu;
    }
    public void setTotalPopu(BigInteger attribute){
        this.totalPopu = attribute;
    }

}
