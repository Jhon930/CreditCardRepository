package com.project.creditcard.controller;

import java.math.BigDecimal;
import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.creditcard.model.CreditCard;
import com.project.creditcard.service.CreditCardService;

import reactor.core.publisher.Mono;

@RestController
public class CreditCardController {
	
	@Autowired
	private CreditCardService service;
	
	@GetMapping
	public Mono<ResponseEntity<CreditCard>> chargeConsumes(@Valid @RequestBody CreditCard creditcard, @PathVariable(value = "id") String id){
		
		BigDecimal balance = creditcard.getBalance();
		BigDecimal totalAmount = creditcard.getTotalAmount();
		    
		BigDecimal currentBalance = balance.add(totalAmount);
		
		BigDecimal b2 = new BigDecimal("4743.00001");
		
		BigDecimal limit = creditcard.getMaxLimit();
			
			return service.findByCreditCardID(id).flatMap(c -> {
				 c.setBalance(currentBalance);
				 return service.saveCreditCard(creditcard);
			})
			.map(c -> ResponseEntity.created(URI.create("/api/creditcard/".concat(c.getId())))
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(c))
			.defaultIfEmpty(ResponseEntity.notFound().build());
			
	}
	
	public Mono<ResponseEntity<CreditCard>> generateCreditCardPayments(@Valid @RequestBody CreditCard creditcard, @PathVariable(value = "id") String id){
		
		BigDecimal totalAmount = creditcard.getTotalAmount();
		BigDecimal minAmount = totalAmount.divide(BigDecimal.valueOf(36));
		
		BigDecimal newTotalAmount = totalAmount.subtract(minAmount);
		BigDecimal minAmount1 = newTotalAmount.divide(BigDecimal.valueOf(36));
		
		return service.findByCreditCardID(id).flatMap(c -> {
			 c.setMinAmount(minAmount1);
			 return service.saveCreditCard(creditcard);
		})
		.map(c -> ResponseEntity.created(URI.create("/api/creditcard/".concat(c.getId())))
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(c))
		.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
}
