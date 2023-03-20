package co.za.task.tracker.controller;

import co.za.task.tracker.entity.dto.UserDto;
import co.za.task.tracker.service.UserService;
import co.za.task.tracker.util.constants.ResourcePath;
import co.za.task.tracker.util.payload.AuthenticationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@AllArgsConstructor
@RestController
@RequestMapping(ResourcePath.USER_ENTRY_POINT)
public class UserController {
    private final UserService userService;

    @PostMapping(ResourcePath.USER_LOGIN)
    public Object authenticateUser(@RequestBody AuthenticationRequest request) {
        return userService.loginUser(request);
    }

    @Deprecated // todo - remove unused
    @PostMapping(ResourcePath.SAVE)
    public Object register(@RequestBody UserDto request) {
        return userService.registerUser(request).getBody();
    }

    @PostMapping(ResourcePath.USER_LOGOUT)
    public void signOut() {
    }
}