package com.sena.test.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.test.Dto.UserDto;
import com.sena.test.Entity.Person;
import com.sena.test.Entity.User;
import com.sena.test.IRepository.IPersonRepository;
import com.sena.test.IRepository.IUserRepository;
import com.sena.test.IService.IUserService;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IPersonRepository personRepository;

    private UserDto convertToDto(User user) {
        return new UserDto(
                user.getIdUser(),
                user.getUserName(),
                user.getPassword(),
                user.getPerson().getIdPerson()
        );
    }

    private User convertToEntity(UserDto dto) {
        User user = new User();
        user.setIdUser(dto.getIdUser());
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());

        Person person = personRepository.findById(dto.getIdPerson())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        user.setPerson(person);

        return user;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return convertToDto(user);
    }

    @Override
    public UserDto save(UserDto dto) {
        User user = convertToEntity(dto);
        User savedUser = userRepository.save(user);
        return convertToDto(savedUser);
    }

    @Override
    public UserDto update(Long id, UserDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());

        Person person = personRepository.findById(dto.getIdPerson())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        user.setPerson(person);

        User updatedUser = userRepository.save(user);
        return convertToDto(updatedUser);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        userRepository.delete(user);
    }
	
}