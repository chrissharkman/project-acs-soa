package ch.comem.acs.ws;

import ch.comem.acs.controller.ControllerACS;
import ch.comem.acs.model.Status;
import ch.comem.acs.transport.Converter;
import ch.comem.acs.transport.StatusTrans;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 * This Class contains all the possible operations of the web service.
 *
 * @author christian heimann
 */
@WebService(serviceName = "ACSInsuranceWS")
@Stateless()
public class ACSInsuranceWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation to change the Status of the given Certificate.
     *
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
     *
     * @return 1 if change successful, -1 if change was not successful.
     */
    @WebMethod(operationName = "changeVin")
    public int changeVin(@WebParam(name = "certificateId") int certificateId, @WebParam(name = "vin") String vin) {
        int vinChanged = ControllerACS.changeVIN(certificateId, vin);
        return vinChanged;
    }

    /**
     * Web service operation to change a comment of a certificate.
     *
     * @return 1 if change successful, -1 if change was not successful.
     */
    @WebMethod(operationName = "changeComment")
    public Integer changeComment(@WebParam(name = "certificateId") int certificateId, @WebParam(name = "comment") String comment) {
        //TODO write your implementation code here:
        return null;
    }

    @WebMethod(operationName = "modifyCertificate")
    public int modifyCertificate(@WebParam(name = "certificateId") int certificateId, @WebParam(name = "vin") String vin, @WebParam(name = "comment") String comment, @WebParam(name = "status") StatusTrans statusT) {
        int modified = 0;
        ControllerACS.getCertificate(certificateId);
        if (vin != null) {
            modified = ControllerACS.changeVIN(certificateId, vin);
        }
        if (comment != null && modified >= 0) {
            modified = ControllerACS.changeComment(certificateId, comment);
        }
        if (statusT != null && modified >= 0) {

        }
        return modified;
    }

}
