/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import ch.comem.acs.controller.ControllerACS;
import ch.comem.acs.model.Certificate;
import ch.comem.acs.model.Customer;
import ch.comem.acs.model.Status;
import ch.comem.acs.model.Vehicle;
import ch.comem.acs.model.VehicleType;

/**
 * Helper class to test
 * @author christian heimann
 */
public class Program {
    
    public static void main(String[] args) {
        Customer costumer = new Customer(8, "Christian");
        VehicleType vtCar = new VehicleType("car");
        Vehicle veh = new Vehicle("abcVin", vtCar, "Passat", 2300.00);
        Status status = new Status("created");
        
//        
        Certificate c = new Certificate(costumer, veh, status, "No comment.");
        int go = ControllerACS.insertNewCertificate(c);
        System.out.println(go);
       // System.out.println(ControllerACS.insertVehicle(veh));
    }
}
