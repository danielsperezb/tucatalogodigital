package com.ieti.project.service;

import com.ieti.project.persistence.entity.ProductsEntity;
import com.ieti.project.persistence.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductsService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<ProductsEntity> getAll(){
        return this.productsRepository.findAll();
    }

    public ProductsEntity get(int productsId){
        return this.productsRepository.findById(productsId).orElse(null);
    }

    public ProductsEntity save(ProductsEntity products){
        return this.productsRepository.save(products);
    }

    public void delete(int productsId){
        this.productsRepository.deleteById(productsId);
    }

    public boolean exists(int productsId){
        return this.productsRepository.existsById(productsId);
    }

}
