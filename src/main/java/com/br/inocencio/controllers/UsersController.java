package com.br.inocencio.controllers;

import com.br.inocencio.models.Users;
import com.br.inocencio.repositories.UsersRepository;
import com.br.inocencio.services.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsersController {

    @Autowired
    private UsersRepository repository;

    @Autowired
    private RulesService service;


    @GetMapping
    public ResponseEntity<List<Users>> getUsers() {
        List<Users> usersList = repository.findAll();
        if (usersList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(usersList);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getById(@PathVariable Integer id) {

        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(
                ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Users> submit(@RequestBody  Users users){
        return service.existingUser(users)
                .map(existing -> ResponseEntity.ok(existing))
                .orElse(ResponseEntity.status(406).build());
    }

    @PutMapping
    public ResponseEntity<Users> change(@RequestBody Users users){
        return ResponseEntity.status(201).body(repository.save(users));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
