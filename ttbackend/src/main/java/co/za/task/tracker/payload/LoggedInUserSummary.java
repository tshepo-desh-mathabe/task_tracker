package co.za.task.tracker.payload;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public record LoggedInUserSummary(
        String name,
        String surname,
        String accessToken,
        Collection<? extends GrantedAuthority> roles
){
}