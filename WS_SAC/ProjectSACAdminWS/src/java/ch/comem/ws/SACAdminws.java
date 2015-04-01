/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.ws;

import ch.comem.transport.Convertisseurs;
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
@WebService(serviceName = "SACAdminws")
@Stateless()
public class SACAdminws {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
      @WebMethod(operationName = "rendUtilisateursTransport")
    public List<UtilisateurTransport> rendUtilisateursTransport() {
        List<UtilisateurTransport> listeUt = new ArrayList<>();
        List<Utilisateur> listeU = ControlleurUtilisateurs.rendUtilisateurs();
        for (Utilisateur u : listeU) {
            listeUt.add(Convertisseurs.utilisateurToUtilisateurTransport(u));
        }
        return listeUt;
    }
    
    
}
