package com.ieti.project.service;

import com.ieti.project.dto.ImageProductDTO;
import com.ieti.project.persistence.entity.ImageProductEntity;
import com.ieti.project.persistence.repository.ImageProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ImageProductService {

    private final ImageProductRepository imageProductRepository;

    @Autowired
    public ImageProductService(ImageProductRepository imageProductRepository) {
        this.imageProductRepository = imageProductRepository;
    }

    public List<ImageProductDTO> getAll(){
        return this.imageProductRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ImageProductDTO get(int imagesProductId){
        return this.imageProductRepository.findById(imagesProductId)
                .map(this::convertToDTO)
                .orElseThrow(() -> new NoSuchElementException("Image Product not found with ID: " + imagesProductId));
    }

    public ImageProductDTO save(ImageProductEntity imageProduct){
        return convertToDTO(this.imageProductRepository.save(imageProduct));
    }

    public void delete(int imagesProductId){
        this.imageProductRepository.deleteById(imagesProductId);
    }

    public boolean exists(int imagesProductId){
        return this.imageProductRepository.existsById(imagesProductId);
    }

    private ImageProductDTO convertToDTO(ImageProductEntity entity) {
        return new ImageProductDTO(
                entity.getImagesProductId(),
                entity.getNameImg(),
                entity.getProductsEntity() != null ? entity.getProductsEntity().getProductId() : null
        );
    }

}
