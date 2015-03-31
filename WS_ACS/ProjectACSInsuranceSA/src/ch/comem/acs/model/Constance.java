/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.acs.model;

/**
 * This class reflects artificial Constance objects.
 * Each Constance has a keyValue, which is the main value to retain,
 * a description of the value what is means, and a technical id.
 * @author christian heimann
 */
public class Constance {
    private int id;
    private String keyValue;
    private String description;

    /**
     * Constructor for Constance object with keyValue and description parameters.
     * The id of the object is automatically set to 0.
     * @param keyValue the value of the constant.
     * @param description the description of the value.
     */
    public Constance(String keyValue, String description) {
        if (keyValue == null || description == null || description.length() > 200) {
            throw new RuntimeException("Constructor Constance: keyValue or description not valid.");
        }
        this.keyValue = keyValue;
        this.description = description; 
        this.id = 0;
    }

    /**
     * Constructor for Constance object with id, keyValue and description parameters.
     * @param id the id of the constance, necessarily > 0. This is a purely technical identifier.
     * @param keyValue the value of the constant.
     * @param description  the description of the value.
     */
    public Constance(int id, String keyValue, String description) {
        if (id <= 0 || keyValue == null || description == null || description.length() > 200) {
            throw new RuntimeException("Constructor Constance: id, keyValue or description not valid.");
        }
        this.id = id;
        this.keyValue = keyValue;
        this.description = description;
    }

    /**
     * Getter of the id of the Constance object.
     * @return the id of the Constance.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter of the keyValue of the Constance object.
     * @return the keyValue of the Constance as String, event when it could be a number.
     */
    public String getKeyValue() {
        return keyValue;
    }

    /**
     * Getter of the description of the Constance object.
     * @return the description of the Constance as String.
     */
    public String getDescription() {
        return description;
    }
    
    
}
