package com.ieti.project.service;

import com.ieti.project.dto.ImageTemplateDTO;
import com.ieti.project.persistence.entity.ImageTemplateEntity;
import com.ieti.project.persistence.repository.ImageTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ImageTemplateService {

    private final ImageTemplateRepository imageTemplateRepository;

    @Autowired
    public ImageTemplateService(ImageTemplateRepository imageTemplateRepository) {
        this.imageTemplateRepository = imageTemplateRepository;
    }

    public List<ImageTemplateDTO> getAll(){
        return this.imageTemplateRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ImageTemplateDTO get(int imageTemplateId){
        return this.imageTemplateRepository.findById(imageTemplateId)
                .map(this::convertToDTO)
                .orElseThrow(() -> new NoSuchElementException("Image Template not found with ID: " + imageTemplateId));
    }

    public ImageTemplateDTO save(ImageTemplateEntity imageTemplate){
        return convertToDTO(this.imageTemplateRepository.save(imageTemplate));
    }

    public void delete(int imageTemplateId){
        this.imageTemplateRepository.deleteById(imageTemplateId);
    }

    public boolean exists(int imageTemplateId){
        return this.imageTemplateRepository.existsById(imageTemplateId);
    }

    private ImageTemplateDTO convertToDTO(ImageTemplateEntity entity) {
        return new ImageTemplateDTO(
                entity.getImagesTemplateId(),
                entity.getNameImg(),
                entity.getUrl(),
                entity.getTemplateEntity() != null ? entity.getTemplateEntity().getTemplateId() : null
        );
    }

}