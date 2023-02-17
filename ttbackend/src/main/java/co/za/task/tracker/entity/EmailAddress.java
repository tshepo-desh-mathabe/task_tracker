package co.za.task.tracker.entity;

import co.za.task.tracker.util.EntityConstants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = EntityConstants.EMAIL_ADDRESS, uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                EntityConstants.EMAIL
        })
})
public class EmailAddress {
    @Id
    @Column(name = EntityConstants.EMAIL_ADDRESS_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;

    @Column(name = EntityConstants.EMAIL, length = 150, nullable = false)
    private String address;
}