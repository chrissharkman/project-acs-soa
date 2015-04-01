
import ch.comem.controller.SACController;
import ch.comem.sac.model.Customer;
import ch.comem.sac.model.Issue;
import ch.comem.sac.model.Vehicle;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Issue(String numberPlate, Customer customer, Vehicle vehicle, String status, String comment, Timestamp handOut, Timestamp closeIssueDate) {

 */

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class progTest {
    
    public static void main(String[] args) {
        
       
        System.out.println(SACController.updatePlateIssue(4, "holalal")); 

      
  
 
        
    }

}
