package com.sena.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sena.test.Dto.PersonDto;
import com.sena.test.IService.IPersonService;

@RestController
@RequestMapping("/api/person")
@CrossOrigin("*")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping
    public List<PersonDto> getAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public PersonDto getById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PostMapping
    public PersonDto create(@RequestBody PersonDto dto) {
        return personService.save(dto);
    }

    @PutMapping("/{id}")
    public PersonDto update(@PathVariable Long id, @RequestBody PersonDto dto) {
        return personService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }
    
}