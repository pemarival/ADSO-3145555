package com.sena.test.IService;

import java.util.List;
import com.sena.test.Dto.PersonDto;

public interface IPersonService {

    List<PersonDto> findAll();
    PersonDto findById(Long id);
    PersonDto save(PersonDto dto);
    PersonDto update(Long id, PersonDto dto);
    void delete(Long id);

}