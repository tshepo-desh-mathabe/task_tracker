package co.za.task.tracker.service.helper;

import co.za.task.tracker.entity.Status;
import co.za.task.tracker.entity.dto.StatusDto;
import co.za.task.tracker.repository.IStatusRepository;
import co.za.task.tracker.util.helper.mapper.IModelMapper;
import co.za.task.tracker.util.helper.service.util.IFindAll;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Component
public class StatusServiceImpl implements IFindAll<Set<StatusDto>> {
    private final IStatusRepository repository;
    private final IModelMapper<Status, StatusDto> mapper;

    @Override
    public Set<StatusDto> readAll() {
        var statuses = repository.findAll();
        var data = StreamSupport.stream(statuses.spliterator(), false)
                .collect(Collectors.toSet());
        return mapper.toDto(data);
    }
}
