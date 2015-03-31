
package ch.comem.acs.model;

/**
 * This class describes a customer with a his id (customer number) and a last name.
 * @author christian heimann
 */
public class Customer {
    private int id;
    private String lastname;
    
    /**
     * Constructor for customer object with a lastname. The id is set to 0.
     * @param lastname the lastname to set, length max 100.
     */
    public Customer(String lastname) {
        if (lastname == null || lastname.length() > 100) {
            throw new RuntimeException("Customer object not valid: no lastname or lastname.length() > 100");
        }
        this.id = 0;
        this.lastname = lastname;
    }
    
    /**
     * Constructor for customer object with an id and a lastname.
     * @param id
     * @param lastname 
     */
    public Customer(int id, String lastname) {
        if (lastname == null || lastname.length() > 100 || id < 0) {
            throw new RuntimeException("Customer object not valid: no lastname, lastname.length() > 100 or id < 0");
        }
        this.id = id;
        this.lastname = lastname;
    }

    /**
     * Getter for customer id.
     * @return the id of the customer.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the id of the customer. The id cannot be lte than 0.
     * @param id the id to set to the customer.
     */
    public void setId(int id) {
        if (id <= 0) {
            this.id = id;
        }
    }

    /**
     * Getter for customer's lastname.
     * @return the lastname of the customer.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Setter for the lastname of the customer. The lenght of lastname cannot be gte than 100.
     * @param lastname the lastname to set to the customer.
     */
    public void setLastname(String lastname) {
        if (lastname != null && lastname.length() <= 100) {
            this.lastname = lastname;
        }
    }
    
    

}
