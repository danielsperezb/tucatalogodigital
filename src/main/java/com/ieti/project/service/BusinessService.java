package com.ieti.project.service;


import com.ieti.project.persistence.entity.BusinessEntity;
import com.ieti.project.persistence.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {

    private final BusinessRepository businessRepository;

    @Autowired
    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    public List<BusinessEntity> getAll(){
        return this.businessRepository.findAll();
    }

    public BusinessEntity get(int idPizza){
        return this.businessRepository.findById(idPizza).orElse(null);
    }

    public BusinessEntity save(BusinessEntity business){
        return this.businessRepository.save(business);
    }

    public boolean exists(int businessId){
        return this.businessRepository.existsById(businessId);
    }

}
