/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.acs.controller;

import ch.comem.acs.model.Certificate;
import ch.comem.acs.model.Status;
import ch.comem.acs.model.Vehicle;
import ch.comem.acs.model.VehicleType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * The manager/controller class of the application service ACS.
 * @author christian heimann
 */
public class ControllerACS {
    
    /**
     * Function to insert a new certificate. The certificate needs to be complete.
     * @param certificate the certificate object to insert.
     * @return the generated id of the inserted certificate, -1 if insertion was not successful. 
     */
    public static int insertNewCertificate(Certificate certificate) {
        int generatedKey = -1;
        // check customer and vehicleType
        if (customerExists(certificate.getCustomerId()) && vehicleTypeExists(certificate.getVehicleType())) {
            try {
                // insert Vehicle into database
                int vehiculeInserted = insertVehicle(certificate.getVehicle());
                if (vehiculeInserted >= 0) {
                    // insert Certificate into database with status 'created'
                    generatedKey = insertCertificate(certificate);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return generatedKey;
    }
    
    public static void changeState(int certificateId, Status status) {
        
    }
    
    public static void modifyCertificate() {
    
    }
    
    
    /**
     * Function to insert a vehicle into database.
     * @param vehicle a complete vehicle object with a vim, type, model and amount
     * @return 1 if successfully inserted, 0 if vehicle id, -1 if vehicle is null
     */
    public static int insertVehicle(Vehicle vehicle) {
        int vehicleInserted = -1;
        if (vehicle != null) {
            if (!vehicleExists(vehicle.getVin())) {
                Connection con = null;
                try {
                    ResourceBundle prop = propertiesLoader();
                    con = getConnected(prop);
                    Statement statement = con.createStatement();
                    String query = "INSERT INTO vehicles (identificationNumber,typeCategory,modele,amount) "
                            + "VALUES ('" + vehicle.getVin() +"','" + vehicle.getVehicleTypeCategory() + "','" 
                            + vehicle.getModel() +"'," + vehicle.getAmount() + ")";
                    vehicleInserted = statement.executeUpdate(query);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                // close connection
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                vehicleInserted = 0;
            }
        }
        return vehicleInserted;
    } 
    
    
    
    
    /* CRUD AND FS METHODS */

    /*
    Function to insert a certificate object.
    Make sure that vim, customer and status are already inserted into database before
    calling this function.
    */
    static int insertCertificate(Certificate certificate) {
    int keyCertificate = -1;
        if (certificate != null) {
                Connection con = null;
                try {
                    ResourceBundle prop = propertiesLoader();
                    con = getConnected(prop);
                    Statement statement = con.createStatement();
                    String query = "INSERT INTO certificates (customerId,vehicleIdentificationNumber,status,comment) "
                            + "VALUES (" + certificate.getCustomerId() + ",'" + certificate.getVehicleVin() + "','"
                            + certificate.getStatus() + "','" + certificate.getComment() + "')";
                    statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                    ResultSet res = statement.getGeneratedKeys();
                    if (res.next())
                    {
                        keyCertificate = res.getInt(1);                        
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                // close connection
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
        }
        return keyCertificate;    
    }
    
    
    
    /*
    Function to check if customer exists in database.
    */
    static boolean customerExists(int customerId) {
        boolean customerExists = false;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = getConnected(prop);
            Statement statement = con.createStatement();
            String query = "SELECT * FROM customers WHERE id = " + customerId +"";
            ResultSet res  = statement.executeQuery(query);
            if (res.next()) {
                customerExists = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // close connection
        try {
            con.close();
        } catch (SQLException e) {
                System.out.println(e.getMessage());
        }
        return customerExists;
    }
    
    /*
    Function to check if vehicleType exists in tha database.
    */
    static boolean vehicleTypeExists(String vehicleTypeCategory) {
        boolean vehicleTypeExists = false;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = getConnected(prop);
            Statement statement = con.createStatement();
            String query = "SELECT * FROM vehicleTypes WHERE category = '" + vehicleTypeCategory +"'";
            ResultSet res  = statement.executeQuery(query);
            if (res.next()) {
                vehicleTypeExists = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // close connection
        try {
            con.close();
        } catch (SQLException e) {
                System.out.println(e.getMessage());
        }
        return vehicleTypeExists;
    }
    
    /*
    Function to check if a vehicle exists already in database.
    */
    static boolean vehicleExists(String vin) {
        boolean vehicleExists = false;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = getConnected(prop);
            Statement statement = con.createStatement();
            String query = "SELECT * FROM vehicles WHERE identificationNumber = '" + vin +"'";
            ResultSet res  = statement.executeQuery(query);
            if (res.next()) {
                vehicleExists = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // close connection
        try {
            con.close();
        } catch (SQLException e) {
                System.out.println(e.getMessage());
        }
        return vehicleExists;
    }
    
    
    /* PRIVATE HELPER METHODS */
    
    /*
    Function to load the properties of the indicated file.
    */
    private static ResourceBundle propertiesLoader() {
        String dataPath = "ch.comem.acs.config.database";
        ResourceBundle prop = ResourceBundle.getBundle(dataPath);
        return prop;
    }
    
    /*
    Function to connect with the database indicated in the prop parameter.
    @param prop is a ResourceBundle which must contain a dbUrl, dbUser and a dbPw.
    @return a Connection.
    */
    private static Connection getConnected(ResourceBundle prop) throws SQLException {
        return DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
    }
}
