/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.acs.controller;

import ch.comem.acs.model.Certificate;
import ch.comem.acs.model.Customer;
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
 *
 * @author christian heimann
 */
public class ControllerACS {

    /**
     * Function to insert a new certificate. The certificate needs to be
     * complete.
     *
     * @param certificate the certificate object to insert.
     * @return the generated id of the inserted certificate, -1 if insertion was
     * not successful.
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

    /**
     * Function to get a complete certificate with all the internalized objects (customer, vehicle, status).
     * @param certificateId the id of the searched certificate.
     * @return a complete certificate object.
     */
    public static Certificate getCertificate(int certificateId) {
        Certificate certificate = null;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = getConnected(prop);
            Statement statement = con.createStatement();
            String query = "SELECT * FROM certificates WHERE id = " + certificateId + "";
            ResultSet res = statement.executeQuery(query);
            if (res.next()) {
                Customer customer = getCustomer(res.getInt("customerId"));
                Vehicle vehicle = getVehicle(res.getString("identificationNumber"));
                Status status = getStatus(res.getString("mode"));
                certificate = new Certificate(res.getInt("id"),customer,vehicle,status,res.getString("comment"));
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
        return certificate;
    }
    
    /**
     * Function to return a customer object with the indicated id.
     * @param customerId the id of the searched customer.
     * @return a complete customer object.
     */
    public static Customer getCustomer(int customerId) {
        Customer customer = null;
        if (customerId > 0) {
            Connection con = null;
            try {
                ResourceBundle prop = propertiesLoader();
                con = getConnected(prop);
                Statement statement = con.createStatement();
                String query = "SELECT * FROM customers WHERE id = " + customerId + "";
                ResultSet res = statement.executeQuery(query);
                if (res.next()) {
                    customer = new Customer(res.getInt("id"), res.getString("lastname"));
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
        return customer;
    }
    
    /**
     * Function to return a complete vehicle object.
     * @param identificationnumber the id of the searched vehicle.
     * @return a vehicle if it exists in the database, null if not.
     */
    public static Vehicle getVehicle(String identificationnumber) {
        Vehicle vehicle = null;
        if (identificationnumber != null) {
            Connection con = null;
            try {
                ResourceBundle prop = propertiesLoader();
                con = getConnected(prop);
                Statement statement = con.createStatement();
                String query = "SELECT * FROM vehicles WHERE identificationnumber = '" + identificationnumber + "'";
                ResultSet res = statement.executeQuery(query);
                if (res.next()) {
                    VehicleType vehicleType = new VehicleType(res.getString("typecategory"));
                    vehicle = new Vehicle(res.getString("identificationnumber"), vehicleType, res.getString("model"), res.getDouble("amount"));
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
        return vehicle;
    }
    
    public static Status getStatus(String mode) {
       Status status = null;
       if (mode != null) {
       Connection con = null;
            try {
                ResourceBundle prop = propertiesLoader();
                con = getConnected(prop);
                Statement statement = con.createStatement();
                String query = "SELECT * FROM status WHERE mode = '" + mode + "'";
                ResultSet res = statement.executeQuery(query);
                if (res.next()) {
                    status = new Status(res.getString("mode"));
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
       return status;
    }
    
    /**
     * Function to change the state of a certificate, only possible if
     * certificate and status already exist.
     *
     * @param certificateId the certificate from which the state must be
     * changed.
     * @param status the status to set.
     * @return 1 if update was successful, -1 if error.
     */
    public static int changeState(int certificateId, Status status) {
        int changeState = -1;
        if (certificateExists(certificateId) && statusExists(status.getMode())) {
            String query = "UPDATE certificates SET status = '" + status.getMode().replace("'", "''") + "' WHERE id = " + certificateId +"";
            changeState = updateCertificate(query);
        }
        return changeState;
    }

    /**
     * Function to set the a new vehicule identification number.
     * @param certificateId the certificate to change.
     * @param vin the new vehicule identification number to set.
     * @return 1 if update was successful, -1 if error.
     */
    public static int changeVIN(int certificateId, String vin) {
        int changeVIN = -1;
        if (certificateExists(certificateId) && vehicleExists(vin)) {
            String query = "UPDATE certificates SET vehicleidentificationnumber = '" + vin.replace("'", "''") + "' WHERE id = " + certificateId + "";
            changeVIN = updateCertificate(query);
        }
        return changeVIN;
    }
    
    /**
     * FUnction to set a new comment to the certificate. The old comment is erased.
     * @param certificateId the certificate id of the certificate to change.
     * @param comment the comment to set.
     * @return 1 if update was successful, -1 if error.
     */
    public static int changeComment(int certificateId, String comment) {
        int changeComment = -1;
        if (certificateExists(certificateId)) {
            String query = "UPDATE certificates SET comment = '" + comment.replace("'", "''") + "' WHERE id = " + certificateId + "";
            changeComment = updateCertificate(query);
        }
        return changeComment;
    }

    public static String getConstantKeyValue(int constantId) {
        String keyValue = "";
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = getConnected(prop);
            Statement statement = con.createStatement();
            String query = "SELECT * FROM constances WHERE id = " + constantId + "";
            ResultSet res = statement.executeQuery(query);
            if (res.next()) {
                keyValue = res.getString("keyvalue");
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
        return keyValue;
    }

    /**
     * Function to insert a vehicle into database.
     *
     * @param vehicle a complete vehicle object with a vim, type, model and
     * amount
     * @return 1 if successfully inserted, 0 if vehicle id, -1 if vehicle is
     * null
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
                            + "VALUES ('" + vehicle.getVin() + "','" + vehicle.getVehicleTypeCategory() + "','"
                            + vehicle.getModel() + "'," + vehicle.getAmount() + ")";
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
                if (res.next()) {
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

    /**
     * Generic update function for Certificate.
     *
     * @param query the query for the update.
     * @return 1 if update was successful, -1 if error.
     */
    static int updateCertificate(String query) {
        int updateCertificate = -1;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = getConnected(prop);
            Statement statement = con.createStatement();
            updateCertificate = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // close connection
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return updateCertificate;
    }

    /**
     * Function to check if certificate exists.
     *
     * @param certificateId the id of the certificate to verify.
     * @return true if certificate exists, false if not.
     */
    static boolean certificateExists(int certificateId) {
        boolean certificateExists = false;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = getConnected(prop);
            Statement statement = con.createStatement();
            String query = "SELECT * FROM certificates WHERE id = " + certificateId + "";
            ResultSet res = statement.executeQuery(query);
            if (res.next()) {
                certificateExists = true;
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
        return certificateExists;
    }

    /**
     * Function to check if a status exists.
     *
     * @param mode the identifier of the status.
     * @return true if the status exists, false if not.
     */
    static boolean statusExists(String mode) {
        boolean statusExists = false;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = getConnected(prop);
            Statement statement = con.createStatement();
            String query = "SELECT * FROM status WHERE mode LIKE '" + mode + "'";
            ResultSet res = statement.executeQuery(query);
            if (res.next()) {
                statusExists = true;
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
        return statusExists;
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
            String query = "SELECT * FROM customers WHERE id = " + customerId + "";
            ResultSet res = statement.executeQuery(query);
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
            String query = "SELECT * FROM vehicleTypes WHERE category = '" + vehicleTypeCategory + "'";
            ResultSet res = statement.executeQuery(query);
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
            String query = "SELECT * FROM vehicles WHERE identificationNumber = '" + vin + "'";
            ResultSet res = statement.executeQuery(query);
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
