/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.controller;

import ch.comem.sac.model.VehicleType;
import ch.comem.sac.model.Customer;
import ch.comem.sac.model.Issue;
import ch.comem.sac.model.Status;
import ch.comem.sac.model.Vehicle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * The manager/controller class of the application service SAC.
 *
 * @author florent plomb
 */
public class SACController {

    /**
     * Function to insert a new issue.
     *
     * @param issue the issue object to insert
     * @return number of inssert or -1 if insertion was not successful.
     */
    public static int insertNewIssue(Issue issue) {

        int issueInsert = -1;
        Connection con = null;
        try {
            if (getStatus(issue.getStatus()) == null) {
                throw new RuntimeException("Status is wrong");
            }
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();

            issueInsert = statement.executeUpdate("INSERT INTO issues "
                    + "(numberPlate,vehicleIdentificationNumber,customerId,status,comment,createdDate,handOut,closeIssueDate) VALUES "
                    + "('" + issue.getNumberPlate() + "','" + issue.getVehicle().getIdentificationNumber() + "'," + issue.getCustomer().getId() + ",'" + issue.getStatus() + "'"
                    + ",'" + issue.getComment() + "',CURRENT_TIMESTAMP,{ts'" + issue.getHandOut() + "'},{ts'" + issue.getHandOut() + "'})");

            if (issueInsert == -1) {
                throw new RuntimeException("Issue insert error");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return issueInsert;

    }

    /**
     * Function to get a list of complete issue with all the internalized
     * objects (customer, vehicle, status).
     *
     * @return a list of all object issue
     */
    public static ArrayList<Customer> getCustomers() {

        ArrayList<Customer> customers = new ArrayList<>();
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM customers ");
            while (results.next()) {
                Customer customer = new Customer(
                        results.getInt("id"),
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

    /**
     * Function to return a customer object with the indicated id.
     *
     * @param id the id of the searched customer.
     * @return a complete customer object
     */
    public static Customer getCustomer(int id) {

        Customer customer = null;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM customers where id =" + id);
            if (results.next()) {
                customer = new Customer(
                        results.getInt("id"),
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

    /**
     * Function to insert a new customer.
     *
     * @param customer the new customer
     * @return number of insert or -1 if insert not sucessful.
     */
    public static int insertCustomer(Customer customer) {

        int customerInsert = -1;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();

            customerInsert = statement.executeUpdate("INSERT INTO customers (lastname) VALUES ('" + customer.getLastname() + "') ");
            if (customerInsert == -1) {
                throw new RuntimeException("Customer insert error");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return customerInsert;
    }

    /**
     * This Function get a vehicleType object.
     *
     * @param category the category of the vehicleType
     * @return a vehicleType
     */
    public static VehicleType getVehicleType(String category) {

        VehicleType vehicleType = null;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM vehicleTypes WHERE category = '" + category + "'");
            if (results.next()) {
                vehicleType = new VehicleType(
                        results.getString("category"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            vehicleType = null;
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vehicleType;
    }

    /**
     * This Function get status of an issue.
     *
     * @param mode the mode of status
     * @return an object status
     */
    public static Status getStatus(String mode) {

        Status status = null;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM status WHERE mode = '" + mode + "'");
            if (results.next()) {
                status = new Status(
                        results.getString("mode"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            status = null;
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return status;
    }

    /**
     * Function insert a new object VehicleTye
     *
     * @param vehicleType the new vehicleType
     * @return number insert or -1 if insert not sucessfull
     */
    public static int insertVehicleType(VehicleType vehicleType) {

        int vehicleTyperInsert = -1;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            vehicleTyperInsert = statement.executeUpdate("INSERT INTO VehicleTypes (category) VALUES ('" + vehicleType.getCategory() + "') ");
            if (vehicleTyperInsert == -1) {
                throw new RuntimeException("Customer insert error");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vehicleTyperInsert;
    }

    /**
     * Function get all Vehicle in databse
     *
     * @return a list of Vehicle
     *
     */
    public static ArrayList<Vehicle> getVehicles() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM vehicles ");
            while (results.next()) {
                Vehicle vehicle = new Vehicle(
                        results.getString("identificationNumber"),
                        results.getString("model"),
                        results.getString("typeCategory")
                );
                vehicles.add(vehicle);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            vehicles = null;
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vehicles;
    }

    /**
     * Function get a specifique vehicle in a database
     *
     * @param identificationNumber id of vehicle
     * @return a object vehicle
     */
    public static Vehicle getVehicle(String identificationNumber) {
        Vehicle vehicle = null;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM vehicles WHERE identificationNumber = '" + identificationNumber + "'");
            if (results.next()) {
                vehicle = new Vehicle(
                        results.getString("identificationNumber"),
                        results.getString("model"),
                        results.getString("typeCategory")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            vehicle = null;
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vehicle;
    }

    /**
     * This Function insert a new vehicle in a database
     *
     * @param vehicule the new vehicle
     * @return number of insert , or -1 if insert not sucessfull
     */
    public static int insertVehicle(Vehicle vehicule) {

        int vehicleInsert = -1;
        Connection con = null;
        try {
            if (getVehicleType(vehicule.getTypeCategory()) == null) {
                throw new RuntimeException("Vehicule Type is wrong");
            }
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            vehicleInsert = statement.executeUpdate("INSERT INTO Vehicles (identificationNumber,typeCategory,model) VALUES "
                    + "('" + vehicule.getIdentificationNumber() + "', "
                    + "'" + vehicule.getTypeCategory() + "',"
                    + "'" + vehicule.getTypeCategory() + "')");
            if (vehicleInsert == -1) {
                throw new RuntimeException("vehicle insert error");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vehicleInsert;
    }

    /**
     * Function get all issue in a database
     *
     * @return an array list issue
     */
    public static ArrayList<Issue> getIssues() {
        ArrayList<Issue> issues = new ArrayList<>();
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM issues ");
            while (results.next()) {
                Issue issue = new Issue(
                        results.getInt("id"),
                        results.getString("numberPlate"),
                        getCustomer(results.getInt("customerId")),
                        getVehicle(results.getString("vehicleIdentificationNumber")),
                        results.getString("status"),
                        results.getString("comment"),
                        results.getString("createdDate")
                );
                issues.add(issue);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            issues = null;
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return issues;
    }

    /**
     * This Function get a specific issue in a database
     *
     * @param id of the specific issue
     * @return an issue object
     */
    public static Issue getIssue(int id) {
        Issue issue = null;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM issues WHERE id =" + id);
            if (results.next()) {
                issue = new Issue(
                        results.getInt("id"),
                        results.getString("numberPlate"),
                        getCustomer(results.getInt("customerId")),
                        getVehicle(results.getString("vehicleIdentificationNumber")),
                        results.getString("status"),
                        results.getString("comment"),
                        results.getString("createdDate")
                );

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            issue = null;
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return issue;
    }

    /**
     * This function update a number plate of an issue
     *
     * @param id of issue to update
     * @param numberPlate the number plate to update
     * @return the issue updated
     */
    public static Issue updatePlateIssue(int id, String numberPlate) {
        Issue issue = null;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            if (getIssue(id) == null) {
                throw new RuntimeException("issue invalide");
            }
            int IssueModified = statement.executeUpdate("UPDATE issues "
                    + "SET numberPlate = '" + numberPlate
                    + "' WHERE id = " + id);
            if (IssueModified == 0) {
                throw new RuntimeException("Issue plate number no updated");
            }
            issue = getIssue(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            issue = null;
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return issue;
    }

    /**
     * This function update a status of an issue
     *
     * @param id of issue to update
     * @param status a new status of issue
     * @return the issue updated
     */
    public static Issue updateStatusIssue(int id, String status) {
        Issue issue = null;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            if (getStatus(status) == null) {
                throw new RuntimeException("Issue status no updated");
            }
            if (getIssue(id) == null) {
                throw new RuntimeException("Issue invalide");
            }
            int IssueModified = statement.executeUpdate("UPDATE issues "
                    + "SET status = '" + status
                    + "' WHERE id = " + id);

            if (IssueModified == 0) {
                throw new RuntimeException("Issue status no updated");
            }
            issue = getIssue(id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            issue = null;
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return issue;
    }

    /**
     * This function update a handOut of an issue
     *
     * @param id of issue to update
     * @param handout handout of issue
     * @return the issue updated
     */
    public static Issue updateHandOutDateIssue(int id, String handout) {
        Issue issue = null;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();

            if (getIssue(id) == null) {
                throw new RuntimeException("Issue invalide");
            }
            int IssueModified = statement.executeUpdate("UPDATE issues "
                    + "SET handout = '" + handout
                    + "' WHERE id = " + id);

            if (IssueModified == 0) {
                throw new RuntimeException("Issue status no updated");
            }
            issue = getIssue(id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            issue = null;
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return issue;
    }

    /**
     * This function update a closedate of an issue
     *
     * @param id of issue to update
     * @param closeDateIssue closedate of issue
     * @return the issue updated
     */
    public static Issue updateCloseIssueDate(int id, String closeDateIssue) {
        Issue issue = null;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();

            if (getIssue(id) == null) {
                throw new RuntimeException("Issue invalide");
            }
            int IssueModified = statement.executeUpdate("UPDATE issues "
                    + "SET closeissueDate = '" + closeDateIssue
                    + "' WHERE id = " + id);

            if (IssueModified == 0) {
                throw new RuntimeException("Issue status no updated");
            }
            issue = getIssue(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            issue = null;
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return issue;
    }

    /* PRIVATE METHODE */
    private static ResourceBundle propertiesLoader() {
        String dataPath = "ch.comem.sac.config.database";
        ResourceBundle prop = ResourceBundle.getBundle(dataPath);
        return prop;
    }

}
