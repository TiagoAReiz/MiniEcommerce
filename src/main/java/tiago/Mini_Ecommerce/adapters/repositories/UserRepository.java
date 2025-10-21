package tiago.Mini_Ecommerce.adapters.repositories;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import tiago.Mini_Ecommerce.core.entities.UserEntity;
import tiago.Mini_Ecommerce.infrastructure.jpaRepositories.UserJpaRepository;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepository {
    private final UserJpaRepository userJpaRepository;
    public UserRepository(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }


    public ResponseEntity<List<UserEntity>> getAllUsers(){
        return ResponseEntity.ok(userJpaRepository.findAll());
    }

    public Optional<UserEntity> getUserById(Long id){
        return userJpaRepository.findById(id);
    }

    public UserEntity getUserByEmail(String email) {
       return userJpaRepository.findByEmail(email);
    }


    public void createUser(UserEntity user) {
        userJpaRepository.save(user);

    }
}
