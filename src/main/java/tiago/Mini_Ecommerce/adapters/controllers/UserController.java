package tiago.Mini_Ecommerce.adapters.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tiago.Mini_Ecommerce.adapters.dtos.User.CreateUser;
import tiago.Mini_Ecommerce.adapters.dtos.User.LoginRequest;
import tiago.Mini_Ecommerce.adapters.dtos.User.LoginResponse;
import tiago.Mini_Ecommerce.core.entities.UserEntity;
import tiago.Mini_Ecommerce.core.usecases.UserUseCases;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserUseCases userUseCases;

    public UserController(UserUseCases userUseCases) {
        this.userUseCases = userUseCases;
    }
    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        return userUseCases.getAllUsers();
    }
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@Valid @RequestBody CreateUser user) {
        return userUseCases.createUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return userUseCases.login(loginRequest);
    }

}
