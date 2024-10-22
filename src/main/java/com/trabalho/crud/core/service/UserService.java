package com.trabalho.crud.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trabalho.crud.core.dto.UserDto;
import com.trabalho.crud.core.entity.BusinessException;
import com.trabalho.crud.core.entity.User;
import com.trabalho.crud.core.mapper.UserMapper;
import com.trabalho.crud.core.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository repository;

  private final UserMapper mapper;

  public List<UserDto> findAll() {
    return repository.findAll().stream().map(user -> mapper.toDto(user)).toList();
  }

  public UserDto findById(Long id) {
    return repository.findById(id).map(user -> mapper.toDto(user))
        .orElseThrow(() -> BusinessException.notFoundException("Usuário não encontrado"));
  }

  public UserDto save(UserDto userDto) {
    var user = mapper.toEntity(userDto);
    return mapper.toDto(repository.save(user));
  }

  public UserDto update(Long id, UserDto userDto) {
    var existingUser = this.findById(id);
    userDto.setId(existingUser.getId());
    var user = mapper.toEntity(userDto);
    return mapper.toDto(repository.save(user));
  }

  public void deleteById(Long id) {
    this.findById(id);
    repository.deleteById(id);
  }

  public UserDto createUser(UserDto userDto) {
    User user = mapper.toEntity(userDto); // Converter de UserDto para User
    User savedUser = repository.save(user); // Salvar no repositório
    return mapper.toDto(savedUser); // Retornar o UserDto salvo
}

}
