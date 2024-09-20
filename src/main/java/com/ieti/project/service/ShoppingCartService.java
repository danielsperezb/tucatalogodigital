package com.ieti.project.service;


import com.ieti.project.persistence.entity.ShoppingCartEntity;
import com.ieti.project.persistence.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public List<ShoppingCartEntity> getAll(){
        return this.shoppingCartRepository.findAll();
    }

    public ShoppingCartEntity get(int shoppingCartId){
        return this.shoppingCartRepository.findById(shoppingCartId).orElse(null);
    }

    public ShoppingCartEntity save(ShoppingCartEntity products){
        return this.shoppingCartRepository.save(products);
    }

    public void delete(int productsId){
        this.shoppingCartRepository.deleteById(productsId);
    }

    public boolean exists(int productsId){
        return this.shoppingCartRepository.existsById(productsId);
    }


}
