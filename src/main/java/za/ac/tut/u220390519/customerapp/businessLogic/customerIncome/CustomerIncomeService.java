package za.ac.tut.u220390519.customerapp.businessLogic.customerIncome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.tut.u220390519.customerapp.model.customerIncome.CustomerIncome;

@Service
public class CustomerIncomeService {
    @Autowired
    CustomerIncomeRepository customerIncomeRepository;

    public void storeCustomerIncome(CustomerIncome customerIncome){
        customerIncomeRepository.save(customerIncome);
    }
}
