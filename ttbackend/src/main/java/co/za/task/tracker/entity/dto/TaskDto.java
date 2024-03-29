package co.za.task.tracker.entity.dto;

import co.za.task.tracker.entity.dto.helper.TaskDetails;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TaskDto extends TaskDetails {
    @NotBlank
    private UserDto assignedTo;
}
