/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.transport;

import ch.comem.acs.model.VehicleType;
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
    public static CustomerTransport customerToCustomerTransport(Customer customer) {
        CustomerTransport ct = null;
        if (customer != null) {
            ct = new CustomerTransport();
            ct.setId(customer.getId());
            ct.setLastname(customer.getLastname());
        }
        return ct;
    }

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

    public static StatusTransport statusToStatusTransport(Status status) {
        StatusTransport st = null;
        if (status != null) {
            st = new StatusTransport();
            st.setMode(status.getMode());

        }
        return st;
    }

    public static VehicleTypeTransport vehicleTypeToVehicleTypeTransport(VehicleType vehicleType) {
        VehicleTypeTransport vt = null;
        if (vehicleType != null) {
            vt = new VehicleTypeTransport();
            vt.setCategory(vehicleType.getCategory());
        }
        return vt;
    }

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
    public static Customer customerTransportToCustomer(CustomerTransport ct) {
        Customer c = null;
        if (ct != null) {
            c = new Customer(
                    ct.getId(),
                    ct.getLastname());
        }
        return c;
    }

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

    public static Status statusTransportToStatus(StatusTransport st) {
        Status s = null;
        if (st != null) {
            s = new Status(
                    st.getMode());
        }
        return s;
    }

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
            i = new Issue(
                    it.getId(),
                    it.getNumberPlate(),
                    customerTransportToCustomer(it.getCustomer()),
                    vehicleTransportToVehicle(it.getVehicle()),
                    it.getStatus(),
                    it.getComment(),
                    it.getCreatedDate(),
                    it.getHandOut(),
                    it.getCloseIssueDate());                               
        }
        return i;
    }

}
