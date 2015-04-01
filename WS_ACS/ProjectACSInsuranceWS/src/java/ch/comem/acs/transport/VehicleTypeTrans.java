
package ch.comem.acs.transport;

/**
 * This class is the vehicle type transport class.
 * @author christian heimann
 */
public class VehicleTypeTrans {
    private String category;
    
    /**
     * Empty constructor of vehicleTypeTrans object.
     */
    public VehicleTypeTrans() {};

    /**
     * Getter of the category string.
     * @return the category of the VehicleType.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter for the category string.
     * @param category the category to set.
     */
    public void setCategory(String category) {
        this.category = category;
    }

}
