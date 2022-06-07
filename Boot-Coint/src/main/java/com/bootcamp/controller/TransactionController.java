package com.bootcamp.controller;

import com.bootcamp.entities.Transaction;
import com.bootcamp.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;


    @GetMapping
    public ResponseEntity<Flux<Transaction>> findAll() {
        return ResponseEntity.ok(transactionService.findAll());
    }

    @GetMapping("/{id}")
    public Mono<Transaction> findById(@PathVariable String id) {
        return transactionService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Mono<Transaction>> save(@RequestBody Transaction transaction) {

        return ResponseEntity.ok(transactionService.save(transaction));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Transaction>> update(@RequestBody Transaction transaction, @PathVariable String id) {

        return transactionService.update(transaction, id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<String>> delete(@PathVariable String id) {
        return transactionService.delete(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
