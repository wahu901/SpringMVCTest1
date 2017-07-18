/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.Customer;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

/**
 *
 * @author Wayne.Hu
 */
//@Component
@Named
public class CustomerDao {
    @PersistenceContext private EntityManager em;
    
    @Transactional
    public void persist(Customer customer) {
        System.out.print("persist "+customer.getName());
        em.persist(customer);
    }
    
    public List<Customer> getAllCustomers() {
        TypedQuery<Customer> query = em.createQuery(
        "SELECT c FROM Customer c", Customer.class);
        return query.getResultList();
    }
    
}
