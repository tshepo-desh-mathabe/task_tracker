package co.za.task.tracker.controller;

import co.za.task.tracker.service.FlagOptionsHelperService;
import co.za.task.tracker.util.constants.ResourcePath;
import co.za.task.tracker.util.constants.ResourceRoleChecker;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(ResourcePath.FLAG_OPTION_ENTRY_POINT)
public class FlagOptionController {
    private final FlagOptionsHelperService service;

    @PreAuthorize(ResourceRoleChecker.ROLE_ADMIN + " or " + ResourceRoleChecker.ROLE_MODERATE)
    @GetMapping(ResourcePath.GET_ALL)
    public ResponseEntity<?> getAllData() {
        return service.getAllFlagOptions();
    }
}