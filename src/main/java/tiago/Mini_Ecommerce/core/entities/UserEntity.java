package tiago.Mini_Ecommerce.core.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import tiago.Mini_Ecommerce.core.entities.enums.Role;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @Email(message = "Email inválido")
    @NotBlank(message = "O email é obrigatório")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    private String password;

    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O papel (role) é obrigatório")
    private Role role;

    @CreationTimestamp
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
}
