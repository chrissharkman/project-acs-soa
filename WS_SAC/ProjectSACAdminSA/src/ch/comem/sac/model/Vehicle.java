/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.comem.sac.model;



/**
 * /**
 * This class defines the vehicle object. A vehicle object has always the standardized
 * vehicule identification , a vehicle type, a model name.
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Vehicle {
    private String identificationNumber;
    private String model;
    private String typeCategory;
    
     /**
     * Constructor for vehicle object with a vehicle identification number, a vehicle type, a model name and an amount
     * that indicates the value of the vehicle in CHF.
     * @param identificationNumber the vehicle identification number.
     * @param vehicleType the vehicle type
     * @param model the name of the vehicle's model
     * 
     */

    public Vehicle(String identificationNumber, String model, String typeCategory) {
        if ( identificationNumber == null || model == null  || typeCategory == null) throw new RuntimeException("Vehicle invalid");
        this.identificationNumber = identificationNumber;
        this.model = model;
        this.typeCategory = typeCategory;
    }

    /**
     * Getter of the vehicle identification number.
     * @return the identificationNumber
     */
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * @param identificationNumber the identificationNumber to set
     */
    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * * Getter to get the category name of the vehicle's vehicle type.
     * @return the typeCategory
     */
    public String getTypeCategory() {
        return typeCategory;
    }

   /**
     * Setter to set a new vehicleType.
     * @param String the vehicleType to set
     */
    public void setTypeCategory(String typeCategory) {
        this.typeCategory = typeCategory;
    }
       
    

}
