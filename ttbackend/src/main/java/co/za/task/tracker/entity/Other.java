package co.za.task.tracker.entity;

import co.za.task.tracker.util.constants.EntityConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = EntityConstants.OTHER)
public class Other {
    @Id
    @JsonIgnore
    @Column(name = EntityConstants.OTHER_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long otherId;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = EntityConstants.TASK_ID, referencedColumnName = EntityConstants.TASK_ID)
    private Task task;
}
