package com.ieti.project.persistence.repository;

import com.ieti.project.persistence.entity.ProductsEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductsRepository extends ListCrudRepository<ProductsEntity, Integer> {
}
