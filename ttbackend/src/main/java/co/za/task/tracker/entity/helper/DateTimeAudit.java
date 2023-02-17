package co.za.task.tracker.entity.helper;

import co.za.task.tracker.util.EntityConstants;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class DateTimeAudit {
    @NotNull
    @CreatedDate
    @Column(name = EntityConstants.CREATED_AT)
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = EntityConstants.ASSIGNED_AT)
    private LocalDateTime assignedAt;

    @NotNull
    @Column(name = EntityConstants.ETA)
    private LocalDateTime eta;

    @PrePersist
    protected void beforePersistingCreatedAt() {
        if (createdAt == null ) createdAt = LocalDateTime.now();
    }
}
