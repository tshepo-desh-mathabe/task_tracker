package co.za.task.tracker.controller;

import co.za.task.tracker.entity.dto.UserDto;
import co.za.task.tracker.service.UserService;
import co.za.task.tracker.util.constants.ServicePath;
import co.za.task.tracker.util.payload.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ServicePath.USER_ENTRY_POINT)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(ServicePath.USER_LOGIN)
    public Object authenticateUser(@RequestBody AuthenticationRequest request) {
        return userService.loginUser(request).getBody();
    }

    @PostMapping(ServicePath.REGISTER)
    public Object register(@RequestBody UserDto request) {
        return userService.registerUser(request).getBody();
    }

    @PostMapping(ServicePath.USER_LOGOUT)
    public void signOut() {
    }
}