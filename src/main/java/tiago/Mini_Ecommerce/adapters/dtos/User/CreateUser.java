package tiago.Mini_Ecommerce.adapters.dtos.User;

import tiago.Mini_Ecommerce.core.entities.enums.Role;

public record CreateUser(String email, String name, String password, String cpf, Role role) {
}
