package com.bootcamp.service;

import com.bootcamp.entities.Status;
import com.bootcamp.entities.Transaction;
import com.bootcamp.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {


    private final TransactionRepository transactionRepository;

    @Override
    public Flux<Transaction> findAll() {
        return transactionRepository.findAll();
    }


    @Override
    public Mono<Transaction> findById(String id) {
        return transactionRepository.findById(id);
    }


    @Override
    public Mono<Transaction> save(Transaction transaction) {
        transaction.setStatus(Status.PENDING);
        return transactionRepository.save(transaction);
    }


    @Override
    public Mono<Transaction> update(Transaction transaction, String id) {
        return transactionRepository.findById(id).flatMap(x->{
            x.setFromAccount(transaction.getFromAccount());
            x.setToAccount(transaction.getToAccount());
            x.setPaymentType(transaction.getPaymentType());
            x.setStatus(transaction.getStatus());
            x.setAmount(transaction.getAmount());
            return transactionRepository.save(x);
        });
    }


    @Override
    public Mono<String> delete(String id) {
        return transactionRepository.deleteById(id).thenReturn(id);
    }
}
