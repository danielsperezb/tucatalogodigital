package com.ieti.project.web.controller;

import com.ieti.project.dto.BusinessDTO;
import com.ieti.project.persistence.entity.BusinessEntity;
import com.ieti.project.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/business")
public class BusinessController {

    private final BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService){
        this.businessService = businessService;
    }

    @GetMapping
    public ResponseEntity<List<BusinessDTO>> getAll(){
        return ResponseEntity.ok(this.businessService.getAll());
    }

    @GetMapping("/{businessId}")
    public ResponseEntity<BusinessDTO> get(@PathVariable int businessId){
        return ResponseEntity.ok(this.businessService.get(businessId));
    }

    @PostMapping
    public ResponseEntity<BusinessDTO> add(@RequestBody BusinessEntity business){
        if (business.getBusinessId() == null || !this.businessService.exists(business.getBusinessId())){
            return ResponseEntity.ok(this.businessService.save(business));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<BusinessDTO> update(@RequestBody BusinessEntity business){
        if (business.getBusinessId() != null && this.businessService.exists(business.getBusinessId())){
            return ResponseEntity.ok(this.businessService.save(business));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{businessId}")
    public ResponseEntity<Void> delete(@PathVariable int businessId){
        if (this.businessService.exists(businessId)){
            this.businessService.delete(businessId);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

}
