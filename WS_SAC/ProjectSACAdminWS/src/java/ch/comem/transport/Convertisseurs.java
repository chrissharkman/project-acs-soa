/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.transport;

import ch.comem.sac.model.VehicleType;
import ch.comem.sac.model.Customer;
import ch.comem.sac.model.Issue;
import ch.comem.sac.model.Status;
import ch.comem.sac.model.Vehicle;

/**
 *
 * @acthor Sammy Guergachi <sguergachi at gmail.com>
 */
public class Convertisseurs {

    /* METHODE OBJECT TO OBJECTTRANSPORT */
    
    /**
     * This function convert a customer in customer transport
     * @param customer the customer to transport
     * @return a customertransport
     */
    public static CustomerTransport customerToCustomerTransport(Customer customer) {
        CustomerTransport ct = null;
        if (customer != null) {
            ct = new CustomerTransport();
            ct.setId(customer.getId());
            ct.setLastname(customer.getLastname());
        }
        return ct;
    }
/**
 * This function convert a vehicle in vehicle to transport
 * @param vehicle the vehicle to transport
 * @return vehicletransport
 */
    public static VehicleTransport vehicleToVehicleTransport(Vehicle vehicle) {
        VehicleTransport vt = null;
        if (vehicle != null) {
            vt = new VehicleTransport();
            vt.setIdentificationNumber(vehicle.getIdentificationNumber());
            vt.setModel(vehicle.getModel());
            vt.setTypeCategory(vehicle.getTypeCategory());

        }
        return vt;
    }
    /**
     * This function convert a status in a status to transport
     * @param status the status to transport
     * @return a status
     */

    public static StatusTransport statusToStatusTransport(Status status) {
        StatusTransport st = null;
        if (status != null) {
            st = new StatusTransport();
            st.setMode(status.getMode());

        }
        return st;
    }
/**
 * This function convert a vehicle in to Vehicle Transport
 * @param vehicleType the vehicleType to transport
 * @return vehicleType
 */
    public static VehicleTypeTransport vehicleTypeToVehicleTypeTransport(VehicleType vehicleType) {
        VehicleTypeTransport vt = null;
        if (vehicleType != null) {
            vt = new VehicleTypeTransport();
            vt.setCategory(vehicleType.getCategory());
        }
        return vt;
    }
    /**
     * This function convert an issue into issue to transport
     * @param issue to transport
     * @return an issue transport
     */

    public static IssueTransport issueToIssueTransport(Issue issue) {
        IssueTransport it = null;
        if (issue != null) {
            it = new IssueTransport();
            it.setCloseIssueDate(issue.getCloseIssueDate());
            it.setComment(issue.getComment());
            it.setCreatedDate(issue.getCreatedDate());
            it.setCustomer(customerToCustomerTransport(issue.getCustomer()));
            it.setVehicle(vehicleToVehicleTransport(issue.getVehicle()));
            it.setHandOut(issue.getHandOut());
            it.setId(issue.getId());
            it.setNumberPlate(issue.getNumberPlate());
            it.setStatus(issue.getStatus());
        }
        return it;
    }

    /* METHODE OBJECTTRANSPORT TO OBJECT */
   
    
    /**
     * Function to transform a customerTransport into a customer object.
     * @param ct the customerTransports object to transform.
     * @return a new created customer object or null if input is null.
     */
    public static Customer customerTransportToCustomer(CustomerTransport ct) {
        Customer c = null;
        if (ct != null) {

            if (ct.getId() <= 0) {
                c = new Customer(
                        ct.getLastname());
            } else {
                c = new Customer(
                        ct.getId(),
                        ct.getLastname());

            }
        }
        return c;
    }
    /**
     * Function to transform a vehicleTransport into a vehicle object.
     * @param vt the vehicleTransports object to transform.
     * @return a new created vehicle object or null if input is null.
     */
    
    public static Vehicle vehicleTransportToVehicle(VehicleTransport vt) {
        Vehicle v = null;
        if (vt != null) {
            v = new Vehicle(
                    vt.getIdentificationNumber(),
                    vt.getModel(),
                    vt.getTypeCategory());
        }
        return v;
    }
    /**
     * Function to transform a statusTransport into a status object.
     * @param st the statusTransports object to transform.
     * @return a new created status object or null if input is null.
     */

    public static Status statusTransportToStatus(StatusTransport st) {
        Status s = null;
        if (st != null) {
            s = new Status(
                    st.getMode());
        }
        return s;
    }
    /**
     * Function to transform a vehicleTypeTransport into a vehicleType object.
     * @param ct the vehicleTypeTransports object to transform.
     * @return a new created vehicleType object or null if input is null.
     */
    

    public static VehicleType vehicleTypeTransportToVehicleType(VehicleTypeTransport vt) {
        VehicleType v = null;
        if (vt != null) {
            v = new VehicleType(
                    vt.getCategory());
        }
        return v;
    }

    public static Issue issueTransportToIssue(IssueTransport it) {
        Issue i = null;
        if (it != null) {

            if (it.getId() <= 0) {
                i = new Issue(
                        it.getNumberPlate(),
                        customerTransportToCustomer(it.getCustomer()),
                        vehicleTransportToVehicle(it.getVehicle()),
                        it.getStatus(),
                        it.getComment(),
                        it.getCreatedDate()
                );

            } else {
                i = new Issue(
                        it.getId(),
                        it.getNumberPlate(),
                        customerTransportToCustomer(it.getCustomer()),
                        vehicleTransportToVehicle(it.getVehicle()),
                        it.getStatus(),
                        it.getComment(),
                        it.getCreatedDate());
            }
        }
        return i;
    }

}
