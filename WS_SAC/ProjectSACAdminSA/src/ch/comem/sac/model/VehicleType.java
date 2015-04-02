
package ch.comem.sac.model;

/**
 * This class describes a vehicle type object, which has a category name that
 * describes the type.
 * @author Plomb Florent
 */
public class VehicleType {
    private String category;

    /**
     * Constructor of vehicle type object.
     * @param category The category name of the vehicle type, lenght must be gte than 0;
     */
    public VehicleType(String category) {
        if (category == null || category.length() < 1) {
            throw new RuntimeException("Category null or length < 1");
        }
        this.category = category;
    }

    /**
     * Getter to get the category name of the vehicle type.
     * @return the category name of the vehicle type.
     */
    public String getCategory() {
        return category;
    }
    
    
    
}
