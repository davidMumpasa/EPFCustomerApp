package za.ac.tut.u220390519.customerapp.model.customerIncome;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class CustomerIncome {

    @Id
    private String month;
    private String income;
    private String expenses;

    public CustomerIncome() {
    }

    public CustomerIncome(String month, String income, String expenses) {
        this.month = month;
        this.income = income;
        this.expenses = expenses;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getExpenses() {
        return expenses;
    }

    public void setExpense(String expenses) {
        this.expenses = expenses;
    }
}
