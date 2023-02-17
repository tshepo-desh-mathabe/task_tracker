package co.za.task.tracker.entity;

import co.za.task.tracker.entity.helper.DateTimeAudit;
import co.za.task.tracker.util.EntityConstants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@MappedSuperclass
@NoArgsConstructor
abstract class Task extends DateTimeAudit {

    @Column(name = EntityConstants.DESCRIPTION, length = 100, nullable = false)
    private String description;

    @Column(name = EntityConstants.ADDITIONAL_COMMENTS, length = 100)
    private String additionalComments;

    @Column(name = EntityConstants.IS_BACKEND, nullable = false)
    private Boolean isBackend;

    @Column(name = EntityConstants.IS_DATABASE, nullable = false)
    private Boolean isDatabase;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = EntityConstants.ASSIGNED_TO, referencedColumnName = EntityConstants.USER_ID, nullable = false)
    private User assignedTo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = EntityConstants.STATUS_ID, referencedColumnName = EntityConstants.STATUS_ID, nullable = false)
    private Status status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = EntityConstants.PRIORITY_ID, referencedColumnName = EntityConstants.PRIORITY_ID, nullable = false)
    private Priority priority;

}
