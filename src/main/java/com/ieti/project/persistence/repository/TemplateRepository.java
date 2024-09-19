package com.ieti.project.persistence.repository;

import com.ieti.project.persistence.entity.TemplateEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface TemplateRepository extends ListCrudRepository<TemplateEntity, Integer> {
}
