package co.za.task.tracker.entity;

import co.za.task.tracker.util.constants.Flag;
import co.za.task.tracker.util.constants.EntityConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = EntityConstants.TASK_FLAG, uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                EntityConstants.FLAG
        })
})
public class TaskFlag {
    @Id
    @JsonIgnore
    @Column(name = EntityConstants.TASK_FLAG_ID, length = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @Column(name = EntityConstants.FLAG, nullable = false, length = 15)
    private Flag flag;
}
