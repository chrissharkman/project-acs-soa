/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.sac.model;

import java.util.Date;

/**
 * /**
 * This class describes a issue object with all the necessary indications like
 * id, customer, vehicle, status and comment.
 *
 * @author florent plomb
 */



public class Issue {

    private int id;
    private String numberPlate;
    private Customer customer;
    private Vehicle vehicle;
    private String status;
    private String comment;
    private String createdDate;
    private String handOut;
    private String closeIssueDate;

    /**
     * Constructor to create a issue belonging to a customer and a
     * vehicule
     * @param id an identification for issue
     * @param numberPlate an number plate for a vehicule
     * @param customer  The customer for whom the issue is for.
     * @param vehicle The vehicle for whom the issue is for.
     * @param status The status of issue
     * @param comment The comment about issue
     * @param createdDate Date of creation
     * @param handOut Date when the customer handout a plate
     * @param closeIssueDate Date if the timeout is over
     */

    public Issue(int id, String numberPlate, Customer customer, Vehicle vehicle, String status, String comment, String createdDate) {
        if (id <= 0 || customer == null || vehicle == null || status == null || comment == null || createdDate == null) {
            throw new RuntimeException("Issue invalide");
        }
        this.id = id;
        this.numberPlate = numberPlate;
        this.customer = customer;
        this.vehicle = vehicle;
        this.status = status;
        this.comment = comment;
        this.createdDate = createdDate;
        this.handOut = null;
        this.closeIssueDate = null;
    }
    /**
     * Constructor to create a issue belonging to a customer and a
     * vehicule
     * @param numberPlate an number plate for a vehicule
     * @param customer  The customer for whom the issue is for.
     * @param vehicle The vehicle for whom the issue is for.
     * @param status The status of issue
     * @param comment The comment about issue
     * @param createdDate Date of creation
     * @param handOut Date when the customer handout a plate
     * @param closeIssueDate Date if the timeout is over
     */

    public Issue(String numberPlate, Customer customer, Vehicle vehicle, String status, String comment, String createdDate) {
        if (customer == null || vehicle == null || status == null || comment == null) {
            throw new RuntimeException("Issue invalide");
        }
        this.id = -1;
        this.numberPlate = numberPlate;
        this.customer = customer;
        this.vehicle = vehicle;
        this.status = status;
        this.comment = comment;
        this.createdDate = createdDate;
        this.handOut = null;
        this.closeIssueDate = null;
    }

    /**
     * Getter of the id of an issue
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter to set the id of an issue
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter of the numberplate of an issuee
     * @return the numberPlate
     */
    public String getNumberPlate() {
        return numberPlate;
    }

    /**
     * Setter of the numberplate of an issue
     * @param numberPlate the numberPlate to set
     */
    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    /**
     * Getter for a customer of a issue
     * @return the customer
     */
    public Customer getCustomer() {
        Customer c = customer;
        return c;
    }

    /**
     * Setter for the customer of a issue
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the vehicle
     */
    public Vehicle getVehicle() {
        Vehicle v = vehicle;
        return v;
    }

    /**
     * @param vehicle the vehicle to set
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Getter for a status of issue
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter of a status for a issue
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter for comment of issue
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Setter of comment for issue
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * getter of createdate of an issue
     * @return the createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * Setter of createddate of an issue
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Getter for a date handout of an issue
     * @return the handOut
     */
    public String getHandOut() {
        return handOut;
    }

    /**
     * Setter for a date handout of an issue
     * @param handOut the handOut to set
     */
    public void setHandOut(String handOut) {
        this.handOut = handOut;
    }

    /**
     * Getter for closeDateof of an issue
     * @return the closeIssueDate
     */
    public String getCloseIssueDate() {
        return closeIssueDate;
    }

    /**
     * Setter for a closeIssueDate of an issue
     * @param closeIssueDate the closeIssueDate to set
     */
    public void setCloseIssueDate(String closeIssueDate) {
        this.closeIssueDate = closeIssueDate;
    }

}
