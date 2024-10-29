package com.ieti.project.service;


import com.ieti.project.dto.TransactionDTO;
import com.ieti.project.persistence.entity.TemplateEntity;
import com.ieti.project.persistence.entity.TransactionEntity;
import com.ieti.project.persistence.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionDTO> getAll(){
        return this.transactionRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TransactionDTO get(int transactionId){
        return this.transactionRepository.findById(transactionId)
                .map(this::convertToDTO)
                .orElseThrow(() -> new NoSuchElementException("Transaction not found with ID: " + transactionId));
    }

    public TransactionDTO save(TransactionEntity template){
        return convertToDTO(this.transactionRepository.save(template));
    }

    public void delete(int templateId){
        this.transactionRepository.deleteById(templateId);
    }

    public boolean exists(int templateId){
        return this.transactionRepository.existsById(templateId);
    }

    private TransactionDTO convertToDTO(TransactionEntity entity) {
        return new TransactionDTO(
                entity.getTransactionId(),
                entity.getReferenceTransaction(),
                entity.getPCustIdCliente(),
                entity.getPKey(),
                entity.getConstumerName(),
                entity.getConstumerPhone(),
                entity.getShippingDirection(),
                entity.getShippingDepartament(),
                entity.getShippingMunicipality(),
                entity.getAmountBusinees(),
                entity.getAmountShip(),
                entity.getAmountComission(),
                entity.getAmountTotal()
        );
    }
}