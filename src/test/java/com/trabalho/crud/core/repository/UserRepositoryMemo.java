package com.trabalho.crud.core.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;

import com.trabalho.crud.core.entity.User;

@ActiveProfiles("test")
@Repository
public class UserRepositoryMemo implements UserRepository {

  private final List<User> users = new ArrayList<User>();

  @Override
  public List<User> findAll() {
    return users;
  }

  @Override
  public Optional<User> findById(Long id) {
    return users.stream().filter(user -> user.getId().equals(id)).findFirst();
  }

  @Override
  public User save(User user) {
    var id = users.size() + 1;
    user.setId((long) id);
    users.add(user);
    return user;
  }

  @Override
  public void deleteById(Long id) {
    users.removeIf(user -> user.getId() == id);
  }

  @Override
  public void deleteAll() {
    users.clear();
  }
}
