package tiago.Mini_Ecommerce.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tiago.Mini_Ecommerce.adapters.Mappers.UserMap;
import tiago.Mini_Ecommerce.adapters.dtos.User.CreateUser;
import tiago.Mini_Ecommerce.adapters.dtos.User.LoginRequest;
import tiago.Mini_Ecommerce.adapters.dtos.User.LoginResponse;
import tiago.Mini_Ecommerce.adapters.repositories.UserRepository;
import tiago.Mini_Ecommerce.core.entities.UserEntity;
import tiago.Mini_Ecommerce.core.usecases.UserUseCases;
import tiago.Mini_Ecommerce.infrastructure.jwt.jwtService;

import java.util.List;

@Service
public class UserUseCasesImpl implements UserUseCases {
    private final UserMap userMap;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final jwtService jwtService;
    public UserUseCasesImpl(UserMap userMap, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,  AuthenticationManager authenticationManager,  jwtService jwtService) {
        this.userMap = userMap;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        return userRepository.getAllUsers();
    }
    @Override
    public UserEntity getUserById(Long id){

        return userRepository.getUserById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    }

    @Override
    public ResponseEntity<String> createUser(CreateUser user) {
        if (userRepository.getUserByEmail(user.email()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário já existe");
        }
        UserEntity userEntity = userMap.toEntity(user);
        userEntity.setPassword(bCryptPasswordEncoder.encode(user.password()));
        try {
            userRepository.createUser(userEntity);
            return  ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso");
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
        }


    }

    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest loginRequest) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());
        try {
            var auth = this.authenticationManager.authenticate(usernamePassword);
            var token = jwtService.generateToken((UserEntity)auth.getPrincipal());
            return ResponseEntity.ok(new LoginResponse(token));
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

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
