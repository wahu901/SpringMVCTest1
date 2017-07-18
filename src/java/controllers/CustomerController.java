/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.Customer;
import controllers.CustomerDao;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Wayne.Hu
 */
@Controller
public class CustomerController {
    //@Autowired
    @Inject
    private CustomerDao customerDao;
    
    @RequestMapping(value="/customerList.htm")
    public ModelAndView customerList(HttpServletRequest request) {
        String name = request.getParameter("name");
      
       /*
        for (Customer customer : customerDao.getAllCustomers()) { 
            System.out.println("name="+customer.getName());
        }*/            
        return new ModelAndView("customerList", "customerList", customerDao.getAllCustomers());
       
    }
    
    @RequestMapping(value = "/addCustomerForm", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("addCustomerForm", "customer", new Customer());
    }
    
    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public ModelAndView submit(@Valid @ModelAttribute("customer")Customer customer, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return new ModelAndView("error", "customer", customer);
        }
  
        
        if (customer != null) {
            System.out.println("name="+customer.getName());
             System.out.println("id="+customer.getCustomerId());
             System.out.println("email="+customer.getEmail());
             //customer.setDiscountCode(DiscountCode.);
            customerDao.persist(customer);
        }
        return new ModelAndView("customerList", "customerList", customerDao.getAllCustomers());
    }
}
