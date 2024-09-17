package com.ieti.project.persistence.repository;

import com.ieti.project.persistence.entity.BusinessEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface BusinessRepository extends ListCrudRepository<BusinessEntity, Integer> {

}
