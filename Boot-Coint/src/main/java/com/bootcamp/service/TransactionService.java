package com.bootcamp.service;

import com.bootcamp.entities.Transaction;
import com.bootcamp.entities.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {

    Flux<Transaction> findAll();
    Mono<Transaction> findById(String id);
    Mono<Transaction> save(Transaction transaction);
    Mono<Transaction> update(Transaction transaction,String id);
    Mono<String> delete(String id);
}
