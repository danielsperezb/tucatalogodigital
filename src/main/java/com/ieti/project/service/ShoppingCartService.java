package com.ieti.project.service;


import com.ieti.project.dto.ShoppingCartDTO;
import com.ieti.project.persistence.entity.ShoppingCartEntity;
import com.ieti.project.persistence.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public List<ShoppingCartDTO> getAll(){
        return this.shoppingCartRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ShoppingCartDTO get(int shoppingCartId){
        return this.shoppingCartRepository.findById(shoppingCartId)
                .map(this::convertToDTO)
                .orElseThrow(() -> new NoSuchElementException("Shopping Cart not found with ID: " + shoppingCartId));
    }

    public ShoppingCartDTO save(ShoppingCartEntity products){
        return convertToDTO(this.shoppingCartRepository.save(products));
    }

    public void delete(int productsId){
        this.shoppingCartRepository.deleteById(productsId);
    }

    public boolean exists(int productsId){
        return this.shoppingCartRepository.existsById(productsId);
    }

    private ShoppingCartDTO convertToDTO(ShoppingCartEntity entity) {
        return new ShoppingCartDTO(
                entity.getShoppingCartId(),
                entity.getKeyCustomer()
        );
    }

}