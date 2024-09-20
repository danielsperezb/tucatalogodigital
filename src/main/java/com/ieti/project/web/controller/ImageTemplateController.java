package com.ieti.project.web.controller;


import com.ieti.project.persistence.entity.ImageProductEntity;
import com.ieti.project.persistence.entity.ImageTemplateEntity;
import com.ieti.project.service.ImageProductService;
import com.ieti.project.service.ImageTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imageTemplate")
public class ImageTemplateController {

    private final ImageTemplateService imageTemplateService;

    @Autowired
    public ImageTemplateController(ImageTemplateService imageTemplateService){
        this.imageTemplateService = imageTemplateService;
    }

    @GetMapping
    public ResponseEntity<List<ImageTemplateEntity>> getAll(){
        return ResponseEntity.ok(this.imageTemplateService.getAll());
    }

    @GetMapping("/{imageProductId}")
    public ResponseEntity<ImageTemplateEntity> get(@PathVariable int imageTemplateId){
        return ResponseEntity.ok(this.imageTemplateService.get(imageTemplateId));
    }

    @PostMapping
    public ResponseEntity<ImageTemplateEntity> add(@RequestBody ImageTemplateEntity imageTemplate){
        if (imageTemplate.getImagesTemplateId() == null || !this.imageTemplateService.exists(imageTemplate.getImagesTemplateId())){
            return ResponseEntity.ok(this.imageTemplateService.save(imageTemplate));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<ImageTemplateEntity> update(@RequestBody ImageTemplateEntity imageTemplate){
        if (imageTemplate.getImagesTemplateId() != null && this.imageTemplateService.exists(imageTemplate.getImagesTemplateId())){
            return ResponseEntity.ok(this.imageTemplateService.save(imageTemplate));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{imageTemplateId}")
    public ResponseEntity<Void> delete(@PathVariable int imageTemplateId){
        if (this.imageTemplateService.exists(imageTemplateId)){
            this.imageTemplateService.delete(imageTemplateId);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }


}
