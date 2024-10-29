package com.ieti.project.service;

import com.ieti.project.dto.TemplateDTO;
import com.ieti.project.persistence.entity.ProductsEntity;
import com.ieti.project.persistence.entity.TemplateEntity;
import com.ieti.project.persistence.repository.ProductsRepository;
import com.ieti.project.persistence.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class TemplateService {


    private final TemplateRepository templateRepository;

    @Autowired
    public TemplateService(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public List<TemplateDTO> getAll(){
        return this.templateRepository.findAll().stream()
                .map(this::convertToDTO) // Convertimos cada entidad a DTO
                .collect(Collectors.toList());
    }

    public TemplateDTO get(int templateId){
        return this.templateRepository.findById(templateId)
                .map(this::convertToDTO) // Convertimos la entidad a DTO si se encuentra
                .orElseThrow(() -> new NoSuchElementException("Template not found with ID: " + templateId));
    }

    public TemplateDTO save(TemplateEntity template){
        return convertToDTO(this.templateRepository.save(template));
    }

    public void delete(int templateId){
        this.templateRepository.deleteById(templateId);
    }

    public boolean exists(int templateId){
        return this.templateRepository.existsById(templateId);
    }

    private TemplateDTO convertToDTO(TemplateEntity entity) {
        return new TemplateDTO(
                entity.getTemplateId(),
                entity.getLogo(),
                entity.getSubtitleCategories(),
                entity.getSubtitlePictures(),
                entity.getSeccionOne(),
                entity.getSeccionTwo(),
                entity.getBusinessEntity() != null ? entity.getBusinessEntity().getBusinessId() : null
        );
    }
}
