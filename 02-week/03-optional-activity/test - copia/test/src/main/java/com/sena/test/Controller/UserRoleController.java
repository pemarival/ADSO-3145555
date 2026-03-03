package com.sena.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sena.test.Dto.UserRoleDto;
import com.sena.test.IService.IUserRoleService;

@RestController
@RequestMapping("/api/userrole")
@CrossOrigin("*")
public class UserRoleController {

    @Autowired
    private IUserRoleService userRoleService;

    @GetMapping
    public List<UserRoleDto> getAll() {
        return userRoleService.findAll();
    }

    @GetMapping("/{id}")
    public UserRoleDto getById(@PathVariable Long id) {
        return userRoleService.findById(id);
    }

    @PostMapping
    public UserRoleDto create(@RequestBody UserRoleDto dto) {
        return userRoleService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userRoleService.delete(id);
    }

}