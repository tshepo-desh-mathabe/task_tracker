package co.za.task.tracker.entity;

import co.za.task.tracker.entity.helper.UserDateAudit;
import co.za.task.tracker.util.constants.EntityConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@NoArgsConstructor
public class Task extends UserDateAudit {
    @Id
    @JsonIgnore
    @Column(name = EntityConstants.TASK_ID)
    private Long id;

    @JsonIgnore
    @Column(name = EntityConstants.DESCRIPTION, length = 500, nullable = false)
    private String description;

    @JsonIgnore
    @Column(name = EntityConstants.ADDITIONAL_COMMENTS, length = 100)
    private String additionalComments;

    @JsonIgnore
    @Column(
            name = EntityConstants.IS_BACKEND, nullable = false,
            columnDefinition = EntityConstants.TINYINT, length = 1
    )
    private Boolean isBackend;

    @JsonIgnore
    @Column(
            name = EntityConstants.IS_FRONTEND, nullable = false,
            columnDefinition = EntityConstants.TINYINT, length = 1
    )
    private Boolean isFrontend;

    @JsonIgnore
    @Column(name = EntityConstants.DUE_DATE, nullable = false)
    private LocalDateTime estimatedTimeOfArrival;

    @JsonIgnore
    @Column(name = EntityConstants.ASSIGNED_AT, nullable = false)
    private LocalDateTime assignedAt;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = EntityConstants.ASSIGNED_TO, referencedColumnName = EntityConstants.USER_ID, nullable = false)
    private User assignedTo;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = EntityConstants.TASK_FLAG_ID, referencedColumnName = EntityConstants.TASK_FLAG_ID, nullable = false)
    private TaskFlag taskFlag;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = EntityConstants.STATUS_ID, referencedColumnName = EntityConstants.STATUS_ID, nullable = false)
    private Status status;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = EntityConstants.PRIORITY_ID, referencedColumnName = EntityConstants.PRIORITY_ID, nullable = false)
    private Priority priority;

}
