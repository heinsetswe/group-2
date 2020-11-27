package com.napier.group2;

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
    private Float Percentage;
    public Float getPercentage() { return Percentage; }
    public void setPercentage(Float attribute) { this.Percentage = attribute; }

}
