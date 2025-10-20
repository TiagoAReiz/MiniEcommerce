package tiago.Mini_Ecommerce.adapters.Mappers;

import org.springframework.stereotype.Component;
import tiago.Mini_Ecommerce.adapters.dtos.User.CreateUser;
import tiago.Mini_Ecommerce.core.entities.UserEntity;

@Component
public class UserMap {
    public UserEntity toEntity(CreateUser userDto){
        UserEntity user = new UserEntity();
        user.setName(userDto.name());
        user.setEmail(userDto.email());
        user.setPassword(userDto.password());
        return user;
    }
}
