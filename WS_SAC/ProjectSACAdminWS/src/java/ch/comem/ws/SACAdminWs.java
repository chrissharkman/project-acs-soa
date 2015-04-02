/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.ws;

import ch.comem.sac.model.VehicleType;
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
 * This webservice manage a systeme for an insurence vehicule and auto service
 *
 * @author Florent Plomb
 */
@WebService(serviceName = "SACAdminWs")
@Stateless()
public class SACAdminWs {

    /**
     * issueT the issueTrans object, which will be saved via issue object in the
     * bd
     *
     * @param issueT the new issueT
     * @return tnumber of insert or -1 if insertion was not successful
     */
    @WebMethod(operationName = "insertNewIssue")
    public int insertNewIssue(@WebParam(name = "Issue") IssueTransport issueT) {
        int issueInsert = -1;
        Issue issue = Convertisseurs.issueTransportToIssue(issueT);
        issueInsert = SACController.insertNewIssue(issue);
        return issueInsert;
    }

    /**
     * Get all issue in a database
     *
     * @return a list of customer
     */
    @WebMethod(operationName = "getIssues")
    public List<IssueTransport> getIssues() {

        List<IssueTransport> listeIt = new ArrayList<>();
        List<Issue> listeI = SACController.getIssues();
        for (Issue i : listeI) {
            listeIt.add(Convertisseurs.issueToIssueTransport(i));
        }
        return listeIt;
    }

    /**
     * Get issue specifique in database
     *
     * @param idissue id of specific issue
     * @return an issue transport
     */

    @WebMethod(operationName = "getIssue")
    public IssueTransport getIssue(@WebParam(name = "issueId") int idissue) {

        IssueTransport it = new IssueTransport();
        Issue i = SACController.getIssue(idissue);

        it = Convertisseurs.issueToIssueTransport(i);
        return it;
    }

    /**
     * Get all customers in BD
     *
     * @return an list of customer
     */

    @WebMethod(operationName = "getCustomers")
    public List<CustomerTransport> getCustomers() {

        List<CustomerTransport> listUt = new ArrayList<>();

        List<Customer> listeI = SACController.getCustomers();
        for (Customer i : listeI) {
            listUt.add(Convertisseurs.customerToCustomerTransport(i));
        }
        return listUt;
    }

    /**
     * Get customer specific
     *
     * @param idiustomer id of customer specific
     * @return a customerTransport
     */

    @WebMethod(operationName = "getCustomer")
    public CustomerTransport getCustomer(@WebParam(name = "iustomerId") int idiustomer) {

        CustomerTransport it = new CustomerTransport();
        Customer i = SACController.getCustomer(idiustomer);
        it = Convertisseurs.customerToCustomerTransport(i);
        return it;
    }

    /**
     * get a speicifc vehicle
     *
     * @param idvehicule id of speicif vehicle
     * @return a vehicleTransport
     */
    @WebMethod(operationName = "getVehicle")

    public VehicleTransport getVehicle(@WebParam(name = "idVehicule") String idvehicule) {

        VehicleTransport it = new VehicleTransport();
        Vehicle i = SACController.getVehicle(idvehicule);
        it = Convertisseurs.vehicleToVehicleTransport(i);
        return it;
    }

    /**
     * Get all vehicle of database
     *
     * @return a list of vehicle
     */
    @WebMethod(operationName = "getVehicles")
    public List<VehicleTransport> getVehicles() {

        List<VehicleTransport> listUt = new ArrayList<>();

        List<Vehicle> listeI = SACController.getVehicles();
        for (Vehicle i : listeI) {
            listUt.add(Convertisseurs.vehicleToVehicleTransport(i));
        }
        return listUt;
    }

    /**
     * Insert a new customer in DB
     *
     * @param customerT the new customer
     * @return int of insert or -1 if not sucessfull
     */

    @WebMethod(operationName = "insertNewCustomer")
    public int insertNewCustomer(@WebParam(name = "Customer") CustomerTransport customerT) {
        int customerInsert = -1;
        Customer customer = Convertisseurs.customerTransportToCustomer(customerT);
        customerInsert = SACController.insertCustomer(customer);
        return customerInsert;
    }

    /**
     * get type og vehicle in DB
     *
     * @param category a category
     * @return a vehiculeType
     */
    @WebMethod(operationName = "getvehicleType")

    public VehicleTypeTransport getvehicleType(@WebParam(name = "idVehicule") String category) {

        VehicleTypeTransport it = new VehicleTypeTransport();
        VehicleType i = SACController.getVehicleType(category);
        it = Convertisseurs.vehicleTypeToVehicleTypeTransport(i);
        return it;
    }

    /**
     * Get a specific status in DB
     *
     * @param mode the mode
     * @return a statusTransport
     */

    @WebMethod(operationName = "getStatus")

    public StatusTransport getstatus(@WebParam(name = "idVehicule") String mode) {

        StatusTransport it = new StatusTransport();
        Status i = SACController.getStatus(mode);
        it = Convertisseurs.statusToStatusTransport(i);
        return it;
    }

    /**
     * insert a new vehicle type
     *
     * @param vt a new vechicletypeTransport
     * @return number of insert or -1 if insert not sucessfull
     */
    @WebMethod(operationName = "insertNewVehicleType")
    public int insertNewVehicleType(@WebParam(name = "VehicleType") VehicleTypeTransport vt) {
        int vehicleTypeInsert = -1;
        VehicleType vehicleType = Convertisseurs.vehicleTypeTransportToVehicleType(vt);
        vehicleTypeInsert = SACController.insertVehicleType(vehicleType);
        return vehicleTypeInsert;
    }

    /**
     * insert a new vehicle
     *
     * @param vt a new vehicle transport
     * @return number of insert or -1 if insert not sucessfull
     */

    @WebMethod(operationName = "insertNewVehicle")
    public int insertNewVehicle(@WebParam(name = "Vehicle") VehicleTransport vt) {
        int vehicleInsert = -1;
        Vehicle vehicle = Convertisseurs.vehicleTransportToVehicle(vt);
        vehicleInsert = SACController.insertVehicle(vehicle);
        return vehicleInsert;
    }

    /**
     * Update a numberplate of an issue
     *
     * @param issueId id of issue updated
     * @param numberPlate the numbeplate
     * @return issue updated
     */

    @WebMethod(operationName = "updatePlateIssue")
    public IssueTransport updatePlateIssue(@WebParam(name = "issueId") int issueId, @WebParam(name = "numberPlate") String numberPlate) {
        Issue i = null;
        IssueTransport it = null;
        i = SACController.updatePlateIssue(issueId, numberPlate);
        it = Convertisseurs.issueToIssueTransport(i);
        return it;
    }

    /**
     * Update a status of issue
     *
     * @param issueId issue updated
     * @param status new status
     * @return issuetransport updated
     */

    @WebMethod(operationName = "updateStatusIssue")
    public IssueTransport updateStatusIssue(@WebParam(name = "issueId") int issueId, @WebParam(name = "status") String status) {
        Issue i = null;
        IssueTransport it = null;
        i = SACController.updateStatusIssue(issueId, status);
        it = Convertisseurs.issueToIssueTransport(i);
        return it;
    }

    /**
     * issue handout updated
     *
     * @param issueId a issue updated
     * @param handout a new handout
     * @return issuetransport update
     */

    @WebMethod(operationName = "handOutDateIssue")
    public IssueTransport handOutDateIssue(@WebParam(name = "issueId") int issueId, @WebParam(name = "handout") String handout) {
        Issue i = null;
        IssueTransport it = null;
        i = SACController.updateHandOutDateIssue(issueId, handout);
        it = Convertisseurs.issueToIssueTransport(i);
        return it;
    }

    /**
     * update close date of issue
     *
     * @param issueId issue to update
     * @param closeDate a new closedate
     * @return issuetransport updated
     */
    @WebMethod(operationName = "closedDateIssue")
    public IssueTransport closedDateIssue(@WebParam(name = "issueId") int issueId, @WebParam(name = "closeDate") String closeDate) {
        Issue i = null;
        IssueTransport it = null;
        i = SACController.updateCloseIssueDate(issueId, closeDate);
        it = Convertisseurs.issueToIssueTransport(i);
        return it;
    }

}
