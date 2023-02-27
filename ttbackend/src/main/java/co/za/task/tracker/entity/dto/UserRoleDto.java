package co.za.task.tracker.entity.dto;

import co.za.task.tracker.util.constants.EntityConstants;
import co.za.task.tracker.util.constants.RoleType;
import jakarta.persistence.*;
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
    private String role;

    @Enumerated(EnumType.STRING)
    @Column(name = EntityConstants.NAME, nullable = false, length = 15)
    private RoleType roleType;
}
