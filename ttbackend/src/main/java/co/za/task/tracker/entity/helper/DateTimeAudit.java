package co.za.task.tracker.entity.helper;

import co.za.task.tracker.util.constants.EntityConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class DateTimeAudit {
    @JsonIgnore
    @CreatedDate
    @Column(name = EntityConstants.CREATED_AT, nullable = false)
    private LocalDateTime auditCreatedAt;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = EntityConstants.UPDATED_AT, nullable = false)
    private LocalDateTime auditUpdatedAt;
}
