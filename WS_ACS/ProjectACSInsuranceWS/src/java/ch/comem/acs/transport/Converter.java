/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.acs.transport;

import ch.comem.acs.controller.ControllerACS;
import ch.comem.acs.model.Certificate;
import ch.comem.acs.model.Customer;
import ch.comem.acs.model.Status;
import ch.comem.acs.model.Vehicle;
import ch.comem.acs.model.VehicleType;
import ch.comem.acs.ws.ACSInsuranceWS;

/**
 * This class is a converter class with static functions to change from transport
 * to business object and vice versa.
 * @author christian heimann
 */
public class Converter {
    
    /**
     * Function to convert vehicleTypeTrans into vehicleType.
     * @param vtt the vehicleTypeTransport to convert.
     * @return a vehicleType transport or null if entry is null.
     */
    public static VehicleType vehicleTypeTransToVehicleType(VehicleTypeTrans vtt) {
        VehicleType vt = null;
        if (vtt != null) {
            vt = new VehicleType(vtt.getCategory());
        }
        return vt;
    }
    
    /**
     * Function to convert vehicleType into vehicleTypeTrans.
     * @param vt the vehicle type to convert.
     * @return a vehicleTypeTrans or null if entry is null.
     */
    public static VehicleTypeTrans vehicleTypeToVehicleTypeTrans(VehicleType vt) {
        VehicleTypeTrans vtt = null;
        if (vt != null) {
            vtt = new VehicleTypeTrans();
            vtt.setCategory(vt.getCategory());
        }    
        return vtt;
    }
    
    /**
     * Function to convert StatusTrans into a Status object.
     * @param st the StatusTrans object to convert.
     * @return a Status object with the same mode as the delivered StatusTrans object or null if input is null.
     */
    public static Status statusTransToStatus(StatusTrans st) {
        Status s = null;
        if (st != null) {
            s = new Status(st.getMode());
        }
        return s;
    }
    
    /**
     * Function to convert Status into StatusTrans object.
     * @param s the Status object to convert.
     * @return a StatusTrans object with the same mode as the delivered Status object or null if input is null.
     */
    public static StatusTrans statusToStatusTrans(Status s) {
        StatusTrans st = null;
        if (s != null) {
            st = new StatusTrans();
            st.setMode(s.getMode());
        }
        return st;
    }
    
    /**
     * Function to transform a customerTrans into a customer object.
     * @param ct the customerTrans object to transform
     * @return a new created customer object or null if input is null.
     */
    public static Customer customerTransToCustomer(CustomerTrans ct) {
        Customer c = null;
        if (ct != null) {
            c = new Customer(ct.getId(),ct.getLastname());
        }
        return c;
    }
    
    /**
     * Function to transform a customer into a customerTrans object.
     * @param c the customer object to transform
     * @return a new created customerTrans object or null if input is null.
     */
    public static CustomerTrans customerToCustomerTrans(Customer c) {
        CustomerTrans ct = null;
        if (c != null) {
            ct = new CustomerTrans();
            ct.setId(c.getId());
            ct.setLastname(c.getLastname());
        }
        return ct;
    }
    
    /**
     * Function to transform a vehicleTrans into a vehicle object.
     * @param vt the vehicleTrans object to transform.
     * @return a new created Vehicle object or null if input is null.
     */
    public static Vehicle vehicleTransToVehicle(VehicleTrans vt) {
        Vehicle v = null;
        if (vt != null) {
            v = new Vehicle(vt.getVin(),Converter.vehicleTypeTransToVehicleType(vt.getVehicleType()), vt.getModel(), vt.getAmount());
        }
        return v;
    }
    
    /**
     * Function to transform a vehicle into a vehicleTrans object.
     * @param v the vehicle to transform
     * @return a new created VehicleTrans object or null if input is null.
     */
    public static VehicleTrans vehicleToVehicleTrans(Vehicle v) {
        VehicleTrans vt = null;
        if (v != null) {
            vt = new VehicleTrans();
            vt.setVin(v.getVin());
            vt.setVehicleType(Converter.vehicleTypeToVehicleTypeTrans(v.getVehicleType()));
            vt.setModel(v.getModel());
            vt.setAmount(v.getAmount());
        }
        return vt;
    }
    
    /**
     * Function to transform a Certificate into a CertificateTrans object.
     * @param c the certificate to transform.
     * @return a new created certificateTrans, or null if input is null.
     */
    public static CertificateTrans certificateToCertificateTrans(Certificate c) {
        CertificateTrans ct = null;
        if (c != null) {
            ct = new CertificateTrans();
            ct.setId(c.getId());
            Customer customer = ControllerACS.getCustomer(c.getCustomerId());
            ct.setCustomer(Converter.customerToCustomerTrans(customer));
            StatusTrans statusTrans = new StatusTrans();
            statusTrans.setMode(c.getStatus());
            ct.setStatus(statusTrans);
            ct.setVehicle(Converter.vehicleToVehicleTrans(c.getVehicle()));
            ct.setComment(c.getComment());
        }
        return ct;
    }
    
    /**
     * Function to convert CertificateTrans into Certificate object.
     * @param ct the certificateTrans object to convert.
     * @return the Certificate object or null if input is null;
     */
    public static Certificate certificateTransToCertificate(CertificateTrans ct) {
        Certificate certificate = null;
        if (ct != null) {
            Customer customer = Converter.customerTransToCustomer(ct.getCustomer());
            Vehicle vehicle = Converter.vehicleTransToVehicle(ct.getVehicle());
            Status status = Converter.statusTransToStatus(ct.getStatus());
            certificate = new Certificate(ct.getId(),customer,vehicle,status,ct.getComment());
        }
        return certificate;
    }
}