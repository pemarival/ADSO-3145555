package com.sena.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sena.test.Dto.RoleDto;
import com.sena.test.IService.IRoleService;

@RestController
@RequestMapping("/api/role")
@CrossOrigin("*")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @GetMapping
    public List<RoleDto> getAll() {
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public RoleDto getById(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @PostMapping
    public RoleDto create(@RequestBody RoleDto dto) {
        return roleService.save(dto);
    }

    @PutMapping("/{id}")
    public RoleDto update(@PathVariable Long id, @RequestBody RoleDto dto) {
        return roleService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        roleService.delete(id);
    }
    
}