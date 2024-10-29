package com.ieti.project.web.controller;

import com.ieti.project.dto.ContactDTO;
import com.ieti.project.persistence.entity.ContactEntity;
import com.ieti.project.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<List<ContactDTO>> getAll(){
        return ResponseEntity.ok(this.contactService.getAll());
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<ContactDTO> get(@PathVariable int contactId){
        return ResponseEntity.ok(this.contactService.get(contactId));
    }

    @PostMapping
    public ResponseEntity<ContactDTO> add(@RequestBody ContactEntity contact){
        if (contact.getContactId() == null || !this.contactService.exists(contact.getContactId())){
            return ResponseEntity.ok(this.contactService.save(contact));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<ContactDTO> update(@RequestBody ContactEntity contact){
        if (contact.getContactId() != null && this.contactService.exists(contact.getContactId())){
            return ResponseEntity.ok(this.contactService.save(contact));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<Void> delete(@PathVariable int contactId){
        if (this.contactService.exists(contactId)){
            this.contactService.delete(contactId);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }



}
