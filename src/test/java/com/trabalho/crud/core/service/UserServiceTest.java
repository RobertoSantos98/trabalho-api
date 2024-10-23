package com.trabalho.crud.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.trabalho.crud.core.dto.UserDto;
import com.trabalho.crud.core.entity.User;
import com.trabalho.crud.core.repository.UserRepository;

@ActiveProfiles("test")
@SpringBootTest
class UserServiceTest {

  @Autowired
  private UserRepository repository;

  @Autowired
  private UserService service;

  @BeforeEach
  void populateRepository() {

    repository.deleteAll();
    
    MockitoAnnotations.openMocks(this);
    
    repository.save(User.builder().nome("User 1").cpf("123.456.789-10").animal("Cão").raça("Pastor Alemão").build());
    repository.save(User.builder().nome("User 2").cpf("321.654.987-01").animal("Gato").raça("Siamês").build());
    repository.save(User.builder().nome("User 3").cpf("456.123.789-11").animal("Furão").raça("Genérico").build());
  }

  @Test
  @DisplayName("Busca todos os usuários")
  void testBuscarTodosOsUsuarios() {
    var allUsers = service.findAll();

    assertEquals(3, allUsers.size());
  }

  @Test
  @DisplayName("Buscar por ID existente")
  void testBuscarUsuarioPorId() {

    var user = repository.findAll().get(0);
    UserDto userDto = service.findById(user.getId());

    assertEquals(user.getNome(), userDto.getNome(), "O nome no UserDto deve ser igual ao nome do usuário");
    assertEquals(user.getCpf(), userDto.getCpf(), "O email no UserDto deve ser igual ao email do usuário");
    
  }

  @Test
    @DisplayName("Criar um novo usuário")
    void testCriarNovoUsuario() {
        // Criamos um novo UserDto para criar
        UserDto newUser = new UserDto();
        newUser.setNome("New User");
        newUser.setCpf("147.258.369-00");

        // Chamamos o método de criação
        UserDto savedUser = service.createUser(newUser);

        // Verificamos se o usuário foi salvo corretamente
        assertEquals("New User", savedUser.getNome(), "O nome do usuário salvo deve ser 'New User'");
        assertTrue(savedUser.getId() > 0, "O ID do usuário salvo deve ser maior que 0");
    }

@Test
@DisplayName("Deletar um usuário por ID")
void testDeletarUsuarioPorId() {
    UserDto userToDelete = service.findById(1L); // Assume que o usuário com ID 1 existe

    // Verifique o número de usuários antes da exclusão
    assertEquals(3, service.findAll().size(), "Deve haver 3 usuários antes da exclusão");

    // Chama o método de exclusão
    service.deleteById(userToDelete.getId());

    // Verifique o número de usuários após a exclusão
    assertEquals(2, service.findAll().size(), "Deve haver 2 usuários após a exclusão");
}

@Test
    @DisplayName("Atualizar um usuário existente")
    void testAtualizarUsuario() {
        // Primeiro, buscamos o usuário existente
        UserDto existingUser = service.findById(1L); // Assumindo que o usuário com ID 1 existe

        // Criamos um novo UserDto para atualizar
        UserDto updatedUser = new UserDto();
        updatedUser.setId(existingUser.getId()); // Mantemos o ID do usuário existente
        updatedUser.setNome("Updated User"); // Novo nome
        updatedUser.setCpf("123.123.123-11"); // Novo cpf

        // Atualizamos o usuário
        UserDto result = service.update(existingUser.getId(), updatedUser);

        // Verificamos se o usuário foi atualizado corretamente
        assertEquals("Updated User", result.getNome(), "O nome do usuário deve ser 'Updated User'");
        assertEquals("123.123.123-11", result.getCpf(), "O cpf do usuário deve ser '123.123.123-11'");
    }


  
}
