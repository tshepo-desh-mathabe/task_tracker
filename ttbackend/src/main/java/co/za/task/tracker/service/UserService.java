package co.za.task.tracker.service;

import co.za.task.tracker.entity.dto.UserDto;
import co.za.task.tracker.util.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserService service;

    public ResponseEntity<?> loginUser(UserDto payload) {
        return service.signIn(payload);
    }
}
