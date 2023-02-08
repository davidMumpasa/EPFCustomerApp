package za.ac.tut.u220390519.customerapp.businessLogic.customerIncome;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.tut.u220390519.customerapp.model.customerIncome.CustomerIncome;

@Repository
public interface CustomerIncomeRepository extends JpaRepository<CustomerIncome,String> {

}
