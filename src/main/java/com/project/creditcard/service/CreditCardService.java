package com.project.creditcard.service;

import com.project.creditcard.model.CreditCard;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardService {

	 Mono<CreditCard> generateCreditCard(CreditCard creditcard);
	 
	 Mono<CreditCard> saveCreditCard(CreditCard creditcard);
	 
	 Mono<CreditCard> chargeConsumesToCreditCard(CreditCard creditcard);
	 
	 Flux<CreditCard> showCreditCardBalance(String numberCreditCard);
	 
	 Mono<CreditCard> findByClientDni(String dni); 
	 
	 Mono<CreditCard> findByCreditCardID(String id);
	 
	 
}
