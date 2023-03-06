package co.za.task.tracker.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class UserDto {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String pwd;
    @NotBlank
    private EmailAddressDto emailAddress;
    @NotBlank
    private Set<UserRoleDto> roles;
}
