
package ch.comem.acs.transport;

/**
 * This class is the transport class of the status object.
 * @author christian heimann
 */
public class StatusTrans {

    private String mode;
    
    /**
     * Empty Construction for StatusTrans object.
     */
    public StatusTrans() {}

    /**
     * Getter for the mode String of the StatusTrans object.
     * @return the mode
     */
    public String getMode() {
        return mode;
    }

    /**
     * Getter of the mode of the StatusTrans object.
     * @param mode the mode to set
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

}