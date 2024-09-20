package com.ieti.project.persistence.repository;

import com.ieti.project.persistence.entity.ShoppingCartEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ShoppingCartRepository extends ListCrudRepository<ShoppingCartEntity, Integer> {
}
