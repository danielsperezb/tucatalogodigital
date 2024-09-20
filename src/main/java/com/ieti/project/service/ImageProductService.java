package com.ieti.project.service;

import com.ieti.project.persistence.entity.ImageProductEntity;
import com.ieti.project.persistence.repository.ImageProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageProductService {

    private final ImageProductRepository imageProductRepository;

    @Autowired
    public ImageProductService(ImageProductRepository imageProductRepository) {
        this.imageProductRepository = imageProductRepository;
    }

    public List<ImageProductEntity> getAll(){
        return this.imageProductRepository.findAll();
    }

    public ImageProductEntity get(int imagesProductId){
        return this.imageProductRepository.findById(imagesProductId).orElse(null);
    }

    public ImageProductEntity save(ImageProductEntity imageProduct){
        return this.imageProductRepository.save(imageProduct);
    }

    public void delete(int imagesProductId){
        this.imageProductRepository.deleteById(imagesProductId);
    }

    public boolean exists(int imagesProductId){
        return this.imageProductRepository.existsById(imagesProductId);
    }

}
