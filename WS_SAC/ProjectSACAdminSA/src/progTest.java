
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
        SACController.UpdateCloseIssueDate(3,"2002-04-01 08:58:09");
        
 
//        Customer c1 = SACController.getCustomer(2);
//        Vehicle  v1 = SACController.getVehicle("CH11");
//        
//        Issue i = SACController.getIssue(3);
//        
//        System.out.println(i.getCustomer().getId());
//        
//        ArrayList<Customer> a =  SACController.getCustomers();
//        
//        System.out.println(c1.getId());
        
//        Vehicle v = SACController.getVehicle("CH111");
//        
//        
//      
//        
//        System.out.println(v.getTypeCategory());
        
//        for (Customer ai : a) {
//            
//            System.out.println("ai = " + ai.getId());
//            
//        }
        
      
  
 
        
    }

}
