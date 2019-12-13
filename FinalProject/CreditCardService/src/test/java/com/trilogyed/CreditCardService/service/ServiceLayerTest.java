package com.trilogyed.CreditCardService.service;

import com.trilogyed.CreditCardService.dao.CreditCardRepository;
import com.trilogyed.CreditCardService.dto.CreditCard;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;



public class ServiceLayerTest {

    private ServiceLayer serviceLayer;
    private CreditCardRepository repository;

    @Before
    public void  setUp() throws Exception{
        setUpRepoMock();

        serviceLayer = new ServiceLayer(repository);
    }

    private void setUpRepoMock() {
        repository = mock(CreditCardRepository.class);
        CreditCard creditcard  = new CreditCard();
        creditcard.setCustomerAccount(4410);
        creditcard.setBalance(new BigDecimal(2000));
        doReturn(creditcard).when(repository).getOne(4410);
        doReturn(creditcard).when(repository).save(creditcard);
    }

    @Test
    public void shouldReturnAccountBAlance(){
        CreditCard  input = new CreditCard();
        input.setCustomerAccount(4410);
        input.setBalance(new BigDecimal(2000));

        int id = input.getCustomerAccount();
        CreditCard  outPut = new CreditCard();
        outPut.setCustomerAccount(4410);
        outPut.setBalance(new BigDecimal(4000));

     BigDecimal outputbalance =  serviceLayer.addFunds(id, new BigDecimal(2000));
        assertEquals(outputbalance, 4000 );
    }

    @Test
    public void shouldreturnCurrentBalanceforGivenAccountId(){
        CreditCard  outPut = new CreditCard();
        outPut.setCustomerAccount(4410);
        outPut.setBalance(new BigDecimal(4000));

        BigDecimal outputbalance =  serviceLayer.getBalanceByAccountId(4410);
        assertEquals(outputbalance, 4000 );
    }
}

