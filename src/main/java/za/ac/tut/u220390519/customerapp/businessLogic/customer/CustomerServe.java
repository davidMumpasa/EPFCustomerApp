package za.ac.tut.u220390519.customerapp.businessLogic.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.tut.u220390519.customerapp.model.customer.Customer;

import java.util.List;

@Service
public class CustomerServe {

    @Autowired
    CustomerRepository customerRepository;
    public void storeCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public List<Customer> getCustomers(){
       List<Customer> customers =  customerRepository.findAll();

       return customers;
    }

}
