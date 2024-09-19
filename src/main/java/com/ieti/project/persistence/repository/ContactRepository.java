package com.ieti.project.persistence.repository;

import com.ieti.project.persistence.entity.ContactEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ContactRepository extends ListCrudRepository<ContactEntity, Integer> {
}
