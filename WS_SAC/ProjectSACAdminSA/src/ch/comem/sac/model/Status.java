/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.sac.model;

/**
 * 
 * This class manage the status which has a mode name.
 */

public class Status {
    
    private String mode ;
    /**
     * Constructor of status which needs a mode name which length is not gte than 100
     * @param mode the mode name of the status
     */

    public Status(String mode) {
        if (mode == null) throw new RuntimeException("mode invalide");
        this.mode = mode;
    }
    /**
     * Getter of the status' mode.
     * @return the mode name of the status
     */
    public String getMode() {
        return mode;
    }


}
