package com.ieti.project.persistence.repository;

import com.ieti.project.persistence.entity.CategoriesEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface CategoriesRepository extends ListCrudRepository<CategoriesEntity, Integer> {
}
