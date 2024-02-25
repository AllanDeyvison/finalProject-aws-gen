package com.br.inocencio.controllers;

import com.br.inocencio.models.Posts;
import com.br.inocencio.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostsController {

    @Autowired
    private PostsRepository repository;

    @GetMapping
    public ResponseEntity<List<Posts>> getPosts() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posts> getById(@PathVariable Integer id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(
                ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Posts> publish (@RequestBody Posts post){
        return ResponseEntity.status(201).body(repository.save(post));
    }

    @PutMapping
    public ResponseEntity<Posts> change (@RequestBody Posts post){
        return ResponseEntity.status(200).body(repository.save(post));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
       repository.deleteById(id);
    }
}
