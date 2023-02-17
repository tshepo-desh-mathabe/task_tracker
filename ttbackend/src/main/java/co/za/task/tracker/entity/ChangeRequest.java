package co.za.task.tracker.entity;

import co.za.task.tracker.util.EntityConstants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = EntityConstants.CHANGE_REQUEST)
public class ChangeRequest extends Task {
    @Id
    @Column(name = EntityConstants.CHANGE_REQUEST_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long changeRequestId;
}
