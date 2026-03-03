package com.sena.test.IService.ISecurityService;

import java.util.List;

import com.sena.test.Dto.SecurityDto.UserRoleDto;

public interface IUserRoleService {

    List<UserRoleDto> findAll();
    UserRoleDto findById(Long id);
    UserRoleDto save(UserRoleDto dto);
    void delete(Long id);
    
}