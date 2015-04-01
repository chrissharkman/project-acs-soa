
import ch.comem.controller.SACController;
import ch.comem.sac.model.Customer;
import ch.comem.sac.model.Issue;
import ch.comem.sac.model.Vehicle;
import java.util.ArrayList;

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
        Customer c1 = SACController.getCustomer(2);
        Vehicle  v1 = new Vehicle("CH111", "m1", "car");
        
        ArrayList<Issue> a =  SACController.getIssues();
        
        Issue i = SACController.getIssue(4);
        
        System.out.println(i.getCreatedDate());
        
      
      
     
        
        

        
    }

}
