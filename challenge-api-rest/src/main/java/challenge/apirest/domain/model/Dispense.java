package challenge.apirest.domain.model;

import java.time.LocalDate;

public class Dispense {
    private String medicine;
    private int quantityToDispense;
    private String nextWithdrawalDate;
    
    public String getMedicine() {
        return medicine;
    }

    public int getQuantityToDispense() {
        return quantityToDispense;
    }

    public String getNextWithdrawalDate() {
        return nextWithdrawalDate;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public void setQuantityToDispense(int quantityToDispense) {
        this.quantityToDispense = quantityToDispense;
    }
    
    public void setNextWithdrawalDate(String nextWithdrawalDate) {
        this.nextWithdrawalDate = nextWithdrawalDate;
    }
}
