package com.sena.test.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.test.Dto.UserRoleDto;
import com.sena.test.Entity.User;
import com.sena.test.Entity.Role;
import com.sena.test.Entity.UserRole;
import com.sena.test.IRepository.IUserRepository;
import com.sena.test.IRepository.IRoleRepository;
import com.sena.test.IRepository.IUserRoleRepository;
import com.sena.test.IService.IUserRoleService;

@Service
public class UserRoleService implements IUserRoleService {

    @Autowired
    private IUserRoleRepository userRoleRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    private UserRoleDto convertToDto(UserRole entity) {
        return new UserRoleDto(
                entity.getIdUserRole(),
                entity.getUser().getIdUser(),
                entity.getRole().getIdRole()
        );
    }

    private UserRole convertToEntity(UserRoleDto dto) {

        User user = userRepository.findById(dto.getIdUser())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Role role = roleRepository.findById(dto.getIdRole())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        UserRole userRole = new UserRole();
        userRole.setIdUserRole(dto.getIdUserRole());
        userRole.setUser(user);
        userRole.setRole(role);

        return userRole;
    }

    @Override
    public List<UserRoleDto> findAll() {
        return userRoleRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserRoleDto findById(Long id) {
        UserRole entity = userRoleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));

        return convertToDto(entity);
    }

    @Override
    public UserRoleDto save(UserRoleDto dto) {
        UserRole entity = convertToEntity(dto);
        UserRole saved = userRoleRepository.save(entity);
        return convertToDto(saved);
    }

    @Override
    public void delete(Long id) {
        UserRole entity = userRoleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));

        userRoleRepository.delete(entity);
    }
    
}