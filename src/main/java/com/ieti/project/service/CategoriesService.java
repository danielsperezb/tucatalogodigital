package com.ieti.project.service;

import com.ieti.project.persistence.entity.CategoriesEntity;
import com.ieti.project.persistence.repository.categoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {

    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public List<CategoriesEntity> getAll(){
        return this.categoriesRepository.findAll();
    }

    public CategoriesEntity get(int categoryId){
        return this.categoriesRepository.findById(categoryId).orElse(null);
    }

    public CategoriesEntity save(CategoriesEntity categories){
        return this.categoriesRepository.save(categories);
    }

    public void delete(int categoryId){
        this.categoriesRepository.deleteById(categoryId);
    }

    public boolean exists(int categoryId){
        return this.categoriesRepository.existsById(categoryId);
    }
}
