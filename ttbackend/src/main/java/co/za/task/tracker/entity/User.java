package co.za.task.tracker.entity;

import co.za.task.tracker.util.EntityConstants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = EntityConstants.USERS)
public class User {
    @Id
    @Column(name = EntityConstants.USER_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = EntityConstants.FIRST_NAME, length = 50, nullable = false)
    private String firstName;

    @Column(name = EntityConstants.LAST_NAME, length = 50, nullable = false)
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = EntityConstants.EMAIL_ID, referencedColumnName = EntityConstants.EMAIL_ADDRESS_ID)
    private EmailAddress emailAddress;
}
