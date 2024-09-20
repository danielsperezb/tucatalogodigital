package com.ieti.project.persistence.repository;

import com.ieti.project.persistence.entity.TransactionEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface TransactionRepository extends ListCrudRepository<TransactionEntity, Integer> {
}
