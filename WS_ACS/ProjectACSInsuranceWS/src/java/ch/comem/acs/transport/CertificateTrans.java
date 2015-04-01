/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.acs.transport;

/**
 * This class describes the transmissible certificate object.
 * @author christian heimann
 */
public class CertificateTrans {
    private int id;
    private CustomerTrans customer;
    private VehicleTrans vehicle;
    private StatusTrans status;
    private String comment;

    /**
     * Empty constructor of CertificateTrans object.
     */
    public CertificateTrans() {};

    /**
     * Getter for the certificate id.
     * @return the id of the certificate.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter of the id of a certificate.
     * @param id the id to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter of a copy of the customerTrans object of the certificate.
     * @return the customer of the certificate.
     */
    public CustomerTrans getCustomer() {
        CustomerTrans ct = new CustomerTrans();
        ct.setId(this.customer.getId());
        ct.setLastname(this.customer.getLastname());
        return ct;
    }

    /**
     * Setter for the customer of the certificate.
     * @param customer the customer to set.
     */
    public void setCustomer(CustomerTrans customer) {
        this.customer = customer;
    }

    /**
     * Getter of the vehicle of the certificate.
     * @return the vehicle of the certificate.
     */
    public VehicleTrans getVehicle() {
        VehicleTrans vt = new VehicleTrans();
        vt.setVin(this.vehicle.getVin());
        vt.setVehicleType(this.vehicle.getVehicleType());
        vt.setModel(this.vehicle.getModel());
        vt.setAmount(this.vehicle.getAmount());
        return vt;
    }

    /**
     * Setter for the vehicle of the certificate.
     * @param vehicle the vehicle to set.
     */
    public void setVehicle(VehicleTrans vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Getter of a copy of the statusTrans object of the certificate.
     * @return the status of the certificate.
     */
    public StatusTrans getStatus() {
        StatusTrans st = new StatusTrans();
        st.setMode(this.status.getMode());
        return st;
    }

    /**
     * Setter for the status of the certificate.
     * @param status the status to set.
     */
    public void setStatus(StatusTrans status) {
        this.status = status;
    }

    /**
     * Getter of the comment of the certificate.
     * @return the comment of the certificate.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Setter for the comment of the certificate.
     * @param comment the comment to set.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
}



