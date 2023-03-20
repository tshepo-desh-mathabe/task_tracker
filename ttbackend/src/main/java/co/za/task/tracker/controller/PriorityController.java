package co.za.task.tracker.controller;

import co.za.task.tracker.service.PriorityService;
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
@RequestMapping(ResourcePath.PRIORITY_ENTRY_POINT)
public class PriorityController {
    private final PriorityService priorityService;

    @PreAuthorize(value = ResourceRoleChecker.ROLE_ADMIN)
    @GetMapping(ResourcePath.GET_ALL)
    public Object getAllStatuses() {
        return priorityService.getAll();
    }
}