package co.za.task.tracker.entity;

import co.za.task.tracker.util.EntityConstants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = EntityConstants.OTHER)
public class Other extends Task {
    @Id
    @Column(name = EntityConstants.OTHER_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long otherId;
}
