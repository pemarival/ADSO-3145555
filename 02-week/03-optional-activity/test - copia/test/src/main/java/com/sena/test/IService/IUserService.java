package com.sena.test.IService;

import java.util.List;

import com.sena.test.Dto.UserDto;

public interface IUserService {

    List<UserDto> findAll();
    UserDto findById(Long id);
    UserDto save(UserDto dto);
    UserDto update(Long id, UserDto dto);
    void delete(Long id);
    
}