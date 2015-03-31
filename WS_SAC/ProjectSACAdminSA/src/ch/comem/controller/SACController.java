/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.controller;

import ch.comem.sac.model.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class SACController {

    public static void insertNewIssue() {

    }

    /* CRUD METHODE */
    public static ArrayList<Customer> getCustomer(String lastname) {

        ArrayList<Customer> customers = new ArrayList<>();

        Connection con = null;

        try {
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM customers ");

            while (results.next()) {
                Customer customer = new Customer(
                        results.getString("lastname"));
                customers.add(customer);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            customers = null;
        }

        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return customers;

    }

    public static Customer insertCustomer(String lastname) {

        Customer customer = null;
        Connection con = null;

        try {
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("INSERT TO customers (lastname) VALUES ('" + lastname + "') ");
            if (results.next()) {
                customer = new Customer(
                        results.getString("lastname"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            customer = null;
        }

        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return customer;

    }

    public static Customer getVehicleType(String lastname) {

        Customer customer = null;
        Connection con = null;

        try {
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM customers ");

            if (results.next()) {
                customer = new Customer(
                        results.getString("lastname"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            customer = null;
        }

        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return customer;

    }

    /* PRIVATE METHODE */
    private static ResourceBundle propertiesLoader() {
        String dataPath = "ch.comem.goldeneye.config.database";
        ResourceBundle prop = ResourceBundle.getBundle(dataPath);
        return prop;
    }

}
