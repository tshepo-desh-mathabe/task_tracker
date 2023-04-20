package co.za.task.tracker.controller;

import co.za.task.tracker.entity.dto.TaskDto;
import co.za.task.tracker.util.constants.ResourcePath;
import co.za.task.tracker.util.constants.ResourceRoleChecker;
import co.za.task.tracker.util.helper.service.util.IService;
import co.za.task.tracker.util.payload.PagedGetDataPayload;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(ResourcePath.TASK_ENTRY_POINT)
public class TaskController {
    private final IService<TaskDto> service;


    @PreAuthorize(ResourceRoleChecker.ROLE_ADMIN + " or " + ResourceRoleChecker.ROLE_MODERATE)
    @PostMapping(ResourcePath.SAVE)
    public ResponseEntity<?> saveUser(@RequestBody TaskDto payload) {
        return service.save(payload);
    }

    @GetMapping(ResourcePath.GET_BY_ID)
    public ResponseEntity<?> getOne(@PathVariable("id") Long taskId) {
        return service.findWithId(taskId);
    }

    @GetMapping(ResourcePath.GET_ALL)
    public ResponseEntity<?> getOne(@RequestBody PagedGetDataPayload payload) {
        return service.getWithPagination(payload);
    }

//    @PreAuthorize(ResourceRoleChecker.ROLE_ADMIN + " or " + ResourceRoleChecker.ROLE_MODERATE)
//    @GetMapping(ResourcePath.DELETE_BY_ID)
//    public ResponseEntity<?> delete(@RequestParam String data) {
//        var id = 0l; // decode payload and get data
//        return service.delete(id);
//    }

}