package com.ieti.project.web.controller;

import com.ieti.project.persistence.entity.BusinessEntity;
import com.ieti.project.persistence.entity.ProductsEntity;
import com.ieti.project.service.BusinessService;
import com.ieti.project.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {


    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService){
        this.productsService = productsService;
    }

    @GetMapping
    public ResponseEntity<List<ProductsEntity>> getAll(){
        return ResponseEntity.ok(this.productsService.getAll());
    }

    @GetMapping("/{productsId}")
    public ResponseEntity<ProductsEntity> get(@PathVariable int productsId){
        return ResponseEntity.ok(this.productsService.get(productsId));
    }

    @PostMapping
    public ResponseEntity<ProductsEntity> add(@RequestBody ProductsEntity products){
        if (products.getProductId() == null || !this.productsService.exists(products.getProductId())){
            return ResponseEntity.ok(this.productsService.save(products));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<ProductsEntity> update(@RequestBody ProductsEntity products){
        if (products.getProductId() != null && this.productsService.exists(products.getProductId())){
            return ResponseEntity.ok(this.productsService.save(products));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> delete(@PathVariable int productId){
        if (this.productsService.exists(productId)){
            this.productsService.delete(productId);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
