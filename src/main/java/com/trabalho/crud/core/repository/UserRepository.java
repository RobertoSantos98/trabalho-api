package com.trabalho.crud.core.repository;

import java.util.List;
import java.util.Optional;

import com.trabalho.crud.core.entity.User;

public interface UserRepository {

  List<User> findAll();

  Optional<User> findById(Long id);

  User save(User user);

  void deleteById(Long id);

  void deleteAll();
}
