package co.za.task.tracker.service;

import co.za.task.tracker.util.service.APriorityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class PriorityService {
    private final APriorityService priorityService;

    @Transactional
    public ResponseEntity<?> getAll() {
        return priorityService.readAll();
    }
}
