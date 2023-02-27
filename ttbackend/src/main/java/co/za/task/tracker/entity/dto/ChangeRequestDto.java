package co.za.task.tracker.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ChangeRequestDto {
    private Long id;
    private TaskDto taskDto;
}
