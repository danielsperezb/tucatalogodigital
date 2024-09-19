package com.ieti.project.service;

import com.ieti.project.persistence.entity.BusinessEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<BusinessEntity> getAll(){
        return this.contactRepository.findAll();
    }

    public BusinessEntity get(int businessId){
        return this.contactRepository.findById(businessId).orElse(null);
    }

    public BusinessEntity save(BusinessEntity business){
        return this.contactRepository.save(business);
    }

    public void delete(int businessId){
        this.contactRepository.deleteById(businessId);
    }

    public boolean exists(int businessId){
        return this.contactRepository.existsById(businessId);
    }
}
