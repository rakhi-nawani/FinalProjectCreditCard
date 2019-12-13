package com.trilogyed.EdgeService.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@FeignClient(name = "CreditCardService")
public interface CrudFeignClient {

    @GetMapping ("/creditcard/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getByAcoountId(@PathVariable int id);

    @PostMapping("/creditcard/debitfund/{debitfund}")
    @ResponseStatus(HttpStatus.CREATED)
    public BigDecimal addfundsToAccount (@PathVariable BigDecimal debitfund,
                                         @RequestParam int id);
    }


