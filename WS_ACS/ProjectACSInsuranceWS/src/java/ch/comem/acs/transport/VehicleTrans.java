/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.acs.transport;

/**
 * This class is the vehicle trans class.
 * @author christian heimann
 */
public class VehicleTrans {
    private String vin;
    private VehicleTypeTrans vehicleType;
    private String model;
    private Double amount;
    
    /**
     * Constructor (empty) of VehicleTrans object.
     */
    public VehicleTrans() {};

    /**
     * Getter of the vehicle identification number of the vehicle.
     * @return the vin of the vehicle.
     */
    public String getVin() {
        return vin;
    }

    /**
     * @param vin the vin to set
     */
    public void setVin(String vin) {
        this.vin = vin;
    }

    /**
     * Getter of a copy of the VehicleTrans object.
     * @return the vehicleType
     */
    public VehicleTypeTrans getVehicleType() {
        VehicleTypeTrans vtt = new VehicleTypeTrans();
        vtt.setCategory(this.vehicleType.getCategory());
        return vtt;
    }

    /**
     * Setter for the VehicleTypeTrans property.
     * @param vehicleType the vehicleType to set.
     */
    public void setVehicleType(VehicleTypeTrans vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * Getter of the model property (car description) of VehicleTrans.
     * @return the model to set.
     */
    public String getModel() {
        return model;
    }

    /**
     * Setter for the model of the VehicleTrans object
     * @param model the model to set.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Getter of the value of the vehicleTrans object in CHF.
     * @return the amount in CHF
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Setter for the amount value of the vehicleTrans object.
     * @param amount the amount to set in CHF.
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    
}
