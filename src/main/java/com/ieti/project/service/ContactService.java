package com.ieti.project.service;


import com.ieti.project.persistence.entity.ContactEntity;
import com.ieti.project.persistence.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<ContactEntity> getAll(){
        return this.contactRepository.findAll();
    }

    public ContactEntity get(int contactId){
        return this.contactRepository.findById(contactId).orElse(null);
    }

    public ContactEntity save(ContactEntity contact){
        return this.contactRepository.save(contact);
    }

    public void delete(int contactId){
        this.contactRepository.deleteById(contactId);
    }

    public boolean exists(int contactId){
        return this.contactRepository.existsById(contactId);
    }
}
