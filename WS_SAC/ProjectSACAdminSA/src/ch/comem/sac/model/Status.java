/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.sac.model;

/**
 * 
 * This class manage the status 
 */

public class Status {
    
    private String mode ;

    public Status(String mode) {
        if (mode == null) throw new RuntimeException("mode invalide");
        this.mode = mode;
    }
    /**
     * @return the mode
     */
    public String getMode() {
        return mode;
    }


}
