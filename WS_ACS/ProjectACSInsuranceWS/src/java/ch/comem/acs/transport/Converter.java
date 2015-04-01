<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.acs.transport;

import ch.comem.acs.model.Certificate;
import ch.comem.acs.model.Customer;
import ch.comem.acs.model.Status;
import ch.comem.acs.model.Vehicle;
import ch.comem.acs.model.VehicleType;

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
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.acs.transport;

import ch.comem.acs.model.VehicleType;

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
}
>>>>>>> flo
