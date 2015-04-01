/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.comem.transport;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class IssueTransport {
    
     private int id;
    private String numberPlate;
    private CustomerTransport customer;
    private VehicleTransport vehicle;
    private String status;
    private String comment;
    private String createdDate;
    private String handOut;
    private String closeIssueDate;  

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
    public CustomerTransport getCustomer() {
         CustomerTransport c = new CustomerTransport();
        return c;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(CustomerTransport customer) {
   
        this.customer = customer;
    }

    /**
     * @return the vehicle
     */
    public VehicleTransport getVehicle() {
         VehicleTransport v = new VehicleTransport();
        return v;
    }

    /**
     * @param vehicle the vehicle to set
     */
    public void setVehicle(VehicleTransport vehicle) {
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
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the handOut
     */
    public String getHandOut() {
        return handOut;
    }

    /**
     * @param handOut the handOut to set
     */
    public void setHandOut(String handOut) {
        this.handOut = handOut;
    }

    /**
     * @return the closeIssueDate
     */
    public String getCloseIssueDate() {
        return closeIssueDate;
    }

    /**
     * @param closeIssueDate the closeIssueDate to set
     */
    public void setCloseIssueDate(String closeIssueDate) {
        this.closeIssueDate = closeIssueDate;
    }

}
