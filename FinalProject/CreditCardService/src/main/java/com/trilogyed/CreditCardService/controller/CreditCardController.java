package com.trilogyed.CreditCardService.controller;

import com.trilogyed.CreditCardService.NotFoundException;
import com.trilogyed.CreditCardService.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class CreditCardController {

    @Autowired
    ServiceLayer serviceLayer;


    @GetMapping ("/creditcard/id/{id}")
    @ResponseStatus (HttpStatus.OK)
    public BigDecimal getByAcoountId(@PathVariable int id) {
        if (id < 0 ) {
            throw new NotFoundException("Customer ID is not Present");
        }
        return serviceLayer.getBalanceByAccountId(id);
    }

    @PostMapping("/creditcard/debitfund/{debitfund}")
    @ResponseStatus(HttpStatus.CREATED)
    public BigDecimal addfundsToAccount (@PathVariable BigDecimal debitfund,
                                         @RequestParam int id) {

        BigDecimal accountBalane =  serviceLayer.addFunds(id , debitfund);
        return accountBalane;
    }




}
