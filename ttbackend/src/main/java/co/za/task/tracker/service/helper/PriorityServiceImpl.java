package co.za.task.tracker.service.helper;

import co.za.task.tracker.entity.Priority;
import co.za.task.tracker.entity.dto.PriorityDto;
import co.za.task.tracker.repository.IPriorityRepository;
import co.za.task.tracker.util.helper.mapper.IModelMapper;
import co.za.task.tracker.util.helper.service.util.IFindAll;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Component
public class PriorityServiceImpl implements IFindAll<Set<PriorityDto>> {
    private final IPriorityRepository repository;
    private final IModelMapper<Priority, PriorityDto> mapper;

    @Override
    public Set<PriorityDto> readAll() {
        var priorities = repository.findAll();
        var data = StreamSupport.stream(priorities.spliterator(), false)
                .collect(Collectors.toSet());
        return mapper.toDto(data);
    }
}
