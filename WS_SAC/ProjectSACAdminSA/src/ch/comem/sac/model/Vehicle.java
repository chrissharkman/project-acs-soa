/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.comem.sac.model;

import com.sun.xml.internal.bind.v2.util.TypeCast;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Vehicle {
    private String identificationNumber;
    private String model;
    private String typeCategory;

    public Vehicle(String identificationNumber, String model, String typeCategory) {
        if ( identificationNumber == null || model == null  || typeCategory == null) throw new RuntimeException("Vehicle invalid");
        this.identificationNumber = identificationNumber;
        this.model = model;
        this.typeCategory = typeCategory;
    }

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
