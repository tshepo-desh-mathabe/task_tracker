package co.za.task.tracker.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String pwd;
    @NotBlank
    private EmailAddressDto email;
    @NotBlank
    private Set<UserRoleDto> roles;
}
