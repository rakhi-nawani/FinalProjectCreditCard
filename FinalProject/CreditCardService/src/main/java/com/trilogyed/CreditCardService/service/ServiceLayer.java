package com.trilogyed.CreditCardService.service;

import com.trilogyed.CreditCardService.dao.CreditCardRepository;
import com.trilogyed.CreditCardService.dto.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ServiceLayer {

    @Autowired
    CreditCardRepository repo;

    public ServiceLayer() {
    }

    public ServiceLayer(CreditCardRepository repo) {
        this.repo = repo;
    }

        public BigDecimal addFunds(int  id, BigDecimal funds){

        CreditCard credit = repo.getOne(id);
        BigDecimal outputBalance = credit.getBalance().add(funds);

        return outputBalance;
        }

    public BigDecimal getBalanceByAccountId(int customerAccount){
        CreditCard creditCard = repo.getOne(customerAccount);
        BigDecimal curentBalance = creditCard.getBalance();
        return curentBalance;
    }
}
