package com.example.danceSchoolBackend.controller;


import com.example.danceSchoolBackend.ResourceNotFoundException.ResourceNotFoundException;
import com.example.danceSchoolBackend.model.Contacts;
import com.example.danceSchoolBackend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/ap1/v1/")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;
    @GetMapping("contacts")
    public List<Contacts> getAllConatacts(){
        return contactRepository.findAll();
    }

    @PostMapping("contacts")
    public Contacts createContacts(@RequestBody Contacts contacts){
        return  contactRepository.save(contacts);
    }
    @GetMapping("contacts/{id}")
    public ResponseEntity<Contacts> getContactById(@PathVariable Long id){
        Contacts contacts = contactRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist id: "+id));

        return ResponseEntity.ok(contacts);
    }
    @DeleteMapping("contacts/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        Contacts contacts = contactRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist id: "+id));
        contactRepository.delete(contacts);
        Map<String,Boolean> response = new HashMap<>();
        return  ResponseEntity.ok(response);
    }




}
