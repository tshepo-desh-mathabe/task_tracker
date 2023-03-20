package co.za.task.tracker.util.service;

import co.za.task.tracker.entity.Status;
import co.za.task.tracker.entity.dto.StatusDto;
import co.za.task.tracker.repository.IStatusRepository;
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
public abstract class AStatusService {
    private final IStatusRepository repository;
    private final IModelMapper<Status, StatusDto> mapper;

    public ResponseEntity<ApiResponse> readAll() {
        var statuses = repository.findAll();
        var data = StreamSupport.stream(statuses.spliterator(), false)
                .collect(Collectors.toSet());
        return ResponseApiWrapper.okRequest(mapper.toDto(data));
    }
}
