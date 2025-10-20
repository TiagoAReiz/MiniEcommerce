package tiago.Mini_Ecommerce.core.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "id", nullable = false)
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "itemcart_id", nullable = false)
    private ItemCart itemcart;
}

