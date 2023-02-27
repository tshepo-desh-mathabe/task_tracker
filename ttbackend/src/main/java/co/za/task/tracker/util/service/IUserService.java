package co.za.task.tracker.util.service;

import co.za.task.tracker.entity.dto.UserDto;
import org.springframework.http.ResponseEntity;

/**
 * Serves for User Service
 */
@FunctionalInterface
public interface IUserService {
    ResponseEntity<?> signIn(UserDto payload);
}
