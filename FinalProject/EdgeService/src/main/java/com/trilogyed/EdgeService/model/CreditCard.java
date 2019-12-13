package com.trilogyed.EdgeService.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.math.BigDecimal;
import java.util.Objects;

public class CreditCard {


    private int customerAccount ;
    private BigDecimal balance ;


    public CreditCard() {
    }

    public CreditCard(int customerAccount, BigDecimal balance) {
        this.customerAccount = customerAccount;
        this.balance = balance;
    }

    public int getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(int customerAccount) {
        this.customerAccount = customerAccount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "customerAccount=" + customerAccount +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return customerAccount == that.customerAccount &&
                Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerAccount, balance);
    }
}
