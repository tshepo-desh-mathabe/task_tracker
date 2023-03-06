package co.za.task.tracker.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserRoleDto {
    private Long userRoleId;

    @NotBlank
    private String type;
}
