package co.za.task.tracker.util.service;

import co.za.task.tracker.entity.Priority;
import co.za.task.tracker.entity.dto.PriorityDto;
import co.za.task.tracker.repository.IPriorityRepository;
import co.za.task.tracker.util.helper.IModelMapper;
import co.za.task.tracker.util.response.ApiResponse;
import co.za.task.tracker.util.response.ResponseApiWrapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@AllArgsConstructor
@Component
public abstract class APriorityService {
    private final IPriorityRepository repository;
    private final IModelMapper<Priority, PriorityDto> mapper;

    public ResponseEntity<ApiResponse> readAll() {
        var priorities = repository.findAll();
        var data = StreamSupport.stream(priorities.spliterator(), false)
                .collect(Collectors.toSet());
        return ResponseApiWrapper.okRequest(mapper.toDto(data));
    }
}
