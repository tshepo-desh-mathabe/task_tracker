package co.za.task.tracker.entity;

import co.za.task.tracker.util.constants.EntityConstants;
import co.za.task.tracker.util.constants.RoleType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = EntityConstants.ROLE, uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                EntityConstants.NAME
        })
})
public class UserRole {

    @Id
    @Column(name = EntityConstants.ROLE_ID, length = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRoleId;

    @Enumerated(EnumType.STRING)
    @Column(name = EntityConstants.NAME, nullable = false, length = 15)
    private RoleType roleType;
}