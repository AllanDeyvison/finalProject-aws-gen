package com.br.inocencio.controllers;

import com.br.inocencio.models.Themes;
import com.br.inocencio.repositories.ThemesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/themes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ThemesController {

    @Autowired
    private ThemesRepository repository;

    @GetMapping
    public ResponseEntity<List<Themes>> getThemes() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Themes> getById(@PathVariable Integer id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(
                ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Themes> publish(@RequestBody Themes themes){
        return ResponseEntity.status(201).body(repository.save(themes));
    }

    @PutMapping
    public ResponseEntity<Themes> edit(@RequestBody Themes themes){
        return ResponseEntity.status(201).body(repository.save(themes));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
