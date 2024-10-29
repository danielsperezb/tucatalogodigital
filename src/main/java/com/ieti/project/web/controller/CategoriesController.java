package com.ieti.project.web.controller;

import com.ieti.project.dto.CategoryDTO;
import com.ieti.project.persistence.entity.CategoriesEntity;
import com.ieti.project.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    private final CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService){
        this.categoriesService = categoriesService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAll(){
        return ResponseEntity.ok(this.categoriesService.getAll());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> get(@PathVariable int categoryId){
        return ResponseEntity.ok(this.categoriesService.get(categoryId));
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> add(@RequestBody CategoriesEntity categories){
        if (categories.getCategoryId() == null || !this.categoriesService.exists(categories.getCategoryId())){
            return ResponseEntity.ok(this.categoriesService.save(categories));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<CategoryDTO> update(@RequestBody CategoriesEntity categories){
        if (categories.getCategoryId() != null && this.categoriesService.exists(categories.getCategoryId())){
            return ResponseEntity.ok(this.categoriesService.save(categories));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> delete(@PathVariable int categoryId){
        if (this.categoriesService.exists(categoryId)){
            this.categoriesService.delete(categoryId);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }


}
