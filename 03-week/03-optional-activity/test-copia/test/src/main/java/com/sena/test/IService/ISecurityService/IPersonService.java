package com.sena.test.IService.ISecurityService;

import java.util.List;

import com.sena.test.Dto.SecurityDto.PersonDto;

public interface IPersonService {

    List<PersonDto> findAll();
    PersonDto findById(Long id);
    PersonDto save(PersonDto dto);
    PersonDto update(Long id, PersonDto dto);
    void delete(Long id);

}