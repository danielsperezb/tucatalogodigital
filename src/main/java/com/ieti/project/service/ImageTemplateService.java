package com.ieti.project.service;

import com.ieti.project.persistence.entity.ImageTemplateEntity;
import com.ieti.project.persistence.repository.ImageTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageTemplateService {

    private final ImageTemplateRepository imageTemplateRepository;

    @Autowired
    public ImageTemplateService(ImageTemplateRepository imageTemplateRepository) {
        this.imageTemplateRepository = imageTemplateRepository;
    }

    public List<ImageTemplateEntity> getAll(){
        return this.imageTemplateRepository.findAll();
    }

    public ImageTemplateEntity get(int imageTemplateId){
        return this.imageTemplateRepository.findById(imageTemplateId).orElse(null);
    }

    public ImageTemplateEntity save(ImageTemplateEntity imageTemplate){
        return this.imageTemplateRepository.save(imageTemplate);
    }

    public void delete(int imageTemplateId){
        this.imageTemplateRepository.deleteById(imageTemplateId);
    }

    public boolean exists(int imageTemplateId){
        return this.imageTemplateRepository.existsById(imageTemplateId);
    }

}