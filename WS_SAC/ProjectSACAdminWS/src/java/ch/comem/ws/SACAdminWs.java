/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.ws;

import ch.comem.acs.model.VehicleType;
import ch.comem.controller.SACController;
import ch.comem.sac.model.Customer;
import ch.comem.sac.model.Issue;
import ch.comem.sac.model.Status;
import ch.comem.sac.model.Vehicle;
import ch.comem.transport.Convertisseurs;
import ch.comem.transport.CustomerTransport;
import ch.comem.transport.IssueTransport;
import ch.comem.transport.StatusTransport;
import ch.comem.transport.VehicleTransport;
import ch.comem.transport.VehicleTypeTransport;
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
        Issue issue = Convertisseurs.issueTransportToIssue(issueT);
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

    @WebMethod(operationName = "getVehicle")

    public VehicleTransport getVehicle(@WebParam(name = "idVehicule") String idvehicule) {

        VehicleTransport it = new VehicleTransport();
        Vehicle i = SACController.getVehicle(idvehicule);
        it = Convertisseurs.vehicleToVehicleTransport(i);
        return it;
    }

    @WebMethod(operationName = "getVehicles")
    public List<VehicleTransport> getVehicles() {

        List<VehicleTransport> listUt = new ArrayList<>();

        List<Vehicle> listeI = SACController.getVehicles();
        for (Vehicle i : listeI) {
            listUt.add(Convertisseurs.vehicleToVehicleTransport(i));
        }
        return listUt;
    }

    @WebMethod(operationName = "insertNewCustomer")
    public int insertNewCustomer(@WebParam(name = "Customer") CustomerTransport customerT) {
        int customerInsert = -1;
        Customer customer = Convertisseurs.customerTransportToCustomer(customerT);
        customerInsert = SACController.insertCustomer(customer);
        return customerInsert;
    }

    @WebMethod(operationName = "getvehicleType")

    public VehicleTypeTransport getvehicleType(@WebParam(name = "idVehicule") String category) {

        VehicleTypeTransport it = new VehicleTypeTransport();
        VehicleType i = SACController.getVehicleType(category);
        it = Convertisseurs.vehicleTypeToVehicleTypeTransport(i);
        return it;
    }

    @WebMethod(operationName = "getStatus")

    public StatusTransport getstatus(@WebParam(name = "idVehicule") String category) {

        StatusTransport it = new StatusTransport();
        Status i = SACController.getStatus(category);
        it = Convertisseurs.statusToStatusTransport(i);
        return it;
    }

    @WebMethod(operationName = "insertNewVehicleType")
    public int insertNewVehicleType(@WebParam(name = "VehicleType") VehicleTypeTransport vt) {
        int vehicleTypeInsert = -1;
        VehicleType vehicleType = Convertisseurs.vehicleTypeTransportToVehicleType(vt);
        vehicleTypeInsert = SACController.insertVehicleType(vehicleType);
        return vehicleTypeInsert;
    }

    @WebMethod(operationName = "insertNewVehicle")
    public int insertNewVehicle(@WebParam(name = "Vehicle") VehicleTransport vt) {
        int vehicleInsert = -1;
        Vehicle vehicle = Convertisseurs.vehicleTransportToVehicle(vt);
        vehicleInsert = SACController.insertVehicle(vehicle);
        return vehicleInsert;
    }

    @WebMethod(operationName = "updatePlateIssue")
    public IssueTransport updatePlateIssue(@WebParam(name = "issueId") int issueId, @WebParam(name = "numberPlate") String numberPlate) {
        Issue i = null;
        IssueTransport it = null;
        i = SACController.updatePlateIssue(issueId, numberPlate);
        it = Convertisseurs.issueToIssueTransport(i);
        return it;
    }

    @WebMethod(operationName = "updateStatusIssue")
    public IssueTransport updateStatusIssue(@WebParam(name = "issueId") int issueId, @WebParam(name = "status") String status) {
        Issue i = null;
        IssueTransport it = null;
        i = SACController.updateStatusIssue(issueId, status);
        it = Convertisseurs.issueToIssueTransport(i);
        return it;
    }

    @WebMethod(operationName = "handOutDateIssue")
    public IssueTransport handOutDateIssue(@WebParam(name = "issueId") int issueId, @WebParam(name = "handout") String handout) {
        Issue i = null;
        IssueTransport it = null;
        i = SACController.updateHandOutDateIssue(issueId, handout);
        it = Convertisseurs.issueToIssueTransport(i);
        return it;
    }

    @WebMethod(operationName = "closedDateIssue")
    public IssueTransport closedDateIssue(@WebParam(name = "issueId") int issueId, @WebParam(name = "closeDate") String closeDate) {
        Issue i = null;
        IssueTransport it = null;
        i = SACController.updateCloseIssueDate(issueId, closeDate);
        it = Convertisseurs.issueToIssueTransport(i);
        return it;
    }

}
