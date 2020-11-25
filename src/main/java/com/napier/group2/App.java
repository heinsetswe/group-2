package com.napier.group2;

import java.sql.*;
import java.util.ArrayList;

public class App
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
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
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
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

    public void displayCountry(ArrayList<Country> countrytylist)
    {
        System.out.println("All the countries in the world organised by largest population to smallest.");
        System.out.println(String.format("%-5s %-30s %-15s %-30s %-25s %-10s","Code", "Name", "Continent", "Region", "Population", "Capital"));
        System.out.println(String.format("%-5s %-30s %-15s %-30s %-25s %-10s","~~~~", "~~~~", "~~~~~~~~~", "~~~~~~", "~~~~~~~~~~", "~~~~~~~"));
        for ( Country coty : countrytylist)
        {
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

    //**display countries with limit
    public void displayCountrywithlimit(ArrayList<Country> countrytylist)
    {
        System.out.println("All the countries in the world organised by largest population to smallest by limit.");
        System.out.println(String.format("%-5s %-30s %-15s %-30s %-25s %-10s","Code", "Name", "Continent", "Region", "Population", "Capital"));
        System.out.println(String.format("%-5s %-30s %-15s %-30s %-25s %-10s","~~~~", "~~~~", "~~~~~~~~~", "~~~~~~", "~~~~~~~~~~", "~~~~~~~"));
        for ( Country coty : countrytylist)
        {
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

    //**The population of the world.
    public void worldpopulation()
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

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
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
        a.connect();

        // Get countries
        ArrayList<Country> cty = a.getCountrybyPopu();
        ArrayList<Country> ctycon = a.getCountrycon();
        ArrayList<Country> ctyreg = a.getCountryreg();
        ArrayList<Country> ctylimit = a.getCountrywithlimit();
        ArrayList<Country> ctyconlimit = a.getCountryconwithlimit();
        ArrayList<Country> ctyreglimit = a.getCountryregwithlimit();

        // Display countries
        a.displayCountry(cty);
        a.displayCountry(ctycon);
        a.displayCountry(ctyreg);
        a.displayCountrywithlimit(ctylimit);
        a.displayCountry(ctyconlimit);
        a.displayCountry(ctyreglimit);

        //Display Population
        a.worldpopulation();
        a.continentpopulation();
        a.regionpopulation();
        a.countrypopulation();

        // Disconnect from database
        a.disconnect();
    }
}