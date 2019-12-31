package com.project.creditcard.controller;

import java.math.BigDecimal;
import java.math.MathContext;
import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.creditcard.model.CreditCard;
import com.project.creditcard.model.SavingAccount;
import com.project.creditcard.service.CreditCardService;

import reactor.core.publisher.Mono;

@RestController
public class CreditCardController {
	
	@Autowired
	private CreditCardService service;
	
    @PutMapping("/update-balance/{id}")
	public Mono<CreditCard> chargeConsumes(@Valid @RequestBody CreditCard creditcard, @PathVariable(value = "id") String id){
		
		//BigDecimal balance = creditcard.getBalance();
		//BigDecimal amount = creditcard.getAmount();
		    
		return service.findByCreditCardID(id).flatMap(c -> {
			 c.setBalance(c.getBalance().add(creditcard.getAmount()));		 
			 return service.saveCreditCard(c);
		});
			
	}
	
    @PutMapping("/update-balance2/{id}")
	public Mono<CreditCard> generateCreditCardPayments(@Valid @RequestBody CreditCard creditcard, @PathVariable(value = "id") String id){
		
		//BigDecimal totalAmount = creditcard.getTotalAmount();
		//BigDecimal minAmount = totalAmount.divide(BigDecimal.valueOf(36));
			
		return service.findByCreditCardID(id).flatMap(c -> {
			 //c.setTotalAmount(totalAmount.subtract(minAmount));	 
			 c.setTotalAmount(c.getTotalAmount().subtract(creditcard.getTotalAmount().divide(BigDecimal.valueOf(36), MathContext.DECIMAL128)));
			 
			 //BigDecimal result = num1.divide(num2, MathContext.DECIMAL128);
			 
			 return service.saveCreditCard(c);
		});
	}
	
    @PutMapping("/updatebalance1/{id}")
    Mono<SavingAccount> insertDeposit(SavingAccount savingaccount, String id){
    	
    	return service.insertDeposit(savingaccount, id);
    	
    }
    
    @PutMapping("/updatebalance2/{id}")
    Mono<SavingAccount> insertWithDraw(SavingAccount savingaccount, String id){
    	
    	return service.insertWithDraw(savingaccount, id);
    	
    }
}
