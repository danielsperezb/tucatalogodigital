package com.ieti.project.web.controller;

import com.ieti.project.persistence.entity.BusinessEntity;
import com.ieti.project.persistence.entity.TemplateEntity;
import com.ieti.project.service.BusinessService;
import com.ieti.project.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/template")
public class TemplateController {

    private final TemplateService templateService;

    @Autowired
    public TemplateController(TemplateService templateService){
        this.templateService = templateService;
    }

    @GetMapping
    public ResponseEntity<List<TemplateEntity>> getAll(){
        return ResponseEntity.ok(this.templateService.getAll());
    }

    @GetMapping("/{templateId}")
    public ResponseEntity<TemplateEntity> get(@PathVariable int templateId){
        return ResponseEntity.ok(this.templateService.get(templateId));
    }

    @PostMapping
    public ResponseEntity<TemplateEntity> add(@RequestBody TemplateEntity template){
        if (template.getTemplateId() == null || !this.templateService.exists(template.getTemplateId())){
            return ResponseEntity.ok(this.templateService.save(template));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<TemplateEntity> update(@RequestBody TemplateEntity template){
        if (template.getTemplateId() != null && this.templateService.exists(template.getTemplateId())){
            return ResponseEntity.ok(this.templateService.save(template));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{templateId}")
    public ResponseEntity<Void> delete(@PathVariable int templateId){
        if (this.templateService.exists(templateId)){
            this.templateService.delete(templateId);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

}
