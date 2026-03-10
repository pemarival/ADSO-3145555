package com.sena.test.IService;

import java.util.List;
import com.sena.test.Dto.UserRoleDto;

public interface IUserRoleService {

    List<UserRoleDto> findAll();
    UserRoleDto findById(Long id);
    UserRoleDto save(UserRoleDto dto);
    void delete(Long id);
    
}