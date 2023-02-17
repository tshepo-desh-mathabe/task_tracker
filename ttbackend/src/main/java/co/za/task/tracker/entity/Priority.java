package co.za.task.tracker.entity;

import co.za.task.tracker.util.EntityConstants;
import co.za.task.tracker.util.PriorityType;
import co.za.task.tracker.util.StatusType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = EntityConstants.PRIORITY, uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                EntityConstants.TYPE
        })
})
public class Priority {
    @Id
    @Column(name = EntityConstants.PRIORITY_ID, length = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priorityId;

    @Enumerated(EnumType.STRING)
    @Column(name = EntityConstants.TYPE, nullable = false, length = 20)
    private PriorityType priorityType;
}
