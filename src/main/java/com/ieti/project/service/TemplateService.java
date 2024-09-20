package com.ieti.project.service;

import com.ieti.project.persistence.entity.ProductsEntity;
import com.ieti.project.persistence.entity.TemplateEntity;
import com.ieti.project.persistence.repository.ProductsRepository;
import com.ieti.project.persistence.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {


    private final TemplateRepository templateRepository;

    @Autowired
    public TemplateService(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public List<TemplateEntity> getAll(){
        return this.templateRepository.findAll();
    }

    public TemplateEntity get(int templateId){
        return this.templateRepository.findById(templateId).orElse(null);
    }

    public TemplateEntity save(TemplateEntity template){
        return this.templateRepository.save(template);
    }

    public void delete(int templateId){
        this.templateRepository.deleteById(templateId);
    }

    public boolean exists(int templateId){
        return this.templateRepository.existsById(templateId);
    }


}
