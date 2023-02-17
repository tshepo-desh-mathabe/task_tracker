package co.za.task.tracker.entity.dto;

import co.za.task.tracker.util.PriorityType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PriorityDto {
    private Long id;
    private PriorityType type;
}
