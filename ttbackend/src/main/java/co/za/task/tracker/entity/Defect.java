package co.za.task.tracker.entity;

import co.za.task.tracker.util.EntityConstants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = EntityConstants.DEFECT)
public class Defect extends Task {
    @Id
    @Column(name = EntityConstants.DEFECT_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long defectId;
}
