package com.sena.test.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.test.Dto.PersonDto;
import com.sena.test.Entity.Person;
import com.sena.test.IRepository.IPersonRepository;
import com.sena.test.IService.IPersonService;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private IPersonRepository personRepository;

    private PersonDto convertToDto(Person person) {
        return new PersonDto(
                person.getIdPerson(),
                person.getFirstName(),
                person.getLastName(),
                person.getEmail()
        );
    }

    private Person convertToEntity(PersonDto dto) {
        Person person = new Person();
        person.setIdPerson(dto.getIdPerson());
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setEmail(dto.getEmail());
        return person;
    }

    @Override
    public List<PersonDto> findAll() {
        return personRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDto findById(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        return convertToDto(person);
    }

    @Override
    public PersonDto save(PersonDto dto) {
        Person person = convertToEntity(dto);
        Person savedPerson = personRepository.save(person);
        return convertToDto(savedPerson);
    }

    @Override
    public PersonDto update(Long id, PersonDto dto) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setEmail(dto.getEmail());

        Person updatedPerson = personRepository.save(person);
        return convertToDto(updatedPerson);
    }

    @Override
    public void delete(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        personRepository.delete(person);
    }
    
}