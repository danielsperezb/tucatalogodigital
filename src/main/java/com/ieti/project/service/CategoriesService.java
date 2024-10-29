package com.ieti.project.service;

import com.ieti.project.dto.CategoryDTO;
import com.ieti.project.persistence.entity.CategoriesEntity;
import com.ieti.project.persistence.entity.ProductsEntity;
import com.ieti.project.persistence.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CategoriesService {

    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public List<CategoryDTO> getAll(){

        return this.categoriesRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO get(int categoryId){
        return this.categoriesRepository.findById(categoryId)
                .map(this::convertToDTO)
                .orElseThrow(() -> new NoSuchElementException("Category not found with ID: " + categoryId));
    }

    public CategoryDTO save(CategoriesEntity categories){
        return convertToDTO(this.categoriesRepository.save(categories));
    }

    public void delete(int categoryId){
        this.categoriesRepository.deleteById(categoryId);
    }

    public boolean exists(int categoryId){
        return this.categoriesRepository.existsById(categoryId);
    }

    private CategoryDTO convertToDTO(CategoriesEntity entity) {
        return new CategoryDTO(
                entity.getCategoryId(),
                entity.getName(),
                entity.getImgName(),
                entity.getBusiness() != null ? entity.getBusiness().getBusinessId() : null,
                entity.getProducts().stream()
                        .map(ProductsEntity::getProductId)
                        .collect(Collectors.toSet())
        );
    }
}
