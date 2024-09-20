package com.ieti.project.service;


import com.ieti.project.persistence.entity.TemplateEntity;
import com.ieti.project.persistence.entity.TransactionEntity;
import com.ieti.project.persistence.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionEntity> getAll(){
        return this.transactionRepository.findAll();
    }

    public TransactionEntity get(int templateId){
        return this.transactionRepository.findById(templateId).orElse(null);
    }

    public TransactionEntity save(TransactionEntity template){
        return this.transactionRepository.save(template);
    }

    public void delete(int templateId){
        this.transactionRepository.deleteById(templateId);
    }

    public boolean exists(int templateId){
        return this.transactionRepository.existsById(templateId);
    }
}
