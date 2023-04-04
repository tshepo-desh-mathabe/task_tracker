package co.za.task.tracker.controller;

import co.za.task.tracker.service.UserService;
import co.za.task.tracker.util.constants.ResourcePath;
import co.za.task.tracker.util.constants.ResourceRoleChecker;
import co.za.task.tracker.util.payload.AuthenticationRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(ResourcePath.USER_ENTRY_POINT)
public class UserController {
    private final UserService userService;

    @PostMapping(ResourcePath.USER_LOGIN)
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest request) {
        return userService.loginUser(request);
    }

    @PreAuthorize(ResourceRoleChecker.ROLE_ADMIN + " or " + ResourceRoleChecker.ROLE_MODERATE)
    @GetMapping(ResourcePath.GET_ALL)
    public ResponseEntity<?> getSearchedUser(@RequestBody String value) {
        return userService.searchForUsers(value);
    }

//    @PostMapping(ResourcePath.USER_LOGOUT)
//    public void signOut(HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//    }
}