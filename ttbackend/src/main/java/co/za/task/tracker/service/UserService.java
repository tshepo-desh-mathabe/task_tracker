package co.za.task.tracker.service;

import co.za.task.tracker.entity.dto.UserDto;
import co.za.task.tracker.util.constants.AppConstant;
import co.za.task.tracker.util.helper.service.AUserService;
import co.za.task.tracker.util.helper.service.util.ICrudFindService;
import co.za.task.tracker.util.payload.AuthenticationRequest;
import co.za.task.tracker.util.response.ApiResponse;
import co.za.task.tracker.util.response.ResponseApiWrapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

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

    public ResponseEntity<?> searchForUsers(String value) {
        return service.readData(value);
    }
}
