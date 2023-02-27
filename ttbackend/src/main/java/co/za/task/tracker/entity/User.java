package co.za.task.tracker.entity;

import co.za.task.tracker.util.constants.EntityConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = EntityConstants.USERS)
public class User {
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

    @JsonIgnore
    @Column(name = EntityConstants.PASSWORD, length = 50, nullable = false)
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
}
