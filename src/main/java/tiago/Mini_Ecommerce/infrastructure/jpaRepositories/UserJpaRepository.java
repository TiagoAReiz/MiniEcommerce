package tiago.Mini_Ecommerce.infrastructure.jpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tiago.Mini_Ecommerce.core.entities.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
