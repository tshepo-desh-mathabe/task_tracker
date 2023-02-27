package co.za.task.tracker.entity.dto;

import co.za.task.tracker.entity.helper.UserDateAudit;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class TaskDto extends UserDateAudit {
    @NotBlank
    private Long id;
    @NotBlank
    private String desc;
    @NotBlank
    private String comments;
    @NotBlank
    private Boolean isBackend;
    @NotBlank
    private Boolean isDatabase;
    @NotBlank
    private LocalDateTime eta;
    @NotBlank
    private LocalDateTime allocatedAt;
    @NotBlank
    private UserDto assignedTo;
    @NotBlank
    private StatusDto status;
    @NotBlank
    private PriorityDto priority;
}
