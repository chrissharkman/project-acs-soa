/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.comem.sac.model;

/**
 * This class describes a customer with a his id (customer number) and a last name.
 * @author florent plomb
 */
public class Customer {
    
    private int id;
    private String lastname;
    
    /**
     * Constructor for customer object with a lastname. The id is set to 0.
     * @param lastname the lastname to set, length max 100.
     */
        public Customer(String lastname) {
        if ( lastname == null) throw new RuntimeException("lastname invalid");
        this.id = 0;
        this.lastname = lastname;
    }
/**
     * Constructor for customer object with an id and a lastname.
     * @param id the id of the customer if known. If not known, use constructor with String signature.
     * @param lastname the lastname of the customer.
     */
    public Customer(int id, String lastname) {
        if ( lastname == null || id <= 0) throw new RuntimeException("lastname invalid or id");
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
        this.id = id;
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
        this.lastname = lastname;
    }


    

}
