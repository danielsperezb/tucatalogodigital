package com.ieti.project.service;


import com.ieti.project.dto.BusinessDTO;
import com.ieti.project.dto.CategoryDTO;
import com.ieti.project.persistence.entity.BusinessEntity;
import com.ieti.project.persistence.entity.ProductsEntity;
import com.ieti.project.persistence.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class BusinessService {

    private final BusinessRepository businessRepository;

    @Autowired
    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    public List<BusinessDTO> getAll(){
        List<BusinessDTO> listBusinessDTO = this.businessRepository.findAll().stream()
                                            .map(this::convertToDTO)
                                            .collect(Collectors.toList());
        return listBusinessDTO;
    }

    public BusinessDTO get(int businessId){
        BusinessDTO businessDTO = this.businessRepository.findById(businessId)
                                  .map(this::convertToDTO)
                                  .orElseThrow(() -> new NoSuchElementException("Business not found with ID: " + businessId));
        return businessDTO;
    }

    public BusinessDTO save(BusinessEntity business){

        return convertToDTO(this.businessRepository.save(business));
    }

    public void delete(int businessId){
        this.businessRepository.deleteById(businessId);
    }

    public boolean exists(int businessId){
        return this.businessRepository.existsById(businessId);
    }

    private BusinessDTO convertToDTO(BusinessEntity businessEntity) {
        return new BusinessDTO(
                businessEntity.getBusinessId(),
                businessEntity.getName(),
                businessEntity.getCreationDate(),
                businessEntity.getDeathDate(),
                businessEntity.getKey_code(),
                businessEntity.getCategories().stream()
                        .map(category -> new CategoryDTO(
                                category.getCategoryId(),
                                category.getName(),
                                category.getImgName(),
                                businessEntity.getBusinessId(),
                                category.getProducts().stream()
                                        .map(ProductsEntity::getProductId)
                                        .collect(Collectors.toSet())
                        ))
                        .toList()
        );
    }
}
