package entities;

import java.util.Date;

public class Installments {

    private Date dueDate;
    private Double amount;
    private Contract contract;

    public Installments(Date dueDate, Double amount, Contract contract){
        this.setDueDate(dueDate);
        this.setAmount(amount);
        this.setContract(contract);
    }


    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
