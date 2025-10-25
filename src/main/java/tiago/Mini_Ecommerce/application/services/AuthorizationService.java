package tiago.Mini_Ecommerce.application.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tiago.Mini_Ecommerce.adapters.repositories.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService {
    private final UserRepository userRepository;
    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.getUserByEmail(email);
    }
}
