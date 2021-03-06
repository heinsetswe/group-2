package com.napier.group2;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class gpTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    void printCountryTestNull()
    {
        app.displayCountry(null);
    }

    @Test
    void printCountryTestContainsNull()
    {
        ArrayList<Country> cty = new ArrayList<Country>();
        cty.add(null);
        app.displayCountry(cty);
        ArrayList<Country> ctycon = new ArrayList<Country>();
        ctycon.add(null);
        app.displayCountry(ctycon);
        ArrayList<Country> ctyreg = new ArrayList<Country>();
        ctyreg.add(null);
        app.displayCountry(ctyreg);
        ArrayList<Country> ctylimit = new ArrayList<Country>();
        ctylimit.add(null);
        app.displayCountry(ctylimit);
        ArrayList<Country> ctyconlimit = new ArrayList<Country>();
        ctyconlimit.add(null);
        app.displayCountry(ctyconlimit);
        ArrayList<Country> ctyreglimit = new ArrayList<Country>();
        ctyreglimit.add(null);
        app.displayCountry(ctyreglimit);
    }

    @Test
    void printCityTestNull()
    {
        app.displayCity(null);
    }

    @Test
    void printCityTestContainsNull()
    {
        ArrayList<City> city = new ArrayList<City>();
        city.add(null);
        app.displayCity(city);
        ArrayList<City> citycon = new ArrayList<City>();
        citycon.add(null);
        app.displayCity(citycon);
        ArrayList<City> citycountry = new ArrayList<City>();
        citycountry.add(null);
        app.displayCity(citycountry);
        ArrayList<City> citydistrict = new ArrayList<City>();
        citydistrict.add(null);
        app.displayCity(citydistrict);
        ArrayList<City> cityreg = new ArrayList<City>();
        cityreg.add(null);
        app.displayCity(cityreg);
        ArrayList<City> citywithlimit = new ArrayList<City>();
        citywithlimit.add(null);
        app.displayCity(citywithlimit);
        ArrayList<City> cityconwithlimit = new ArrayList<City>();
        cityconwithlimit.add(null);
        app.displayCity(cityconwithlimit);
        ArrayList<City> citycountrywithlimit = new ArrayList<City>();
        citycountrywithlimit.add(null);
        app.displayCity(citycountrywithlimit);
        ArrayList<City> citydistrictwithlimit = new ArrayList<City>();
        citydistrictwithlimit.add(null);
        app.displayCity(citydistrictwithlimit);
        ArrayList<City> cityregwithlimit = new ArrayList<City>();
        cityregwithlimit.add(null);
        app.displayCity(cityregwithlimit);
    }

    @Test
    void printCapitalCityTestNull()
    {
        app.displayCapitalCity(null);
    }

    @Test
    void printCapitalCityTestContainsNull()
    {
        ArrayList<City> capitalcty = new ArrayList<City>();
        capitalcty.add(null);
        app.displayCity(capitalcty);
        ArrayList<City> capitalcon = new ArrayList<City>();
        capitalcon.add(null);
        app.displayCity(capitalcon);
        ArrayList<City> capitalreg = new ArrayList<City>();
        capitalreg.add(null);
        app.displayCity(capitalreg);
        ArrayList<City> capitalwithlimit = new ArrayList<City>();
        capitalwithlimit.add(null);
        app.displayCity(capitalwithlimit);
        ArrayList<City> capitalconwithlimit = new ArrayList<City>();
        capitalconwithlimit.add(null);
        app.displayCity(capitalconwithlimit);
        ArrayList<City> capitalregwithlimit = new ArrayList<City>();
        capitalregwithlimit.add(null);
        app.displayCity(capitalregwithlimit);
    }

    @Test
    void printPopulationTestNull()
    {
        app.displaypplPopuCountry(null);
    }

    @Test
    void printPopulationTestContainsNull()
    {
        ArrayList<Population> pplPopuCountry = new ArrayList<Population>();
        pplPopuCountry.add(null);
        app.displaypplPopuCountry(pplPopuCountry);
        ArrayList<Population> pplPopuContinent = new ArrayList<Population>();
        pplPopuContinent.add(null);
        app.displaypplPopuCountry(pplPopuContinent);
        ArrayList<Population> pplPopuRegion = new ArrayList<Population>();
        pplPopuRegion.add(null);
        app.displaypplPopuCountry(pplPopuRegion);
    }

    @Test
    void printCountryLanguageTestNull()
    {
        app.displayCountrylanguages(null);
    }

    @Test
    void printCountryLanguageTestContainsNull()
    {
        ArrayList<CountryLanguage> ctylang = new ArrayList<CountryLanguage>();
        ctylang.add(null);
        app.displayCountrylanguages(ctylang);
    }

}