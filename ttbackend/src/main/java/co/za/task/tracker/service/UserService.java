package co.za.task.tracker.service;

import co.za.task.tracker.entity.dto.UserDto;
import co.za.task.tracker.util.payload.AuthenticationRequest;
import co.za.task.tracker.util.response.ResponseApiWrapper;
import co.za.task.tracker.util.service.AUserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Getter
@AllArgsConstructor
@Service
public class UserService {
    private AUserService service;

    public ResponseEntity<?> loginUser(AuthenticationRequest payload) {
        try {
            return service.signIn(payload);
        } catch (BadCredentialsException ex) {
            return ResponseApiWrapper.badRequest(ex.getMessage());
        }
    }

    public ResponseEntity<?> registerUser(UserDto request) {
        return service.saveData(request);
    }
}
