/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.comem.transport;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class VehicleTransport {
    
    private String identificationNumber;
    private String model;
    private String typeCategory;

    /**
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
     * @return the typeCategory
     */
    public String getTypeCategory() {
        return typeCategory;
    }

    /**
     * @param typeCategory the typeCategory to set
     */
    public void setTypeCategory(String typeCategory) {
        this.typeCategory = typeCategory;
    }


}
