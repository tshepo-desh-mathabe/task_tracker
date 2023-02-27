package co.za.task.tracker.entity;

import co.za.task.tracker.util.constants.EntityConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @Column(name = EntityConstants.EMAIL_ADDRESS_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;

    @JsonIgnore
    @Column(name = EntityConstants.EMAIL, length = 150, nullable = false)
    private String address;
}