/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.ws;

import ch.comem.controller.SACController;
import ch.comem.sac.model.Customer;
import ch.comem.sac.model.Issue;
import ch.comem.transport.Convertisseurs;
import ch.comem.transport.CustomerTransport;
import ch.comem.transport.IssueTransport;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@WebService(serviceName = "SACAdminWs")
@Stateless()
public class SACAdminWs {
    
   

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
      @WebMethod(operationName = "insertNewIssue")
    public int insertNewIssue(@WebParam(name = "Issue") IssueTransport issueT) {
        int issueInsert = -1;
        Issue issue =  Convertisseurs.issueTransportToIssue(issueT);          
        issueInsert = SACController.insertNewIssue(issue);        
        return issueInsert;
    }
       @WebMethod(operationName = "getIssues")
    public List<IssueTransport> getIssues() {
      
        List<IssueTransport> listeIt = new ArrayList<>();
        List<Issue> listeI = SACController.getIssues();
        for (Issue i : listeI) {
            listeIt.add(Convertisseurs.issueToIssueTransport(i));
        }
        return listeIt;
    }
    
      @WebMethod(operationName = "getIssue")
    public IssueTransport getIssue(@WebParam(name = "issueId") int idissue) {
      
        IssueTransport it = new IssueTransport();
        Issue i = SACController.getIssue(idissue);  
        
        it = Convertisseurs.issueToIssueTransport(i); 
        return it;
    }
    @WebMethod(operationName = "getCustomers")
     public List<CustomerTransport> getCustomers() {
      
        List<CustomerTransport> listUt = new ArrayList<>();
 
        List<Customer> listeI = SACController.getCustomers();
        for (Customer i : listeI) {
            listUt.add(Convertisseurs.customerToCustomerTransport(i));
        }
        return listUt;
    }
     
        @WebMethod(operationName = "getCustomer")
    public CustomerTransport getCustomer(@WebParam(name = "iustomerId") int idiustomer) {
      
        CustomerTransport it = new CustomerTransport();
        Customer i = SACController.getCustomer(idiustomer);         
        it = Convertisseurs.customerToCustomerTransport(i); 
        return it;
    }
    
}
