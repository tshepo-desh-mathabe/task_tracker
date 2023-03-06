package co.za.task.tracker.entity;

import co.za.task.tracker.util.constants.EntityConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@NoArgsConstructor
@Table(name = EntityConstants.USERS)
public class User implements UserDetails {
    @Id
    @JsonIgnore
    @Column(name = EntityConstants.USER_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @JsonIgnore
    @Column(name = EntityConstants.FIRST_NAME, length = 50, nullable = false)
    private String firstName;

    @JsonIgnore
    @Column(name = EntityConstants.LAST_NAME, length = 50, nullable = false)
    private String lastName;

    @OneToMany
    private List<Token> tokens;

    @JsonIgnore
    @Column(name = EntityConstants.PASSWORD, nullable = false)
    private String password;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = EntityConstants.EMAIL_ID, referencedColumnName = EntityConstants.EMAIL_ADDRESS_ID)
    private EmailAddress emailAddress;

    @NotNull
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = EntityConstants.USER_ROLE,
            joinColumns = @JoinColumn(name = EntityConstants.USER_ID),
            inverseJoinColumns = @JoinColumn(name = EntityConstants.ROLE_ID)
    )
    private Set<UserRole> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleType().name()))
                .collect(Collectors.toSet());
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
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
