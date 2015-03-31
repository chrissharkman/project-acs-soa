
package ch.comem.acs.model;

/**
 * This class defines the vehicle object. A vehicle object has always the standardized
 * vehicule identification number (vim), a vehicle type, a model name, and a value (amount). 
 * @author christian heimann
 */
public class Vehicle {
    private String vin;
    private VehicleType vehicleType;
    private String model;
    private Double amount;

    /**
     * Constructor for vehicle object with a vehicle identification number, a vehicle type, a model name and an amount
     * that indicates the value of the vehicle in CHF.
     * @param vin the vehicle identification number.
     * @param vehicleType the vehicle type
     * @param model the name of the vehicle's model
     * @param amount the value in CHF of the vehicle
     */
    public Vehicle(String vin, VehicleType vehicleType, String model, Double amount) {
        if (vin == null || vin.length() < 1 || vin.length() > 17 || vehicleType == null || model == null || model.length() < 1 || amount < 0) {
            throw new RuntimeException("Constructor Vehicle: insertion not valid.");
        }
        this.vin = vin;
        this.vehicleType = vehicleType;
        this.model = model;
        this.amount = amount;
    }

    /**
     * Getter of the vehicle identification number.
     * @return the vin
     */
    public String getVin() {
        return vin;
    }

    /**
     * Getter to get the category name of the vehicle's vehicle type.
     * @return the category name of the vehicle type.
     */
    public String getVehicleTypeCategory() {
        return vehicleType.getCategory();
    }
    
    /**
     * Getter to get a copy of the VehicleType of the vehicle.
     * @return a VehicleType object with the category like the vehicle.
     */
    public VehicleType getVehicleType() {
        VehicleType vt = new VehicleType(this.vehicleType.getCategory());
        return vt;
    }

    /**
     * Setter to set a new vehicleType.
     * @param vehicleType the vehicleType to set
     */
    public void setVehicleType(VehicleType vehicleType) {
        if (vehicleType != null) {
            this.vehicleType = vehicleType; 
        }
    }

    /**
     * Getter to get the vehicle's model name.
     * @return the model name of the vehicle.
     */
    public String getModel() {
        return model;
    }

    /**
     * Setter to set the vehicle's model name.
     * @param model the model name to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Getter to get the value of the vehicle.
     * @return the amount in CHF
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Setter for the value of the vehicle.
     * @param amount the amount to set in CHF.
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    
    
    
}
