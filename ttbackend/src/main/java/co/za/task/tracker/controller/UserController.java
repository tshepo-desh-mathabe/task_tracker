package co.za.task.tracker.controller;

import co.za.task.tracker.entity.dto.UserDto;
import co.za.task.tracker.payload.LoggedInUserSummary;
import co.za.task.tracker.service.UserService;
import co.za.task.tracker.util.constants.ServicePath;
import co.za.task.tracker.util.security.CurrentUser;
import co.za.task.tracker.util.security.UserPrincipal;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ServicePath.USER_ENTRY_POINT)
public class UserController {

    @Autowired
    private UserService userService;

    //    @PreAuthorize("hasRole('USER')")
    @GetMapping(ServicePath.GET_USER_LOGGED_IN)
    public LoggedInUserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return new LoggedInUserSummary(
                currentUser.name(), currentUser.surname(), currentUser.username(), currentUser.authorities()
        );
    }

    @PostMapping(ServicePath.USER_LOGIN)
    public Object authenticateUser(@Valid @RequestBody UserDto user) {
        return this.userService.loginUser(user).getBody();
    }

    @PostMapping(ServicePath.USER_LOGOUT)
    public void signOut(@CurrentUser UserPrincipal currentUser) {
        currentUser = null;
    }
}