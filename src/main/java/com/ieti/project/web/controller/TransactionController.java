package com.ieti.project.web.controller;

import com.ieti.project.persistence.entity.BusinessEntity;
import com.ieti.project.persistence.entity.TransactionEntity;
import com.ieti.project.service.BusinessService;
import com.ieti.project.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<List<TransactionEntity>> getAll(){
        return ResponseEntity.ok(this.transactionService.getAll());
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<TransactionEntity> get(@PathVariable int transactionId){
        return ResponseEntity.ok(this.transactionService.get(transactionId));
    }

    @PostMapping
    public ResponseEntity<TransactionEntity> add(@RequestBody TransactionEntity transaction){
        if (transaction.getTransactionId() == null || !this.transactionService.exists(transaction.getTransactionId())){
            return ResponseEntity.ok(this.transactionService.save(transaction));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<TransactionEntity> update(@RequestBody TransactionEntity transaction){
        if (transaction.getTransactionId() != null && this.transactionService.exists(transaction.getTransactionId())){
            return ResponseEntity.ok(this.transactionService.save(transaction));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{transactionId}")
    public ResponseEntity<Void> delete(@PathVariable int transactionId){
        if (this.transactionService.exists(transactionId)){
            this.transactionService.delete(transactionId);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
