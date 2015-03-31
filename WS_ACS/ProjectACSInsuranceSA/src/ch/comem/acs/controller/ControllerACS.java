/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.acs.controller;

import ch.comem.acs.model.Status;
import java.util.ResourceBundle;

/**
 * The manager/controller class of the application service ACS.
 * @author christian heimann
 */
public class ControllerACS {
    
    public static void insertNewCertificate() {
        
    }
    
    public static void changeState(int certificateId, Status status) {
        
    }
    
    public static void modifyCertificate() {
    
    }
    
     
    
    /* PRIVATE METHODS */
    
    private static ResourceBundle propertiesLoader() {
        String dataPath = "ch.comem.acs.config.database";
        ResourceBundle prop = ResourceBundle.getBundle(dataPath);
        return prop;
    }
    
}
