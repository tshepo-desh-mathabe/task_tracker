package co.za.task.tracker.service;

import co.za.task.tracker.entity.dto.UserDto;
import co.za.task.tracker.util.payload.AuthenticationRequest;
import co.za.task.tracker.util.service.AUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private AUserService service;

    public ResponseEntity<?> loginUser(AuthenticationRequest payload) {
        return service.signIn(payload);
    }

    public ResponseEntity<?> registerUser(UserDto request) {
        return service.saveData(request);
    }
}
