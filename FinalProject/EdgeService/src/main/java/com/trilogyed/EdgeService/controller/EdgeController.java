package com.trilogyed.EdgeService.controller;

import com.trilogyed.EdgeService.feign.CrudFeignClient;
import com.trilogyed.EdgeService.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class EdgeController {

    @Autowired
    CrudFeignClient client;



    @GetMapping ("/creditcard/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getByAcoountId(@PathVariable int id) {
        return client.getByAcoountId(id);
    }

    @PostMapping("/creditcard/debitfund/{debitfund}")
    @ResponseStatus(HttpStatus.CREATED)
    public BigDecimal addfundsToAccount (@PathVariable BigDecimal debitfund,
                                         @RequestParam int id) {

        BigDecimal accountBalane =  client.addfundsToAccount(debitfund, id);
        return accountBalane;
    }


}
