
package ch.comem.acs.model;

/**
 * This class describes a certificate object with all the necessary indications
 * like id, customer, vehicle, status and comment.
 * @author christian heimann
 */
public class Certificate {
    private int id;
    private Customer customer;
    private Vehicle vehicle;
    private Status status;
    private String comment;

    /**
     * Constructor to create a certificate belonging to a customer and a vehicule,
     * having a status (e.g. approved, refused) and a comment.
     * @param customer The customer for whom the certificate is for.
     * @param vehicle The vehicle for what the certificate is for.
     * @param status The status of the certificate.
     * @param comment Any comment to this certificate.
     */
    public Certificate(Customer customer, Vehicle vehicle, Status status, String comment) {
        if (customer == null || vehicle == null || status == null) {
            throw new RuntimeException("Customer, vehicle or status object is null.");
        }
        if (comment.length() > 400) {
            throw new RuntimeException("Comment too long.");
        }
        this.id = 0;
        this.customer = customer;
        this.vehicle = vehicle;
        this.status = status;
        this.comment = comment;
    }
    
    /**
     * Constructor to create a certificate with a known id, belonging to a customer and a vehicule,
     * having a status (e.g. approved, refused) and a comment.
     * @param id The id of a certificate when known.
     * @param customer The customer for whom the certificate is for.
     * @param vehicle The vehicle for what the certificate is for.
     * @param status The status of the certificate.
     * @param comment Any comment to this certificate.
     */
    public Certificate(int id, Customer customer, Vehicle vehicle, Status status, String comment) {
        if (customer == null || vehicle == null || status == null) {
            throw new RuntimeException("Customer, vehicle or status object is null.");
        }
        if (comment.length() > 400) {
            throw new RuntimeException("Comment too long.");
        }
        this.id = id;
        this.customer = customer;
        this.vehicle = vehicle;
        this.status = status;
        this.comment = comment;
    }

    /**
     * Getter of the id of the certificate.
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter to set the id of a certificate.
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter of the customer's id attributed to the certificate.
     * @return the customer's id whose certificate it is.
     */
    public int getCustomerId() {
        return customer.getId();
    }

    /**
     * Getter of the vehicle identification number attributed to the certificate.
     * @return the vehicle identification number.
     */
    public String getVehicleVin() {
        return vehicle.getVin();
    }

    /**
     * Setter to set a new vehicle to the certificate.
     * @param vehicle the vehicle to set
     */
    public void setVehicle(Vehicle vehicle) {
        if (vehicle != null) {
            this.vehicle = vehicle;            
        }
    }

    /**
     * Getter to get the status' mode name.
     * @return the status mode name.
     */
    public String getStatus() {
        return status.getMode();
    }

    /**
     * Setter to set a new status to the certificate.
     * @param status the status to set.
     */
    public void setStatus(Status status) {
        if (status != null) {
            this.status = status;
        }    
    }

    /**
     * Getter to get the comment of the certificate.
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Setter to set a new or modified comment to the certificate.
     * This setter replaces any existing comment.
     * @param comment the comment to set.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
}
