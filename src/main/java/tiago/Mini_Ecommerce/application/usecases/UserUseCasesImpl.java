package tiago.Mini_Ecommerce.application.usecases;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tiago.Mini_Ecommerce.adapters.Mappers.UserMap;
import tiago.Mini_Ecommerce.adapters.dtos.User.CreateUser;
import tiago.Mini_Ecommerce.adapters.repositories.UserRepository;
import tiago.Mini_Ecommerce.core.entities.UserEntity;
import tiago.Mini_Ecommerce.core.usecases.UserUseCases;

import java.util.List;

@Service
public class UserUseCasesImpl implements UserUseCases {
    private final UserMap userMap;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserUseCasesImpl(UserMap userMap, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userMap = userMap;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Override
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        return userRepository.getAllUsers();
    }

    @Override
    public ResponseEntity<UserEntity> createUser(CreateUser user) {
        if (userRepository.getUserByEmail(user.email()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        UserEntity userEntity = userMap.toEntity(user);
        userEntity.setPassword(bCryptPasswordEncoder.encode(user.password()));
        return userRepository.createUser(userEntity);
    }

    @Override
    public ResponseEntity<Void> updateUser(CreateUser user) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteUser(int id) {
        return null;
    }
}
