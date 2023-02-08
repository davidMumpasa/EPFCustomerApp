package za.ac.tut.u220390519.customerapp.model.customer;


import jakarta.persistence.*;
import za.ac.tut.u220390519.customerapp.model.customerIncome.CustomerIncome;


import java.util.Date;

@Entity
public class Customer {
    @Id
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private CustomerIncome customerIncome;

    public Customer(String firstName, String lastName, Date dateOfBirth, CustomerIncome customerIncome) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.customerIncome = customerIncome;
    }

    public Customer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public CustomerIncome getCustomerIncome() {
        return customerIncome;
    }

    public void setCustomerIncome(CustomerIncome customerIncome) {
        this.customerIncome = customerIncome;
    }
}
