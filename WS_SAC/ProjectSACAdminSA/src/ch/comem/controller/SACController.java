/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.controller;

import ch.comem.acs.model.VehicleType;
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
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class SACController {

    public static int insertNewIssue(Issue issue) {
      
        int issueInsert = -1;
        Connection con = null;
        try {
             if (getStatus(issue.getStatus()) == null)throw new RuntimeException("Status is wrong"); 
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
                    
                issueInsert = statement.executeUpdate("INSERT INTO issues "
                    + "(numberPlate,vehicleIdentificationNumber,customerId,status,comment,createdDate,handOut,closeIssueDate) VALUES "
                    + "('" + issue.getNumberPlate() + "','"+issue.getVehicle().getIdentificationNumber()+"',"+issue.getCustomer().getId()+",'"+issue.getStatus()+"'"
                    + ",'"+issue.getComment()+"',CURRENT_TIMESTAMP,{ts'"+issue.getHandOut()+"'},{ts'"+issue.getHandOut()+"'})");   
                
              
                                   
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

    /* CRUD METHODE */
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

    public static int insertCustomer(Customer customer) {

        int customerInsert = -1;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            
            customerInsert = statement.executeUpdate("INSERT INTO customers (lastname) VALUES ('" + customer.getLastname()+ "') ");
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

    public static int insertVehicleType(VehicleType vehicleType) {

        int vehicleTyperInsert = -1;
        Connection con = null;
        try {
            ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            vehicleTyperInsert = statement.executeUpdate("INSERT INTO VehicleTypes (category) VALUES ('" + vehicleType.getCategory()+ "') ");
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

    public static int insertVehicle(Vehicle vehicule) {

        int vehicleInsert = -1;
        Connection con = null;
        try {
            if (getVehicleType(vehicule.getTypeCategory()) == null)throw new RuntimeException("Vehicule Type is wrong");                
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
     *
     *
     * @return
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
                        results.getString("createdDate"),
                        results.getString("handOut"),
                        results.getString("closeIssueDate")
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
                      	results.getString("createdDate"),
                        results.getString("handOut"),
                        results.getString("closeIssueDate")
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

      public static Issue UpdatePlateIssue(int id,String numberPlate ) {
        Issue issue = null;
        Connection con = null;
        try {
              ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            if (getIssue(id) == null) throw new RuntimeException("issue invalide");      
            int IssueModified = statement.executeUpdate("UPDATE issues "
                    + "SET numberPlate = '" + numberPlate
                    +"' WHERE id = " + id);
         
            if (IssueModified == 0)throw new RuntimeException("Issue plate number no updated");
                           
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
      
     public static Issue UpdateStatusIssue(int id,String status ) {
        Issue issue = null;
        Connection con = null;
        try {
              ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            if (getStatus(status) == null)throw new RuntimeException("Issue status no updated");
            if (getIssue(id) == null) throw new RuntimeException("Issue invalide");      
            int IssueModified = statement.executeUpdate("UPDATE issues "
                    + "SET status = '" + status
                    + "' WHERE id = " + id);
         
            if (IssueModified == 0)throw new RuntimeException("Issue status no updated");
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
     
         public static Issue UpdateHandOutDateIssue(int id,String handout ) {
        Issue issue = null;
        Connection con = null;
        try {
              ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            
            if (getIssue(id) == null) throw new RuntimeException("Issue invalide");      
            int IssueModified = statement.executeUpdate("UPDATE issues "
                    + "SET handout = '" + handout
                    + "' WHERE id = " + id);
         
            if (IssueModified == 0)throw new RuntimeException("Issue status no updated");
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
         
    public static Issue UpdateCloseIssueDate(int id,String closeDateIssue ) {
        Issue issue = null;
        Connection con = null;
        try {
              ResourceBundle prop = propertiesLoader();
            con = DriverManager.getConnection(prop.getString("dbUrl"), prop.getString("dbUser"), prop.getString("dbPw"));
            Statement statement = con.createStatement();
            
            if (getIssue(id) == null) throw new RuntimeException("Issue invalide");      
            int IssueModified = statement.executeUpdate("UPDATE issues "
                    + "SET closeissueDate = '" + closeDateIssue
                    + "' WHERE id = " + id);
         
            if (IssueModified == 0)throw new RuntimeException("Issue status no updated");
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
