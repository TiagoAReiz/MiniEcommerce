package tiago.Mini_Ecommerce.core.usecases;


import org.springframework.http.ResponseEntity;
import tiago.Mini_Ecommerce.adapters.dtos.User.CreateUser;
import tiago.Mini_Ecommerce.core.entities.UserEntity;

import java.util.List;

public interface UserUseCases {
    ResponseEntity<List<UserEntity>> getAllUsers();
    UserEntity getUserById(Long id);
    ResponseEntity<String> createUser(CreateUser user);
    ResponseEntity<Void> updateUser(CreateUser user);
    ResponseEntity<Void> deleteUser(int id);
}
