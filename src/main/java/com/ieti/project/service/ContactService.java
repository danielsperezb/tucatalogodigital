package com.ieti.project.service;


import com.ieti.project.dto.ContactDTO;
import com.ieti.project.persistence.entity.ContactEntity;
import com.ieti.project.persistence.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<ContactDTO> getAll(){
        return this.contactRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ContactDTO get(int contactId){
        return this.contactRepository.findById(contactId)
                .map(this::convertToDTO)
                .orElseThrow(() -> new NoSuchElementException("Contact not found with ID: " + contactId));
    }

    public ContactDTO save(ContactEntity contact){
        return convertToDTO(this.contactRepository.save(contact));
    }

    public void delete(int contactId){
        this.contactRepository.deleteById(contactId);
    }

    public boolean exists(int contactId){
        return this.contactRepository.existsById(contactId);
    }

    private ContactDTO convertToDTO(ContactEntity entity) {
        return new ContactDTO(
                entity.getContactId(),
                entity.getContactValue(),
                entity.getContactType(),
                entity.getTemplateEntity() != null ? entity.getTemplateEntity().getTemplateId() : null
        );
    }

}
