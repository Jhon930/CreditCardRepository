package com.project.creditcard.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.project.creditcard.model.CreditCard;

import reactor.core.publisher.Mono;

public interface CreditCardRepository extends ReactiveMongoRepository<CreditCard, String>{
	
    @Query(value="{'personClient.dni': ?0}", fields="{'personClient.dni':1}")	
	Mono<CreditCard> findByClientDni(String dni); 

}
