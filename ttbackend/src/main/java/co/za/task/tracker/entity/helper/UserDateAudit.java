package co.za.task.tracker.entity.helper;

import co.za.task.tracker.util.constants.EntityConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class UserDateAudit extends DateTimeAudit {
    @CreatedBy
    @JsonIgnore
    @Column(name = EntityConstants.CREATED_BY, nullable = false)
    private Long auditCreatedBy;

    @JsonIgnore
    @LastModifiedBy
    @Column(name = EntityConstants.UPDATED_BY, nullable = false)
    private Long auditUpdatedBy;

}
