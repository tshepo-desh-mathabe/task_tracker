package co.za.task.tracker.entity.dto;

import co.za.task.tracker.util.constants.EntityConstants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class SecureAccountDto {
    private Long id;
    private Boolean isEnabled;
    private Boolean isAccountExpired;
    private Boolean isCredentialsExpired;
    private Boolean isAccountNonLocked;
}