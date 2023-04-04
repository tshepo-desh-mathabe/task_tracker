package co.za.task.tracker.entity.dto.helper;

import co.za.task.tracker.entity.dto.PriorityDto;
import co.za.task.tracker.entity.dto.StatusDto;
import co.za.task.tracker.entity.dto.TaskFlagDto;
import co.za.task.tracker.entity.helper.UserDateAudit;
import co.za.task.tracker.util.payload.client.UserResponse;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class TaskDetails extends UserDateAudit {
    @NotBlank
    private Long id;
    @NotBlank
    private String desc;
    private String comments;
    @NotBlank
    private Boolean isBackend;
    @NotBlank
    private Boolean isDatabase;
    @NotBlank
    private LocalDateTime eta;
    private LocalDateTime allocatedAt;
    @NotBlank
    private TaskFlagDto taskType;
//    @NotBlank
//    private UserResponse assignedTo;
    @NotBlank
    private StatusDto statusDetails;
    @NotBlank
    private PriorityDto priorityDetails;
}
