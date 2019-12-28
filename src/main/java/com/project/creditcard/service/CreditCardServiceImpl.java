package com.project.creditcard.service;

import java.math.BigDecimal;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.project.creditcard.model.CreditCard;
import com.project.creditcard.repository.CreditCardRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CreditCardServiceImpl implements CreditCardService{
	
	@Autowired
	private WebClient client;
	
	@Autowired
	private CreditCardRepository repository;

	@Override
	public Mono<CreditCard> generateCreditCard(CreditCard creditcard) {
		
		return client.post()
				.uri("/insert")
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.body(BodyInserters.fromObject(creditcard))
				.retrieve()
				.bodyToMono(CreditCard.class);
		
	}

	@Override
	public Mono<CreditCard> chargeConsumesToCreditCard(CreditCard creditcard) {
		// TODO Auto-generated method stub
		return client.put()
				.uri("/update-balance")
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.syncBody(creditcard)
				.retrieve()
				.bodyToMono(CreditCard.class);
				
	}
	
	@Override
	public Mono<CreditCard> saveCreditCard(CreditCard creditcard) {
		// TODO Auto-generated method stub
		return repository.save(creditcard);
	}

	@Override
	public Flux<CreditCard> showCreditCardBalance(String numberCreditCard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<CreditCard> findByClientDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<CreditCard> findByCreditCardID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
