package com.trilogyed.CreditCardService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.CreditCardService.dto.CreditCard;
import com.trilogyed.CreditCardService.service.ServiceLayer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CreditCardController.class)
public class CreditCardControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ServiceLayer service;


    private ObjectMapper mapper = new ObjectMapper();
    private String jsonObject;

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void shouldGetAccountBAlance() throws Exception {

           CreditCard creditCard = new CreditCard();
           creditCard.setCustomerAccount(4410);
           creditCard.setBalance(new BigDecimal(4000));
            BigDecimal balance = creditCard.getBalance();
            jsonObject = mapper.writeValueAsString(balance);

            when(service.getBalanceByAccountId(4410));
            mockMvc.perform(MockMvcRequestBuilders.get("/creditcard/id/{id}",4410)
                    .accept(APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect((ResultMatcher) content().json(jsonObject));
        }

    @Test
    public void shouldAddFundsToAccount() throws Exception {

        CreditCard creditCard = new CreditCard();
        creditCard.setCustomerAccount(4410);
        creditCard.setBalance(new BigDecimal(4000));
        BigDecimal balance = creditCard.getBalance();
        jsonObject = mapper.writeValueAsString(balance);

        when(service.addFunds(4410, new BigDecimal(2000)));
        mockMvc.perform(MockMvcRequestBuilders.get("/creditcard/debitfund/{debitfund}",2000)
                .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().json(jsonObject));
    }

}