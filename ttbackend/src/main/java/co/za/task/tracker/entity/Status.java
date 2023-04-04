package co.za.task.tracker.entity;

import co.za.task.tracker.util.constants.EntityConstants;
import co.za.task.tracker.util.constants.StatusType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = EntityConstants.STATUS, uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                EntityConstants.TYPE
        })
})
public class Status {
    @Id
    @JsonIgnore
    @Column(name = EntityConstants.STATUS_ID, length = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @Column(name = EntityConstants.TYPE, nullable = false, length = 20)
    private StatusType statusType;
}
