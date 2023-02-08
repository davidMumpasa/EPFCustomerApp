package za.ac.tut.u220390519.customerapp.businessLogic.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.tut.u220390519.customerapp.model.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {

}
