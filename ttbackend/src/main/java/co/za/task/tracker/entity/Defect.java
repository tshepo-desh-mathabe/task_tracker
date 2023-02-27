package co.za.task.tracker.entity;

import co.za.task.tracker.util.constants.EntityConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = EntityConstants.DEFECT)
public class Defect {
    @Id
    @JsonIgnore
    @Column(name = EntityConstants.DEFECT_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long defectId;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = EntityConstants.TASK_ID, referencedColumnName = EntityConstants.TASK_ID)
    private Task task;
}
