package co.za.task.tracker.util.payload.client;

import co.za.task.tracker.entity.dto.helper.TaskDetails;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TaskPayload extends TaskDetails {
    @NotBlank
    private UserResponse assignedTo;
}