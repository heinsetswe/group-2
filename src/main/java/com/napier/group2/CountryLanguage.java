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
    private BigInteger totalPopulation;
    public BigInteger gettotalPopulation(){
        return totalPopulation;
    }
    public void setPopulation(BigInteger attribute){
        this.totalPopulation = attribute;
    }

    public static Comparator<CountryLanguage> compareLanguage = new Comparator<CountryLanguage>() {
        @Override
        public int compare(CountryLanguage o1, CountryLanguage o2) {
            BigDecimal popu = o1.getPopulation();
            BigDecimal popu1 = o2.getPopulation();
            int compare = popu1.compareTo(popu);
            return compare;
        }
    };
}
