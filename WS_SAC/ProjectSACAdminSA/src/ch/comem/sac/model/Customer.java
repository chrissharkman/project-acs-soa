/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.comem.sac.model;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Customer {
    
    private int id;
    private String lastname;
    
        public Customer(String lastname) {
        if ( lastname == null) throw new RuntimeException("lastname invalid");
        this.id = 0;
        this.lastname = lastname;
    }

    public Customer(int id, String lastname) {
        if ( lastname == null || id <= 0) throw new RuntimeException("lastname invalid or id");
        this.id = id;
        this.lastname = lastname;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    

}
