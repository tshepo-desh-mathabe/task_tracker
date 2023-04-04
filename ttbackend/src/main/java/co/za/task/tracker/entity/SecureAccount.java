package co.za.task.tracker.entity;

import co.za.task.tracker.util.constants.EntityConstants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = EntityConstants.SECURE_ACCOUNT)
public class SecureAccount {

    @Id
    @Column(name = EntityConstants.SECURE_ACCOUNT_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = EntityConstants.IS_ENABLED, nullable = false,
            columnDefinition = EntityConstants.TINYINT, length = 1
    )
    private Boolean isEnabled;

    @Column(
            name = EntityConstants.IS_ACCOUNT_EXPIRED, nullable = false,
            columnDefinition = EntityConstants.TINYINT, length = 1
    )
    private Boolean isAccountExpired;

    @Column(
            name = EntityConstants.IS_CREDENTIALS_EXPIRED,
            nullable = false,
            columnDefinition = EntityConstants.TINYINT,
            length = 1
    )
    private Boolean isCredentialsExpired;

    @Column(
            name = EntityConstants.IS_ACCOUNT_LOCKED,
            nullable = false,
            columnDefinition = EntityConstants.TINYINT,
            length = 1
    )
    private Boolean isAccountNonLocked;

}