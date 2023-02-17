package co.za.task.tracker.entity.dto;

import co.za.task.tracker.util.StatusType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class StatusDto {
    private Long id;
    private StatusType type;
}
