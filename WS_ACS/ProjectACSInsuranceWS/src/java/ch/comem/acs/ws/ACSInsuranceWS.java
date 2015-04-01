package ch.comem.acs.ws;

import ch.comem.acs.controller.ControllerACS;
import ch.comem.acs.model.Certificate;
import ch.comem.acs.model.Status;
import ch.comem.acs.transport.CertificateTrans;
import ch.comem.acs.transport.Converter;
import ch.comem.acs.transport.StatusTrans;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 * This Class contains all the possible operations of the web service.
 * Actually, the service proposes the following main functions:
 * <ul><li>createCertificate</li><li>changeStatus</li><li>modifyCertificate</li></ul>
 *
 * @author christian heimann
 */
@WebService(serviceName = "ACSInsuranceWS")
@Stateless()
public class ACSInsuranceWS {

    /**
     * Web service operation to create a new Certificate in the database.
     * @param certificateT the certificateTrans object, which will be saved via certificate object in the bd.
     * @return  the generated id of the inserted certificate, -1 if insertion was not successful. 
     */
    @WebMethod(operationName = "createCertificate")
    public int createCertificate(@WebParam(name = "certificate") CertificateTrans certificateT) {
        int certificateCreated = -1;
        if (certificateT != null) {
            Certificate certificate = Converter.certificateTransToCertificate(certificateT);
            certificateCreated = ControllerACS.insertNewCertificate(certificate);
        }
        return certificateCreated;
    }
    
    
    /**
     * Web service operation to change the Status of the given Certificate.
     * @param certificateId the id of the certificate to change.
     * @param statusT the new status to set.
     * @return 1 if change successful, -1 if change was not successful.
     */
    @WebMethod(operationName = "changeStatus")
    public int changeStatus(@WebParam(name = "certificateId") int certificateId, @WebParam(name = "status") StatusTrans statusT) {
        int statusChanged = -1;
        if (statusT != null) {
            Status status = Converter.statusTransToStatus(statusT);
            statusChanged = ControllerACS.changeState(certificateId, status);
        }
        return statusChanged;
    }

    /**
     * Web service operation to change the vehicle identification number of a
     * certificate.
     * @param certificateId the id of the certificate to change.
     * @param vin the new vehicle identification number.
     * @return 1 if change successful, -1 if change was not successful.
     */
    @WebMethod(operationName = "changeVin")
    public int changeVin(@WebParam(name = "certificateId") int certificateId, @WebParam(name = "vin") String vin) {
        int vinChanged = ControllerACS.changeVIN(certificateId, vin);
        return vinChanged;
    }

    /**
     * Web service operation to change a comment of a certificate.
     * @param certificateId the id of the certificate to change.
     * @param comment the new comment to set, which replaces the existing.
     * @return 1 if change successful, -1 if change was not successful.
     */
    @WebMethod(operationName = "changeComment")
    public Integer changeComment(@WebParam(name = "certificateId") int certificateId, @WebParam(name = "comment") String comment) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation to modify a certificate. This way a certificate can be changed on multiple fields.
     * @param certificateId the id of the certificate to change.
     * @param vin the vehicule identification number, a string. if null, vin is not modified.
     * @param comment the new comment to set. if null, comment is not modified.
     * @param statusT the ne status to set. if null, status is not modified.
     * @return 1 if updates was successful, 0 is nothing was modified, -1 if an error occured (Rollback included).
     */
    @WebMethod(operationName = "modifyCertificate")
    public int modifyCertificate(@WebParam(name = "certificateId") int certificateId, @WebParam(name = "vin") String vin, @WebParam(name = "comment") String comment, @WebParam(name = "status") StatusTrans statusT) {
        int modified = 0;
        Certificate originCertificate = ControllerACS.getCertificate(certificateId);
        if (vin != null) {
            modified = ControllerACS.changeVIN(certificateId, vin);
        }
        if (comment != null && modified >= 0) {
            modified = ControllerACS.changeComment(certificateId, comment);
        }
        if (statusT != null && modified >= 0) {
            Status status = Converter.statusTransToStatus(statusT);
            modified = ControllerACS.changeState(certificateId, status);
        }
        // Rollback
        if (modified == -1) {
            ControllerACS.changeVIN(certificateId, originCertificate.getVehicle().getVin());
            ControllerACS.changeComment(certificateId, originCertificate.getComment());
            ControllerACS.changeState(certificateId, new Status(originCertificate.getStatus()));
        }
        return modified;
    }

}
