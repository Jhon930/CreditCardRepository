package com.project.creditcard.service;

import com.project.creditcard.model.CreditCard;
import com.project.creditcard.model.SavingAccount;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardService {
	 
	 Mono<CreditCard> saveCreditCard(CreditCard creditcard);
	 
	 Flux<CreditCard> showCreditCardBalance(String numberCreditCard);
	 
	 Mono<CreditCard> findByClientDni(String dni); 
	 
	 Mono<CreditCard> findByCreditCardID(String id);
	 
	 Mono<SavingAccount> insertDeposit(SavingAccount savingaccount, String id);
	 
	 Mono<SavingAccount> insertWithDraw(SavingAccount savingaccount, String id);
}
