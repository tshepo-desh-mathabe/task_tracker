package co.za.task.tracker.util.security;

import co.za.task.tracker.entity.User;
import co.za.task.tracker.repository.IUserRepository;
import co.za.task.tracker.util.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Getter
@AllArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final IUserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        User user = userRepository.findByEmailAddressAddress(email)
                .orElseThrow(()
                        -> new UsernameNotFoundException("User not found with username or email : " + email)
                );

        return UserPrincipal.create(user);
    }

    @Deprecated // todo - remove unused
    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );

        return UserPrincipal.create(user);
    }
}