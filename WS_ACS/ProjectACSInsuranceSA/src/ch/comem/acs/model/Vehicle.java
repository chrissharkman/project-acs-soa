
package ch.comem.acs.model;

import javax.management.RuntimeErrorException;

/**
 * This class defines the vehicle object. A vehicle object has always the standardized
 * vehicule identification number (vim), a vehicle type, a model name, and a value (amount). 
 * @author christian heimann
 */
public class Vehicle {
    private String vim;
    private VehicleType vehicleType;
    private String model;
    private Double amount;

    public Vehicle(String vim, VehicleType vehicleType, String model, Double amount) {
        if (vim == null || vim.length() < 1 || vim.length() > 17 || vehicleType == null || model == null || model.length() < 1 || amount < 0) {
            throw new RuntimeException("Constructor Vehicle: insertion not valid.");
        }
        this.vim = vim;
        this.vehicleType = vehicleType;
        this.model = model;
        this.amount = amount;
    }
    
    
}
