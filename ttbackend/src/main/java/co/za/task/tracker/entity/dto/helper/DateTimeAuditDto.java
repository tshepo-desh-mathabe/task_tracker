package co.za.task.tracker.entity.dto.helper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public abstract class DateTimeAuditDto {
    private LocalDateTime createdAt;
    private LocalDateTime assignedAt;
    private LocalDateTime eta;
}
