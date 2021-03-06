package com.napier.group2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class App
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(3000);
                // for codecov error
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    //**All the countries in the world organised by largest population to smallest.
    public ArrayList<Country> getCountrybyPopu()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country order by Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<Country> ctylist = new ArrayList<Country>();
            while (rset.next()) {
                Country cty = new Country();
                cty.setCode(rset.getString("Code"));
                cty.setName(rset.getString("Name"));
                cty.setContinent(rset.getString("Continent"));
                cty.setRegion(rset.getString("Region"));
                cty.setPopulation(rset.getInt("Population"));
                cty.setCapital(rset.getInt("Capital"));
                ctylist.add(cty);
            }
            return ctylist;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //**All the countries in a continent organised by largest population to smallest.
    public ArrayList<Country> getCountrycon()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Continent = 'Asia' " + "order by Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<Country> ctylistcon = new ArrayList<Country>();
            while (rset.next()) {
                Country cty = new Country();
                cty.setCode(rset.getString("Code"));
                cty.setName(rset.getString("Name"));
                cty.setContinent(rset.getString("Continent"));
                cty.setRegion(rset.getString("Region"));
                cty.setPopulation(rset.getInt("Population"));
                cty.setCapital(rset.getInt("Capital"));
                ctylistcon.add(cty);
            }
            return ctylistcon;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //**All the countries in a region organised by largest population to smallest.**//
    public ArrayList<Country> getCountryreg()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Region = 'Central Africa' " + "order by Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<Country> ctylistreg = new ArrayList<Country>();
            while (rset.next()) {
                Country cty = new Country();
                cty.setCode(rset.getString("Code"));
                cty.setName(rset.getString("Name"));
                cty.setContinent(rset.getString("Continent"));
                cty.setRegion(rset.getString("Region"));
                cty.setPopulation(rset.getInt("Population"));
                cty.setCapital(rset.getInt("Capital"));
                ctylistreg.add(cty);
            }
            return ctylistreg;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //***Display Country
    public void displayCountry(ArrayList<Country> countrylist)
    {
        if (countrylist == null)
        {
            System.out.println("No Result");
            return;
        }
        System.out.println("All the countries in the world organised by largest population to smallest.");
        System.out.println(String.format("%-5s %-30s %-15s %-30s %-25s %-10s","Code", "Name", "Continent", "Region", "Population", "Capital"));
        System.out.println(String.format("%-5s %-30s %-15s %-30s %-25s %-10s","~~~~", "~~~~", "~~~~~~~~~", "~~~~~~", "~~~~~~~~~~", "~~~~~~~"));
        for ( Country coty : countrylist)
        {
            if (coty == null)
                continue;
            String Code = coty.getCode();
            String Name = coty.getName();
            String Continent = coty.getContinent();
            String Region = coty.getRegion();
            int Population = coty.getPopulation();
            int Capital = coty.getCapital();
            System.out.println(String.format("%-5s %-30s %-15s %-30s %-25s %-10s", Code, Name, Continent, Region, Population, Capital));
        }
        System.out.println("=========================================================================================================");
        System.out.println("\n");
    }

    //**The top N populated countries in the world where N is provided by the user.
    public ArrayList<Country> getCountrywithlimit()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country order by Population DESC limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<Country> ctylist = new ArrayList<Country>();
            while (rset.next()) {
                Country cty = new Country();
                cty.setCode(rset.getString("Code"));
                cty.setName(rset.getString("Name"));
                cty.setContinent(rset.getString("Continent"));
                cty.setRegion(rset.getString("Region"));
                cty.setPopulation(rset.getInt("Population"));
                cty.setCapital(rset.getInt("Capital"));
                ctylist.add(cty);
            }
            return ctylist;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //**The top N populated countries in a continent where N is provided by the user.
    public ArrayList<Country> getCountryconwithlimit()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Continent = 'Asia' " + "order by Population DESC limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<Country> ctylistcon = new ArrayList<Country>();
            while (rset.next()) {
                Country cty = new Country();
                cty.setCode(rset.getString("Code"));
                cty.setName(rset.getString("Name"));
                cty.setContinent(rset.getString("Continent"));
                cty.setRegion(rset.getString("Region"));
                cty.setPopulation(rset.getInt("Population"));
                cty.setCapital(rset.getInt("Capital"));
                ctylistcon.add(cty);
            }
            return ctylistcon;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //The top N populated countries in a region where N is provided by the user.//
    public ArrayList<Country> getCountryregwithlimit()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Region = 'Central Africa' " + "order by Population DESC limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<Country> ctylistreg = new ArrayList<Country>();
            while (rset.next()) {
                Country cty = new Country();
                cty.setCode(rset.getString("Code"));
                cty.setName(rset.getString("Name"));
                cty.setContinent(rset.getString("Continent"));
                cty.setRegion(rset.getString("Region"));
                cty.setPopulation(rset.getInt("Population"));
                cty.setCapital(rset.getInt("Capital"));
                ctylistreg.add(cty);
            }
            return ctylistreg;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    ////****CITIES****////
    ///////////////////////
    //**All the cities in a district organised by largest population to smallest.
    public ArrayList<City> getdistrict()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Countrycode, District, Population FROM city WHERE District = 'Rio de Janeiro' " + "order by Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<City> citydistrict = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.setName(rset.getString("Name"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getInt("Population"));
                citydistrict.add(city);
            }
            return citydistrict;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //** All the cities in a district organised by largest population to smallest.
    ///////////////////////
//**All the cities in a country organised by largest population to smallest.
    public ArrayList<City> getCitycountry()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * " + "FROM city, country WHERE city.Countrycode = country.Code " + "AND country.name = 'United States' " + "order by city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<City> countrylistcountry = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.setName(rset.getString("Name"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getInt("Population"));
                countrylistcountry.add(city);
            }
            return countrylistcountry;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //////////////////////////////////////////////////////////
    //**All the cities in the world organised by largest population to smallest.
    public ArrayList<City> getCity()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Countrycode, District, Population FROM city order by Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<City> citylist = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.setName(rset.getString("Name"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getInt("Population"));
                citylist.add(city);
            }
            return citylist;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //** All the cities in a continent organised by largest population to smallest.
    public ArrayList<City> getCitycon()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * " + "FROM city, country WHERE city.Countrycode = country.Code " + "AND country.Continent = 'Asia' " + "order by city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<City> citylistcon = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.setName(rset.getString("Name"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getInt("Population"));
                citylistcon.add(city);
            }
            return citylistcon;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //** All the cities in a region organised by largest population to smallest.
    public ArrayList<City> getCityreg()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * " + "FROM city, country WHERE city.Countrycode = country.Code " + "AND country.Region = 'Central America' " + "order by city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<City> citylistreg = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.setName(rset.getString("Name"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getInt("Population"));
                citylistreg.add(city);
            }
            return citylistreg;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public void displayCity(ArrayList<City> citylist)
    {
        if (citylist == null)
        {
            System.out.println("No Result");
            return;
        }
        System.out.println("CITIES");
        System.out.println(String.format("%-45s %-10s %-25s %-25s ","Name", "Country", "District", "Population"));
        System.out.println(String.format("%-45s %-10s %-25s %-25s ","~~~~", "~~~~~~~", "~~~~~~~~", "~~~~~~~~~~"));
        for ( City city : citylist)
        {
            if (city == null)
                continue;
            String Name = city.getName();
            String CountryCode = city.getCountryCode();
            String District = city.getDistrict();
            int Population = city.getPopulation();
            System.out.println(String.format("%-45s %-10s %-25s %-25s", Name, CountryCode, District, Population));
        }
        System.out.println("===================================================================================================");
        System.out.println("\n");
    }

    //****TOP CITIES****//
    //The top N populated cities in the world where N is provided by the user.
    public ArrayList<City> getCitywithlimit()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Countrycode, District, Population FROM city order by Population DESC limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<City> citylist = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.setName(rset.getString("Name"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getInt("Population"));
                citylist.add(city);
            }
            return citylist;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //** The top N populated cities in a continent where N is provided by the user.
    public ArrayList<City> getCityconwithlimit()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * " + "FROM city, country WHERE city.Countrycode = country.Code " + "AND country.Continent = 'Asia' " + "order by city.Population DESC limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<City> citylistcon = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.setName(rset.getString("Name"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getInt("Population"));
                citylistcon.add(city);
            }
            return citylistcon;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //The top N populated cities in a district where N is provided by the user.
    public ArrayList<City> getdistrictwithlimit()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Countrycode, District, Population FROM city WHERE District = 'Rio de Janeiro' " + "order by Population DESC limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<City> citydistrict = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.setName(rset.getString("Name"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getInt("Population"));
                citydistrict.add(city);
            }
            return citydistrict;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }


    //**The top N populated cities in a country where N is provided by the user.
    public ArrayList<City> getCitycountrywithlimit()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * " + "FROM city, country WHERE city.Countrycode = country.Code " + "AND country.name = 'United States' " + "order by city.Population DESC limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<City> countrylistcountry = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.setName(rset.getString("Name"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getInt("Population"));
                countrylistcountry.add(city);
            }
            return countrylistcountry;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //**the number of people who speak different languages from greatest number to smallest
    // , including the percentage of the world population:
    public ArrayList<City> getCityregwithlimit()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * " + "FROM city, country WHERE city.Countrycode = country.Code " + "AND country.Region = 'Central America' " + "order by city.Population DESC limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<City> citylistreg = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.setName(rset.getString("Name"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getInt("Population"));
                citylistreg.add(city);
            }
            return citylistreg;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //////**CAPITAL CITIES***//////
    ///All the capital cities in the world organised by largest population to smallest.
    public ArrayList<City> getCapitalbyPopu()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * " + "FROM city, country WHERE city.ID = country.Capital " +  "order by city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<City> capitalctylist = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.setName(rset.getString("Name"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getInt("Population"));
                capitalctylist.add(city);
            }
            return capitalctylist;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //All the capital cities in a continent organised by largest population to smallest.
    public ArrayList<City> getCapitalcon()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * " + "FROM city, country WHERE city.ID = country.Capital " + "AND country.Continent = 'Europe' " + "order by city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<City> capitalctycon = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.setName(rset.getString("Name"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getInt("Population"));
                capitalctycon.add(city);
            }
            return capitalctycon;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //All the capital cities in a region organised by largest to smallest.
    public ArrayList<City> getCapitalreg()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * " + "FROM city, country WHERE city.ID = country.Capital " + "AND country.Region = 'Southeast Asia' " + "order by city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<City> capitalctyreg = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.setName(rset.getString("Name"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getInt("Population"));
                capitalctyreg.add(city);
            }
            return capitalctyreg;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //**The top N populated capital cities in the world where N is provided by the user.
    public ArrayList<City> getCapitalwithlimit()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * " + "FROM city, country WHERE city.ID = country.Capital " +  "order by city.Population DESC limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<City> capitalctylist = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.setName(rset.getString("Name"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getInt("Population"));
                capitalctylist.add(city);
            }
            return capitalctylist;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //**The top N populated capital cities in a continent where N is provided by the user.
    public ArrayList<City> getCapitalconwithlimit()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * " + "FROM city, country WHERE city.ID = country.Capital " + "AND country.Continent = 'Europe' " + "order by city.Population DESC limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<City> capitalctycon = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.setName(rset.getString("Name"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getInt("Population"));
                capitalctycon.add(city);
            }
            return capitalctycon;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //**The top N populated capital cities in a region where N is provided by the user.
    public ArrayList<City> getCapitalregwithlimit()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * " + "FROM city, country WHERE city.ID = country.Capital " + "AND country.Region = 'Southeast Asia' " + "order by city.Population DESC limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<City> capitalctyreg = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.setName(rset.getString("Name"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setDistrict(rset.getString("District"));
                city.setPopulation(rset.getInt("Population"));
                capitalctyreg.add(city);
            }
            return capitalctyreg;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //**Display Capital Cities
    public void displayCapitalCity(ArrayList<City> capitalcty)
    {
        if (capitalcty == null)
        {
            System.out.println("No Result");
            return;
        }
        System.out.println("CAPITAL CITIES");
        System.out.println(String.format("%-45s %-25s %-25s ","Name", "Country", "Population"));
        System.out.println(String.format("%-45s %-25s %-25s ","~~~~", "~~~~~~~", "~~~~~~~~~~"));
        for ( City city : capitalcty)
        {
            if (city == null)
                continue;
            String Name = city.getName();
            String CountryCode = city.getCountryCode();
            String District = city.getDistrict();
            int Population = city.getPopulation();
            System.out.println(String.format("%-45s %-25s %-25s", Name, CountryCode, Population));
        }
        System.out.println("===================================================================================================");
        System.out.println("\n");
    }

    //**The population of the world.
    public String worldpopulation()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT sum(Population) FROM country";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            String worldpopulation="";
            // taking the value
            while (rset.next()) {
                worldpopulation = rset.getString(1);
            }
            System.out.println("The population of the world : " + worldpopulation);
            return worldpopulation;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
        return null;
    }

    //**The population of a continent.
    public void continentpopulation()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT sum(Population) FROM country WHERE Continent = 'Asia' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            String worldpopulation="";
            // taking the value
            while (rset.next()) {
                worldpopulation = rset.getString(1);
            }
            System.out.println("The population of a continent (Asia) : " + worldpopulation);

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
    }

    //**The population of a region.
    public void regionpopulation()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT sum(Population) FROM country WHERE Region = 'Central Africa' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            String worldpopulation="";
            // taking the value
            while (rset.next()) {
                worldpopulation = rset.getString(1);
            }
            System.out.println("The population of a region (Central Africa) : " + worldpopulation);

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
    }

    //**The population of a country.
    public void countrypopulation()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT sum(Population) FROM country WHERE Name = 'India' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            String worldpopulation="";
            // taking the value
            while (rset.next()) {
                worldpopulation = rset.getString(1);
            }
            System.out.println("The population of a country (India) : " + worldpopulation);

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
    }

    //**The population of a district.
    public void districtpopulation()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT sum(Population) FROM city WHERE District = 'Wales' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            String worldpopulation="";
            // taking the value
            while (rset.next()) {
                worldpopulation = rset.getString(1);
            }
            System.out.println("The population of a district (Wales) : " + worldpopulation);

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
    }

    //**The population of a city.
    public void citypopulation()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT sum(Population) FROM city WHERE Name = 'Edinburgh' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            String worldpopulation="";
            // taking the value
            while (rset.next()) {
                worldpopulation = rset.getString(1);
            }
            System.out.println("The population of a city (Edinburgh) : " + worldpopulation + "\n");

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
    }

    //Percentage of country languages
    public ArrayList<CountryLanguage> getCountrylanguages()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            ArrayList<CountryLanguage> countryLang = new ArrayList<CountryLanguage>();
            String[] languages = {"Chinese", "English", "Hindi", "Spanish", "Arabic"};
            // Create string for SQL statement
            for (String lang : languages) {
                String strSelect =
                        "SELECT countrylanguage.Language, SUM(countrylanguage.Percentage*country.Population/100), SUM(country.Population) " + "FROM countrylanguage, country WHERE countrylanguage.CountryCode = country.Code " + "AND countrylanguage.Language = '" + lang + "'";
                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Return new country if valid.
                // Check one is returned
                while (rset.next()) {
                    CountryLanguage cotyLang = new CountryLanguage();
                    cotyLang.setTotalPopu(BigInteger.valueOf(rset.getInt("SUM(countrylanguage.Percentage*country.Population/100)")));
                    cotyLang.setLanguage(rset.getString("countrylanguage.Language"));
                    countryLang.add(cotyLang);
                }
            }
            return countryLang;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get language detail");
            return null;
        }
    }

    //**Display Country languages
    public void displayCountrylanguages(ArrayList<CountryLanguage> countryLang) {
        if (countryLang == null) {
            System.out.println("No Result");
            return;
        }
        //Collections.sort(countryLang, CountryLanguage.compareLanguage);
        for (CountryLanguage lang : countryLang) {
            if (lang == null)
                continue;
            String langName = lang.getLanguage();
            BigInteger percent = new BigInteger("100");
            BigInteger worldpopu = new BigInteger(worldpopulation());
            BigInteger population = lang.getTotalPopu().multiply(percent).divide(worldpopu);
            System.out.println(langName + " is spoken by " + population + "% of the world population.\n");
        }
        System.out.println("====================================================");
        System.out.println("\n");
    }

    //**The population of people, people living in cities, and people not living in cities in each country.
    public ArrayList<Population> getpplPopuCountry()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name, SUM(country.Population), SUM(city.Population)" + "FROM city, country WHERE country.Code = city.CountryCode " + "GROUP BY country.Name";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<Population> pplPopuContinent = new ArrayList<Population>();
            while (rset.next()) {
                Population pplPopuCon = new Population();
                pplPopuCon.setTotal(BigInteger.valueOf(rset.getLong("SUM(country.Population)")));
                pplPopuCon.setCityPopu(BigInteger.valueOf(rset.getLong("SUM(city.Population)")));
                pplPopuCon.setName(rset.getString("Name"));
                pplPopuContinent.add(pplPopuCon);
            }
            return pplPopuContinent;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    //The population of people, people living in cities, and people not living in cities in each continent.
    public ArrayList<Population> getpplPopuContinent()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Continent, SUM(country.Population), SUM(city.Population)" + "FROM city, country WHERE country.Code = city.CountryCode " + "GROUP BY country.Continent";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<Population> pplPopuContinent = new ArrayList<Population>();
            while (rset.next()) {
                Population pplPopuCon = new Population();
                pplPopuCon.setTotal(BigInteger.valueOf(rset.getLong("SUM(country.Population)")));
                pplPopuCon.setCityPopu(BigInteger.valueOf(rset.getLong("SUM(city.Population)")));
                pplPopuCon.setName(rset.getString("Continent"));
                pplPopuContinent.add(pplPopuCon);
            }
            return pplPopuContinent;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    //The population of people, people living in cities, and people not living in cities in each region.
    public ArrayList<Population> getpplPopuRegion()
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Region, SUM(country.Population), SUM(city.Population)" + "FROM city, country WHERE country.Code = city.CountryCode " + "GROUP BY country.Region";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            ArrayList<Population> pplPopuContinent = new ArrayList<Population>();
            while (rset.next()) {
                Population pplPopuCon = new Population();
                pplPopuCon.setTotal(BigInteger.valueOf(rset.getLong("SUM(country.Population)")));
                pplPopuCon.setCityPopu(BigInteger.valueOf(rset.getLong("SUM(city.Population)")));
                pplPopuCon.setName(rset.getString("Region"));
                pplPopuContinent.add(pplPopuCon);
            }
            return pplPopuContinent;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    //**Display population of people living in the city
    public void displaypplPopuCountry(ArrayList<Population> cityPopu)
    {
        if (cityPopu == null)
        {
            System.out.println("No Result");
            return;
        }
        System.out.println("POPULATION OF PEOPLE LIVING IN A CITY");
        System.out.println("=====================================\n");
        for ( Population pplPopu : cityPopu)
        {
            if (pplPopu == null)
                continue;
            BigInteger totalPopu = pplPopu.getTotal();
            if (totalPopu.compareTo(BigInteger.ZERO) == 0)
            {
                System.out.println("The total population of country is ZERO");
            }
            else {
                BigDecimal percent = new BigDecimal("100");
                BigDecimal pplinCity = new BigDecimal(pplPopu.getCityPopu()).multiply(percent).divide(new BigDecimal(pplPopu.getTotal()), 2);
                BigDecimal pplnotinCity = percent.subtract(pplinCity);
                String country = pplPopu.getName();
                System.out.println("Name - " + country);
                System.out.println("The total " + pplinCity + "% of people are living in the city.");
                System.out.println("The total " + pplnotinCity + "% of people are not living in the city.\n");
            }
        }
        System.out.println("===================================================");
        System.out.println("\n");
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        if (args.length < 1)
        {
            a.connect("localhost:3306");
        }
        else
        {
            a.connect(args[0]);
        }

        // Get countries
        ArrayList<Country> cty = a.getCountrybyPopu();
        ArrayList<Country> ctycon = a.getCountrycon();
        ArrayList<Country> ctyreg = a.getCountryreg();
        ArrayList<Country> ctylimit = a.getCountrywithlimit();
        ArrayList<Country> ctyconlimit = a.getCountryconwithlimit();
        ArrayList<Country> ctyreglimit = a.getCountryregwithlimit();

        // Get cities
        ArrayList<City> city = a.getCity();
        ArrayList<City> citycon = a.getCitycon();
        ArrayList<City> citycountry = a.getCitycountry();
        ArrayList<City> citydistrict = a.getdistrict();
        ArrayList<City> cityreg = a.getCityreg();
        ArrayList<City> citywithlimit = a.getCitywithlimit();
        ArrayList<City> cityconwithlimit = a.getCityconwithlimit();
        ArrayList<City> citycountrywithlimit = a.getCitycountrywithlimit();
        ArrayList<City> citydistrictwithlimit = a.getdistrictwithlimit();
        ArrayList<City> cityregwithlimit = a.getCityregwithlimit();
        ArrayList<City> capitalcty = a.getCapitalbyPopu();
        ArrayList<City> capitalcon = a.getCapitalcon();
        ArrayList<City> capitalreg = a.getCapitalreg();
        ArrayList<City> capitalwithlimit = a.getCapitalwithlimit();
        ArrayList<City> capitalconwithlimit = a.getCapitalconwithlimit();
        ArrayList<City> capitalregwithlimit = a.getCapitalregwithlimit();

        // Get living not living details
        ArrayList<Population> pplPopuCountry = a.getpplPopuCountry();
        ArrayList<Population> pplPopuContinent = a.getpplPopuContinent();
        ArrayList<Population> pplPopuRegion = a.getpplPopuRegion();

        // Get country languages
        ArrayList<CountryLanguage> ctylang = a.getCountrylanguages();

        // Display countries
        a.displayCountry(cty);
        a.displayCountry(ctycon);
        a.displayCountry(ctyreg);
        a.displayCountry(ctylimit);
        a.displayCountry(ctyconlimit);
        a.displayCountry(ctyreglimit);

        // Display cities
        a.displayCity(city);
        a.displayCity(citycon);
        a.displayCity(citycountry);
        a.displayCity(citydistrict);
        a.displayCity(cityreg);
        a.displayCity(citywithlimit);
        a.displayCity(cityconwithlimit);
        a.displayCity(citycountrywithlimit);
        a.displayCity(citydistrictwithlimit);
        a.displayCity(cityregwithlimit);
        a.displayCapitalCity(capitalcty);
        a.displayCapitalCity(capitalcon);
        a.displayCapitalCity(capitalreg);
        a.displayCapitalCity(capitalwithlimit);
        a.displayCapitalCity(capitalconwithlimit);
        a.displayCapitalCity(capitalregwithlimit);

        //Display Population
        a.worldpopulation();
        a.continentpopulation();
        a.regionpopulation();
        a.countrypopulation();
        a.districtpopulation();
        a.citypopulation();

        // Display living not living details
        a.displaypplPopuCountry(pplPopuCountry);
        a.displaypplPopuCountry(pplPopuContinent);
        a.displaypplPopuCountry(pplPopuRegion);

        // Display country languages
        a.displayCountrylanguages(ctylang);

        // Disconnect from database
        a.disconnect();
    }
}