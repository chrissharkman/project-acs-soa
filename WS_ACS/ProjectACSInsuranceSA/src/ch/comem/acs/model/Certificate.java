
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
    
    
}
