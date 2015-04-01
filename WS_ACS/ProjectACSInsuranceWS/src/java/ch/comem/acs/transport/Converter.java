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
