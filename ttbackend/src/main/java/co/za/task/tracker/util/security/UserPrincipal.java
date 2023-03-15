package co.za.task.tracker.util.security;

import co.za.task.tracker.entity.EmailAddress;
import co.za.task.tracker.entity.SecureAccount;
import co.za.task.tracker.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@AllArgsConstructor
public class UserPrincipal implements UserDetails {
    private final Long userId;
    private final String firstName;
    private final String lastName;
    @JsonIgnore
    private final String password;
    private final EmailAddress emailAddress;
    private final SecureAccount secureAccount;
    private final Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role
                -> new SimpleGrantedAuthority(role.getRoleType().name())
        ).collect(Collectors.toList());

        return new UserPrincipal (
                user.getUserId(), user.getFirstName(), user.getLastName(), user.getPassword(),
                user.getEmailAddress(),  user.getSecureAccount(), authorities
        );
    }

    public Long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String getUsername() {
        return emailAddress.getAddress();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return secureAccount.getIsAccountNonLocked();
    }

    @Override
    public boolean isAccountNonLocked() {
        return secureAccount.getIsAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return secureAccount.getIsCredentialsExpired();
    }

    @Override
    public boolean isEnabled() {
        return secureAccount.getIsEnabled();
    }

    public SecureAccount getSecureAccount() {
        return secureAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
