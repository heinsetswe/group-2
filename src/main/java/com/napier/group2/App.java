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
                cty.Code = rset.getString("Code");
                cty.Name = rset.getString("Name");
                cty.Continent = rset.getString("Continent");
                cty.Region = rset.getString("Region");
                cty.Population = rset.getInt("Population");
                cty.Capital = rset.getInt("Capital");
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
                Country ctycon = new Country();
                ctycon.Code = rset.getString("Code");
                ctycon.Name = rset.getString("Name");
                ctycon.Continent = rset.getString("Continent");
                ctycon.Region = rset.getString("Region");
                ctycon.Population = rset.getInt("Population");
                ctycon.Capital = rset.getInt("Capital");
                ctylistcon.add(ctycon);
            }
            return ctylistcon;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displayCountrybyPopu(ArrayList<Country> ctylist)
    {
        System.out.println("All the countries in the world organised by largest population to smallest.");
        System.out.println(String.format("%-5s %-30s %-15s %-30s %-25s %-10s","Code", "Name", "Continent", "Region", "Population", "Capital"));
        System.out.println(String.format("%-5s %-30s %-15s %-30s %-25s %-10s","~~~~", "~~~~", "~~~~~~~~~", "~~~~~~", "~~~~~~~~~~", "~~~~~~~"));
        for ( Country coty : ctylist)
        {
             System.out.println(String.format("%-5s %-30s %-15s %-30s %-25s %-10s", coty.Code, coty.Name, coty.Continent, coty.Region, coty.Population, coty.Capital));
        }
    }

    public void displayCountrycon(ArrayList<Country> ctylistcon)
    {
        System.out.println("All the countries in a continent organised by largest population to smallest.");
        System.out.println(String.format("%-5s %-30s %-15s %-30s %-25s %-10s","Code", "Name", "Continent", "Region", "Population", "Capital"));
        System.out.println(String.format("%-5s %-30s %-15s %-30s %-25s %-10s","~~~~", "~~~~", "~~~~~~~~~", "~~~~~~", "~~~~~~~~~~", "~~~~~~~"));
        for ( Country coty : ctylistcon)
        {
            System.out.println(String.format("%-5s %-30s %-15s %-30s %-25s %-10s", coty.Code, coty.Name, coty.Continent, coty.Region, coty.Population, coty.Capital));
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
                Country ctyreg = new Country();
                ctyreg.Code = rset.getString("Code");
                ctyreg.Name = rset.getString("Name");
                ctyreg.Continent = rset.getString("Continent");
                ctyreg.Region = rset.getString("Region");
                ctyreg.Population = rset.getInt("Population");
                ctyreg.Capital = rset.getInt("Capital");
                ctylistreg.add(ctyreg);
            }
            return ctylistreg;

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public void displayCountryreg(ArrayList<Country> ctylistreg)
    {
        System.out.println("All the countries in the world organised by largest population to smallest.");
        System.out.println(String.format("%-5s %-30s %-15s %-30s %-25s %-10s","Code", "Name", "Continent", "Region", "Population", "Capital"));
        System.out.println(String.format("%-5s %-30s %-15s %-30s %-25s %-10s","~~~~", "~~~~", "~~~~~~~~~", "~~~~~~", "~~~~~~~~~~", "~~~~~~~"));
        for ( Country coty : ctylistreg)
        {
            System.out.println(String.format("%-5s %-30s %-15s %-30s %-25s %-10s", coty.Code, coty.Name, coty.Continent, coty.Region, coty.Population, coty.Capital));
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
        // Display countries
        a.displayCountrybyPopu(cty);
        a.displayCountrycon(ctycon);
        a.displayCountryreg(ctyreg);

        // Disconnect from database
        a.disconnect();
    }
}