/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

CREATE TABLE issues (
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    numberPlate VARCHAR (50),
    vehicleIdentificationNumber VARCHAR(17) NOT NULL,
    customerId INTEGER NOT NULL,
    status VARCHAR(100),
    comment VARCHAR(400),
    createdDate DATE, 
    handOut DATE DEFAULT NULL,
    closeIssueDate DATE DEFAULT NULL,
    CONSTRAINT fk_customer FOREIGN KEY (customerId) REFERENCES customers(id) ON DELETE CASCADE,
    CONSTRAINT fk_vhcId FOREIGN KEY (vehicleIdentificationNumber) REFERENCES vehicles(identificationNumber) ON DELETE CASCADE
);
 */

package ch.comeme.sac.model;

import java.util.Date;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Issue {
    private int id;
    private String numberPlate;
    private Customer customer;
    private Vehicle vehicle;
    private String status;
    private String comment;
    private Date createdDate;
    private Date handOut;
    private Date closeIssueDate;    

    public Issue(int id, String numberPlate, Customer customer, Vehicle vehicle, String status, String comment, Date createdDate, Date handOut, Date closeIssueDate) {
      if (id <= 0 || customer == null || vehicle == null || status ==  null || comment == null || createdDate == null) throw new RuntimeException("Article invalide");
        this.id = id;
        this.numberPlate = numberPlate;
        this.customer = customer;
        this.vehicle = vehicle;
        this.status = status;
        this.comment = comment;
        this.createdDate = createdDate;
        this.handOut = handOut;
        this.closeIssueDate = closeIssueDate;
    }
    
     public Issue(String numberPlate, Customer customer, Vehicle vehicle, String status, String comment, Date createdDate, Date handOut, Date closeIssueDate) {
      if (customer == null || vehicle == null || status ==  null || comment == null || createdDate == null) throw new RuntimeException("Article invalide");
        this.id = -1;
        this.numberPlate = numberPlate;
        this.customer = customer;
        this.vehicle = vehicle;
        this.status = status;
        this.comment = comment;
        this.createdDate = createdDate;
        this.handOut = handOut;
        this.closeIssueDate = closeIssueDate;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the numberPlate
     */
    public String getNumberPlate() {
        return numberPlate;
    }

    /**
     * @param numberPlate the numberPlate to set
     */
    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * @param vehicle the vehicle to set
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the handOut
     */
    public Date getHandOut() {
        return handOut;
    }

    /**
     * @param handOut the handOut to set
     */
    public void setHandOut(Date handOut) {
        this.handOut = handOut;
    }

    /**
     * @return the closeIssueDate
     */
    public Date getCloseIssueDate() {
        return closeIssueDate;
    }

    /**
     * @param closeIssueDate the closeIssueDate to set
     */
    public void setCloseIssueDate(Date closeIssueDate) {
        this.closeIssueDate = closeIssueDate;
    }
    
    

}


