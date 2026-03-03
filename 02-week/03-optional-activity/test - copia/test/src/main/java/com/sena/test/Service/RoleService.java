package com.sena.test.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.test.Dto.RoleDto;
import com.sena.test.Entity.Role;
import com.sena.test.IRepository.IRoleRepository;
import com.sena.test.IService.IRoleService;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    private RoleDto convertToDto(Role role) {
        return new RoleDto(
                role.getIdRole(),
                role.getRoleName()
        );
    }

    private Role convertToEntity(RoleDto dto) {
        Role role = new Role();
        role.setIdRole(dto.getIdRole());
        role.setRoleName(dto.getRoleName());
        return role;
    }

    @Override
    public List<RoleDto> findAll() {
        return roleRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto findById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        return convertToDto(role);
    }

    @Override
    public RoleDto save(RoleDto dto) {
        Role role = convertToEntity(dto);
        Role savedRole = roleRepository.save(role);
        return convertToDto(savedRole);
    }

    @Override
    public RoleDto update(Long id, RoleDto dto) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        role.setRoleName(dto.getRoleName());

        Role updatedRole = roleRepository.save(role);
        return convertToDto(updatedRole);
    }

    @Override
    public void delete(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        roleRepository.delete(role);
    }
    
}