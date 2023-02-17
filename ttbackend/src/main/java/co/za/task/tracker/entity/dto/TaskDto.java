package co.za.task.tracker.entity.dto;

import co.za.task.tracker.entity.dto.helper.DateTimeAuditDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
abstract class TaskDto extends DateTimeAuditDto {
    @NotBlank
    private String desc;
    @NotBlank
    private String comments;
    @NotBlank
    private Boolean isBackend;
    @NotBlank
    private Boolean isDatabase;
    @NotBlank
    private UserDto assignedTo;
    @NotBlank
    private StatusDto status;
    @NotBlank
    private PriorityDto priority;
}
