package co.za.task.tracker.util.security;

import co.za.task.tracker.entity.User;
import co.za.task.tracker.util.exeption.ResourceNotFoundException;
import co.za.task.tracker.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    IUserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        // Let people login with email. Email will be username
        User user = userRepository.findByEmailAddressAddress(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username or email : " + email) );

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("User", "id", id) );

        return UserPrincipal.create(user);
    }
}