package com.ieti.project.persistence.repository;

import com.ieti.project.persistence.entity.ImageProductEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ImageProductRepository extends ListCrudRepository<ImageProductEntity, Integer> {
}
