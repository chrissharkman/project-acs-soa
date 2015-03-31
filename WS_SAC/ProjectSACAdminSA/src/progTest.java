
import ch.comem.controller.SACController;
import ch.comem.sac.model.Vehicle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class progTest {
    
    public static void main(String[] args) {
        
        Vehicle  v1 = new Vehicle("CH999", "m9", "motos");
        System.out.println(SACController.insertVehicleType("scooter"));
        
    }

}
