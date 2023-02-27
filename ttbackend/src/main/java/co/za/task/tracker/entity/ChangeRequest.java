package co.za.task.tracker.entity;

import co.za.task.tracker.util.constants.EntityConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = EntityConstants.CHANGE_REQUEST)
public class ChangeRequest {
    @Id
    @Column(name = EntityConstants.CHANGE_REQUEST_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long changeRequestId;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = EntityConstants.TASK_ID, referencedColumnName = EntityConstants.TASK_ID)
    private Task task;
}
