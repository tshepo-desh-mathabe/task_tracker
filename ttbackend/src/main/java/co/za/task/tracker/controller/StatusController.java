package co.za.task.tracker.controller;

import co.za.task.tracker.service.StatusService;
import co.za.task.tracker.util.constants.ResourcePath;
import co.za.task.tracker.util.constants.ResourceRoleChecker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@AllArgsConstructor
@RestController
@RequestMapping(ResourcePath.STATUS_ENTRY_POINT)
public class StatusController {
    private final StatusService stat;

    @PreAuthorize(ResourceRoleChecker.ROLE_ADMIN + " or " + ResourceRoleChecker.ROLE_MODERATE)
    @GetMapping(ResourcePath.GET_ALL)
    public Object getAllPriorities() {
        return stat.getAll();
    }
}