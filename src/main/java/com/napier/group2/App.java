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
                city.Name = rset.getString("Name");
                city.CountryCode = rset.getString("CountryCode");
                city.District = rset.getString("District");
                city.Population = rset.getInt("Population");
                citylist.add(city);
            }
            return citylist;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displayCitybyPopu(ArrayList<City> citylist)
    {
        System.out.println("All the cities in the world organised by largest population to smallest.");
        System.out.println(String.format("%-15s %-10s %-15s %-25s ","Name", "Country", "District", "Population"));
        System.out.println(String.format("%-15s %-10s %-15s %-25s ","~~~~", "~~~~~~~", "~~~~~~~~", "~~~~~~~~~~"));
        for ( City city : citylist)
        {
             System.out.println(String.format("%-15s %-10s %-15s %-25s", city.Name, city.CountryCode, city.District, city.Population));
        }
        System.out.println("===================================================================================================");
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
                City citycon = new City();
                citycon.Name = rset.getString("Name");
                citycon.CountryCode = rset.getString("CountryCode");
                citycon.District = rset.getString("District");
                citycon.Population = rset.getInt("Population");
                citylistcon.add(citycon);
            }
            return citylistcon;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displayCitycon(ArrayList<City> citylistcon)
    {
        System.out.println("All the cities in a continent organised by largest population to smallest.");
        System.out.println(String.format("%-15s %-10s %-15s %-25s ","Name", "Country", "District", "Population"));
        System.out.println(String.format("%-15s %-10s %-15s %-25s ","~~~~", "~~~~~~~", "~~~~~~~~", "~~~~~~~~~~"));
        for ( City city : citylistcon)
        {
            System.out.println(String.format("%-15s %-10s %-15s %-25s", city.Name, city.CountryCode, city.District, city.Population));
        }
        System.out.println("===================================================================================================");
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
        ArrayList<City> city = a.getCity();
        ArrayList<City> citycon = a.getCitycon();

        // Display countries
        a.displayCitybyPopu(city);
        a.displayCitycon(citycon);

        // Disconnect from database
        a.disconnect();
    }
}