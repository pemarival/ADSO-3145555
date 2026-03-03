package com.sena.test.IService.ISecurityService;

import java.util.List;

import com.sena.test.Dto.SecurityDto.RoleDto;

public interface IRoleService {

    List<RoleDto> findAll();
    RoleDto findById(Long id);
    RoleDto save(RoleDto dto);
    RoleDto update(Long id, RoleDto dto);
    void delete(Long id);
    
}