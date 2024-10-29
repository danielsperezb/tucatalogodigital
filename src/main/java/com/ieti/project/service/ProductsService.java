package com.ieti.project.service;

import com.ieti.project.dto.ProductDTO;
import com.ieti.project.persistence.entity.ProductsEntity;
import com.ieti.project.persistence.entity.CategoriesEntity;
import com.ieti.project.persistence.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ProductsService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<ProductDTO> getAll() {
        return this.productsRepository.findAll().stream()
                .map(this::convertToDTO) // Convertimos cada entidad a DTO
                .collect(Collectors.toList());
    }

    public ProductDTO get(int productsId) {
        return this.productsRepository.findById(productsId)
                .map(this::convertToDTO)
                .orElseThrow(() -> new NoSuchElementException("Product not found with ID: " + productsId));
    }

    public ProductDTO save(ProductsEntity products) {
        return convertToDTO(this.productsRepository.save(products));
    }

    public void delete(int productsId) {
        this.productsRepository.deleteById(productsId);
    }

    public boolean exists(int productsId) {
        return this.productsRepository.existsById(productsId);
    }

    private ProductDTO convertToDTO(ProductsEntity entity) {
        return new ProductDTO(
                entity.getProductId(),
                entity.getTitle(),
                entity.getPrice(),
                entity.getDescription(),
                entity.getState(),
                entity.getQuantity(),
                entity.getCategories().stream()
                        .map(CategoriesEntity::getCategoryId)
                        .collect(Collectors.toSet())
        );

    }
}
