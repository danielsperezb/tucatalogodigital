package com.ieti.project.web.controller;



import com.ieti.project.persistence.entity.ImageProductEntity;
import com.ieti.project.service.ImageProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imageProduct")
public class ImageProductController {


    private final ImageProductService imageProductService;

    @Autowired
    public ImageProductController(ImageProductService imageProductService){
        this.imageProductService = imageProductService;
    }

    @GetMapping
        public ResponseEntity<List<ImageProductEntity>> getAll(){
        return ResponseEntity.ok(this.imageProductService.getAll());
    }

    @GetMapping("/{imageProductId}")
    public ResponseEntity<ImageProductEntity> get(@PathVariable int imageProductId){
        return ResponseEntity.ok(this.imageProductService.get(imageProductId));
    }

    @PostMapping
    public ResponseEntity<ImageProductEntity> add(@RequestBody ImageProductEntity imageProduct){
        if (imageProduct.getImagesProductId() == null || !this.imageProductService.exists(imageProduct.getImagesProductId())){
            return ResponseEntity.ok(this.imageProductService.save(imageProduct));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<ImageProductEntity> update(@RequestBody ImageProductEntity imageProduct){
        if (imageProduct.getImagesProductId() != null && this.imageProductService.exists(imageProduct.getImagesProductId())){
            return ResponseEntity.ok(this.imageProductService.save(imageProduct));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{imageProductId}")
    public ResponseEntity<Void> delete(@PathVariable int imageProductId){
        if (this.imageProductService.exists(imageProductId)){
            this.imageProductService.delete(imageProductId);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }



}
